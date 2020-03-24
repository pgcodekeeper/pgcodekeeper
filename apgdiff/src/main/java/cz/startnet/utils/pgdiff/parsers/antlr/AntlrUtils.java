package cz.startnet.utils.pgdiff.parsers.antlr;

import java.util.List;
import java.util.Locale;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

public class AntlrUtils {

    public static String normalizeWhitespaceUnquoted(ParserRuleContext ctx, CommonTokenStream stream) {
        StringBuilder sb = new StringBuilder();

        // skip space before first token
        int previous = SQLLexer.DOT;

        List<Token> tokens = stream.getTokens();
        for (int i = ctx.getStart().getTokenIndex(); i <= ctx.getStop().getTokenIndex(); i++) {
            Token token  = tokens.get(i);
            // skip tokens from non default channel
            if (token.getChannel() != Token.DEFAULT_CHANNEL) {
                continue;
            }
            int type = token.getType();

            // remove whitespace after and before some special characters
            if (previous != SQLLexer.DOT
                    && previous != SQLLexer.LEFT_PAREN
                    && previous != SQLLexer.Text_between_Dollar
                    && previous != SQLLexer.BeginDollarStringConstant
                    && type != SQLLexer.DOT
                    && type != SQLLexer.RIGHT_PAREN
                    && type != SQLLexer.Text_between_Dollar
                    && type != SQLLexer.EndDollarStringConstant
                    && type != SQLLexer.COMMA) {
                sb.append(' ');
            }

            sb.append(getTokenText(type, token));
            previous = type;
        }

        return sb.toString();
    }

    private static String getTokenText(int type, Token token) {
        if (type == SQLLexer.QuotedIdentifier
                || type == SQLLexer.Character_String_Literal) {
            // get text with quotes
            return token.getInputStream().getText(
                    Interval.of(token.getStartIndex(), token.getStopIndex()));
        }

        if (SQLLexer.ALL <= type && type <= SQLLexer.WITH) {
            // upper case reserved keywords
            return token.getText().toUpperCase(Locale.ROOT);
        }

        return token.getText();
    }


    /*
     * Because INTO is sometimes used in the main SQL grammar, we have to be
     * careful not to take any such usage of INTO as a PL/pgSQL INTO clause.
     * There are currently three such cases:
     *
     * 1. SELECT ... INTO.  We don't care, we just override that with the
     * PL/pgSQL definition.
     *
     * 2. INSERT INTO.  This is relatively easy to recognize since the words
     * must appear adjacently; but we can't assume INSERT starts the command,
     * because it can appear in CREATE RULE or WITH.  Unfortunately, INSERT is
     * *not* fully reserved, so that means there is a chance of a false match;
     * but it's not very likely.
     *
     * 3. IMPORT FOREIGN SCHEMA ... INTO.  This is not allowed in CREATE RULE
     * or WITH, so we just check for IMPORT as the command's first token.
     * (If IMPORT FOREIGN SCHEMA returned data someone might wish to capture
     * with an INTO-variables clause, we'd have to work much harder here.)
     *
     * See https://github.com/postgres/postgres/blob/master/src/pl/plpgsql/src/pl_gram.y
     */
    public static void removeIntoStatements(Parser parser) {
        CommonTokenStream stream = (CommonTokenStream) parser.getTokenStream();

        boolean isImport = false;
        boolean hasInto = false;
        int i = 0;

        while (true) {
            stream.seek(i++);
            int type = stream.LA(1);

            switch (type) {
            case SQLLexer.EOF:
                stream.reset();
                parser.setInputStream(stream);
                return;
            case SQLLexer.SEMI_COLON:
                isImport = false;
                hasInto = false;
                break;
            case SQLLexer.IMPORT:
                if (stream.LA(2) == SQLLexer.FOREIGN && stream.LA(3) == SQLLexer.SCHEMA) {
                    isImport = true;
                }
                break;
            case SQLLexer.INTO:
                if (hasInto || isImport || stream.LA(- 1) == SQLLexer.INSERT) {
                    break;
                }
                if (hideIntoTokens(stream)) {
                    hasInto = true;
                }
                break;
            default:
                break;
            }
        }
    }

    private static boolean hideIntoTokens(CommonTokenStream stream) {
        int i = 1;
        int nextType = stream.LA(++i); // into

        if (nextType == SQLLexer.STRICT) {
            nextType = stream.LA(++i); // strict
        }

        if (isIdentifier(nextType)) {
            nextType = stream.LA(++i); // identifier

            while ((nextType == SQLLexer.DOT || nextType == SQLLexer.COMMA)
                    && isIdentifier(stream.LA(i + 1))) {
                i += 2; // comma or dot + identifier
                nextType = stream.LA(i);
            }

            // hide from end, because LT(p) skips hidden tokens
            for (int p = i - 1; p > 0; p--) {
                ((CommonToken) stream.LT(p)).setChannel(Token.HIDDEN_CHANNEL);
            }
            return true;
        }

        return false;
    }

    private static boolean isIdentifier(int type) {
        return SQLLexer.ABORT <= type || type <= SQLLexer.WHILE
                || type == SQLLexer.Identifier || type == SQLLexer.QuotedIdentifier;
    }


    private AntlrUtils() {
        // only static
    }

}
