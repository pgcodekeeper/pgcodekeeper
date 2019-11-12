package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.Arrays;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_operator_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_schema_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alter_type_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Operator_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_alterContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.StatementActions;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class AlterOther extends ParserAbstract {

    private final Schema_alterContext ctx;

    public AlterOther(Schema_alterContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public void parseObject() {
        if (ctx.alter_function_statement() != null) {
            alterFunction(ctx.alter_function_statement());
        } else if (ctx.alter_schema_statement() != null) {
            alterSchema(ctx.alter_schema_statement());
        } else if (ctx.alter_type_statement() != null) {
            alterType(ctx.alter_type_statement());
        } else if (ctx.alter_operator_statement() != null) {
            alterOperator(ctx.alter_operator_statement());
        }
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

        addObjReference(ctx.function_parameters().schema_qualified_name().identifier(),
                type, StatementActions.ALTER);
    }

    public void alterSchema(Alter_schema_statementContext ctx) {
        addObjReference(Arrays.asList(ctx.identifier()), DbObjType.SCHEMA, StatementActions.ALTER);
    }

    public void alterType(Alter_type_statementContext ctx) {
        addObjReference(ctx.name.identifier(), DbObjType.TYPE, StatementActions.ALTER);
    }

    private void alterOperator(Alter_operator_statementContext ctx) {
        Operator_nameContext nameCtx = ctx.target_operator().operator_name();
        addObjReference(Arrays.asList(nameCtx.schema_name, nameCtx.operator),
                DbObjType.OPERATOR, StatementActions.ALTER);
    }
}