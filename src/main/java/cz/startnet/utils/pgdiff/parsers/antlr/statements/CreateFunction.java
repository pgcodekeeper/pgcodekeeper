package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_bodyContext;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateFunction extends ParserAbstract {
    private Create_function_statementContext ctx;
    public CreateFunction(Create_function_statementContext ctx, PgDatabase db, Path filePath) {
        super(db, filePath);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        String name = getName(ctx.function_parameters().name);
        PgFunction function = new PgFunction(name, getFullCtxText(ctx.getParent()), "");
        for (Function_argumentsContext argument : ctx.function_parameters().function_arguments()) {
            PgFunction.Argument arg = new PgFunction.Argument();
            if (argument.argname!=null) {
                arg.setName(argument.argname.getText());
            }
            if (argument.argtype_data!= null) {
                arg.setDataType(argument.argtype_data.getText());
            } else if (argument.argtype_expres != null) {
                arg.setDataType(argument.argtype_expres.getText());
            }
            if (argument.function_def_value() != null) {
                arg.setDefaultExpression(argument.function_def_value().def_value.getText());
            }
            if (argument.arg_mode!=null) {
                arg.setMode(argument.arg_mode.getText());
            }
            function.addArgument(arg);
        }
        for (Function_bodyContext body : ctx.function_body()) {
            function.setBody(body.getText());
        }
        
        if (ctx.function_ret_table()!= null) {
            function.setReturns(ctx.function_ret_table().getText());
        } else if(ctx.rettype != null) {
            function.setReturns(ctx.rettype.getText());
        } else if(ctx.rettype_data != null) {
            function.setReturns(ctx.rettype_data.getText());
        }
        fillObjLocation(name, ctx.function_parameters().name.getStart().getStartIndex());
        return function;
    }

}
