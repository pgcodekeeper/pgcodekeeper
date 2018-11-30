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
implements PgRuleContainer, PgTriggerContainer, IRelation {

    private final List<PgRule> rules = new ArrayList<>();
    private final List<AbstractTrigger> triggers = new ArrayList<>();
    private final List<Pair<String, String>> relationColumns = new ArrayList<>();

    @Override
    public DbObjType getStatementType() {
        return DbObjType.VIEW;
    }

    public AbstractView(String name) {
        super(name);
    }

    @Override
    public Stream<PgStatement> getChildren() {
        return Stream.concat(getRules().stream(), getTriggers().stream());
    }

    @Override
    public void addChild(PgStatement st) {
        DbObjType type = st.getStatementType();
        switch (type) {
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
    public Stream<Pair<String, String>> getRelationColumns() {
        return relationColumns.stream();
    }

    public void addRelationColumns(List<Pair<String, String>> relationColumns) {
        this.relationColumns.addAll(relationColumns);
    }

    @Override
    public boolean compare(PgStatement obj) {
        if (this == obj) {
            return true;
        }

        return obj instanceof AbstractView && compareBaseFields(obj);
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
    protected void computeChildrenHash(Hasher hasher) {
        hasher.putUnordered(rules);
        hasher.putUnordered(triggers);
    }

    @Override
    public AbstractView shallowCopy() {
        AbstractView viewDst = getViewCopy();
        copyBaseFields(viewDst);
        viewDst.relationColumns.addAll(relationColumns);
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

    @Override
    public AbstractSchema getContainingSchema() {
        return (AbstractSchema)this.getParent();
    }
}
