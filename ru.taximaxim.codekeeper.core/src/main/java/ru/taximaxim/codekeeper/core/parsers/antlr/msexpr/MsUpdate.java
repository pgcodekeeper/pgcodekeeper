/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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

import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.ExpressionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.From_itemContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Full_column_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Qualified_nameContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Search_conditionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Update_elemContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Update_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.With_expressionContext;

public class MsUpdate extends MsAbstractExprWithNmspc<Update_statementContext> {

    protected MsUpdate(MsAbstractExpr parent) {
        super(parent);
    }

    @Override
    public List<String> analyze(Update_statementContext update) {
        With_expressionContext with = update.with_expression();
        if (with != null) {
            analyzeCte(with);
        }

        Qualified_nameContext tableName = update.qualified_name();

        MsSelect select = new MsSelect(this);
        for (From_itemContext item : update.from_item()) {
            select.from(item);
        }

        boolean isAlias = false;

        if (tableName != null && tableName.schema == null) {
            isAlias = select.findReference(null, tableName.name.getText()) != null;
        }

        if (tableName != null && !isAlias) {
            addNameReference(tableName, null);
        }

        MsValueExpr vex = new MsValueExpr(select);

        ExpressionContext exp = update.expression();
        if (exp != null) {
            vex.analyze(exp);
        }

        for (Update_elemContext elem : update.update_elem()) {
            ExpressionContext expr = elem.expression();
            if (expr != null) {
                vex.analyze(expr);
                Full_column_nameContext fcn = elem.full_column_name();
                if (fcn != null) {
                    select.addColumnDepcy(fcn);
                }
            } else {
                vex.expressionList(elem.expression_list());
            }
        }

        Search_conditionContext search = update.search_condition();
        if (search != null) {
            vex.search(search);
        }

        return Collections.emptyList();
    }
}
