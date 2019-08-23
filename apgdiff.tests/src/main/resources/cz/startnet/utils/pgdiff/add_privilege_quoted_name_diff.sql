SET search_path = pg_catalog;

GRANT SELECT ON TABLE public."MyTestTable" TO test;

GRANT SELECT(c1),UPDATE(c1) ON TABLE public."MyTestTable" TO test;

GRANT SELECT ON TABLE public."MyTestView" TO test;