/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.util.Locale;

import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;

/**
 * Utilities for creation of diffs.
 *
 * @author fordfrog
 */
public final class PgDiffUtils {
    public static final int ERROR_SUBSTRING_LENGTH = 20;

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

    private static String getQuotedName(final String name,
            final boolean excludeKeywords) {
        if (name.contains("-") || name.contains(".") || name.contains("\"")) {
            return quoteName(name);
        }

        for (int i = 0; i < name.length(); i++) {
            final char chr = name.charAt(i);

            if (Character.isUpperCase(chr)) {
                return quoteName(name);
            }
        }

        if (excludeKeywords) {
            return name;
        }

        final String upperName = name.toUpperCase(Locale.ENGLISH);

        for (final String keyword : KEYWORDS) {
            if (keyword.equals(upperName)) {
                return quoteName(name);
            }
        }

        return name;
    }

    private static String quoteName(String name) {
        return '"' + name.replace("\"", "\"\"") + '"';
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
        return getQuotedName(name, false);
    }

    public static String quoteString(String s) {
        return "'" + s.replace("'", "''") + "'";
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
            byte[] bytesOfMessage = s.getBytes(ApgdiffConsts.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(bytesOfMessage);
            StringBuilder sb = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(MessageFormat.format(
                    "UnsupportedEncodingException thrown while getting hash: {0}",
                    e.getLocalizedMessage()), e);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(MessageFormat.format(
                    "NoSuchAlgorithmException thrown while getting hash: {0}",
                    e.getLocalizedMessage()),e);
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

    private PgDiffUtils() {
    }
}
