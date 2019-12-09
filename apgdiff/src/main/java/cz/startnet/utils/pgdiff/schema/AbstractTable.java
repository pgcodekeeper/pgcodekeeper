package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

/**
 * Stores table information.
 */
public abstract class AbstractTable extends PgStatementWithSearchPath
implements IStatementContainer, PgOptionContainer, IRelation {

    protected static final String ALTER_COLUMN = " ALTER COLUMN ";

    protected final List<AbstractColumn> columns = new ArrayList<>();
    protected final Map<String, String> options = new LinkedHashMap<>();

    protected final Map<String, AbstractConstraint> constraints = new LinkedHashMap<>();
    protected final Map<String, AbstractIndex> indexes = new LinkedHashMap<>();
    protected final Map<String, AbstractTrigger> triggers = new LinkedHashMap<>();
    protected final Map<String, PgRule> rules = new LinkedHashMap<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.TABLE;
    }

    public AbstractTable(String name) {
        super(name);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        l.add(indexes.values());
        l.add(triggers.values());
        l.add(rules.values());
        l.add(constraints.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        switch (type) {
        case INDEX:
            return getIndex(name);
        case TRIGGER:
            return getTrigger(name);
        case RULE:
            return getRule(name);
        case CONSTRAINT:
            return getConstraint(name);
        default:
            return null;
        }
    }

    @Override
    public void addChild(PgStatement st) {
        DbObjType type = st.getStatementType();
        switch (type) {
        case INDEX:
            addIndex((AbstractIndex) st);
            break;
        case CONSTRAINT:
            addConstraint((AbstractConstraint) st);
            break;
        case TRIGGER:
            addTrigger((AbstractTrigger) st);
            break;
        case RULE:
            addRule((PgRule) st);
            break;
        default:
            throw new IllegalArgumentException("Unsupported child type: " + type);
        }
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
        return columns.stream().filter(c -> c.getType() != null)
                .map(c -> new Pair<>(c.getName(), c.getType()));
    }

    /**
     * Finds constraint according to specified constraint {@code name}.
     *
     * @param name name of the constraint to be searched
     *
     * @return found constraint or null if no such constraint has been found
     */
    @Override
    public AbstractConstraint getConstraint(final String name) {
        return constraints.get(name);
    }

    /**
     * Getter for {@link #constraints}. The list cannot be modified.
     *
     * @return {@link #constraints}
     */
    @Override
    public Collection<AbstractConstraint> getConstraints() {
        return Collections.unmodifiableCollection(constraints.values());
    }

    /** Checks if the order of the table columns has changed.<br><br>
     *
     * <b>Example:</b><br><br>
     *
     * original columns : c1, c2, c3<br>
     * new columns      : c2, c3, c1<br><br>
     *
     * Column c1 was moved to last index and method will return true<br><br>
     *
     * <b>Example:</b><br><br>
     *
     * original columns : c1, c2, c3<br>
     * new columns      : c2, c3, c4<br><br>
     *
     * Column c1 was deleted and column c4 was added. Method will return false.<br><br>
     *
     * <b>Example:</b><br><br>
     *
     * original columns : c1, c2, c3<br>
     * new columns      : c1, c4, c2, c3<br><br>
     *
     * Column c4 was added between old columns: c1 and c2. Method will return true.<br><br>
     *
     * <b>Example:</b><br><br>
     *
     * original columns : c2, c3, inherit(some table)<br>
     * new columns      : c1, c2, c3<br><br>
     *
     * Some table is no longer inherited. If table did not have a column c1,
     * we must return true, but we cannot track this right now. Method will return false. <br><br>
     *
     * @param newTable - new table
     * @return true if order was changed
     * @since 5.1.7
     */
    protected boolean isColumnsOrderChanged(AbstractTable newTable) {
        // last founded column
        int i = -1;
        for (AbstractColumn col : newTable.getColumns()) {
            // old column index
            int index = 0;
            // search old column index by new column name
            for ( ; index < columns.size(); index++) {
                if (col.getName().equals(columns.get(index).getName())) {
                    break;
                }
            }

            if (index == columns.size()) {
                // New column was not found in original table.
                // After this column can be only new columns.
                i = Integer.MAX_VALUE;
            } else if (index < i) {
                // New column was found in original table
                // but one of previous columns was not found
                // or was located on more later index
                return true;
            } else {
                // New column was found in original table.
                // Safe index of column in original table.
                i = index;
            }
        }

        return false;
    }

    protected void compareComment(AbstractTable newTable, StringBuilder sb) {
        if (!Objects.equals(getComment(), newTable.getComment())) {
            sb.append("\n\n");
            newTable.appendCommentSql(sb);
        }
    }

    protected void compareOwners(AbstractTable newTable, StringBuilder sb) {
        if (!Objects.equals(owner, newTable.getOwner())) {
            newTable.alterOwnerSQL(sb);
        }
    }

    protected void appendColumnsPriliges(StringBuilder sbSQL) {
        for (AbstractColumn col : columns) {
            col.appendPrivileges(sbSQL);
        }
    }

    public final boolean isRecreated(AbstractTable newTable) {
        return isNeedRecreate(newTable) || isColumnsOrderChanged(newTable);
    }

    protected abstract boolean isNeedRecreate(AbstractTable newTable);

    /**
     * Finds index according to specified index {@code name}.
     *
     * @param name name of the index to be searched
     *
     * @return found index or null if no such index has been found
     */
    @Override
    public AbstractIndex getIndex(final String name) {
        return indexes.get(name);
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
        return triggers.get(name);
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
        return rules.get(name);
    }

    /**
     * Getter for {@link #indexes}. The list cannot be modified.
     *
     * @return {@link #indexes}
     */
    @Override
    public Collection<AbstractIndex> getIndexes() {
        return Collections.unmodifiableCollection(indexes.values());
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
     * Getter for {@link #triggers}. The list cannot be modified.
     *
     * @return {@link #triggers}
     */
    @Override
    public Collection<AbstractTrigger> getTriggers() {
        return Collections.unmodifiableCollection(triggers.values());
    }

    /**
     * Getter for {@link #rules}. The list cannot be modified.
     *
     * @return {@link #rules}
     */
    @Override
    public Collection<PgRule> getRules() {
        return Collections.unmodifiableCollection(rules.values());
    }

    public void addColumn(final AbstractColumn column) {
        assertUnique(getColumn(column.getName()), column);
        columns.add(column);
        column.setParent(this);
        resetHash();
    }

    @Override
    public void addConstraint(final AbstractConstraint constraint) {
        addUnique(constraints, constraint, this);
    }

    @Override
    public void addIndex(final AbstractIndex index) {
        addUnique(indexes, index, this);
    }

    @Override
    public void addTrigger(final AbstractTrigger trigger) {
        addUnique(triggers, trigger, this);
    }

    @Override
    public void addRule(final PgRule rule) {
        addUnique(rules, rule, this);
    }

    public boolean containsColumn(final String name) {
        return getColumn(name) != null;
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof AbstractTable && super.compare(obj)) {
            AbstractTable table = (AbstractTable) obj;
            return getClass().equals(table.getClass())
                    && columns.equals(table.columns)
                    && options.equals(table.options);
        }

        return false;
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof AbstractTable) {
            AbstractTable table = (AbstractTable) obj;
            return constraints.equals(table.constraints)
                    && indexes.equals(table.indexes)
                    && triggers.equals(table.triggers)
                    && rules.equals(table.rules);
        }
        return false;
    }

    @Override
    public void computeHash(Hasher hasher) {
        hasher.putOrdered(columns);
        hasher.put(options);
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
        copyBaseFields(tableDst);
        for (AbstractColumn colSrc : columns) {
            tableDst.addColumn((AbstractColumn) colSrc.deepCopy());
        }
        tableDst.options.putAll(options);
        return tableDst;
    }

    protected abstract AbstractTable getTableCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema)this.getParent();
    }
}
