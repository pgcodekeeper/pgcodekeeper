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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.Collections;
import java.util.List;

import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Function_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.Function_returnContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLParser.StatementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.rulectx.Vex;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;
import ru.taximaxim.codekeeper.core.utils.ModPair;

public class SqlFunctionBody extends Statements<Function_bodyContext> {

    protected SqlFunctionBody(AbstractExpr parent) {
        super(parent);
    }

    public SqlFunctionBody(MetaContainer meta) {
        super(meta);
    }

    @Override
    protected List<StatementContext> getStatements(Function_bodyContext ctx) {
        return ctx.statement();
    }

    @Override
    public List<ModPair<String, String>> analyze(Function_bodyContext ctx) {
        super.analyze(ctx);
        for (Function_returnContext ret : ctx.function_return()) {
            new ValueExpr(this).analyze(new Vex(ret.vex()));
        }

        return Collections.emptyList();
    }
}
