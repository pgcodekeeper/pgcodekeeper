package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_procedureContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Procedure_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Procedure_paramContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.MsProcedure;
import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class CreateMsProcedure extends ParserAbstract {

    private final Create_or_alter_procedureContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    private final CommonTokenStream stream;

    public CreateMsProcedure(Create_or_alter_procedureContext ctx, PgDatabase db,
            boolean ansiNulls, boolean quotedIdentifier, CommonTokenStream stream) {
        super(db);
        this.ctx = ctx;
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
        this.stream = stream;
    }

    @Override
    public MsProcedure getObject() {
        IdContext schemaCtx = ctx.func_proc_name().schema;
        AbstractSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
        return getObject(schema);
    }

    public MsProcedure getObject(AbstractSchema schema) {
        ParserRuleContext batchCtx = ctx.getParent().getParent();
        MsProcedure procedure = new MsProcedure(ctx.func_proc_name().procedure.getText(), getFullCtxText(batchCtx));
        if (ctx.proc_body().EXTERNAL() != null) {
            procedure.setAnsiNulls(false);
            procedure.setQuotedIdentified(false);
            procedure.setCLR(true);

            fillArguments(procedure);
            procedure.setForReplication(ctx.REPLICATION() != null);
            procedure.setBody(db.getArguments(), getFullCtxText(ctx.proc_body()));

            for (Procedure_optionContext option : ctx.procedure_option()) {
                procedure.addOption(getFullCtxText(option));
            }
        } else {
            procedure.setAnsiNulls(ansiNulls);
            procedure.setQuotedIdentified(quotedIdentifier);

            boolean isKeepNewLines = db.getArguments().isKeepNewlines();
            String first = ParserAbstract.getHiddenLeftCtxText(batchCtx, stream);
            String second = ParserAbstract.getRightCtxTextWithHidden(batchCtx, stream, true);
            procedure.setFirstPart(isKeepNewLines ? first : first.replace("\r", ""));
            procedure.setSecondPart(isKeepNewLines ? second : second.replace("\r", ""));
        }

        schema.addFunction(procedure);
        return procedure;
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