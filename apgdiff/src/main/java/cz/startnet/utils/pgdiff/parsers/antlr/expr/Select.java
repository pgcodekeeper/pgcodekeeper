package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.function.Predicate;
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
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

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

    public List<Pair<String, String>> analyze(ParserRuleContext ruleCtx) {
        if (ruleCtx instanceof Select_stmtContext) {
            return analyze(new SelectStmt((Select_stmtContext) ruleCtx));
        } else if (ruleCtx instanceof Select_stmt_no_parensContext) {
            return analyze(new SelectStmt((Select_stmt_no_parensContext) ruleCtx));
        } else {
            throw new IllegalStateException("Not a select ctx");
        }
    }

    @Override
    public List<Pair<String, String>> analyze(SelectStmt select) {
        return analyze(select, null);
    }

    public List<Pair<String, String>> analyze(SelectStmt select, With_queryContext recursiveCteCtx) {
        With_clauseContext with = select.withClause();
        if (with != null) {
            analyzeCte(with);
        }

        List<Pair<String, String>> ret = selectOps(select.selectOps(), recursiveCteCtx);

        selectAfterOps(select);

        return ret;
    }

    private void selectAfterOps(SelectStmt select) {
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
                addRelationDepcy(tableLock.identifier());
            }

        }
    }

    private List<Pair<String, String>> selectOps(SelectOps selectOps) {
        return selectOps(selectOps, null);
    }

    private List<Pair<String, String>> selectOps(SelectOps selectOps, With_queryContext recursiveCteCtx) {
        List<Pair<String, String>> ret;
        Select_stmtContext selectStmt = selectOps.selectStmt();
        Select_primaryContext primary;

        if (selectOps.leftParen() != null && selectOps.rightParen() != null && selectStmt != null) {
            ret = analyze(selectStmt);
        } else if (selectOps.intersect() != null || selectOps.union() != null || selectOps.except() != null) {
            // analyze each in a separate scope
            // use column names from the first one
            ret = new Select(this).selectOps(selectOps.selectOps(0));

            // when a recursive CTE is encountered, its SELECT is guaranteed
            // to have a "SelectOps" on top level
            //
            // WITH RECURSIVE a(b) AS (select1 UNION select2) SELECT a.b FROM a
            //
            // CTE analysis creates a new child namespace to recurse through SelectOps
            // and this is where we are now.
            // Since current namespace is independent of its parent and SelectOps operands
            // well be analyzed on further separate child namespaces
            // we can safely store "select1"s signature as a CTE on the current pseudo-namespace
            // so that it's visible to the recursive "select2" and doesn't pollute any other namespaces.
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
            ret = primary(primary);
        } else {
            Log.log(Log.LOG_WARNING, "No alternative in SelectOps!");
            ret = Collections.emptyList();
        }
        return ret;
    }

    private List<Pair<String, String>> primary(Select_primaryContext primary) {
        List<Pair<String, String>> ret;
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

            ret = new ArrayList<>();
            ValueExpr vex = new ValueExpr(this);
            for (Select_sublistContext target : primary.select_list().select_sublist()) {
                Vex selectSublistVex = new Vex(target.vex());

                Qualified_asteriskContext ast;
                Value_expression_primaryContext valExprPrimary = selectSublistVex.primary();
                if (valExprPrimary != null
                        && (ast = valExprPrimary.qualified_asterisk()) != null) {
                    Schema_qualified_nameContext qNameAst = ast.tb_name;
                    ret.addAll(qNameAst == null ? unqualAster() : qualAster(qNameAst));
                } else {
                    Pair<String, String> columnPair = vex.analyze(selectSublistVex);

                    if (target.alias != null && columnPair != null) {
                        columnPair.setFirst(target.alias.getText());
                    }

                    ret.add(columnPair);
                }
            }


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
            Schema_qualified_nameContext table = primary.schema_qualified_name();
            addRelationDepcy(table.identifier());
            ret = qualAster(table);
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
            ret = Collections.emptyList();
        }
        return ret;
    }

    private static final Predicate<String> ANY = s -> true;

    private List<Pair<String, String>> unqualAster() {
        List<Pair<String, String>> cols = new ArrayList<>();

        for (GenericColumn gc : unaliasedNamespace) {
            addFilteredRelationColumnsDepcies(gc.schema, gc.table, ANY).forEach(cols::add);
        }

        for (Entry<String, GenericColumn> nmsp : namespace.entrySet()) {
            GenericColumn gc = nmsp.getValue();
            if (gc != null) {
                addFilteredRelationColumnsDepcies(gc.schema, gc.table, ANY).forEach(cols::add);
            }
        }

        complexNamespace.values().forEach(cols::addAll);

        return cols;
    }

    private List<Pair<String, String>> qualAster(Schema_qualified_nameContext qNameAst) {
        List<IdentifierContext> ids = qNameAst.identifier();
        String schema = QNameParser.getSecondName(ids);
        String relation = QNameParser.getFirstName(ids);

        Entry<String, GenericColumn> ref = findReference(schema, relation, null);
        if (ref == null) {
            Log.log(Log.LOG_WARNING, "Asterisk qualification not found: " + qNameAst.getText());
            return Collections.emptyList();
        }
        GenericColumn relationGc = ref.getValue();
        if (relationGc != null) {
            return addFilteredRelationColumnsDepcies(relationGc.schema, relationGc.table, ANY)
                    .collect(Collectors.toList());
        } else {
            List<Pair<String, String>> complexNsp = findReferenceComplex(relation);
            if (complexNsp != null) {
                return complexNsp;
            } else {
                Log.log(Log.LOG_WARNING, "Complex not found: " + relation);
                return Collections.emptyList();
            }
        }
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

    void from(From_itemContext fromItem) {
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
                    List<Pair<String, String>> columnList = new Select(this).analyze(subquery.select_stmt());

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
                    Pair<String, String> func = vexFunc.function(function);
                    if (func.getKey() != null) {
                        String funcAlias = primary.alias == null ? func.getKey():
                            primary.alias.getText();
                        addReference(funcAlias, null);
                        complexNamespace.put(funcAlias,
                                Arrays.asList(new Pair<>(funcAlias, func.getValue())));
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