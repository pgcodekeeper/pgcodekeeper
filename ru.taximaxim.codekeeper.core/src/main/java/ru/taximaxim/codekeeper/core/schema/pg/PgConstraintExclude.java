/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
package ru.taximaxim.codekeeper.core.schema.pg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractConstraint;
import ru.taximaxim.codekeeper.core.schema.ISimpleColumnContainer;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.SimpleColumn;
import ru.taximaxim.codekeeper.core.schema.StatementUtils;

public final class PgConstraintExclude extends PgConstraint implements PgIndexParamContainer, ISimpleColumnContainer {

    private final Map<String, String> params = new HashMap<>();
    private final Set<String> columnNames = new HashSet<>();
    private final List<SimpleColumn> columns = new ArrayList<>();
    private final List<String> includes = new ArrayList<>();
    private String indexMethod;
    private String predicate;
    private String tablespace;

    public PgConstraintExclude(String name) {
        super(name);
    }

    @Override
    public void addInclude(String include) {
        includes.add(include);
        resetHash();
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
    public void addParam(String key, String value) {
        params.put(key, value);
        resetHash();
    }

    public void setIndexMethod(String indexMethod) {
        this.indexMethod = indexMethod;
        resetHash();
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
        resetHash();
    }

    @Override
    public void setTablespace(String tablespace) {
        this.tablespace = tablespace;
        resetHash();
    }

    @Override
    public String getDefinition() {
        var sbSQL = new StringBuilder();
        sbSQL.append("EXCLUDE");
        if (indexMethod != null) {
            sbSQL.append(" USING ").append(indexMethod);
        }
        appendSimpleColumns(sbSQL, columns);
        appendIndexParam(sbSQL);
        if (predicate != null) {
            sbSQL.append(" WHERE ").append(predicate);
        }
        return sbSQL.toString();
    }

    private void appendSimpleColumns(StringBuilder sbSQL, List<SimpleColumn> columns) {
        sbSQL.append(" (");
        for (var col : columns) {
            // column name already quoted
            sbSQL.append(col.getName());
            if (col.getOpClass() != null) {
                sbSQL.append(' ').append(col.getOpClass());
                var opClassParams = col.getOpClassParams();
                if (!opClassParams.isEmpty()) {
                    StatementUtils.appendOptionsWithParen(sbSQL, opClassParams, getDbType());
                }
            }
            if (col.isDesc()) {
                sbSQL.append(" DESC");
            }
            if (col.getNullsOrdering() != null) {
                sbSQL.append(col.getNullsOrdering());
            }
            if (col.getOperator() != null) {
                sbSQL.append(" WITH ").append(col.getOperator());
            }
            sbSQL.append(", ");
        }
        sbSQL.setLength(sbSQL.length() - 2);
        sbSQL.append(')');
    }

    private void appendIndexParam(StringBuilder sb) {
        if (!includes.isEmpty()) {
            sb.append(" INCLUDE ");
            StatementUtils.appendCols(sb, includes, DatabaseType.PG);
        }
        if (!params.isEmpty()) {
            sb.append(" WITH");
            StatementUtils.appendOptionsWithParen(sb, params, getDbType());
        }
        if (tablespace != null) {
            sb.append("\n\tUSING INDEX TABLESPACE ").append(tablespace);
        }
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgConstraintExclude exclude && super.compare(obj)) {
            return compareUnalterable(exclude);
        }
        return false;
    }

    @Override
    protected boolean compareUnalterable(PgConstraint newConstr) {
        var con = (PgConstraintExclude) newConstr;
        return super.compareUnalterable(con)
                && Objects.equals(params, con.params)
                && Objects.equals(includes, con.includes)
                && Objects.equals(columns, con.columns)
                && Objects.equals(indexMethod, con.indexMethod)
                && Objects.equals(predicate, con.predicate)
                && Objects.equals(tablespace, con.tablespace);
    }

    @Override
    public void computeHash(Hasher hasher) {
        super.computeHash(hasher);
        hasher.put(params);
        hasher.put(includes);
        hasher.putOrdered(columns);
        hasher.put(indexMethod);
        hasher.put(predicate);
        hasher.put(tablespace);
    }

    @Override
    protected AbstractConstraint getConstraintCopy() {
        var con = new PgConstraintExclude(name);
        con.params.putAll(params);
        con.includes.addAll(includes);
        con.columnNames.addAll(columnNames);
        con.columns.addAll(columns);
        con.setIndexMethod(indexMethod);
        con.setPredicate(predicate);
        con.setTablespace(tablespace);
        return con;
    }

    @Override
    public String getErrorCode() {
        return Consts.DUPLICATE_RELATION;
    }
}