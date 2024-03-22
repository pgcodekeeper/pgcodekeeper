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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher;

import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.loader.FullAnalyze;
import ru.taximaxim.codekeeper.core.parsers.antlr.expr.Select;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.schema.meta.MetaUtils;
import ru.taximaxim.codekeeper.core.schema.pg.PgView;

public class ViewAnalysisLauncher extends AbstractAnalysisLauncher {

    private FullAnalyze fullAnalyze;

    public ViewAnalysisLauncher(PgView stmt, Select_stmtContext ctx, String location) {
        super(stmt, ctx, location);
    }

    public void setFullAnalyze(FullAnalyze fullAnalyze) {
        this.fullAnalyze = fullAnalyze;
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        Select select = new Select(meta);
        select.setFullAnaLyze(fullAnalyze);
        MetaUtils.initializeView(meta, getSchemaName(), stmt.getName(),
                select.analyze((Select_stmtContext) ctx));
        return select.getDepcies();
    }
}
