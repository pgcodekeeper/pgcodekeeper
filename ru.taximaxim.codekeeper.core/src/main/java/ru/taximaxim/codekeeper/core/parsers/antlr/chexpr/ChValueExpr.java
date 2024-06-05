/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.parsers.antlr.chexpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Alias_exprContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Arg_exprContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.ExprContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Expr_listContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Expr_primaryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Function_callContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.LiteralContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Order_by_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Select_modeContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Window_exprContext;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation.LocationType;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.Pair;

public final class ChValueExpr extends ChAbstractExpr {

    protected ChValueExpr(ChAbstractExpr parent) {
        super(parent);
    }

    public ChValueExpr(MetaContainer meta) {
        super(meta);
    }

    public void analyze(ExprContext expr) {
        var aliasExpr = expr.alias_expr();
        analyzeExprs(expr.expr());

        primary(expr.expr_primary(), aliasExpr);

        var likeExpr = expr.like_expr();
        if (likeExpr != null) {
            analyze(likeExpr.expr());
        }

        selectMode(expr.select_mode());
    }

    private void selectMode(Select_modeContext selectMode) {
        if (selectMode == null) {
            return;
        }

        if (selectMode.APPLY() != null) {
            functionCall(selectMode.function_call());
            var lambda = selectMode.lambda_expr();
            if (lambda != null) {
                analyze(lambda.expr());
            }
            return;
        }

        if (selectMode.EXCEPT() != null) {
            analyzeExprs(selectMode.expr_list());
            addDynamicColumnDepcies(selectMode.literal(), false);
            return;
        }

        if (selectMode.REPLACE() != null) {
            analyze(selectMode.expr());
        }
    }

    private GenericColumn primary(Expr_primaryContext exprPrimary, Alias_exprContext aliasExpr) {
        if (exprPrimary == null) {
            return null;
        }

        var fc = exprPrimary.function_call();
        if (fc != null) {
            return functionCall(fc);
        }

        var selectCtx = exprPrimary.select_stmt_no_parens();
        if (selectCtx != null) {
            new ChSelect(this).analyze(selectCtx);
            return null;
        }

        var stmtQualNameCtx = exprPrimary.qualified_name();
        if (stmtQualNameCtx != null) {
            if (aliasExpr != null) {
                addReferenceInRootParent(stmtQualNameCtx, aliasExpr.alias_clause(), false);
            }
            return qualifiedName(stmtQualNameCtx);
        }

        analyzeExprs(exprPrimary.expr_list());
        addDynamicColumnDepcies(exprPrimary.literal(), true);
        return null;
    }

    private GenericColumn qualifiedName(Qualified_nameContext qualNameCtx) {
        var ids = qualNameCtx.identifier();
        if (ids.size() == 1) {
            var relCol = findColumn(qualNameCtx.getText());
            if (relCol != null) {
                return addColumnDepcy(qualNameCtx, relCol);
            }
        }

        var columnName = QNameParser.getFirstName(ids);
        var tableName = QNameParser.getSecondName(ids);
        var ref = findReference(null, tableName);
        if (ref == null) {
            // if we don't found reference by alias try to find table in metadata where tableName will be schemaName
            // and columnName will be relationName
            if (findRelation(tableName, columnName) != null) {
                return addObjectDepcy(qualNameCtx, DbObjType.TABLE);
            }
            return null;
        }

        GenericColumn parent = ref.getValue();
        if (parent == null) {
            return null;
        }

        var schemaName = QNameParser.getThirdName(ids);
        if (schemaName != null) {
            addDepcy(new GenericColumn(schemaName, DbObjType.SCHEMA), QNameParser.getThirdNameCtx(ids));
        }

        var tableCtx = QNameParser.getSecondNameCtx(ids);
        var tName = parent.table;
        if (Objects.equals(tableName, tName)) {
            addDepcy(parent, tableCtx);
        }

        var column = new GenericColumn(parent.schema, tName, columnName, DbObjType.COLUMN);

        addDepcy(column, QNameParser.getFirstNameCtx(ids));
        addReference(parent, tableCtx, LocationType.LOCAL_REF);
        return column;
    }

