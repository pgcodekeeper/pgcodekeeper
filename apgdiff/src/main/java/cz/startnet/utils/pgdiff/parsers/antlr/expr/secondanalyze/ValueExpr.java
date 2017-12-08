package cz.startnet.utils.pgdiff.parsers.antlr.expr.secondanalyze;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.SupportedVersion;
import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Array_bracketsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Array_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Case_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Cast_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Collate_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comparison_modContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Data_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Datetime_literalContext;
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
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Orderby_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Partition_by_columnsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Predefined_typeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Qualified_asteriskContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_name_nontypeContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sort_specifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.String_value_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_subqueryContext;
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
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgFunction;
import cz.startnet.utils.pgdiff.schema.PgFunction.Argument;
import cz.startnet.utils.pgdiff.schema.PgView;
import cz.startnet.utils.pgdiff.schema.system.PgSystemFunction;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStatement;
import cz.startnet.utils.pgdiff.schema.system.PgSystemStorage;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ValueExpr extends AbstractExpr {

    private PgView viewInProcessing;

    public ValueExpr(String schema, PgDatabase db, PgView viewInProcessing) {
        this(schema, db);
        this.viewInProcessing = viewInProcessing;
    }

    public ValueExpr(String schema, PgDatabase db) {
        super(schema, db);
    }

    protected ValueExpr(AbstractExpr parent) {
        super(parent);

        if (parent instanceof Select) {
            viewInProcessing = ((Select)parent).getViewInProcessing();
        } else if(parent instanceof ValueExpr) {
            viewInProcessing = ((ValueExpr)parent).getViewInProcessing();
        }
    }

    public PgView getViewInProcessing() {
        return viewInProcessing;
    }

    private List<Vex> addVexCtxtoList(List<Vex> l, List<VexContext> ctx) {
        int toAdd = ctx.size();
        if (toAdd != 0) {
            if (l == null) {
                l = new ArrayList<>(toAdd);
            }
            for (VexContext vexCtx : ctx) {
                l.add(new Vex(vexCtx));
            }
        }
        return l;
    }

    public Entry<String, String> analyze(Vex vex) {
        Entry<String, String> ret = null;
        Data_typeContext dataType = vex.dataType();
        @SuppressWarnings("unused")
        // TODO OpCtx user-operator reference
        Collate_identifierContext collate;
        Select_stmt_no_parensContext selectStmt;
        Datetime_overlapsContext overlaps;
        Value_expression_primaryContext primary;
        boolean doneWork = true;
        List<Entry<String, String>> operandsList;

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
                        && literal.Character_String_Literal() != null) {
                    regCast(PgDiffUtils.unquoteQuotedString(literal.getText()),
                            customType.getText());
                }
            }

            ret = new SimpleEntry<>(null, ParserAbstract.getFullCtxText(dataType));
        } else if ((collate = vex.collateIdentifier()) != null) {
            // TODO pending DbObjType.COLLATION
            ret = new SimpleEntry<>(null, "boolean");
        } else if (vex.in() != null && vex.leftParen() != null && vex.rightParen() != null &&
                (selectStmt = vex.selectStmt()) != null) {
            new Select(this).analyze(selectStmt);
            ret = new SimpleEntry<>(null, "unknown");
        } else if (vex.in() != null && vex.leftParen() != null && vex.rightParen() != null &&
                (selectStmt = vex.selectStmt()) == null) {
            ret = new SimpleEntry<>(null, "unknown");
        } else if ((overlaps = vex.datetimeOverlaps()) != null) {
            for (VexContext v : overlaps.vex()) {
                analyze(new Vex(v));
            }
            ret = new SimpleEntry<>(null, "boolean");
        } else if (vex.leftBracket() != null && vex.rightBracket() != null) {
            if(vex.colon() == null){
                ret = operandsList.get(0);
                ret.setValue(bracketProcessing(ret.getValue()));
            } else {
                ret = operandsList.get(0);
            }
        } else if (vex.plus() != null || vex.minus() != null) {
            if(operandsList.size() == 2){
                ret = cast(operandsList.get(0), operandsList.get(1));
            } else{
                ret = operandsList.get(0);
            }
        } else if ( (vex.timeZone() != null)
                || (vex.in() == null && vex.leftParen() != null && vex.rightParen() != null) ) {
            ret = operandsList.get(0);
        } else if (vex.exp() != null || vex.multiply() != null || vex.divide() != null || vex.modular() != null) {
            ret = cast(operandsList.get(0), operandsList.get(1));
        } else if (vex.op() != null) {
            ret = new SimpleEntry<>(null, "unknown");
        } else if ((vex.is() != null && (vex.truthValue() != null || vex.nullValue() != null) )
                || (vex.is() != null && vex.distinct() != null)
                || (vex.not() != null && vex.in() == null)
                || vex.between() != null
                || vex.like() != null
                || vex.ilike() != null
                || vex.similar() != null
                || vex.lth() != null
                || vex.gth() != null
                || vex.leq() != null
                || vex.geq() != null
                || vex.equal() != null
                || vex.notEqual() != null
                || vex.isNull() != null
                || vex.notNull() != null
                || vex.and() != null
                || vex.or() != null ) {
            ret = new SimpleEntry<>(null, "boolean");
        } else if ((primary = vex.primary()) != null) {
            Select_stmt_no_parensContext subSelectStmt = primary.select_stmt_no_parens();
            Case_expressionContext caseExpr;
            Cast_specificationContext cast;
            Comparison_modContext compMod;
            Table_subqueryContext subquery;
            Function_callContext function;
            Schema_qualified_nameContext qname;
            Indirection_identifierContext indirection;
            @SuppressWarnings("unused")
            Qualified_asteriskContext ast;
            Array_expressionContext array;
            Type_coercionContext typeCoercion;
            Unsigned_value_specificationContext unsignedValue;

            if(primary.NULL() != null){
                ret = new SimpleEntry<>(null, "NULL");
            } else if((unsignedValue = primary.unsigned_value_specification()) != null){
                ret = new SimpleEntry<>(null, unsigned(unsignedValue));
            } else if (primary.LEFT_PAREN() != null && primary.RIGHT_PAREN() != null &&
                    subSelectStmt != null) {
                List<Entry<String, String>> colsList = new Select(this).analyze(subSelectStmt);
                if(colsList.size() == 1) {
                    ret = new SimpleEntry<>(null, colsList.get(0).getValue());
                } else {
                    ret = new SimpleEntry<>(null, "unknown");
                }
            } else if ((caseExpr = primary.case_expression()) != null) {
                List<Vex> subOperands = null;
                subOperands = addVexCtxtoList(subOperands, caseExpr.vex());
                if (subOperands != null) {
                    for (Vex v : subOperands) {
                        analyze(v);
                    }
                }
                ret = new SimpleEntry<>(null, "boolean");
            } else if ((cast = primary.cast_specification()) != null) {
                ret = analyze(new Vex(cast.vex()));
                Data_typeContext dataTypeCtx = cast.data_type();
                ret.setValue(dataTypeCtx.getText());
                addTypeDepcy(dataTypeCtx);
            } else if ((compMod = primary.comparison_mod()) != null) {
                VexContext compModVex = compMod.vex();
                if (compModVex != null) {
                    ret = analyze(new Vex(compModVex));
                    ret.setValue(bracketProcessing(ret.getValue()));
                } else {
                    new Select(this).analyze(compMod.select_stmt_no_parens());
                    ret = new SimpleEntry<>(null, "unknown");
                }
            } else if (primary.EXISTS() != null &&
                    (subquery = primary.table_subquery()) != null) {
                new Select(this).analyze(subquery.select_stmt());
                ret = new SimpleEntry<>(null, "boolean");
            } else if ((function = primary.function_call()) != null) {
                ret = function(function);
            } else if ((qname = primary.schema_qualified_name()) != null) {
                ret = addColumnDepcy(qname);
            } else if ((indirection = primary.indirection_identifier()) != null) {
                analyze(new Vex(indirection.vex()));
            } else if ((ast = primary.qualified_asterisk()) != null) {
                // TODO pending full analysis
                ret = new SimpleEntry<>(null, "qualifiedAsterisk");
            } else if ((array = primary.array_expression()) != null) {
                Array_bracketsContext arrayb = array.array_brackets();
                if (arrayb != null) {
                    List<VexContext> arraybVexCtxList = arrayb.vex();
                    ret = analyze(new Vex(arraybVexCtxList.get(0)));
                } else {
                    new Select(this).analyze(array.array_query().table_subquery().select_stmt());
                    ret = new SimpleEntry<>(null, "unknown[]");
                }
            } else if ((typeCoercion = primary.type_coercion()) != null) {
                Data_typeContext coercionDataType = typeCoercion.data_type();
                addTypeDepcy(coercionDataType);
                ret = new SimpleEntry<>(null, ParserAbstract.getFullCtxText(coercionDataType));
            }
        } else {
            doneWork = false;
        }

        if (!doneWork) {
            Log.log(Log.LOG_WARNING, "No alternative in Vex!");
        }

        return ret;
    }


    /**
     * @return function reference or null for internal functions
     */
    public Entry<String, String> function(Function_callContext function) {
        Entry<String, String> pair = new SimpleEntry<>(null, "functionCol");
        List<Vex> args = null;
        List<VexContext> argsCtx = null;

        Function_nameContext name = function.function_name();

        Extract_functionContext extract;
        String_value_functionContext string;
        Xml_functionContext xml;

        boolean canFindFunctionSignature = false;

        if (name != null) {
            argsCtx = function.vex();
            args = addVexCtxtoList(args, argsCtx);

            canFindFunctionSignature = true;

            Orderby_clauseContext orderBy = function.orderby_clause();
            if (orderBy != null) {
                orderBy(orderBy);
            }
            Filter_clauseContext filter = function.filter_clause();
            if (filter != null) {
                pair = analyze(new Vex(filter.vex()));
            }
            Window_definitionContext window = function.window_definition();
            if (window != null) {
                window(window);
            }
        } else if ((extract = function.extract_function()) != null) {
            pair = analyze(new Vex(extract.vex()));
        } else if ((string = function.string_value_function()) != null) {
            args = addVexCtxtoList(args, string.vex());

            Vex_bContext vexB = string.vex_b();
            if (vexB != null) {
                pair = analyze(new Vex(vexB));
            }
        } else if ((xml = function.xml_function()) != null) {
            args = addVexCtxtoList(args, xml.vex());
        }

        List<Entry<String, String>> argsType = new ArrayList<>();
        if (args != null) {
            for (Vex v : args) {
                argsType.add(analyze(v));
            }
        }

        if (canFindFunctionSignature) {
            pair = setReturnedTypeOfFunction(name, argsType, argsCtx, pair);

        }

        return pair;
    }

    private Entry<String, String> setReturnedTypeOfFunction(Function_nameContext name,
            List<Entry<String, String>> argsType, List<VexContext> argsCtx, Entry<String, String> pair) {
        String funcName = name.getText();

        List<String> types = argsType.stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append(funcName);
        sb.append("(");
        for (int i = 0; types.size() > i; i++) {
            sb.append(types.get(i));
            if (types.size() != (i+1)) {
                sb.append(", ");
            }
        }
        sb.append(")");
        String functionSignature = sb.toString();

        boolean isUserFunction = false;

        List<PgFunction> userFunctionsList = new ArrayList<>();
        for(PgFunction f : db.getSchema(schema).getFunctions()) {
            if (funcName.equals(f.getBareName())
                    && (types.size() == f.getArguments().size())) {
                userFunctionsList.add(f);
            }
        }

        isUserFunction = !userFunctionsList.isEmpty();

        // TODO get postgresql version.
        // Need to get version. I can get it from JdbcLoader(READER),
        // but I can't get it from PgDumpLoader(WRITER).
        PgSystemStorage storage = PgSystemStorage.getObjectsFromResources(SupportedVersion.VERSION_9_5);

        boolean doesItNeedCast = true;
        if (isUserFunction) {
            for(PgFunction f : userFunctionsList) {
                if (functionSignature.equals(f.getName())) {
                    pair = new SimpleEntry<>(funcName, f.getReturns());
                    doesItNeedCast = false;
                    break;
                }
            }
        }

        if (doesItNeedCast && isUserFunction) {
            List<String> castArgumentsResult = new ArrayList<>();
            String negativeResult = "-";

            for (PgFunction f : userFunctionsList) {
                castArgumentsResult.clear();
                List<Argument> argsOfUserFunction = f.getArguments();

                for (int i = 0; argsCtx.size() > i; i++) {
                    String castCtx = PgSystemStorage.castFunctionArguments(storage,
                            argsOfUserFunction.get(i).getDataType(), types.get(i));

                    castArgumentsResult.add(castCtx != null ? castCtx : negativeResult);
                }

                if (!castArgumentsResult.contains(negativeResult)) {
                    pair = new SimpleEntry<>(funcName, f.getReturns());
                    break;
                }
            }
        }

        if (!isUserFunction) {
            PgSystemStatement systemStmt = PgSystemStorage.getPgSystemStatement(storage, DbObjType.FUNCTION, funcName);
            if (systemStmt != null) {
                PgSystemFunction systemFunc = (PgSystemFunction) systemStmt;
                pair = new SimpleEntry<>(funcName, systemFunc.getReturnType());
            }
        }

        Data_typeContext type = name.data_type();
        Schema_qualified_name_nontypeContext funcNameCtx;
        if (type != null &&
                (funcNameCtx = type.predefined_type().schema_qualified_name_nontype()) != null) {
            addFunctionDepcy(funcNameCtx, functionSignature);
        }

        return pair;
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
        DbObjType regcastType;
        switch (regcast) {
        case "regproc":
            regcastType = DbObjType.FUNCTION;
            break;
        case "regclass":
            regcastType = DbObjType.TABLE;
            break;
        case "regtype":
            regcastType = DbObjType.TYPE;
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

        addObjectDepcy(new QNameParser(s).getIds(), regcastType);
    }

    private String unsigned(Unsigned_value_specificationContext unsignedValue){
        String ret = null;
        Unsigned_numeric_literalContext unsignedNumeric;
        General_literalContext generalLiteral;
        Datetime_literalContext dateTime;
        Truth_valueContext truthValue;

        if((unsignedNumeric = unsignedValue.unsigned_numeric_literal()) != null){
            if(unsignedNumeric.NUMBER_LITERAL() != null){
                ret = "integer";
            } else {
                ret = "double precision";
            }

        } else {
            generalLiteral = unsignedValue.general_literal();

            if(generalLiteral.Character_String_Literal() != null){
                ret = "text";
            } else if((dateTime = generalLiteral.datetime_literal()) != null) {
                ret = ParserAbstract.getFullCtxText(dateTime);
            } else if((truthValue = generalLiteral.truth_value()) != null){
                if(truthValue.TRUE() != null || truthValue.FALSE() != null){
                    ret = "boolean";
                } else {
                    ret = "text";
                }
            }
        }
        return ret;
    }

    private String bracketProcessing(Object obj) {
        String type = (String) obj;
        if(type.endsWith("[]")){
            Log.log(Log.LOG_WARNING, "The type '" + type + "' had brackets!");
            return type.substring(0, type.indexOf("[]"));
        } else {
            return type;
        }
    }


    private Entry<String, String> cast(Entry<String, String> ret1, Entry<String, String> ret2) {
        String firstType = ret1.getValue();
        String secondType = ret2.getValue();

        Entry<String, String> ret =  new SimpleEntry<>(null, "unknown");

        if(!"unknown".equalsIgnoreCase(firstType) && "unknown".equalsIgnoreCase(secondType)){
            ret.setValue(firstType);
        } else if("unknown".equalsIgnoreCase(firstType) && !"unknown".equalsIgnoreCase(secondType)){
            ret.setValue(secondType);
        } else if(!"unknown".equalsIgnoreCase(firstType) && !"unknown".equalsIgnoreCase(secondType)){
            if("double precision".equalsIgnoreCase(firstType)
                    || "float8".equalsIgnoreCase(firstType)
                    || "double precision".equalsIgnoreCase(secondType)
                    || "float8".equalsIgnoreCase(secondType)){
                ret.setValue("double precision");
            } else if("real".equalsIgnoreCase(firstType)
                    || "float4".equalsIgnoreCase(firstType)
                    || "real".equalsIgnoreCase(secondType)
                    || "float4".equalsIgnoreCase(secondType)){
                ret.setValue("real");
            } else if("bigint".equalsIgnoreCase(firstType)
                    || "int8".equalsIgnoreCase(firstType)
                    || "bigint".equalsIgnoreCase(secondType)
                    || "int8".equalsIgnoreCase(secondType)){
                ret.setValue("bigint");
            } else if("integer".equalsIgnoreCase(firstType)
                    || "int4".equalsIgnoreCase(firstType)
                    || "int".equalsIgnoreCase(firstType)
                    || "integer".equalsIgnoreCase(secondType)
                    || "int4".equalsIgnoreCase(secondType)
                    || "int".equalsIgnoreCase(secondType)){
                ret.setValue("integer");
            } else if("smallint".equalsIgnoreCase(firstType)
                    || "int2".equalsIgnoreCase(firstType)
                    || "smallint".equalsIgnoreCase(secondType)
                    || "int2".equalsIgnoreCase(secondType)){
                ret.setValue("smallint");
            } else if("bytea".equalsIgnoreCase(firstType)
                    || "bytea".equalsIgnoreCase(secondType)){
                ret.setValue("bytea");
            }
        }
        return ret;
    }
}