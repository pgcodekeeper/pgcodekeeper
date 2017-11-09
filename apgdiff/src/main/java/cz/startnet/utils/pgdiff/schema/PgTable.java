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
public abstract class PgTable extends PgStatementWithSearchPath
implements PgRuleContainer, PgTriggerContainer, PgOptionContainer {

    protected static final String OIDS = "OIDS";

    protected final List<PgColumn> columns = new ArrayList<>();
    protected final List<Inherits> inherits = new ArrayList<>();
    protected final Map<String, String> options = new LinkedHashMap<>();
    protected final List<PgConstraint> constraints = new ArrayList<>();
    protected final List<PgIndex> indexes = new ArrayList<>();
    protected final List<PgTrigger> triggers = new ArrayList<>();
    protected final List<PgRule> rules = new ArrayList<>();
    protected boolean hasOids;

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
     * Generates beginning of alter table statement.
     *
     * @param nextLine - if true, string starts with new line symbol
     * @param only - if true, append 'only' to statement
     *
     * @return alter table statement beginning in String format
     */
    protected abstract String getAlterTable(boolean nextLine, boolean only);

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
        final StringBuilder sbOption = new StringBuilder();
        final StringBuilder sbSQL = new StringBuilder();

        appendName(sbSQL);
        appendColumns(sbSQL, sbOption);
        appendInherit(sbSQL);
        appendOptions(sbSQL);
        sbSQL.append(sbOption);
        appendAlterOptions(sbSQL);
        appendOwnerSQL(sbSQL);
        appendPrivileges(sbSQL);
        appendColumnsPriliges(sbSQL);
        appendColumnsStatistics(sbSQL);
        appendComments(sbSQL);
        return sbSQL.toString();
    }


    /**
     * Appends CREATE TABLE statement beginning
     * <br><br>
     * Expected:
     * <br><br>
     * CREATE [ [ GLOBAL | LOCAL ] { TEMPORARY | TEMP } | UNLOGGED | FOREIGN ] TABLE [ IF NOT EXISTS ] table_name
     *
     * @param sbSQL - StringBuilder for statement
     */
    protected abstract void appendName(StringBuilder sbSQL);

    /**
     * Fills columns and their options to create table statement. Options will
     * be appends after CREATE TABLE statement. <br>
     * Must be overridden by subclasses
     *
     * @param sbSQL - StringBuilder for columns
     * @param sbOption - StringBuilder for options
     */
    protected abstract void appendColumns(StringBuilder sbSQL, StringBuilder sbOption);

    /**
     * Fills tables parents, parents are stored in 'inherits' list.<br>
     * May be overridden by subclasses.
     * <br><br>
     * For example:
     * <br><br>
     * INHERITS (first_parent, schema_name.second_parent)
     *
     * @param sbSQL - StringBuilder for inherits
     */
    protected void appendInherit(StringBuilder sbSQL) {
        if (!inherits.isEmpty()) {
            sbSQL.append("\nINHERITS (");
            for (final Inherits tableName : inherits) {
                sbSQL.append((tableName.getKey() == null ? "" : (tableName.getKey() + ".")) +
                        tableName.getValue());
                sbSQL.append(", ");
            }
            sbSQL.setLength(sbSQL.length() - 2);
            sbSQL.append(")");
        }
    }

    /**
     * Appends table storage parameters or server options, part of create statement,
     * must be finished with ';' character;
     *
     * @param sbSQL - StringBuilder for options
     */
    protected abstract void appendOptions(StringBuilder sbSQL);

    /**
     * Appends <b>TABLE</b> options by alter table statement
     * <br><br>
     * For example:
     * <br><br>
     * ALTER TABLE table_name SET WITH OID;
     * <br>
     * @param sbSQL - StringBuilder for options
     */
    protected abstract void appendAlterOptions(StringBuilder sbSQL);

    protected void appendColumnsPriliges(StringBuilder sbSQL) {
        for (PgColumn col : columns) {
            col.appendPrivileges(sbSQL);
        }
    }

    protected void appendColumnsStatistics(StringBuilder sbSQL) {
        for (PgColumn column : getColumnsWithStatistics()) {
            sbSQL.append(getAlterTable(true, true));
            sbSQL.append(" ALTER COLUMN ");
            sbSQL.append(PgDiffUtils.getQuotedName(column.getName()));
            sbSQL.append(" SET STATISTICS ");
            sbSQL.append(column.getStatistics());
            sbSQL.append(';');
        }
    }

    protected void appendComments(StringBuilder sbSQL) {
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
    }

    private void writeSequences(PgColumn column, StringBuilder sbOption) {
        PgSequence sequence = column.getSequence();
        if (sequence != null) {
            sbOption.append(getAlterTable(true, false))
            .append(" ALTER COLUMN ")
            .append(PgDiffUtils.getQuotedName(column.name))
            .append(" ADD GENERATED ")
            .append(column.getIdentityType())
            .append(" AS IDENTITY (");
            sbOption.append("\n\tSEQUENCE NAME ").append(sequence.getName());
            sequence.fillSequenceBody(sbOption);
            sbOption.append("\n);");
        }
    }

    @Override
    public String getDropSQL() {
        return "DROP TABLE " + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        if (!(newCondition instanceof PgTable)) {
            return false;
        }

        PgTable newTable = (PgTable)newCondition;
        PgTable oldTable = this;

        if (isNeedRecreate(oldTable, newTable)) {
            isNeedDepcies.set(true);
            return true;
        }

        compareTableTypes(oldTable, newTable, sb);
        compareInherits(oldTable, newTable, sb);
        compareOptions(oldTable, newTable, sb);
        compareOwners(oldTable, newTable, sb);
        compareTableOptions(oldTable, newTable, sb);
        alterPrivileges(newTable, sb);
        compareComment(oldTable,newTable,sb);

        return sb.length() > startLength;
    }

    /**
     * Compare <b>TABLE</b> options by alter table statement
     *
     * @param oldTable - old table
     * @param newTable - new table
     * @param sb - StringBuilder for statements
     */

    protected abstract void compareTableOptions(PgTable oldTable, PgTable newTable, StringBuilder sb);

    protected void compareComment(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {
        if (!Objects.equals(oldTable.getComment(), newTable.getComment())) {
            sb.append("\n\n");
            newTable.appendCommentSql(sb);
        }
    }

    protected void compareOwners(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {
        if (!Objects.equals(oldTable.getOwner(), newTable.getOwner())) {
            sb.append(newTable.getOwnerSQL());
        }
    }

    protected void compareInherits(PgTable oldTable, PgTable newTable,
            StringBuilder sb) {

        List<Inherits> oldInherits = oldTable.getInherits();
        List<Inherits> newInherits = newTable.getInherits();

        for (final Inherits tableName : oldInherits) {
            if (!newInherits.contains(tableName)) {
                sb.append(getAlterTable(true, false))
                .append("\n\tNO INHERIT ")
                .append(tableName.getKey() == null ?
                        "" : PgDiffUtils.getQuotedName(tableName.getKey()) + '.')
                .append(PgDiffUtils.getQuotedName(tableName.getValue()))
                .append(';');
            }
        }

        for (final Inherits tableName : newInherits) {
            if (!oldInherits.contains(tableName)) {
                sb.append(getAlterTable(true, false))
                .append("\n\tINHERIT ")
                .append(tableName.getKey() == null ?
                        "" : PgDiffUtils.getQuotedName(tableName.getKey()) + '.')
                .append(PgDiffUtils.getQuotedName(tableName.getValue()))
                .append(';');
            }
        }
    }

    protected abstract boolean isNeedRecreate(PgTable oldTable, PgTable newTable);

    /**
     * Compare tables types and generate transform scripts for change tables type
     *
     * @param oldTable - old table
     * @param newTable - new table
     * @param sb - StringBuilder for statements
     */
    //TODO при смене типа на обычную таблицу необходимо пропускать колонки, которые появляются от родителя
    protected abstract void compareTableTypes(PgTable oldTable, PgTable newTable, StringBuilder sb);

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
        resetHash();
    }

    public void addInherits(final String schemaName, final String tableName) {
        inherits.add(new Inherits(schemaName, tableName));
        resetHash();
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

    public boolean getHasOids() {
        return hasOids;
    }

    public void setHasOids(final boolean hasOids) {
        this.hasOids = hasOids;
        resetHash();
    }

    public void addColumn(final PgColumn column) {
        assertUnique(this::getColumn, column);
        columns.add(column);
        column.setParent(this);

        // first the usual columns in the order of adding,
        // then sorted alphabetically the inheritance columns
        Collections.sort(columns, (e1, e2) ->  {
            if (e1.isInherit() && e2.isInherit()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Boolean.compare(!e1.isInherit(), !e2.isInherit());
            }
        });

        resetHash();
    }

    public void addConstraint(final PgConstraint constraint) {
        assertUnique(this::getConstraint, constraint);
        constraints.add(constraint);
        constraint.setParent(this);
        resetHash();
    }

    public void addIndex(final PgIndex index) {
        assertUnique(this::getIndex, index);
        indexes.add(index);
        index.setParent(this);
        resetHash();
    }

    @Override
    public void addTrigger(final PgTrigger trigger) {
        assertUnique(this::getTrigger, trigger);
        triggers.add(trigger);
        trigger.setParent(this);
        resetHash();
    }

    @Override
    public void addRule(final PgRule rule) {
        assertUnique(this::getRule, rule);
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

            eq = Objects.equals(table.getClass(), getClass())
                    && Objects.equals(name, table.getName())
                    && inherits.equals(table.inherits)
                    && columns.equals(table.columns)
                    && grants.equals(table.grants)
                    && revokes.equals(table.revokes)
                    && Objects.equals(owner, table.getOwner())
                    && Objects.equals(comment, table.getComment())
                    && Objects.equals(options, table.getOptions())
                    && hasOids == table.getHasOids();
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
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + (hasOids ? itrue : ifalse);
        result = prime * result + columns.hashCode();
        result = prime * result + inherits.hashCode();
        result = prime * result + options.hashCode();
        result = prime * result + PgDiffUtils.setlikeHashcode(constraints);
        result = prime * result + PgDiffUtils.setlikeHashcode(indexes);
        result = prime * result + PgDiffUtils.setlikeHashcode(triggers);
        result = prime * result + PgDiffUtils.setlikeHashcode(rules);
        return result;
    }

    @Override
    public PgTable shallowCopy() {
        PgTable tableDst = getTableCopy(getName(), getRawStatement());
        tableDst.setHasOids(getHasOids());
        tableDst.options.putAll(options);
        tableDst.inherits.addAll(inherits);
        for (PgColumn colSrc : columns) {
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

    protected abstract PgTable getTableCopy(String name, String rawStatement);

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

    private void writeOptions(PgColumn column, StringBuilder sbOption, boolean isInherit) {
        Map<String, String> opts = column.getOptions();
        Map<String, String> fOpts = column.getForeignOptions();

        if (!opts.isEmpty()) {
            sbOption.append(getAlterTable(true, isInherit))
            .append(" ALTER COLUMN ")
            .append(PgDiffUtils.getQuotedName(column.name))
            .append(" SET (");

            for (Entry<String, String> option : opts.entrySet()) {
                sbOption.append(option.getKey());
                if (!option.getValue().isEmpty()) {
                    sbOption.append('=').append(option.getValue());
                }
                sbOption.append(", ");
            }
            sbOption.setLength(sbOption.length() - 2);
            sbOption.append(");");
        }

        if (!fOpts.isEmpty()) {
            sbOption.append(getAlterTable(true, isInherit))
            .append(" ALTER COLUMN ")
            .append(PgDiffUtils.getQuotedName(column.name))
            .append(" OPTIONS (");

            for (Entry<String, String> option : fOpts.entrySet()) {
                sbOption.append(option.getKey());
                if (!option.getValue().isEmpty()) {
                    sbOption.append(' ').append(option.getValue());
                }
                sbOption.append(", ");
            }
            sbOption.setLength(sbOption.length() - 2);
            sbOption.append(");");
        }
    }

    protected void writeColumn(PgColumn column, StringBuilder sbSQL,
            StringBuilder sbOption) {
        boolean isInherit = column.isInherit();
        if (isInherit) {
            searchColumn(column, sbOption);
        } else {
            sbSQL.append("\t");
            sbSQL.append(column.getFullDefinition());
            sbSQL.append(",\n");
        }

        if (column.getStorage() != null) {
            sbOption.append(getAlterTable(true, isInherit))
            .append(" ALTER COLUMN ")
            .append(PgDiffUtils.getQuotedName(column.name))
            .append(" SET STORAGE ")
            .append(column.getStorage())
            .append(';');
        }

        writeOptions(column, sbOption, isInherit);
        writeSequences(column, sbOption);
    }

    protected void searchColumn(PgColumn column, StringBuilder sb) {
        if (!column.getNullValue()) {
            sb.append(getAlterTable(true, true))
            .append(" ALTER COLUMN ")
            .append(PgDiffUtils.getQuotedName(column.name))
            .append(" SET NOT NULL;");
        }
        if (column.getDefaultValue() != null) {
            sb.append(getAlterTable(true, true))
            .append(" ALTER COLUMN ")
            .append(PgDiffUtils.getQuotedName(column.name))
            .append(" SET DEFAULT ")
            .append(column.getDefaultValue())
            .append(';');
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
