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
package ru.taximaxim.codekeeper.core.schema;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import ru.taximaxim.codekeeper.core.MsDiffUtils;
import ru.taximaxim.codekeeper.core.Utils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;

public final class MsConstraintPk extends MsConstraint implements IConstraintPk {

    private final boolean isPrimaryKey;
    private boolean isClustered;
    private String dataSpace;
    private final Map<String, SimpleColumn> columns = new LinkedHashMap<>();
    private final Map<String, String> options = new HashMap<>();

    public MsConstraintPk(String name, boolean isPrimaryKey) {
        super(name);
        this.isPrimaryKey = isPrimaryKey;
    }

    @Override
    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    @Override
    public boolean isClustered() {
        return isClustered;
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
        return Collections.unmodifiableSet(columns.keySet());
    }

    public void addColumn(String key, SimpleColumn value) {
        columns.put(key, value);
        resetHash();
    }

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
        sbSQL.append("CLUSTERED  ");
        if (options.keySet().stream().anyMatch("BUCKET_COUNT"::equalsIgnoreCase)) {
            sbSQL.append("HASH ");
        }
        sbSQL.append('(');
        for (var col : columns.values()) {
            sbSQL.append(MsDiffUtils.quoteName(col.getName()));
            if (col.isDesc()) {
                sbSQL.append(" DESC");
            }
            sbSQL.append(", ");
        }
        sbSQL.setLength(sbSQL.length() - 2);
        sbSQL.append(")");

        if (!options.isEmpty()) {
            sbSQL.append(" WITH ");
            Utils.appendOptions(sbSQL, options, isPostgres());
        }

        if (dataSpace != null) {
            sbSQL.append(" ON ").append(MsDiffUtils.quoteName(dataSpace));
        }
        return sbSQL.toString();
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof MsConstraintPk && super.compare(obj)) {
            var con = (MsConstraintPk) obj;
            return compareUnalterable(con);
        }

        return false;
    }

    @Override
    protected boolean compareUnalterable(MsConstraint obj) {
        if (obj instanceof MsConstraintPk) {
            var con = (MsConstraintPk) obj;
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
        hasher.put(isClustered);
        hasher.put(dataSpace);
        hasher.putUnordered(columns);
        hasher.put(options);
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        var con = new MsConstraintPk(name, isPrimaryKey);
        con.setClustered(isClustered());
        con.setDataSpace(getDataSpace());
        con.columns.putAll(columns);
        con.options.putAll(options);
        return con;
    }
}