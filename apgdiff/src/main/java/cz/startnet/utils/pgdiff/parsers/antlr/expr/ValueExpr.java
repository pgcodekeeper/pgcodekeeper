package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.antlr.v4.runtime.tree.TerminalNode;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Array_bracketsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Array_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Case_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Cast_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collate_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comparison_modContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Date_time_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Datetime_overlapsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Extract_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Filter_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Frame_boundContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Frame_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_callContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.General_literalContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Indirection_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.OpContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Orderby_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Partition_by_columnsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Predefined_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Qualified_asteriskContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sort_specifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.String_value_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.System_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_subqueryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Tokens_simple_functionsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Truth_valueContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Type_coercionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Unsigned_numeric_literalContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Unsigned_value_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expression_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Vex_bContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Window_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Xml_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.parsers.antlr.statements.ParserAbstract;
import cz.startnet.utils.pgdiff.schema.IArgument;
import cz.startnet.utils.pgdiff.schema.IFunction;
import cz.startnet.utils.pgdiff.schema.ISchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public class ValueExpr extends AbstractExpr {

    public ValueExpr(String schema, PgDatabase db) {
        super(schema, db);
    }

    protected ValueExpr(AbstractExpr parent) {
        super(parent);
    }


    public Pair<String, String> analyze(Vex vex) {
        Pair<String, String> ret ;
        Data_typeContext dataType = vex.dataType();
        @SuppressWarnings("unused")
        // TODO OpCtx user-operator reference
        Collate_identifierContext collate;
        TerminalNode operator;
        OpContext op = null;
        Datetime_overlapsContext overlaps;
        Value_expression_primaryContext primary;
        List<Pair<String, String>> operandsList;

        List<Vex> operands = vex.vex();
        if (!operands.isEmpty()) {
            operandsList = new ArrayList<>(operands.size());
            for (Vex v : operands) {
                operandsList.add(analyze(v));
            }
        } else {
            operandsList = Collections.emptyList();
        }

        if (vex.castExpression() != null && dataType != null) {
            addTypeDepcy(dataType);
            Predefined_typeContext pType = dataType.predefined_type();
            Schema_qualified_name_nontypeContext customType = pType.schema_qualified_name_nontype();
            IdentifierContext typeSchema = customType == null ? null : customType.identifier();
            // TODO remove when tokens are refactored
            if (dataType.LEFT_BRACKET() == null && dataType.SETOF() == null && customType != null &&
                    (typeSchema == null || "pg_catalog".equals(typeSchema.getText()))) {
                // check simple built-in types for reg*** casts
                Value_expression_primaryContext castPrimary = vex.vex().get(0).primary();
                Unsigned_value_specificationContext value;
                General_literalContext literal;
                if (castPrimary != null
                        && (value = castPrimary.unsigned_value_specification()) != null
                        && (literal = value.general_literal()) != null
                        && literal.character_string() != null) {
                    regCast(PgDiffUtils.unquoteQuotedString(literal.getText()),
                            customType.getText());
                }
            }

            ret = operandsList.get(0);
            ret.setSecond(ParserAbstract.getFullCtxText(dataType));
        } else if (vex.leftParen() != null && vex.rightParen() != null) {
            if (operandsList.size() == 1) {
                ret = operandsList.get(0);
            } else {
                // TODO add record type placeholder?
                ret = new Pair<>("row", TypesSetManually.UNKNOWN);
            }
        } else if (vex.leftBracket() != null && vex.rightBracket() != null) {
            ret = operandsList.get(0);
            if (vex.colon() == null) {
                ret.setValue(stripBrackets(ret.getValue()));
            }
        } else if ((collate = vex.collateIdentifier()) != null) {
            // TODO pending DbObjType.COLLATION
            ret = operandsList.get(0);
        } else if (vex.timeZone() != null) {
            ret = operandsList.get(0);
        } else if (vex.in() != null) {
            Select_stmt_no_parensContext selectStmt = vex.selectStmt();
            if (selectStmt != null) {
                new Select(this).analyze(selectStmt);
            }
            ret = new Pair<>(null, TypesSetManually.BOOLEAN);
        } else if ((overlaps = vex.datetimeOverlaps()) != null) {
            for (VexContext v : overlaps.vex()) {
                analyze(new Vex(v));
            }
            ret = new Pair<>("overlaps", TypesSetManually.BOOLEAN);
        } else if ((operator = getOperatorToken(vex)) != null || (op = vex.op()) != null) {
            if (op != null) {
                IdentifierContext opSchemaCtx = op.identifier();
                if (opSchemaCtx == null || opSchemaCtx.getText().equals(PgSystemStorage.SCHEMA_PG_CATALOG)) {
                    operator = op.OP_CHARS();
                }
            }
            if (operator != null) {
                String larg = TypesSetManually.EMPTY;
                String rarg = TypesSetManually.EMPTY;
                if (operandsList.size() == 2) {
                    larg = operandsList.get(0).getSecond();
                    rarg = operandsList.get(1).getSecond();
                } else if (op == null || vex.getVexCtx().getChild(0) instanceof OpContext) {
                    rarg = operandsList.get(0).getSecond();
                } else {
                    larg = operandsList.get(0).getSecond();
                }
                ret = operator(operator.getText(), larg, rarg);
            } else {
                // if we got to this point, operator didn't get filled by the OP_CHARS token
                // meaning user-schema operator
                Log.log(Log.LOG_WARNING, "Unsupported user operator!");
                ret = new Pair<>(null, TypesSetManually.UNKNOWN);
            }
        } else if (vex.between() != null
                || vex.like() != null
                || vex.ilike() != null
                || vex.similar() != null
                || vex.lth() != null
                || vex.gth() != null
                || vex.leq() != null
                || vex.geq() != null
                || vex.equal() != null
                || vex.notEqual() != null
                || vex.is() != null
                || vex.isNull() != null
                || vex.notNull() != null
                || (vex.not() != null && vex.in() == null)
                || vex.and() != null
                || vex.or() != null ) {
            ret = new Pair<>(null, TypesSetManually.BOOLEAN);
        } else if ((primary = vex.primary()) != null) {
            Select_stmt_no_parensContext subSelectStmt = primary.select_stmt_no_parens();
            Case_expressionContext caseExpr;
            Cast_specificationContext cast;
            Comparison_modContext compMod;
            Table_subqueryContext subquery;
            Function_callContext function;
            Schema_qualified_nameContext qname;
            Indirection_identifierContext indirection;
            Qualified_asteriskContext ast;
            Array_expressionContext array;
            Type_coercionContext typeCoercion;
            Unsigned_value_specificationContext unsignedValue;

            if (primary.NULL() != null) {
                ret = new Pair<>(null, TypesSetManually.UNKNOWN);
            } else if ((unsignedValue = primary.unsigned_value_specification()) != null) {
                ret = new Pair<>(null, literal(unsignedValue));
            } else if (primary.LEFT_PAREN() != null && primary.RIGHT_PAREN() != null &&
                    subSelectStmt != null) {
                ret = new Select(this).analyze(subSelectStmt).get(0);
            } else if ((caseExpr = primary.case_expression()) != null) {
                VexContext retVex = caseExpr.r.get(0);
                ret = null;
                for (VexContext v : caseExpr.vex()) {
                    Pair<String, String> caseRet = analyze(new Vex(v));
                    if (v == retVex) {
                        // use the first case result as the return type
                        ret = caseRet;
                    }
                }
                if (ret.getFirst() == null) {
                    ret.setFirst("case");
                }
            } else if ((cast = primary.cast_specification()) != null) {
                ret = analyze(new Vex(cast.vex()));
                Data_typeContext dataTypeCtx = cast.data_type();
                ret.setValue(ParserAbstract.getFullCtxText(dataTypeCtx));
                addTypeDepcy(dataTypeCtx);
            } else if ((compMod = primary.comparison_mod()) != null) {
                VexContext compModVex = compMod.vex();
                if (compModVex != null) {
                    ret = analyze(new Vex(compModVex));
                    ret.setValue(stripBrackets(ret.getValue()));
                } else {
                    ret = new Select(this).analyze(compMod.select_stmt_no_parens()).get(0);
                }
            } else if (primary.EXISTS() != null &&
                    (subquery = primary.table_subquery()) != null) {
                new Select(this).analyze(subquery.select_stmt());
                ret = new Pair<>("exists", TypesSetManually.BOOLEAN);
            } else if ((function = primary.function_call()) != null) {
                ret = function(function);
            } else if ((qname = primary.schema_qualified_name()) != null) {
                ret = processColumn(qname);
            } else if ((indirection = primary.indirection_identifier()) != null) {
                analyze(new Vex(indirection.vex()));
                ret = new Pair<>(null, TypesSetManually.UNKNOWN);
            } else if ((ast = primary.qualified_asterisk()) != null) {
                // TODO pending full analysis
                ret = new Pair<>(null, TypesSetManually.QUALIFIED_ASTERISK);
            } else if ((array = primary.array_expression()) != null) {
                Array_bracketsContext arrayb = array.array_brackets();
                if (arrayb != null) {
                    List<VexContext> arraybVexCtxList = arrayb.vex();
                    ret = analyze(new Vex(arraybVexCtxList.get(0)));
                    for (int i = 1; i < arraybVexCtxList.size(); ++i) {
                        analyze(new Vex(arraybVexCtxList.get(i)));
                    }
                } else {
                    ret = new Select(this)
                            .analyze(array.array_query().table_subquery().select_stmt())
                            .get(0);
                }
                ret.setFirst("array");
                ret.setSecond(ret.getSecond() + "[]");
            } else if ((typeCoercion = primary.type_coercion()) != null) {
                Data_typeContext coercionDataType = typeCoercion.data_type();
                addTypeDepcy(coercionDataType);
                String type = ParserAbstract.getFullCtxText(coercionDataType);
                // since this cast can only convert string literals into a type
                // and types are restricted to the simplest
                // column name here will always be derived from type name
                ret = new Pair<>(type, type);
            } else {
                Log.log(Log.LOG_WARNING, "No alternative in Vex Primary!");
                ret = new Pair<>(null, TypesSetManually.UNKNOWN);
            }
        } else {
            Log.log(Log.LOG_WARNING, "No alternative in Vex!");
            ret = new Pair<>(null, TypesSetManually.UNKNOWN);
        }

        return ret;
    }

    /**
     * @return return signature
     */
    public Pair<String, String> function(Function_callContext function) {
        Function_nameContext funcNameCtx = function.function_name();
        if (funcNameCtx == null) {
            return functionSpecial(function);
        }

        Orderby_clauseContext orderBy = function.orderby_clause();
        if (orderBy != null) {
            orderBy(orderBy);
        }
        Filter_clauseContext filter = function.filter_clause();
        if (filter != null) {
            analyze(new Vex(filter.vex()));
        }
        Window_definitionContext window = function.window_definition();
        if (window != null) {
            window(window);
        }

        String schemaName = null;
        String functionName;
        Data_typeContext dataTypeCtx = funcNameCtx.data_type();
        Schema_qualified_name_nontypeContext funcNameQualCtx;

        IdentifierContext id;
        Tokens_simple_functionsContext tokensSimpleFunc;
        if (dataTypeCtx != null &&
                (funcNameQualCtx = dataTypeCtx.predefined_type().schema_qualified_name_nontype()) != null) {
            functionName = funcNameQualCtx.identifier_nontype().getText();

            if ((id = funcNameQualCtx.identifier()) != null) {
                schemaName = id.getText();
            }
        } else if ((tokensSimpleFunc = funcNameCtx.tokens_simple_functions()) != null) {
            functionName = tokensSimpleFunc.getText();

            if ((id = funcNameCtx.identifier()) != null) {
                schemaName = id.getText();
            }
        } else {
            functionName = funcNameCtx.getText();
        }

        List<VexContext> args = function.vex();
        Value_expression_primaryContext primary;
        if (args.size() == 1 && (primary = args.get(0).value_expression_primary()) != null
                && primary.qualified_asterisk() != null) {
            //// In this case function's argument is '*' or 'source.*'.

            int foundFuncsCount = 0;
            IFunction func = null;
            for (IFunction f : PgDiffUtils.sIter(availableFunctions(schemaName))) {
                if (f.getBareName().equals(functionName) && getInInoutFuncArgs(f).count() == 1) {
                    func = f;
                    foundFuncsCount++;
                }
            }

            return new Pair<>(functionName, foundFuncsCount == 1 ?
                    getFunctionReturns(func) : TypesSetManually.FUNCTION_COLUMN);
        } else {
            List<String> argsType = new ArrayList<>(args.size());
            for (VexContext arg : args) {
                argsType.add(analyze(new Vex(arg)).getSecond());
            }

            IFunction resultFunction = resolveCall(functionName, argsType, availableFunctions(schemaName));

            if (resultFunction != null) {
                addFunctionDepcy(resultFunction);
                return new Pair<>(functionName, getFunctionReturns(resultFunction));
            }
            return new Pair<>(functionName, TypesSetManually.FUNCTION_COLUMN);
        }
    }

    private Pair<String, String> functionSpecial(Function_callContext function) {
        Pair<String, String> ret;
        List<VexContext> args = null;

        Extract_functionContext extract;
        System_functionContext system;
        Date_time_functionContext datetime;
        String_value_functionContext string;
        Xml_functionContext xml;

        if ((extract = function.extract_function()) != null) {
            analyze(new Vex(extract.vex()));
            // parser defines this as a call to an overload of pg_catalog.date_part
            ret = new Pair<>("date_part", TypesSetManually.DOUBLE);
        } else if ((system = function.system_function()) != null) {
            ret = new Pair<>(system.USER() != null ? "current_user"
                    : system.getChild(0).getText().toLowerCase(),
                    TypesSetManually.NAME);
        } else if ((datetime = function.date_time_function()) != null) {
            String colname;
            String coltype;
            if (datetime.CURRENT_DATE() != null) {
                colname = "date";
                coltype = TypesSetManually.DATE;
            } else if (datetime.CURRENT_TIME() != null) {
                colname = "timetz";
                coltype = TypesSetManually.TIMETZ;
            } else if (datetime.CURRENT_TIMESTAMP() != null) {
                colname = "now";
                coltype = TypesSetManually.TIMESTAMPTZ;
            } else if (datetime.LOCALTIME() != null) {
                colname = "time";
                coltype = TypesSetManually.TIME;
            } else if (datetime.LOCALTIMESTAMP() != null) {
                colname = "timestamp";
                coltype = TypesSetManually.TIMESTAMP;
            } else {
                Log.log(Log.LOG_WARNING, "No alternative in date_time_function!");
                colname = null;
                coltype = TypesSetManually.UNKNOWN;
            }
            ret = new Pair<>(colname, coltype);
        } else if ((string = function.string_value_function()) != null) {
            args = string.vex();
            Vex_bContext vexB = string.vex_b();
            if (vexB != null) {
                analyze(new Vex(vexB));
            }

            String colname = string.getChild(0).getText().toLowerCase();
            String coltype = TypesSetManually.TEXT;
            if (string.TRIM() != null) {
                if (string.LEADING() != null) {
                    colname = "ltrim";
                } else if (string.TRAILING() != null) {
                    colname = "rtrim";
                } else {
                    colname = "btrim";
                }
            } else if (string.POSITION() != null) {
                coltype = TypesSetManually.INTEGER;
            } else {
                // defaults work
            }
            ret = new Pair<>(colname, coltype);
        } else if ((xml = function.xml_function()) != null) {
            args = xml.vex();

            String colname = xml.getChild(0).getText().toLowerCase();
            String coltype = TypesSetManually.XML;
            if (xml.XMLEXISTS() != null) {
                coltype = TypesSetManually.BOOLEAN;
            } else if (xml.XMLSERIALIZE() != null) {
                Data_typeContext type = xml.data_type();
                coltype = ParserAbstract.getFullCtxText(type);
                addTypeDepcy(type);
            } else {
                // defaults work
            }
            ret = new Pair<>(colname, coltype);
        } else {
            Log.log(Log.LOG_WARNING, "No alternative in functionSpecial!");
            ret = new Pair<>(null, TypesSetManually.UNKNOWN);
        }

        if (args != null) {
            for (VexContext arg : args) {
                analyze(new Vex(arg));
            }
        }
        return ret;
    }

    /**
     * @param functionName called function bare name
     * @param sourceTypes call argument types
     * @param availableFunctions functions from applicable schemas
     * @return most suitable function to call or null,
     *      if none were found or an ambiguity was detected
     */
    private IFunction resolveCall(String functionName, List<String> sourceTypes,
            Stream<? extends IFunction> availableFunctions) {
        // save each applicable function with the number of exact type matches
        // between input args and function parameters
        // function that has more exact matches (less casts) wins
        List<Pair<IFunction, Integer>> matches = new ArrayList<>();
        for (IFunction f : PgDiffUtils.sIter(availableFunctions)) {
            if (!f.getBareName().equals(functionName)) {
                continue;
            }
            int argN = 0;
            int exactMatches = 0;
            boolean signatureApplicable = true;
            for (IArgument arg : PgDiffUtils.sIter(getInInoutFuncArgs(f))) {
                if (argN >= sourceTypes.size()) {
                    // supplied fewer arguments than function requires
                    // current (unsatisfied) parameter having a default value
                    // means that all the rest of parameters will also have default values
                    // because of ordering imposed by the standard
                    // thus, the function is applicable if the first unsatisfied parameter
                    // has a default value, and otherwise it is not
                    if (arg.getDefaultExpression() == null) {
                        signatureApplicable = false;
                    }
                    break;
                }
                String sourceType = sourceTypes.get(argN);
                if (sourceType.equals(arg.getDataType())) {
                    ++exactMatches;
                } else if (!systemStorage.containsCastImplicit(sourceType, arg.getDataType())) {
                    signatureApplicable = false;
                    break;
                }
                ++argN;
            }
            if (signatureApplicable) {
                if (exactMatches == argN && argN == sourceTypes.size()) {
                    // fast path for exact signature match
                    return f;
                }
                matches.add(new Pair<>(f, exactMatches));
            }
        }

        return matches.stream()
                .max((f1,f2) -> Integer.compare(f1.getSecond(), f2.getSecond()))
                .map(Pair::getFirst).orElse(null);
    }

    private Pair<String, String> operator(String operator, String... sourceArgsTypes) {
        // TODO When the user's operators will be also process by codeKeeper,
        // put in 'findFunctions' operator's schema name instead of 'PgSystemStorage.SCHEMA_PG_CATALOG'.
        IFunction resultOperFunction = resolveCall(operator, Arrays.asList(sourceArgsTypes),
                availableFunctions(PgSystemStorage.SCHEMA_PG_CATALOG));
        return new Pair<>(null, resultOperFunction != null ? resultOperFunction.getReturns()
                : TypesSetManually.FUNCTION_COLUMN);
    }

    private Stream<? extends IArgument> getInInoutFuncArgs(IFunction func) {
        return func.getArguments().stream()
                .filter(arg -> "IN".equals(arg.getMode()) || "INOUT".equals(arg.getMode()));
    }

    private TerminalNode getOperatorToken(Vex vex) {
        TerminalNode token = vex.getVexCtx().getChild(TerminalNode.class, 0);
        if (token == null) {
            return null;
        }
        switch (token.getSymbol().getType()) {
        case SQLParser.PLUS:
        case SQLParser.MINUS:
        case SQLParser.EXP:
        case SQLParser.MULTIPLY:
        case SQLParser.DIVIDE:
        case SQLParser.MODULAR:
            return token;
        default:
            return null;
        }
    }

    private Stream<? extends IFunction> availableFunctions(String schemaName) {
        if (schemaName != null) {
            ISchema schema = systemStorage.getSchema(schemaName);
            if (schema == null) {
                schema = db.getSchema(schemaName);
            }
            return schema.getFunctions().stream();
        } else {
            return Stream.concat(db.getSchema(schema).getFunctions().stream(),
                    systemStorage.getPgCatalog().getFunctions().stream());
        }
    }

    private String getFunctionReturns(IFunction f) {
        return f.getReturnsColumns().isEmpty() ? f.getReturns() : TypesSetManually.FUNCTION_TABLE;
    }

    public void orderBy(Orderby_clauseContext orderBy) {
        for (Sort_specifierContext sort : orderBy.sort_specifier_list().sort_specifier()) {
            analyze(new Vex(sort.vex()));
        }
    }

    public void window(Window_definitionContext window) {
        Partition_by_columnsContext partition = window.partition_by_columns();
        if (partition != null) {
            for (VexContext v : partition.vex()) {
                analyze(new Vex(v));
            }
        }

        Orderby_clauseContext orderBy = window.orderby_clause();
        if (orderBy != null) {
            orderBy(orderBy);
        }

        Frame_clauseContext frame = window.frame_clause();
        if (frame != null) {
            for (Frame_boundContext bound : frame.frame_bound()) {
                VexContext vex = bound.vex();
                if (vex != null) {
                    analyze(new Vex(vex));
                }
            }
        }
    }

    private void regCast(String s, String regcast) {
        switch (regcast) {
        case "regproc":
            // In this case, the function is not overloaded.
            addFunctionDepcyNotOverloaded(new QNameParser(s).getIds());
            break;
        case "regclass":
            addRelationDepcy(new QNameParser(s).getIds());
            break;
        case "regtype":
            // TODO pending DbObjType.TYPE
            break;

        case "regnamespace":
            addSchemaDepcy(new QNameParser(s).getIds());
            return;

        case "regprocedure":
            addFunctionSigDepcy(s);
            return;

        case "regoper":
        case "regoperator":
            // TODO pending DbObjType.OPERATOR
        default:
            return;
        }
    }

    private String literal(Unsigned_value_specificationContext unsignedValue){
        String ret;
        Unsigned_numeric_literalContext unsignedNumeric;
        General_literalContext generalLiteral;
        Truth_valueContext truthValue;

        if ((unsignedNumeric = unsignedValue.unsigned_numeric_literal()) != null) {
            if (unsignedNumeric.NUMBER_LITERAL() != null) {
                ret = TypesSetManually.INTEGER;
            } else {
                ret = TypesSetManually.NUMERIC;
            }

        } else {
            generalLiteral = unsignedValue.general_literal();

            if (generalLiteral.character_string() != null) {
                ret = TypesSetManually.TEXT;
            } else if ((truthValue = generalLiteral.truth_value()) != null) {
                if (truthValue.TRUE() != null || truthValue.FALSE() != null) {
                    ret = TypesSetManually.BOOLEAN;
                } else {
                    ret = TypesSetManually.TEXT;
                }
            } else {
                Log.log(Log.LOG_WARNING, "No alternative in general_literal!");
                ret = TypesSetManually.UNKNOWN;
            }
        }
        return ret;
    }

    private String stripBrackets(String type) {
        if (type.endsWith("[]")) {
            return type.substring(0, type.length() - 2);
        } else {
            return type;
        }
    }
}