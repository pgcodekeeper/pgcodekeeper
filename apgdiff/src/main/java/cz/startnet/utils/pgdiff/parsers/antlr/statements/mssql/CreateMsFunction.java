package cz.startnet.utils.pgdiff.parsers.antlr.statements.mssql;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Assembly_specifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Batch_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Column_def_table_constraintsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Create_or_alter_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Func_bodyContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Func_returnContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Function_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.IdContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Procedure_paramContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Sql_clausesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSelect;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsSqlClauses;
import cz.startnet.utils.pgdiff.parsers.antlr.msexpr.MsValueExpr;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractMsClrFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.FuncTypes;
import cz.startnet.utils.pgdiff.schema.MsClrFunction;
import cz.startnet.utils.pgdiff.schema.MsFunction;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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
        String name = nameCtx.getText();
        Func_bodyContext bodyRet = ctx.func_body();

        AbstractFunction f;

        String returns = getFullCtxText(ctx.func_return());

        if (bodyRet.EXTERNAL() != null) {
            Assembly_specifierContext assemblyCtx = bodyRet.assembly_specifier();
            String assembly = assemblyCtx.assembly_name.getText();
            String assemblyClass = assemblyCtx.class_name.getText();
            String assemblyMethod = assemblyCtx.method_name.getText();

            MsClrFunction func = new MsClrFunction(name, assembly,
                    assemblyClass, assemblyMethod);

            addDepSafe(func, Arrays.asList(assemblyCtx.assembly_name),
                    DbObjType.ASSEMBLY, false);

            for (Function_optionContext option : ctx.function_option()) {
                func.addOption(getFullCtxText(option));
            }

            boolean isKeepNewlines = db.getArguments().isKeepNewlines();
            func.setReturns(isKeepNewlines ? returns : returns.replace("\r", ""));

            Func_returnContext ret = ctx.func_return();
            if (ret.LOCAL_ID() != null) {
                func.setFuncType(FuncTypes.MULTI);
            } else if (ret.data_type() == null) {
                func.setFuncType(FuncTypes.TABLE);
            }

            f = func;
        } else {
            MsFunction func = new MsFunction(name);
            func.setAnsiNulls(ansiNulls);
            func.setQuotedIdentified(quotedIdentifier);
            setSourceParts(func);

            Select_statementContext select = bodyRet.select_statement();
            String schemaName;
            if (schema != null) {
                schemaName = schema.getName();
            } else {
                schemaName = getSchemaNameSafe(ids);
            }

            if (select != null) {
                MsSelect sel = new MsSelect(schemaName);
                sel.analyze(select);
                func.addAllDeps(sel.getDepcies());
            } else {
                ExpressionContext exp = bodyRet.expression();
                if (exp != null) {
                    MsValueExpr vex = new MsValueExpr(schemaName);
                    vex.analyze(exp);
                    func.addAllDeps(vex.getDepcies());
                }

                Sql_clausesContext clausesCtx = bodyRet.sql_clauses();
                if (clausesCtx != null) {
                    MsSqlClauses clauses = new MsSqlClauses(schemaName);
                    clauses.analyze(clausesCtx);
                    func.addAllDeps(clauses.getDepcies());
                }
            }

            Func_returnContext ret = ctx.func_return();
            if (ret.LOCAL_ID() != null) {
                func.setFuncType(FuncTypes.MULTI);
            } else if (ret.data_type() == null) {
                func.setFuncType(FuncTypes.TABLE);
            }

            f = func;
        }

        fillArguments(f);
        analyzeReturn(ctx.func_return(), f);

        if (isJdbc && schema != null) {
            schema.addFunction(f);
        } else {
            addSafe(schema, f, ids);
        }

        return f;
    }

    private void analyzeReturn(Func_returnContext ret, AbstractFunction function) {
        Column_def_table_constraintsContext cons = ret.column_def_table_constraints();
        if (cons != null) {
            for (Column_def_table_constraintContext con : cons.column_def_table_constraint()) {
                Data_typeContext dt = con.data_type();
                if (dt != null) {
                    addMsTypeDepcy(dt, function);
                }
            }
        } else if (ret.data_type() != null) {
            addMsTypeDepcy(ret.data_type(), function);
        }
    }

    private void fillArguments(AbstractFunction function) {
        for (Procedure_paramContext argument : ctx.procedure_param()) {
            addMsTypeDepcy(argument.data_type(), function);

            if (function instanceof AbstractMsClrFunction) {
                Argument arg = new Argument(
                        argument.arg_mode != null ? argument.arg_mode.getText() : null,
                                argument.name.getText(), getFullCtxText(argument.data_type()));
                if (argument.default_val != null) {
                    arg.setDefaultExpression(getFullCtxText(argument.default_val));
                }

                ((AbstractMsClrFunction) function).addArgument(arg);
            }
        }
    }
}
