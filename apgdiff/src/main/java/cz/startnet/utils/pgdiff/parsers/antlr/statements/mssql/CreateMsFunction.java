package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Func_returnContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Procedure_paramContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.MsFunction;
import cz.startnet.utils.pgdiff.schema.MsFunction.FuncTypes;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CreateMsFunction extends ParserAbstract {

    private final Create_or_alter_functionContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    private final CommonTokenStream stream;

    public CreateMsFunction(Create_or_alter_functionContext ctx, PgDatabase db,
            boolean ansiNulls, boolean quotedIdentifier, CommonTokenStream stream) {
        super(db);
        this.ctx = ctx;
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
        this.stream = stream;
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

            boolean isKeepNewLines = db.getArguments().isKeepNewlines();
            String first = ParserAbstract.getHiddenLeftCtxText(batchCtx, stream);
            String second = ParserAbstract.getRightCtxTextWithHidden(batchCtx, stream, true);
            function.setFirstPart(isKeepNewLines ? first : first.replace("\r", ""));
            function.setSecondPart(isKeepNewLines ? second : second.replace("\r", ""));
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
