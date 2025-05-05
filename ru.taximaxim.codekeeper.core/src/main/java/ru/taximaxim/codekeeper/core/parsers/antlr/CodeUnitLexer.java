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

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;

public abstract class CodeUnitLexer extends Lexer {

    private static final String CODE_POINT_32_BIT_CHAR_STREAM = "CodePoint32BitCharStream";

    private int offset;
    private int tokenOffset;
    private int prevLineOffset;
    private int currentLineOffset;

    private final boolean is32bitStream;

    protected CodeUnitLexer(CharStream input) {
        super(input);
        is32bitStream = CODE_POINT_32_BIT_CHAR_STREAM.equals(input.getClass().getSimpleName());
    }

    @Override
    public Token emit() {
        var t = new CodeUnitToken(_tokenFactorySourcePair, _type, _channel,
                _tokenStartCharIndex, _input.index() - 1, _tokenStartCharIndex + offset,
               _input.index() + offset + tokenOffset -1, _tokenStartCharPositionInLine + currentLineOffset);

        t.setLine(_tokenStartLine);
        t.setCharPositionInLine(_tokenStartCharPositionInLine);
        if (_text != null) {
            t.setText(_text);
        }

        return emitToken(t);
    }

    @Override
    public Token emitEOF() {
        var t = new CodeUnitToken(_tokenFactorySourcePair, Token.EOF, _channel,
                _tokenStartCharIndex, _input.index() - 1, _tokenStartCharIndex + offset,
               _input.index() + offset + tokenOffset -1, _tokenStartCharPositionInLine + currentLineOffset);

        t.setLine(getLine());
        t.setCharPositionInLine(getCharPositionInLine());

        return emitToken(t);
    }

    protected void calculateOffset() {
        if (is32bitStream) {
            calculateOffset(getText());
        }
    }

    protected void calculateOffset(String text) {
        if (!is32bitStream) {
            return;
        }

        for (var c : text.chars().toArray()) {
            if (Character.isLowSurrogate((char) c)) {
                tokenOffset++;
                prevLineOffset++;
            }
        }
    }

    protected void resetLineOffset() {
        if (is32bitStream) {
            prevLineOffset = 0;
            currentLineOffset = 0;
        }
    }

    private CodeUnitToken emitToken(CodeUnitToken token) {
        emit(token);
        currentLineOffset = prevLineOffset;
        offset += tokenOffset;
        tokenOffset = 0;

        return token;
    }

    protected boolean checkLetter() {
        return Character.isLetter((char) _input.LA(-1));
    }

    protected boolean checkEmoji() {
        return Character.isLetter(Character.toCodePoint((char) _input.LA(-2), (char) _input.LA(-1)));
    }

    /**
     * unquote so that we may always call getText() and not worry about quotes
     */
    protected void removeQuotes() {
        String tx = getText();
        calculateOffset(tx);
        setText(tx.substring(1, tx.length() - 1));
    }

    /**
     * unquote so that we may always call getText() and not worry about quotes
     */
    protected void removeQuotes(CharSequence target, CharSequence replacement) {
        String tx = getText();
        calculateOffset(tx);
        setText(tx.substring(1, tx.length() - 1).replace(target, replacement));
    }

    protected void toLowerCase() {
        String tx = getText();
        calculateOffset(tx);
        setText(tx.toLowerCase(java.util.Locale.ROOT));
    }
}
