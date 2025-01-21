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
package ru.taximaxim.codekeeper.core.parsers.antlr.verification;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import ru.taximaxim.codekeeper.core.formatter.IndentDirection;
import ru.taximaxim.codekeeper.core.formatter.pg.PgFormatParseTreeListener;
import ru.taximaxim.codekeeper.core.formatter.pg.PgFormatterUtils;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrError;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.parsers.antlr.ErrorTypes;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLLexer;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.generated.SQLParser.Function_bodyContext;
import ru.taximaxim.codekeeper.core.utils.Pair;

public class VerificationIndents implements IVerification {

    /**
     * function definition's offset into the function CREATE statement string <br>
     * all other offsets are statement-string-based
     */
    private final int defOffset;
    /**
     * intermediate indent instructions found by parser
     */
    private final Map<Token, Pair<IndentDirection, Integer>> indents = new HashMap<>();

    /**
     * position of token following last non-whitespace or newline token
     */
    private int lastTokenOffset;

    /**
     * unaryOps and other operator-like tokens found by parser
     */
    private final Set<Token> unaryOps = new HashSet<>();

    /**
     * whether current token is first non-whitespace token on the line
     */
    private boolean firstTokenInLine = true;
    /**
     * whether indent of the current line has characters mismatched with indent setting
     */
    //private boolean isMixedIndent;

    /**
     * whether a space is needed after an operator
     */
    private boolean needSpace;
    private int currentIndent = 1;
    private boolean needSpaceAfterIf;
    private boolean needSpaceAfterComma;
    private List<? extends Token> tokens;

    private final Token codeStart;
    private final String filename;
    private final List<Object> errors;
    private final VerificationProperties rules;

    public VerificationIndents(Token codeStart, String functionDefinition, String language,
            String filename, List<Object> errors, VerificationProperties rules) {
        this.defOffset = codeStart.getStartIndex();
        this.lastTokenOffset = codeStart.getStartIndex();
        this.codeStart = codeStart;
        this.filename = filename;
        this.errors = errors;
        this.rules = rules;
        this.tokens = analyzeDefinition(functionDefinition, language);
    }

    public VerificationIndents(Token codeStart, Function_bodyContext definition, CommonTokenStream tokenStream,
            String filename, List<Object> errors, VerificationProperties rules) {
        this.defOffset = 0;
        this.codeStart = codeStart;
        this.filename = filename;
        this.errors = errors;
        this.rules = rules;
        this.tokens = analyzeDefinition(definition, tokenStream);
        if (!tokens.isEmpty()) {
            lastTokenOffset = tokens.get(0).getStartIndex();
        }
    }

    @Override
    public void verify() {
        Token firstToken = tokens.get(0);
        if (firstToken.getType() != SQLLexer.NewLine
                && firstToken.getType() != SQLLexer.BEGIN) {
            addError(firstToken, Messages.VerificationIndents_body_start_rule);
        }

        for (Token t : tokens) {
            int tokenStart = defOffset + t.getStartIndex();
            int length = t.getStopIndex() - t.getStartIndex() + 1;
            int type = t.getType();

            if (type == SQLLexer.NewLine) {
                needSpace = false;
                // isMixedIndent = false;
                firstTokenInLine = true;
                lastTokenOffset = tokenStart + length;
                continue;
            }

            if (rules.isSpaceAfterComma()) {
                checkSpaceAfterComma(t);
            }

            if (type == SQLLexer.Tab || type == SQLLexer.Space) {
                // processSpaces(type);
                needSpace = false;
                continue;
            }

            if (rules.isCheckSpaceOnMath()) {
                proccessOperators(type, tokenStart, t);
            }

            if (rules.isCheckSpaceAfterIf()) {
                checkSpaceAfterIf(tokenStart, t);
            }

            if (type == Recognizer.EOF) {
                if (rules.isCheckSemicolonAfterSimpleSql()) {
                    checkSemicolonAfterSimpleSQL();
                }
                return;
            }

            if (rules.isCheckIndents() || rules.getMaxCyclomaticComplexity() > 0) {
                processIndents(indents.get(t), tokenStart, t);
            }

            // isMixedIndent = false;
            firstTokenInLine = false;
            lastTokenOffset = tokenStart + length;
        }
    }

    /* we nowhere use isMixedIndent param value. Maybe later will be useful
     private void processSpaces(int type) {
        if (type == SQLLexer.Tab // && config.getIndentType() == IndentType.WHITESPACE
                || type == SQLLexer.Space // && config.getIndentType() == IndentType.TAB) {
            isMixedIndent = true;
        }
    }
     */

