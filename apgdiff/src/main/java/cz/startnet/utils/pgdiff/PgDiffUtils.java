/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.apgdiff.Log;
import ru.taximaxim.codekeeper.apgdiff.sql.Keyword;
import ru.taximaxim.codekeeper.apgdiff.sql.Keyword.KeywordCategory;

/**
 * Utilities for creation of diffs.
 *
 * @author fordfrog
 */
public final class PgDiffUtils {

    public static final int ERROR_SUBSTRING_LENGTH = 20;
    private static final Pattern PATTERN_SQ = Pattern.compile("'", Pattern.LITERAL);
    private static final Pattern PATTERN_DQ = Pattern.compile("\"", Pattern.LITERAL);

    public static boolean isValidId(String id, boolean allowKeywords, boolean allowCaps) {
        if (id.isEmpty()) {
            return true;
        }

        for (int i = 0; i < id.length(); i++) {
            if (!isValidIdChar(id.charAt(i), allowCaps, i != 0)) {
                return false;
            }
        }

        if (!allowKeywords) {
            Keyword keyword = Keyword.KEYWORDS.get(id);
            if (keyword != null && keyword.getCategory() != KeywordCategory.UNRESERVED_KEYWORD) {
                return false;
            }
        }

        return true;
    }

    public static boolean isValidIdChar(char c) {
        return isValidIdChar(c, true, true);
    }

    public static boolean isValidIdChar(char c, boolean allowCaps, boolean allowDigits) {
        return (c >= 'a' && c <= 'z') ||
                (allowCaps && c >= 'A' && c <= 'Z') ||
                (allowDigits && c >= '0' && c <= '9') ||
                c == '_';
    }

    /**
     * If name contains only lower case characters and digits and is not
     * keyword, it is returned not quoted, otherwise the string is returned
     * quoted.
     *
     * @param name name
     *
     * @return quoted string if needed, otherwise not quoted string
     */
    public static String getQuotedName(final String name) {
        return isValidId(name, false, false) ? name : quoteName(name);
    }

    public static String quoteName(String name) {
        return new StringBuilder(name.length() + 2)
                .append('"')
                .append(name.indexOf('"') != -1 ? PATTERN_DQ.matcher(name).replaceAll("\"\"") : name)
                .append('"')
                .toString();
    }

    public static String quoteString(String s) {
        return appendQuotedString(new StringBuilder(s.length() + 2), s).toString();
    }

    public static StringBuilder appendQuotedString(StringBuilder sb, String s) {
        return sb.append('\'')
                .append(s.indexOf('\'') != -1 ? PATTERN_SQ.matcher(s).replaceAll("''") : s)
                .append('\'');
    }

    public static String unquoteQuotedName(String name) {
        return name.substring(1, name.length() - 1).replace("\"\"", "\"");
    }

    public static String unquoteQuotedString(String s) {
        return s.substring(1, s.length() - 1).replace("''", "'");
    }

    @Deprecated
    // TODO use antlr context's getText()
    public static String normalizeWhitespaceUnquoted(String string) {
        StringBuilder sb = new StringBuilder(string.length());

        boolean quote = false,
                doubleQuote = false;
        int currentWhitespaceStart = -1;
        for (int pos = 0; pos < string.length(); ++pos) {
            char ch = string.charAt(pos);

            if (ch == '\'') {
                if (!doubleQuote) {
                    quote = !quote;
                }
            } else if (ch == '"') {
                if (!quote) {
                    doubleQuote = !doubleQuote;
                }
            } else if (Character.isWhitespace(ch) && !quote && !doubleQuote) {
                if (currentWhitespaceStart < 0) {
                    currentWhitespaceStart = pos;
                }

                // do not add whitespace while iterating over it
                continue;
            } else {
                // if we interrupted some whitespace
                if (currentWhitespaceStart >= 0) {
                    // check whitespace boundaries, if it was delimited by a
                    // special character do not separate that character - add nothing
                    // if whitespace was necessary (e.g. delimited words) - add one space
                    boolean removeWhitespace = false;

                    if (currentWhitespaceStart - 1 >= 0) {
                        char preW = string.charAt(currentWhitespaceStart - 1);
                        removeWhitespace |= preW == '(' || preW == ')'
                                || preW == ',';
                    }
                    if (pos + 1 < string.length()) {
                        char postW = string.charAt(pos + 1);
                        removeWhitespace |= postW == '(' || postW == ')'
                                || postW == ',';
                    }

                    // reset whitespace flag
                    currentWhitespaceStart = -1;
                    if (!removeWhitespace) {
                        sb.append(' ');
                    }
                }
            }

            // append unskipped characters
            sb.append(ch);
        }

        return sb.toString();
    }

