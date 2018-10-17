package cz.startnet.utils.pgdiff.parsers.antlr.msexpr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import cz.startnet.utils.pgdiff.parsers.antlr.SQLParser.From_itemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.As_table_aliasContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Derived_tableContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.ExpressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Expression_listContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Full_table_nameContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Function_callContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Join_partContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Open_xmlContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Order_by_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Order_by_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Query_specificationContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Search_conditionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_list_elemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_statementContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Select_stmt_no_parensContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_sourceContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_source_itemContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_source_item_joinedContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Table_sourcesContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.Top_clauseContext;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLParser.With_expressionContext;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.MsSelectOps;
import cz.startnet.utils.pgdiff.parsers.antlr.rulectx.MsSelectStmt;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import ru.taximaxim.codekeeper.apgdiff.Log;

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
    protected Entry<String, GenericColumn> findReferenceInNmspc(String schema, String name, String column) {
        return !inFrom || lateralAllowed ? super.findReferenceInNmspc(schema, name, column) : null;
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
            // from defines the namespace so it goes before everything else
            if (query.FROM() != null) {
                boolean oldFrom = inFrom;
                try {
                    inFrom = true;
                    Table_sourcesContext sources = query.table_sources();
                    if (sources != null) {
                        for (Table_sourceContext ctx : sources.table_source()) {
                            source(ctx);
                        }
                    }
                } finally {
                    inFrom = oldFrom;
                }
            }

            ret = new ArrayList<>();
            MsValueExpr vex = new MsValueExpr(this);
            for (Select_list_elemContext target : query.select_list().select_list_elem()) {
                ExpressionContext exp = target.expression();
                if (exp != null) {
                    /*String column =*/ vex.analyze(exp);
                    /*ret.add(target.column_alias() == null ? column : target.column_alias().getText());*/
                }
            }

            // TODO select into
            // https://msdn.microsoft.com/en-us/library/ms188029.aspx

            if (query.HAVING() != null || query.WHERE() != null) {
                for (Search_conditionContext search : query.search_condition()) {
                    vex.search(search);
                }
            }

            if (query.GROUP() != null) {
                for (ExpressionContext exp : query.expression()) {
                    vex.analyze(exp);
                }
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
        } else {
            Log.log(Log.LOG_WARNING, "No alternative in SelectOps!");
        }
        return ret;
    }

    private void source(Table_sourceContext sourceCtx) {
        Table_source_item_joinedContext source = sourceCtx.table_source_item_joined();
        // first of all JOIN?
        from(source.table_source_item());
        for (Join_partContext join : source.join_part()) {
            join(join);
        }
    }

    private void join(Join_partContext join) {
        Table_sourceContext source = join.table_source();
        Table_source_itemContext item;
        MsValueExpr vex = new MsValueExpr(this);

        if (source != null) {
            source(source);
            vex.search(join.search_condition());
        } else if ((item = join.table_source_item()) != null) {
            from(item);
        } else if (join.PIVOT() != null) {
            vex.aggregate(join.aggregate_windowed_function());
            addReference(join.as_table_alias().id().getText(), null);
        } else if (join.UNPIVOT() != null) {
            vex.analyze(join.expression());
            addReference(join.as_table_alias().id().getText(), null);
        } else {
            Log.log(Log.LOG_WARNING, "No alternative in join!");
        }
    }

    private void from(Table_source_itemContext item) {
        Function_callContext call = item.function_call();
        As_table_aliasContext alias = item.as_table_alias();
        Derived_tableContext der;
        Open_xmlContext xml;
        Full_table_nameContext table;

        MsValueExpr vex = new MsValueExpr(this);

        if (call != null) {
            boolean oldLateral = lateralAllowed;
            try {
                lateralAllowed = true;
                GenericColumn func = vex.functionCall(call);
                if (func != null) {
                    String funcAlias = alias == null ? func.table : alias.getText();
                    addReference(funcAlias, null);
                }
            } finally {
                lateralAllowed = oldLateral;
            }
        } else if ((xml = item.open_xml()) != null) {
            for (ExpressionContext exp : xml.expression()) {
                vex.analyze(exp);
            }
        } else if ((der = item.derived_table()) != null) {
            Select_statementContext sel = der.select_statement();
            if (sel != null) {
                new MsSelect(this).analyze(sel);
            } else {
                for (Expression_listContext list : der.table_value_constructor().expression_list()) {
                    vex.expressionList(list);
                }
            }
            if (alias != null) {
                addReference(alias.id().getText(), null);
            }
        } else if ((table = item.full_table_name()) != null) {
            addNameReference(table, alias);
        } else if (alias != null) {
            addReference(alias.id().getText(), null);
        }
    }
}
