package cz.startnet.utils.pgdiff.parsers.antlr.statements;

import java.util.List;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_funct_paramsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Create_function_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_actions_commonContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_argumentsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_column_name_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Set_statement_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Transform_for_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_storage_parameterContext;
import cz.startnet.utils.pgdiff.schema.AbstractFunction;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.Argument;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgStatement;

public class CreateFunction extends ParserAbstract {
    private final Create_function_statementContext ctx;
    public CreateFunction(Create_function_statementContext ctx, PgDatabase db) {
        super(db);
        this.ctx = ctx;
    }

    @Override
    public PgStatement getObject() {
        List<IdentifierContext> ids = ctx.function_parameters().name.identifier();
        AbstractSchema schema = getSchemaSafe(ids, db.getDefaultSchema());
        AbstractFunction function = new PgFunction(QNameParser.getFirstName(ids), getFullCtxText(ctx.getParent()));
        fillArguments(function);
        function.setBody(db.getArguments(), getFullCtxText(ctx.funct_body));
        fillFunction(ctx.funct_body, function);

        if (ctx.ret_table != null) {
            function.setReturns(getFullCtxText(ctx.ret_table));
            for (Function_column_name_typeContext ret_col : ctx.ret_table.function_column_name_type()) {
                addTypeAsDepcy(ret_col.column_type, function, getDefSchemaName());
                function.addReturnsColumn(ret_col.column_name.getText(), getFullCtxText(ret_col.column_type));
            }
        } else if(ctx.rettype_data != null) {
            function.setReturns(getFullCtxText(ctx.rettype_data));
            addTypeAsDepcy(ctx.rettype_data, function, getDefSchemaName());
        }
        schema.addFunction(function);
        return function;
    }

    private void fillFunction(Create_funct_paramsContext params,
            AbstractFunction function) {
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
                function.setBody(db.getArguments(), getFullCtxText(action.function_def()));
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
                    function.addConfiguration(par, AbstractFunction.FROM_CURRENT);
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

    private void fillArguments(AbstractFunction function) {
        for (Function_argumentsContext argument : ctx.function_parameters()
                .function_args().function_arguments()) {
            Argument arg = new Argument(argument.arg_mode != null ? argument.arg_mode.getText() : null,
                    argument.argname != null ? argument.argname.getText() : null,
                            getFullCtxText(argument.argtype_data));
            addTypeAsDepcy(argument.data_type(), function, getDefSchemaName());

            if (argument.function_def_value() != null) {
                arg.setDefaultExpression(getFullCtxText(argument.function_def_value().def_value));
                db.addContextForAnalyze(function, argument.function_def_value().def_value);
            }

            function.addArgument(arg);
        }
    }
}