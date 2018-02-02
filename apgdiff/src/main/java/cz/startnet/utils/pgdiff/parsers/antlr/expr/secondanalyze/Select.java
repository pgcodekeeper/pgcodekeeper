package cz.startnet.utils.pgdiff.parsers.antlr.expr.secondanalyze;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alias_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.From_itemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.From_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_callContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Groupby_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Grouping_elementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Grouping_set_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Orderby_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Ordinary_grouping_setContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Qualified_asteriskContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Row_value_predicand_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_sublistContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_subqueryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expression_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Values_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Values_valuesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Window_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_queryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectOps;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgTable;
import cz.startnet.utils.pgdiff.schema.PgTable.Inherits;
import cz.startnet.utils.pgdiff.schema.PgView;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class Select extends AbstractExprWithNmspc<SelectStmt> {

    /**
     * Flags for proper FROM (subquery) analysis.<br>
     * {@link #findReferenceInNmspc(String, String, String)} assumes that when {@link #inFrom} is set the FROM clause
     * of that query is analyzed and skips that namespace entirely unless {@link #lateralAllowed} is also set
     * (when analyzing a lateral FROM subquery or a function call).<br>
     * This assumes that {@link #from(From_itemContext)} is the first method to fill the namespace.<br>
     * Note: caller of {@link #from(From_itemContext)} is responsible for setting {@link #inFrom} flag.
     */
    private boolean inFrom;
    /**
     * @see #inFrom
     */
    private boolean lateralAllowed;

    private static final Pattern PATTERN_FUNC_RETURN_TBL_TEMPLATE = Pattern.compile("^TABLE\\([\\w\\d\\s\\[\\],]+\\)$");

    public Select(String schema, PgDatabase db) {
        super(schema, db);
    }

    protected Select(AbstractExpr parent) {
        super(parent);
    }

    @Override
    protected Entry<String, GenericColumn> findReferenceInNmspc(String schema, String name, String column) {
        return !inFrom || lateralAllowed ? super.findReferenceInNmspc(schema, name, column) : null;
    }

    public List<Entry<String, String>> analyze(ParserRuleContext ruleCtx) {
        if (ruleCtx instanceof Select_stmtContext) {
            return analyze(new SelectStmt((Select_stmtContext) ruleCtx));
        } else if (ruleCtx instanceof Select_stmt_no_parensContext) {
            return analyze(new SelectStmt((Select_stmt_no_parensContext) ruleCtx));
        } else {
            throw new IllegalStateException("Not a select ctx");
        }
    }

    @Override
    public List<Entry<String, String>> analyze(SelectStmt select) {
        return analyze(select, null);
    }

    public List<Entry<String, String>> analyze(SelectStmt select, With_queryContext recursiveCteCtx) {
        With_clauseContext with = select.withClause();
        if (with != null) {
            analyzeCte(with);
        }

        List<Entry<String, String>> ret = selectOps(select.selectOps(), recursiveCteCtx);

        selectAfterOps(select);

        return ret;
    }

    protected void selectAfterOps(SelectStmt select) {
        Orderby_clauseContext orderBy = select.orderBy();

        List<VexContext> vexs = null;
        if (select.limit() != null || select.offset() != null || select.fetch() != null) {
            vexs = select.vex();
        }

        if (orderBy != null || vexs != null) {
            ValueExpr vex = new ValueExpr(this);
            if (orderBy != null) {
                vex.orderBy(orderBy);
            }
            if(vexs != null) {
                for (VexContext vexCtx : vexs) {
                    vex.analyze(new Vex(vexCtx));
                }
            }
        }

        if (select.of(0) != null) {
            for (Schema_qualified_nameContext tableLock : select.schemaQualifiedName()) {
                addObjectDepcy(tableLock.identifier(), DbObjType.TABLE);
            }

        }
    }

    protected List<Entry<String, String>> selectOps(SelectOps selectOps) {
        return selectOps(selectOps, null);
    }

    protected List<Entry<String, String>> selectOps(SelectOps selectOps, With_queryContext recursiveCteCtx) {
        List<Entry<String, String>> ret = Collections.emptyList();
        Select_stmtContext selectStmt = selectOps.selectStmt();
        Select_primaryContext primary;

        if (selectOps.leftParen() != null && selectOps.rightParen() != null && selectStmt != null) {
            ret = analyze(selectStmt);
        } else if (selectOps.intersect() != null || selectOps.union() != null || selectOps.except() != null) {
            // analyze each in a separate scope
            // use column names from the first one
            ret = new Select(this).selectOps(selectOps.selectOps(0));

            // 'recursiveCteCtx != null' means that program at this moment
            // situated inside recursion which contains 'UNION',
            //
            // for example:
            // "WITH RECURSIVE a(b) AS (select1 UNION select2) SELECT a.b FROM a;".
            //
            // Results of select1 (non-recursive part) analysis are used
            // as CTE by select2's (potentially recursive part) analysis.
            // This way types of recursive references in select2 will be known from select1.
            // Lastly select1 signature is used for the entire CTE.
            if (recursiveCteCtx != null) {
                addCteSignature(recursiveCteCtx, ret);
            }

            new Select(this).selectOps(selectOps.selectOps(1));
        } else if ((primary = selectOps.selectPrimary()) != null) {
            Values_stmtContext values;

            if (primary.SELECT() != null) {
                // from defines the namespace so it goes before everything else
                if (primary.FROM() != null) {
                    boolean oldFrom = inFrom;
                    try {
                        inFrom = true;
                        for (From_itemContext fromItem : primary.from_item()) {
                            from(fromItem);
                        }
                    } finally {
                        inFrom = oldFrom;
                    }
                }

                Qualified_asteriskContext ast = null;
                ret = new ArrayList<>();

                for (Select_sublistContext target : primary.select_list().select_sublist()) {
                    ValueExpr vexCol = new ValueExpr(this);
                    Vex selectSublistVex = new Vex(target.vex());

                    Value_expression_primaryContext valExprPrimary;
                    if ((valExprPrimary = selectSublistVex.primary()) != null
                            && (ast = valExprPrimary.qualified_asterisk()) != null) {
                        ret.addAll(getColsOfAsterisk(ast));
                        continue;
                    }

                    Entry<String, String> columnPair = vexCol.analyze(selectSublistVex);

                    if(target.alias != null && columnPair != null){
                        columnPair = new SimpleEntry<>(target.alias.getText(), columnPair.getValue());
                    }

                    ret.add(columnPair);
                }

                ret = fillTypesOfColsWhenFromFunc(ret, ast);

                ValueExpr vex = new ValueExpr(this);

                if ((primary.set_qualifier() != null && primary.ON() != null)
                        || primary.WHERE() != null || primary.HAVING() != null) {
                    for (VexContext v : primary.vex()) {
                        vex.analyze(new Vex(v));
                    }
                }

                Groupby_clauseContext groupBy = primary.groupby_clause();
                if (groupBy != null) {
                    for (Grouping_elementContext group : groupBy.grouping_element_list().grouping_element()) {
                        Ordinary_grouping_setContext groupingSet = group.ordinary_grouping_set();
                        Grouping_set_listContext groupingSets;

                        if (groupingSet != null) {
                            groupingSet(groupingSet, vex);
                        } else if ((groupingSets = group.grouping_set_list()) != null) {
                            for (Ordinary_grouping_setContext groupingSubset : groupingSets.ordinary_grouping_set_list().ordinary_grouping_set()) {
                                groupingSet(groupingSubset, vex);
                            }
                        }
                    }
                }

                if (primary.WINDOW() != null) {
                    for (Window_definitionContext window : primary.window_definition()) {
                        vex.window(window);
                    }
                }
            } else if (primary.TABLE() != null) {
                addObjectDepcy(primary.schema_qualified_name().identifier(), DbObjType.TABLE);
            } else if ((values = primary.values_stmt()) != null) {
                ret = new ArrayList<>();
                ValueExpr vex = new ValueExpr(this);
                for (Values_valuesContext vals : values.values_values()) {
                    for (VexContext v : vals.vex()) {
                        ret.add(vex.analyze(new Vex(v)));
                    }
                }
            } else {
                Log.log(Log.LOG_WARNING, "No alternative in select_primary!");
            }
        } else {
            Log.log(Log.LOG_WARNING, "No alternative in SelectOps!");
        }
        return ret;
    }

    /**
     * Fill columns by types in cases when function located in FROM.
     *
     * @return list of columns as entry('column name' - 'column type').
     */
    private List<Entry<String, String>> fillTypesOfColsWhenFromFunc(List<Entry<String, String>> analyzedColPairs,
            Qualified_asteriskContext ast) {
        if (ast != null) {
            return analyzedColPairs;
        }

        List<Entry<String, String>> colPairsFilledByType = new ArrayList<>();

        for (Entry<String, String> currentColPair : analyzedColPairs) {
            if (TypesSetManually.COLUMN.equals(currentColPair.getValue())) {
                // Cases are handled when the type of column is not defined.

                String currentColName = currentColPair.getKey();

                List<Entry<String, String>> colPairsOfAliasOfComplexNmsp;
                if ((colPairsOfAliasOfComplexNmsp = complexNamespace.get(currentColName)) != null) {
                    // In this case alias of 'complexNamespace' is used as name of 'columnPair'.

                    // fill column by type in cases when function return only one value.

                    colPairsFilledByType.add(getColsChekedForFuncReturnTbl(new SimpleEntry<>(currentColName,
                            colPairsOfAliasOfComplexNmsp)).get(0));
                } else {
                    // fill column by type in cases when function return TABLE(...).

                    // In 'complexNamespace', check the presence of 'table (colName colType, ...)',
                    // in which the column names and their number are the same as the current one.
                    // As result get the column from the table returned by the function.
                    colPairsFilledByType.add(getColFromReturnedTblFunc(analyzedColPairs, currentColPair));
                }
            } else {
                colPairsFilledByType.add(currentColPair);
            }
        }
        return colPairsFilledByType;
    }

    /**
     * Get columnPair(with defined type) for 'currentColPair' from one of the columns
     * of the table returned by the function
     * (function returns 'TABLE (colName colType, ...)').
     *
     * <p>Example for explanation.
     * <p>SELECT d.f1,d.f2 FROM dup3(3) d(f1,f2);
     * <p>SELECT dup3.f1, dup3.f2 FROM dup3(3) dup3(f1,f2);
     * <p>'dup3' returns 'TABLE(f1 integer, f2 double precision)'.
     * <p>For getting type for column 'f1' uses filter by 'currentColPair.getKey()'
     * (currentColPair.getKey() == "f1").
     *
     * <p>In 'complexNamespace', check the presence of 'TABLE (colName colType, ...)',
     * in which the column names and their number are the same as the current one.
     * As result get the column from the table returned by the function.
     *
     * @param analyzedColPairs list of analyzed column pairs.
     * @param currentColPair the colPari(with undefined type) of the column to get the columnPair (with defined type).
     *
     * @return columnPair(with defined type) for 'currentColPair' from one of the columns of the table returned by the function
     * or 'currentColPair' without changes
     */
    private Entry<String, String> getColFromReturnedTblFunc(List<Entry<String, String>> analyzedColPairs,
            Entry<String, String> currentColPair) {
        Set<String> colNamesOfanalyzedColPairs = analyzedColPairs.stream()
                .map(Entry::getKey).collect(Collectors.toSet());

        // In 'complexNamespace', check the presence of 'TABLE (colName colType, ...)',
        // in which the column names and their number are the same as the current one.
        for (Entry<String, List<Entry<String, String>>> complexEntry : complexNamespace.entrySet()) {
            List<Entry<String, String>> colPairsOfAliasOfComplexNmsp = complexEntry.getValue();

            if (colPairsOfAliasOfComplexNmsp.size() == 1
                    && PATTERN_FUNC_RETURN_TBL_TEMPLATE
                    .matcher(colPairsOfAliasOfComplexNmsp.get(0).getValue()).matches()) {

                Set<String> colNamesOfcolPairsOfAliasOfComplexNmsp = getColsChekedForFuncReturnTbl(complexEntry).stream()
                        .map(Entry::getKey).collect(Collectors.toSet());

                if (colNamesOfcolPairsOfAliasOfComplexNmsp.equals(colNamesOfanalyzedColPairs)) {
                    // Return one columnPair(name-type) which relates to the 'currentColName'.
                    //
                    // Example for explanation.
                    //
                    // SELECT d.f1,d.f2 FROM dup3(3) d(f1,f2);
                    // SELECT dup3.f1, dup3.f2 FROM dup3(3) dup3(f1,f2);
                    //
                    // 'dup3' returns 'TABLE(f1 integer, f2 double precision)'.
                    //
                    // For getting type for column 'f1' uses filter by 'currentColPair.getKey()'
                    // (currentColPair.getKey() == "f1").
                    return getColsChekedForFuncReturnTbl(complexEntry).stream()
                            .filter(entry -> entry.getKey().equals(currentColPair.getKey()))
                            .collect(Collectors.toList()).get(0);
                }
            }
        }

        return currentColPair;
    }

    private List<Entry<String, String>> getColsOfAsterisk(Qualified_asteriskContext ast) {
        Schema_qualified_nameContext qNameAst = ast.tb_name;

        //// If asterisk in SELECT is NOT qualified.

        if(qNameAst == null ) {
            List<Entry<String, String>> retNotQualAsterCols = new ArrayList<>();

            unaliasedNamespace.forEach(gCol -> retNotQualAsterCols.addAll(getTableOrViewColumns(gCol.schema, gCol.table)));

            for (Entry<String, GenericColumn> nmsp : namespace.entrySet()) {
                GenericColumn gCol = nmsp.getValue();
                if (gCol != null) {
                    retNotQualAsterCols.addAll(getTableOrViewColumns(gCol.schema, gCol.table));
                }
            }

            complexNamespace.entrySet().forEach(complexNmsp -> retNotQualAsterCols.addAll(complexNmsp.getValue()));

            // Check colPairs for the presence in the type the value of "TABLE (...)".
            // If there are presence such colPairs, then replacing them by colPairs from "TABLE (...)".
            Iterator<Entry<String, String>> iterRetNotQualAsterCols = retNotQualAsterCols.iterator();
            List<Entry<String, String>> colsFromFuncReturnTbl = new ArrayList<>();
            while (iterRetNotQualAsterCols.hasNext()) {
                String colType = iterRetNotQualAsterCols.next().getValue();
                if (PATTERN_FUNC_RETURN_TBL_TEMPLATE.matcher(colType).matches()) {
                    colsFromFuncReturnTbl.addAll(getColsFromStringOfFuncReturnTbl(colType));
                    iterRetNotQualAsterCols.remove();
                }
            }
            retNotQualAsterCols.addAll(colsFromFuncReturnTbl);

            return retNotQualAsterCols;
        }

        //// If asterisk in SELECT is qualified.

        List<Entry<String, String>> retQualAsterCols;

        List<IdentifierContext> ids = qNameAst.identifier();
        String qualSchema = QNameParser.getSecondName(ids);
        String srcOrTblOrView = QNameParser.getFirstName(ids);

        // For cases when: SELECT (schemaName.)?tableName.* From (schemaName.)?tableName;
        if (!(retQualAsterCols = getTableOrViewColumns(qualSchema, srcOrTblOrView)).isEmpty()) {
            return retQualAsterCols;
        }

        Entry<String, GenericColumn> srcOfAlias;
        GenericColumn tableOrView;
        if ((srcOfAlias = findReference(qualSchema, srcOrTblOrView, null)) != null
                && (tableOrView = srcOfAlias.getValue()) != null) {
            // if FROM has table or view with alias
            return getTableOrViewColumns(tableOrView.schema, tableOrView.table);
        } else {
            // if FROM has subquery with alias

            if (complexNamespaceIsFunction.contains(srcOrTblOrView)) {
                // if FROM use function as subquery

                Entry<String, List<Entry<String, String>>> funcEntry = findReferenceComplex(srcOrTblOrView, null);

                String funcRetType = funcEntry.getValue().get(0).getValue();

                if (PATTERN_FUNC_RETURN_TBL_TEMPLATE.matcher(funcRetType).matches()) {
                    // if function returns TABLE(...)
                    return getColsFromStringOfFuncReturnTbl(funcRetType);
                } else {
                    // if function return one value
                    retQualAsterCols.add(new SimpleEntry<>(srcOrTblOrView, funcRetType));
                    return retQualAsterCols;
                }
            } else {
                // if FROM dosn't use function as subquery
                return findReferenceComplex(srcOrTblOrView, null).getValue();
            }
        }
    }

    private List<Entry<String, String>> getColsFromStringOfFuncReturnTbl(String matchedExpression) {
        List<Entry<String, String>> ret = new ArrayList<>();

        String nameTypeExpression = matchedExpression.substring(0, matchedExpression.length()-1)
                .replace("TABLE(", "");

        String name;
        String type;
        for (String nameType: nameTypeExpression.split(", ")) {
            name = nameType.substring(0, nameType.indexOf(' '));
            type = nameType.substring(nameType.indexOf(' ')+1, nameType.length());
            ret.add(new SimpleEntry<>(name, type));
        }

        return ret;
    }

    /**
     * This method check for the function which returns TABLE(name1 type1, name2 type2, ...)
     * and function with alias which returns only one value.
     *
     * @param entryCompNmsp
     * @return list of columns as entry('column name' - 'column type').
     */
    private List<Entry<String, String>> getColsChekedForFuncReturnTbl(Entry<String, List<Entry<String, String>>> entryCompNmsp) {
        List<Entry<String, String>> complexResult = entryCompNmsp.getValue();

        if (complexResult.size() != 1) {
            return complexResult;
        }

        String value = complexResult.get(0).getValue();
        Matcher matcher = PATTERN_FUNC_RETURN_TBL_TEMPLATE.matcher(value);

        if (!matcher.matches()) {
            return Arrays.asList(new SimpleEntry<>(entryCompNmsp.getKey(), complexResult.get(0).getValue()));
        }

        List<Entry<String, String>> ret = new ArrayList<>();
        String matchedExpression = matcher.group(0);
        String nameTypeExpression = matchedExpression.substring(0, matchedExpression.length()-1)
                .replace("TABLE(", "");

        String name;
        String type;
        for (String nameType: nameTypeExpression.split(", ")) {
            name = nameType.substring(0, nameType.indexOf(' '));
            type = nameType.substring(nameType.indexOf(' ')+1, nameType.length());
            ret.add(new SimpleEntry<>(name, type));
        }

        return ret;
    }

    private void groupingSet(Ordinary_grouping_setContext groupingSet, ValueExpr vex) {
        VexContext v = groupingSet.vex();
        Row_value_predicand_listContext predicandList;
        if (v != null) {
            vex.analyze(new Vex(v));
        } else if ((predicandList = groupingSet.row_value_predicand_list()) != null) {
            for (VexContext predicand : predicandList.vex()) {
                vex.analyze(new Vex(predicand));
            }
        }
    }

    private void from(From_itemContext fromItem) {
        From_primaryContext primary;

        if (fromItem.LEFT_PAREN() != null && fromItem.RIGHT_PAREN() != null) {
            Alias_clauseContext joinAlias = fromItem.alias_clause();
            if (joinAlias != null) {
                // we simplify this case by analyzing joined ranges in an isolated scope
                // this way we get dependencies and don't pollute this scope with names hidden by the join alias
                // the only name this form of FROM clause exposes is the join alias

                // consequence of this method: no way to connect column references with the tables inside the join
                // that would require analyzing the table schemas and actually "performing" the join
                Select fromProcessor = new Select(this);
                fromProcessor.inFrom = true;
                fromProcessor.from(fromItem.from_item(0));
                addReference(joinAlias.alias.getText(), null);
            } else {
                from(fromItem.from_item(0));
            }
        } else if (fromItem.JOIN() != null) {
            from(fromItem.from_item(0));
            from(fromItem.from_item(1));

            if (fromItem.ON() != null) {
                VexContext joinOn = fromItem.vex();
                boolean oldLateral = lateralAllowed;
                // technically incorrect simplification
                // joinOn expr only does not have access to anything in this FROM
                // except JOIN operand subtrees
                // but since we're not doing expression validity checks
                // we pretend that joinOn has access to everything
                // that a usual LATERAL expr has access to
                // this greatly simplifies analysis logic here
                try {
                    lateralAllowed = true;
                    ValueExpr vexOn = new ValueExpr(this);
                    vexOn.analyze(new Vex(joinOn));
                } finally {
                    lateralAllowed = oldLateral;
                }
            }
        } else if ((primary = fromItem.from_primary()) != null) {
            Schema_qualified_nameContext table = primary.schema_qualified_name();
            Alias_clauseContext alias = primary.alias_clause();
            Table_subqueryContext subquery;
            Function_callContext function;

            if (table != null) {
                addNameReference(table, alias);
            } else if ((subquery = primary.table_subquery()) != null) {
                boolean oldLateral = lateralAllowed;
                try {
                    lateralAllowed = primary.LATERAL() != null;
                    List<Entry<String, String>> columnList = new Select(this).analyze(subquery.select_stmt());

                    String tableSubQueryAlias = alias.alias.getText();
                    addReference(tableSubQueryAlias, null);
                    complexNamespace.put(tableSubQueryAlias, columnList);
                } finally {
                    lateralAllowed = oldLateral;
                }
            } else if ((function = primary.function_call()) != null) {
                boolean oldLateral = lateralAllowed;
                try {
                    lateralAllowed = true;
                    ValueExpr vexFunc = new ValueExpr(this);
                    Entry<String, String> func = vexFunc.function(function);
                    if (func.getKey() != null) {
                        String funcAlias = primary.alias == null ? func.getKey():
                            primary.alias.getText();
                        addReference(funcAlias, null);
                        complexNamespace.put(funcAlias, new ArrayList<>(Arrays.asList(func)));
                        complexNamespaceIsFunction.add(funcAlias);
                    }
                } finally {
                    lateralAllowed = oldLateral;
                }
            } else {
                Log.log(Log.LOG_WARNING, "No alternative in from_primary!");
            }
        } else {
            Log.log(Log.LOG_WARNING, "No alternative in from_item!");
        }
    }

    public List<Entry<String, String>> analyzeAsterisk(boolean aliased, Qualified_asteriskContext ast,
            GenericColumn unaliasedNmsp) {
        Schema_qualified_nameContext qualifiedName;
        String schema;
        String tableOrView;
        if (!aliased && (qualifiedName = ast.tb_name) != null) {
            List<IdentifierContext> ids = qualifiedName.identifier();
            schema = QNameParser.getSecondName(ids);
            tableOrView = QNameParser.getFirstName(ids);
        } else {
            schema = unaliasedNmsp.schema;
            tableOrView = unaliasedNmsp.table;
        }
        return getTableOrViewColumns(schema, tableOrView);
    }

    /**
     * Gives list of columns (name-type) for the specified parameters.
     *
     * @param qualSchemaName
     * @param tableOrView
     * @return list of columns (name-type) for the specified parameters
     */
    protected List<Entry<String, String>> getTableOrViewColumns(String qualSchemaName, String tableOrView) {
        List<Entry<String, String>> ret = new ArrayList<>();

        String schemaName = qualSchemaName != null ? qualSchemaName : this.schema;

        PgSchema s;
        if ((s = db.getSchema(schemaName)) != null && tableOrView != null) {
            PgTable t;
            PgView v;
            if ((t = s.getTable(tableOrView)) != null) {

                t.getColumns().forEach(c -> ret.add(new SimpleEntry<>(c.getName(), c.getType())));

                // TODO It is necessary to remake it for a new logic
                // of 'Inherits' object (recursion should be used for this).
                List<Inherits> inheritsList;
                if (!(inheritsList = t.getInherits()).isEmpty()) {
                    for (Inherits inht : inheritsList) {
                        PgTable tInherits = s.getTable(inht.getValue());
                        tInherits.getColumns().forEach(c -> ret.add(new SimpleEntry<>(c.getName(), c.getType())));
                    }

                }
            } else if ((v = s.getView(tableOrView)) != null) {
                v.getRelationColumns().forEach(ret::add);
            }
        }
        return ret;
    }
}