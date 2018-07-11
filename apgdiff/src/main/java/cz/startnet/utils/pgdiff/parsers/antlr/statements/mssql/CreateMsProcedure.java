package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_procedureContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Procedure_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Procedure_paramContext;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.MsProcedure;
import cz.startnet.utils.pgdiff.schema.MsProcedure.ProcedureArgument;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateMsProcedure extends ParserAbstract {

    private final Create_or_alter_procedureContext ctx;

    public CreateMsProcedure(Create_or_alter_procedureContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        IdContext schemaCtx = ctx.func_proc_name().schema;
        PgSchema schema = schemaCtx == null ? db.getDefaultSchema() : getSafe(db::getSchema, schemaCtx);
        MsProcedure function = new MsProcedure(ctx.func_proc_name().procedure.getText(), getFullCtxText(ctx.getParent()));
        fillArguments(function);
        function.setForReplication(ctx.REPLICATION() != null);
        function.setBody(getFullCtxText(ctx.proc_body()));

        for (Procedure_optionContext option : ctx.procedure_option()) {
            function.addOption(getFullCtxText(option));
        }

        schema.addProcedure(function);
        return function;
    }

    private void fillArguments(MsProcedure function) {
        for (Procedure_paramContext argument : ctx.procedure_param()) {
            ProcedureArgument arg = function.new ProcedureArgument(
                    argument.arg_mode != null ? argument.arg_mode.getText() : null,
                            argument.name.getText(), getFullCtxText(argument.data_type()));

            if (argument.default_val != null) {
                arg.setDefaultExpression(getFullCtxText(argument.default_val));
            }

            function.addArgument(arg);
        }
    }
}