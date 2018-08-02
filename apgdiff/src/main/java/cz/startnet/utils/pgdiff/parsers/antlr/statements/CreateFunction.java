package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_column_name_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
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
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        PgFunction function = new PgFunction(QNameParser.getFirstName(ids), getFullCtxText(ctx.getParent()));
        fillArguments(function);
        function.setBody(db.getArguments(), getFullCtxText(ctx.funct_body));

        if (ctx.ret_table != null) {
            function.setReturns(getFullCtxText(ctx.ret_table));
            for (Function_column_name_typeContext ret_col : ctx.ret_table.function_column_name_type()) {
                addTypeAsDepcy(ret_col.column_type, function, getDefSchemaName());
                function.addReturnsColumn(ret_col.column_name.getText(), getFullCtxText(ret_col.column_type));
            }
        } else if(ctx.rettype_data != null) {
            function.setReturns(getFullCtxText(ctx.rettype_data));
            addTypeAsDepcy(ctx.rettype_data, function, getDefSchemaName());
        }
        schema.addFunction(function);
        return function;
    }

    private void fillArguments(PgFunction function) {
        for (Function_argumentsContext argument : ctx.function_parameters()
                .function_args().function_arguments()) {
            Argument arg = new Argument(argument.arg_mode != null ? argument.arg_mode.getText() : null,
                    argument.argname != null ? argument.argname.getText() : null,
                            getFullCtxText(argument.argtype_data));
            addTypeAsDepcy(argument.data_type(), function, getDefSchemaName());

            if (argument.function_def_value() != null) {
                arg.setDefaultExpression(getFullCtxText(argument.function_def_value().def_value));
                db.addContextForAnalyze(function, argument.function_def_value().def_value);
            }

            function.addArgument(arg);
        }
    }
}