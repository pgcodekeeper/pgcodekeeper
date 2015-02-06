/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.parsers;

import java.text.MessageFormat;
import java.util.Locale;

import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

/**
 * Class for parsing strings.
 *
 * @author fordfrog
 */
public final class Parser {
    
    /**
     * String to be parsed.
     */
    private String string;
    /**
     * Current position.
     */
    private int position;

    /**
     * Creates new instance of Parser.
     *
     * @param string {@link #string}
     */
    public Parser(final String string) {
        this.string = string;
        skipWhitespace();
    }

    /**
     * Checks whether the string contains given word on current position. If not
     * then throws an exception.
     *
     * @param words list of words to check
     */
    public void expect(final String... words) {
        for (final String word : words) {
            expect(word, false);
        }
    }
    
    /**
     * Checks whether one of the words is present at current position. If a
     * word is present then the word is returned and position is updated.
     * Throws an exception if no words found.
     *
     * @param words words to check
     *
     * @return found word or throws if none of the words has been found
     *
     * @see #expectOptional(java.lang.String[])
     */
    public String expectOneOf(final String... words) {
        final int last = words.length - 1;
        for (int i = 0; i < last - 1; ++i) {
            if (expect(words[i], true)) {
                return words[i];
            }
        }
        
        if (expect(words[last], false)) {
            return words[last];
        } else {
            // never happens
            // expect(word, false) throws if none of the words has been found
            return null;
        }
    }

    /**
     * Checks whether the string contains given word on current position. If not
     * and expectation is optional then position is not changed and method
     * returns true. If expectation is not optional, exception with error
     * description is thrown. If word is found, position is moved at first
     * non-whitespace character following the word.
     *
     * @param word     word to expect
     * @param optional true if word is optional, otherwise false
     *
     * @return true if word was found, otherwise false
     */
    private boolean expect(final String word, final boolean optional) {
        final int wordEnd = position + word.length();

        if (wordEnd <= string.length()
                && string.substring(position, wordEnd).equalsIgnoreCase(word)
                && (wordEnd == string.length()
                || Character.isWhitespace(string.charAt(wordEnd))
                || string.charAt(wordEnd) == ';'
                || string.charAt(wordEnd) == ')'
                || string.charAt(wordEnd) == ','
                || string.charAt(wordEnd) == '['
                || string.charAt(wordEnd) == '('
                || "(".equals(word) || ")".equals(word) || ",".equals(word)
                || "[".equals(word) || "]".equals(word))) {
            position = wordEnd;
            skipWhitespace();

            return true;
        }

        if (optional) {
            return false;
        }

        throw new ParserException(MessageFormat.format(
                Messages.Parser_CannotParseStringExpectedWord, string,
                word, position + 1, getErrorSubstring()));
    }

    /**
     * Checks whether string contains at current position sequence of the words.
     *
     * @param words array of words
     *
     * @return true if whole sequence was found, otherwise false
     */
    public boolean expectOptional(final String... words) {
        final boolean found = expect(words[0], true);

        if (!found) {
            return false;
        }

        for (int i = 1; i < words.length; i++) {
            skipWhitespace();
            expect(words[i]);
        }

        return true;
    }

    /**
     * Moves position in the string to next non-whitespace string.
     */
    public void skipWhitespace() {
        for (; position < string.length(); position++) {
            if (!Character.isWhitespace(string.charAt(position))) {
                break;
            }
        }
    }

    /**
     * Parses identifier from current position. If identifier is quoted, it is
     * returned quoted. If the identifier is not quoted, it is converted to
     * lowercase. If identifier does not start with letter then exception is
     * thrown. Position is placed at next first non-whitespace character.
     *
     * @return parsed identifier
     */
    public String parseIdentifier() {
        StringBuilder identifier = new StringBuilder();
        boolean firstPass = true;
        
        do {
            if(firstPass) {
                firstPass = false;
            } else {
                position++;
                skipWhitespace();
                identifier.append('.');
            }
            
            identifier.append(parseIdentifierInternal());
            skipWhitespace();
        } while (position < string.length() && string.charAt(position) == '.');
        
        return identifier.toString();
    }

    /**
     * Parses single part of the identifier.
     *
     * @return parsed identifier
     */
    private String parseIdentifierInternal() {
        // quoted identifier
        if (string.charAt(position) == '"') {
            int endPos = position - 1; // see comment below
            
            do {
                // the purpose of this loop is to check for escaped quotes (doubled quotes)
                
                // if we do more than one iteration
                // it means we need to skip TWO quotes (escaped quotes)
                // hence (position - 1) above
                endPos += 2;
                endPos = string.indexOf('"', endPos);
            } while(string.charAt(endPos) != '"' // checks endPos != -1
                    
                    // check for doubled quotes (escaped quote) ""
                    // if the quote is escaped (doubled) - ignore this one look for the next
                    || (endPos + 1 < string.length() && string.charAt(endPos + 1) == '"'));
            
            final String result = string.substring(position, endPos + 1);
            position = endPos + 1;

            return result;
        } else {
            int endPos = position;

            for (; endPos < string.length(); endPos++) {
                final char chr = string.charAt(endPos);

                if (Character.isWhitespace(chr) || chr == ',' || chr == ')'
                        || chr == '(' || chr == ';' || chr == '.') {
                    break;
                }
            }

            final String result =
                    string.substring(position, endPos).toLowerCase(
                    Locale.ENGLISH);

            position = endPos;

            return result;
        }
    }

