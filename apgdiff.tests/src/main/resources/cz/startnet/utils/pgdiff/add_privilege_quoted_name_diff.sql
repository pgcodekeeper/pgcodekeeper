SET search_path = pg_catalog;

REVOKE ALL ON TABLE public."MyTestTable" FROM PUBLIC;

GRANT SELECT ON TABLE public."MyTestTable" TO test;

GRANT SELECT(c1),UPDATE(c1) ON TABLE public."MyTestTable" TO test;

REVOKE ALL ON TABLE public."MyTestView" FROM PUBLIC;

GRANT SELECT ON TABLE public."MyTestView" TO test;