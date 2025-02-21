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
package ru.taximaxim.codekeeper.core.parsers.antlr;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Ch_fileContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.SqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.TSQLParser.Tsql_fileContext;

public interface AntlrContextProcessor<R extends ParserRuleContext> {
    void process(R rootCtx, CommonTokenStream stream);

    public static interface SqlContextProcessor extends AntlrContextProcessor<SqlContext> {
    }

    public static interface TSqlContextProcessor extends AntlrContextProcessor<Tsql_fileContext> {
    }

    public static interface ChSqlContextProcessor extends AntlrContextProcessor<Ch_fileContext> {
    }
}
