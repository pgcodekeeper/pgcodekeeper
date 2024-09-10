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

import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import ru.taximaxim.codekeeper.core.utils.Pair;

public abstract class FormatParseTreeListener implements ParseTreeListener {

    private final CommonTokenStream tokens;
    private final Map<Token, Pair<IndentDirection, Integer>> indents;
    protected final Set<Token> unaryOps;

    /**
     * @param unaryOps
     *            found unary operators and other operator-like tokens
     */
    protected FormatParseTreeListener(CommonTokenStream tokens,
            Map<Token, Pair<IndentDirection, Integer>> indents,
            Set<Token> unaryOps) {
        this.tokens = tokens;
        this.indents = indents;
        this.unaryOps = unaryOps;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        //no imp
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        //no imp
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        //no imp
    }

    protected void putIndent(Token token, IndentDirection indentDir) {
        Pair<IndentDirection, Integer> indent = indents.get(token);
        if (indent != null && indent.getFirst() == indentDir) {
            indent = new Pair<>(indentDir, indent.getSecond() + 1);
        } else {
            indent = new Pair<>(indentDir, 1);
        }

        indents.put(token, indent);
    }

    protected boolean isSelectPrimaryInParens(TerminalNode node, int parenToken) {
        if (node == null) {
            return false;
        }

        int oldPos = tokens.index();
        try {
            Token select = node.getSymbol();
            tokens.seek(select.getTokenIndex());
            Token prev = tokens.LT(-1);
            return prev != null && prev.getType() == parenToken;
        } finally {
            tokens.seek(oldPos);
        }
    }
}