    protected GenericColumn functionCall(Function_callContext functionCall) {
        if (functionCall == null) {
            return null;
        }
        if (functionCall.COLUMNS() != null) {
            addDynamicColumnDepcies(functionCall.column, true);
            return null;
        }

        analyzeExprs(functionCall.expr());
        analyzeExprs(functionCall.expr_list());

        var windowExpr = functionCall.window_expr();
        if (windowExpr != null) {
            window(windowExpr);
            return null;
        }

        var funcName = functionCall.name;
        if (funcName == null) {
            return null;
        }

        var argList = functionCall.arg_list();
        if (argList == null) {
            return null;
        }

        List<ExprContext> exprs = argList.arg_expr().stream()
                .map(Arg_exprContext::expr)
                .filter(e -> e != null)
                .collect(Collectors.toList());
        analyzeExprs(exprs);
        GenericColumn depcy = new GenericColumn(funcName.getText(), DbObjType.FUNCTION);
        addDepcy(depcy, funcName);
        return depcy;
    }

    protected void window(Window_exprContext windowExpr) {
        analyzeExprs(windowExpr.expr_list());
        orderBy(windowExpr.order_by_clause());
    }

    protected void orderBy(Order_by_clauseContext orderBy) {
        if (orderBy == null) {
            return;
        }

        var orderList = orderBy.order_expr_list();
        if (orderList == null) {
            return;
        }

        for (var orderExprCtx : orderList.order_expr()) {
            analyze(orderExprCtx.expr());

            var withFillCtx = orderExprCtx.with_fill();
            if (withFillCtx != null) {
                analyzeExprs(withFillCtx.expr());
                analyzeExprs(withFillCtx.expr_list());
            }
        }
    }

    protected void analyzeExprs(Expr_listContext exprList) {
        if (exprList != null) {
            analyzeExprs(exprList.expr());
        }
    }

    protected void analyzeExprs(List<ExprContext> exprs) {
        if (exprs != null) {
            exprs.forEach(this::analyze);
        }
    }

    private GenericColumn addColumnDepcy(Qualified_nameContext qualNameCtx,
            Pair<IRelation, Pair<String, String>> relCol) {
        IRelation rel = relCol.getFirst();
        Pair<String, String> col = relCol.getSecond();
        var column = new GenericColumn(rel.getSchemaName(), rel.getName(), col.getFirst(), DbObjType.COLUMN);
        addDepcy(column, qualNameCtx);
        return column;
    }

    private void addDynamicColumnDepcies(LiteralContext lit, boolean include) {
        if (lit == null) {
            return;
        }

        var rawNamePart = lit.getText();
        var contains = rawNamePart.startsWith("\'");
        var namePart = rawNamePart.replace("\'","");
        // TODO add when we will understood how processing in ClickHouse this cases when argument is array
        if (namePart.startsWith("[") && namePart.endsWith("]")) {
            return;
        }

        List<GenericColumn> tempDepcies = new ArrayList<>();
        for (var depcy : getDepcies()) {
            var obj = depcy.getObj();
            if (obj.type != DbObjType.TABLE) {
                continue;
            }
            var rel = findRelation(obj.schema, obj.table);
            if (rel != null) {
                rel.getRelationColumns()
                .filter(e -> isNeedColumn(e.getFirst(), namePart, include, contains))
                .forEach(e ->
                tempDepcies.add(new GenericColumn(rel.getSchemaName(), rel.getName(), e.getFirst(), DbObjType.COLUMN)));
            }
        }
        tempDepcies.forEach(e -> addDepcy(e, lit));
    }

    /**
     * This method need for understanding from which columns we have depence when user use dynamic column selection
     *
     * @param name     - name of column
     * @param namePart - condition for filter
     * @param include  - true/false include/exclude
     * @param contains - true/false check that name contains/equals namePart
     * @return boolean - if true we will be add this column at the depcies, and if false exclude
     */
    private boolean isNeedColumn(String name, String namePart, boolean include, boolean contains) {
        if (contains) {
            var cont = name.contains(namePart);
            return include ? cont : !cont;
        }
        var eq = name.equals(namePart);
        return include ? eq : !eq;
    }
}