package cz.startnet.utils.pgdiff.schema;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.hashers.Hasher;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.apgdiff.utils.Pair;

public abstract class AbstractView extends PgStatementWithSearchPath
implements IStatementContainer, IRelation {

    private final List<PgRule> rules = new ArrayList<>();
    private final List<AbstractTrigger> triggers = new ArrayList<>();
    private final List<AbstractIndex> indexes = new ArrayList<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.VIEW;
    }

    public AbstractView(String name) {
        super(name);
    }

    @Override
    protected void fillChildrenList(List<List<? extends PgStatement>> l) {
        l.add(rules);
        l.add(triggers);
        l.add(indexes);
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

    @Override
    public AbstractIndex getIndex(String name) {
        for (AbstractIndex index : indexes) {
            if (index.getName().equals(name)) {
                return index;
            }
        }

        return null;
    }

    @Override
    public List<AbstractIndex> getIndexes() {
        return Collections.unmodifiableList(indexes);
    }

    @Override
    public void addIndex(AbstractIndex index) {
        assertUnique(this::getIndex, index);
        indexes.add(index);
        index.setParent(this);
        resetHash();
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
            return PgDiffUtils.setlikeEquals(rules, view.rules)
                    && PgDiffUtils.setlikeEquals(triggers, view.triggers)
                    && PgDiffUtils.setlikeEquals(indexes, view.indexes);
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
