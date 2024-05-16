/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.core;

public class ChDiffUtils {

    public static String quoteName(String name) {
        return name.startsWith("`") ? name : '`' + name + '`';
    }

    public static String getQuotedName(String name) {
        return isValidId(name, true) ? name : quoteName(name);
    }

    public static boolean isValidId(String id, boolean allowCaps) {
        if (id.isEmpty()) {
            return true;
        }

        for (int i = 0; i < id.length(); i++) {
            if (!isValidIdChar(id.charAt(i), allowCaps, i != 0)) {
                return false;
            }
        }

        return true;
    }

    public static String quoteLiteralName(String name) {
        return name.startsWith("'") ? name : '\'' + name + '\'';
    }

    public static boolean isValidIdChar(char c, boolean allowCaps, boolean allowDigits) {
        if (c >= 'a' && c <= 'z') {
            return true;
        }

        if (allowCaps && c >= 'A' && c <= 'Z') {
            return true;
        }

        if (allowDigits && c >= '0' && c <= '9') {
            return true;
        }

        return c == '_';
    }

    public static String unQuoteName(String name) {
        return name.startsWith("`") ? name.substring(1, name.length() - 1).replace("``", "`") : name;
    }

    public static String unQuoteLiteralName(String name) {
        return name.startsWith("'") ? name.substring(1, name.length() - 1).replace("''", "'") : name;
    }

    private ChDiffUtils() {
    }
}