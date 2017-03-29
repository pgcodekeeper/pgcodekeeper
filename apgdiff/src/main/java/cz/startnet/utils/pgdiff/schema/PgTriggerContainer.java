package cz.startnet.utils.pgdiff.schema;

import java.util.List;

public interface PgTriggerContainer extends IStatement {

    void addTrigger(PgTrigger rule);
    PgTrigger getTrigger(String name);
    List<PgTrigger> getTriggers();
}
