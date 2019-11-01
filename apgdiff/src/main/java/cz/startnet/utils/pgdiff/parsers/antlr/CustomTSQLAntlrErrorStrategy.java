package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.stream.Stream;

import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.misc.IntervalSet;

class CustomTSQLAntlrErrorStrategy extends CustomAntlrErrorStrategy {

    @Override
    protected Stream<Integer> getTokenStream(IntervalSet tokens) {
        Stream<Integer> stream = tokens.toList().stream();

        if (tokens.contains(TSQLLexer.ID)) {
            stream = stream.filter(e -> e < TSQLLexer.ADD || TSQLLexer.XSINIL < e);
        }
        return stream;
    }

    @Override
    protected String getTokenName(Integer token, Vocabulary vocabulary) {
        switch (token) {
        case TSQLLexer.LOCAL_ID:
        case TSQLLexer.SQUARE_BRACKET_ID:
        case TSQLLexer.ID:
            return IDENTIFIER;
        case TSQLLexer.DOUBLE_QUOTE_ID:
        case TSQLLexer.STRING:
            return STRING;
        case TSQLLexer.DECIMAL:
        case TSQLLexer.FLOAT:
        case TSQLLexer.REAL:
            return NUMBER;
        default:
            return vocabulary.getDisplayName(token);
        }
    }
}
