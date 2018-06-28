package cz.startnet.utils.pgdiff;

import ru.taximaxim.codekeeper.apgdiff.sql.Keyword;
import ru.taximaxim.codekeeper.apgdiff.sql.Keyword.KeywordCategory;

public class MsDiffUtils {
    public static final int ERROR_SUBSTRING_LENGTH = 20;

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
                .append('[').append(name).append(']').toString();
    }

    public static String unquoteQuotedName(String name) {
        return name.substring(1, name.length() - 1).replace("[[", "[").replaceAll("]]", "]");
    }

    private MsDiffUtils() {
    }
}
