package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.core.runtime.SubMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.jdbc.ExtensionsReader;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcLoaderBase;
import cz.startnet.utils.pgdiff.loader.jdbc.JdbcReaderFactory;
import cz.startnet.utils.pgdiff.loader.jdbc.SchemasContainer;
import cz.startnet.utils.pgdiff.loader.jdbc.SchemasReader;
import cz.startnet.utils.pgdiff.loader.jdbc.SequencesReader;
import cz.startnet.utils.pgdiff.loader.jdbc.TypesReader;
import cz.startnet.utils.pgdiff.loader.jdbc.ViewsReader;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Constr_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Index_restContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rewrite_commandContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.When_triggerContext;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.Select;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExpr;
import cz.startnet.utils.pgdiff.parsers.antlr.expr.ValueExprWithNmspc;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateIndex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRewrite;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgColumn;
import cz.startnet.utils.pgdiff.schema.PgConstraint;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgDomain;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgIndex;
import cz.startnet.utils.pgdiff.schema.PgRule;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTrigger;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

public class JdbcLoader extends JdbcLoaderBase {

    private boolean useServerHelpers = true;

    public JdbcLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments) {
        this(connector, pgDiffArguments, SubMonitor.convert(null));
    }

    public JdbcLoader(JdbcConnector connector, PgDiffArguments pgDiffArguments,
            SubMonitor monitor) {
        super(connector, monitor, pgDiffArguments);
    }

    public void setUseServerHelpers(boolean useServerHelpers) {
        this.useServerHelpers = useServerHelpers;
    }

    public PgDatabase getDbFromJdbc() throws IOException, InterruptedException, LicenseException {
        PgDatabase d = new PgDatabase(false);
        d.setArguments(args);

        Log.log(Log.LOG_INFO, "Reading db using JDBC.");
        setCurrentOperation("connection setup");
        try (Connection connection = connector.getConnection();
                Statement statement = connection.createStatement()) {
            this.connection = connection;
            this.statement = statement;
            connection.setAutoCommit(false);
            statement.execute("SET TRANSACTION ISOLATION LEVEL REPEATABLE READ, READ ONLY");
            statement.execute("SET timezone = " + PgDiffUtils.quoteString(connector.getTimezone()));

            queryCheckVersion();
            queryTypesForCache();
            queryRoles();
            setupMonitorWork();

            schemas = new SchemasReader(this, d).read();
            try (SchemasContainer schemas = this.schemas) {
                availableHelpersBits = useServerHelpers ? JdbcReaderFactory.getAvailableHelpersBits(this) : 0;
                for (JdbcReaderFactory f : JdbcReaderFactory.FACTORIES) {
                    f.getReader(this).read();
                }
                new ExtensionsReader(this, d).read();

                if(!SupportedVersion.VERSION_10.checkVersion(version)) {
                    SequencesReader.querySequencesData(d, this);
                }
            }
            connection.commit();
            finishAntlr();
            Log.log(Log.LOG_INFO, "Database object has been successfully queried from JDBC");

            for (PgSchema s : d.getSchemas()) {
                for (PgView v : s.getViews()) {
                    viewAnalyze(s, v);
                }
                for (PgTable t : s.getTables()) {
                    tableAnalyze(s, t);
                }
                for (PgFunction f : s.getFunctions()) {
                    functionAnalyze(s, f);
                }
                for (PgDomain dm : s.getDomains()) {
                    domainAnalyze(s, dm);
                }
            }
        } catch (InterruptedException ex) {
            throw ex;
        } catch (Exception e) {
            // connection is closed at this point, trust Postgres to rollback it; we're a read-only xact anyway
            throw new IOException(MessageFormat.format(Messages.Connection_DatabaseJdbcAccessError,
                    e.getLocalizedMessage(), getCurrentLocation()), e);
        }
        args.getLicense().verifyDb(d);
        return d;
    }

    private void viewAnalyze(PgSchema s, PgView v) {
        String schemaName = s.getName();
        String viewKey = schemaName + "." + v.getStatementType() + "." + v.getName();
        String viewKeyColDef = viewKey + ViewsReader.COLUMN_DEFAULT;

        if (objectsForAnalyze.containsKey(viewKey)) {
            Select sel = new Select(schemaName);
            sel.analyze((ParserRuleContext)objectsForAnalyze.get(viewKey));
            v.addAllDeps(sel.getDepcies());
        }

        if (objectsForAnalyze.containsKey(viewKeyColDef)) {
            List<Vex> vexList = (List<Vex>)objectsForAnalyze.get(viewKeyColDef);

            ValueExpr vex = new ValueExpr(schemaName);
            for (Vex vx : vexList) {
                vex.analyze(vx);
            }
            v.addAllDeps(vex.getDepcies());
        }
    }

    private void tableAnalyze(PgSchema s, PgTable t) {
        List<PgColumn> columnList;
        if(t.getOfType() == null) {
            columnList = t.getColumns();
        } else {
            columnList = t.getColumnsOfType();
        }

        String schemaName = s.getName();
        String frontKey = schemaName + "." + t.getName() + ".";

        String tableColKey;
        for (PgColumn c : columnList) {
            tableColKey = frontKey + c.getType() + "." + c.getName();
            if (objectsForAnalyze.containsKey(tableColKey)) {
                ValueExpr vex = new ValueExpr(schemaName);
                vex.analyze((Vex)objectsForAnalyze.get(tableColKey));
                c.addAllDeps(vex.getDepcies());
            }
        }

        for (PgRule r : t.getRules()) {
            String ruleKey = frontKey + r.getStatementType() + "." + r.getName();
            if (objectsForAnalyze.containsKey(ruleKey)) {
                Create_rewrite_statementContext ctx = (Create_rewrite_statementContext)objectsForAnalyze.get(ruleKey);

                if (ctx.WHERE() != null){
                    CreateRewrite.analyzeRewriteCreateStmtCtx(ctx, r, schemaName);
                }

                for (Rewrite_commandContext cmd : ctx.commands) {
                    CreateRewrite.analyzeRewriteCommandCtx(cmd, r, args, schemaName);
                }
            }
        }

        for (PgTrigger tr : t.getTriggers()) {
            String triggerKey = frontKey + tr.getStatementType() + "." + tr.getName();
            if (objectsForAnalyze.containsKey(triggerKey)) {
                Object ctx = objectsForAnalyze.get(triggerKey);
                When_triggerContext whenCtx;
                if (ctx != null) {
                    whenCtx = (When_triggerContext)ctx;
                    ValueExprWithNmspc vex = new ValueExprWithNmspc(schemaName);
                    vex.addReference("new", null);
                    vex.addReference("old", null);
                    vex.analyze(new Vex(whenCtx.vex()));
                    tr.addAllDeps(vex.getDepcies());
                    tr.setWhen(ParserAbstract.getFullCtxText(whenCtx.when_expr));
                }
            }
        }

        for (PgIndex ind : t.getIndexes()) {
            String indexKey = frontKey + ind.getStatementType() + "." + ind.getName();
            if (objectsForAnalyze.containsKey(indexKey)) {
                Index_restContext ctx = (Index_restContext)objectsForAnalyze.get(indexKey);
                if (ctx.index_where() != null) {
                    CreateIndex.analyzeIndexWhereCtx(ctx, schemaName, ind);
                }
            }
        }

        for (PgConstraint con : t.getConstraints()) {
            String conKey = frontKey + con.getStatementType() + "." + con.getName();
            if (objectsForAnalyze.containsKey(conKey)) {
                ParserAbstract.parseConstraintExpr((Constr_bodyContext)objectsForAnalyze.get(conKey), schemaName, con);
            }
        }
    }

    private void functionAnalyze(PgSchema s, PgFunction f) {
        String schemaName = s.getName();
        String functionKey = schemaName + "." + f.getStatementType() + "." + f.getName();

        if (objectsForAnalyze.containsKey(functionKey)) {
            List<Function_argumentsContext> functionArguments = ((Function_argsContext)objectsForAnalyze.get(functionKey))
                    .function_arguments();

            for (Function_argumentsContext argument : functionArguments) {
                if (argument.function_def_value() != null) {
                    VexContext defExpression = argument.function_def_value().def_value;
                    ValueExpr vex = new ValueExpr(s.getName());
                    vex.analyze(new Vex(defExpression));
                    f.addAllDeps(vex.getDepcies());
                }
            }
        }
    }

    private void domainAnalyze(PgSchema s, PgDomain dm) {
        String schemaName = s.getName();
        String domainKey = schemaName + "." + dm.getStatementType() + "." + dm.getName();
        String domainKeyConstr = domainKey + TypesReader.DOMAIN_CONSTRAINT;

        if (objectsForAnalyze.containsKey(domainKey)) {
            ValueExpr vex = new ValueExpr(schemaName);
            vex.analyze((Vex)objectsForAnalyze.get(domainKey));
            dm.addAllDeps(vex.getDepcies());
        }

        if (objectsForAnalyze.containsKey(domainKeyConstr)) {
            List<Map<String, Constr_bodyContext>> constrBodyCtxList = (List<Map<String, Constr_bodyContext>>)objectsForAnalyze
                    .get(domainKeyConstr);
            for (Map<String, Constr_bodyContext> pair : constrBodyCtxList) {
                Entry<String, Constr_bodyContext> entry = pair.entrySet().iterator().next();
                ParserAbstract.parseConstraintExpr(entry.getValue(), schemaName, dm.getConstraint(entry.getKey()));
            }
        }
    }

    public boolean hasAllHelpers() throws IOException {
        // just makes new connection for now
        // smarter solution would be to make the class AutoCloseable
        try (Connection c = connector.getConnection()) {
            return JdbcReaderFactory.getAvailableHelperBits(c) == JdbcReaderFactory.getAllHelperBits();
        } catch (SQLException ex) {
            throw new IOException(ex.getLocalizedMessage(), ex);
        }
    }
}
