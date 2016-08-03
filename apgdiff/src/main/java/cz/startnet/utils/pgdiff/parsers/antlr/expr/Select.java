package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

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
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectOps;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class Select extends AbstractExpr {
    
    /**
     * Flags for proper FROM (subquery) analysis.<br>
     * {@link #findReference(String)} assumes that when {@link #inFrom} is set the FROM clause
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

    public Select(String schema) {
        super(schema);
    }

    protected Select(AbstractExpr parent) {
        super(parent);
    }

    @Override
    protected AbstractExpr findCte(String cteName) {
        return cte.contains(cteName) ? this : super.findCte(cteName);
    }

    private boolean hasCte(String cteName) {
        return findCte(cteName) != null;
    }

    @Override
    protected Entry<String, GenericColumn> findReference(String schema, String name, String column) {
        if (!inFrom || lateralAllowed) {
            boolean found;
            GenericColumn dereferenced = null;
            if (schema == null && namespace.containsKey(name)) {
                found = true;
                dereferenced = namespace.get(name);
            } else if (!unaliasedNamespace.isEmpty()) {
                // simple empty check to save some allocations
                // it will almost always be empty
                for (GenericColumn unaliased : unaliasedNamespace) {
                    if (unaliased.table.equals(name) &&
                            (schema == null || unaliased.schema.equals(schema))) {
                        if (dereferenced == null) {
                            dereferenced = unaliased;
                            if (schema != null) {
                                // fully qualified, no ambiguity search needed
                                break;
                            }
                        } else {
                            Log.log(Log.LOG_WARNING, "Ambiguous reference: " + name);
                        }
                    }
                }
                found = dereferenced != null;
            } else {
                found = false;
            }

            if (found) {
                // column aliases imply there must be a corresponding table alias
                // so we may defer their lookup until here

                // also, if we cannot dereference an existing name it's safe to assume
                // all its columns are aliases
                // this saves a lookup and extra space in columnAliases
                if (column != null && dereferenced != null) {
                    Set<String> columns = columnAliases.get(name);
                    if (columns != null && columns.contains(column)) {
                        dereferenced = null;
                    }
                }
                return new SimpleEntry<>(name, dereferenced);
            }
        }
        return super.findReference(schema, name, column);
    }

    @Override
    protected List<String> analize(ParserRuleContext ruleCtx) {
        SelectStmt select = null;
        if (ruleCtx instanceof Select_stmtContext) {
            select = new SelectStmt((Select_stmtContext) ruleCtx);
        } else if (ruleCtx instanceof Select_stmt_no_parensContext) {
            select = new SelectStmt((Select_stmt_no_parensContext) ruleCtx);
        } else {
            return null;
        }
        With_clauseContext with = select.withClause();
        if (with != null) {
            withPerform(with, cte);
        }

        List<String> ret = selectOps(select.selectOps());

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
                    vex.vex(new Vex(vexCtx));
                }
            }
        }

        if (select.of(0) != null) {
            for (Schema_qualified_nameContext tableLock : select.schemaQualifiedName()) {
                addObjectDepcy(tableLock.identifier(), DbObjType.TABLE);
            }
        }
        return ret;
    }

    private List<String> selectOps(SelectOps selectOps) {
        List<String> ret = Collections.emptyList();
        Select_stmtContext selectStmt = selectOps.selectStmt();
        Select_primaryContext primary;

        if (selectOps.leftParen() != null && selectOps.rightParen() != null &&
                selectStmt != null) {
            ret = analize(selectStmt);
        } else if (selectOps.intersect() != null || selectOps.union() != null || selectOps.except() != null) {
            // analyze each in a separate scope
            // use column names from the first one
            ret = new Select(this).selectOps(selectOps.selectOps(0));
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

                ret = new ArrayList<>();
                ValueExpr vex = new ValueExpr(this);
                for (Select_sublistContext target : primary.select_list().select_sublist()) {
                    String column = vex.vex(new Vex(target.vex()));
                    ret.add(target.alias == null ? column : target.alias.getText());
                }

                if ((primary.set_qualifier() != null && primary.ON() != null)
                        || primary.WHERE() != null || primary.HAVING() != null) {
                    for (VexContext v : primary.vex()) {
                        vex.vex(new Vex(v));
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
                ValueExpr vex = new ValueExpr(this);
                for (Values_valuesContext vals : values.values_values()) {
                    for (VexContext v : vals.vex()) {
                        vex.vex(new Vex(v));
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

    private void groupingSet(Ordinary_grouping_setContext groupingSet, ValueExpr vex) {
        VexContext v = groupingSet.vex();
        Row_value_predicand_listContext predicandList;
        if (v != null) {
            vex.vex(new Vex(v));
        } else if ((predicandList = groupingSet.row_value_predicand_list()) != null) {
            for (VexContext predicand : predicandList.vex()) {
                vex.vex(new Vex(predicand));
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
                    new ValueExpr(this).vex(new Vex(joinOn));
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
                List<IdentifierContext> tableIds = table.identifier();
                String tableName = QNameParser.getFirstName(tableIds);

                boolean isCte = tableIds.size() == 1 && hasCte(tableName);
                GenericColumn depcy = null;
                if (!isCte) {
                    depcy = addObjectDepcy(tableIds, DbObjType.TABLE);
                }

                if (alias != null) {
                    String aliasName = alias.alias.getText();
                    if (addReference(aliasName, depcy) && !isCte &&
                            !alias.column_alias.isEmpty()) {
                        for (IdentifierContext columnAlias : alias.column_alias) {
                            addColumnReference(aliasName, columnAlias.getText());
                        }
                    }
                } else if (isCte) {
                    addReference(tableName, null);
                } else {
                    addRawTableReference(depcy);
                }
            } else if ((subquery = primary.table_subquery()) != null) {
                boolean oldLateral = lateralAllowed;
                try {
                    lateralAllowed = primary.LATERAL() != null;
                    new Select(this).analize(subquery.select_stmt());
                    addReference(alias.alias.getText(), null);
                } finally {
                    lateralAllowed = oldLateral;
                }
            } else if ((function = primary.function_call()) != null) {
                boolean oldLateral = lateralAllowed;
                try {
                    lateralAllowed = true;
                    GenericColumn func = new ValueExpr(this).function(function);
                    if (func != null) {
                        String funcAlias = primary.alias == null ? func.table :
                            primary.alias.getText();
                        addReference(funcAlias, null);
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
