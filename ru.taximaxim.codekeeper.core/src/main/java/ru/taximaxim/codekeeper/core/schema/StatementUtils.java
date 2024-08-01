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
package ru.taximaxim.codekeeper.core.schema;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.localizations.Messages;

public class StatementUtils {

    /** Checks if the order of the table columns has changed.<br><br>
     *
     * <b>Example:</b><br><br>
     *
     * original columns : c1, c2, c3<br>
     * new columns      : c2, c3, c1<br><br>
     *
     * Column c1 was moved to last index and method will return true<br><br>
     *
     * <b>Example:</b><br><br>
     *
     * original columns : c1, c2, c3<br>
     * new columns      : c2, c3, c4<br><br>
     *
     * Column c1 was deleted and column c4 was added. Method will return false.<br><br>
     *
     * <b>Example:</b><br><br>
     *
     * original columns : c1, c2, c3<br>
     * new columns      : c1, c4, c2, c3<br><br>
     *
     * Column c4 was added between old columns: c1 and c2. Method will return true.<br><br>
     *
     * <b>Example:</b><br><br>
     *
     * original columns : c2, c3, inherit(some table)<br>
     * new columns      : c1, c2, c3<br><br>
     *
     * Some table is no longer inherited. If table did not have a column c1,
     * we must return true, but we cannot track this right now. Method will return false. <br><br>
     *
     * @param newTable - new table
     * @return true if order was changed or order is ignored
     * @since 5.1.7
     */
    public static boolean isColumnsOrderChanged(List<AbstractColumn> newColumns, List<AbstractColumn> oldColumns) {
        // last founded column
        int i = -1;
        for (AbstractColumn col : newColumns) {
            // old column index
            int index = 0;
            // search old column index by new column name
            for ( ; index < oldColumns.size(); index++) {
                if (col.getName().equals(oldColumns.get(index).getName())) {
                    break;
                }
            }

            if (index == oldColumns.size()) {
                // New column was not found in original table.
                // After this column can be only new columns.
                i = Integer.MAX_VALUE;
            } else if (index < i) {
                // New column was found in original table
                // but one of previous columns was not found
                // or was located on more later index
                return true;
            } else {
                // New column was found in original table.
                // Safe index of column in original table.
                i = index;
            }
        }

        return false;
    }

    public static void appendCols(StringBuilder sbSQL, Collection<String> cols, DatabaseType dbType) {
        sbSQL.append('(');
        switch (dbType) {
        case PG:
            for (var col : cols) {
                sbSQL.append(PgDiffUtils.getQuotedName(col));
                sbSQL.append(", ");
            }
            break;
        case MS:
            for (var col : cols) {
                sbSQL.append(MsDiffUtils.quoteName(col));
                sbSQL.append(", ");
            }
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
        }
        sbSQL.setLength(sbSQL.length() - 2);
        sbSQL.append(')');
    }

    public static void appendOptionsWithParen(StringBuilder sbSQL, Map<String, String> options, DatabaseType dbType) {
        sbSQL.append(" (");
        appendOptions(sbSQL, options, dbType);
        sbSQL.append(')');
    }

    public static void appendCollection(StringBuilder sbSQL, Collection<String> collection,
            String delimiter, boolean needParens) {
        if (collection.isEmpty()) {
            return;
        }

        if (needParens) {
            sbSQL.append(" (");
        }
        for (var element : collection) {
            sbSQL.append(element).append(delimiter);
        }
        sbSQL.setLength(sbSQL.length() - delimiter.length());
        if (needParens) {
            sbSQL.append(')');
        }
    }

    /**
     * Appends parameters/options at StringBuilder. This StringBuilder used in
     * schema package Constraint's classes in the method getDifinition()
     *
     * @param sbSQL
     *            - the StringBuilder from method getDifinition()
     *
     * @param options
     *            - the Map<String, String> where key is parameter/option and
     *            value is value of this parameter/option
     *
     * @param dbType
     *            - the DatabaseType variable in package schema what's need us for
     *            correct delimiter, because in postgres and microsoft server is
     *            different
     */
    public static void appendOptions(StringBuilder sbSQL, Map<String, String> options, DatabaseType dbType) {
        for (var option : options.entrySet()) {
            sbSQL.append(option.getKey());
            var value = option.getValue();
            if (value != null && !value.isEmpty()) {
                switch (dbType) {
                case PG:
                    sbSQL.append('=').append(value);
                    break;
                case MS:
                    sbSQL.append(" = ").append(value);
                    break;
                default:
                    throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + dbType);
                }
            }
            sbSQL.append(", ");
        }
        sbSQL.setLength(sbSQL.length() - 2);
    }

    public static String getFullBareName(PgStatement st) {
        StringBuilder sb = new StringBuilder(st.getBareName());
        PgStatement par = st.getParent();
        while (par != null && !(par instanceof AbstractDatabase)) {
            sb.insert(0, '.').insert(0, par.getBareName());
            par = par.getParent();
        }

        return sb.toString();
    }

    private StatementUtils() {}
}
