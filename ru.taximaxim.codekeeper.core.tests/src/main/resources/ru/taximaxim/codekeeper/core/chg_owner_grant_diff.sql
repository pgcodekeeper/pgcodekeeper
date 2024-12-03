SET search_path = pg_catalog;

ALTER TABLE public."o+o+" OWNER TO n;

REVOKE ALL ON TABLE public."o+o+" FROM PUBLIC;

REVOKE ALL ON TABLE public."o+o+" FROM n;

GRANT ALL ON TABLE public."o+o+" TO n;

GRANT ALL ON TABLE public."o+o+" TO o;

ALTER TABLE public."o+o-" OWNER TO n;

ALTER TABLE public."o-o+" OWNER TO n;

REVOKE ALL ON TABLE public."o-o+" FROM PUBLIC;

REVOKE ALL ON TABLE public."o-o+" FROM n;

GRANT ALL ON TABLE public."o-o+" TO n;

GRANT ALL ON TABLE public."o-o+" TO o;

ALTER TABLE public."o-o-" OWNER TO n;

REVOKE ALL ON TABLE public."o-o-" FROM PUBLIC;

REVOKE ALL ON TABLE public."o-o-" FROM n;

GRANT ALL ON TABLE public."o-o-" TO n;

ALTER TABLE public."n+n+" OWNER TO n;

REVOKE ALL ON TABLE public."n+n+" FROM n;

REVOKE ALL ON TABLE public."n+n+" FROM PUBLIC;

GRANT ALL ON TABLE public."n+n+" TO n;

ALTER TABLE public."n+n-" OWNER TO n;

REVOKE ALL ON TABLE public."n+n-" FROM n;

REVOKE ALL ON TABLE public."n+n-" FROM PUBLIC;

GRANT ALL ON TABLE public."n+n-" TO n;

ALTER TABLE public."n-n+" OWNER TO n;

ALTER TABLE public."n-n-" OWNER TO n;

REVOKE ALL ON TABLE public."n-n-" FROM PUBLIC;

REVOKE ALL ON TABLE public."n-n-" FROM n;

GRANT ALL ON TABLE public."n-n-" TO n;

ALTER TABLE public."o+o+2" OWNER TO n;

REVOKE ALL ON TABLE public."o+o+2" FROM PUBLIC;

REVOKE ALL ON TABLE public."o+o+2" FROM n;

GRANT ALL ON TABLE public."o+o+2" TO n;

GRANT ALL ON TABLE public."o+o+2" TO o;

GRANT ALL ON TABLE public."o+o+2" TO dummy;

ALTER TABLE public."o+o-2" OWNER TO n;

ALTER TABLE public."o-o+2" OWNER TO n;

REVOKE ALL ON TABLE public."o-o+2" FROM PUBLIC;

REVOKE ALL ON TABLE public."o-o+2" FROM n;

GRANT ALL ON TABLE public."o-o+2" TO n;

GRANT ALL ON TABLE public."o-o+2" TO o;

GRANT ALL ON TABLE public."o-o+2" TO dummy;

ALTER TABLE public."o-o-2" OWNER TO n;

REVOKE ALL ON TABLE public."o-o-2" FROM PUBLIC;

REVOKE ALL ON TABLE public."o-o-2" FROM n;

GRANT ALL ON TABLE public."o-o-2" TO n;

GRANT ALL ON TABLE public."o-o-2" TO dummy;

ALTER TABLE public."n+n+2" OWNER TO n;

REVOKE ALL ON TABLE public."n+n+2" FROM n;

REVOKE ALL ON TABLE public."n+n+2" FROM PUBLIC;

GRANT ALL ON TABLE public."n+n+2" TO n;

GRANT ALL ON TABLE public."n+n+2" TO dummy;

ALTER TABLE public."n+n-2" OWNER TO n;

REVOKE ALL ON TABLE public."n+n-2" FROM n;

REVOKE ALL ON TABLE public."n+n-2" FROM PUBLIC;

GRANT ALL ON TABLE public."n+n-2" TO n;

GRANT ALL ON TABLE public."n+n-2" TO dummy;

ALTER TABLE public."n-n+2" OWNER TO n;

ALTER TABLE public."n-n-2" OWNER TO n;

REVOKE ALL ON TABLE public."n-n-2" FROM PUBLIC;

REVOKE ALL ON TABLE public."n-n-2" FROM n;

GRANT ALL ON TABLE public."n-n-2" TO n;

GRANT ALL ON TABLE public."n-n-2" TO dummy;