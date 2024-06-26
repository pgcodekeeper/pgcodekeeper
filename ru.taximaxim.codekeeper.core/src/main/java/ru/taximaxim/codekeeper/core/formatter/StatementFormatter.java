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
package ru.taximaxim.codekeeper.core.formatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration.IndentType;
import ru.taximaxim.codekeeper.core.utils.Pair;

public abstract class StatementFormatter {

    private final int start;
    private final int stop;
    /**
     * function definition's offset into the function CREATE statement string <br>
     * all other offsets are statement-string-based
     */
    private final int defOffset;
    private final FormatConfiguration config;
    /**
     * tab replacement string if tabs are forbidden; null otherwise
     */
    private final String tabReplace;

    protected int currentIndent = 1;
    /**
     * position of token following last non-whitespace or newline token
     */
    protected int lastTokenOffset;
    /**
     * whether indent of the current line has characters mismatched with indent setting
     */
    private boolean isMixedIndent;
    /**
     * whether a space is needed after an operator
     */
    private boolean needSpace;
    /**
     * whether current token is first non-whitespace token on the line
     */
    private boolean firstTokenInLine = true;
    /**
     * intermediate indent instructions found by parser
     */
    private final Map<Token, Pair<IndentDirection, Integer>> indents = new HashMap<>();

    /**
     * unaryOps and other operator-like tokens found by parser
     */
    private final Set<Token> unaryOps = new HashSet<>();
    /**
     * pending tab replacements, can either be applied or overridden by other whitespace changes
     */
    private final List<FormatItem> tabs = new ArrayList<>();
    /**
     * accumulated formatting change operations
     */
    private final List<FormatItem> changes = new ArrayList<>();

    public StatementFormatter(int start, int stop, int defOffset, int lastTokenOffset, FormatConfiguration config) {
        this.start = start;
        this.stop = stop;
        this.defOffset = defOffset;
        this.lastTokenOffset = lastTokenOffset;
        this.config = config;
        this.tabReplace = config.getIndentType() == IndentType.WHITESPACE ? config.createIndent(config.getIndentSize())
                : null;
    }

    public List<FormatItem> getChanges() {
        return changes;
    }

    public void format() {
        for (Token t : getTokens()) {
            int tokenStart = defOffset + t.getStartIndex();
            int length = t.getStopIndex() - t.getStartIndex() + 1;
            int type = t.getType();

            if (isNewLineToken(type)) {
                removeTrailingWhitespace(tokenStart);
                needSpace = false;

                isMixedIndent = false;
                firstTokenInLine = true;
                lastTokenOffset = tokenStart + length;
                continue;
            }

            if (isTabToken(type) || isSpaceToken(type)) {
                processSpaces(type, tokenStart, length);
                needSpace = false;
                continue;
            }

            if (tokenStart > stop) {
                // ignore all after stop, but try to remove partial trailing space
                tabs.forEach(this::addChange);
                return;
            }

            if (type == Recognizer.EOF) {
                removeTrailingWhitespace(tokenStart);
                return;
            }

            if (IndentType.DISABLE != config.getIndentType()) {
                processIndents(indents.get(t), tokenStart);
            }

            tabs.forEach(this::addChange);
            tabs.clear();

            if (config.isAddWhitespaceAfterOp() || config.isAddWhitespaceBeforeOp()) {
                proccessOperators(type, tokenStart, t);
            }

            isMixedIndent = false;
            firstTokenInLine = false;
            lastTokenOffset = tokenStart + length;
        }
    }


    private void processSpaces(int type, int tokenStart, int length) {
        if (isTabToken(type) && config.getIndentType() == IndentType.WHITESPACE
                || isSpaceToken(type) && config.getIndentType() == IndentType.TAB) {
            isMixedIndent = true;
        }

        if (isTabToken(type) && tabReplace != null) {
            tabs.add(new FormatItem(tokenStart, length, tabReplace));
        }
    }

