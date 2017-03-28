package cz.startnet.utils.pgdiff.schema;

import java.util.List;

public interface PgRuleContainer extends IStatement{

    void addRule(PgRule rule);
    PgRule getRule(String name);
    List<PgRule> getRules();
}
