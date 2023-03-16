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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr.launcher;

import java.util.LinkedHashSet;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Index_columnContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Index_restContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Storage_parameter_optionContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Storage_parametersContext;
import ru.taximaxim.codekeeper.core.schema.PgIndex;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public class IndexAnalysisLauncher extends AbstractAnalysisLauncher {

    public IndexAnalysisLauncher(PgIndex stmt, Index_restContext ctx, String location) {
        super(stmt, ctx, location);
    }

    @Override
    public Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        Set<PgObjLocation> depcies = new LinkedHashSet<>();
        Index_restContext rest = (Index_restContext) ctx;

        for (Index_columnContext c : rest.index_columns().index_column()) {
            depcies.addAll(analyzeTableChildVex(c.column, meta));

            Storage_parametersContext params = c.storage_parameters();
            if (params != null) {
                for (Storage_parameter_optionContext o : params.storage_parameter_option()) {
                    depcies.addAll(analyzeTableChildVex(o.vex(), meta));
                }
            }
        }

        if (rest.index_where() != null){
            depcies.addAll(analyzeTableChildVex(rest.index_where().vex(), meta));
        }

        return depcies;
    }
}
