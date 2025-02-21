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

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.misc.IntervalSet;

abstract class CustomAntlrErrorStrategy extends DefaultErrorStrategy {

    private static final int EXPECTED_TOKEN_LIMIT = 10;

    protected static final String IDENTIFIER = "Identifier";
    protected static final String NUMBER = "Number";
    protected static final String STRING = "String";
    protected static final String OPERATOR = "Operator";

    @Override
    protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
        Token t = e.getOffendingToken();
        StringBuilder sb = new StringBuilder();
        sb.append("mismatched input ").append(getTokenErrorDisplay(t));
        sb.append(" expecting ");
        fillTokens(sb, recognizer.getVocabulary(), e.getExpectedTokens());
        recognizer.notifyErrorListeners(t, sb.toString(), e);
    }

    @Override
    protected void reportUnwantedToken(Parser recognizer) {
        if (inErrorRecoveryMode(recognizer)) {
            return;
        }
        beginErrorCondition(recognizer);

        Token t = recognizer.getCurrentToken();
        StringBuilder sb = new StringBuilder();
        sb.append("extraneous input ").append(getTokenErrorDisplay(t));
        sb.append(" expecting ");
        fillTokens(sb, recognizer.getVocabulary(), getExpectedTokens(recognizer));
        recognizer.notifyErrorListeners(t, sb.toString(), null);
    }

    @Override
    protected void reportMissingToken(Parser recognizer) {
        if (inErrorRecoveryMode(recognizer)) {
            return;
        }
        beginErrorCondition(recognizer);

        Token t = recognizer.getCurrentToken();
        StringBuilder sb = new StringBuilder();
        sb.append("missing ");
        fillTokens(sb, recognizer.getVocabulary(), getExpectedTokens(recognizer));
        sb.append(" at ").append(getTokenErrorDisplay(t));
        recognizer.notifyErrorListeners(t, sb.toString(), null);
    }

    private void fillTokens(StringBuilder sb, Vocabulary vocabulary, IntervalSet tokens) {
        Stream<Integer> stream = getTokenStream(tokens);
        AtomicInteger tokenCount = new AtomicInteger();
        String rules = stream.map(e -> this.getTokenName(e, vocabulary)).distinct()
                .filter(e -> tokenCount.incrementAndGet() <= EXPECTED_TOKEN_LIMIT)
                .collect(Collectors.joining(", "));
        sb.append(rules);

        if (tokenCount.get() > EXPECTED_TOKEN_LIMIT) {
            sb.append(" or " + (tokenCount.get() - EXPECTED_TOKEN_LIMIT) + " more");
        }
    }

    protected abstract Stream<Integer> getTokenStream(IntervalSet tokens);

    protected abstract String getTokenName(Integer token, Vocabulary vocabulary);
}
