
ALTER TABLE testtable
	ADD COLUMN field5 boolean,
	ADD COLUMN field6 integer,
	ADD COLUMN field7 double DEFAULT 1 NOT NULL;

ALTER TABLE testtable
	ALTER COLUMN field5 SET DEFAULT false,
	ALTER COLUMN field6 SET DEFAULT 0;
