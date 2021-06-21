package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.core.runtime.IProgressMonitor;

import cz.startnet.utils.pgdiff.loader.ParserListenerMode;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_owner_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_table_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Owner_toContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Rule_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_createContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.SqlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.StatementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_actionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.User_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.exception.UnresolvedReferenceException;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.AlterOwner;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.GrantPrivilege;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.IRelation;
import cz.startnet.utils.pgdiff.schema.IStatement;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementOverride;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

public class SQLOverridesListener extends CustomParserListener
implements SqlContextProcessor {

    private final Map<PgStatement, StatementOverride> overrides;

    public SQLOverridesListener(PgDatabase db, String filename, ParserListenerMode mode,
            List<Object> errors, IProgressMonitor mon,
            Map<PgStatement, StatementOverride> overrides) {
        super(db, filename, mode, errors, mon);
        this.overrides = overrides;
    }

    @Override
    public void process(SqlContext rootCtx, CommonTokenStream stream) {
        for (StatementContext s : rootCtx.statement()) {
            Schema_statementContext st = s.schema_statement();
            if (st != null) {
                Schema_createContext create = st.schema_create();
                Schema_alterContext alter;
                if (create != null) {
                    create(create);
                } else if ((alter = st.schema_alter()) != null) {
                    alter(alter);
                }
            }
        }
    }

    private void create(Schema_createContext ctx) {
        Rule_commonContext rule = ctx.rule_common();
        Create_schema_statementContext schema;
        if (rule != null) {
            safeParseStatement(new GrantPrivilege(rule, db, overrides), ctx);
        } else if ((schema = ctx.create_schema_statement()) != null) {
            safeParseStatement(() -> createSchema(schema), ctx);
        }
    }

    private void alter(Schema_alterContext ctx) {
        Alter_owner_statementContext owner = ctx.alter_owner_statement();
        Alter_table_statementContext ats;
        if (owner != null) {
            safeParseStatement(new AlterOwner(owner, db, overrides), ctx);
        } else if ((ats  = ctx.alter_table_statement()) != null) {
            safeParseStatement(() -> alterTable(ats), ctx);
        }
    }

    private void createSchema(Create_schema_statementContext ctx) {
        User_nameContext user = ctx.user_name();
        IdentifierContext owner = user == null ? null : user.identifier();
        if (db.getArguments().isIgnorePrivileges() || owner == null) {
            return;
        }

        PgStatement st = getSafe(PgDatabase::getSchema, db, ctx.name);
        if (st.getName().equals(ApgdiffConsts.PUBLIC) && "postgres".equals(owner.getText())) {
            return;
        }

        overrides.computeIfAbsent(st, k -> new StatementOverride()).setOwner(owner.getText());
    }

    private void alterTable(Alter_table_statementContext ctx) {
        List<IdentifierContext> ids = ctx.name.identifier();
        IdentifierContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        AbstractSchema schema = schemaCtx == null ? db.getDefaultSchema() :
            getSafe(PgDatabase::getSchema, db, schemaCtx);

        IdentifierContext nameCtx = QNameParser.getFirstNameCtx(ids);

        for (Table_actionContext tablAction : ctx.table_action()) {
            Owner_toContext owner = tablAction.owner_to();
            if (owner != null && owner.name != null) {
                IRelation st = getSafe(AbstractSchema::getRelation, schema, nameCtx);
                overrides.computeIfAbsent((PgStatement) st,
                        k -> new StatementOverride()).setOwner(owner.name.getText());
            }
        }
    }

    private <T extends IStatement, R extends IStatement> R getSafe(
            BiFunction<T, String, R> getter, T container, IdentifierContext ctx) {
        String name = ctx.getText();
        R statement = getter.apply(container, name);
        if (statement == null) {
            throw new UnresolvedReferenceException("Cannot find object in database: "
                    + name, ctx.getStart());
        }

        return statement;
    }
}