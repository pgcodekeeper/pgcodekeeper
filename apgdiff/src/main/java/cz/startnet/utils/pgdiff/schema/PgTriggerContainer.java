package cz.startnet.utils.pgdiff.schema;

import java.util.List;

public interface PgTriggerContainer extends IStatement {

    void addTrigger(AbstractTrigger rule);
    AbstractTrigger getTrigger(String name);
    List<AbstractTrigger> getTriggers();

    default boolean containsTrigger(String name) {
        return getTrigger(name) != null;
    }
}
