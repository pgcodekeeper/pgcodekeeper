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

import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.QNameParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.ExprContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Expr_primaryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Function_callContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IRelation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class ChValueExpr extends ChAbstractExpr {

    protected ChValueExpr(ChAbstractExpr parent) {
        super(parent);
    }

    public ChValueExpr(MetaContainer meta) {
        super(meta);
    }

    public void analyze(ExprContext expr) {
        for (ExprContext v : expr.expr()) {
            analyze(v);
        }

        var exprPrimary = expr.expr_primary();
        if (exprPrimary != null) {
            exprPrimary(exprPrimary);
        }
    }

    private void exprPrimary(Expr_primaryContext exprPrimary) {
        var fc = exprPrimary.function_call();
        if (fc != null) {
            functionCall(fc);
            return;
        }

        var selectCtx = exprPrimary.select_stmt_no_parens();
        if (selectCtx != null) {
            new ChSelect(this).analyze(selectCtx);
            return;
        }

        var stmtNameCtx = exprPrimary.qualified_name();
        if (stmtNameCtx != null) {
            var relCol = findColumn(stmtNameCtx.getText());
            if (relCol != null) {
                addColumnDepcy(exprPrimary, relCol);
                return;
            }

            addObjectDepcy(stmtNameCtx, DbObjType.TABLE);
            return;
        }

        var exprList = exprPrimary.expr_list();
        if (exprList != null) {
            for (var e : exprList.expr()) {
                analyze(e);
            }
        }
    }

    public void functionCall(Function_callContext functionCall) {
        for (ExprContext exp : functionCall.expr()) {
            analyze(exp);
        }

        var list = functionCall.expr_list();
        if (list != null) {
            for (ExprContext exp : list.expr()) {
                analyze(exp);
            }
        }

        var funcName = functionCall.name;
        if (funcName != null) {
            addDepcy(new GenericColumn(funcName.getText(), DbObjType.FUNCTION), funcName);
        }

        var argList = functionCall.arg_list();
        if (argList == null) {
            return;
        }

        for (var argExpr : argList.arg_expr()) {
            var expr = argExpr.expr();
            if (expr != null) {
                analyze(expr);
            }
        }
    }

    private void addColumnDepcy(Expr_primaryContext exprPrimary, Pair<IRelation, Pair<String, String>> relCol) {
        IRelation rel = relCol.getFirst();
        Pair<String, String> col = relCol.getSecond();
        addDepcy(new GenericColumn(rel.getSchemaName(), rel.getName(), col.getFirst(), DbObjType.COLUMN), exprPrimary);
    }

    protected void addObjectDepcy(Qualified_nameContext qualifiedName,
            DbObjType type) {
        var ids = qualifiedName.identifier();
        var schemaCtx = QNameParser.getSchemaNameCtx(ids);
        String schemaName = null;
        var relationName = QNameParser.getFirstName(ids);
        var relationCtx = QNameParser.getFirstNameCtx(ids);

        if (schemaCtx != null) {
            schemaName = QNameParser.getSchemaName(ids);
            addDepcy(new GenericColumn(schemaName, DbObjType.SCHEMA), schemaCtx);
        }

        addDepcy(new GenericColumn(schemaName, relationName, type), relationCtx);
    }
}