package cz.startnet.utils.pgdiff.parsers.antlr.msexpr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.As_table_aliasContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Derived_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Expression_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.From_itemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.From_primaryContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Full_table_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Function_callContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Open_xmlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Order_by_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Order_by_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Query_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Search_conditionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_list_elemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_value_constructorContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Top_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.With_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.MsSelectOps;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.MsSelectStmt;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class MsSelect extends MsAbstractExprWithNmspc<Select_statementContext> {

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

    protected MsSelect(MsAbstractExpr parent) {
        super(parent);
    }

    public MsSelect(String schema) {
        super(schema);
    }

    @Override
    protected Entry<String, GenericColumn> findReferenceInNmspc(String schema, String name) {
        return !inFrom || lateralAllowed ? super.findReferenceInNmspc(schema, name) : null;
    }

    @Override
    public List<String> analyze(Select_statementContext ruleCtx) {
        return analyze(new MsSelectStmt(ruleCtx));
    }

    public List<String> analyze(Select_stmt_no_parensContext ruleCtx) {
        return analyze(new MsSelectStmt(ruleCtx));
    }

    public List<String> analyze(MsSelectStmt select) {
        With_expressionContext with = select.withExpression();
        if (with != null) {
            analyzeCte(with);
        }

        return selectOps(select.selectOps());
    }

    private List<String> selectOps(MsSelectOps selectOps) {
        List<String> ret = Collections.emptyList();
        Select_statementContext selectStmt = selectOps.selectStmt();
        Query_specificationContext query;

        if (selectOps.leftParen() != null && selectOps.rightParen() != null && selectStmt != null) {
            ret = analyze(selectStmt);
        } else if (selectOps.intersect() != null || selectOps.union() != null || selectOps.except() != null) {
            // analyze each in a separate scope
            // use column names from the first one
            ret = new MsSelect(this).selectOps(selectOps.selectOps(0));
            new MsSelect(this).selectOps(selectOps.selectOps(1));
        } else if ((query = selectOps.querySpecification()) != null) {
            Table_value_constructorContext values = query.table_value_constructor();
            if (values != null) {
                for (Expression_listContext list : values.expression_list()) {
                    new MsValueExpr(this).expressionList(list);
                }
            } else {
                ret = select(query);
            }
        } else {
            Log.log(Log.LOG_WARNING, "No alternative in SelectOps!");
        }
        return ret;
    }

    private List<String> select(Query_specificationContext query) {
        // from defines the namespace so it goes before everything else
        if (query.FROM() != null) {
            boolean oldFrom = inFrom;
            try {
                inFrom = true;
                if (query.FROM() != null) {
                    for (From_itemContext item : query.from_item()) {
                        from(item);
                    }
                }
            } finally {
                inFrom = oldFrom;
            }
        }

        MsValueExpr vex = new MsValueExpr(this);
        List<String> ret = new ArrayList<>();

        for (Select_list_elemContext target : query.select_list().select_list_elem()) {
            ExpressionContext exp = target.expression();
            if (exp != null) {
                /*String column =*/ vex.analyze(exp);
                /*ret.add(target.column_alias() == null ? column : target.column_alias().getText());*/
            } else {
                //TODO star, difficult
            }
        }

        if (query.INTO() != null) {
            addObjectDepcy(query.full_table_name(), DbObjType.TABLE);
        }

        // HAVING and WHERE parts
        for (Search_conditionContext search : query.search_condition()) {
            vex.search(search);
        }

        // GROUP part
        for (ExpressionContext exp : query.expression()) {
            vex.analyze(exp);
        }

        Top_clauseContext tc = query.top_clause();
        if (tc != null) {
            ExpressionContext exp = tc.top_count().expression();
            if (exp != null) {
                vex.analyze(exp);
            }
        }

        Order_by_clauseContext order = query.order_by_clause();
        if (order != null) {
            for (Order_by_expressionContext orderExp : order.order_by_expression()) {
                vex.analyze(orderExp.expression());
            }

            for (ExpressionContext exp : order.expression()) {
                vex.analyze(exp);
            }
        }

        return ret;
    }

    private void from(From_itemContext item) {
        From_primaryContext primary;

        if (item.sub_item != null) {
            from(item.sub_item);
        } else if (item.PIVOT() != null) {
            new MsValueExpr(this).aggregate(item.aggregate_windowed_function());
            addReference(item.as_table_alias().id().getText(), null);
            from(item.from_item(0));
            // addColumnDepcy
        } else if (item.UNPIVOT() != null) {
            new MsValueExpr(this).analyze(item.expression());
            addReference(item.as_table_alias().id().getText(), null);
            from(item.from_item(0));
        } else if (item.JOIN() != null || item.APPLY() != null) {
            from(item.from_item(0));
            if (item.APPLY() != null) {
                boolean oldLateral = lateralAllowed;
                try {
                    lateralAllowed = true;
                    from(item.from_item(1));
                } finally {
                    lateralAllowed = oldLateral;
                }
            } else {
                from(item.from_item(1));
            }

            if (item.ON() != null) {
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
                    MsValueExpr vexOn = new MsValueExpr(this);
                    vexOn.search(item.search_condition());
                } finally {
                    lateralAllowed = oldLateral;
                }
            }
        } else if ((primary = item.from_primary()) != null) {
            primary(primary);
        } else {
            Log.log(Log.LOG_WARNING, "No alternative in from_item!");
        }
    }

    private void primary(From_primaryContext item) {
        Function_callContext call = item.function_call();
        As_table_aliasContext alias = item.as_table_alias();
        Derived_tableContext der;
        Open_xmlContext xml;
        Full_table_nameContext table;

        if (call != null) {
            boolean oldLateral = lateralAllowed;
            try {
                lateralAllowed = true;
                GenericColumn func = new MsValueExpr(this).functionCall(call);
                if (func != null) {
                    String funcAlias = alias == null ? func.table : alias.getText();
                    addReference(funcAlias, null);
                }
            } finally {
                lateralAllowed = oldLateral;
            }
        } else if ((xml = item.open_xml()) != null) {
            for (ExpressionContext exp : xml.expression()) {
                new MsValueExpr(this).analyze(exp);
            }
            if (alias != null) {
                addReference(alias.id().getText(), null);
            }
        } else if ((der = item.derived_table()) != null) {
            new MsSelect(this).analyze(der.select_statement());
            addReference(alias.id().getText(), null);
        } else if ((table = item.full_table_name()) != null) {
            addNameReference(table, alias);
        } else if (alias != null) {
            addReference(alias.id().getText(), null);
        }
        //change_table
    }
}