    private void removeTrailingWhitespace(int tokenStart) {
        if (config.isRemoveTrailingWhitespace() && tokenStart > lastTokenOffset) {
            addChange(new FormatItem(lastTokenOffset, tokenStart - lastTokenOffset, ""));
            tabs.clear();
        }
    }

    private void processIndents(Pair<IndentDirection, Integer> indent, int tokenStart) {
        if (indent != null) {
            switch (indent.getFirst()) {
            case BLOCK_START:
                writeIndent(true, currentIndent++, tokenStart);
                currentIndent += indent.getSecond() - 1;
                break;
            case BLOCK_LINE:
                writeIndent(true, currentIndent - 1, tokenStart);
                break;
            case BLOCK_STOP:
                writeIndent(false, --currentIndent, tokenStart);
                currentIndent -= indent.getSecond() - 1;
                break;
            case NEW_LINE:
                writeIndent(true, currentIndent, tokenStart);
                break;
            }
        } else if (firstTokenInLine) {
            writeIndent(false, currentIndent, tokenStart);
        }
    }

    private void proccessOperators(int type, int tokenStart, Token t) {
        if (isOperatorToken(type)) {
            if (unaryOps.contains(t)) {
                return;
            }

            if (config.isAddWhitespaceBeforeOp() && lastTokenOffset == tokenStart) {
                addChange(new FormatItem(tokenStart, 0, " "));
            }
            needSpace = config.isAddWhitespaceAfterOp();
        } else if (needSpace) {
            addChange(new FormatItem(tokenStart, 0, " "));
            needSpace = false;
        }
    }

    private void writeIndent(boolean needNewLine, int indent, int tokenStart) {
        if (!firstTokenInLine) {
            if (!needNewLine) {
                return;
            }
            // TODO pass separator from user preferences
            addChange(new FormatItem(lastTokenOffset, 0, "\n"));
        }

        int expectedIndent = indent * (config.getIndentType() == IndentType.TAB ? 1 : config.getIndentSize());
        int spaceSize = tokenStart - lastTokenOffset;
        if (spaceSize != expectedIndent || isMixedIndent) {
            addChange(new FormatItem(lastTokenOffset, spaceSize, config.createIndent(expectedIndent)));
        }
        tabs.clear();
    }

    private void addChange(FormatItem item) {
        int itemStart = item.getStart();
        int length = item.getLength();
        String text = item.getText();

        if (start <= itemStart && itemStart < stop) {
            if (itemStart + length > stop && text.isEmpty()) {
                // partial trailing whitespace
                changes.add(new FormatItem(itemStart, stop - itemStart, text));
            } else {
                changes.add(item);
            }
        }
    }

    protected List<? extends Token> analyzeDefinition(ParserRuleContext definition, CommonTokenStream tokenStream) {
        if (!isLexerOnly()) {
            runFormatListener(definition, tokenStream);
        }
        return tokenStream.getTokens(definition.getStart().getTokenIndex(), definition.getStop().getTokenIndex());
    }

    protected boolean isLexerOnly() {
        return IndentType.DISABLE == config.getIndentType()
                && !config.isAddWhitespaceAfterOp()
                && !config.isAddWhitespaceBeforeOp();
    }

    protected void runFormatListener(ParserRuleContext ctx, CommonTokenStream tokenStream) {
        FormatParseTreeListener listener = getListener(tokenStream, indents, unaryOps);
        ParseTreeWalker.DEFAULT.walk(listener, ctx);
    }

    protected abstract FormatParseTreeListener getListener(CommonTokenStream tokenStream,
            Map<Token, Pair<IndentDirection, Integer>> indents, Set<Token> unaryOps);

    protected abstract List<? extends Token> getTokens();

    protected abstract boolean isTabToken(int type);

    protected abstract boolean isSpaceToken(int type);

    protected abstract boolean isOperatorToken(int type);

    protected abstract boolean isNewLineToken(int type);
}