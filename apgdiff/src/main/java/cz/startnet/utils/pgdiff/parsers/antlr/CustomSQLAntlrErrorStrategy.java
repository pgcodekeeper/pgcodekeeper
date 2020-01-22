package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.stream.Stream;

import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.misc.IntervalSet;

class CustomSQLAntlrErrorStrategy extends CustomAntlrErrorStrategy {

    @Override
    protected Stream<Integer> getTokenStream(IntervalSet tokens) {
        Stream<Integer> stream = tokens.toList().stream();

        if (tokens.contains(SQLLexer.Identifier)) {
            stream = stream.filter(e -> e < SQLLexer.ABORT || SQLLexer.WHILE < e);
        }
        if (tokens.contains(SQLLexer.OP_CHARS)) {
            stream = stream.filter(e -> e < SQLLexer.CAST_EXPRESSION || SQLLexer.HASH_SIGN < e);
        }
        return stream;
    }

    @Override
    protected String getTokenName(Integer token, Vocabulary vocabulary) {
        switch (token) {
        case SQLLexer.OP_CHARS:
            return OPERATOR;
        case SQLLexer.DOLLAR_NUMBER:
        case SQLLexer.Identifier:
        case SQLLexer.QuotedIdentifier:
            return IDENTIFIER;
        case SQLLexer.Character_String_Literal:
        case SQLLexer.BeginDollarStringConstant:
            return STRING;
        case SQLLexer.NUMBER_LITERAL:
        case SQLLexer.REAL_NUMBER:
            return NUMBER;
        default:
            return vocabulary.getDisplayName(token);
        }
    }
}
