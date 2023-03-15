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
 **
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.schema;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.hashers.Hasher;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrUtils;
import ru.taximaxim.codekeeper.core.utils.Pair;

/**
 * Stores view information.
 *
 * @author fordfrog
 */
public class PgView extends AbstractView implements PgSimpleOptionContainer  {

    public static final String COLUMN_COMMENT = "\n\nCOMMENT ON COLUMN {0}.{1} IS {2};";
    public static final String CHECK_OPTION = "check_option";

    private String query;
    private String normalizedQuery;
    private String method = Consts.HEAP;
    private String tablespace;
    private Boolean isWithData;
    private final Map<String, String> defaultValues = new LinkedHashMap<>();
    private final Map<String, String> columnComments = new LinkedHashMap<>();
    private final Map<String, String> options = new LinkedHashMap<>();
    private final List<String> columnNames = new ArrayList<>();

    public PgView(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder(getQuery().length() * 2);
        appendDropBeforeCreate(sbSQL);
        sbSQL.append("CREATE ");
        sbSQL.append(getTypeName()).append(' ');
        if (isMatView()) {
            appendIfNotExists(sbSQL);
        }

        sbSQL.append(getQualifiedName());

        if (!columnNames.isEmpty()) {
            sbSQL.append(" (");

            for (int i = 0; i < columnNames.size(); i++) {
                if (i > 0) {
                    sbSQL.append(", ");
                }

                sbSQL.append(PgDiffUtils.getQuotedName(columnNames.get(i)));
            }
            sbSQL.append(')');
        }

        if (!Consts.HEAP.equals(method)) {
            sbSQL.append("\nUSING ").append(PgDiffUtils.getQuotedName(method));
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : options.entrySet()){
            if (!CHECK_OPTION.equals(entry.getKey())){
                sb.append(entry.getKey());
                if (!entry.getValue().isEmpty()){
                    sb.append("=").append(entry.getValue());
                }
                sb.append(", ");
            }
        }

        if (sb.length() > 0){
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nWITH (").append(sb).append(")");
        }

        if (getTablespace() != null) {
            sbSQL.append("\nTABLESPACE ").append(getTablespace());
        }

        sbSQL.append(" AS\n\t");
        sbSQL.append(getQuery());
        if (isMatView()){
            sbSQL.append("\nWITH ");
            if (!isWithData()){
                sbSQL.append("NO ");
            }
            sbSQL.append("DATA");
        } else if (options.containsKey(CHECK_OPTION)){
            String chekOption = options.get(CHECK_OPTION);
            sbSQL.append("\nWITH ");
            if (chekOption != null){
                sbSQL.append(chekOption.toUpperCase(Locale.ROOT));
            }
            sbSQL.append(" CHECK OPTION");
        }
        sbSQL.append(';');

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        for (final Entry<String, String> defaultValue : getDefaultValues().entrySet()) {
            sbSQL.append("\n\nALTER VIEW ");
            sbSQL.append(getQualifiedName());
            sbSQL.append(" ALTER COLUMN ");
            sbSQL.append(
                    PgDiffUtils.getQuotedName(defaultValue.getKey()));
            sbSQL.append(" SET DEFAULT ");
            sbSQL.append(defaultValue.getValue());
            sbSQL.append(';');
        }

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        for (final Entry<String, String> columnComment : columnComments.entrySet()) {
            sbSQL.append(MessageFormat.format(COLUMN_COMMENT, getQualifiedName(),
                    PgDiffUtils.getQuotedName(columnComment.getKey()), columnComment.getValue()));
        }

        return sbSQL.toString();
    }

