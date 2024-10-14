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
package ru.taximaxim.codekeeper.core.formatter.pg;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.formatter.AbstractFormatter;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.formatter.FormatItem;
import ru.taximaxim.codekeeper.core.formatter.StatementFormatter;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLLexer;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Create_function_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_actions_commonContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_bodyContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_defContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_createContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Schema_statementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.SqlContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.StatementContext;
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.pg.PgParserAbstract;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class PgFormatter extends AbstractFormatter {

    public PgFormatter(String source, int start, int stop, FormatConfiguration config) {
        super(source, start, stop, config);
    }

    @Override
    public List<FormatItem> getFormatItems() {
        List<FormatItem> changes = new ArrayList<>();

        Lexer lexer = new SQLLexer(new ANTLRInputStream(source));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(tokenStream);

        SqlContext root = parser.sql();
        for (StatementContext st : root.statement()) {
            if (start <= st.stop.getStopIndex() || st.start.getStartIndex() < stop) {
                fillChanges(st, tokenStream, changes);
            }
        }

        return changes;
    }

    private void fillChanges(StatementContext st, CommonTokenStream tokenStream,
            List<FormatItem> changes) {
        Schema_statementContext schema = st.schema_statement();
        if (schema == null) {
            return;
        }

        Schema_createContext create = schema.schema_create();
        if (create == null) {
            return;
        }

        Create_function_statementContext function = create.create_function_statement();
        if (function == null) {
            return;
        }

        StatementFormatter sf;
        Function_bodyContext body = function.function_body();
        if (body != null) {
            sf = new PgStatementFormatter(start, stop, body, tokenStream, config);
        } else {
            String language = null;
            Function_defContext funcDef = null;
            for (Function_actions_commonContext action : function.function_actions_common()) {
                if (action.LANGUAGE() != null) {
                    language = action.lang_name.getText();
                } else if (action.AS() != null) {
                    funcDef = action.function_def();
                }
            }

            if (funcDef == null || funcDef.symbol != null || !PgDiffUtils.isValidLanguage(language)) {
                return;
            }

            Pair<String, Token> pair = PgParserAbstract.unquoteQuotedString(funcDef.definition);
            String definition = pair.getFirst();
            Token codeStart = pair.getSecond();

            sf = new PgStatementFormatter(start, stop, definition, codeStart.getStartIndex(), language, config);
        }

        sf.format();
        changes.addAll(sf.getChanges());
    }
}