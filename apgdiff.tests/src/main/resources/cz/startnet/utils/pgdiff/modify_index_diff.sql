SET search_path = public, pg_catalog;

DROP INDEX testindex;

CREATE INDEX """idxф.garbage=:;\""""." ON testtable USING btree (field3);
