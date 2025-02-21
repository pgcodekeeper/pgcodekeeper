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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Array_elementsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Array_expressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Case_expressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Cast_specificationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Col_labelContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Comparison_modContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Data_typeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Date_time_functionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Datetime_overlapsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Expr_constContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Extract_functionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Filter_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Frame_boundContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Frame_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_callContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_constructContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.IndirectionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Indirection_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Indirection_varContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Json_columnsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Json_functionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Json_return_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Merge_support_functionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.OpContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Orderby_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Partition_by_columnsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_qualified_name_nontypeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.SconstContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_stmt_no_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Sort_specifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.String_value_functionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.System_functionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Table_subqueryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Truth_valueContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Type_coercionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Type_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Value_expression_primaryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.VexContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Vex_bContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Vex_or_named_notationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Window_definitionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Xml_functionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Xml_table_columnContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.Vex;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.PgParserAbstract;
import ru.taximaxim.codekeeper.core.schema.Argument;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IFunction;
import ru.taximaxim.codekeeper.core.schema.IOperator;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.ModPair;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class ValueExpr extends AbstractExpr {

    private static final Logger LOG = LoggerFactory.getLogger(ValueExpr.class);

    public ValueExpr(MetaContainer meta) {
        super(meta);
    }

    protected ValueExpr(AbstractExpr parent) {
        super(parent);
    }

    protected ValueExpr(AbstractExpr parent, Set<PgObjLocation> depcies) {
        super(parent, depcies);
    }

    /*
        Alternative checks are ordered for performance according to their usage frequency in real code.
        Statistics gathered on the internal DB codebase as of 2019-10-16.
        Also note that some checks are constrained by the grammar to go before others.
        Otherwise some alternatives would be mis-processed as a wrong kind.

        collate          1
        isnull           3
        similar          6
        ilike          140
        between        181
        like           239
        leq            311
        not            328
        geq            422
        lth            468
        in             622
        gth            737
        neq           1456
        or            1525
        op base       2404
        is            3992
        parens        5688
        op full       6302
        and           7594
        eq           17496
        cast         18050
        primary     192884
     */
    public ModPair<String, String> analyze(Vex vex) {
        List<Vex> operandVexs = vex.vex();
        if (operandVexs.isEmpty()) {
            Value_expression_primaryContext primary = vex.primary();
            if (primary != null) {
                return primary(primary);
            }
        }

        List<ModPair<String, String>> operandsList = new ArrayList<>(operandVexs.size());
        for (Vex operand : operandVexs) {
            operandsList.add(analyze(operand));
        }

        Data_typeContext dataType = vex.dataType();
        if (dataType != null) {
            cast(operandVexs.get(0), dataType);
            ModPair<String, String> ret = operandsList.get(0);
            ret.setSecond(ParserAbstract.getFullCtxText(dataType));
            return ret;
        }

        if (vex.equal() != null || vex.and() != null) {
            // BETWEEN is handled as AND, no separate processing required
            return new ModPair<>(NONAME, TypesSetManually.BOOLEAN);
        }

        OpContext op = vex.op();
        String operator = null;
        if (op != null || (operator = getOperatorToken(vex)) != null) {
            return op(vex, operandsList, operator, op);
        }

        if (vex.leftParen() != null) {
            if (vex.in() != null) {
                Select_stmt_no_parensContext selectStmt = vex.selectStmt();
                if (selectStmt != null) {
                    new Select(this).analyze(selectStmt);
                }
                return new ModPair<>(NONAME, TypesSetManually.BOOLEAN);
            }

            Type_listContext typeList = vex.typeList();
            if (typeList != null) {
                for (Data_typeContext type : typeList.data_type()) {
                    addTypeDepcy(type);
                }
                return new ModPair<>(NONAME, TypesSetManually.BOOLEAN);
            }

            if (operandsList.size() == 1) {
                ModPair<String, String> ret = operandsList.get(0);
                Indirection_listContext indir = vex.indirectionList();
                if (indir != null) {
                    indirection(indir.indirection(), ret);
                    if (indir.MULTIPLY() != null) {
                        ret = new ModPair<>(NONAME, TypesSetManually.QUALIFIED_ASTERISK);
                    }
                }
                return ret;
            }
            // TODO add record type placeholder?
            return new ModPair<>("row", TypesSetManually.UNKNOWN);
        }

        if (vex.is() != null
                || vex.or() != null
                || vex.notEqual() != null
                || vex.gth() != null
                || vex.lth() != null
                || vex.geq() != null
                || vex.leq() != null
                || vex.like() != null
                || vex.ilike() != null
                || vex.similar() != null
                || vex.isNull() != null
                || vex.not() != null
                || vex.notNull() != null) {
            // check IS after "OF ( type_list )"
            // check unary NOT after all NOT-containing alternatives
            return new ModPair<>(NONAME, TypesSetManually.BOOLEAN);
        }

        if (vex.collateIdentifier() != null) {
            var collationCtx = vex.collateIdentifier().collation;
            var ids = PgParserAbstract.getIdentifiers(collationCtx);
            addDepcy(ids, DbObjType.COLLATION, collationCtx.getStart());
            return operandsList.get(0);
        }

        if (vex.timeZone() != null) {
            return operandsList.get(0);
        }

        LOG.warn("No alternative in Vex!");
        return new ModPair<>(NONAME, TypesSetManually.UNKNOWN);
    }

    private void cast(Vex operand, Data_typeContext dataType) {
        addTypeDepcy(dataType);
        Schema_qualified_name_nontypeContext customType = dataType.predefined_type().schema_qualified_name_nontype();
        IdentifierContext typeSchema = customType == null ? null : customType.identifier();
        // TODO remove when tokens are refactored
        if (customType != null && (typeSchema == null || Consts.PG_CATALOG.equals(typeSchema.getText()))
                && dataType.ARRAY() == null && dataType.array_type().isEmpty() && dataType.SETOF() == null) {
            // check simple built-in types for reg*** casts
            Value_expression_primaryContext castPrimary = operand.primary();
            if (castPrimary == null) {
                return;
            }
            Expr_constContext exprConst = castPrimary.expr_const();
            if (exprConst == null) {
                return;
            }

            SconstContext stringConst = exprConst.sconst();
            if (stringConst != null) {
                regCast(stringConst, customType.getText());
            }
        }
    }

    private ModPair<String, String> op(Vex vex, List<ModPair<String, String>> operandsList,
            String operator, OpContext op) {
        String schema = Consts.PG_CATALOG;
        ParserRuleContext ctx = null;
        if (op != null) {
            IdentifierContext opSchemaCtx = op.identifier();
            if (opSchemaCtx == null) {
                ctx = op.op_chars();
                operator = ctx.getText();
            } else {
                schema = opSchemaCtx.getText();
                addDepcy(new GenericColumn(schema, DbObjType.SCHEMA), opSchemaCtx);
                ctx = op.all_simple_op();
                operator = ctx.getText();
            }
        }

        String larg = null;
        String rarg = null;
        if (operandsList.size() == 2) {
            larg = operandsList.get(0).getSecond();
            rarg = operandsList.get(1).getSecond();
        } else if (op == null || vex.getVexCtx().getChild(0) instanceof OpContext) {
            rarg = operandsList.get(0).getSecond();
        } else {
            larg = operandsList.get(0).getSecond();
        }
        IOperator resultOperFunction = resolveOperatorsCall(operator, larg, rarg,
                availableOperators(schema));

        if (resultOperFunction != null) {
            addDepcy(new GenericColumn(resultOperFunction.getSchemaName(),
                    resultOperFunction.getName(), DbObjType.OPERATOR), ctx);

            String returns =  resultOperFunction.getReturns();
            if (returns == null) {
                returns = TypesSetManually.FUNCTION_COLUMN;
            }

            return new ModPair<>(NONAME, returns);
        }

        return new ModPair<>(NONAME, TypesSetManually.FUNCTION_COLUMN);
    }

    /*
        Usage frequency in internal DB codebase.
        coercion            54
        asterisk           306
        array              392
        compmod            399
        select             516
        exists             551
        case              2281
        NULL              5507
        function         25665
        unsigned         39816
        indirection     117397
     */
    private ModPair<String, String> primary(Value_expression_primaryContext primary) {
        ModPair<String, String> ret;
        Indirection_varContext indirection = primary.indirection_var();
        Expr_constContext unsignedValue;
        Select_stmt_no_parensContext subSelectStmt;
        Case_expressionContext caseExpr;
        Comparison_modContext compMod;
        Table_subqueryContext subquery;
        Function_callContext function;
        Array_expressionContext array;
        Type_coercionContext typeCoercion;
        Datetime_overlapsContext overlaps;

        if (indirection != null) {
            ret = indirectionVar(indirection);
        } else if ((unsignedValue = primary.expr_const()) != null) {
            ret = new ModPair<>(NONAME, literal(unsignedValue));
        } else if ((function = primary.function_call()) != null) {
            ret = function(function);
        } else if (primary.NULL() != null) {
            ret = new ModPair<>(NONAME, TypesSetManually.ANYTYPE);
        } else if ((caseExpr = primary.case_expression()) != null) {
            ret = null;
            for (VexContext v : caseExpr.vex()) {
                // we need the Pair of the last expression (ELSE)
                ret = analyze(new Vex(v));
            }
            if (ret.getFirst() == null || caseExpr.ELSE() == null) {
                // CASE inherits its name only from the ELSE expression
                // if it is missing or doesn't carry any name, the name becomes "case"
                ret.setFirst("case");
            }
        } else if ((subquery = primary.table_subquery()) != null) {
            new Select(this).analyze(subquery.select_stmt());
            ret = new ModPair<>("exists", TypesSetManually.BOOLEAN);
        } else if ((subSelectStmt = primary.select_stmt_no_parens()) != null) {
            Select select = new Select(this);
            ret = getSubselectColumn(select.analyze(subSelectStmt));
            Indirection_listContext indir = primary.indirection_list();
            if (indir != null) {
                indirection(indir.indirection(), ret);
                if (indir.MULTIPLY() != null) {
                    ret = new ModPair<>(NONAME, TypesSetManually.QUALIFIED_ASTERISK);
                }
            }
        } else if ((compMod = primary.comparison_mod()) != null) {
            // type doesn't matter since this is not a real expression
            // this is always an operand of comparison operator, which will reset the type
            ret = new ModPair<>(NONAME, TypesSetManually.UNKNOWN);
            VexContext compModVex = compMod.vex();
            if (compModVex != null) {
                analyze(new Vex(compModVex));
            } else {
                new Select(this).analyze(compMod.select_stmt_no_parens());
            }
        } else if ((array = primary.array_expression()) != null) {
            Array_elementsContext elements = array.array_elements();
            if (elements != null) {
                ret = arrayElements(elements);
            } else {
                Select select = new Select(this);
                ret = getSubselectColumn(select.analyze(array.table_subquery().select_stmt()));
            }
            ret.setFirst("array");
            ret.setSecond(ret.getSecond() + "[]");
        } else if (primary.MULTIPLY() != null) {
            // handled in Select analyzer
            ret = new ModPair<>(NONAME, TypesSetManually.QUALIFIED_ASTERISK);
        } else if ((typeCoercion = primary.type_coercion()) != null) {
            String type;
            if (typeCoercion.INTERVAL() != null) {
                type = "interval";
            } else {
                Data_typeContext coercionDataType = typeCoercion.data_type();
                addTypeDepcy(coercionDataType);
                type = PgParserAbstract.getTypeName(coercionDataType);
            }
            // since this cast can only convert string literals into a type
            // column name here will always be derived from type name
            ret = new ModPair<>(type, type);
        } else if ((overlaps = primary.datetime_overlaps()) != null) {
            for (VexContext v : overlaps.vex()) {
                analyze(new Vex(v));
            }
            ret = new ModPair<>("overlaps", TypesSetManually.BOOLEAN);
        } else {
            LOG.warn("No alternative in Vex Primary!");
            ret = new ModPair<>(NONAME, TypesSetManually.UNKNOWN);
        }
        return ret;
    }

    private ModPair<String, String> getSubselectColumn(
            List<ModPair<String, String>> list) {
        if (list.isEmpty()) {
            LOG.warn("Subselect return 0 element");
            return new ModPair<>(NONAME, TypesSetManually.UNKNOWN);
        }
        return list.get(0);
    }

    private ModPair<String, String> indirectionVar(Indirection_varContext indirection) {
        ParserRuleContext id = indirection.identifier();
        if (id == null) {
            id = indirection.dollar_number();
        }

        Indirection_listContext indirList = indirection.indirection_list();
        if (indirList == null) {
            return processTablelessColumn(id);
        }

        List<IndirectionContext> indir = indirList.indirection();
        if (indirList.MULTIPLY() != null) {
            indirection(indir, null);
            return new ModPair<>(NONAME, TypesSetManually.QUALIFIED_ASTERISK);
        }
        /*
        String columnName = id.getText();
        String columnParent = null;
        String schemaName = null;
        int i = 0;
        for (; i < indir.size(); ++i) {
            switch (i) {

            }
        }
         */
        // reserve space for longest-yet-still-common case
        // this list has minimal size of 1, may as well reserve 3
        List<ParserRuleContext> ids = new ArrayList<>(3);
        ids.add(id);

        for (IndirectionContext ind : indir) {
            Col_labelContext label = ind.col_label();
            if (label == null) {
                break;
            }
            ids.add(label);
        }

        ModPair<String, String> ret;
        if (ids.size() > 3) {
            LOG.warn("Very long indirection!");
            ret = new ModPair<>(NONAME, TypesSetManually.UNKNOWN);
        } else {
            ret = processColumn(ids);
        }

        int consumedIndirs = ids.size() - 1;
        if (consumedIndirs != indir.size()) {
            indirection(indir.subList(consumedIndirs, indir.size()), ret);
        }

        return ret;
    }

    /**
     * @param left signature of the expression on which the indirection is executed <br>
     *              modified by each step in indirection analysis <br>
     *              may be null if indirection result is not interesting (e.g. predetermined)
     */
    private void indirection(List<IndirectionContext> indirection, ModPair<String, String> left) {
        for (IndirectionContext ind : indirection) {
            if (ind.LEFT_BRACKET() != null) {
                for (VexContext v : ind.vex()) {
                    analyze(new Vex(v));
                }
                if (left != null) {
                    left.setSecond(stripBrackets(left.getSecond()));
                }
            } else if (left != null) {
                // indirection by id, unsupported
                left.setFirst(null);
                left.setSecond(TypesSetManually.UNKNOWN);
            }
        }
    }

    private ModPair<String, String> arrayElements(Array_elementsContext elements) {
        ModPair<String, String> ret = null;
        for (Array_elementsContext sub : elements.array_elements()) {
            ret = arrayElements(sub);
        }

        for (VexContext vex : elements.vex()) {
            ret = analyze(new Vex(vex));
        }

        return ret != null ? ret : new ModPair<>(NONAME, TypesSetManually.UNKNOWN);
    }

    /**
     * @return return signature
     */
    public ModPair<String, String> function(Function_callContext function) {
        Schema_qualified_name_nontypeContext funcNameCtx = function.schema_qualified_name_nontype();
        if (funcNameCtx == null) {
            return functionSpecial(function);
        }

        for (Orderby_clauseContext orderBy : function.orderby_clause()) {
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
        List<ParserRuleContext> ids = PgParserAbstract.getIdentifiers(funcNameCtx);
        String functionName = QNameParser.getFirstName(ids);

        ParserRuleContext id = QNameParser.getSchemaNameCtx(ids);
        if (id != null) {
            schemaName = id.getText();
            addDepcy(new GenericColumn(schemaName, DbObjType.SCHEMA), id);
        }

        List<Vex_or_named_notationContext> args = function.vex_or_named_notation();

        // all sequential args go before named args
        // so we can ignore the order of latter and collect them into a map
        List<String> argsType = new ArrayList<>(args.size());
        Map<String, String> argsName = new HashMap<>();
        for (Vex_or_named_notationContext arg : args) {
            String argType = analyze(new Vex(arg.vex())).getSecond();
            // strip once before calling resolveCall
            argType = stripParens(argType);

            IdentifierContext argnameCtx = arg.identifier();
            if (argnameCtx != null) {
                String argname = argnameCtx.getText();
                if (argsName.put(argname, argType) != null) {
                    LOG.warn("Duplicate values for function named arg: {}", argname);
                }
            } else {
                argsType.add(argType);
            }
        }

        Collection<IFunction> functions = availableFunctions(schemaName);

        if (args.size() == 1 && argsType.size() == 1
                && TypesSetManually.QUALIFIED_ASTERISK.equals(argsType.get(0))) {
            //// In this case function's argument is '*' or 'source.*'.

            IFunction func = null;
            for (IFunction f : functions) {
                if (f.getArguments().size() == 1
                        && f.getArguments().get(0).getMode().isIn()
                        && f.getBareName().equals(functionName)) {
                    if (func != null) {
                        // ambiguous call
                        func = null;
                        break;
                    }
                    func = f;
                }
            }

            return new ModPair<>(functionName, func != null ?
                    getFunctionReturns(func) : TypesSetManually.FUNCTION_COLUMN);
        }

        IFunction resultFunction = resolveCall(functionName, argsType, argsName, functions);
        if (resultFunction != null) {
            addFunctionDepcy(resultFunction, QNameParser.getFirstNameCtx(ids));
            return new ModPair<>(functionName, getFunctionReturns(resultFunction));
        }

        return new ModPair<>(functionName, TypesSetManually.FUNCTION_COLUMN);
    }

    private ModPair<String, String> functionSpecial(Function_callContext function) {
        ModPair<String, String> ret;
        List<VexContext> args = null;

        Extract_functionContext extract;
        System_functionContext system;
        Date_time_functionContext datetime;
        String_value_functionContext string;
        Xml_functionContext xml;
        Json_functionContext json;
        Function_constructContext con;
        Merge_support_functionContext mer;

        if ((extract = function.extract_function()) != null) {
            analyze(new Vex(extract.vex()));
            // parser defines this as a call to an overload of pg_catalog.date_part
            ret = new ModPair<>("date_part", TypesSetManually.DOUBLE);
        } else if ((system = function.system_function()) != null) {
            Cast_specificationContext cast = system.cast_specification();
            if (cast != null) {
                ret = analyze(new Vex(cast.vex()));
                Data_typeContext dataTypeCtx = cast.data_type();
                ret.setSecond(PgParserAbstract.getTypeName(dataTypeCtx));
                addTypeDepcy(dataTypeCtx);
            } else {
                ret = new ModPair<>(system.USER() != null ? "current_user"
                        : system.getChild(0).getText().toLowerCase(Locale.ROOT),
                        TypesSetManually.NAME);
            }
        } else if ((datetime = function.date_time_function()) != null) {
            ret = analyzeDate(datetime);
        } else if ((string = function.string_value_function()) != null) {
            args = string.vex();
            ret = analyzeString(string);
        } else if ((xml = function.xml_function()) != null) {
            args = xml.vex();
            ret = analyzeXml(args, xml);
        } else if ((json = function.json_function()) != null) {
            args = new ArrayList<>();
            ret = analyzeJson(args, json);
        } else if ((mer = function.merge_support_function()) != null) {
            String colname = mer.getChild(0).getText().toLowerCase(Locale.ROOT);
            ret = new ModPair<>(colname, TypesSetManually.TEXT);
        } else if ((con = function.function_construct()) != null) {
            args = con.vex();

            String colname = con.getChild(0).getText().toLowerCase(Locale.ROOT);
            String coltype;
            if (con.XMLCONCAT() != null) {
                coltype = TypesSetManually.XML;
            } else if (con.ROW() != null) {
                coltype = TypesSetManually.UNKNOWN;
            } else if (con.GROUPING() != null) {
                coltype = TypesSetManually.INTEGER;
            } else {
                VexContext vex = args.get(0);
                args = args.subList(1, args.size());
                coltype = analyze(new Vex(vex)).getSecond();
            }
            ret = new ModPair<>(colname, coltype);
        } else {
            LOG.warn("No alternative in functionSpecial!");
            ret = new ModPair<>(NONAME, TypesSetManually.UNKNOWN);
        }

        if (args != null) {
            for (VexContext arg : args) {
                analyze(new Vex(arg));
            }
        }
        return ret;
    }

    private ModPair<String, String> analyzeString(String_value_functionContext string) {
        Vex_bContext vexB = string.vex_b();
        if (vexB != null) {
            analyze(new Vex(vexB));
        }

        String colname = string.getChild(0).getText().toLowerCase(Locale.ROOT);
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
        }

        return new ModPair<>(colname, coltype);
    }

    private ModPair<String, String> analyzeXml(List<VexContext> args, Xml_functionContext xml) {
        String coltype = TypesSetManually.XML;
        if (xml.XMLEXISTS() != null) {
            coltype = TypesSetManually.BOOLEAN;
        } else if (xml.XMLSERIALIZE() != null) {
            Data_typeContext type = xml.data_type();
            coltype = PgParserAbstract.getTypeName(type);
            addTypeDepcy(type);
        } else if (xml.XMLTABLE() != null) {
            for (Xml_table_columnContext col : xml.xml_table_column()) {
                args.addAll(col.vex());
                Data_typeContext type = col.data_type();
                if (type != null) {
                    addTypeDepcy(col.data_type());
                }
            }
            coltype = TypesSetManually.FUNCTION_TABLE;
        }

        String colname = xml.getChild(0).getText().toLowerCase(Locale.ROOT);
        return new ModPair<>(colname, coltype);
    }

    private ModPair<String, String> analyzeDate(Date_time_functionContext datetime) {
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
            LOG.warn("No alternative in date_time_function!");
            colname = NONAME;
            coltype = TypesSetManually.UNKNOWN;
        }
        return new ModPair<>(colname, coltype);
    }

    private ModPair<String, String> analyzeJson(List<VexContext> args, Json_functionContext json) {
        Json_return_clauseContext retClause = json.json_return_clause();
        if (retClause == null && json.json_object_content() != null) {
            retClause = json.json_object_content().json_return_clause();
        }

        String coltype = TypesSetManually.JSON;
        if (retClause != null) {
            Data_typeContext type = retClause.data_type();
            coltype = PgParserAbstract.getTypeName(type);
            addTypeDepcy(type);
        } else if (json.JSON_ARRAY() != null || json.JSON_ARRAYAGG() != null) {
            coltype = TypesSetManually.JSON + "[]";
        } else if (json.JSON_EXISTS() != null) {
            coltype = TypesSetManually.BOOLEAN;
        } else if (json.JSON_QUERY() != null) {
            coltype = TypesSetManually.JSONB;
        } else if (json.JSON_VALUE() != null) {
            coltype = TypesSetManually.TEXT;
        } else if (json.JSON_SERIALIZE() != null) {
            coltype = TypesSetManually.TEXT;
        } else if (json.JSON_TABLE() != null) {
            analyzeJsonColumns(args, json.json_columns());
            coltype = TypesSetManually.FUNCTION_TABLE;
        } else if (json.JSON_SCALAR() != null) {
            var inputType = analyze(new Vex(json.vex())).getSecond();
            if (TypesSetManually.BOOLEAN.equals(inputType)) {
                coltype = TypesSetManually.BOOLEAN;
            } else if (TypesSetManually.TEXT.equals(inputType)) {
                coltype = TypesSetManually.TEXT;
            }
        }

        var array = json.json_array_element();
        if (array != null) {
            var select = array.select_stmt_no_parens();
            if (select != null) {
                new Select(this).analyze(select);
            }
        }

        var vex = json.vex();
        if (vex != null) {
            args.add(vex);
        }

        String colname = json.getChild(0).getText().toLowerCase(Locale.ROOT);
        return new ModPair<>(colname, coltype);
    }

    private void analyzeJsonColumns(List<VexContext> args, Json_columnsContext columns) {
        for (var col : columns.json_table_column()) {
            if (col.NESTED() == null) {
                args.add(col.vex());
                Data_typeContext type = col.data_type();
                if (type != null) {
                    addTypeDepcy(col.data_type());
                }
            } else {
                analyzeJsonColumns(args, col.json_columns());
            }
        }
    }

    /**
     * @param functionName called function bare name
     * @param sourceTypes call sequential argument types
     * @param sourceNames call named argument types (Name => Type map)
     * @param availableFunctions functions from applicable schemas
     * @return most suitable function to call or null,
     *      if none were found or an ambiguity was detected
     */
    private IFunction resolveCall(String functionName, List<String> sourceTypes,
            Map<String, String> sourceNames, Collection<? extends IFunction> availableFunctions) {
        // save each applicable function with the number of exact type matches
        // between input args and function parameters
        // function that has more exact matches (less casts) wins
        List<Pair<IFunction, Integer>> matches = new ArrayList<>();
        for (IFunction f : availableFunctions) {
            if (!f.getBareName().equals(functionName)) {
                continue;
            }

            int argN = 0;
            int namedArgN = 0;
            int exactMatches = 0;
            boolean signatureApplicable = true;
            for (Argument arg : f.getArguments()) {
                if (!arg.getMode().isIn()) {
                    continue;
                }

                String sourceType = null;
                boolean hasNamedArg = namedArgN < sourceNames.size();
                if (argN < sourceTypes.size()) {
                    sourceType = sourceTypes.get(argN);
                    ++argN;
                } else if (hasNamedArg) {
                    sourceType = sourceNames.get(arg.getName());
                    if (sourceType != null) {
                        ++namedArgN;
                    }
                }

                if (sourceType == null) {
                    // supplied fewer arguments than function requires
                    // current (unsatisfied) parameter having a default value
                    // means that all the rest of parameters will also have default values
                    // because of ordering imposed by the standard
                    // thus, the function is applicable if the first unsatisfied parameter
                    // has a default value, and otherwise it is not
                    signatureApplicable = arg.getDefaultExpression() != null;
                    if (!signatureApplicable || !hasNamedArg) {
                        break;
                    }
                    // continue checking if more named (out-of-order) args are available
                    continue;
                }

                if (sourceType.equals(arg.getDataType())) {
                    ++exactMatches;
                } else if (!typesMatch(sourceType, arg.getDataType())) {
                    signatureApplicable = false;
                    break;
                }
            }
            if (signatureApplicable) {
                if (exactMatches == (argN + namedArgN) && argN == sourceTypes.size()
                        && namedArgN == sourceNames.size()) {
                    // all args matched types exactly with no casts
                    // fast path for exact signature match
                    return f;
                }
                matches.add(new Pair<>(f, exactMatches));
            }
        }

        if (matches.isEmpty()) {
            return null;
        }
        return Collections.max(matches, Comparator.comparing(Pair::getSecond))
                .getFirst();
    }

    private IOperator resolveOperatorsCall(String operatorName, String left, String right,
            Collection<IOperator> availableOperators) {
        // save each applicable operators with the number of exact type matches
        // between input args and operator parameters
        // function that has more exact matches (less casts) wins
        List<Pair<IOperator, Integer>> matches = new ArrayList<>();
        for (IOperator oper : availableOperators) {
            if (!oper.getBareName().equals(operatorName)) {
                continue;
            }
            int exactMatches = 0;
            String leftArg = oper.getLeftArg();
            String rightArg = oper.getRightArg();

            if (Objects.equals(leftArg, left)) {
                ++exactMatches;
            } else if (leftArg == null || left == null || !typesMatch(left, leftArg)) {
                continue;
            }

            if (Objects.equals(rightArg, right)) {
                ++exactMatches;
            } else if (rightArg == null || right == null || !typesMatch(right, rightArg)) {
                continue;
            }

            if (exactMatches == 2) {
                // fast path for exact signature match
                return oper;
            }

            matches.add(new Pair<>(oper, exactMatches));
        }

        if (matches.isEmpty()) {
            return null;
        }

        return Collections.max(matches,
                (m1,m2) -> Integer.compare(m1.getSecond(), m2.getSecond()))
                .getFirst();

    }

    private boolean typesMatch(String source, String target) {
        if (isAnyTypes(source) || isAnyTypes(target)) {
            return true;
        }
        return meta.containsCastImplicit(source, target);
    }

    private static boolean isAnyTypes(String type) {
        return type.equalsIgnoreCase(TypesSetManually.ANYTYPE)
                || type.equalsIgnoreCase(TypesSetManually.ANY)
                || type.equalsIgnoreCase(TypesSetManually.ANYARRAY)
                || type.equalsIgnoreCase(TypesSetManually.ANYRANGE)
                || type.equalsIgnoreCase(TypesSetManually.ANYENUM)
                || type.equalsIgnoreCase(TypesSetManually.ANYNOARRAY);
    }

    private String getOperatorToken(Vex vex) {
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
            return token.getText();
        default:
            return null;
        }
    }

    private String getFunctionReturns(IFunction f) {
        return f.getReturnsColumns().isEmpty() ? f.getReturns() : TypesSetManually.FUNCTION_TABLE;
    }

    public void orderBy(Orderby_clauseContext orderBy) {
        for (Sort_specifierContext sort : orderBy.sort_specifier()) {
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

    private void regCast(SconstContext strCtx, String regcast) {
        if (!regcast.startsWith("reg")) {
            return;
        }

        Pair<String, Token> pair = PgParserAbstract.unquoteQuotedString(strCtx);
        String s = pair.getFirst();
        Token start = pair.getSecond();

        switch (regcast) {
        case "regproc":
            // In this case, the function is not overloaded.
            addFunctionDepcyNotOverloaded(QNameParser.parsePg(s).getIds(), start, DbObjType.FUNCTION);
            break;
        case "regclass":
            addDepcy(QNameParser.parsePg(s).getIds(), DbObjType.TABLE, start);
            break;
        case "regtype":
            addDepcy(QNameParser.parsePg(s).getIds(), DbObjType.TYPE, start);
            break;
        case "regnamespace":
            addSchemaDepcy(QNameParser.parsePg(s).getIds(), start);
            break;
        case "regprocedure":
            addFunctionSigDepcy(s, start, DbObjType.FUNCTION);
            break;
        case "regoper":
            // In this case, the operator is not overloaded.
            addFunctionDepcyNotOverloaded(QNameParser.parsePgOperator(s).getIds(), start, DbObjType.OPERATOR);
            break;
        case "regoperator":
            addFunctionSigDepcy(s, start, DbObjType.OPERATOR);
            break;
        case "regconfig":
            addDepcy(QNameParser.parsePg(s).getIds(), DbObjType.FTS_CONFIGURATION, start);
            break;
        case "regdictionary":
            addDepcy(QNameParser.parsePg(s).getIds(), DbObjType.FTS_DICTIONARY, start);
            break;
        default:
            break;
        }
    }

    private String literal(Expr_constContext constCtx) {
        String ret;
        SconstContext charString;
        Truth_valueContext truthValue;

        if (constCtx.iconst() != null) {
            ret = TypesSetManually.INTEGER;
        } else if (constCtx.fconst() != null) {
            ret = TypesSetManually.NUMERIC;
        } else if ((charString = constCtx.sconst()) != null) {
            String text = charString.getText();
            if (text.regionMatches(true, 0, "B", 0, 1) || text.regionMatches(true, 0, "X", 0, 1)) {
                ret = TypesSetManually.BIT;
            } else if (text.regionMatches(true, 0, "N", 0, 1)) {
                ret = TypesSetManually.BPCHAR;
            } else {
                ret = TypesSetManually.TEXT;
            }
        } else if ((truthValue = constCtx.truth_value()) != null) {
            if (truthValue.TRUE() != null || truthValue.FALSE() != null) {
                ret = TypesSetManually.BOOLEAN;
            } else {
                ret = TypesSetManually.TEXT;
            }
        } else {
            LOG.warn("No alternative in unsigned_value_specification!");
            ret = TypesSetManually.UNKNOWN;
        }
        return ret;
    }

    private String stripBrackets(String type) {
        if (type.endsWith("[]")) {
            return type.substring(0, type.length() - 2);
        }
        return type;
    }

    private String stripParens(String type) {
        if (type.endsWith(")")) {
            return type.substring(0, type.lastIndexOf('('));
        }
        return type;
    }
}
