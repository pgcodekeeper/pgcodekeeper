package cz.startnet.utils.pgdiff.schema;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public abstract class PgStatementContainer extends PgStatementWithSearchPath
implements IStatementContainer {

    protected final Map<String, AbstractIndex> indexes = new LinkedHashMap<>();
    protected final Map<String, AbstractTrigger> triggers = new LinkedHashMap<>();
    protected final Map<String, PgRule> rules = new LinkedHashMap<>();

    public PgStatementContainer(String name) {
        super(name);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        l.add(indexes.values());
        l.add(triggers.values());
        l.add(rules.values());
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

    /**
     * Finds constraint according to specified constraint {@code name}.
     *
     * @param name name of the constraint to be searched
     *
     * @return found constraint or null if no such constraint has been found
     */
    public abstract AbstractConstraint getConstraint(final String name);

    /**
     * Finds index according to specified index {@code name}.
     *
     * @param name name of the index to be searched
     *
     * @return found index or null if no such index has been found
     */
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
    public PgRule getRule(final String name) {
        return rules.get(name);
    }

    @Override
    public abstract Collection<AbstractConstraint> getConstraints();

    /**
     * Getter for {@link #indexes}. The list cannot be modified.
     *
     * @return {@link #indexes}
     */
    public Collection<AbstractIndex> getIndexes() {
        return Collections.unmodifiableCollection(indexes.values());
    }

    /**
     * Getter for {@link #triggers}. The list cannot be modified.
     *
     * @return {@link #triggers}
     */
    public Collection<AbstractTrigger> getTriggers() {
        return Collections.unmodifiableCollection(triggers.values());
    }

    /**
     * Getter for {@link #rules}. The list cannot be modified.
     *
     * @return {@link #rules}
     */
    public Collection<PgRule> getRules() {
        return Collections.unmodifiableCollection(rules.values());
    }

    public abstract void addConstraint(final AbstractConstraint constraint);

    public void addIndex(final AbstractIndex index) {
        addUnique(indexes, index, this);
    }

    public void addTrigger(final AbstractTrigger trigger) {
        addUnique(triggers, trigger, this);
    }

    public void addRule(final PgRule rule) {
        addUnique(rules, rule, this);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if (obj instanceof PgStatementContainer) {
            PgStatementContainer table = (PgStatementContainer) obj;
            return indexes.equals(table.indexes)
                    && triggers.equals(table.triggers)
                    && rules.equals(table.rules);
        }
        return false;
    }

    @Override
    public void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(indexes);
        hasher.putUnordered(triggers);
        hasher.putUnordered(rules);
    }

    @Override
    public PgStatementContainer shallowCopy() {
        PgStatementContainer copy = getCopy();
        copyBaseFields(copy);
        return copy;
    }

    protected abstract PgStatementContainer getCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) this.getParent();
    }
}
