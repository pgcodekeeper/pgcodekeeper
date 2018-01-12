SET search_path = public, pg_catalog;

ALTER TABLE testtable SET (fillfactor=70);

ALTER TABLE ONLY testtable SET WITH OIDS;