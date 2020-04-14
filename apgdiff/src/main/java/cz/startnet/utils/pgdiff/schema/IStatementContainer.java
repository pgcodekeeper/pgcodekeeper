package cz.startnet.utils.pgdiff.schema;

import java.util.Collection;

public interface IStatementContainer extends IRelation {

    void addTrigger(AbstractTrigger trigger);
    AbstractTrigger getTrigger(String name);
    Collection<AbstractTrigger> getTriggers();

    void addRule(PgRule rule);
    PgRule getRule(String name);
    Collection<PgRule> getRules();

    void addIndex(AbstractIndex index);
    AbstractIndex getIndex(String name);
    Collection<AbstractIndex> getIndexes();

    void addConstraint(AbstractConstraint constraint);
    AbstractConstraint getConstraint(String name);
    Collection<? extends IConstraint> getConstraints();
}
