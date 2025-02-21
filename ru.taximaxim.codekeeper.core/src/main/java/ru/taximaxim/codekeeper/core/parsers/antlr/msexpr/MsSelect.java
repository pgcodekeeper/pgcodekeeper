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
package ru.taximaxim.codekeeper.core.parsers.antlr.msexpr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.As_table_aliasContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Change_tableContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Column_declarationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Derived_tableContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Expression_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.From_itemContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.From_primaryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Full_column_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Function_callContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Open_jsonContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Open_xmlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Order_by_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Order_by_expressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Primary_key_valuesContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Query_specificationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Schema_declarationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Search_conditionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Select_list_elemContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Select_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Select_stmt_no_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Table_value_constructorContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Top_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Window_specificationContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.With_expressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.MsSelectOps;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.MsSelectStmt;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

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

    public MsSelect(String schema, MetaContainer meta) {
        super(schema, meta);
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
            log("No alternative in SelectOps!");
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

        window(query.window_specification());

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
            addObjectDepcy(query.qualified_name(), DbObjType.TABLE);
        }

        // HAVING and WHERE parts
        for (Search_conditionContext search : query.search_condition()) {
            vex.search(search);
        }

        // GROUP part
        var group = query.group_by_clause();
        if (group != null) {
            var expList = group.expression_list();
            if (expList != null) {
                vex.expressionList(expList);
            } else {
                for (var groupItem : group.group_by_item()) {
                    for (var item : groupItem.grouping_sets_item()) {
                        for (var exp : item.expression()) {
                            vex.analyze(exp);
                        }
                    }
                }
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

        return ret;
    }

    private void window(Window_specificationContext windowCtx) {
        if (windowCtx == null) {
            return;
        }

        var expr = new MsValueExpr(this);
        expr.expressionList(windowCtx.expression_list());
        expr.orderBy(windowCtx.order_by_clause());
    }

    void from(From_itemContext item) {
        From_primaryContext primary;
        if (item.sub_item != null) {
            from(item.sub_item);
        } else if (item.PIVOT() != null) {
            new MsValueExpr(this).functionCall(item.function_call());
            addReference(item.as_table_alias().id().getText(), null);
            from(item.from_item(0));
            addColumnDepcy(item.full_column_name());
        } else if (item.UNPIVOT() != null) {
            new MsValueExpr(this).analyze(item.expression());
            addReference(item.as_table_alias().id().getText(), null);
            from(item.from_item(0));
            addColumnDepcy(item.full_column_name());
            for (Full_column_nameContext fcn : item.full_column_name_list().full_column_name()) {
                addColumnDepcy(fcn);
            }
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
            log("No alternative in from_item!");
        }
    }

    private void primary(From_primaryContext item) {
        Function_callContext call = item.function_call();
        As_table_aliasContext alias = item.as_table_alias();
        Derived_tableContext der;
        Open_xmlContext xml;
        Open_jsonContext json;
        Change_tableContext ct;
        Qualified_nameContext table;

        if (call != null) {
            boolean oldLateral = lateralAllowed;
            try {
                lateralAllowed = true;
                GenericColumn func = new MsValueExpr(this).functionCall(call);
                String funcAlias = alias != null ? alias.id().getText()
                        : func != null ? func.table : null;
                if (funcAlias != null) {
                    addReference(funcAlias, null);
                }
            } finally {
                lateralAllowed = oldLateral;
            }
        } else if ((xml = item.open_xml()) != null) {
            MsValueExpr exp = new MsValueExpr(this);
            exp.analyze(xml.expression());
            exp.expressionList(xml.expression_list());
            Schema_declarationContext dec = xml.schema_declaration();
            if (dec != null) {
                for (Column_declarationContext col : dec.column_declaration()) {
                    addTypeDepcy(col.data_type());
                }
            }
            if (alias != null) {
                addReference(alias.id().getText(), null);
            }
        } else if ((json = item.open_json()) != null) {
            MsValueExpr exp = new MsValueExpr(this);
            for (ExpressionContext expCtx : json.expression()) {
                exp.analyze(expCtx);
            }
            for (Column_declarationContext col : json.column_declaration()) {
                addTypeDepcy(col.data_type());
            }
            if (alias != null) {
                addReference(alias.id().getText(), null);
            }
        } else if ((der = item.derived_table()) != null) {
            new MsSqlClauses(this).dml(der.dml_clause());
            addReference(alias.id().getText(), null);
        } else if ((table = item.qualified_name()) != null) {
            addNameReference(table, alias);
        } else if ((ct = item.change_table()) != null) {
            addNameReference(ct.qualified_name(), alias);
            Primary_key_valuesContext values = ct.primary_key_values();
            if (values != null) {
                for (Full_column_nameContext fcn : values.full_column_name_list().full_column_name()) {
                    addColumnDepcy(fcn);
                }
                new MsValueExpr(this).expressionList(values.expression_list());
            }
        } else if (alias != null) {
            addReference(alias.id().getText(), null);
        }
    }
}
