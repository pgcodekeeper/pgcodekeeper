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

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.formatter.FormatParseTreeListener;
import ru.taximaxim.codekeeper.core.formatter.IndentDirection;
import ru.taximaxim.codekeeper.core.formatter.StatementFormatter;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHLexer;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.CHParser.Select_stmtContext;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class ChStatementFormatter extends StatementFormatter {

    private List<? extends Token> tokens;

    public ChStatementFormatter(int start, int stop, Select_stmtContext selectStmtCtx,
            CommonTokenStream tokenStream, FormatConfiguration config) {
        super(start, stop, 0, 0, config);
        this.tokens = analyzeDefinition(selectStmtCtx, tokenStream);
        if (!tokens.isEmpty()) {
            lastTokenOffset = tokens.get(0).getStartIndex();
        }
    }

    @Override
    public List<? extends Token> getTokens() {
        return tokens;
    }

    @Override
    protected FormatParseTreeListener getListener(CommonTokenStream tokenStream,
            Map<Token, Pair<IndentDirection, Integer>> indents, Set<Token> unaryOps) {
        return new ChFormatParseTreeListener(tokenStream, indents, unaryOps);
    }

    @Override
    protected boolean isTabToken(int type) {
        return type == CHLexer.TAB;
    }

    @Override
    protected boolean isSpaceToken(int type) {
        return type == CHLexer.SPACE;
    }

    @Override
    protected boolean isNewLineToken(int type) {
        return type == CHLexer.NEW_LINE;
    }

    @Override
    protected boolean isOperatorToken(int type, Token t) {
        switch (type) {
        case CHLexer.EQ_DOUBLE:
        case CHLexer.EQ_SINGLE:
        case CHLexer.NOT_EQ:
        case CHLexer.LE:
        case CHLexer.GE:
        case CHLexer.LT:
        case CHLexer.GT:
        case CHLexer.CONCAT:
        case CHLexer.PLUS:
        case CHLexer.MINUS:
        case CHLexer.ASTERISK:
        case CHLexer.SLASH:
        case CHLexer.PERCENT:
        case CHLexer.AND:
        case CHLexer.OR:
        case CHLexer.NOT_DIST:
        case CHLexer.MOD:
        case CHLexer.DIV:
            return true;
        default:
            return false;
        }
    }
}