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
import java.util.List;
import java.util.Map;
import java.util.Objects;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.AbstractStatistics;
import ru.taximaxim.codekeeper.core.schema.ISchema;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class MsStatistics extends AbstractStatistics {

    private String filter;
    private final List<String> cols = new ArrayList<>();
    private final Map<String, String> options = new HashMap<>();

    public MsStatistics(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        var sb = new StringBuilder("CREATE STATISTICS ");
        sb.append(MsDiffUtils.quoteName(getName())).append(" ON ").append(getParent().getQualifiedName());
        if (!cols.isEmpty()) {
            sb.append(' ');
            StatementUtils.appendCols(sb, getCols(), getDbType());
        }
        if (filter != null) {
            sb.append("\nWHERE ").append(filter);
        }
        appendOptions(sb, options);
        script.addStatement(sb);
    }

    private void appendOptions(StringBuilder sb, Map<String, String> options) {
        if (options.isEmpty()) {
            return;
        }
        sb.append("\nWITH");
        var sapmlePercent = options.get("SAMPLE");
        if (sapmlePercent != null) {
            sb.append(" SAMPLE ").append(sapmlePercent).append(", PERSIST_SAMPLE_PERCENT = ON,");
        }
        appendOption(sb, "NORECOMPUTE", " NORECOMPUTE,");
        appendOption(sb, "AUTO_DROP", " AUTO_DROP = ON,");
        appendOption(sb, "INCREMENTAL", " INCREMENTAL = ON,");
        sb.setLength(sb.length() - 1);
    }

    private void appendOption(StringBuilder sb, String condition, String value) {
        if (null == options.get(condition)) {
            return;
        }
        sb.append(value);
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        var newStat = (MsStatistics) newCondition;
        if (!compareUnalterable(newStat)) {
            return ObjectState.RECREATE;
        }
        if (!Objects.equals(newStat.getOptions(), options)) {
            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE STATISTICS ")
            .append(getParent().getQualifiedName()).append(" (").append(getName()).append(")");
            appendOptions(sql, newStat.getOptions());
            script.addStatement(sql);
        }

        return getObjectState(script, startSize);
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(filter);
        hasher.put(cols);
        hasher.put(options);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof MsStatistics stat) {
            return super.compare(stat)
                    && compareUnalterable(stat)
                    && Objects.equals(options, stat.options);
        }
        return false;
    }

    private boolean compareUnalterable (MsStatistics stat) {
        return Objects.equals(filter, stat.filter)
                && Objects.equals(cols, stat.cols);
    }

    @Override
    protected AbstractStatistics getStatisticsCopy() {
        var stat = new MsStatistics(name);
        stat.setFilter(filter);
        stat.cols.addAll(cols);
        stat.options.putAll(options);
        return stat;
    }

    @Override
    public boolean isSubElement() {
        return true;
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.MS;
    }

    @Override
    public ISchema getContainingSchema() {
        return (AbstractSchema) getParent().getParent();
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
        resetHash();
    }

    public List<String> getCols() {
        return Collections.unmodifiableList(cols);
    }

    public void addCol(String col) {
        cols.add(col);
        resetHash();
    }

    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    public void putOption(String key, String value) {
        options.put(key, value);
        resetHash();
    }
}