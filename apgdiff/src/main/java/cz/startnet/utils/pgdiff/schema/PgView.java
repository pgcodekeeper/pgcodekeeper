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
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores view information.
 *
 * @author fordfrog
 */
public class PgView extends PgStatementWithSearchPath
implements PgRuleContainer, PgTriggerContainer, PgOptionContainer {

    private static final String CHECK_OPTION = "check_option";
    private String query;
    private String normalizedQuery;
    private final Map<String, String> options = new LinkedHashMap<>();
    private List<String> columnNames = new ArrayList<>();
    private final List<DefaultValue> defaultValues = new ArrayList<>();
    private final List<ColumnComment> columnComments = new ArrayList<>();
    private final List<PgRule> rules = new ArrayList<>();
    private final List<PgTrigger> triggers = new ArrayList<>();


    @Override
    public DbObjType getStatementType() {
        return DbObjType.VIEW;
    }

    /**
     * Finds rule according to specified rule {@code name}.
     *
     * @param name name of the rule to be searched
     *
     * @return found rule or null if no such rule has been found
     */
    @Override
    public PgRule getRule(final String name) {
        for (PgRule rule : rules) {
            if (rule.getName().equals(name)) {
                return rule;
            }
        }

        return null;
    }

    @Override
    public List<PgRule> getRules() {
        return Collections.unmodifiableList(rules);
    }

    @Override
    public void addRule(final PgRule rule) {
        rules.add(rule);
        rule.setParent(this);
        resetHash();
    }

    /**
     * Finds trigger according to specified rule {@code name}.
     *
     * @param name name of the trigger to be searched
     *
     * @return found trigger or null if no such trigger has been found
     */
    @Override
    public PgTrigger getTrigger(final String name) {
        for (PgTrigger trigger : triggers) {
            if (trigger.getName().equals(name)) {
                return trigger;
            }
        }

        return null;
    }

    @Override
    public List<PgTrigger> getTriggers() {
        return Collections.unmodifiableList(triggers);
    }

    @Override
    public void addTrigger(final PgTrigger trigger) {
        triggers.add(trigger);
        trigger.setParent(this);
        resetHash();
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

        for (Map.Entry<String, String> entry : options.entrySet()){
            if (!CHECK_OPTION.equals(entry.getKey())){
                sbSQL.append(" WITH (")
                .append(entry.getKey());
                if (!entry.getValue().isEmpty()){
                    sbSQL.append(" = ").append(entry.getValue());
                }
                sbSQL.append(")");
            }
        }

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
        if (options.containsKey(CHECK_OPTION)){
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

        alterPrivileges(newView, sb);

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

        PgTable.compareOptions(oldView.getOptions(), newView.getOptions(), sb, getName(), DbObjType.VIEW);

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
                    && columnNames.equals(view.columnNames)
                    && PgDiffUtils.setlikeEquals(defaultValues, view.defaultValues)
                    && defaultValues.equals(view.defaultValues)
                    && grants.equals(view.grants)
                    && revokes.equals(view.revokes)
                    && Objects.equals(owner, view.getOwner())
                    && Objects.equals(comment, view.getComment())
                    && Objects.equals(columnComments, view.getColumnComments())
                    && Objects.equals(options, view.getOptions());
        }

        return eq;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;

        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgView) {
            PgView view = (PgView) obj;

            eq = super.equals(obj)

                    && PgDiffUtils.setlikeEquals(rules, view.rules)
                    && PgDiffUtils.setlikeEquals(triggers, view.triggers);
        }

        return eq;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int computeHash() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((grants == null) ? 0 : grants.hashCode());
        result = prime * result + ((revokes == null) ? 0 : revokes.hashCode());
        result = prime * result + ((columnNames == null) ? 0 : columnNames.hashCode());
        result = prime * result + PgDiffUtils.setlikeHashcode(defaultValues);
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((normalizedQuery == null) ? 0 : normalizedQuery.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((columnComments == null) ? 0 : columnComments.hashCode());
        result = prime * result + PgDiffUtils.setlikeHashcode(rules);
        result = prime * result + PgDiffUtils.setlikeHashcode(triggers);
        result = prime * result + ((options == null) ? 0 : options.hashCode());
        return result;
    }

    @Override
    public PgView shallowCopy() {
        PgView viewDst = new PgView(getName(), getRawStatement());
        viewDst.setQuery(getQuery());
        viewDst.setComment(getComment());
        viewDst.setColumnNames(new ArrayList<>(columnNames));
        viewDst.defaultValues.addAll(defaultValues);
        viewDst.columnComments.addAll(columnComments);
        for (PgPrivilege priv : revokes) {
            viewDst.addPrivilege(priv.deepCopy());
        }
        for (PgPrivilege priv : grants) {
            viewDst.addPrivilege(priv.deepCopy());
        }
        viewDst.setOwner(getOwner());
        viewDst.deps.addAll(deps);
        viewDst.options.putAll(options);
        return viewDst;
    }

    @Override
    public PgView deepCopy() {
        PgView copy = shallowCopy();
        for(PgRule rule : rules) {
            copy.addRule(rule.deepCopy());
        }
        for(PgTrigger trigger : triggers) {
            copy.addTrigger(trigger.deepCopy());
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

    @Override
    public Map <String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String option, String value) {
        options.put(option, value);
    }
}
