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
package ru.taximaxim.codekeeper.core.parsers.antlr.expr;

import java.util.List;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.SqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.StatementContext;
import ru.taximaxim.codekeeper.core.schema.meta.MetaContainer;

public class Sql extends Statements<SqlContext> {

    protected Sql(AbstractExpr parent) {
        super(parent);
    }

    public Sql(MetaContainer meta) {
        super(meta);
    }

    @Override
    protected List<StatementContext> getStatements(SqlContext ctx) {
        return ctx.statement();
    }
}
