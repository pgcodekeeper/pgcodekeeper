/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.parsers.antlr.statements.ms;

import java.util.Arrays;
import java.util.List;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher.MsFuncProcTrigAnalysisLauncher;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Assembly_specifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Batch_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Column_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Create_or_alter_functionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Func_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Func_returnContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Function_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.IdContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Procedure_paramContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Select_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Sql_clausesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_elementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_elementsContext;
import ru.taximaxim.codekeeper.core.schema.AbstractFunction;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.FuncTypes;
import ru.taximaxim.codekeeper.core.schema.ms.MsClrFunction;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsFunction;

public class CreateMsFunction extends BatchContextProcessor {

    private final Create_or_alter_functionContext ctx;

    private final boolean ansiNulls;
    private final boolean quotedIdentifier;

    public CreateMsFunction(Batch_statementContext ctx, MsDatabase db,
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
        List<ParserRuleContext> ids = Arrays.asList(ctx.qualified_name().schema, nameCtx);
        String name = nameCtx.getText();
        Func_bodyContext bodyRet = ctx.func_body();

        AbstractFunction f;
        if (bodyRet.EXTERNAL() != null) {
            Assembly_specifierContext assemblyCtx = bodyRet.assembly_specifier();
            String assembly = assemblyCtx.assembly_name.getText();
            String assemblyClass = assemblyCtx.class_name.getText();
            String assemblyMethod = assemblyCtx.method_name.getText();

            MsClrFunction func = new MsClrFunction(name, assembly,
                    assemblyClass, assemblyMethod);

            addDepSafe(func, Arrays.asList(assemblyCtx.assembly_name), DbObjType.ASSEMBLY);

            for (Function_optionContext option : ctx.function_option()) {
                func.addOption(getFullCtxText(option));
            }

            func.setReturns(getFullCtxTextWithCheckNewLines(ctx.func_return()));

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

            if (select != null) {
                db.addAnalysisLauncher(new MsFuncProcTrigAnalysisLauncher(
                        func, select, fileName));
            } else {
                ExpressionContext exp = bodyRet.expression();
                if (exp != null) {
                    db.addAnalysisLauncher(new MsFuncProcTrigAnalysisLauncher(
                            func, exp, fileName));
                }

                Sql_clausesContext clausesCtx = bodyRet.sql_clauses();
                if (clausesCtx != null) {
                    db.addAnalysisLauncher(new MsFuncProcTrigAnalysisLauncher(
                            func, clausesCtx, fileName));
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
        var typeCtx = ret.data_type();
        if (typeCtx != null) {
            addTypeDepcy(typeCtx, function);
            return;
        }

        Table_elementsContext elements = ret.table_elements();
        if (elements == null) {
            return;
        }

        for (Table_elementContext element : elements.table_element()) {
            Column_defContext colCtx = element.column_def();
            if (colCtx != null) {
                var dt = colCtx.data_type();
                if (dt != null) {
                    addTypeDepcy(dt, function);
                }
            }
        }
    }

    private void fillArguments(AbstractFunction function) {
        for (Procedure_paramContext argument : ctx.procedure_param()) {
            addTypeDepcy(argument.data_type(), function);

            Argument arg = new Argument(parseArgMode(argument.arg_mode()),
                    argument.name.getText(), getFullCtxText(argument.data_type()));
            arg.setReadOnly(argument.READONLY() != null);
            if (argument.default_val != null) {
                arg.setDefaultExpression(getFullCtxTextWithCheckNewLines(argument.default_val));
            }

            function.addArgument(arg);
        }
    }

    @Override
    protected String getStmtAction() {
        return getStrForStmtAction(ACTION_CREATE, DbObjType.FUNCTION, ctx.qualified_name());
    }
}
