package cz.startnet.utils.pgdiff.schema;

import java.util.List;

public interface PgRuleContainer {

    void addRule(PgRule rule);
    PgRule getRule(String name);
    List<PgRule> getRules();
}
