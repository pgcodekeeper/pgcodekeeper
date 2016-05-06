ALTER TABLE testtable
	ADD COLUMN field5 boolean;

ALTER TABLE testtable
	ALTER COLUMN field5 SET DEFAULT false;

ALTER TABLE testtable
	ADD COLUMN field6 integer;

ALTER TABLE testtable
	ALTER COLUMN field6 SET DEFAULT 0;

ALTER TABLE testtable
	ADD COLUMN field7 double precision DEFAULT 1 NOT NULL;
