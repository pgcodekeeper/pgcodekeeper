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
package ru.taximaxim.codekeeper.core.parsers.antlr.rulectx;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.For_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Option_clauseContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Select_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Select_stmt_no_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.With_expressionContext;

public class MsSelectStmt {

    private final Select_statementContext select;
    private final Select_stmt_no_parensContext selectNp;
    private final boolean isNp;

    public MsSelectStmt(Select_statementContext select) {
        this.select = select;
        this.selectNp = null;
        this.isNp = false;
    }

    public MsSelectStmt(Select_stmt_no_parensContext select) {
        this.selectNp = select;
        this.select = null;
        this.isNp = true;
    }

    public With_expressionContext withExpression() {
        return isNp ? selectNp.with_expression() : select.with_expression();
    }

    public MsSelectOps selectOps() {
        // no null check since select_ops is mandatory in select_stmt
        return isNp ? new MsSelectOps(selectNp.select_ops_no_parens())
                : new MsSelectOps(select.select_ops());
    }

    public Option_clauseContext option() {
        return isNp ? selectNp.option_clause() : select.option_clause();
    }

    public For_clauseContext forClause() {
        return isNp ? selectNp.for_clause() : select.for_clause();
    }
}
