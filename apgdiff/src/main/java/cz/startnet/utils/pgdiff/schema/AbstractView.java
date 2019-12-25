package cz.startnet.utils.pgdiff.schema;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public abstract class AbstractView extends PgStatementWithSearchPath
implements IStatementContainer, IRelation {

    private final Map<String, PgRule> rules = new LinkedHashMap<>();
    private final Map<String, AbstractTrigger> triggers = new LinkedHashMap<>();
    private final Map<String, AbstractIndex> indexes = new LinkedHashMap<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.VIEW;
    }

    public AbstractView(String name) {
        super(name);
    }

    @Override
    protected void fillChildrenList(List<Collection<? extends PgStatement>> l) {
        l.add(rules.values());
        l.add(triggers.values());
        l.add(indexes.values());
    }

    @Override
    public PgStatement getChild(String name, DbObjType type) {
        switch (type) {
        case RULE:
            return getRule(name);
        case TRIGGER:
            return getTrigger(name);
        case INDEX:
            return getIndex(name);
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

    @Override
    public Collection<PgRule> getRules() {
        return Collections.unmodifiableCollection(rules.values());
    }

    @Override
    public void addRule(final PgRule rule) {
        addUnique(rules, rule, this);
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
        return triggers.get(name);
    }

    @Override
    public Collection<AbstractTrigger> getTriggers() {
        return Collections.unmodifiableCollection(triggers.values());
    }

    @Override
    public void addTrigger(final AbstractTrigger trigger) {
        addUnique(triggers, trigger, this);
    }

    @Override
    public AbstractIndex getIndex(String name) {
        return indexes.get(name);
    }

    @Override
    public Collection<AbstractIndex> getIndexes() {
        return Collections.unmodifiableCollection(indexes.values());
    }

    @Override
    public void addIndex(AbstractIndex index) {
        addUnique(indexes, index, this);
    }

    @Override
    public void addConstraint(AbstractConstraint constraint) {
        // no op
        // throw error later?
    }

    @Override
    public AbstractConstraint getConstraint(String name) {
        return null;
    }

    @Override
    public List<AbstractConstraint> getConstraints() {
        return Collections.emptyList();
    }

    @Override
    public Stream<Pair<String, String>> getRelationColumns() {
        return Stream.empty();
    }

    @Override
    public boolean compare(PgStatement obj) {
        return this == obj || obj instanceof AbstractView && super.compare(obj);
    }

    @Override
    public boolean compareChildren(PgStatement obj) {
        if(obj instanceof AbstractView) {
            AbstractView view = (AbstractView) obj;
            return rules.equals(view.rules)
                    && triggers.equals(view.triggers)
                    && indexes.equals(view.indexes);
        }
        return false;
    }

    @Override
    protected void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(rules);
        hasher.putUnordered(triggers);
        hasher.putUnordered(indexes);
    }

    @Override
    public AbstractView shallowCopy() {
        AbstractView viewDst = getViewCopy();
        copyBaseFields(viewDst);
        return viewDst;
    }

    protected abstract AbstractView getViewCopy();

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema) this.getParent();
    }
}
