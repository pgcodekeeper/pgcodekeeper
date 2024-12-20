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
package ru.taximaxim.codekeeper.core.parsers.antlr.chexpr;

import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.ExprContext;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public final class ChExprWithNmspc extends ChAbstractExprWithNmspc<ExprContext> {

    private final ChValueExpr expr;

    public ChExprWithNmspc(String schema, MetaContainer meta) {
        super(schema, meta);
        expr = new ChValueExpr(this);
    }

    @Override
    public List<String> analyze(ExprContext ruleCtx) {
        expr.analyze(ruleCtx);
        return Collections.emptyList();
    }
}
