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
package ru.taximaxim.codekeeper.core.parsers.antlr.rulectx;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.After_opsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_stmt_no_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.With_clauseContext;

/**
 * Merging wrapper for select_stmt/select_stmt_no_parens
 *
 * @author levsha_aa
 */
public class SelectStmt {

    private final Select_stmtContext select;
    private final Select_stmt_no_parensContext selectNp;
    private final boolean isNp;

    public SelectStmt(Select_stmtContext select) {
        this.select = select;
        this.selectNp = null;
        this.isNp = false;
    }

    public SelectStmt(Select_stmt_no_parensContext select) {
        this.selectNp = select;
        this.select = null;
        this.isNp = true;
    }

    public ParserRuleContext getCtx() {
        return isNp ? selectNp : select;
    }

    public With_clauseContext withClause() {
        return isNp ? selectNp.with_clause() : select.with_clause();
    }

    public SelectOps selectOps() {
        // no null check since select_ops is mandatory in select_stmt
        return isNp ? new SelectOps(selectNp.select_ops_no_parens())
                : new SelectOps(select.select_ops());
    }

    public List<After_opsContext> afterOps() {
        return isNp ? selectNp.after_ops() : select.after_ops();
    }
}