    @Override
    protected String getTypeName() {
        return isMatView() ? "MATERIALIZED VIEW" : "VIEW";
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgView newView = (PgView) newCondition;

        if (isViewModified(newView) || isMatView() != newView.isMatView()
                || !Objects.equals(getMethod(), newView.getMethod())) {
            isNeedDepcies.set(true);
            return true;
        }

        if (!Objects.equals(getTablespace(), newView.getTablespace())) {
            sb.append("\n\nALTER TABLE ").append(newView.getQualifiedName())
            .append("\n\tSET TABLESPACE ");

            String newSpace = newView.getTablespace();
            sb.append(newSpace == null ? Consts.PG_DEFAULT : newSpace).append(';');
        }

        if (!Objects.equals(isWithData(), newView.isWithData())) {
            sb.append("\n\nREFRESH MATERIALIZED VIEW ").append(newView.getQualifiedName());
            if (newView.isWithData() == Boolean.FALSE) {
                sb.append(" WITH NO DATA");
            }

            sb.append(';');
        }

        alterDefaultValues(sb, newView);

        if (!Objects.equals(getOwner(), newView.getOwner())) {
            newView.alterOwnerSQL(sb);
        }

        alterPrivileges(newView, sb);

        if (!Objects.equals(getComment(), newView.getComment())) {
            sb.append("\n\n");
            newView.appendCommentSql(sb);
        }

        alterColumnComments(sb, newView);

        compareOptions(newView, sb);

        return sb.length() > startLength;
    }

    private void alterColumnComments(final StringBuilder sb, final PgView newView) {
        for (final Entry<String, String> columnComment : newView.columnComments.entrySet()) {
            String newColumn = columnComment.getKey();
            String newValue = columnComment.getValue();

            String oldValue = columnComments.get(newColumn);
            if (!Objects.equals(oldValue, newValue)) {
                sb.append(MessageFormat.format(COLUMN_COMMENT, getQualifiedName(),
                        PgDiffUtils.getQuotedName(newColumn), newValue));
            }
        }

        for (final Entry<String, String> columnComment : columnComments.entrySet()) {
            String oldColumn = columnComment.getKey();

            if (!newView.columnComments.containsKey(oldColumn)) {
                sb.append(MessageFormat.format(COLUMN_COMMENT, getQualifiedName(),
                        PgDiffUtils.getQuotedName(oldColumn), "NULL"));
            }
        }
    }

    /**
     * Compares default values with values in new view.
     *
     * @param sb               writer
     * @param newView          new view
     */
    private void alterDefaultValues(final StringBuilder sb, final PgView newView) {
        for (final Entry<String, String> columnComment : newView.defaultValues.entrySet()) {
            String newColumn = columnComment.getKey();
            String newValue = columnComment.getValue();

            String oldValue = defaultValues.get(newColumn);
            if (!Objects.equals(oldValue, newValue)) {
                sb.append("\n\nALTER TABLE ").append(getQualifiedName())
                .append(" ALTER COLUMN ").append(PgDiffUtils.getQuotedName(newColumn))
                .append(" SET DEFAULT ").append(newValue).append(';');
            }
        }

        for (final Entry<String, String> columnComment : defaultValues.entrySet()) {
            String oldColumn = columnComment.getKey();

            if (!newView.defaultValues.containsKey(oldColumn)) {
                sb.append("\n\nALTER TABLE ").append(getQualifiedName()).append(" ALTER COLUMN ")
                .append(PgDiffUtils.getQuotedName(oldColumn))
                .append(" DROP DEFAULT;");
            }
        }
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
        } else {
            return !oldColumnNames.equals(newColumnNames);
        }
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

    /**
     * @return query string with whitespace normalized.
     * @see AntlrUtils#normalizeWhitespaceUnquoted
     */
    public String getNormalizedQuery(){
        return normalizedQuery;
    }

    /**
     * Adds/replaces column default value specification.
     */
    public void addColumnDefaultValue(final String columnName,
            final String defaultValue) {
        defaultValues.put(columnName, defaultValue);
        resetHash();
    }

    public void removeColumnDefaultValue(final String columnName) {
        defaultValues.remove(columnName);
        resetHash();
    }

    @Override
    public Map <String, String> getOptions() {
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
        if (obj instanceof PgView && super.compare(obj)) {
            PgView view = (PgView) obj;
            return Objects.equals(normalizedQuery, view.getNormalizedQuery())
                    && Objects.equals(isWithData, view.isWithData())
                    && Objects.equals(method, view.getMethod())
                    && Objects.equals(tablespace, view.getTablespace())
                    && columnNames.equals(view.columnNames)
                    && defaultValues.equals(view.defaultValues)
                    && columnComments.equals(view.columnComments)
                    && options.equals(view.options);
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
        return view;
    }
}
