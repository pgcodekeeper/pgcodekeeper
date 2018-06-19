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
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import cz.startnet.utils.pgdiff.hashers.IHashable;
import cz.startnet.utils.pgdiff.hashers.JavaHasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

/**
 * Stores view information.
 *
 * @author fordfrog
 */
public class PgView extends PgStatementWithSearchPath
implements PgRuleContainer, PgTriggerContainer, PgOptionContainer, IRelation {

    private static final String CHECK_OPTION = "check_option";
    private String query;
    private String normalizedQuery;
    private final Map<String, String> options = new LinkedHashMap<>();
    private List<String> columnNames = new ArrayList<>();
    private final List<DefaultValue> defaultValues = new ArrayList<>();
    private final List<ColumnComment> columnComments = new ArrayList<>();
    private final List<PgRule> rules = new ArrayList<>();
    private final List<PgTrigger> triggers = new ArrayList<>();
    private Boolean isWithData;
    private String tablespace;
    private final List<Pair<String, String>> relationColumns = new ArrayList<>();


    @Override
    public DbObjType getStatementType() {
        return DbObjType.VIEW;
    }

    @Override
    public Stream<PgStatement> getChildren() {
        return Stream.concat(getRules().stream(), getTriggers().stream());
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
        assertUnique(this::getRule, rule);
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
        assertUnique(this::getTrigger, trigger);
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
    public Stream<Pair<String, String>> getRelationColumns() {
        return relationColumns.stream();
    }

    public void addRelationColumns(List<Pair<String, String>> relationColumns) {
        this.relationColumns.addAll(relationColumns);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder(query.length() * 2);
        sbSQL.append("CREATE");
        if (isMatView()) {
            sbSQL.append(" MATERIALIZED");
        }
        sbSQL.append(" VIEW ");
        sbSQL.append(PgDiffUtils.getQuotedName(name));

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

        if (tablespace != null) {
            sbSQL.append("\nTABLESPACE ").append(tablespace);
        }

        sbSQL.append(" AS\n\t");
        sbSQL.append(query);
        if (isMatView()){
            sbSQL.append("\nWITH ");
            if (!isWithData){
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
        String mat = isMatView() ? "MATERIALIZED " : "";
        return "DROP " + mat + "VIEW " + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    protected StringBuilder appendOwnerSQL(StringBuilder sb) {
        return (!isMatView() || owner == null) ? super.appendOwnerSQL(sb)
                : sb.append("\n\nALTER MATERIALIZED VIEW ").append(PgDiffUtils.getQuotedName(getName()))
                .append(" OWNER TO ").append(PgDiffUtils.getQuotedName(owner)).append(';');
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
        // TODO add alter for materialized view
        // after merge view columns dependencies branch
        if (isViewModified(newView)
                || oldView.isWithData() != newView.isWithData()
                || oldView.getTablespace() != newView.getTablespace()) {
            isNeedDepcies.set(true);
            return true;
        }
        diffDefaultValues(sb, newView);

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

        compareOptions(newView, sb);

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
        boolean eq = false;

        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgView) {
            PgView view = (PgView) obj;
            eq = Objects.equals(name, view.name)
                    && Objects.equals(normalizedQuery, view.getNormalizedQuery())
                    && columnNames.equals(view.columnNames)
                    && PgDiffUtils.setlikeEquals(defaultValues, view.defaultValues)
                    && grants.equals(view.grants)
                    && revokes.equals(view.revokes)
                    && Objects.equals(owner, view.getOwner())
                    && Objects.equals(comment, view.getComment())
                    && Objects.equals(columnComments, view.getColumnComments())
                    && Objects.equals(options, view.getOptions())
                    && Objects.equals(isWithData, view.isWithData())
                    && Objects.equals(tablespace, view.getTablespace());
        }

        return eq;
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if(obj instanceof PgView) {
            PgView view = (PgView) obj;
            return PgDiffUtils.setlikeEquals(rules, view.rules)
                    && PgDiffUtils.setlikeEquals(triggers, view.triggers);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.putOrdered(grants);
        hasher.putOrdered(revokes);
        hasher.putOrderedStrings(columnNames);
        hasher.putUnordered(defaultValues);
        hasher.put(name);
        hasher.put(normalizedQuery);
        hasher.put(owner);
        hasher.put(comment);
        hasher.putOrdered(columnComments);
        hasher.put(options);
        hasher.put(isWithData);
        hasher.put(tablespace);
    }

    @Override
    protected void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(rules);
        hasher.putUnordered(triggers);
    }

    @Override
    public PgView shallowCopy() {
        PgView viewDst = new PgView(getName(), getRawStatement());
        viewDst.setQuery(getQuery());
        viewDst.setComment(getComment());
        viewDst.setIsWithData(isWithData());
        viewDst.setTablespace(getTablespace());
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
    public static class DefaultValue implements IHashable {

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

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent();
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
}