    /**
     * checking rules:
     * Cyclomatic complexity
     * CheckIndent
     * Exception position
     */
    private void processIndents(Pair<IndentDirection, Integer> indent, int tokenStart, Token t) {
        if (indent != null) {
            switch (indent.getFirst()) {
            case BLOCK_START:
                writeIndent(true, currentIndent++, tokenStart, t);
                currentIndent += indent.getSecond() - 1;
                int cyclomaticComplexCount = rules.getMaxCyclomaticComplexity();
                if (cyclomaticComplexCount > 0 && currentIndent > cyclomaticComplexCount) {
                    String msg = MessageFormat.format(Messages.VerificationIndents_cyclomatic_complexy,
                            currentIndent, cyclomaticComplexCount);
                    addError(t, msg);
                }
                break;
            case BLOCK_LINE:
                writeIndent(true, currentIndent - 1, tokenStart, t);
                break;
            case BLOCK_STOP:
                writeIndent(false, --currentIndent, tokenStart, t);
                currentIndent -= indent.getSecond() - 1;
                break;
            default:
                break;
            }
        } else if (firstTokenInLine) {
            writeIndent(false, currentIndent, tokenStart, t);
        }
    }

    private void writeIndent(boolean needNewLine, int indent, int tokenStart, Token t) {
        boolean isCheckIndents = rules.isCheckIndents();
        if (!firstTokenInLine) {
            if (!needNewLine) {
                return;
            }
            if (isCheckIndents) {
                addError(t, MessageFormat.format(Messages.VerificationIndents_eol_before_stat, t.getText()));
                return;
            }
        }

        int expectedIndent = indent * rules.getIndentSize();
        int spaceSize = tokenStart - lastTokenOffset;
        if (isCheckIndents && spaceSize != expectedIndent) {
            addError(t, MessageFormat.format(Messages.VerificationIndents_indent_size, expectedIndent, spaceSize));
        }
    }

    /**
     * checking CheckSpaceOnMath
     */
    private void proccessOperators(int type, int tokenStart, Token t) {
        String msg = Messages.VerificationIndents_space_math_operators;
        if (PgFormatterUtils.isOperatorToken(type)) {
            if (!PgFormatterUtils.checkOperator(t, type, tokens) || unaryOps.contains(t)) {
                return;
            }
            if (lastTokenOffset == tokenStart) {
                addError(t, msg);
            }
            needSpace = true;
        } else if (needSpace) {
            addError(t, msg);
            needSpace = false;
        }
    }

    /**
     * checking SpaceAfterComma rule, spaces after comma
     */
    private void checkSpaceAfterComma(Token t) {
        if (t.getType() == SQLLexer.COMMA) {
            needSpaceAfterComma = true;
            return;
        }
        if (needSpaceAfterComma && t.getType() != SQLLexer.Space)  {
            addError(t, Messages.VerificationIndents_space_after_comma);
        }
        needSpaceAfterComma = false;
    }

    /**
     * checking SpaceAfterIf rule, spaces after if
     */
    private void checkSpaceAfterIf(int tokenStart, Token t) {
        if (t.getType() == SQLLexer.IF) {
            needSpaceAfterIf = true;
        } else {
            if (needSpaceAfterIf && t.getType() == SQLLexer.LEFT_PAREN && lastTokenOffset == tokenStart) {
                addError(t, Messages.VerificationIndents_space_after_if);
            }
            needSpaceAfterIf = false;
        }
    }

    /**
     * checking SemicolonAfterSimpleSql rule, after simple sql statement
     */
    private void checkSemicolonAfterSimpleSQL() {
        Token endToken = tokens.stream().filter(
                token -> token.getType() != SQLLexer.NewLine
                && token.getType() != SQLLexer.Space
                && token.getType() != SQLLexer.END
                && token.getType() != Recognizer.EOF)
                .reduce((first, second) -> second).orElse(null);

        if (endToken != null && endToken.getType() != SQLLexer.SEMI_COLON) {
            addError(endToken, Messages.VerificationIndents_semicolon_after_simple_sql);
        }
    }

    private void addError(Token t, String msg) {
        AntlrError err = new AntlrError(filename, t.getLine(),
                t.getCharPositionInLine(), msg, ErrorTypes.VERIFICATIONERROR)
                .copyWithOffset(defOffset, codeStart.getLine() - 1, codeStart.getCharPositionInLine());
        errors.add(err);
    }

    private List<? extends Token> analyzeDefinition(Function_bodyContext definition, CommonTokenStream tokenStream) {
        runFormatListener(definition, tokenStream);
        return tokenStream.getTokens(definition.getStart().getTokenIndex(), definition.getStop().getTokenIndex());
    }

    private List<? extends Token> analyzeDefinition(String definition, String language) {
        Lexer lexer = new SQLLexer(new ANTLRInputStream(definition));
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

    private void runFormatListener(ParserRuleContext definition, CommonTokenStream tokenStream) {
        ParseTreeListener listener = new PgFormatParseTreeListener(tokenStream, indents, unaryOps);
        ParseTreeWalker.DEFAULT.walk(listener, definition);
    }
}