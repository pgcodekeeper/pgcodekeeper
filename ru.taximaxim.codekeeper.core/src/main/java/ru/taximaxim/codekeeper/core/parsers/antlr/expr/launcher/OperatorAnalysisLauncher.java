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

import java.util.Collections;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.IFunction;
import ru.taximaxim.codekeeper.core.schema.IOperator;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgStatementWithSearchPath;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public class OperatorAnalysisLauncher extends AbstractAnalysisLauncher {

    private final GenericColumn function;

    public OperatorAnalysisLauncher(PgStatementWithSearchPath stmt, GenericColumn function, String location) {
        super(stmt, null, location);
        this.function = function;
    }

    @Override
    protected Set<PgObjLocation> analyze(ParserRuleContext ctx, MetaContainer meta) {
        IFunction func = meta.findFunction(function.schema, function.table);
        IOperator oper = meta.findOperator(stmt.getSchemaName(), stmt.getName());

        if (oper != null && func != null) {
            oper.setReturns(func.getReturns());
        }

        return Collections.emptySet();
    }

}
