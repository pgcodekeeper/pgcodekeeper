SET search_path = public, pg_catalog;

ALTER TABLE t1 DISABLE RULE rule_disable;

ALTER TABLE t1 ENABLE RULE rule_enable;

ALTER TABLE t1 ENABLE REPLICA RULE rule_enable_replica;

ALTER TABLE t1 ENABLE ALWAYS RULE rule_enable_always;