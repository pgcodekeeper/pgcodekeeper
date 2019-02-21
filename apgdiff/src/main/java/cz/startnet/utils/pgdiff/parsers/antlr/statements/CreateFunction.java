package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;
import java.util.Queue;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrTask;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Character_stringContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_funct_paramsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_actions_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_column_name_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_defContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statement_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Transform_for_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_storage_parameterContext;
import cz.startnet.utils.pgdiff.schema.AbstractPgFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgProcedure;

public class CreateFunction extends ParserAbstract {

    private List<AntlrError> errors;
    private final Queue<AntlrTask<?>> antlrTasks;
    private final Create_function_statementContext ctx;


    public CreateFunction(Create_function_statementContext ctx, PgDatabase db,
            Queue<AntlrTask<?>> antlrTasks) {
        super(db);
        this.ctx = ctx;
        this.antlrTasks = antlrTasks;
    }

    public void setErrors(List<AntlrError> errors) {
        this.errors = errors;
    }

    @Override
    public void parseObject() {
        List<IdentifierContext> ids = ctx.function_parameters().name.identifier();
        String name = QNameParser.getFirstName(ids);
        AbstractPgFunction function = ctx.PROCEDURE() != null ? new PgProcedure(name)
                : new PgFunction(name);

        // TODO add processing for case when (funcArgsCtx == null)
        List<Function_argumentsContext> funcArgsCtx = ctx.function_parameters()
                .function_args().function_arguments();


        fillArguments(function, funcArgsCtx);
        function.setBody(db.getArguments(), getFullCtxText(ctx.funct_body));
        fillFunction(ctx.funct_body, function, funcArgsCtx);

        if (ctx.ret_table != null) {
            function.setReturns(getFullCtxText(ctx.ret_table));
            for (Function_column_name_typeContext ret_col : ctx.ret_table.function_column_name_type()) {
                addPgTypeDepcy(ret_col.column_type, function);
                function.addReturnsColumn(ret_col.column_name.getText(), getTypeName(ret_col.column_type));
            }
        } else if (ctx.rettype_data != null) {
            function.setReturns(getTypeName(ctx.rettype_data));
            addPgTypeDepcy(ctx.rettype_data, function);
        }
        addSafe(AbstractSchema::addFunction, getSchemaSafe(ids), function, ids);
    }

    private void fillFunction(Create_funct_paramsContext params,
            AbstractPgFunction function, List<Function_argumentsContext> funcArgsCtx) {
        Function_defContext funcDef = null;
        for (Function_actions_commonContext action  : params.function_actions_common()) {
            if (action.WINDOW() != null) {
                function.setWindow(true);
            } else if (action.IMMUTABLE() != null) {
                function.setVolatileType("IMMUTABLE");
            } else if (action.STABLE() != null) {
                function.setVolatileType("STABLE");
            } else if (action.STRICT() != null || action.RETURNS() != null) {
                function.setStrict(true);
            } else if (action.DEFINER() != null) {
                function.setSecurityDefiner(true);
            } else if (action.LEAKPROOF() != null) {
                function.setLeakproof(true);
            } else if (action.LANGUAGE() != null) {
                function.setLanguage(action.lang_name.getText());
            } else if (action.COST() != null) {
                function.setCost(Float.parseFloat(action.execution_cost.getText()));
            } else if (action.ROWS() != null) {
                float f = Float.parseFloat(action.result_rows.getText());
                if (0.0f != f) {
                    function.setRows(Float.parseFloat(action.result_rows.getText()));
                }
            } else if (action.AS() != null) {
                funcDef = action.function_def();
                function.setBody(db.getArguments(), getFullCtxText(funcDef));
            } else if (action.TRANSFORM() != null) {
                for (Transform_for_typeContext transform : action.transform_for_type()) {
                    function.addTransform(ParserAbstract.getFullCtxText(transform.type_name));
                }
            } else if (action.SAFE() != null) {
                function.setParallel("SAFE");
            } else if (action.RESTRICTED() != null) {
                function.setParallel("RESTRICTED");
            } else if (action.SET() != null) {
                String par = PgDiffUtils.getQuotedName(action.configuration_parameter.getText());
                if (action.FROM() != null) {
                    function.addConfiguration(par, AbstractPgFunction.FROM_CURRENT);
                } else {
                    StringBuilder sb = new StringBuilder();
                    for (Set_statement_valueContext val : action.value) {
                        sb.append(getFullCtxText(val)).append(", ");
                    }
                    sb.setLength(sb.length() - 2);
                    function.addConfiguration(par, sb.toString());
                }
            }
        }

        // Parsing the function definition and adding its result context for analysis.
        List<Character_stringContext> funcContent = funcDef.character_string();
        if ("SQL".equalsIgnoreCase(function.getLanguage()) && funcContent.size() == 1) {
            StringBuilder sb = new StringBuilder();
            funcContent.get(0).Text_between_Dollar().forEach(sb::append);
            String def = sb.toString();
            AntlrParser.submitSqlCtxToAnalyze(def, errors,
                    getFullCtxText(ctx.getParent()).indexOf(def),
                    "function definition of " + function.getBareName(),
                    ctx -> db.addContextForAnalyze(function, ctx), antlrTasks);
            db.addFuncArgsCtxsForAnalyze(function, funcArgsCtx);
        }

        With_storage_parameterContext storage = params.with_storage_parameter();
        if (storage != null) {
            for (Storage_parameter_optionContext option : storage.storage_parameter().storage_parameter_option()) {
                if ("isStrict".equalsIgnoreCase(option.getText())) {
                    function.setStrict(true);
                } else if ("isCachable".equalsIgnoreCase(option.getText())) {
                    function.setVolatileType("IMMUTABLE");
                }
            }
        }
    }

    private void fillArguments(AbstractPgFunction function,
            List<Function_argumentsContext> funcArgsCtx) {
        for (Function_argumentsContext argument : funcArgsCtx) {
            Argument arg = new Argument(argument.arg_mode != null ? argument.arg_mode.getText() : null,
                    argument.argname != null ? argument.argname.getText() : null,
                            getTypeName(argument.argtype_data));
            addPgTypeDepcy(argument.data_type(), function);

            if (argument.function_def_value() != null) {
                arg.setDefaultExpression(getFullCtxText(argument.function_def_value().def_value));
                db.addContextForAnalyze(function, argument.function_def_value().def_value);
            }

            function.addArgument(arg);
        }
    }
}