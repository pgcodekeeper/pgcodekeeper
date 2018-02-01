package cz.startnet.utils.pgdiff.parsers.antlr.expr.secondanalyze;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
                List<Select_sublistContext> selectSublist = primary.select_list().select_sublist();
                for (int i = 0; i < selectSublist.size(); i++) {
                    Select_sublistContext target = selectSublist.get(i);

                    ValueExpr vexCol = new ValueExpr(this);
                    Vex selectSublistVex = new Vex(target.vex());

                    if ((ast = vexCol.getAsteriskIfContainedInVex(selectSublistVex)) != null) {
                        ret.addAll(getColsOfAsterisk(ast, vexCol, i));
                        continue;
                    }

                    Entry<String, String> columnPair = vexCol.analyze(selectSublistVex);

                    if(target.alias != null && columnPair != null){
                        columnPair = new SimpleEntry<>(target.alias.getText(), columnPair.getValue());
                    }

                    ret.add(columnPair);
                }

                ret = replacingNullNameInColumns(ret);

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

        for (Entry<String, String> columnPair : analyzedColPairs) {
            if (TypesSetManually.COLUMN.equals(columnPair.getValue())) {
                // Cases are handled when the type of column is not defined.

                String currentColName = columnPair.getKey();

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
                    // As result get the columns from the table returned by the function.
                    colPairsFilledByType.addAll(getColsFromReturnedTblFunc(analyzedColPairs, currentColName));
                }
            } else {
                colPairsFilledByType.add(columnPair);
            }
        }
        return colPairsFilledByType;
    }

    /**
     * Get the columns from the table returned by the function.
     *
     * In 'complexNamespace', check the presence of 'TABLE (colName colType, ...)',
     * in which the column names and their number are the same as the current one.
     * As result get the columns from the table returned by the function.
     *
     * @return columns from the table returned by the function.
     */
    private List<Entry<String, String>> getColsFromReturnedTblFunc(List<Entry<String, String>> analyzedColPairs,
            String currentColName) {
        Set<String> colNamesOfanalyzedColPairs = analyzedColPairs.stream()
                .map(Entry::getKey).collect(Collectors.toSet());

        // In 'complexNamespace', check the presence of 'TABLE (colName colType, ...)',
        // in which the column names and their number are the same as the current one.
        for (Entry<String, List<Entry<String, String>>> complexEntry : complexNamespace.entrySet()) {
            List<Entry<String, String>> colPairsOfAliasOfComplexNmsp = complexEntry.getValue();

            if (colPairsOfAliasOfComplexNmsp.size() == 1
                    && Pattern.compile("^TABLE\\([\\w\\d\\s\\[\\],]+\\)$")
                    .matcher(colPairsOfAliasOfComplexNmsp.get(0).getValue()).matches()) {

                Set<String> colNamesOfcolPairsOfAliasOfComplexNmsp = getColsChekedForFuncReturnTbl(complexEntry).stream()
                        .map(Entry::getKey).collect(Collectors.toSet());

                if (colNamesOfcolPairsOfAliasOfComplexNmsp.equals(colNamesOfanalyzedColPairs)) {
                    // return colPairs which relates to the currentColName.
                    return getColsChekedForFuncReturnTbl(complexEntry).stream()
                            .filter(entry -> entry.getKey().equals(currentColName))
                            .collect(Collectors.toList());
                }
            }
        }

        return Collections.emptyList();
    }

    private List<Entry<String, String>> replacingNullNameInColumns(List<Entry<String, String>> ret) {
        if(!ret.stream().anyMatch(e -> e.getKey() == null)) {
            return ret;
        }

        List<Entry<String, String>> withoutNullName = new ArrayList<>();
        for (int i = 0; i < ret.size(); i++) {
            Entry<String, String> entry = ret.get(i);

            withoutNullName.add(entry.getKey() != null ? entry :
                new SimpleEntry<>("col"+(i+1), entry.getValue()));

        }
        return withoutNullName;
    }

    private List<Entry<String, String>> getColsOfAsterisk(Qualified_asteriskContext ast, ValueExpr vexCol,
            int asterNumberInList) {
        List<Entry<String, String>> ret = new ArrayList<>();
        boolean aliased = false;
        GenericColumn genericFrom = null;
        if (!unaliasedNamespace.isEmpty()) {
            genericFrom = unaliasedNamespace.size() == 1 ? unaliasedNamespace.iterator().next(): null;
        } else if (!namespace.isEmpty()) {

            if (ast.tb_name != null
                    && (genericFrom = namespace.get(QNameParser.getFirstName(ast.tb_name.identifier()))) != null) {
                // In this case 'ast.tb_name' is alias of table or view.

                aliased = true;
            } else {
                // In this case 'ast.tb_name' is alias of subselect
                // or 'ast.tb_name' is alias of function,
                // or 'ast.tb_name' may be absent.

                // 'complexNamespace == 1' - means only one asterisk in query;
                // 'complexNamespace > 1' - means several columns in the query,
                //                          where an asterisk is located in the 'asterNumberInList'.
                return getColsChekedForFuncReturnTbl(complexNamespace.size() == 1 ?
                        complexNamespace.entrySet().iterator().next() :
                            new ArrayList<>(complexNamespace.entrySet()).get(asterNumberInList));
            }
        }

        ret.addAll(vexCol.analyzeAsterisk(aliased, ast, genericFrom));

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
        Matcher matcher = Pattern.compile("^TABLE\\([\\w\\d\\s\\[\\],]+\\)$").matcher(value);

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
                    complexNamespace.put(tableSubQueryAlias, columnList);
                    addReference(tableSubQueryAlias, null);
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
}