package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_database_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_extension_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_operator_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_type_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterOther extends ParserAbstract {

    private final Schema_alterContext ctx;

    public AlterOther(Schema_alterContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        if (ctx.alter_database_statement() != null) {
            alterDatabase(ctx.alter_database_statement());
        } else if (ctx.alter_function_statement() != null) {
            alterFunction(ctx.alter_function_statement());
        } else if (ctx.alter_schema_statement() != null) {
            alterSchema(ctx.alter_schema_statement());
        } else if (ctx.alter_type_statement() != null) {
            alterType(ctx.alter_type_statement());
        } else if (ctx.alter_operator_statement() != null) {
            alterOperator(ctx.alter_operator_statement());
        } else if (ctx.alter_extension_statement() != null) {
            alterExtension(ctx.alter_extension_statement());
        }
    }

    private void alterDatabase(Alter_database_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.DATABASE, ACTION_ALTER);
    }

    public void alterFunction(Alter_function_statementContext ctx) {
        DbObjType type;
        if (ctx.FUNCTION() != null) {
            type = DbObjType.FUNCTION;
        } else if (ctx.PROCEDURE() != null) {
            type = DbObjType.PROCEDURE;
        } else {
            type = DbObjType.AGGREGATE;
        }

        addObjReference(getIdentifiers(ctx.function_parameters().schema_qualified_name()),
                type, ACTION_ALTER);
    }

    public void alterSchema(Alter_schema_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.SCHEMA, ACTION_ALTER);
    }

    public void alterType(Alter_type_statementContext ctx) {
        addObjReference(getIdentifiers(ctx.name), DbObjType.TYPE, ACTION_ALTER);
    }

    private void alterOperator(Alter_operator_statementContext ctx) {
        addObjReference(getIdentifiers(ctx.target_operator().name), DbObjType.OPERATOR, ACTION_ALTER);
    }

    private void alterExtension(Alter_extension_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.EXTENSION, ACTION_ALTER);
    }

    @Override
    protected String getStmtAction() {
        DbObjType type = getType();
        ParserRuleContext id = getId();
        return type != null && id != null ? getStrForStmtAction(ACTION_ALTER, type, id) : null;

    }

    private DbObjType getType() {
        if (ctx.alter_operator_statement() != null) {
            return DbObjType.OPERATOR;
        } else if (ctx.alter_function_statement() != null) {
            return DbObjType.FUNCTION;
        } else if (ctx.alter_schema_statement() != null) {
            return DbObjType.SCHEMA;
        } else if (ctx.alter_type_statement() != null) {
            return DbObjType.TYPE;
        } else if (ctx.alter_extension_statement() != null) {
            return DbObjType.EXTENSION;
        } else if (ctx.alter_database_statement() != null) {
            return DbObjType.DATABASE;
        }
        return null;
    }

    private ParserRuleContext getId() {
        Alter_operator_statementContext alterOperCtx = ctx.alter_operator_statement();
        if (alterOperCtx != null) {
            return alterOperCtx.target_operator().name;
        }
        if (ctx.alter_function_statement() != null) {
            return ctx.alter_function_statement().function_parameters().schema_qualified_name();
        }
        if (ctx.alter_schema_statement() != null) {
            return ctx.alter_schema_statement().identifier();
        }
        if (ctx.alter_type_statement() != null) {
            return ctx.alter_type_statement().name;
        }
        if (ctx.alter_extension_statement() != null) {
            return ctx.alter_extension_statement().identifier();
        }
        if (ctx.alter_database_statement() != null) {
            return ctx.alter_database_statement().identifier();
        }
        return null;
    }
}
