CREATE TYPE testtype AS (
	field1 text,
	field2 numeric,
	field3 character(1),
	field4 boolean
);

ALTER TYPE testtype OWNER TO shamsutdinov_lr;

CREATE TABLE testtable OF testtype (
	field1 WITH OPTIONS NOT NULL,
	field2 WITH OPTIONS DEFAULT 1000,
	field3 WITH OPTIONS DEFAULT 'y'::bpchar,
	field4 WITH OPTIONS DEFAULT true
);

ALTER TABLE testtable OWNER TO shamsutdinov_lr;

ALTER TABLE testtable
	ADD CONSTRAINT testtable_pkey PRIMARY KEY (field1);
