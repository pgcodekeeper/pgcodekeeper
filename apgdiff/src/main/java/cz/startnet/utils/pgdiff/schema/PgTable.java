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

import cz.startnet.utils.pgdiff.PgDiffUtils;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

/**
 * Stores table information.
 *
 * @author fordfrog
 */
public class PgTable extends PgStatementWithSearchPath {

    private final List<PgColumn> columns = new ArrayList<>();
    private final List<Inherits> inherits = new ArrayList<>();
    private final List<PgConstraint> constraints = new ArrayList<>();
    private final List<PgIndex> indexes = new ArrayList<>();
    private final List<PgTrigger> triggers = new ArrayList<>();
    // Костыль позволяет отследить использование Sequence в выражениях вставки
    // DEFAULT (nextval)('sequenceName'::Type)
    private final List<String> sequences = new ArrayList<>();
    private final List<PgRule> rules = new ArrayList<>();

    /**
     * WITH clause. If value is null then it is not set, otherwise can be set to
     * OIDS=true, OIDS=false, or storage parameters can be set.
     */
    private String with;
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

        if (with != null && !with.isEmpty()) {
            sbSQL.append("\n");

            if ("OIDS=false".equalsIgnoreCase(with)) {
                sbSQL.append("WITHOUT OIDS");
            } else {
                sbSQL.append("WITH ");

                if ("OIDS".equalsIgnoreCase(with)
                        || "OIDS=true".equalsIgnoreCase(with)) {
                    sbSQL.append("OIDS");
                } else {
                    sbSQL.append(with);
                }
            }
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

        if (!Objects.equals(oldTable.getWith(), newTable.getWith())) {
            StringBuilder sbWith = new StringBuilder();
            sbWith.append("\n\nALTER TABLE ");
            sbWith.append(PgDiffUtils.getQuotedName(newTable.getName()));

            if (newTable.getWith() == null
                    || "OIDS=false".equalsIgnoreCase(newTable.getWith())) {
                sbWith.append("\n\tSET WITHOUT OIDS;");
            } else if ("OIDS".equalsIgnoreCase(newTable.getWith())
                    || "OIDS=true".equalsIgnoreCase(newTable.getWith())) {
                sbWith.append("\n\tSET WITH OIDS;");
            } else {
                sbWith.append("\n\tSET ");
                sbWith.append(newTable.getWith());
                sbWith.append(';');
            }
            sb.append(sbWith);
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
    public List<PgTrigger> getTriggers() {
        return Collections.unmodifiableList(triggers);
    }

    /**
     * Getter for {@link #rules}. The list cannot be modified.
     *
     * @return {@link #rules}
     */
    public List<PgRule> getRules() {
        return Collections.unmodifiableList(rules);
    }

    public List<String> getSequences() {
        return Collections.unmodifiableList(sequences);
    }

    public void addSequence(final String string) {
        if (string != null && !sequences.contains(string)) {
            sequences.add(string);
            resetHash();
        }
    }

    public void setWith(final String with) {
        this.with = with;
        resetHash();
    }

    public String getWith() {
        return with;
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

    public void addTrigger(final PgTrigger trigger) {
        triggers.add(trigger);
        trigger.setParent(this);
        resetHash();
    }

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
                    && Objects.equals(with, table.getWith())

                    && inherits.equals(table.inherits)
                    && columns.equals(table.columns)
                    && grants.equals(table.grants)
                    && revokes.equals(table.revokes)
                    && sequences.equals(table.sequences)
                    && Objects.equals(owner, table.getOwner())
                    && Objects.equals(comment, table.getComment());
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

                    && new HashSet<>(constraints).equals(new HashSet<>(table.constraints))
                    && new HashSet<>(indexes).equals(new HashSet<>(table.indexes))
                    && new HashSet<>(triggers).equals(new HashSet<>(table.triggers))
                    && new HashSet<>(rules).equals(new HashSet<>(table.rules));
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
        result = prime * result + ((columns == null) ? 0 : columns.hashCode());
        result = prime * result + new HashSet<>(constraints).hashCode();
        result = prime * result + new HashSet<>(indexes).hashCode();
        result = prime * result + ((inherits == null) ? 0 : inherits.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((tablespace == null) ? 0 : tablespace.hashCode());
        result = prime * result + new HashSet<>(triggers).hashCode();
        result = prime * result + new HashSet<>(sequences).hashCode();
        result = prime * result + ((with == null) ? 0 : with.hashCode());
        result = prime * result + ((owner == null) ? 0 : owner.hashCode());
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + new HashSet<>(rules).hashCode();
        return result;
    }

    @Override
    public PgTable shallowCopy() {
        PgTable tableDst = new PgTable(getName(), getRawStatement());
        tableDst.setTablespace(getTablespace());
        tableDst.setWith(getWith());
        for(Inherits inh : inherits) {
            tableDst.addInherits(inh.getKey(), inh.getValue());
        }
        for(PgColumn colSrc : columns) {
            tableDst.addColumn(colSrc.shallowCopy());
        }
        tableDst.setComment(getComment());
        for (PgPrivilege priv : revokes) {
            tableDst.addPrivilege(priv.shallowCopy());
        }
        for (PgPrivilege priv : grants) {
            tableDst.addPrivilege(priv.shallowCopy());
        }
        for (String segName : sequences) {
            tableDst.addSequence(segName);
        }
        tableDst.setOwner(getOwner());
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
