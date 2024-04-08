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

import java.util.EnumSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.chexpr.ChValueExpr;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.ExprContext;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.ch.ChFunction;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public class ChFuncAnalysisLauncher extends AbstractAnalysisLauncher {

    public ChFuncAnalysisLauncher(ChFunction st, ExprContext ctx, String location) {
        super(st, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        ChValueExpr analyzer = new ChValueExpr(meta);
        return analyze(((ExprContext) ctx), analyzer);
    }

    @Override
    protected EnumSet<DbObjType> getDisabledDepcies() {
        PgDiffArguments args = stmt.getDatabaseArguments();
        if (!args.isEnableFunctionBodiesDependencies()) {
            return EnumSet.of(DbObjType.FUNCTION);
        }

        return super.getDisabledDepcies();
    }
}
