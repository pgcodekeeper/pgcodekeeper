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
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Function_callContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.IdentifierContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Select_stmt_no_parensContext;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

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

        Qualified_nameContext tableCtx;
        Function_callContext fc;
        Select_stmt_no_parensContext selectCtx;
        var exprPrimary = expr.expr_primary();
        if (exprPrimary != null) {
            if ((fc = exprPrimary.function_call()) != null) {
                functionCall(fc);
            } else if ((selectCtx = exprPrimary.select_stmt_no_parens()) != null ) {
                new ChSelect(this).analyze(selectCtx);
            } else if ((tableCtx = exprPrimary.qualified_name()) != null) {
                addObjectDepcy(tableCtx, DbObjType.TABLE);
            }
        }
    }

    public GenericColumn functionCall(Function_callContext functionCall) {
        for (ExprContext exp : functionCall.expr()) {
            analyze(exp);
        }

        var list = functionCall.expr_list();
        if (list != null) {
            for (ExprContext exp : list.expr()) {
                analyze(exp);
            }
        }

        var argList = functionCall.arg_list();
        if (argList != null) {
            for (var argExpr : argList.arg_expr()) {
                var expr = argExpr.expr();
                if (expr != null) {
                    analyze(expr);
                }
            }
        }

        var funcName = functionCall.name;
        if (funcName != null) {
            return addFuncDepcy(funcName, DbObjType.FUNCTION);
        }
        return null;
    }

    protected GenericColumn addFuncDepcy(IdentifierContext id, DbObjType type) {
        GenericColumn depcy = new GenericColumn(id.getText(), type);
        addDepcy(depcy, id);
        return depcy;
    }

    protected GenericColumn addObjectDepcy(Qualified_nameContext qualifiedName,
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

        GenericColumn depcy = new GenericColumn(schemaName, relationName, type);
        addDepcy(depcy, relationCtx);
        return depcy;
    }
}