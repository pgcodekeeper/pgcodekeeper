package cz.startnet.utils.pgdiff.parsers.antlr.expr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.antlr.v4.runtime.ParserRuleContext;

import cz.startnet.utils.pgdiff.parsers.antlr.QNameParser;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.After_opsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Alias_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Array_bracketsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Array_elementsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Array_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Case_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Cast_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Comparison_modContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Datetime_overlapsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Extract_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Filter_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Frame_boundContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Frame_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.From_itemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.From_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_callContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Function_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Groupby_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Grouping_elementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Grouping_element_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.IdentifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Indirection_identifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Orderby_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Partition_by_columnsContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Schema_qualified_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Select_sublistContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Sort_specifierContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.String_value_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.System_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Table_subqueryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Value_expression_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Values_stmtContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Values_valuesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.VexContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Vex_bContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Vex_or_named_notationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Window_definitionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.With_queryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.Xml_functionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectOps;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.SelectStmt;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.Vex;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffUtils;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class ViewSelect {

    private final ViewSelect parent;
    private final Set<GenericColumn> depcies;

    public Set<GenericColumn> getDepcies() {
        return Collections.unmodifiableSet(depcies);
    }

    /**
     * CTE names that current level of FROM has access to.
     */
    private final Set<String> cte = new HashSet<>();

    public ViewSelect() {
        parent = null;
        depcies = new LinkedHashSet<>();
    }

    private ViewSelect(ViewSelect parent) {
        this.parent = parent;
        depcies = parent.depcies;
    }

    private ViewSelect findCte(String cteName) {
        if (cte.contains(cteName)) {
            return this;
        }

        return parent == null ? null : parent.findCte(cteName);
    }

    private void addNameReference(Schema_qualified_nameContext name) {
        List<IdentifierContext> ids = name.identifier();
        String firstName = QNameParser.getFirstName(ids);

        boolean isCte = ids.size() == 1 && findCte(firstName) != null;
        String schemaName = QNameParser.getSchemaName(ids);
        if (!isCte && schemaName != null && !ApgdiffUtils.isPgSystemSchema(schemaName)) {
            depcies.add(new GenericColumn(schemaName,
                    QNameParser.getFirstName(ids), DbObjType.TABLE));
        }
    }

    public void analyze(SelectStmt select) {
        With_clauseContext with = select.withClause();
        if (with != null) {
            analyzeCte(with);
        }

        selectOps(select.selectOps());

        for (After_opsContext after : select.afterOps()) {
            VexContext vexCtx = after.vex();
            if (vexCtx != null) {
                analyze(new Vex(vexCtx));
            }

            Orderby_clauseContext orderBy = after.orderby_clause();
            if (orderBy != null) {
                orderBy(orderBy);
            }
        }
    }

    private void analyze(ParserRuleContext ruleCtx) {
        if (ruleCtx instanceof Select_stmtContext) {
            analyze(new SelectStmt((Select_stmtContext) ruleCtx));
        } else if (ruleCtx instanceof Select_stmt_no_parensContext) {
            analyze(new SelectStmt((Select_stmt_no_parensContext) ruleCtx));
        } else {
            throw new IllegalStateException("Not a select ctx");
        }
    }

    private void analyzeCte(With_clauseContext with) {
        for (With_queryContext withQuery : with.with_query()) {
            String withName = withQuery.query_name.getText();

            Select_stmtContext withSelect = withQuery.select_stmt();
            if (withSelect != null) {
                // add CTE name to the visible CTEs list after processing the query for normal CTEs
                // and before for recursive ones
                ViewSelect withProcessor = new ViewSelect(this);
                boolean added;
                if (with.RECURSIVE() != null) {
                    added = cte.add(withName);
                    withProcessor.analyze(withSelect);
                } else {
                    withProcessor.analyze(withSelect);
                    added = cte.add(withName);
                }
                if (!added) {
                    Log.log(Log.LOG_WARNING, "Duplicate CTE " + withName);
                }
            } else {
                Log.log(Log.LOG_WARNING, "Skipped analisys of modifying CTE " + withName);
            }
        }
    }

    private void selectOps(SelectOps selectOps) {
        Select_stmtContext selectStmt = selectOps.selectStmt();
        Select_primaryContext primary = selectOps.selectPrimary();

        if (selectOps.intersect() != null || selectOps.union() != null || selectOps.except() != null) {
            // analyze each in a separate scope
            new ViewSelect(this).selectOps(selectOps.selectOps(0));

            ViewSelect viewSelect = new ViewSelect(this);
            SelectOps ops = selectOps.selectOps(1);
            if (ops != null) {
                viewSelect.selectOps(ops);
            } else if (primary != null) {
                viewSelect.selectPrimary(primary);
            } else if (selectStmt != null) {
                viewSelect.analyze(selectStmt);
            } else {
                Log.log(Log.LOG_WARNING, "No alternative in right part of SelectOps!");
            }
        } else if (selectOps.leftParen() != null && selectOps.rightParen() != null && selectStmt != null) {
            analyze(selectStmt);
        } else if (primary != null) {
            selectPrimary(primary);
        } else {
            Log.log(Log.LOG_WARNING, "No alternative in SelectOps!");
        }
    }


    private void selectPrimary(Select_primaryContext primary) {
        Values_stmtContext values;

        if (primary.SELECT() != null) {
            // from defines the namespace so it goes before everything else
            if (primary.FROM() != null) {
                for (From_itemContext fromItem : primary.from_item()) {
                    from(fromItem);
                }
            }

            for (Select_sublistContext t : primary.select_list().select_sublist()) {
                analyze(new Vex(t.vex()));
            }

            if ((primary.set_qualifier() != null && primary.ON() != null)
                    || primary.WHERE() != null || primary.HAVING() != null) {
                for (VexContext v : primary.vex()) {
                    analyze(new Vex(v));
                }
            }

            Groupby_clauseContext groupBy = primary.groupby_clause();
            if (groupBy != null) {
                groupBy(groupBy.grouping_element_list());
            }

            if (primary.WINDOW() != null) {
                for (Window_definitionContext window : primary.window_definition()) {
                    window(window);
                }
            }
        } else if (primary.TABLE() != null) {
            List<IdentifierContext> ids = primary.schema_qualified_name().identifier();
            String schemaName = QNameParser.getSchemaName(ids);
            if (schemaName != null && !ApgdiffUtils.isPgSystemSchema(schemaName)) {
                depcies.add(new GenericColumn(schemaName, QNameParser.getFirstName(ids),
                        DbObjType.TABLE));
            }
        } else if ((values = primary.values_stmt()) != null) {
            for (Values_valuesContext vals : values.values_values()) {
                for (VexContext v : vals.vex()) {
                    analyze(new Vex(v));
                }
            }
        } else {
            Log.log(Log.LOG_WARNING, "No alternative in select_primary!");
        }
    }

    private void groupBy(Grouping_element_listContext list) {
        for (Grouping_elementContext el : list.grouping_element()) {
            VexContext vexCtx = el.vex();
            Grouping_element_listContext sub;
            if (vexCtx != null) {
                analyze(new Vex(vexCtx));
            } else if ((sub = el.c) != null) {
                groupBy(sub);
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
                ViewSelect fromProcessor = new ViewSelect(this);
                fromProcessor.from(fromItem.from_item(0));
            } else {
                from(fromItem.from_item(0));
            }
        } else if (fromItem.JOIN() != null) {
            from(fromItem.from_item(0));
            from(fromItem.from_item(1));

            if (fromItem.ON() != null) {
                VexContext joinOn = fromItem.vex();
                analyze(new Vex(joinOn));
            }
        } else if ((primary = fromItem.from_primary()) != null) {
            List<Function_callContext> functions = primary.function_call();
            Schema_qualified_nameContext table;
            Table_subqueryContext subquery;

            if (!functions.isEmpty()) {
                functions.forEach(this::function);
            } else if ((table = primary.schema_qualified_name()) != null) {
                addNameReference(table);
            } else if ((subquery = primary.table_subquery()) != null) {
                new ViewSelect(this).analyze(subquery.select_stmt());
            } else {
                Log.log(Log.LOG_WARNING, "No alternative in from_primary!");
            }
        } else {
            Log.log(Log.LOG_WARNING, "No alternative in from_item!");
        }
    }

    private void analyze(Vex vex) {
        Select_stmt_no_parensContext selectStmt;
        Datetime_overlapsContext overlaps;
        Value_expression_primaryContext primary;
        boolean doneWork = true;

        if (vex.in() != null && vex.leftParen() != null && vex.rightParen() != null &&
                (selectStmt = vex.selectStmt()) != null) {
            new ViewSelect(this).analyze(selectStmt);
        } else if ((overlaps = vex.datetimeOverlaps()) != null) {
            for (VexContext v : overlaps.vex()) {
                analyze(new Vex(v));
            }
        } else if ((primary = vex.primary()) != null) {
            analysePrimary(primary);
        } else {
            doneWork = false;
        }

        List<Vex> operands = vex.vex();
        if (!operands.isEmpty()) {
            for (Vex v : operands) {
                analyze(v);
            }
        } else if (!doneWork) {
            Log.log(Log.LOG_WARNING, "No alternative in Vex!");
        }
    }

    private void analysePrimary(Value_expression_primaryContext primary) {
        Select_stmt_no_parensContext subSelectStmt = primary.select_stmt_no_parens();
        Case_expressionContext caseExpr;
        Comparison_modContext compMod;
        Table_subqueryContext subquery;
        Function_callContext function;
        Indirection_identifierContext indirection;
        Array_expressionContext array;
        ArrayList<Vex> subOperands = null;

        if (primary.LEFT_PAREN() != null && primary.RIGHT_PAREN() != null &&
                subSelectStmt != null) {
            new ViewSelect(this).analyze(subSelectStmt);
        } else if ((caseExpr = primary.case_expression()) != null) {
            subOperands = addVexCtxtoList(subOperands, caseExpr.vex());
        } else if ((compMod = primary.comparison_mod()) != null) {
            VexContext compModVex = compMod.vex();
            if (compModVex != null) {
                analyze(new Vex(compModVex));
            } else {
                new ViewSelect(this).analyze(compMod.select_stmt_no_parens());
            }
        } else if (primary.EXISTS() != null &&
                (subquery = primary.table_subquery()) != null) {
            new ViewSelect(this).analyze(subquery.select_stmt());
        } else if ((function = primary.function_call()) != null) {
            function(function);
        } else if ((indirection = primary.indirection_identifier()) != null) {
            analyze(new Vex(indirection.vex()));
        } else if ((array = primary.array_expression()) != null) {
            Array_bracketsContext arrayb = array.array_brackets();
            if (arrayb != null) {
                arrayElements(subOperands, arrayb.array_elements());
            } else {
                new ViewSelect(this).analyze(array.array_query().table_subquery().select_stmt());
            }
        }

        if (subOperands != null) {
            for (Vex v : subOperands) {
                analyze(v);
            }
        }
    }

    private void arrayElements(ArrayList<Vex> subOperands, Array_elementsContext elements) {
        addVexCtxtoList(subOperands,  elements.vex());
        for (Array_elementsContext sub : elements.array_elements()) {
            arrayElements(subOperands, sub);
        }
    }

    private void window(Window_definitionContext window) {
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

    private void orderBy(Orderby_clauseContext orderBy) {
        for (Sort_specifierContext sort : orderBy.sort_specifier_list().sort_specifier()) {
            analyze(new Vex(sort.vex()));
        }
    }

    /**
     * @return function reference or null for internal functions
     */
    private void function(Function_callContext function) {
        ArrayList<Vex> args = null;

        Function_nameContext name = function.function_name();

        Extract_functionContext extract;
        String_value_functionContext string;
        System_functionContext sys;
        Xml_functionContext xml;

        if (name != null){
            args = addVexCtxtoList(args, function.vex_or_named_notation(),
                    Vex_or_named_notationContext::vex);

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
        } else if ((extract = function.extract_function()) != null) {
            analyze(new Vex(extract.vex()));
        } else if ((string = function.string_value_function()) != null) {
            args = addVexCtxtoList(args, string.vex());

            Vex_bContext vexB = string.vex_b();
            if (vexB != null) {
                analyze(new Vex(vexB));
            }
        } else if ((xml = function.xml_function()) != null) {
            args = addVexCtxtoList(args, xml.vex());
        } else if ((sys = function.system_function()) != null) {
            Cast_specificationContext cast = sys.cast_specification();
            if (cast != null) {
                analyze(new Vex(cast.vex()));
            }
        }

        if (args != null) {
            for (Vex v : args) {
                analyze(v);
            }
        }
    }

    private ArrayList<Vex> addVexCtxtoList(ArrayList<Vex> list, List<VexContext> ctx) {
        return addVexCtxtoList(list, ctx, Function.identity());
    }

    private <T extends ParserRuleContext> ArrayList<Vex> addVexCtxtoList(
            ArrayList<Vex> list, List<T> ctx, Function<T, VexContext> getVex) {
        ArrayList<Vex> l = list;
        int toAdd = ctx.size();
        if (toAdd != 0) {
            if (l == null) {
                l = new ArrayList<>(toAdd);
            } else {
                l.ensureCapacity(l.size() + toAdd);
            }
            for (T c: ctx) {
                l.add(new Vex(getVex.apply(c)));
            }
        }
        return l;
    }
}
