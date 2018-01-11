SET search_path = public, pg_catalog;

ALTER TABLE testtable RESET (fillfactor);

ALTER TABLE ONLY testtable SET WITHOUT OIDS;