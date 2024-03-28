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

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Select_stmt_no_parensContext;

public class ChSelectStmt {

    private final Select_stmtContext select;
    private final Select_stmt_no_parensContext selectNp;
    private final boolean isNp;

    public ChSelectStmt(Select_stmtContext select) {
        this.select = select;
        this.selectNp = null;
        this.isNp = false;
    }

    public ChSelectStmt(Select_stmt_no_parensContext select) {
        this.selectNp = select;
        this.select = null;
        this.isNp = true;
    }

    public ChSelectOps selectOps() {
        // no null check since select_ops is mandatory in select_stmt
        return isNp ? new ChSelectOps(selectNp.select_ops_no_parens())
                : new ChSelectOps(select.select_ops());
    }
}
