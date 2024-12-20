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
package ru.taximaxim.codekeeper.core.formatter.pg;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.formatter.FormatParseTreeListener;
import ru.taximaxim.codekeeper.core.formatter.IndentDirection;
import ru.taximaxim.codekeeper.core.formatter.StatementFormatter;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLLexer;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_bodyContext;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class PgStatementFormatter extends StatementFormatter {

    private List<? extends Token> tokens;

    public PgStatementFormatter(int start, int stop, String functionDefinition,
            int defOffset, String language, FormatConfiguration config) {
        super(start, stop, defOffset, defOffset, config);
        this.tokens = analyzeDefinition(functionDefinition, language);
    }

    public PgStatementFormatter(int start, int stop, Function_bodyContext definition,
            CommonTokenStream tokenStream, FormatConfiguration config) {
        super(start, stop, 0, 0, config);
        this.tokens = analyzeDefinition(definition, tokenStream);
        if (!tokens.isEmpty()) {
            lastTokenOffset = tokens.get(0).getStartIndex();
        }
    }

    @Override
    public List<? extends Token> getTokens() {
        return tokens;
    }

    private List<? extends Token> analyzeDefinition(String definition, String language) {
        Lexer lexer = new SQLLexer(new ANTLRInputStream(definition));
        if (isLexerOnly()) {
            // fast-path when no parser is required for advanced structure detection
            return lexer.getAllTokens();
        }
        CommonTokenStream stream = new CommonTokenStream(lexer);
        SQLParser parser = new SQLParser(stream);

        ParserRuleContext ctx;
        if ("SQL".equalsIgnoreCase(language)) {
            ctx = parser.sql();
            currentIndent = 0;
        } else {
            AntlrUtils.removeIntoStatements(parser);
            ctx = parser.plpgsql_function();
        }
        runFormatListener(ctx, stream);
        return stream.getTokens();
    }

    @Override
    protected FormatParseTreeListener getListener(CommonTokenStream tokenStream,
            Map<Token, Pair<IndentDirection, Integer>> indents, Set<Token> unaryOps) {
        return new PgFormatParseTreeListener(tokenStream, indents, unaryOps);
    }

    @Override
    protected boolean isTabToken(int type) {
        return type == SQLLexer.Tab;
    }

    @Override
    protected boolean isSpaceToken(int type) {
        return type == SQLLexer.Space;
    }

    @Override
    protected boolean isNewLineToken(int type) {
        return type == SQLLexer.New_Line;
    }

    @Override
    protected boolean isOperatorToken(int type, Token t) {
        return PgFormatterUtils.isOperatorToken(type)
                && PgFormatterUtils.checkOperator(t, type, tokens);
    }
}