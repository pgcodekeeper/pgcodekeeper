package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Func_returnContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Procedure_paramContext;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.MsFunction;
import cz.startnet.utils.pgdiff.schema.MsFunction.FuncTypes;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CreateMsFunction extends BatchContextProcessor {

    private final Create_or_alter_functionContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    public CreateMsFunction(Batch_statementContext ctx, PgDatabase db,
            boolean ansiNulls, boolean quotedIdentifier, CommonTokenStream stream) {
        super(db, ctx, stream);
        this.ctx = ctx.batch_statement_body().create_or_alter_function();
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
    }

    @Override
    protected ParserRuleContext getDelimiterCtx() {
        return ctx.func_proc_name();
    }

    @Override
    public MsFunction getObject() {
        IdContext schemaCtx = ctx.func_proc_name().schema;
        AbstractSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
        return getObject(schema);
    }

    public MsFunction getObject(AbstractSchema schema) {
        ParserRuleContext batchCtx = ctx.getParent().getParent();
        MsFunction function = new MsFunction(ctx.func_proc_name().procedure.getText(), getFullCtxText(batchCtx));
        boolean isKeepNewlines = db.getArguments().isKeepNewlines();
        if (ctx.func_body().func_body_return().EXTERNAL() != null) {
            function.setAnsiNulls(false);
            function.setQuotedIdentified(false);
            function.setCLR(true);

            fillArguments(function);
            function.setBody(db.getArguments(), getFullCtxText(ctx.func_body()));
            String returns = getFullCtxText(ctx.func_return());
            function.setReturns(isKeepNewlines ? returns : returns.replace("\r", ""));
        } else {
            function.setAnsiNulls(ansiNulls);
            function.setQuotedIdentified(quotedIdentifier);
            setSourceParts(function);
        }

        Func_returnContext ret = ctx.func_return();
        if (ret.TABLE() != null) {
            function.setFuncType(FuncTypes.TABLE);
        } else if  (ret.LOCAL_ID() != null) {
            function.setFuncType(FuncTypes.MULTI);
        }

        schema.addFunction(function);
        return function;
    }

    private void fillArguments(AbstractFunction function) {
        for (Procedure_paramContext argument : ctx.procedure_param()) {
            Argument arg = new Argument(
                    argument.arg_mode != null ? argument.arg_mode.getText() : null,
                            argument.name.getText(), getFullCtxText(argument.data_type()));

            if (argument.default_val != null) {
                arg.setDefaultExpression(getFullCtxText(argument.default_val));
            }

            function.addArgument(arg);
        }
    }
}
