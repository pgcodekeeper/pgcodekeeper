CREATE DOMAIN dom1 AS integer;

ALTER DOMAIN dom1
    ADD CONSTRAINT dom1_check CHECK ((VALUE <> '-1'::integer)) NOT VALID;


CREATE TABLE t1 (
    c1 int
);

ALTER TABLE t1
    ADD CONSTRAINT t1_c1_check CHECK ((c1 <> '-1'::integer)) NOT VALID;