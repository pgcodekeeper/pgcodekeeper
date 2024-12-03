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
package ru.taximaxim.codekeeper.core.schema.ms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractIndex;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SimpleColumn;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;
import ru.taximaxim.codekeeper.core.script.SQLAction;

public class MsIndex extends AbstractIndex {
    private boolean isColumnstore;
    private List<String> orderCols = new ArrayList<>();

    public MsIndex(String name) {
        super(name);
    }

    public boolean isColumnstore() {
        return isColumnstore;
    }

    public void setColumnstore(boolean isColumnstore) {
        this.isColumnstore = isColumnstore;
        resetHash();
    }

    public List<String> getOrderCols() {
        return Collections.unmodifiableList(orderCols);
    }

    public void addOrderCol(String orderCol) {
        this.orderCols.add(orderCol);
        resetHash();
    }

    @Override
    public void getCreationSQL(Collection<SQLAction> createActions) {
        getCreationSQL(createActions, false);
    }

    private void getCreationSQL(Collection<SQLAction> createActions, boolean dropExisting) {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE ");
        if (isUnique()) {
            sbSQL.append("UNIQUE ");
        }
        appendClustered(sbSQL);

        if (isColumnstore()) {
            sbSQL.append("COLUMNSTORE ");
        }
        sbSQL.append(getDefinition(false, dropExisting));
        if (getTablespace() != null) {
            sbSQL.append("\nON ").append(getTablespace());
        }
        createActions.add(new SQLAction(sbSQL));
    }

    public String getDefinition(boolean isTypeIndex, boolean dropExisting) {
        var sb = new StringBuilder();
        sb.append("INDEX ");

        if (!isTypeIndex) {
            appendFullName(sb);
            if (!columns.isEmpty()) {
                sb.append(" (");
                appendSimpleColumns(sb, columns);
                sb.append(')');
            }
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
            sb.append(isColumnstore() ? " " : " INCLUDE ");
            StatementUtils.appendCols(sb, includes, getDbType());
        }
        if (!orderCols.isEmpty()) {
            sb.append("\nORDER ");
            StatementUtils.appendCols(sb, orderCols, getDbType());
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

    private void appendSimpleColumns(StringBuilder sbSQL, List<SimpleColumn> columns) {
        for (var col : columns) {
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
    public ObjectState appendAlterSQL(PgStatement newCondition,
            AtomicBoolean isNeedDepcies, Collection<SQLAction> alterActions) {
        if (!compare(newCondition)) {
            isNeedDepcies.set(true);

            MsIndex newIndex = (MsIndex) newCondition;
            if (!isClustered() || newIndex.isClustered()) {
                newIndex.getCreationSQL(alterActions, true);
                return ObjectState.ALTER;
            }

            return ObjectState.RECREATE;
        }

        // options can be changed by syntax :
        // ALTER INDEX index_name ON schema_name.table REBUILD WITH (options (, option)*)
        // but how to reset option? all indices has all option with default value
        // and we don't know what is it and how to change current value to default value.

        return ObjectState.NOTHING;
    }

    @Override
    protected StringBuilder appendFullName(StringBuilder sb) {
        sb.append(MsDiffUtils.quoteName(getName()))
        .append(" ON ")
        .append(getParent().getQualifiedName());
        return sb;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof MsIndex ind && super.compare(obj)) {
            return isColumnstore == ind.isColumnstore
                    && Objects.equals(orderCols, ind.getOrderCols());
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isColumnstore);
        hasher.put(orderCols);
    }

    @Override
    protected AbstractIndex getIndexCopy() {
        MsIndex ind = new MsIndex(getName());
        ind.setColumnstore(isColumnstore);
        ind.orderCols.addAll(orderCols);
        return ind;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }
}