    public static String hash (String s, String instance) {
        try {
            byte[] hash = MessageDigest.getInstance(instance)
                    .digest(s.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Log.log(ex);
            return instance +"_ERROR_" + new Random().nextInt();
        }
    }

    /**
     * @return lowercase hex SHA-256 for UTF-8 representation of given string.
     */

    public static String sha(String s) {
        return hash(s, "SHA-256");
    }

    /**
     * @return lowercase hex MD5 for UTF-8 representation of given string.
     */
    public static String md5(String s) {
        return hash(s, "MD5");
    }

    public static String checkedEncodeUtf8(String string) {
        try {
            return URLEncoder.encode(string, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return string;
        }
    }

    public static String getErrorSubstr(String s, int pos) {
        return PgDiffUtils.getErrorSubstr(s, pos, ERROR_SUBSTRING_LENGTH);
    }

    public static String getErrorSubstr(String s, int pos, int len) {
        if (pos >= s.length()) {
            return "";
        }
        return pos + len < s.length() ? s.substring(pos, pos + len) : s.substring(pos);
    }

    public static void checkCancelled(IProgressMonitor monitor)
            throws InterruptedException {
        if (monitor != null && monitor.isCanceled()) {
            throw new InterruptedException();
        }
    }

    /**
     * Compares 2 collections for equality unorderedly as if they were {@link Set}s.<br>
     * Does not eliminate duplicate elements as sets do and counts them instead.
     * Thus it achieves complementarity with {@link #setlikeHashcode}
     * while not requiring it to eliminate duplicates, nor does it require
     * a <code>List.containsAll()</code> O(N^2) call here.
     * In general, duplicate elimination is an undesired side-effect of comparison using {@link Set}s,
     * so this solution is overall better and only *slightly* slower.<br><br>
     *
     * Performance: best case O(1), worst case O(N) + new {@link HashMap} (in case N1 == N2),
     * assuming size() takes constant time.
     */
    public static boolean setlikeEquals(Collection<?> c1, Collection<?> c2) {
        final int s1 = c1.size();
        if (s1 != c2.size()) {
            return false;
        }
        // mimic HashSet(Collection) constructor
        final float loadFactor = 0.75f;
        final Map<Object, Integer> map =
                new HashMap<>(Math.max((int) (s1/loadFactor) + 1, 16), loadFactor);
        for (Object el1 : c1) {
            Integer i = map.get(el1);
            map.put(el1, i == null ? 1 : (i + 1));
        }
        for (Object el2 : c2) {
            Integer i = map.get(el2);
            if (i == null) {
                // c1.count(el2) < c2.count(el2)
                return false;
            }
            if (i == 1) {
                // the last or the only instance of el2 in c1
                map.remove(el2);
            } else {
                // counted one duplicate
                map.put(el2, i - 1);
            }
        }
        // if the map is not empty at the end it means that
        // not all duplicates in c1 were matched by those in c2
        return map.isEmpty();
    }

    /**
     * Complementary hashCode for {@link #setlikeEquals(Collection, Collection)} equals.
     */
    public static int setlikeHashcode(Collection<?> c) {
        int h = 0;
        for (Object el : c) {
            h += el.hashCode();
        }
        return h;
    }


    public static boolean isStringNotEmpty(String input) {
        return input != null && !input.isEmpty();
    }

    private PgDiffUtils() {
    }
}
