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
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores table information.
 *
 * @author fordfrog
 */
public class PgTable extends PgStatementWithSearchPath
implements PgRuleContainer, PgTriggerContainer, PgOptionContainer {

    private static final String OIDS = "OIDS";
    private final List<PgColumn> columns = new ArrayList<>();
    private final List<Inherits> inherits = new ArrayList<>();
    private final Map<String, String> options = new LinkedHashMap<>();
    private final List<PgConstraint> constraints = new ArrayList<>();
    private final List<PgIndex> indexes = new ArrayList<>();
    private final List<PgTrigger> triggers = new ArrayList<>();
    // Костыль позволяет отследить использование Sequence в выражениях вставки
    // DEFAULT (nextval)('sequenceName'::Type)
    private final List<PgRule> rules = new ArrayList<>();
    private boolean hasOids = false;
    private String tablespace;

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TABLE;
    }

    public PgTable(String name, String rawStatement) {
        super(name, rawStatement);
    }

    public boolean isClustered() {
        for (PgIndex ind : indexes) {
            if (ind.isClusterIndex()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds column according to specified column {@code name}.
     *
     * @param name name of the column to be searched
     *
     * @return found column or null if no such column has been found
     */
    public PgColumn getColumn(final String name) {
        for (PgColumn column : columns) {
            if (column.getName().equals(name)) {
                return column;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #columns}. The list cannot be modified.
     *
     * @return {@link #columns}
     */
    public List<PgColumn> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    /**
     * Finds constraint according to specified constraint {@code name}.
     *
     * @param name name of the constraint to be searched
     *
     * @return found constraint or null if no such constraint has been found
     */
    public PgConstraint getConstraint(final String name) {
        for (PgConstraint constraint : constraints) {
            if (constraint.getName().equals(name)) {
                return constraint;
            }
        }

        return null;
    }

    /**
     * Getter for {@link #constraints}. The list cannot be modified.
     *
     * @return {@link #constraints}
     */
    public List<PgConstraint> getConstraints() {
        return Collections.unmodifiableList(constraints);
    }

    @Override
    public String getCreationSQL() {
        final StringBuilder sbSQL = new StringBuilder();
        sbSQL.append("CREATE TABLE ");
        sbSQL.append(PgDiffUtils.getQuotedName(name));
        sbSQL.append(" (\n");

        boolean first = true;

        if (columns.isEmpty()) {
            sbSQL.append(')');
        } else {
            for (PgColumn column : columns) {
                if (first) {
                    first = false;
                } else {
                    sbSQL.append(",\n");
                }

                sbSQL.append("\t");
                sbSQL.append(column.getFullDefinition(false, null));
            }

            sbSQL.append("\n)");
        }

        if (inherits != null && !inherits.isEmpty()) {
            sbSQL.append("\nINHERITS (");

            first = true;

            for (final Inherits tableName : inherits) {
                if (first) {
                    first = false;
                } else {
                    sbSQL.append(", ");
                }

                sbSQL.append((tableName.getKey() == null ? "" : (tableName.getKey() + ".")) +
                        tableName.getValue());
            }

            sbSQL.append(")");
        }

        StringBuilder sb = new StringBuilder();

        for (Entry <String, String> entry : options.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();

            sb.append(key);
            if (!value.isEmpty()){
                sb.append("=").append(value);
            }
            sb.append(", ");
        }

        if (hasOids) {
            sb.append(OIDS).append("=").append(hasOids).append(", ");
        }

        if (sb.length() > 0){
            sb.setLength(sb.length() - 2);
            sbSQL.append("\nWITH (").append(sb).append(")");
        }

        if (tablespace != null && !tablespace.isEmpty()) {
            sbSQL.append("\nTABLESPACE ");
            sbSQL.append(tablespace);
        }

        sbSQL.append(';');

        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);

        for (PgColumn col : columns) {
            col.appendPrivileges(sbSQL);
        }

        for (PgColumn column : getColumnsWithStatistics()) {
            sbSQL.append("\nALTER TABLE ONLY ");
            sbSQL.append(PgDiffUtils.getQuotedName(name));
            sbSQL.append(" ALTER COLUMN ");
            sbSQL.append(
                    PgDiffUtils.getQuotedName(column.getName()));
            sbSQL.append(" SET STATISTICS ");
            sbSQL.append(column.getStatistics());
            sbSQL.append(';');
        }

        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        for (final PgColumn column : columns) {
            if (column.getComment() != null && !column.getComment().isEmpty()) {
                sbSQL.append("\n\n");
                column.appendCommentSql(sbSQL);
            }
        }

        return sbSQL.toString();
    }

    @Override
    public String getDropSQL() {
        return "DROP TABLE " + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        PgTable newTable;
        if (newCondition instanceof PgTable) {
            newTable = (PgTable)newCondition;
        } else {
            return false;
        }
        PgTable oldTable = this;

        List<Inherits> oldInherits = oldTable.getInherits();
        List<Inherits> newInherits = newTable.getInherits();
        for (final Inherits tableName : oldInherits) {
            if (!newInherits.contains(tableName)) {
                sb.append("\n\nALTER TABLE "
                        + PgDiffUtils.getQuotedName(newTable.getName())
                        + "\n\tNO INHERIT "
                        + (tableName.getKey() == null ?
                                "" : PgDiffUtils.getQuotedName(tableName.getKey()) + '.')
                        + PgDiffUtils.getQuotedName(tableName.getValue()) + ';');
            }
        }
        for (final Inherits tableName : newInherits) {
            if (!oldInherits.contains(tableName)) {
                sb.append("\n\nALTER TABLE "
                        + PgDiffUtils.getQuotedName(newTable.getName())
                        + "\n\tINHERIT "
                        + (tableName.getKey() == null ?
                                "" : PgDiffUtils.getQuotedName(tableName.getKey()) + '.')
                        + PgDiffUtils.getQuotedName(tableName.getValue()) + ';');
            }
        }

        PgTable.compareOptions(oldTable.getOptions(), newTable.getOptions(), sb, getName(), DbObjType.TABLE);

        if (oldTable.getHasOids() && !newTable.getHasOids()){
            sb.append("\n\nALTER TABLE ")
            .append(PgDiffUtils.getQuotedName(getName()))
            .append("\n\tSET WITHOUT OIDS;");
        } else if (newTable.getHasOids() && !oldTable.getHasOids()){
            sb.append("\n\nALTER TABLE ")
            .append(PgDiffUtils.getQuotedName(getName()))
            .append("\n\tSET WITH OIDS;");
        }

        if (!Objects.equals(oldTable.getTablespace(), newTable.getTablespace())) {
            sb.append("\n\nALTER TABLE "
                    + PgDiffUtils.getQuotedName(newTable.getName())
                    + "\n\tSET TABLESPACE " + newTable.getTablespace() + ';');
        }

        if (!Objects.equals(oldTable.getOwner(), newTable.getOwner())) {
            sb.append(newTable.getOwnerSQL());
        }

        alterPrivileges(newTable, sb);

        if (!Objects.equals(oldTable.getComment(), newTable.getComment())) {
            sb.append("\n\n");
            newTable.appendCommentSql(sb);
        }
        return sb.length() > startLength;
    }

    /**
     * Finds index according to specified index {@code name}.
     *
     * @param name name of the index to be searched
     *
     * @return found index or null if no such index has been found
     */
    public PgIndex getIndex(final String name) {
        for (PgIndex index : indexes) {
            if (index.getName().equals(name)) {
                return index;
            }
        }

        return null;
    }

    /**
     * Finds trigger according to specified trigger {@code name}.
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

    /**
     * Getter for {@link #indexes}. The list cannot be modified.
     *
     * @return {@link #indexes}
     */
    public List<PgIndex> getIndexes() {
        return Collections.unmodifiableList(indexes);
    }

    @Override
    public Map <String, String> getOptions() {
        return Collections.unmodifiableMap(options);
    }

    @Override
    public void addOption(String option, String value) {
        options.put(option, value);
    }

    public void addInherits(final String schemaName, final String tableName) {
        inherits.add(new Inherits(schemaName, tableName));
        resetHash();
    }

    public Boolean getHasOids() {
        return hasOids;
    }

    public void setHasOids(Boolean hasOids) {
        this.hasOids = hasOids;
    }

    /**
     * Getter for {@link #inherits}.
     *
     * @return {@link #inherits}
     */
    public List<Inherits> getInherits() {
        return Collections.unmodifiableList(inherits);
    }

    /**
     * Getter for {@link #triggers}. The list cannot be modified.
     *
     * @return {@link #triggers}
     */
    @Override
    public List<PgTrigger> getTriggers() {
        return Collections.unmodifiableList(triggers);
    }

    /**
     * Getter for {@link #rules}. The list cannot be modified.
     *
     * @return {@link #rules}
     */
    @Override
    public List<PgRule> getRules() {
        return Collections.unmodifiableList(rules);
    }

    public String getTablespace() {
        return tablespace;
    }

    public void setTablespace(final String tablespace) {
        this.tablespace = tablespace;
        resetHash();
    }

    public void addColumn(final PgColumn column) {
        if (column == null) {
            return;
        }
        columns.add(column);
        column.setParent(this);
        resetHash();
    }

    public void addConstraint(final PgConstraint constraint) {
        constraints.add(constraint);
        constraint.setParent(this);
        resetHash();
    }

    public void addIndex(final PgIndex index) {
        indexes.add(index);
        index.setParent(this);
        resetHash();
    }

    @Override
    public void addTrigger(final PgTrigger trigger) {
        triggers.add(trigger);
        trigger.setParent(this);
        resetHash();
    }

    @Override
    public void addRule(final PgRule rule) {
        rules.add(rule);
        rule.setParent(this);
        resetHash();
    }

    public boolean containsColumn(final String name) {
        return getColumn(name) != null;
    }

    public boolean containsConstraint(final String name) {
        return getConstraint(name) != null;
    }

    public boolean containsIndex(final String name) {
        return getIndex(name) != null;
    }

    public boolean containsTrigger(String name) {
        return getTrigger(name) != null;
    }

    public boolean containsRule(String name) {
        return getRule(name) != null;
    }

    /**
     * Returns list of columns that have statistics defined.
     */
    private List<PgColumn> getColumnsWithStatistics() {
        final List<PgColumn> list = new ArrayList<>();

        for (PgColumn column : columns) {
            if (column.getStatistics() != null) {
                list.add(column);
            }
        }

        return list;
    }

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgTable) {
            PgTable table = (PgTable) obj;

            eq = Objects.equals(name, table.getName())
                    && Objects.equals(tablespace, table.getTablespace())
                    && Objects.equals(hasOids, table.getHasOids())
                    && inherits.equals(table.inherits)
                    && columns.equals(table.columns)
                    && grants.equals(table.grants)
                    && revokes.equals(table.revokes)
                    && Objects.equals(owner, table.getOwner())
                    && Objects.equals(comment, table.getComment())
                    && Objects.equals(options, table.getOptions());
        }

        return eq;
    }

    @Override
    public boolean equals(Object obj) {
        boolean eq = false;
        if(this == obj) {
            eq = true;
        } else if(obj instanceof PgTable) {
            PgTable table = (PgTable) obj;
            eq = super.equals(obj)
                    && PgDiffUtils.setlikeEquals(constraints, table.constraints)
                    && PgDiffUtils.setlikeEquals(indexes, table.indexes)
                    && PgDiffUtils.setlikeEquals(triggers, table.triggers)
                    && PgDiffUtils.setlikeEquals(rules, table.rules);
        }
        return eq;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int computeHash() {
        final int itrue = 1231;
        final int ifalse = 1237;
        final int prime = 31;
        int result = 1;
        result = prime * result + ((grants == null) ? 0 : grants.hashCode());
        result = prime * result + ((revokes == null) ? 0 : revokes.hashCode());
        result = prime * result + ((columns == null) ? 0 : columns.hashCode());
        result = prime * result + PgDiffUtils.setlikeHashcode(constraints);
        result = prime * result + PgDiffUtils.setlikeHashcode(indexes);
        result = prime * result + ((inherits == null) ? 0 : inherits.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((tablespace == null) ? 0 : tablespace.hashCode());
        result = prime * result + PgDiffUtils.setlikeHashcode(triggers);
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + PgDiffUtils.setlikeHashcode(rules);
        result = prime * result + ((options == null) ? 0 : options.hashCode());
        result = prime * result + (hasOids ? itrue : ifalse);
        return result;
    }

    @Override
    public PgTable shallowCopy() {
        PgTable tableDst = new PgTable(getName(), getRawStatement());
        tableDst.setTablespace(getTablespace());
        tableDst.setHasOids(getHasOids());
        tableDst.options.putAll(options);
        tableDst.inherits.addAll(inherits);
        for(PgColumn colSrc : columns) {
            tableDst.addColumn(colSrc.deepCopy());
        }
        tableDst.setComment(getComment());
        for (PgPrivilege priv : revokes) {
            tableDst.addPrivilege(priv.deepCopy());
        }
        for (PgPrivilege priv : grants) {
            tableDst.addPrivilege(priv.deepCopy());
        }
        tableDst.setOwner(getOwner());
        tableDst.deps.addAll(deps);
        return tableDst;
    }

    @Override
    public PgTable deepCopy() {
        PgTable copy = shallowCopy();

        for(PgConstraint constraint : constraints) {
            copy.addConstraint(constraint.deepCopy());
        }
        for(PgIndex index : indexes) {
            copy.addIndex(index.deepCopy());
        }
        for(PgTrigger trigger : triggers) {
            copy.addTrigger(trigger.deepCopy());
        }
        for(PgRule rule : rules) {
            copy.addRule(rule.deepCopy());
        }
        return copy;
    }

    @Override
    public PgSchema getContainingSchema() {
        return (PgSchema)this.getParent();
    }

    public static void compareOptions(Map<String, String> oldOptions, Map<String, String> newOptions,
            StringBuilder sb, String name, DbObjType container){
        StringBuilder setOptions = new StringBuilder();
        StringBuilder resetOptions = new StringBuilder();
        if (!oldOptions.isEmpty() || !newOptions.isEmpty()) {
            for (Map.Entry<String, String> entry : oldOptions.entrySet()){
                String key = entry.getKey();
                if (newOptions.containsKey(key)){
                    compareValue(entry.getValue(), newOptions.get(key), setOptions, key);
                } else {
                    resetOptions.append(key)
                    .append(", ");
                }
            }

            for (Map.Entry<String, String> entry : newOptions.entrySet()){
                String key = entry.getKey();
                if (!oldOptions.containsKey(key)){
                    compareValue(null, newOptions.get(key), setOptions, key);
                }
            }
        }

        if(setOptions.length() > 0){
            setOptions.setLength(setOptions.length()-2);
            sb.append("\n\nALTER ").append(container.toString()).append(' ').append(name)
            .append(" SET (").append(setOptions).append(");");
        }

        if(resetOptions.length() > 0){
            resetOptions.setLength(resetOptions.length()-2);
            sb.append("\n\nALTER ").append(container.toString()).append(' ').append(name)
            .append(" RESET (").append(resetOptions).append(");");
        }
    }

    private static void compareValue(String oldValue, String newValue, StringBuilder setOptions, String key) {
        if (!Objects.equals(oldValue, newValue)){
            setOptions.append(key);
            if (!newValue.isEmpty()){
                setOptions.append(" = ");
                setOptions.append(newValue);
            }
            setOptions.append(", ");
        }
    }

    public static class Inherits {
        private final String key;
        private final String value;

        public String getKey() {
            return key;
        }
        public String getValue() {
            return value;
        }
        public Inherits(String key, String value) {
            super();
            this.key = key;
            this.value = value;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((key == null) ? 0 : key.hashCode());
            result = prime * result + ((value == null) ? 0 : value.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Inherits) {
                Inherits other = (Inherits) obj;
                return Objects.equals(key, other.key)
                        && Objects.equals(value, other.value);
            }
            return false;
        }
    }
}
