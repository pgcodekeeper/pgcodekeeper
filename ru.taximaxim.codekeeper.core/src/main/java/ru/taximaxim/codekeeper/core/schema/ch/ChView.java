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
package ru.taximaxim.codekeeper.core.schema.ch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.schema.AbstractView;
import ru.taximaxim.codekeeper.core.schema.PgStatement;

public class ChView extends AbstractView {

    public enum ChViewType {
        SIMPLE("VIEW"), MATERIALIZED("MATERIALIZED VIEW"), LIVE("LIVE VIEW");

        private String sql;

        ChViewType(String sql) {
            this.sql = sql;
        }

        public String getSql() {
            return sql;
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

    public ChViewType getViewType() {
        return type;
    }

    public void setQuery(String query, String normalizedQuery) {
        this.query = query;
        this.normalizedQuery = normalizedQuery;
        resetHash();
    }

    public String getQuery() {
        return query;
    }

    /**
     * @return query string with whitespace normalized.
     * @see AntlrUtils#normalizeWhitespaceUnquoted
     */
    public String getNormalizedQuery() {
        return normalizedQuery;
    }

    public void setRefreshPeriod(int refreshPeriod) {
        this.refreshPeriod = refreshPeriod;
        resetHash();
    }

    public void setWithRefresh(boolean isWithRefresh) {
        this.isWithRefresh = isWithRefresh;
        resetHash();
    }

    public int getRefreshPeriod() {
        return refreshPeriod;
    }

    public boolean isWithRefresh() {
        return isWithRefresh;
    }

    public void addColumn(ChColumn column) {
        columns.add(column);
        resetHash();
    }

    public void setEngine(ChEngine engine) {
        this.engine = engine;
    }

    public ChEngine getEngine() {
        return engine;
    }

    /**
     * Getter for {@link #columns}. The list cannot be modified.
     *
     * @return {@link #columns}
     */
    public List<ChColumn> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    public void setDefiner(String definer) {
        this.definer = definer;
        resetHash();
    }

    public String getDefiner() {
        return definer;
    }

    public void setSqlSecurity(String sqlSecurity) {
        this.sqlSecurity = sqlSecurity;
        resetHash();
    }

    public String getSqlSecurity() {
        return sqlSecurity;
    }

    public void setDestination(String destination) {
        this.destination = destination;
        resetHash();
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String getCreationSQL() {
        StringBuilder sb = new StringBuilder(getQuery().length() * 2);
        sb.append("CREATE ").append(type.getSql()).append(" ");
        appendIfNotExists(sb);
        appendFullName(sb);

        if (getDestination() != null) {
            sb.append(" TO ").append(getDestination());
        }

        if (isWithRefresh()) {
            sb.append(" WITH REFRESH");
            if (getRefreshPeriod() != 0) {
                sb.append(" ").append(getRefreshPeriod());
            }
        }

        appendColumns(sb);

        if (getEngine() != null) {
            engine.appendCreationSQL(sb);
        }

        if (getDefiner() != null || getSqlSecurity() != null) {
            sb.append("\n");
            if (getDefiner() != null) {
                sb.append("DEFINER = ").append(getDefiner()).append(" ");
            }
            if (getSqlSecurity() != null) {
                sb.append("SQL SECURITY ").append(getSqlSecurity());
            }
        }

        sb.append("\nAS ");
        sb.append(getQuery());
        if (getComment() != null) {
            sb.append("\nCOMMENT ").append(getComment());
        }
        sb.append(";");
        return sb.toString();
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
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb, AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        ChView newView = (ChView) newCondition;

        if (getViewType() != newView.getViewType() || isViewModified(newView)
                || !Objects.equals(engine, newView.getEngine())) {
            isNeedDepcies.set(true);
            return true;
        }

        compareSqlSecurity(sb, newView);
        compareSql(sb, newView.getNormalizedQuery());
        compareComment(sb, newView.getComment());

        return sb.length() > startLength;
    }

    private void compareSqlSecurity(StringBuilder sb, ChView newView) {
        if (Objects.equals(getSqlSecurity(), newView.getSqlSecurity())
                && Objects.equals(getDefiner(), newView.getDefiner())) {
            return;
        }

        sb.append("ALTER TABLE ").append(getQualifiedName()).append("\n\t(MODIFY SQL SECURITY ");
        if (newView.getSqlSecurity() != null) {
            sb.append(newView.getSqlSecurity());
        } else if (getViewType() == ChViewType.MATERIALIZED) {
            sb.append("DEFINER");
        } else {
            sb.append("INVOKER");
        }
        sb.append(" DEFINER = ");
        if (newView.getDefiner() != null) {
            sb.append(newView.getDefiner());
        } else {
            sb.append("CURRENT_USER");
        }
        sb.append(");");
    }

    private void compareSql(StringBuilder sb, String newNormalizedSql) {
        if (normalizedQuery.equals(newNormalizedSql)) {
            return;
        }
        sb.append("\n\nALTER TABLE ").append(getQualifiedName()).append("\n\tMODIFY QUERY ").append(newNormalizedSql)
        .append(getSeparator());
    }

    private void compareComment(StringBuilder sb, String newComment) {
        if (Objects.equals(getComment(), newComment)) {
            return;
        }
        sb.append("\n\nALTER TABLE ").append(getQualifiedName()).append("\n\tMODIFY COMMENT ");
        if (newComment == null) {
            sb.append("''");
        } else {
            sb.append(newComment);
        }
        sb.append(getSeparator());
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
                ||(getViewType() != ChViewType.MATERIALIZED && !getNormalizedQuery().equals(newView.getNormalizedQuery()));
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
                    && Objects.equals(normalizedQuery, view.getNormalizedQuery())
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
        view.setType(getViewType());
        view.setQuery(getQuery(), getNormalizedQuery());
        view.setDestination(getDestination());
        view.setWithRefresh(isWithRefresh());
        view.setDefiner(getDefiner());
        view.setRefreshPeriod(getRefreshPeriod());
        view.setSqlSecurity(getSqlSecurity());
        view.columns.addAll(columns);
        view.setEngine(getEngine());
        return view;
    }

    @Override
    public void appendComments(StringBuilder sb) {
        // no impl
    }

    @Override
    protected void appendCommentSql(StringBuilder sb) {
        // no impl
    }
}