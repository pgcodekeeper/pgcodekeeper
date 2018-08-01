SET search_path = pg_catalog;

ALTER TABLE public.t1 DISABLE RULE rule_disable;

ALTER TABLE public.t1 ENABLE RULE rule_enable;

ALTER TABLE public.t1 ENABLE REPLICA RULE rule_enable_replica;

ALTER TABLE public.t1 ENABLE ALWAYS RULE rule_enable_always;