package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import cz.startnet.utils.pgdiff.hashers.IHashable;
import cz.startnet.utils.pgdiff.hashers.JavaHasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public abstract class AbstractView extends PgStatementWithSearchPath
implements PgRuleContainer, PgTriggerContainer, PgOptionContainer, IRelation {

    public static final String CHECK_OPTION = "check_option";

    private String query;
    private String normalizedQuery;
    protected final Map<String, String> options = new LinkedHashMap<>();
    protected final List<String> columnNames = new ArrayList<>();
    private final List<DefaultValue> defaultValues = new ArrayList<>();
    private final List<ColumnComment> columnComments = new ArrayList<>();
    private final List<PgRule> rules = new ArrayList<>();
    private final List<AbstractTrigger> triggers = new ArrayList<>();
    private Boolean isWithData;
    private String tablespace;
    private final List<Pair<String, String>> relationColumns = new ArrayList<>();

    private boolean ansiNulls;
    private boolean quotedIdentified;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.VIEW;
    }

    public AbstractView(String name, String rawStatement) {
        super(name, rawStatement);
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
    public AbstractTrigger getTrigger(final String name) {
        for (AbstractTrigger trigger : triggers) {
            if (trigger.getName().equals(name)) {
                return trigger;
            }
        }

        return null;
    }

    @Override
    public List<AbstractTrigger> getTriggers() {
        return Collections.unmodifiableList(triggers);
    }

    @Override
    public void addTrigger(final AbstractTrigger trigger) {
        assertUnique(this::getTrigger, trigger);
        triggers.add(trigger);
        trigger.setParent(this);
        resetHash();
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

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        return relationColumns.stream();
    }

    public void addRelationColumns(List<Pair<String, String>> relationColumns) {
        this.relationColumns.addAll(relationColumns);
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

    public void setAnsiNulls(boolean ansiNulls) {
        this.ansiNulls = ansiNulls;
        resetHash();
    }

    public boolean isAnsiNulls() {
        return ansiNulls;
    }

    public void setQuotedIdentified(boolean quotedIdentified) {
        this.quotedIdentified = quotedIdentified;
        resetHash();
    }

    public boolean isQuotedIdentified() {
        return quotedIdentified;
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
        } else if(obj instanceof AbstractView) {
            AbstractView view = (AbstractView) obj;
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
                    && Objects.equals(tablespace, view.getTablespace())
                    && quotedIdentified == view.isQuotedIdentified()
                    && ansiNulls == view.isAnsiNulls();
        }

        return eq;
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if(obj instanceof AbstractView) {
            AbstractView view = (AbstractView) obj;
            return PgDiffUtils.setlikeEquals(rules, view.rules)
                    && PgDiffUtils.setlikeEquals(triggers, view.triggers);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.putOrdered(grants);
        hasher.putOrdered(revokes);
        hasher.put(columnNames);
        hasher.putUnordered(defaultValues);
        hasher.put(name);
        hasher.put(normalizedQuery);
        hasher.put(owner);
        hasher.put(comment);
        hasher.putOrdered(columnComments);
        hasher.put(options);
        hasher.put(isWithData);
        hasher.put(tablespace);
        hasher.put(quotedIdentified);
        hasher.put(ansiNulls);
    }

    @Override
    protected void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(rules);
        hasher.putUnordered(triggers);
    }

    @Override
    public AbstractView shallowCopy() {
        AbstractView viewDst = getViewCopy();
        viewDst.query = query;
        viewDst.normalizedQuery = normalizedQuery;
        viewDst.setComment(getComment());
        viewDst.setIsWithData(isWithData());
        viewDst.setTablespace(getTablespace());
        viewDst.setAnsiNulls(isAnsiNulls());
        viewDst.setQuotedIdentified(isQuotedIdentified());
        viewDst.columnNames.addAll(columnNames);
        viewDst.defaultValues.addAll(defaultValues);
        viewDst.columnComments.addAll(columnComments);
        viewDst.relationColumns.addAll(relationColumns);

        for (PgPrivilege priv : revokes) {
            viewDst.addPrivilege(priv);
        }

        for (PgPrivilege priv : grants) {
            viewDst.addPrivilege(priv);
        }

        viewDst.setOwner(getOwner());
        viewDst.deps.addAll(deps);
        viewDst.options.putAll(options);
        viewDst.setLocation(getLocation());
        return viewDst;
    }

    protected abstract AbstractView getViewCopy();

    @Override
    public AbstractView deepCopy() {
        AbstractView copy = shallowCopy();

        for (PgRule rule : rules) {
            copy.addRule(rule.deepCopy());
        }

        for (AbstractTrigger trigger : triggers) {
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
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema)this.getParent();
    }

    /**
     * Returns true if either column names or query of the view has been
     * modified.
     *
     * @param newView new view
     *
     * @return true if view has been modified, otherwise false
     */
    protected boolean isViewModified(final AbstractView newView) {
        List<String> oldColumnNames = getColumnNames();
        List<String> newColumnNames = newView.getColumnNames();

        if (oldColumnNames.isEmpty() && newColumnNames.isEmpty()) {
            return !getNormalizedQuery().equals(newView.getNormalizedQuery());
        } else {
            return !oldColumnNames.equals(newColumnNames);
        }
    }
}
