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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema.pg;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.schema.AbstractView;
import ru.taximaxim.codekeeper.core.schema.ISimpleOptionContainer;
import ru.taximaxim.codekeeper.core.schema.ObjectState;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.script.SQLScript;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * Stores view information.
 *
 * @author fordfrog
 */
public class PgView extends AbstractView implements ISimpleOptionContainer {

    private static final String COLUMN_COMMENT = "COMMENT ON COLUMN {0}.{1} IS {2}";
    public static final String CHECK_OPTION = "check_option";
    private static final String ALTER_COLUMN = " ALTER COLUMN ";

    private String query;
    private String normalizedQuery;
    private String method = Consts.HEAP;
    private String tablespace;
    private String distribution;
    private Boolean isWithData;
    private final Map<String, String> defaultValues = new LinkedHashMap<>();
    private final Map<String, String> columnComments = new LinkedHashMap<>();
    private final Map<String, String> options = new LinkedHashMap<>();
    private final List<String> columnNames = new ArrayList<>();

    public PgView(String name) {
        super(name);
    }

    @Override
    public void getCreationSQL(SQLScript script) {
        final StringBuilder sbSQL = new StringBuilder(getQuery().length() * 2);
        sbSQL.append("CREATE ");
        sbSQL.append(getTypeName()).append(' ');
        if (isMatView()) {
            appendIfNotExists(sbSQL);
        }

        sbSQL.append(getQualifiedName());
        appendColumnNames(sbSQL);

        if (!Consts.HEAP.equals(method)) {
            sbSQL.append("\nUSING ").append(PgDiffUtils.getQuotedName(method));
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : options.entrySet()) {
            if (!CHECK_OPTION.equals(entry.getKey())) {
                sb.append(entry.getKey());
                if (!entry.getValue().isEmpty()) {
                    sb.append("=").append(entry.getValue());
                }
                sb.append(", ");
            }
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nWITH (").append(sb).append(")");
        }

        if (getTablespace() != null) {
            sbSQL.append("\nTABLESPACE ").append(getTablespace());
        }

        sbSQL.append(" AS\n\t");
        sbSQL.append(getQuery());
        if (isMatView()) {
            sbSQL.append("\nWITH ");
            if (!isWithData()) {
                sbSQL.append("NO ");
            }
            sbSQL.append("DATA");

            if (distribution != null) {
                sbSQL.append("\n").append(distribution);
            }
        } else if (options.containsKey(CHECK_OPTION)) {
            String chekOption = options.get(CHECK_OPTION);
            sbSQL.append("\nWITH ");
            if (chekOption != null) {
                sbSQL.append(chekOption.toUpperCase(Locale.ROOT));
            }
            sbSQL.append(" CHECK OPTION");
        }

        script.addStatement(sbSQL);
        appendOwnerSQL(script);
        appendPrivileges(script);

        for (final Entry<String, String> defaultValue : getDefaultValues().entrySet()) {
            StringBuilder sql = new StringBuilder();
            sql.append("ALTER VIEW ");
            sql.append(getQualifiedName());
            sql.append(ALTER_COLUMN);
            sql.append(PgDiffUtils.getQuotedName(defaultValue.getKey()));
            sql.append(" SET DEFAULT ");
            sql.append(defaultValue.getValue());
            script.addStatement(sql);
        }
        appendComments(script);
    }

    @Override
    public void appendComments(SQLScript script) {
        super.appendComments(script);
        appendChildrenComments(script);
    }

    private void appendChildrenComments(SQLScript script) {
        for (final Entry<String, String> columnComment : columnComments.entrySet()) {
            StringBuilder sql = new StringBuilder();
            sql.append(MessageFormat.format(COLUMN_COMMENT, getQualifiedName(),
                    PgDiffUtils.getQuotedName(columnComment.getKey()), columnComment.getValue()));
            script.addStatement(sql.toString(), getCommentsOrder());
        }
    }

    private void appendColumnNames(final StringBuilder sbSQL) {
        if (columnNames.isEmpty()) {
            return;
        }

        sbSQL.append(" (");
        for (String columnName : columnNames) {
            sbSQL.append(PgDiffUtils.getQuotedName(columnName)).append(", ");
        }
        sbSQL.setLength(sbSQL.length() - 2);
        sbSQL.append(')');
    }

