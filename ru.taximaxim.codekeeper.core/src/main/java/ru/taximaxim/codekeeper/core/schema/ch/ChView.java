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
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.schema.AbstractView;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;

public final class ChView extends AbstractView {

    public enum ChViewType {
        SIMPLE("VIEW"), MATERIALIZED("MATERIALIZED VIEW"), LIVE("LIVE VIEW");

        private String sql;

        ChViewType(String sql) {
            this.sql = sql;
        }
    }

    private ChViewType type = ChViewType.SIMPLE;
    private String destination;
    private String query;
    private String normalizedQuery;
    private String definer;
    private String sqlSecurity;
    private boolean isWithRefresh;
    private int refreshPeriod;
    private final List<ChColumn> columns = new ArrayList<>();
    private ChEngine engine;

    public ChView(String name) {
        super(name);
    }

    public void setType(ChViewType type) {
        this.type = type;
        resetHash();
    }

    public void setQuery(String query, String normalizedQuery) {
        this.query = query;
        this.normalizedQuery = normalizedQuery;
        resetHash();
    }

    public void setRefreshPeriod(int refreshPeriod) {
        this.refreshPeriod = refreshPeriod;
        resetHash();
    }

    public void setWithRefresh(boolean isWithRefresh) {
        this.isWithRefresh = isWithRefresh;
        resetHash();
    }

    public void addColumn(ChColumn column) {
        columns.add(column);
        resetHash();
    }

    public void setEngine(ChEngine engine) {
        this.engine = engine;
    }

    public void setDefiner(String definer) {
        this.definer = definer;
        resetHash();
    }

    public void setSqlSecurity(String sqlSecurity) {
        this.sqlSecurity = sqlSecurity;
        resetHash();
    }

    public void setDestination(String destination) {
        this.destination = destination;
        resetHash();
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        StringBuilder sb = new StringBuilder(query.length() * 2);
        sb.append("CREATE ").append(type.sql).append(" ");
        appendIfNotExists(sb);
        appendFullName(sb);

        if (destination != null) {
            sb.append(" TO ").append(destination);
        }

        if (isWithRefresh) {
            sb.append(" WITH REFRESH");
            if (refreshPeriod != 0) {
                sb.append(" ").append(refreshPeriod);
            }
        }

        appendColumns(sb);

        if (engine != null) {
            engine.appendCreationSQL(sb);
        }

        if (definer != null || sqlSecurity != null) {
            sb.append("\n");
            if (definer != null) {
                sb.append("DEFINER = ").append(definer).append(" ");
            }
            if (sqlSecurity != null) {
                sb.append("SQL SECURITY ").append(sqlSecurity);
            }
        }

        sb.append("\nAS ");
        sb.append(query);
        if (getComment() != null) {
            sb.append("\nCOMMENT ").append(comment);
        }

        script.addStatement(sb);
    }

    private void appendColumns(StringBuilder sb) {
        if (columns.isEmpty()) {
            return;
        }

        sb.append("\n(");
        for (var column : columns) {
            sb.append("\n\t").append(column.getFullDefinition()).append(",");
        }
        sb.setLength(sb.length() - 1);
        sb.append("\n)");
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        ChView newView = (ChView) newCondition;

        if (type != newView.type || isViewModified(newView)
                || !Objects.equals(engine, newView.engine)) {
            return ObjectState.RECREATE;
        }

        compareSqlSecurity(newView, script);
        compareSql(newView.normalizedQuery, script);
        compareComment(newView.getComment(), script);

        return getObjectState(script, startSize);
    }

    private void compareSqlSecurity(ChView newView, SQLScript script) {
        if (Objects.equals(sqlSecurity, newView.sqlSecurity)
                && Objects.equals(definer, newView.definer)) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ALTER_TABLE).append(getQualifiedName()).append("\n\t(MODIFY SQL SECURITY ");
        if (newView.sqlSecurity != null) {
            sb.append(newView.sqlSecurity);
        } else if (type == ChViewType.MATERIALIZED) {
            sb.append("DEFINER");
        } else {
            sb.append("INVOKER");
        }
        sb.append(" DEFINER = ");
        if (newView.definer != null) {
            sb.append(newView.definer);
        } else {
            sb.append("CURRENT_USER");
        }
        sb.append(")");
        script.addStatement(sb);
    }

    private void compareSql(String newNormalizedSql, SQLScript script) {
        if (!normalizedQuery.equals(newNormalizedSql)) {
            script.addStatement(ALTER_TABLE + getQualifiedName() + "\n\tMODIFY QUERY " + newNormalizedSql);
        }
    }

    private void compareComment(String newComment, SQLScript script) {
        if (Objects.equals(getComment(), newComment)) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ALTER_TABLE).append(getQualifiedName()).append("\n\tMODIFY COMMENT ");
        if (newComment == null) {
            sb.append("''");
        } else {
            sb.append(newComment);
        }
        script.addStatement(sb);
    }

    /**
     * Returns true if either column names or query of the view has been modified.
     *
     * @param newView
     *            new view
     *
     * @return true if view has been modified, otherwise false
     */
    private boolean isViewModified(final ChView newView) {
        return !columns.equals(newView.columns)
                ||(type != ChViewType.MATERIALIZED && !normalizedQuery.equals(newView.normalizedQuery));
    }

    @Override
    public DatabaseType getDbType() {
        return DatabaseType.CH;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(type);
        hasher.put(normalizedQuery);
        hasher.put(destination);
        hasher.put(isWithRefresh);
        hasher.put(refreshPeriod);
        hasher.put(definer);
        hasher.put(sqlSecurity);
        hasher.putOrdered(columns);
        hasher.put(engine);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof ChView view && super.compare(obj)) {
            return Objects.equals(type, view.type)
                    && Objects.equals(normalizedQuery, view.normalizedQuery)
                    && Objects.equals(destination, view.destination)
                    && Objects.equals(isWithRefresh, view.isWithRefresh)
                    && Objects.equals(refreshPeriod, view.refreshPeriod)
                    && Objects.equals(definer, view.definer)
                    && Objects.equals(sqlSecurity, view.sqlSecurity)
                    && Objects.equals(columns, view.columns)
                    && Objects.equals(engine, view.engine);
        }

        return false;
    }

    @Override
    protected AbstractView getViewCopy() {
        ChView view = new ChView(name);
        view.setType(type);
        view.setQuery(query, normalizedQuery);
        view.setDestination(destination);
        view.setWithRefresh(isWithRefresh);
        view.setDefiner(definer);
        view.setRefreshPeriod(refreshPeriod);
        view.setSqlSecurity(sqlSecurity);
        view.columns.addAll(columns);
        view.setEngine(engine);
        return view;
    }

    @Override
    public void appendComments(SQLScript script) {
        // no impl
    }

    @Override
    protected void appendCommentSql(SQLScript script) {
        // no impl
    }
}