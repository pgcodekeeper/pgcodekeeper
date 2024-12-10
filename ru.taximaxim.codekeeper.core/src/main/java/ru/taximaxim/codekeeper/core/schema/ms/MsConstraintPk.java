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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.IConstraintPk;
import ru.taximaxim.codekeeper.core.schema.IOptionContainer;
import ru.taximaxim.codekeeper.core.schema.ISimpleColumnContainer;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SimpleColumn;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class MsConstraintPk extends MsConstraint
implements IConstraintPk, IOptionContainer, ISimpleColumnContainer {

    private final boolean isPrimaryKey;
    private boolean isClustered;
    private String dataSpace;
    private final Set<String> columnNames = new HashSet<>();
    private final List<SimpleColumn> columns = new ArrayList<>();
    private final Map<String, String> options = new HashMap<>();

    /*
     *  this is table option. It store in MsConstraintPk because can't use without Primary Key
     */
    private Boolean trackedState;

    public MsConstraintPk(String name, boolean isPrimaryKey) {
        super(name);
        this.isPrimaryKey = isPrimaryKey;
    }

    @Override
    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public Boolean getTrackedState() {
        return trackedState;
    }

    @Override
    public boolean isClustered() {
        return isClustered;
    }

    public void setTracked(final Boolean trackedState) {
        this.trackedState = trackedState;
        resetHash();
    }

    public void setClustered(boolean isClustered) {
        this.isClustered = isClustered;
        resetHash();
    }

    public void setDataSpace(String dataSpace) {
        this.dataSpace = dataSpace;
        resetHash();
    }

    public String getDataSpace() {
        return dataSpace;
    }

    @Override
    public Set<String> getColumns() {
        return Collections.unmodifiableSet(columnNames);
    }

    @Override
    public boolean containsColumn(String name) {
        return columnNames.contains(name);
    }

    @Override
    public void addColumn(SimpleColumn column) {
        columnNames.add(column.getName());
        columns.add(column);
        resetHash();
    }

    @Override
    public void addInclude(String column) {
        throw new IllegalStateException("Unsupported operation");
    }

    @Override
    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String key, String value) {
        options.put(key, value);
        resetHash();
    }

    @Override
    public String getDefinition() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append(isPrimaryKey ? "PRIMARY KEY " : "UNIQUE ");
        if (!isClustered) {
            sbSQL.append("NON");
        }
        sbSQL.append("CLUSTERED ");
        if (options.keySet().stream().anyMatch("BUCKET_COUNT"::equalsIgnoreCase)) {
            sbSQL.append(" HASH");
        }
        appendSimpleColumns(sbSQL, columns);
        if (!options.isEmpty()) {
            sbSQL.append(" WITH");
            StatementUtils.appendOptionsWithParen(sbSQL, options, getDbType());
        }
        if (dataSpace != null) {
            sbSQL.append(" ON ").append(MsDiffUtils.quoteName(dataSpace));
        }
        return sbSQL.toString();
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        super.getCreationSQL(script);
        if (trackedState != null) {
            appendChangeTracking(trackedState, script);
        }
    }

    private void appendSimpleColumns(StringBuilder sbSQL, List<SimpleColumn> columns) {
        sbSQL.append(" (");
        for (var col : columns) {
            sbSQL.append(MsDiffUtils.quoteName(col.getName()));
            if (col.isDesc()) {
                sbSQL.append(" DESC");
            }
            sbSQL.append(", ");
        }
        sbSQL.setLength(sbSQL.length() - 2);
        sbSQL.append(')');
    }

    @Override
    protected void compareOptions(MsConstraint newConstr, SQLScript script) {
        var newPk = (MsConstraintPk) newConstr;
        if (Objects.equals(getTrackedState(), newPk.getTrackedState())) {
            return;
        }
        if (getTrackedState() != null) {
            appendChangeTracking(null, script);
        }

        if (newPk.getTrackedState() != null) {
            appendChangeTracking(newPk.getTrackedState(), script);
        }
    }

    private void appendChangeTracking(Boolean trackedState, SQLScript script) {
        StringBuilder sb = new StringBuilder();
        appendAlterTable(sb);
        if (trackedState == null) {
            sb.append(" DISABLE CHANGE_TRACKING");
        } else {
            sb.append(" ENABLE CHANGE_TRACKING WITH (TRACK_COLUMNS_UPDATED = ");
            sb.append(trackedState ? "ON" : "OFF").append(')');
        }
        script.addStatement(sb);
    }

    @Override
    protected void appendSpecialDropSQL(SQLScript script) {
        if (trackedState != null) {
            appendChangeTracking(null, script);
        }
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof MsConstraintPk con && super.compare(obj)) {
            return Objects.equals(trackedState, con.getTrackedState())
                    && compareUnalterable(con);
        }

        return false;
    }

    @Override
    protected boolean compareUnalterable(MsConstraint obj) {
        if (obj instanceof MsConstraintPk con) {
            return isPrimaryKey() == con.isPrimaryKey()
                    && isClustered() == con.isClustered()
                    && Objects.equals(dataSpace, con.dataSpace)
                    && Objects.equals(columns, con.columns)
                    && Objects.equals(options, con.options);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(isPrimaryKey);
        hasher.put(getTrackedState());
        hasher.put(isClustered);
        hasher.put(dataSpace);
        hasher.putOrdered(columns);
        hasher.put(options);
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        var con = new MsConstraintPk(name, isPrimaryKey);
        con.setTracked(trackedState);
        con.setClustered(isClustered());
        con.setDataSpace(getDataSpace());
        con.columnNames.addAll(columnNames);
        con.columns.addAll(columns);
        con.options.putAll(options);
        return con;
    }

    @Override
    public void compareOptions(IOptionContainer newContainer, SQLScript script) {
        // no imple
    }
}