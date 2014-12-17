/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import cz.startnet.utils.pgdiff.schema.PgDatabase;

/**
 * Parser utilities.
 *
 * @author fordfrog
 */
public final class ParserUtils {

    /**
     * Returns object name from optionally schema qualified name.
     *
     * @param name optionally schema qualified name
     *
     * @return name of the object
     */
    public static String getObjectName(final String name) {
        final String[] names = splitNames(name);

        return names[names.length - 1];
    }

    /**
     * Returns second (from right) object name from optionally schema qualified
     * name.
     *
     * @param name optionally schema qualified name
     *
     * @return name of the object
     */
    public static String getSecondObjectName(final String name) {
        final String[] names = splitNames(name);

        return names.length >= 2 ? names[names.length - 2] : null;
    }

    /**
     * Returns third (from right) object name from optionally schema qualified
     * name.
     *
     * @param name optionally schema qualified name
     *
     * @return name of the object or null if there is no third object name
     */
    public static String getThirdObjectName(final String name) {
        final String[] names = splitNames(name);

        return names.length >= 3 ? names[names.length - 3] : null;
    }

    /**
     * Returns schema name from optionally schema qualified name.
     *
     * @param name     optionally schema qualified name
     * @param database database
     *
     * @return name of the schema
     */
    public static String getSchemaName(final String name,
            final PgDatabase database) {
        final String[] names = splitNames(name);

        if (names.length < 2) {
            return database.getDefaultSchema().getName();
        } else {
            return names[0];
        }
    }

    /**
     * Splits qualified names by dots. If names are quoted then quotes are
     * removed.
     * <br><br>
     * This method uses identifier parsing mechanism from
     * {@link #Parser.parseIdentifierInternal()}
     *
     * @param string qualified name
     *
     * @return array of names
     */
    public static String[] splitNames(final String string) {
        if (string.indexOf('"') == -1) {
            return string.split(Pattern.quote("."));
        } else {
            final List<String> strings = new ArrayList<>(3);
            int startPos = 0;

            while (true) {
                if (string.charAt(startPos) == '"') {
                    // see Parser.parseIdentifierInternal for explanation of this method
                    int endPos = startPos - 1;
                    do {
                        endPos += 2;
                        endPos = string.indexOf('"', endPos);
                    } while(string.charAt(endPos) != '"'
                            || (endPos + 1 < string.length()
                                    && string.charAt(endPos + 1) == '"'));
                    
                    strings.add(string.substring(startPos + 1, endPos)
                            .replace("\"\"", "\""));

                    if (endPos + 1 == string.length()) {
                        break;
                    } else if (string.charAt(endPos + 1) == '.') {
                        startPos = endPos + 2;
                    } else {
                        startPos = endPos + 1;
                    }
                } else {
                    final int endPos = string.indexOf('.', startPos);

                    if (endPos == -1) {
                        strings.add(string.substring(startPos));
                        break;
                    } else {
                        strings.add(string.substring(startPos, endPos));
                        startPos = endPos + 1;
                    }
                }
            }

            return strings.toArray(new String[strings.size()]);
        }
    }
    
    public static String quoteString(String s) {
        return "'" + s.replace("'", "''") + "'";
    }

    /**
     * Creates a new instance of ParserUtils.
     */
    private ParserUtils() {
    }
}
