/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores view information.
 *
 * @author fordfrog
 */
public class PgView extends PgStatementWithSearchPath {

    private String query;
    private String normalizedQuery;
    private PgSelect select;
    private List<String> columnNames = new ArrayList<>();
    private final List<DefaultValue> defaultValues = new ArrayList<>();
    private final List<ColumnComment> columnComments = new ArrayList<>();
    private final List<PgRule> rules = new ArrayList<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.VIEW;
    }

    public PgView(String name, String rawStatement) {
        super(name, rawStatement);
    }

    public void addColumnName(String colName) {
        columnNames.add(colName);
        resetHash();
    }

    public void setColumnNames(final List<String> columnNames) {
        this.columnNames = columnNames;
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

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder(query.length() * 2);
        sbSQL.append("CREATE VIEW ");
        sbSQL.append(PgDiffUtils.getQuotedName(name));

        if (columnNames != null && !columnNames.isEmpty()) {
            sbSQL.append(" (");

            for (int i = 0; i < columnNames.size(); i++) {
                if (i > 0) {
                    sbSQL.append(", ");
                }

                sbSQL.append(PgDiffUtils.getQuotedName(columnNames.get(i)));
            }
            sbSQL.append(')');
        }

        sbSQL.append(" AS\n\t");
        sbSQL.append(query);
        sbSQL.append(';');

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        for (final DefaultValue defaultValue : defaultValues) {
            sbSQL.append("\n\nALTER VIEW ");
            sbSQL.append(PgDiffUtils.getQuotedName(name));
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

        for (final ColumnComment columnComment : columnComments) {
            if (columnComment.getComment() != null
                    && !columnComment.getComment().isEmpty()) {
                sbSQL.append("\n\nCOMMENT ON COLUMN ");
                sbSQL.append(PgDiffUtils.getQuotedName(name));
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
        return "DROP VIEW " + PgDiffUtils.getQuotedName(getName()) + ';';
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
        PgView oldView = this;
        if (PgView.isViewModified(oldView, newView)) {
            isNeedDepcies.set(true);
            return true;
        }
        PgView.diffDefaultValues(sb, oldView, newView);

        if (!Objects.equals(oldView.getOwner(), newView.getOwner())) {
            sb.append(newView.getOwnerSQL());
        }

        addPrivilegeScript(oldView, newView, sb);

        if (!Objects.equals(oldView.getComment(), newView.getComment())) {
            sb.append("\n\n");
            newView.appendCommentSql(sb);
        }
        final List<String> columnNames = new ArrayList<>(newView
                .getColumnComments().size());

        for (final PgView.ColumnComment columnComment : newView
                .getColumnComments()) {
            columnNames.add(columnComment.getColumnName());
        }

        for (final PgView.ColumnComment columnComment : oldView
                .getColumnComments()) {
            if (!columnNames.contains(columnComment.getColumnName())) {
                columnNames.add(columnComment.getColumnName());
            }
        }

        for (final String columnName : columnNames) {
            PgView.ColumnComment oldColumnComment = null;
            PgView.ColumnComment newColumnComment = null;

            for (final PgView.ColumnComment columnComment : oldView
                    .getColumnComments()) {
                if (columnName.equals(columnComment.getColumnName())) {
                    oldColumnComment = columnComment;
                    break;
                }
            }

            for (final PgView.ColumnComment columnComment : newView
                    .getColumnComments()) {
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

                sb.append("\n\nCOMMENT ON COLUMN "
                        + PgDiffUtils.getQuotedName(newView.getName())
                        + '.'
                        + PgDiffUtils.getQuotedName(newColumnComment
                                .getColumnName()) + " IS "
                                + newColumnComment.getComment() + ';');
            } else if (oldColumnComment != null && newColumnComment == null) {

                sb.append("\n\nCOMMENT ON COLUMN "
                        + PgDiffUtils.getQuotedName(newView.getName())
                        + '.'
                        + PgDiffUtils.getQuotedName(oldColumnComment
                                .getColumnName()) + " IS NULL;");
            }
        }
        return sb.length() > startLength;
    }

    public void setQuery(final String query) {
        this.query = query;
        this.normalizedQuery = PgDiffUtils.normalizeWhitespaceUnquoted(query);
        resetHash();
    }

    public String getQuery() {
        return query;
    }

    /**
     * @return query string with whitespace normalized.
     * @see PgDiffUtils#normalizeWhitespaceUnquoted(String)
     */
    public String getNormalizedQuery(){
        return normalizedQuery;
    }

    public void setSelect(PgSelect select) {
        this.select = select;
        select.setParent(this);
        resetHash();
    }

    public PgSelect getSelect() {
        return select;
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
    }

    public void addColumnComment(PgDiffArguments args, String columnName, String comment) {
        removeColumnComment(columnName);
        columnComments.add(new ColumnComment(columnName,
                args.isForceUnixNewlines() ? comment.replace("\r", "") : comment));
    }

    public void removeColumnComment(final String columnName) {
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
        boolean eq = false;

        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgView) {
            PgView view = (PgView) obj;
            eq = Objects.equals(name, view.getName())
                    && Objects.equals(normalizedQuery, view.getNormalizedQuery())
                    && Objects.equals(select, view.getSelect())
                    && columnNames.equals(view.columnNames)
                    && new HashSet<>(defaultValues).equals(new HashSet<>(view.defaultValues))
                    && grants.equals(view.grants)
                    && revokes.equals(view.revokes)
                    && Objects.equals(owner, view.getOwner())
                    && Objects.equals(comment, view.getComment())
                    && Objects.equals(columnComments, view.getColumnComments())
                    && new HashSet<>(rules).equals(new HashSet<>(view.rules));
        }

        return eq;
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((grants == null) ? 0 : grants.hashCode());
        result = prime * result + ((revokes == null) ? 0 : revokes.hashCode());
        result = prime * result + ((columnNames == null) ? 0 : columnNames.hashCode());
        result = prime * result + new HashSet<>(defaultValues).hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((normalizedQuery == null) ? 0 : normalizedQuery.hashCode());
        result = prime * result + ((select == null) ? 0 : select.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((columnComments == null) ? 0 : columnComments.hashCode());
        result = prime * result + new HashSet<>(rules).hashCode();
        return result;
    }

    @Override
    public PgView shallowCopy() {
        PgView viewDst = new PgView(getName(), getRawStatement());
        viewDst.setQuery(getQuery());
        viewDst.setSelect(select.shallowCopy());
        viewDst.setComment(getComment());
        viewDst.setColumnNames(new ArrayList<>(columnNames));
        for(DefaultValue defval : defaultValues) {
            viewDst.addColumnDefaultValue(defval.getColumnName(), defval.getDefaultValue());
        }
        for(ColumnComment colcomment : columnComments) {
            viewDst.addColumnComment(colcomment.getColumnName(), colcomment.getComment());
        }
        for (PgPrivilege priv : revokes) {
            viewDst.addPrivilege(priv.shallowCopy());
        }
        for (PgPrivilege priv : grants) {
            viewDst.addPrivilege(priv.shallowCopy());
        }
        viewDst.setOwner(getOwner());
        return viewDst;
    }

    @Override
    public PgView deepCopy() {
        PgView copy = shallowCopy();
        for(PgRule rule : rules) {
            copy.addRule(rule.deepCopy());
        }
        return copy;
    }

    /**
     * Contains information about default value of column.
     */
    public static class DefaultValue {

        private final String columnName;
        private final String defaultValue;

        DefaultValue(final String columnName, final String defaultValue) {
            this.columnName = columnName;
            this.defaultValue = defaultValue;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getDefaultValue() {
            return defaultValue;
        }

        @Override
        public boolean equals(Object obj) {
            boolean eq = false;

            if(this == obj) {
                eq = true;
            } else if(obj instanceof DefaultValue) {
                DefaultValue val = (DefaultValue) obj;
                eq = Objects.equals(columnName, val.getColumnName())
                        && Objects.equals(defaultValue, val.getDefaultValue());
            }

            return eq;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((columnName == null) ? 0 : columnName.hashCode());
            result = prime * result + ((defaultValue == null) ? 0 : defaultValue.hashCode());
            return result;
        }
    }

    /**
     * Contains information about column comment.
     */
    public static class ColumnComment {

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
            final int prime = 31;
            int result = 1;
            result = prime * result + ((columnName == null) ? 0 : columnName.hashCode());
            result = prime * result + ((comment == null) ? 0 : comment.hashCode());
            return result;
        }
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent();
    }

    /**
     * Returns true if either column names or query of the view has been
     * modified.
     *
     * @param oldView old view
     * @param newView new view
     *
     * @return true if view has been modified, otherwise false
     */
    public static boolean isViewModified(final PgView oldView,
            final PgView newView) {
        List<String> oldColumnNames = oldView.getColumnNames();
        List<String> newColumnNames = newView.getColumnNames();

        if(oldColumnNames.isEmpty() && newColumnNames.isEmpty()) {
            String nOldQuery = oldView.getNormalizedQuery();
            String nNewQuery = newView.getNormalizedQuery();
            return !nOldQuery.equals(nNewQuery);
        } else {
            return !oldColumnNames.equals(newColumnNames);
        }
    }

    /**
     * Diffs default values in views.
     *
     * @param writer           writer
     * @param oldView          old view
     * @param newView          new view
     * @param searchPathHelper search path helper
     */
    public static void diffDefaultValues(final StringBuilder sb,
            final PgView oldView, final PgView newView) {
        final List<DefaultValue> oldValues =
                oldView.getDefaultValues();
        final List<DefaultValue> newValues =
                newView.getDefaultValues();

        // modify defaults that are in old view
        for (final DefaultValue oldValue : oldValues) {
            boolean found = false;

            for (final DefaultValue newValue : newValues) {
                if (oldValue.getColumnName().equals(newValue.getColumnName())) {
                    found = true;

                    if (!oldValue.getDefaultValue().equals(newValue.getDefaultValue())) {
                        sb.append("\n\nALTER TABLE "
                                + PgDiffUtils.getQuotedName(newView.getName())
                                + " ALTER COLUMN "
                                + PgDiffUtils.getQuotedName(newValue.getColumnName())
                                + " SET DEFAULT "
                                + newValue.getDefaultValue()
                                + ';');
                    }

                    break;
                }
            }

            if (!found) {
                sb.append("\n\nALTER TABLE "
                        + PgDiffUtils.getQuotedName(newView.getName())
                        + " ALTER COLUMN "
                        + PgDiffUtils.getQuotedName(oldValue.getColumnName())
                        + " DROP DEFAULT;");
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

            sb.append("\n\nALTER TABLE "
                    + PgDiffUtils.getQuotedName(newView.getName())
                    + " ALTER COLUMN "
                    + PgDiffUtils.getQuotedName(newValue.getColumnName())
                    + " SET DEFAULT "
                    + newValue.getDefaultValue()
                    + ';');
        }
    }

    /**
     * Finds rule according to specified rule {@code name}.
     *
     * @param name name of the rule to be searched
     *
     * @return found rule or null if no such rule has been found
     */
    public PgRule getRule(final String name) {
        for (PgRule rule : rules) {
            if (rule.getName().equals(name)) {
                return rule;
            }
        }

        return null;
    }

    public List<PgRule> getRules() {
        return Collections.unmodifiableList(rules);
    }

    public void addRule(final PgRule rule) {
        rules.add(rule);
        rule.setParent(this);
        resetHash();
    }
}
