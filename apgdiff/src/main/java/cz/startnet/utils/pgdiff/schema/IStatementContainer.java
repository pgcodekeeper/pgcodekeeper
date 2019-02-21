package cz.startnet.utils.pgdiff.schema;

import java.util.List;

public interface IStatementContainer extends IStatement {

    void addTrigger(AbstractTrigger trigger);
    AbstractTrigger getTrigger(String name);
    List<AbstractTrigger> getTriggers();

    default boolean containsTrigger(String name) {
        return getTrigger(name) != null;
    }

    void addRule(PgRule rule);
    PgRule getRule(String name);
    List<PgRule> getRules();

    default boolean containsRule(String name) {
        return getRule(name) != null;
    }

    void addIndex(AbstractIndex index);
    AbstractIndex getIndex(String name);
    List<AbstractIndex> getIndexes();

    default boolean containsIndex(String name) {
        return getIndex(name) != null;
    }

    void addConstraint(AbstractConstraint constraint);
    AbstractConstraint getConstraint(String name);
    List<AbstractConstraint> getConstraints();

    default boolean containsConstraint(String name) {
        return getConstraint(name) != null;
    }
}