    @Override
    public String getTypeName() {
        return isMatView() ? "MATERIALIZED VIEW" : "VIEW";
    }

    @Override
    public ObjectState appendAlterSQL(PgStatement newCondition, SQLScript script) {
        int startSize = script.getSize();
        PgView newView = (PgView) newCondition;

        if (isViewModified(newView) || isMatView() != newView.isMatView()
                || !Objects.equals(getMethod(), newView.getMethod())
                || !Objects.equals(getDistribution(), newView.getDistribution())) {
            return ObjectState.RECREATE;
        }

        if (!Objects.equals(getTablespace(), newView.getTablespace())) {
            StringBuilder sql = new StringBuilder();
            sql.append(ALTER_TABLE).append(newView.getQualifiedName())
            .append("\n\tSET TABLESPACE ");

            String newSpace = newView.getTablespace();
            sql.append(newSpace == null ? Consts.PG_DEFAULT : newSpace);
            script.addStatement(sql);
        }

        if (!Objects.equals(isWithData(), newView.isWithData())) {
            StringBuilder sql = new StringBuilder();
            sql.append("REFRESH MATERIALIZED VIEW ").append(newView.getQualifiedName());
            if (newView.isWithData() == Boolean.FALSE) {
                sql.append(" WITH NO DATA");
            }
            script.addStatement(sql);
        }

        alterDefaultValues(newView, script);

        appendAlterOwner(newView, script);
        alterPrivileges(newView, script);
        compareOptions(newView, script);
        appendAlterComments(newView, script);

        return getObjectState(script, startSize);
    }

    @Override
    public void appendAlterComments(PgStatement newObj, SQLScript script) {
        PgView newView = (PgView) newObj;
        super.appendAlterComments(newView, script);
        appendAlterChildrenComments(newObj, script);
    }

    private void appendAlterChildrenComments(PgStatement newObj, SQLScript script) {
        PgView newView = (PgView) newObj;
        for (final Entry<String, String> newColumnComment : newView.columnComments.entrySet()) {
            String newColumn = newColumnComment.getKey();
            String newValue = newColumnComment.getValue();

            String oldValue = columnComments.get(newColumn);
            if (!Objects.equals(oldValue, newValue)) {
                StringBuilder sb = new StringBuilder();
                sb.append(MessageFormat.format(COLUMN_COMMENT, getQualifiedName(),
                        PgDiffUtils.getQuotedName(newColumn), newValue));
                script.addStatement(sb.toString(), getCommentsOrder());
            }
        }

        for (final Entry<String, String> columnComment : columnComments.entrySet()) {
            String oldColumn = columnComment.getKey();

            if (!newView.columnComments.containsKey(oldColumn)) {
                StringBuilder sb = new StringBuilder();
                sb.append(MessageFormat.format(COLUMN_COMMENT, getQualifiedName(),
                        PgDiffUtils.getQuotedName(oldColumn), "NULL"));
                script.addStatement(sb.toString(), getCommentsOrder());
            }
        }
    }

    @Override
    public boolean canDropBeforeCreate() {
        return true;
    }

    /**
     * Compares default values with values in new view.
     *
     * @param script  for collect sql statements
     * @param newView new view
     */
    private void alterDefaultValues(final PgView newView, SQLScript script) {
        for (final Entry<String, String> columnComment : newView.defaultValues.entrySet()) {
            String newColumn = columnComment.getKey();
            String newValue = columnComment.getValue();

            String oldValue = defaultValues.get(newColumn);
            if (!Objects.equals(oldValue, newValue)) {
                script.addStatement(addAlterTable(newColumn, " SET").append(' ').append(newValue));
            }
        }

        for (final Entry<String, String> columnComment : defaultValues.entrySet()) {
            String oldColumn = columnComment.getKey();

            if (!newView.defaultValues.containsKey(oldColumn)) {
                script.addStatement(addAlterTable(oldColumn, " DROP"));
            }
        }
    }

    private StringBuilder addAlterTable(String column, String state) {
        return new StringBuilder(ALTER_TABLE).append(getQualifiedName())
                .append(ALTER_COLUMN)
                .append(PgDiffUtils.getQuotedName(column))
                .append(state).append(" DEFAULT");
    }

