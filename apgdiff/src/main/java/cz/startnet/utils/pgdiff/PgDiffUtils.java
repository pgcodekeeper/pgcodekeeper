/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.IProgressMonitor;

import ru.taximaxim.codekeeper.apgdiff.Log;

/**
 * Utilities for creation of diffs.
 *
 * @author fordfrog
 */
public final class PgDiffUtils {

    public static final int ERROR_SUBSTRING_LENGTH = 20;
    private static final Pattern PATTERN_SQ = Pattern.compile("'", Pattern.LITERAL);
    private static final Pattern PATTERN_DQ = Pattern.compile("\"", Pattern.LITERAL);

    /**
     * Array of reserved keywords. Non-reserved keywords are excluded. Source
     * http://www.postgresql.org/docs/9.0/static/sql-keywords-appendix.html
     */
    // TODO unreserved keywords need not to be quoted, see dumputils.c, fmtId(const char*)
    private static final String[] KEYWORDS = {
            "ABS",
            "ABSOLUTE",
            "ACTION",
            "ADD",
            "ADMIN",
            "AFTER",
            "AGGREGATE",
            "ALIAS",
            "ALL",
            "ALLOCATE",
            "ALTER",
            "ANALYSE",
            "ANALYZE",
            "AND",
            "ANY",
            "ARE",
            "ARRAY",
            "ARRAY_AGG",
            "AS",
            "ASC",
            "ASENSITIVE",
            "ASSERTION",
            "ASYMMETRIC",
            "AT",
            "ATOMIC",
            "AUTHORIZATION",
            "AVG",
            "BEFORE",
            "BEGIN",
            "BETWEEN",
            "BIGINT",
            "BINARY",
            "BIT",
            "BIT_LENGTH",
            "BLOB",
            "BOOLEAN",
            "BOTH",
            "BREADTH",
            "BY",
            "CALL",
            "CALLED",
            "CARDINALITY",
            "CASCADE",
            "CASCADED",
            "CASE",
            "CAST",
            "CATALOG",
            "CEIL",
            "CEILING",
            "CHAR",
            "CHARACTER",
            "CHARACTER_LENGTH",
            "CHAR_LENGTH",
            "CHECK",
            "CLASS",
            "CLOB",
            "CLOSE",
            "COALESCE",
            "COLLATE",
            "COLLATION",
            "COLLECT",
            "COLUMN",
            "COMMIT",
            "COMPLETION",
            "CONCURRENTLY",
            "CONDITION",
            "CONNECT",
            "CONNECTION",
            "CONSTRAINT",
            "CONSTRAINTS",
            "CONSTRUCTOR",
            "CONTINUE",
            "CONVERT",
            "CORR",
            "CORRESPONDING",
            "COUNT",
            "COVAR_POP",
            "COVAR_SAMP",
            "CREATE",
            "CROSS",
            "CUBE",
            "CUME_DIST",
            "CURRENT",
            "CURRENT_CATALOG",
            "CURRENT_DATE",
            "CURRENT_DEFAULT_TRANSFORM_GROUP",
            "CURRENT_PATH",
            "CURRENT_ROLE",
            "CURRENT_SCHEMA",
            "CURRENT_TIME",
            "CURRENT_TIMESTAMP",
            "CURRENT_TRANSFORM_GROUP_FOR_TYPE",
            "CURRENT_USER",
            "CURSOR",
            "CYCLE",
            "DATA",
            "DATALINK",
            "DATE",
            "DAY",
            "DEALLOCATE",
            "DEC",
            "DECIMAL",
            "DECLARE",
            "DEFAULT",
            "DEFERRABLE",
            "DEFERRED",
            "DELETE",
            "DENSE_RANK",
            "DEPTH",
            "DEREF",
            "DESC",
            "DESCRIBE",
            "DESCRIPTOR",
            "DESTROY",
            "DESTRUCTOR",
            "DETERMINISTIC",
            "DIAGNOSTICS",
            "DICTIONARY",
            "DISCONNECT",
            "DISTINCT",
            "DLNEWCOPY",
            "DLPREVIOUSCOPY",
            "DLURLCOMPLETE",
            "DLURLCOMPLETEONLY",
            "DLURLCOMPLETEWRITE",
            "DLURLPATH",
            "DLURLPATHONLY",
            "DLURLPATHWRITE",
            "DLURLSCHEME",
            "DLURLSERVER",
            "DLVALUE",
            "DO",
            "DOMAIN",
            "DOUBLE",
            "DROP",
            "DYNAMIC",
            "EACH",
            "ELEMENT",
            "ELSE",
            "END",
            "END-EXEC",
            "EQUALS",
            "ESCAPE",
            "EVERY",
            "EXCEPT",
            "EXCEPTION",
            "EXEC",
            "EXECUTE",
            "EXISTS",
            "EXP",
            "EXTERNAL",
            "EXTRACT",
            "FALSE",
            "FETCH",
            "FILTER",
            "FIRST",
            "FIRST_VALUE",
            "FLOAT",
            "FLOOR",
            "FOR",
            "FOREIGN",
            "FOUND",
            "FREE",
            "FREEZE",
            "FROM",
            "FULL",
            "FUNCTION",
            "FUSION",
            "GENERAL",
            "GET",
            "GLOBAL",
            "GO",
            "GOTO",
            "GRANT",
            "GROUP",
            "GROUPING",
            "HAVING",
            "HOLD",
            "HOST",
            "HOUR",
            "IDENTITY",
            "IGNORE",
            "ILIKE",
            "IMMEDIATE",
            "IMPORT",
            "IN",
            "INDICATOR",
            "INITIALIZE",
            "INITIALLY",
            "INNER",
            "INOUT",
            "INPUT",
            "INSENSITIVE",
            "INSERT",
            "INT",
            "INTEGER",
            "INTERSECT",
            "INTERSECTION",
            "INTERVAL",
            "INTO",
            "IS",
            "ISNULL",
            "ISOLATION",
            "ITERATE",
            "JOIN",
            "KEY",
            "LAG",
            "LANGUAGE",
            "LARGE",
            "LAST",
            "LAST_VALUE",
            "LATERAL",
            "LEAD",
            "LEADING",
            "LEFT",
            "LESS",
            "LEVEL",
            "LIKE",
            "LIKE_REGEX",
            "LIMIT",
            "LN",
            "LOCAL",
            "LOCALTIME",
            "LOCALTIMESTAMP",
            "LOCATOR",
            "LOWER",
            "MAP",
            "MATCH",
            "MAX",
            "MAX_CARDINALITY",
            "MEMBER",
            "MERGE",
            "METHOD",
            "MIN",
            "MINUTE",
            "MOD",
            "MODIFIES",
            "MODIFY",
            "MODULE",
            "MONTH",
            "MULTISET",
            "NAMES",
            "NATIONAL",
            "NATURAL",
            "NCHAR",
            "NCLOB",
            "NEW",
            "NEXT",
            "NO",
            "NONE",
            "NORMALIZE",
            "NOT",
            "NOTNULL",
            "NTH_VALUE",
            "NTILE",
            "NULL",
            "NULLIF",
            "NUMERIC",
            "OBJECT",
            "OCCURRENCES_REGEX",
            "OCTET_LENGTH",
            "OF",
            "OFF",
            "OFFSET",
            "OLD",
            "ON",
            "ONLY",
            "OPEN",
            "OPERATION",
            "OPTION",
            "OR",
            "ORDER",
            "ORDINALITY",
            "OUT",
            "OUTER",
            "OUTPUT",
            "OVER",
            "OVERLAPS",
            "OVERLAY",
            "PAD",
            "PARAMETER",
            "PARAMETERS",
            "PARTIAL",
            "PARTITION",
            "PATH",
            "PERCENTILE_CONT",
            "PERCENTILE_DISC",
            "PERCENT_RANK",
            "PLACING",
            "POSITION",
            "POSITION_REGEX",
            "POSTFIX",
            "POWER",
            "PRECISION",
            "PREFIX",
            "PREORDER",
            "PREPARE",
            "PRESERVE",
            "PRIMARY",
            "PRIOR",
            "PRIVILEGES",
            "PROCEDURE",
            //        "PUBLIC",
            "RANGE",
            "RANK",
            "READ",
            "READS",
            "REAL",
            "RECURSIVE",
            "REF",
            "REFERENCES",
            "REFERENCING",
            "REGR_AVGX",
            "REGR_AVGY",
            "REGR_COUNT",
            "REGR_INTERCEPT",
            "REGR_R2",
            "REGR_SLOPE",
            "REGR_SXX",
            "REGR_SXY",
            "REGR_SYY",
            "RELATIVE",
            "RELEASE",
            "RESTRICT",
            "RESULT",
            "RETURN",
            "RETURNING",
            "RETURNS",
            "REVOKE",
            "RIGHT",
            "ROLE",
            "ROLLBACK",
            "ROLLUP",
            "ROUTINE",
            "ROW",
            "ROWS",
            "ROW_NUMBER",
            "SAVEPOINT",
            "SCHEMA",
            "SCOPE",
            "SCROLL",
            "SEARCH",
            "SECOND",
            "SECTION",
            "SELECT",
            "SENSITIVE",
            "SEQUENCE",
            "SESSION",
            "SESSION_USER",
            "SET",
            "SETS",
            "SIMILAR",
            "SIZE",
            "SMALLINT",
            "SOME",
            "SPACE",
            "SPECIFIC",
            "SPECIFICTYPE",
            //        "SQL",
            "SQLCODE",
            "SQLERROR",
            "SQLEXCEPTION",
            "SQLSTATE",
            "SQLWARNING",
            "SQRT",
            "START",
            "STATE",
            "STATEMENT",
            "STATIC",
            "STDDEV_POP",
            "STDDEV_SAMP",
            "STRUCTURE",
            "SUBMULTISET",
            "SUBSTRING",
            "SUBSTRING_REGEX",
            "SUM",
            "SYMMETRIC",
            "SYSTEM",
            "SYSTEM_USER",
            "TABLE",
            "TABLESAMPLE",
            "TEMPORARY",
            "TERMINATE",
            "THAN",
            "THEN",
            "TIME",
            "TIMESTAMP",
            "TIMEZONE_HOUR",
            "TIMEZONE_MINUTE",
            "TO",
            "TRAILING",
            "TRANSACTION",
            "TRANSLATE",
            "TRANSLATE_REGEX",
            "TRANSLATION",
            "TREAT",
            "TRIGGER",
            "TRIM",
            "TRIM_ARRAY",
            "TRUE",
            "TRUNCATE",
            "UESCAPE",
            "UNDER",
            "UNION",
            "UNIQUE",
            "UNKNOWN",
            "UNNEST",
            "UPDATE",
            "UPPER",
            "USAGE",
            "USER",
            "USING",
            "VALUE",
            "VALUES",
            "VARBINARY",
            "VARCHAR",
            "VARIABLE",
            "VARIADIC",
            "VARYING",
            "VAR_POP",
            "VAR_SAMP",
            "VERBOSE",
            "VIEW",
            "WHEN",
            "WHENEVER",
            "WHERE",
            "WIDTH_BUCKET",
            "WINDOW",
            "WITH",
            "WITHIN",
            "WITHOUT",
            "WORK",
            "WRITE",
            "XML",
            "XMLAGG",
            "XMLATTRIBUTES",
            "XMLBINARY",
            "XMLCAST",
            "XMLCOMMENT",
            "XMLCONCAT",
            "XMLDOCUMENT",
            "XMLELEMENT",
            "XMLEXISTS",
            "XMLFOREST",
            "XMLITERATE",
            "XMLNAMESPACES",
            "XMLPARSE",
            "XMLPI",
            "XMLQUERY",
            "XMLROOT",
            "XMLSERIALIZE",
            "XMLTABLE",
            "XMLTEXT",
            "XMLVALIDATE",
            "YEAR",
            "ZONE"
    };

    public static boolean isValidId(String id, boolean allowKeywords, boolean allowCaps) {
        if (id.isEmpty()) {
            return true;
        }

        char c = id.charAt(0);
        if ((c < 'a' || c > 'z') && (!allowCaps || c < 'A' || c > 'Z') && c != '_') {
            return false;
        }

        for (int i = 1; i < id.length(); i++) {
            c = id.charAt(i);
            if ((c < 'a' || c > 'z') && (!allowCaps || c < 'A' || c > 'Z') && (c < '0' || c > '9') && c != '_') {
                return false;
            }
        }

        if (allowKeywords) {
            return true;
        }

        final String upperName = id.toUpperCase(Locale.ENGLISH);
        for (final String keyword : KEYWORDS) {
            if (keyword.equals(upperName)) {
                return false;
            }
        }

        return true;
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

    /**
     * @return lowercase hex MD5 for UTF-8 representation of given string.
     */
    public static String md5(String s) {
        try {
            byte[] hash = MessageDigest.getInstance("MD5")
                    .digest(s.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Log.log(ex);
            return "MD5_ERROR_" + new Random().nextInt();
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

    private PgDiffUtils() {
    }
}
