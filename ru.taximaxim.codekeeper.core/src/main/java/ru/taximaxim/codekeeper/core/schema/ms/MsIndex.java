/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SimpleColumn;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;

public class MsIndex extends AbstractIndex {

    public MsIndex(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        return getCreationSQL(false);
    }

    private String getCreationSQL(boolean dropExisting) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ");
        if (isUnique()) {
            sbSQL.append("UNIQUE ");
        }
        appendClustered(sbSQL);
        sbSQL.append(getDefinition(false, dropExisting));
        if (getTablespace() != null) {
            sbSQL.append("\nON ").append(getTablespace());
        }
        sbSQL.append(GO);

        return sbSQL.toString();
    }

    public String getDefinition(boolean isTypeIndex, boolean dropExisting) {
        var sb = new StringBuilder();
        sb.append("INDEX ");

        if (!isTypeIndex) {
            appendFullName(sb);
            sb.append(" (");
            appendSimpleColumns(sb, columns);
            sb.append(')');
        } else {
            sb.append(MsDiffUtils.quoteName(getName()));
            sb.append(' ');
            appendClustered(sb);
            if (options.keySet().stream().anyMatch("BUCKET_COUNT"::equalsIgnoreCase)) {
                sb.append("HASH");
            }
            sb.append("\n(\n\t");
            appendSimpleColumns(sb, columns);
            sb.append("\n)");
        }

        if (!includes.isEmpty()) {
            sb.append(" INCLUDE ");
            StatementUtils.appendCols(sb, includes, getDbType());
        }
        appendWhere(sb);

        var tmpOptions = new LinkedHashMap<String, String>();
        tmpOptions.putAll(options);
        if (!isTypeIndex) {
            if (getDatabaseArguments().isConcurrentlyMode() && !options.containsKey("ONLINE")) {
                tmpOptions.put("ONLINE", "ON");
            }
            if (dropExisting) {
                tmpOptions.put("DROP_EXISTING", "ON");
            }
        }
        if (!tmpOptions.isEmpty()) {
            sb.append(isTypeIndex ? ' ' : '\n').append("WITH (").append(isTypeIndex ? ' ' : "");
            StatementUtils.appendOptions(sb, tmpOptions, getDbType());
            sb.append(')');
        }

        return sb.toString();
    }

    private void appendSimpleColumns(StringBuilder sbSQL, Map<String, SimpleColumn> columns) {
        for (var col : columns.values()) {
            sbSQL.append(MsDiffUtils.quoteName(col.getName()));
            if (col.isDesc()) {
                sbSQL.append(" DESC");
            }
            sbSQL.append(", ");
        }
        sbSQL.setLength(sbSQL.length() - 2);
    }

    private void appendClustered(StringBuilder sb) {
        if (!isClustered()) {
            sb.append("NON");
        }
        sb.append("CLUSTERED ");
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        if (!compare(newCondition)) {
            isNeedDepcies.set(true);

            MsIndex newIndex = (MsIndex) newCondition;
            if (!isClustered() || newIndex.isClustered()) {
                sb.append("\n\n")
                .append(newIndex.getCreationSQL(true));
            }

            return true;
        }

        // options can be changed by syntax :
        // ALTER INDEX index_name ON schema_name.table REBUILD WITH (options (, option)*)
        // but how to reset option? all indices has all option with default value
        // and we don't know what is it and how to change current value to default value.

        return false;
    }

    @Override
    protected StringBuilder appendFullName(StringBuilder sb) {
        sb.append(MsDiffUtils.quoteName(getName()))
        .append(" ON ")
        .append(getParent().getQualifiedName());
        return sb;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }

    @Override
    protected AbstractIndex getIndexCopy() {
        return new MsIndex(getName());
    }
}
