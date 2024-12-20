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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher;

import java.util.Collections;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.chexpr.ChSelect;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Subquery_clauseContext;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.ch.ChView;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public class ChViewAnalysisLauncher extends AbstractAnalysisLauncher {

    public ChViewAnalysisLauncher(ChView stmt, Subquery_clauseContext vQuery, String location) {
        super(stmt, vQuery, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        Subquery_clauseContext subQueryCtx = (Subquery_clauseContext) ctx;
        Select_stmtContext selectCtx = subQueryCtx.select_stmt();
        if (selectCtx != null) {
            ChSelect select = new ChSelect(getSchemaName(), meta);
            return analyze(selectCtx, select);
        }

        return Collections.emptySet();
    }
}