    /**
     * Returns rest of the string. If the string ends with ';' then it is
     * removed from the string before returned. If there is nothing more in the
     * string, null is returned.
     *
     * @return rest of the string, without trailing ';' if present, or null if
     *         there is nothing more in the string
     */
    public String getRest() {
        final String result;

        if (string.charAt(string.length() - 1) == ';') {
            if (position == string.length() - 1) {
                return null;
            } else {
                result = string.substring(position, string.length() - 1);
            }
        } else {
            result = string.substring(position);
        }

        position = string.length();

        return result;
    }

    /**
     * Parses integer from the string. If next word is not integer then
     * exception is thrown.
     *
     * @return parsed integer value
     */
    public int parseInteger() {
        int endPos = position;
        // FIXME negative numbers?
        for (; endPos < string.length(); endPos++) {
            if (!Character.isLetterOrDigit(string.charAt(endPos))) {
                break;
            }
        }

        try {
            final int result =
                    Integer.parseInt(string.substring(position, endPos));

            position = endPos;
            skipWhitespace();

            return result;
        } catch (final NumberFormatException ex) {
            throw new ParserException(MessageFormat.format(
                    Messages.Parser_CannotParseStringExpectedInteger,
                    string, position + 1, getErrorSubstring(), ex));
        }
    }

    /**
     * Parses string from the string. String can be either quoted or unqouted.
     * Quoted string is parsed till next unescaped quote. Unquoted string is
     * parsed till whitespace, ',' ')' or ';' is found. If string should be
     * empty, exception is thrown.
     *
     * @return parsed string, if quoted then including quotes
     */
    public String parseString() {
        final boolean quoted = string.charAt(position) == '\'';

        if (quoted) {
            int endPos = position + 1;

            for (; endPos < string.length(); endPos++) {
                final char chr = string.charAt(endPos);

                if (chr == '\'') {
                    if (endPos + 1 < string.length()
                            && string.charAt(endPos + 1) == '\'') {
                        endPos++;
                    } else {
                        break;
                    }
                }
            }

            final String result;

            try {
                result = string.substring(position, endPos + 1);
            } catch (final IndexOutOfBoundsException ex) {
                throw new ParserException("Failed to get substring: " + string
                        + " start pos: " + position + " end pos: "
                        + (endPos + 1), ex);
            }

            position = endPos + 1;
            skipWhitespace();

            return result;
        } else {
            int endPos = position;

            for (; endPos < string.length(); endPos++) {
                final char chr = string.charAt(endPos);

                if (Character.isWhitespace(chr) || chr == ',' || chr == ')'
                        || chr == ';') {
                    break;
                }
            }

            if (position == endPos) {
                throw new ParserException(MessageFormat.format(
                        Messages.Parser_CannotParseStringExpectedString,
                        string, position + 1));
            }

            final String result = string.substring(position, endPos);

            position = endPos;
            skipWhitespace();

            return result;
        }
    }

    /**
     * Returns expression that is ended either with ',', ')' or with end of the
     * string. If expression is empty then exception is thrown.
     *
     * @param terminationWords optional additional termination words.
     *                          Words may consist only of letters.
     *
     * @return expression string
     */
    public String getExpression(String... terminationWords) {
        final int endPos = getExpressionEnd(terminationWords);

        if (position == endPos) {
            throw new ParserException(MessageFormat.format(
                    Messages.Parser_CannotParseStringExpectedExpression,
                    string, position + 1, getErrorSubstring()));
        }

        final String result = string.substring(position, endPos).trim();

        position = endPos;

        return result;
    }

