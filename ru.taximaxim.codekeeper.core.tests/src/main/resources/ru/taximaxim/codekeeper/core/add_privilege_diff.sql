SET search_path = pg_catalog;

GRANT ALL ON SCHEMA test_schema TO maindb;

REVOKE ALL ON FOREIGN DATA WRAPPER fdw11 FROM testuser;

REVOKE ALL ON FOREIGN DATA WRAPPER fdw11 FROM PUBLIC;

GRANT ALL ON FOREIGN DATA WRAPPER fdw11 TO user_1;

GRANT ALL ON FOREIGN DATA WRAPPER fdw2 TO user_1;

REVOKE ALL ON FOREIGN DATA WRAPPER fdw3 FROM testuser;

REVOKE ALL ON FOREIGN DATA WRAPPER fdw3 FROM PUBLIC;

REVOKE ALL ON FOREIGN SERVER test_server1 FROM testuser;

REVOKE ALL ON FOREIGN SERVER test_server1 FROM PUBLIC;

GRANT ALL ON FOREIGN SERVER test_server1 TO user_1;

GRANT ALL ON FOREIGN SERVER test_server2 TO user_1;

REVOKE ALL ON FOREIGN SERVER test_server3 FROM testuser;

REVOKE ALL ON FOREIGN SERVER test_server3 FROM PUBLIC;

GRANT ALL ON TYPE public.typ_composite TO maindb;

GRANT ALL ON TYPE public.dom TO maindb;

GRANT ALL ON SEQUENCE public.test_id_seq TO maindb;

GRANT ALL ON TABLE public.test TO maindb;

GRANT MAINTAIN ON TABLE public.lock_table2 TO user1;

REVOKE MAINTAIN ON TABLE public.lock_table3 FROM user1;

REVOKE ALL ON TABLE public.lock_table3 FROM PUBLIC;

REVOKE ALL ON TABLE public.lock_table3 FROM khazieva_gr;

GRANT ALL ON TABLE public.lock_table3 TO khazieva_gr;

GRANT DELETE ON TABLE public.lock_table3 TO khazieva_gr;

GRANT SELECT ON TABLE public.lock_table3 TO khazieva_gr;

GRANT ALL(id) ON TABLE public.test TO maindb;

GRANT ALL ON FUNCTION public.test_fnc(arg character varying) TO maindb;

GRANT ALL ON FUNCTION public.trigger_fnc() TO maindb;

GRANT ALL ON TABLE public.test_view TO maindb;