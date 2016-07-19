package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_column_name_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateFunction extends ParserAbstract {
    private final Create_function_statementContext ctx;
    public CreateFunction(Create_function_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.function_parameters().name.identifier();
        String name = QNameParser.getFirstName(ids);
        String schemaName = QNameParser.getSchemaName(ids, getDefSchemaName());
        PgFunction function = new PgFunction(name, getFullCtxText(ctx.getParent()));
        fillArguments(ctx.function_parameters().function_args(), function, getDefSchemaName());
        function.setBody(db.getArguments() ,getFullCtxText(ctx.funct_body));

        if (ctx.ret_table != null) {
            function.setReturns(getFullCtxText(ctx.ret_table));
            for (Function_column_name_typeContext ret_col : ctx.ret_table.function_column_name_type()) {
                addTypeAsDepcy(ret_col.column_type, function, getDefSchemaName());
            }
        } else if(ctx.rettype_data != null) {
            function.setReturns(getFullCtxText(ctx.rettype_data));
            addTypeAsDepcy(ctx.rettype_data, function, getDefSchemaName());
        }
        if (db.getSchema(schemaName) == null) {
            logSkipedObject(schemaName, "FUNCTION", name);
            return null;
        }
        db.getSchema(schemaName).addFunction(function);

        return function;
    }
}
