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
package ru.taximaxim.codekeeper.core.formatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.MultiTextEdit;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;

import ru.taximaxim.codekeeper.core.DatabaseType;
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
import ru.taximaxim.codekeeper.core.parsers.antlr.statements.ParserAbstract;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class FileFormatter {

    private final String source;
    private final int start;
    private final int length;
    private final int stop;
    private final DatabaseType dbType;

    private final FormatConfiguration config;

    public FileFormatter(String source, int offset, int length, FormatConfiguration config, DatabaseType dbType) {
        this.source = source;
        this.start = offset;
        this.stop = offset + length;
        this.length = length;
        this.config = config;
        this.dbType = dbType;
    }

    public String formatText() throws FormatterException {
        Document doc = new Document(source);

        TextEdit edit = getFormatEdit();
        if (edit == null) {
            return source;
        }
        try {
            edit.apply(doc);
        } catch (MalformedTreeException | BadLocationException e) {
            throw new FormatterException(e.getLocalizedMessage(), e);
        }
        return doc.get();
    }

    /**
     * @return edit operation or null if no formatting required
     */
    public TextEdit getFormatEdit() {
        List<FormatItem> list = this.getFormatItems();

        if (list.isEmpty()) {
            return null;
        }

        TextEdit edit = new MultiTextEdit(start, length);

        for (FormatItem item : list) {
            edit.addChild(new ReplaceEdit(item.getStart(), item.getLength(), item.getText()));
        }

        return edit;
    }

    public List<FormatItem> getFormatItems() {
        if (dbType != DatabaseType.PG) {
            return Collections.emptyList();
        }
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
            sf = new StatementFormatter(start, stop, body, tokenStream, config);
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

            if (funcDef == null || funcDef.symbol != null
                    || (!"PLPGSQL".equalsIgnoreCase(language) && !"SQL".equalsIgnoreCase(language))) {
                return;
            }

            Pair<String, Token> pair = ParserAbstract.unquoteQuotedString(funcDef.definition);
            String definition = pair.getFirst();
            Token codeStart = pair.getSecond();

            sf = new StatementFormatter(start, stop, definition,
                    codeStart.getStartIndex(), language, config);
        }

        sf.format();
        changes.addAll(sf.getChanges());
    }
}