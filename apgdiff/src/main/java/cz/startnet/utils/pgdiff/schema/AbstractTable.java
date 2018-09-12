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
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import cz.startnet.utils.pgdiff.hashers.IHashable;
import cz.startnet.utils.pgdiff.hashers.JavaHasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

/**
 * Stores table information.
 *
 * @author fordfrog
 */
public abstract class AbstractTable extends PgStatementWithSearchPath
implements PgRuleContainer, PgTriggerContainer, PgOptionContainer, IRelation {

    protected static final String ALTER_COLUMN = " ALTER COLUMN ";

    protected final List<AbstractColumn> columns = new ArrayList<>();
    protected final List<Inherits> inherits = new ArrayList<>();
    protected final Map<String, String> options = new LinkedHashMap<>();
    protected boolean hasOids;
    protected final List<AbstractConstraint> constraints = new ArrayList<>();
    protected final List<AbstractIndex> indexes = new ArrayList<>();
    protected final List<AbstractTrigger> triggers = new ArrayList<>();
    protected final List<PgRule> rules = new ArrayList<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TABLE;
    }

    public AbstractTable(String name, String rawStatement) {
        super(name, rawStatement);
    }

    public boolean isClustered() {
        for (AbstractIndex ind : indexes) {
            if (ind.isClusterIndex()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Stream<PgStatement> getChildren() {
        Stream<PgStatement> stream = Stream.concat(getIndexes().stream(), getTriggers().stream());
        stream = Stream.concat(stream, getRules().stream());
        stream = Stream.concat(stream, getConstraints().stream());
        return stream;
    }

    public static Stream<PgStatement> columnAdder(PgStatement st) {
        Stream<PgStatement> newStream = Stream.of(st);
        if (st.getStatementType() == DbObjType.TABLE) {
            newStream = Stream.concat(newStream, ((AbstractTable)st).getColumns().stream());
        }

        return newStream;
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
    public AbstractColumn getColumn(final String name) {
        for (AbstractColumn column : columns) {
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
    public List<AbstractColumn> getColumns() {
        return Collections.unmodifiableList(columns);
    }

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        Stream<Pair<String, String>> localColumns = columns.stream()
                .filter(c -> c.getType() != null)
                .map(c -> new Pair<>(c.getName(), c.getType()));
        if (inherits.isEmpty()) {
            return localColumns;
        }

        Stream<Pair<String, String>> inhColumns = Stream.empty();
        for (Inherits inht : inherits) {
            String schemaName = inht.getKey();
            AbstractSchema inhtSchema = schemaName == null ? getContainingSchema()
                    : getDatabase().getSchema(schemaName);
            inhColumns = Stream.concat(inhColumns, inhtSchema
                    .getTable(inht.getValue()).getRelationColumns());
        }
        return Stream.concat(inhColumns, localColumns);
    }

    /**
     * Finds constraint according to specified constraint {@code name}.
     *
     * @param name name of the constraint to be searched
     *
     * @return found constraint or null if no such constraint has been found
     */
    public AbstractConstraint getConstraint(final String name) {
        for (AbstractConstraint constraint : constraints) {
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
    public List<AbstractConstraint> getConstraints() {
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
                sbSQL.append(tableName.getQualifiedName());
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
        for (AbstractColumn col : columns) {
            col.appendPrivileges(sbSQL);
        }
    }

    protected void appendColumnsStatistics(StringBuilder sbSQL) {
        columns.stream().filter(c -> c.getStatistics() != null)
        .forEach(column -> {
            sbSQL.append(getAlterTable(true, true));
            sbSQL.append(ALTER_COLUMN);
            sbSQL.append(PgDiffUtils.getQuotedName(column.getName()));
            sbSQL.append(" SET STATISTICS ");
            sbSQL.append(column.getStatistics());
            sbSQL.append(';');
        });
    }

    protected void appendComments(StringBuilder sbSQL) {
        if (comment != null && !comment.isEmpty()) {
            sbSQL.append("\n\n");
            appendCommentSql(sbSQL);
        }

        for (final AbstractColumn column : columns) {
            if (column.getComment() != null && !column.getComment().isEmpty()) {
                sbSQL.append("\n\n");
                column.appendCommentSql(sbSQL);
            }
        }
    }

    private void writeSequences(AbstractColumn column, StringBuilder sbOption) {
        AbstractSequence sequence = column.getSequence();
        if (sequence != null) {
            sbOption.append(getAlterTable(true, false))
            .append(ALTER_COLUMN)
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
        return "DROP TABLE " + PgDiffUtils.getQuotedName(getContainingSchema().getName()) + '.'
                + PgDiffUtils.getQuotedName(getName()) + ';';
    }

    @Override
    public boolean appendAlterSQL(PgStatement newCondition, StringBuilder sb,
            AtomicBoolean isNeedDepcies) {
        final int startLength = sb.length();
        if (!(newCondition instanceof AbstractTable)) {
            return false;
        }

        AbstractTable newTable = (AbstractTable)newCondition;

        if (isNeedRecreate(newTable)) {
            isNeedDepcies.set(true);
            return true;
        }

        compareTableTypes(newTable, sb);
        compareInherits(newTable, sb);
        compareOptions(newTable, sb);
        compareOwners(newTable, sb);
        compareTableOptions(newTable, sb);
        alterPrivileges(newTable, sb);
        compareComment(newTable,sb);

        return sb.length() > startLength;
    }

    /**
     * Compare <b>TABLE</b> options by alter table statement
     *
     * @param newTable - new table
     * @param sb - StringBuilder for statements
     */
    protected void compareTableOptions(AbstractTable newTable, StringBuilder sb) {
        if (hasOids != newTable.getHasOids()) {
            sb.append(getAlterTable(true, true))
            .append(" SET ")
            .append(newTable.getHasOids() ? "WITH" : "WITHOUT")
            .append(" OIDS;");
        }
    }

    protected void compareComment(AbstractTable newTable, StringBuilder sb) {
        if (!Objects.equals(getComment(), newTable.getComment())) {
            sb.append("\n\n");
            newTable.appendCommentSql(sb);
        }
    }

    protected void compareOwners(AbstractTable newTable, StringBuilder sb) {
        if (!Objects.equals(owner, newTable.getOwner())) {
            sb.append(newTable.getOwnerSQL());
        }
    }

    protected void compareInherits(AbstractTable newTable, StringBuilder sb) {
        List<Inherits> newInherits = newTable.getInherits();

        if (newTable instanceof PartitionPgTable) {
            return;
        }

        for (final Inherits tableName : inherits) {
            if (!newInherits.contains(tableName)) {
                sb.append(getAlterTable(true, false))
                .append("\n\tNO INHERIT ")
                .append(tableName.getQualifiedName())
                .append(';');
            }
        }

        for (final Inherits tableName : newInherits) {
            if (!inherits.contains(tableName)) {
                sb.append(getAlterTable(true, false))
                .append("\n\tINHERIT ")
                .append(tableName.getQualifiedName())
                .append(';');
            }
        }
    }

    protected abstract boolean isNeedRecreate(AbstractTable newTable);

    /**
     * Compare tables types and generate transform scripts for change tables type
     *
     * @param oldTable - old table
     * @param newTable - new table
     * @param sb - StringBuilder for statements
     */
    protected abstract void compareTableTypes(AbstractTable newTable, StringBuilder sb);

    /**
     * Finds index according to specified index {@code name}.
     *
     * @param name name of the index to be searched
     *
     * @return found index or null if no such index has been found
     */
    public AbstractIndex getIndex(final String name) {
        for (AbstractIndex index : indexes) {
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
    public AbstractTrigger getTrigger(final String name) {
        for (AbstractTrigger trigger : triggers) {
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
    public List<AbstractIndex> getIndexes() {
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
    public List<AbstractTrigger> getTriggers() {
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

    public void addColumn(final AbstractColumn column) {
        assertUnique(this::getColumn, column);
        columns.add(column);
        column.setParent(this);
        resetHash();
    }

    /**
     * Sorts columns on table.
     * <br><br>
     * First the usual columns in the order of adding,
     * then sorted alphabetically the inheritance columns
     */
    public void sortColumns() {
        Collections.sort(columns, (e1, e2) ->  {
            if (e1.isInherit() && e2.isInherit()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return -Boolean.compare(e1.isInherit(), e2.isInherit());
            }
        });

        resetHash();
    }

    public void addConstraint(final AbstractConstraint constraint) {
        assertUnique(this::getConstraint, constraint);
        constraints.add(constraint);
        constraint.setParent(this);
        resetHash();
    }

    public void addIndex(final AbstractIndex index) {
        assertUnique(this::getIndex, index);
        indexes.add(index);
        index.setParent(this);
        resetHash();
    }

    @Override
    public void addTrigger(final AbstractTrigger trigger) {
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

    @Override
    public boolean compare(PgStatement obj) {
        boolean eq = false;

        if(this == obj) {
            eq = true;
        } else if(obj instanceof AbstractTable) {
            AbstractTable table = (AbstractTable) obj;

            eq = getClass().equals(table.getClass())
                    && Objects.equals(name, table.getName())
                    && columns.equals(table.columns)
                    && inherits.equals(table.inherits)
                    && options.equals(table.options)
                    && hasOids == table.getHasOids()
                    && grants.equals(table.grants)
                    && revokes.equals(table.revokes)
                    && Objects.equals(owner, table.getOwner())
                    && Objects.equals(comment, table.getComment());
        }
        return eq;
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof AbstractTable) {
            AbstractTable table = (AbstractTable) obj;
            return PgDiffUtils.setlikeEquals(constraints, table.constraints)
                    && PgDiffUtils.setlikeEquals(indexes, table.indexes)
                    && PgDiffUtils.setlikeEquals(triggers, table.triggers)
                    && PgDiffUtils.setlikeEquals(rules, table.rules);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.put(name);
        hasher.putOrdered(columns);
        hasher.putOrdered(inherits);
        hasher.put(options);
        hasher.put(hasOids);
        hasher.putOrdered(grants);
        hasher.putOrdered(revokes);
        hasher.put(owner);
        hasher.put(comment);
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(constraints);
        hasher.putUnordered(indexes);
        hasher.putUnordered(triggers);
        hasher.putUnordered(rules);
    }

    @Override
    public AbstractTable shallowCopy() {
        AbstractTable tableDst = getTableCopy();
        for (AbstractColumn colSrc : columns) {
            tableDst.addColumn(colSrc.deepCopy());
        }
        tableDst.inherits.addAll(inherits);
        tableDst.options.putAll(options);
        tableDst.setHasOids(getHasOids());
        for (PgPrivilege priv : revokes) {
            tableDst.addPrivilege(priv);
        }
        for (PgPrivilege priv : grants) {
            tableDst.addPrivilege(priv);
        }
        tableDst.setOwner(getOwner());
        tableDst.setComment(getComment());
        tableDst.deps.addAll(deps);
        tableDst.setLocation(getLocation());
        return tableDst;
    }

    protected abstract AbstractTable getTableCopy();

    @Override
    public AbstractTable deepCopy() {
        AbstractTable copy = shallowCopy();

        for (AbstractConstraint constraint : constraints) {
            copy.addConstraint(constraint.deepCopy());
        }
        for (AbstractIndex index : indexes) {
            copy.addIndex(index.deepCopy());
        }
        for (AbstractTrigger trigger : triggers) {
            copy.addTrigger(trigger.deepCopy());
        }
        for (PgRule rule : rules) {
            copy.addRule(rule.deepCopy());
        }
        return copy;
    }

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema)this.getParent();
    }

    private void writeOptions(AbstractColumn column, StringBuilder sbOption, boolean isInherit) {
        Map<String, String> opts = column.getOptions();
        Map<String, String> fOpts = column.getForeignOptions();

        if (!opts.isEmpty()) {
            sbOption.append(getAlterTable(true, isInherit))
            .append(ALTER_COLUMN)
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
            .append(ALTER_COLUMN)
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

    protected void writeColumn(AbstractColumn column, StringBuilder sbSQL,
            StringBuilder sbOption) {
        boolean isInherit = column.isInherit();
        if (isInherit) {
            fillInheritOptions(column, sbOption);
        } else {
            sbSQL.append("\t");
            sbSQL.append(column.getFullDefinition());
            sbSQL.append(",\n");
        }

        if (column.getStorage() != null) {
            sbOption.append(getAlterTable(true, isInherit))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.name))
            .append(" SET STORAGE ")
            .append(column.getStorage())
            .append(';');
        }

        writeOptions(column, sbOption, isInherit);
        writeSequences(column, sbOption);
    }

    private void fillInheritOptions(AbstractColumn column, StringBuilder sb) {
        if (!column.getNullValue()) {
            sb.append(getAlterTable(true, true))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.name))
            .append(" SET NOT NULL;");
        }
        if (column.getDefaultValue() != null) {
            sb.append(getAlterTable(true, true))
            .append(ALTER_COLUMN)
            .append(PgDiffUtils.getQuotedName(column.name))
            .append(" SET DEFAULT ")
            .append(column.getDefaultValue())
            .append(';');
        }
    }

    public static class Inherits implements IHashable {
        private final String key;
        private final String value;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public Inherits(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getQualifiedName() {
            return (key == null ? "" : (PgDiffUtils.getQuotedName(key) + '.'))
                    + PgDiffUtils.getQuotedName(value);
        }

        @Override
        public int hashCode() {
            JavaHasher hasher = new JavaHasher();
            computeHash(hasher);
            return hasher.getResult();
        }

        @Override
        public void computeHash(Hasher hasher) {
            hasher.put(key);
            hasher.put(value);
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
