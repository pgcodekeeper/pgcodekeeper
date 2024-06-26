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
package ru.taximaxim.codekeeper.core.formatter.ch;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;

import ru.taximaxim.codekeeper.core.formatter.AbstractFormatter;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.formatter.FormatItem;
import ru.taximaxim.codekeeper.core.formatter.StatementFormatter;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHLexer;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Ddl_stmtContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.QueryContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.StmtContext;

public class ChFormatter extends AbstractFormatter {

    public ChFormatter(String source, int start, int stop, FormatConfiguration config) {
        super(source, start, stop, config);
    }

    @Override
    public List<FormatItem> getFormatItems() {
        List<FormatItem> changes = new ArrayList<>();

        Lexer lexer = new CHLexer(new ANTLRInputStream(source));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CHParser parser = new CHParser(tokenStream);

        var rootCtx = parser.ch_file();
        for (QueryContext queryCtx : rootCtx.query()) {
            if (start <= queryCtx.stop.getStopIndex() || queryCtx.start.getStartIndex() < stop) {
                fillChanges(queryCtx.stmt(), tokenStream, changes);
            }
        }

        return changes;
    }

    private void fillChanges(StmtContext stmtContext, CommonTokenStream tokenStream, List<FormatItem> changes) {
        Ddl_stmtContext ddlCtx = stmtContext.ddl_stmt();
        if (ddlCtx == null) {
            return;
        }

        var createCtx = ddlCtx.create_stmt();
        if (createCtx == null) {
            return;
        }

        var createViewCtx = createCtx.create_view_stmt();
        if (createViewCtx == null) {
            return;
        }

        var selectStmtCtx = createViewCtx.subquery_clause().select_stmt();
        if (selectStmtCtx == null) {
            return;
        }

        StatementFormatter sf = new ChStatementFormatter(start, stop, selectStmtCtx, tokenStream, config);
        sf.format();
        changes.addAll(sf.getChanges());
    }
}