    /**
     * Returns position of last character of single command within statement
     * (like CREATE TABLE). Last character is either ',' or ')'. If no such
     * character is found and method reaches the end of the command then
     * position after the last character in the command is returned.
     * 
     * @param terminationWords optional additional termination words.
     *                          Words may consist only of letters.
     *
     * @return end position of the command
     */
    protected int getExpressionEnd(String... terminationWords) {
        int bracesCount = 0;
        boolean singleQuoteOn = false,
                doubleQuoteOn = false;
        int charPos = position;

        for (; charPos < string.length(); charPos++) {
            final char chr = string.charAt(charPos);

            if (chr == '\'' && !doubleQuoteOn) {
                singleQuoteOn = !singleQuoteOn;
                continue;
            }
            if (chr == '"' && !singleQuoteOn) {
                doubleQuoteOn = !doubleQuoteOn;
                continue;
            }

            if(!singleQuoteOn && !doubleQuoteOn) {
                if (chr == '(') {
                    bracesCount++;
                } else if (bracesCount == 0) {
                    if (chr == ',' || chr == ';' || chr == ')') {
                        break;
                    }
                    
                    boolean wordReached = false;
                    
                    for (String word : terminationWords) {
                        
                        // first, check if the word is properly delimited
                        // and is not a part of a bigger word
                        // any non-letter character delimits the word
                        if (charPos - 1 > -1 &&
                                Character.isJavaIdentifierStart(string.charAt(
                                        charPos - 1))) {
                            // current char continues another word, skip this word
                            continue;
                        }
                        if (charPos < string.length() - word.length()
                                && Character.isJavaIdentifierStart(string.charAt(
                                        charPos + word.length()))) {
                            // char after the word continues it, skip this word
                            continue;
                        }
                        
                        // now check if the word is actually there
                        if (string.regionMatches(true, charPos, word, 0, word.length())) {
                            wordReached = true;
                            break;
                        }
                    }
                    if (wordReached) {
                        break;
                    }
                } else if (chr == ')') {
                    bracesCount--;
                }
            }
        }

        return charPos;
    }

    /**
     * Returns current position in the string.
     *
     * @return current position in the string
     */
    public int getPosition() {
        return position;
    }

    /**
     * Returns parsed string.
     *
     * @return parsed string
     */
    public String getString() {
        return string;
    }

    /**
     * Throws exception about unsupported command in statement.
     */
    public void throwUnsupportedCommand() {
        throw new ParserException(MessageFormat.format(
                Messages.Parser_CannotParseStringUnsupportedCommand,
                string, position + 1, getErrorSubstring()));
    }

    /**
     * Checks whether one of the words is present at current position. If the
     * word is present then the word is returned and position is updated.
     *
     * @param words words to check
     *
     * @return found word or null if non of the words has been found
     *
     * @see #expectOptional(java.lang.String[])
     */
    public String expectOptionalOneOf(final String... words) {
        for (final String word : words) {
            if (expectOptional(word)) {
                return word;
            }
        }

        return null;
    }

    /**
     * Returns substring from the string.
     *
     * @param startPos start position
     * @param endPos   end position exclusive
     *
     * @return substring
     */
    public String getSubString(final int startPos, final int endPos) {
        return string.substring(startPos, endPos);
    }

    /**
     * Changes current position in the string.
     *
     * @param position new position
     */
    public void setPosition(final int position) {
        this.position = position;
    }

    /**
     * Parses data type from the string. Position is updated. If data type
     * definition is not found then exception is thrown.
     *
     * @return data type string
     */
    public String parseDataType() {
        int endPos = position;

        while (endPos < string.length()
                && !Character.isWhitespace(string.charAt(endPos))
                && string.charAt(endPos) != '('
                && string.charAt(endPos) != ')'
                && string.charAt(endPos) != ',') {
            endPos++;
        }

        if (endPos == position) {
            throw new ParserException(MessageFormat.format(
                    Messages.Parser_CannotParseStringExpectedDataType,
                    string, position + 1, getErrorSubstring()));
        }

        String dataType = string.substring(position, endPos);

        position = endPos;
        skipWhitespace();

        if ("character".equalsIgnoreCase(dataType)
                && expectOptional("varying")) {
            dataType = "character varying";
        } else if ("double".equalsIgnoreCase(dataType)
                && expectOptional("precision")) {
            dataType = "double precision";
        }

        final boolean timestamp = "timestamp".equalsIgnoreCase(dataType)
                || "time".equalsIgnoreCase(dataType);

        if (expectOptional("(")) {
            dataType += '(';
            boolean comma;
            do {
                dataType += getExpression();
                comma = expectOptional(",");
                if (comma) {
                    dataType += ',';
                }
            } while (comma);
            expect(")");
            dataType += ')';
        }

        if (timestamp) {
            if (expectOptional("with", "time", "zone")) {
                dataType += " with time zone";
            } else if (expectOptional("without", "time", "zone")) {
                dataType += " without time zone";
            }
        }

        if (expectOptional("[")) {
            expect("]");
            dataType += "[]";
        }

        return dataType;
    }

    /**
     * Checks whether the whole string has been consumed.
     *
     * @return true if there is nothing left to parse, otherwise false
     */
    public boolean isConsumed() {
        return position == string.length()
                || position + 1 == string.length()
                && string.charAt(position) == ';';
    }
    
    private String getErrorSubstring() {
        return ParserUtils.getErrorSubstr(string, position);
    }
}