    /**
     * Returns true if either column names or query of the view has been
     * modified.
     *
     * @param newView new view
     *
     * @return true if view has been modified, otherwise false
     */
    private boolean isViewModified(final PgView newView) {
        List<String> oldColumnNames = getColumnNames();
        List<String> newColumnNames = newView.getColumnNames();

        if (oldColumnNames.isEmpty() && newColumnNames.isEmpty()) {
            return !getNormalizedQuery().equals(newView.getNormalizedQuery());
        }

        return !oldColumnNames.equals(newColumnNames);
    }

    public void addColumnName(String colName) {
        columnNames.add(colName);
        resetHash();
    }

    /**
     * Getter for {@link #columnNames}. The list cannot be modified.
     *
     * @return {@link #columnNames}
     */
    public List<String> getColumnNames() {
        return Collections.unmodifiableList(columnNames);
    }

    public void setQuery(final String query, final String normalizedQuery) {
        this.query = query;
        this.normalizedQuery = normalizedQuery;
        resetHash();
    }

    public String getQuery() {
        return query;
    }

    public boolean isMatView() {
        return isWithData != null;
    }

    public Boolean isWithData() {
        return isWithData;
    }

    public void setIsWithData(final Boolean isWithData) {
        this.isWithData = isWithData;
        resetHash();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String using) {
        this.method = using;
        resetHash();
    }

    public String getTablespace() {
        return tablespace;
    }

    public void setTablespace(final String tablespace) {
        this.tablespace = tablespace;
        resetHash();
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution;
        resetHash();
    }

    /**
     * @return query string with whitespace normalized.
     * @see AntlrUtils#normalizeWhitespaceUnquoted
     */
    public String getNormalizedQuery() {
        return normalizedQuery;
    }

    /**
     * Adds/replaces column default value specification.
     */
    public void addColumnDefaultValue(final String columnName, final String defaultValue) {
        defaultValues.put(columnName, defaultValue);
        resetHash();
    }

    public void removeColumnDefaultValue(final String columnName) {
        defaultValues.remove(columnName);
        resetHash();
    }

    @Override
    public Map<String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String option, String value) {
        options.put(option, value);
        resetHash();
    }

    /**
     * Getter for {@link #defaultValues}.
     *
     * @return {@link #defaultValues}
     */
    public Map<String, String> getDefaultValues() {
        return Collections.unmodifiableMap(defaultValues);
    }

    /**
     * Adds/replaces column comment.
     */
    public void addColumnComment(String columnName, String comment) {
        if (comment == null || comment.isEmpty()) {
            return;
        }

        columnComments.put(columnName, comment);
        resetHash();
    }

    public void addColumnComment(PgDiffArguments args, String columnName, String comment) {
        if (comment == null || comment.isEmpty()) {
            return;
        }

        columnComments.put(columnName, args.isKeepNewlines() ? comment : comment.replace("\r", ""));
        resetHash();
    }

    public Map<String, String> getColumnComments() {
        return Collections.unmodifiableMap(columnComments);
    }

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        return null;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgView view && super.compare(obj)) {
            return Objects.equals(normalizedQuery, view.getNormalizedQuery())
                    && Objects.equals(isWithData, view.isWithData())
                    && Objects.equals(method, view.getMethod())
                    && Objects.equals(tablespace, view.getTablespace())
                    && columnNames.equals(view.columnNames)
                    && defaultValues.equals(view.defaultValues)
                    && columnComments.equals(view.columnComments)
                    && options.equals(view.options)
                    && Objects.equals(distribution, view.getDistribution());
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(columnNames);
        hasher.put(defaultValues);
        hasher.put(normalizedQuery);
        hasher.put(columnComments);
        hasher.put(options);
        hasher.put(isWithData);
        hasher.put(method);
        hasher.put(tablespace);
        hasher.put(distribution);
    }

    @Override
    protected AbstractView getViewCopy() {
        PgView view = new PgView(getName());
        view.query = query;
        view.normalizedQuery = normalizedQuery;
        view.setIsWithData(isWithData());
        view.setMethod(getMethod());
        view.setTablespace(getTablespace());
        view.columnNames.addAll(columnNames);
        view.defaultValues.putAll(defaultValues);
        view.columnComments.putAll(columnComments);
        view.options.putAll(options);
        view.setDistribution(getDistribution());
        return view;
    }
}