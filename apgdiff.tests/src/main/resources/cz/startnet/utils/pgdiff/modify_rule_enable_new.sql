CREATE TABLE public.t1();

CREATE RULE rule_disable AS ON INSERT TO public.t1 DO NOTHING;
CREATE RULE rule_enable AS ON INSERT TO public.t1 DO NOTHING;
CREATE RULE rule_enable_replica AS ON INSERT TO public.t1 DO NOTHING;
CREATE RULE rule_enable_always AS ON INSERT TO public.t1 DO NOTHING;

ALTER TABLE public.t1 DISABLE RULE rule_disable;
ALTER TABLE public.t1 ENABLE REPLICA RULE rule_enable_replica;
ALTER TABLE public.t1 ENABLE ALWAYS RULE rule_enable_always;
