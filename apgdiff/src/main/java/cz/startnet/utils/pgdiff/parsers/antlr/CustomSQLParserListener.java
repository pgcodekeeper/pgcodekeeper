package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_type_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comment_on_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_domain_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_extension_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_index_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_rewrite_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_sequence_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_trigger_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_type_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_view_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statement_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.MonitorCancelledRuntimeException;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterDomain;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterFunction;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterSchema;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterSequence;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterType;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterView;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CommentOn;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateDomain;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateExtension;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateFunction;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateIndex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRewrite;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateRule;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateSchema;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateSequence;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTable;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateTrigger;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateType;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.CreateView;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import ru.taximaxim.codekeeper.apgdiff.Log;

public class CustomSQLParserListener extends SQLParserBaseListener {

    private final PgDatabase db;
    private final String parsedObjectName;
    private final List<AntlrError> errors;
    private final IProgressMonitor monitor;
    private String tablespace;
    private String oids;

    public CustomSQLParserListener(PgDatabase database, String parsedObjectName,
            List<AntlrError> errors, IProgressMonitor monitor) {
        this.db = database;
        this.errors = errors;
        this.parsedObjectName = parsedObjectName;
        this.monitor = monitor;
    }

    private PgStatement safeParseStatement(ParserAbstract p) {
        try {
            PgDiffUtils.checkCancelled(monitor);
            return p.getObject();
        } catch (UnresolvedReferenceException ex) {
            errors.add(handleUnresolvedReference(ex));
            return null;
        } catch (InterruptedException ex) {
            throw new MonitorCancelledRuntimeException();
        }/* catch (Exception ex) {
            Log.log(Log.LOG_WARNING,
                    "Exception while analyzing parser tree for: " + parsedObjectName, ex);
            return null;
        }*/
    }

    @Override
    public void exitCreate_table_statement(Create_table_statementContext ctx) {
        safeParseStatement(new CreateTable(ctx, db, tablespace, oids));
    }

    @Override
    public void exitCreate_index_statement(Create_index_statementContext ctx) {
        safeParseStatement(new CreateIndex(ctx, db, tablespace));
    }

    @Override
    public void exitCreate_extension_statement(Create_extension_statementContext ctx) {
        safeParseStatement(new CreateExtension(ctx, db));
    }

    @Override
    public void exitCreate_trigger_statement(Create_trigger_statementContext ctx) {
        safeParseStatement(new CreateTrigger(ctx, db));
    }

    @Override
    public void exitCreate_rewrite_statement(Create_rewrite_statementContext ctx) {
        safeParseStatement(new CreateRewrite(ctx, db));
    }

    @Override
    public void exitCreate_function_statement(Create_function_statementContext ctx) {
        safeParseStatement(new CreateFunction(ctx, db));
    }

    @Override
    public void exitCreate_sequence_statement(Create_sequence_statementContext ctx) {
        safeParseStatement(new CreateSequence(ctx, db));
    }

    @Override
    public void exitCreate_schema_statement(Create_schema_statementContext ctx) {
        safeParseStatement(new CreateSchema(ctx, db));
    }

    @Override
    public void exitCreate_view_statement(Create_view_statementContext ctx) {
        safeParseStatement(new CreateView(ctx, db));
    }

    @Override
    public void exitCreate_type_statement(Create_type_statementContext ctx) {
        safeParseStatement(new CreateType(ctx, db));
    }

    @Override
    public void exitCreate_domain_statement(Create_domain_statementContext ctx) {
        safeParseStatement(new CreateDomain(ctx, db));
    }

    @Override
    public void exitComment_on_statement(Comment_on_statementContext ctx) {
        safeParseStatement(new CommentOn(ctx, db));
    }

    @Override
    public void exitSet_statement(Set_statementContext ctx) {
        if (ctx.config_param_val.isEmpty()) {
            return;
        }
        String confParam = ctx.config_param.getText();
        // TODO set param values can be identifiers, quoted identifiers, string
        // or other literals: improve handling
        Set_statement_valueContext confValueCtx = ctx.config_param_val.get(0);
        String confValue = confValueCtx.getText();

        switch (confParam.toLowerCase()) {
        case "search_path":
            // allow the exception to terminate entire walker here
            // so that objects aren't created on the wrong search_path
            db.setDefaultSchema(ParserAbstract.getSafe(
                    db::getSchema, confValue, confValueCtx.getStart()).getName());
            break;
        case "default_with_oids":
            oids = confValue;
            if ("false".equals(oids)) {
                oids = null;
            }
            break;
        case "default_tablespace":
            tablespace = confValue;
            if (tablespace.isEmpty()
                    // special case for pg_dump's unset default_tablespace
                    // remove after good unquoting mechanism would be introduced
                    || "''".equals(tablespace)) {
                tablespace = null;
            }
            break;
        default:
            break;
        }

    }

    @Override
    public void exitRule_common(Rule_commonContext ctx) {
        safeParseStatement(new CreateRule(ctx, db));
    }

    @Override
    public void exitAlter_function_statement(Alter_function_statementContext ctx) {
        safeParseStatement(new AlterFunction(ctx, db));
    }

    @Override
    public void exitAlter_schema_statement(Alter_schema_statementContext ctx) {
        safeParseStatement(new AlterSchema(ctx, db));
    }

    @Override
    public void exitAlter_table_statement(Alter_table_statementContext ctx) {
        safeParseStatement(new AlterTable(ctx, db));
    }

    @Override
    public void exitAlter_sequence_statement(Alter_sequence_statementContext ctx) {
        safeParseStatement(new AlterSequence(ctx, db));
    }

    @Override
    public void exitAlter_view_statement(Alter_view_statementContext ctx) {
        safeParseStatement(new AlterView(ctx, db));
    }

    @Override
    public void exitAlter_type_statement(Alter_type_statementContext ctx) {
        safeParseStatement(new AlterType(ctx, db));
    }

    @Override
    public void exitAlter_domain_statement(Alter_domain_statementContext ctx) {
        safeParseStatement(new AlterDomain(ctx, db));
    }

    static AntlrError handleUnresolvedReference(UnresolvedReferenceException ex) {
        Token t = ex.getErrorToken();
        Log.log(Log.LOG_WARNING,"Cannot find object in database: " + t.getText(), ex);
        return new AntlrError(t, t.getLine(), t.getCharPositionInLine(),
                "Cannot find object in database: " + t.getText());
    }
}