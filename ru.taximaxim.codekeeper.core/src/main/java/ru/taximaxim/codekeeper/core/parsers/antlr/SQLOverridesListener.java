package ru.taximaxim.codekeeper.core.parsers.antlr;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.loader.ParserListenerMode;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_owner_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Alter_table_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Create_schema_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Owner_toContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Rule_commonContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Schema_alterContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Schema_createContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Schema_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.SqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.StatementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Table_actionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.User_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.exception.UnresolvedReferenceException;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.AlterOwner;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.GrantPrivilege;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.IStatement;
import ru.taximaxim.codekeeper.core.schema.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementOverride;

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
        if (st.getName().equals(Consts.PUBLIC) && "postgres".equals(owner.getText())) {
            return;
        }

        overrides.computeIfAbsent(st, k -> new StatementOverride()).setOwner(owner.getText());
    }

    private void alterTable(Alter_table_statementContext ctx) {
        List<ParserRuleContext> ids = ParserAbstract.getIdentifiers(ctx.name);
        ParserRuleContext schemaCtx = QNameParser.getSchemaNameCtx(ids);
        AbstractSchema schema = schemaCtx == null ? db.getDefaultSchema() :
            getSafe(PgDatabase::getSchema, db, schemaCtx);

        ParserRuleContext nameCtx = QNameParser.getFirstNameCtx(ids);

        for (Table_actionContext tablAction : ctx.table_action()) {
            Owner_toContext owner = tablAction.owner_to();
            IdentifierContext name;
            if (owner != null && (name = owner.user_name().identifier()) != null) {
                IRelation st = getSafe(AbstractSchema::getRelation, schema, nameCtx);
                overrides.computeIfAbsent((PgStatement) st,
                        k -> new StatementOverride()).setOwner(name.getText());
            }
        }
    }

    private <T extends IStatement, R extends IStatement> R getSafe(
            BiFunction<T, String, R> getter, T container, ParserRuleContext ctx) {
        String name = ctx.getText();
        R statement = getter.apply(container, name);
        if (statement == null) {
            throw new UnresolvedReferenceException("Cannot find object in database: "
                    + name, ctx.getStart());
        }

        return statement;
    }
}
