package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Assembly_specifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_procedureContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Procedure_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Procedure_paramContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSqlClauses;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.MsClrProcedure;
import cz.startnet.utils.pgdiff.schema.MsProcedure;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class CreateMsProcedure extends BatchContextProcessor {

    private final Create_or_alter_procedureContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    public CreateMsProcedure(Batch_statementContext ctx, PgDatabase db,
            boolean ansiNulls, boolean quotedIdentifier, CommonTokenStream stream) {
        super(db, ctx, stream);
        this.ctx = ctx.batch_statement_body().create_or_alter_procedure();
        this.ansiNulls = ansiNulls;
        this.quotedIdentifier = quotedIdentifier;
    }

    @Override
    protected ParserRuleContext getDelimiterCtx() {
        return ctx.qualified_name();
    }

    @Override
    public void parseObject() {
        Qualified_nameContext qname = ctx.qualified_name();
        getObject(getSchemaSafe(Arrays.asList(qname.schema, qname.name)), false);
    }

    public AbstractFunction getObject(AbstractSchema schema, boolean isJdbc) {
        IdContext nameCtx = ctx.qualified_name().name;
        List<IdContext> ids = Arrays.asList(ctx.qualified_name().schema, nameCtx);
        if (ctx.proc_body().EXTERNAL() != null) {
            Assembly_specifierContext assemblyCtx = ctx.proc_body().assembly_specifier();
            String assembly = assemblyCtx.assembly_name.getText();
            String assemblyClass = assemblyCtx.class_name.getText();
            String assemblyMethod = assemblyCtx.method_name.getText();
            MsClrProcedure procedure = new MsClrProcedure(nameCtx.getText(),
                    assembly, assemblyClass, assemblyMethod);

            addDepSafe(procedure, Arrays.asList(assemblyCtx.assembly_name),
                    DbObjType.ASSEMBLY, false);
            fillArguments(procedure);

            for (Procedure_optionContext option : ctx.procedure_option()) {
                procedure.addOption(getFullCtxText(option));
            }
            if (isJdbc) {
                schema.addFunction(procedure);
            } else {
                addSafe(schema, procedure, ids);
            }
            return procedure;
        }

        MsProcedure procedure = new MsProcedure(nameCtx.getText());
        procedure.setAnsiNulls(ansiNulls);
        procedure.setQuotedIdentified(quotedIdentifier);

        fillArguments(procedure);
        setSourceParts(procedure);

        String schemaName;
        if (schema != null) {
            schemaName = schema.getName();
        } else {
            schemaName = getSchemaNameSafe(ids);
        }
        MsSqlClauses clauses;
        if (db.getArguments().isEnableFunctionBodiesDependencies()) {
            clauses = new MsSqlClauses(schemaName);
        } else {
            clauses = new MsSqlClauses(schemaName, DbObjType.FUNCTION, DbObjType.PROCEDURE);
        }
        clauses.analyze(ctx.proc_body().sql_clauses());
        procedure.addAllDeps(clauses.getDepcies());

        if (isJdbc && schema != null) {
            schema.addFunction(procedure);
        } else {
            addSafe(schema, procedure, ids);
        }
        return procedure;
    }

    private void fillArguments(AbstractFunction function) {
        for (Procedure_paramContext argument : ctx.procedure_param()) {
            Argument arg = new Argument(parseArgMode(argument.arg_mode()),
                    argument.name.getText(), getFullCtxText(argument.data_type()));
            arg.setReadOnly(argument.READONLY() != null);
            addMsTypeDepcy(argument.data_type(), function);
            if (argument.default_val != null) {
                arg.setDefaultExpression(getFullCtxText(argument.default_val));
            }

            function.addArgument(arg);
        }
    }
}