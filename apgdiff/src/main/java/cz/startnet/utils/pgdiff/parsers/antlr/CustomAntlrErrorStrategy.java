package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.misc.IntervalSet;

abstract class CustomAntlrErrorStrategy extends DefaultErrorStrategy {

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

        String rules = stream.map(e -> this.getTokenName(e, vocabulary))
                .distinct().collect(Collectors.joining(", "));
        sb.append(rules);
    }

    protected abstract Stream<Integer> getTokenStream(IntervalSet tokens);

    protected abstract String getTokenName(Integer token, Vocabulary vocabulary);
}
