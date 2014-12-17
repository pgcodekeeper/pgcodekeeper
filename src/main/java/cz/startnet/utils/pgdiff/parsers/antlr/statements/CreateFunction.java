package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.nio.file.Path;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
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
        String schemaName =getSchemaName(ctx.function_parameters().name);
        if (schemaName==null) {
            schemaName = getDefSchemaName();
        }
        PgFunction function = new PgFunction(name, getFullCtxText(ctx.getParent()), "");
        fillArguments(ctx.function_parameters().function_args(), function);
        function.setBody(getFullCtxText(ctx.funct_body).replace("\r", ""));
        
        if (ctx.function_ret_table()!= null) {
            function.setReturns(getFullCtxText(ctx.function_ret_table()));
        } else if(ctx.rettype != null) {
            function.setReturns(getFullCtxText(ctx.rettype));
        } else if(ctx.rettype_data != null) {
            function.setReturns(getFullCtxText(ctx.rettype_data));
        }
        db.getSchema(schemaName).addFunction(function);
        fillObjLocation(function, ctx.function_parameters().name.getStart().getStartIndex(),schemaName,
                db.getSchema(schemaName).getFunction(function.getSignature())!=null);
        return function;
    }
}
