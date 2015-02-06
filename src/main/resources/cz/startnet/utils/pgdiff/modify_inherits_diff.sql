
CREATE TABLE parenttable2 (
	id bigserial NOT NULL
);

ALTER TABLE parenttable2 OWNER TO fordfrog;

ALTER TABLE parenttable
	DROP COLUMN id;

ALTER TABLE parenttable
	ADD COLUMN field3 information_schema.cardinal_number;

ALTER TABLE testtable
	NO INHERIT parenttable;

ALTER TABLE testtable
	INHERIT parenttable2;
