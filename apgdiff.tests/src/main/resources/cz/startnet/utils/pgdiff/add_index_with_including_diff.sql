DROP INDEX testindex3;

CREATE INDEX testindex4 ON testtable USING btree (field3) INCLUDE (field4);

DROP INDEX testindex2;

CREATE INDEX testindex2 ON testtable USING btree (field2);

ALTER TABLE testtable CLUSTER ON testindex2;