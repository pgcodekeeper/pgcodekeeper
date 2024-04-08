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

import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Select_primaryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Select_stmt_no_parensContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.ChSelectOps;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.ChSelectStmt;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public class ChSelect extends ChAbstractExprWithNmspc<Select_stmtContext> {

    protected ChSelect(ChAbstractExpr parent) {
        super(parent);
    }

    public ChSelect(String schema, MetaContainer meta) {
        super(schema, meta);
    }

    @Override
    public List<String> analyze(Select_stmtContext ruleCtx) {
        return analyze(new ChSelectStmt(ruleCtx));
    }

    public List<String> analyze(Select_stmt_no_parensContext ruleCtx) {
        return analyze(new ChSelectStmt(ruleCtx));
    }

    public List<String> analyze(ChSelectStmt select) {
        return selectOps(select.selectOps());
    }

    private List<String> selectOps(ChSelectOps selectOps) {
        List<String> ret = Collections.emptyList();
        Select_stmtContext selectStmt = selectOps.selectStmt();
        Select_primaryContext query;

        if (selectOps.leftParen() != null && selectOps.rightParen() != null && selectStmt != null) {
            ret = analyze(selectStmt);
        } else if (selectOps.intersect() != null || selectOps.union() != null || selectOps.except() != null) {
            // analyze each in a separate scope
            // use column names from the first one
            ret = new ChSelect(this).selectOps(selectOps.selectOps(0));
            new ChSelect(this).selectOps(selectOps.selectOps(1));
        } else if ((query = selectOps.selectPrimary()) != null) {
            ret = select(query);
        } else {
            log("No alternative in SelectOps!");
        }
        return ret;
    }

    private List<String> select(Select_primaryContext query) {
        var with = query.with_clause();
        if (with != null) {
            analyzeCte(with);
        }

        // TODO add later
        return Collections.emptyList();
    }
}