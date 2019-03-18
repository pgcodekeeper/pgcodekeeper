package cz.startnet.utils.pgdiff.schema;

import java.util.List;

public interface IStatementContainer extends IStatement {

    void addTrigger(AbstractTrigger trigger);
    AbstractTrigger getTrigger(String name);
    List<AbstractTrigger> getTriggers();

    void addRule(PgRule rule);
    PgRule getRule(String name);
    List<PgRule> getRules();

    void addIndex(AbstractIndex index);
    AbstractIndex getIndex(String name);
    List<AbstractIndex> getIndexes();

    void addConstraint(AbstractConstraint constraint);
    AbstractConstraint getConstraint(String name);
    List<AbstractConstraint> getConstraints();
}
