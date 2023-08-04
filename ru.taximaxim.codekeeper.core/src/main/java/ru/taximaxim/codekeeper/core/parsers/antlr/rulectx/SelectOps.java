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

import org.antlr.v4.runtime.tree.TerminalNode;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_opsContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_ops_no_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_primaryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Set_qualifierContext;

/**
 * Merging wrapper for select_ops/select_ops_no_parens
 *
 * @author levsha_aa
 */
public class SelectOps {

    private final Select_opsContext ops;
    private final Select_ops_no_parensContext opsNp;
    private final boolean isNp;

    public SelectOps(Select_opsContext ops) {
        this.ops = ops;
        this.opsNp = null;
        this.isNp = false;
    }

    public SelectOps(Select_ops_no_parensContext ops) {
        this.opsNp = ops;
        this.ops = null;
        this.isNp = true;
    }

    public TerminalNode leftParen() {
        return isNp ? opsNp.LEFT_PAREN() : ops.LEFT_PAREN();
    }

    public TerminalNode rightParen() {
        return isNp ? opsNp.RIGHT_PAREN() : ops.RIGHT_PAREN();
    }

    public Select_stmtContext selectStmt() {
        return isNp ? null : ops.select_stmt();
    }

    public SelectOps selectOps(int i) {
        Select_opsContext ctx = null;
        if (isNp && i == 0) {
            ctx = opsNp.select_ops();
        } else if (!isNp) {
            ctx = ops.select_ops(i);
        }

        return ctx == null ? null : new SelectOps(ctx);
    }

    public TerminalNode intersect() {
        return isNp ? opsNp.INTERSECT() : ops.INTERSECT();
    }

    public TerminalNode union() {
        return isNp ? opsNp.UNION() : ops.UNION();
    }

    public TerminalNode except() {
        return isNp ? opsNp.EXCEPT() : ops.EXCEPT();
    }

    public Set_qualifierContext setQualifier() {
        return isNp ? opsNp.set_qualifier() : ops.set_qualifier();
    }

    public Select_primaryContext selectPrimary() {
        return isNp ? opsNp.select_primary() : ops.select_primary();
    }
}
