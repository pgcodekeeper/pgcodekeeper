/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import cz.startnet.utils.pgdiff.hashers.IHashable;
import cz.startnet.utils.pgdiff.hashers.JavaHasher;

/**
 * Stores view information.
 *
 * @author fordfrog
 */
public class PgView extends AbstractView implements PgOptionContainer  {

    public static final String CHECK_OPTION = "check_option";

    private String query;
    private String normalizedQuery;
    private String tablespace;
    private Boolean isWithData;
    private final List<DefaultValue> defaultValues = new ArrayList<>();
    private final List<ColumnComment> columnComments = new ArrayList<>();
    private final Map<String, String> options = new LinkedHashMap<>();
    private final List<String> columnNames = new ArrayList<>();

    public PgView(String name) {
        super(name);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder(getQuery().length() * 2);
        sbSQL.append("CREATE");
        if (isMatView()) {
            sbSQL.append(" MATERIALIZED");
        }
        sbSQL.append(" VIEW ");
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
                sbSQL.append(chekOption.toUpperCase());
            }
            sbSQL.append(" CHECK OPTION");
        }
        sbSQL.append(';');

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        for (final DefaultValue defaultValue : getDefaultValues()) {
            sbSQL.append("\n\nALTER VIEW ");
            sbSQL.append(getQualifiedName());
            sbSQL.append(" ALTER COLUMN ");
            sbSQL.append(
                    PgDiffUtils.getQuotedName(defaultValue.getColumnName()));
            sbSQL.append(" SET DEFAULT ");
            sbSQL.append(defaultValue.getDefaultValue());
            sbSQL.append(';');
        }

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        for (final ColumnComment columnComment : getColumnComments()) {
            if (columnComment.getComment() != null
                    && !columnComment.getComment().isEmpty()) {
                sbSQL.append("\n\nCOMMENT ON COLUMN ");
                sbSQL.append(getQualifiedName());
                sbSQL.append('.');
                sbSQL.append(PgDiffUtils.getQuotedName(columnComment.getColumnName()));
                sbSQL.append(" IS ");
                sbSQL.append(columnComment.getComment());
                sbSQL.append(';');
            }
        }

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        String mat = isMatView() ? "MATERIALIZED " : "";
        return "DROP " + mat + "VIEW " + getQualifiedName() + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgView newView;
        if (newCondition instanceof PgView) {
            newView = (PgView) newCondition;
        } else {
            return false;
        }

        // TODO add alter for materialized view
        // after merge view columns dependencies branch
        if (isViewModified(newView)
                || isWithData() != newView.isWithData()
                || getTablespace() != newView.getTablespace()) {
            isNeedDepcies.set(true);
            return true;
        }
        diffDefaultValues(sb, newView);

        if (!Objects.equals(getOwner(), newView.getOwner())) {
            newView.alterOwnerSQL(sb);
        }

        alterPrivileges(newView, sb);

        if (!Objects.equals(getComment(), newView.getComment())) {
            sb.append("\n\n");
            newView.appendCommentSql(sb);
        }
        final List<String> newColumnNames = new ArrayList<>(newView
                .getColumnComments().size());

        for (final ColumnComment columnComment : newView.getColumnComments()) {
            newColumnNames.add(columnComment.getColumnName());
        }

        for (final ColumnComment columnComment : getColumnComments()) {
            if (!newColumnNames.contains(columnComment.getColumnName())) {
                newColumnNames.add(columnComment.getColumnName());
            }
        }

        for (final String columnName : newColumnNames) {
            ColumnComment oldColumnComment = null;
            ColumnComment newColumnComment = null;

            for (final ColumnComment columnComment : getColumnComments()) {
                if (columnName.equals(columnComment.getColumnName())) {
                    oldColumnComment = columnComment;
                    break;
                }
            }

            for (final ColumnComment columnComment : newView.getColumnComments()) {
                if (columnName.equals(columnComment.getColumnName())) {
                    newColumnComment = columnComment;
                    break;
                }
            }

            if (oldColumnComment == null
                    && newColumnComment != null
                    || oldColumnComment != null
                    && newColumnComment != null
                    && !oldColumnComment.getComment().equals(
                            newColumnComment.getComment())) {

                sb.append("\n\nCOMMENT ON COLUMN " + getQualifiedName() + '.'
                        + PgDiffUtils.getQuotedName(newColumnComment
                                .getColumnName()) + " IS "
                                + newColumnComment.getComment() + ';');
            } else if (oldColumnComment != null && newColumnComment == null) {
                sb.append("\n\nCOMMENT ON COLUMN " + getQualifiedName() + '.'
                        + PgDiffUtils.getQuotedName(oldColumnComment
                                .getColumnName()) + " IS NULL;");
            }
        }

        compareOptions(newView, sb);

        return sb.length() > startLength;
    }

    /**
     * Compares default values with values in new view.
     *
     * @param sb               writer
     * @param newView          new view
     */
    private void diffDefaultValues(final StringBuilder sb, final PgView newView) {
        final List<DefaultValue> oldValues = getDefaultValues();
        final List<DefaultValue> newValues =
                newView.getDefaultValues();

        // modify defaults that are in old view
        for (final DefaultValue oldValue : oldValues) {
            boolean found = false;

            for (final DefaultValue newValue : newValues) {
                if (oldValue.getColumnName().equals(newValue.getColumnName())) {
                    found = true;
                    if (!oldValue.getDefaultValue().equals(newValue.getDefaultValue())) {
                        sb.append("\n\nALTER TABLE ").append(getQualifiedName())
                        .append(" ALTER COLUMN ").append(PgDiffUtils.getQuotedName(newValue.getColumnName()))
                        .append(" SET DEFAULT ").append(newValue.getDefaultValue()).append(';');
                    }

                    break;
                }
            }

            if (!found) {
                sb.append("\n\nALTER TABLE ").append(getQualifiedName()).append(" ALTER COLUMN ")
                .append(PgDiffUtils.getQuotedName(oldValue.getColumnName()))
                .append(" DROP DEFAULT;");
            }
        }

        // add new defaults
        for (final DefaultValue newValue : newValues) {
            boolean found = false;

            for (final DefaultValue oldValue : oldValues) {
                if (newValue.getColumnName().equals(oldValue.getColumnName())) {
                    found = true;
                    break;
                }
            }

            if (found) {
                continue;
            }

            sb.append("\n\nALTER TABLE ").append(getQualifiedName())
            .append(" ALTER COLUMN ").append(PgDiffUtils.getQuotedName(newValue.getColumnName()))
            .append(" SET DEFAULT ").append(newValue.getDefaultValue()).append(';');
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

    public void setQuery(final String query) {
        this.query = query;
        this.normalizedQuery = PgDiffUtils.normalizeWhitespaceUnquoted(query);
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

    public String getTablespace() {
        return tablespace;
    }

    public void setTablespace(final String tablespace) {
        this.tablespace = tablespace;
        resetHash();
    }

    /**
     * @return query string with whitespace normalized.
     * @see PgDiffUtils#normalizeWhitespaceUnquoted(String)
     */
    public String getNormalizedQuery(){
        return normalizedQuery;
    }

    /**
     * Adds/replaces column default value specification.
     */
    public void addColumnDefaultValue(final String columnName,
            final String defaultValue) {
        removeColumnDefaultValue(columnName);
        defaultValues.add(new DefaultValue(columnName, defaultValue));
        resetHash();
    }

    public void removeColumnDefaultValue(final String columnName) {
        for (final DefaultValue item : defaultValues) {
            if (item.getColumnName().equals(columnName)) {
                defaultValues.remove(item);
                resetHash();
                return;
            }
        }
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
    public List<DefaultValue> getDefaultValues() {
        return Collections.unmodifiableList(defaultValues);
    }

    /**
     * Adds/replaces column comment.
     */
    public void addColumnComment(String columnName, String comment) {
        removeColumnComment(columnName);
        columnComments.add(new ColumnComment(columnName, comment));
        resetHash();
    }

    public void addColumnComment(PgDiffArguments args, String columnName, String comment) {
        removeColumnComment(columnName);
        columnComments.add(new ColumnComment(columnName,
                args.isKeepNewlines() ? comment : comment.replace("\r", "")));
        resetHash();
    }

    private void removeColumnComment(final String columnName) {
        for (final ColumnComment item : columnComments) {
            if (item.getColumnName().equals(columnName)) {
                columnComments.remove(item);
                return;
            }
        }
    }


    public List<ColumnComment> getColumnComments() {
        return Collections.unmodifiableList(columnComments);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (obj instanceof PgView && super.compare(obj)) {
            PgView view = (PgView) obj;
            return Objects.equals(normalizedQuery, view.getNormalizedQuery())
                    && Objects.equals(isWithData, view.isWithData())
                    && Objects.equals(tablespace, view.getTablespace())
                    && columnNames.equals(view.columnNames)
                    && PgDiffUtils.setlikeEquals(defaultValues, view.defaultValues)
                    && columnComments.equals(view.columnComments)
                    && options.equals(view.options);
        }

        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(columnNames);
        hasher.putUnordered(defaultValues);
        hasher.put(normalizedQuery);
        hasher.putOrdered(columnComments);
        hasher.put(options);
        hasher.put(isWithData);
        hasher.put(tablespace);
    }

    @Override
    protected AbstractView getViewCopy() {
        PgView view = new PgView(getName());
        view.query = query;
        view.normalizedQuery = normalizedQuery;
        view.setIsWithData(isWithData());
        view.setTablespace(getTablespace());
        view.columnNames.addAll(columnNames);
        view.defaultValues.addAll(defaultValues);
        view.columnComments.addAll(columnComments);
        view.options.putAll(options);
        return view;
    }

    /**
     * Contains information about column comment.
     */
    public static class ColumnComment implements IHashable {

        private final String columnName;
        private final String comment;

        ColumnComment(final String columnName, final String comment) {
            this.columnName = columnName;
            this.comment = comment;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getComment() {
            return comment;
        }

        @Override
        public boolean equals(Object obj) {
            boolean eq = false;

            if (this == obj) {
                eq = true;
            } else if(obj instanceof ColumnComment) {
                ColumnComment val = (ColumnComment) obj;
                eq = Objects.equals(columnName, val.getColumnName())
                        && Objects.equals(comment, val.getComment());
            }

            return eq;
        }

        @Override
        public int hashCode() {
            JavaHasher hasher = new JavaHasher();
            computeHash(hasher);
            return hasher.getResult();
        }

        @Override
        public void computeHash(Hasher hasher) {
            hasher.put(columnName);
            hasher.put(comment);
        }
    }

    /**
     * Contains information about default value of column.
     */
    private static class DefaultValue implements IHashable {

        private final String columnName;
        private final String defaultVal;

        DefaultValue(final String columnName, final String defaultValue) {
            this.columnName = columnName;
            this.defaultVal = defaultValue;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getDefaultValue() {
            return defaultVal;
        }

        @Override
        public boolean equals(Object obj) {
            boolean eq = false;

            if(this == obj) {
                eq = true;
            } else if(obj instanceof DefaultValue) {
                DefaultValue val = (DefaultValue) obj;
                eq = Objects.equals(columnName, val.getColumnName())
                        && Objects.equals(defaultVal, val.getDefaultValue());
            }

            return eq;
        }

        @Override
        public int hashCode() {
            JavaHasher hasher = new JavaHasher();
            computeHash(hasher);
            return hasher.getResult();
        }

        @Override
        public void computeHash(Hasher hasher) {
            hasher.put(columnName);
            hasher.put(defaultVal);
        }
    }
}
