CREATE SCHEMA "ABC";

ALTER SCHEMA "ABC" OWNER TO fordfrog;

CREATE TABLE "ABC".testtable (
    field1 integer,
    field2 integer,
    field3 character varying(150) DEFAULT 'none'::character varying,
    field4 double precision
);

ALTER TABLE "ABC".testtable OWNER TO fordfrog;

CREATE INDEX testindex ON "ABC".testtable USING btree (field3);