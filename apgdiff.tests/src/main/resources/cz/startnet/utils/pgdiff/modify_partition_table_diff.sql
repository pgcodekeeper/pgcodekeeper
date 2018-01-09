DROP TABLE cities_hi;

ALTER TABLE cities_cd
	DETACH PARTITION cities_cd_10_to_100;

ALTER TABLE cities_cd
	ATTACH PARTITION cities_cd_10_to_100 FOR VALUES FROM ('1') TO ('10');

ALTER TABLE cities
	DETACH PARTITION cities_fg;

ALTER TABLE cities
	ATTACH PARTITION cities_fg FOR VALUES IN ('e', 'g');

DROP TABLE cities_mz;

DROP FOREIGN TABLE f_cities_e;

ALTER FOREIGN TABLE ONLY ftable SET WITHOUT OIDS;

-- DEPCY: This CONSTRAINT depends on the TABLE: tab_of_type

ALTER TABLE tab_of_type
	DROP CONSTRAINT tab_of_type_f3_check;

DROP TABLE tab_of_type;

-- DEPCY: This TABLE is a dependency of COLUMN: tab_of_type.f3

CREATE TABLE tab_of_type OF public.comp (
	f1 WITH OPTIONS NOT NULL,
	f2 WITH OPTIONS DEFAULT 'text'::text,
	f3 WITH OPTIONS NOT NULL
);

ALTER TABLE ONLY tab_of_type
	ALTER COLUMN f3 SET NOT NULL;

ALTER TABLE cities_ab
	DROP CONSTRAINT constr_check;

CREATE TABLE cities_mz PARTITION OF cities
FOR VALUES IN ('m', 'z')
PARTITION BY RANGE (c3);

ALTER TABLE cities_mz OWNER TO galiev_mr;

CREATE FOREIGN TABLE f_cities_e PARTITION OF cities
FOR VALUES IN ('h', 'i')
SERVER myserver;

ALTER FOREIGN TABLE f_cities_e OWNER TO galiev_mr;

ALTER TABLE tab_of_type
	ADD CONSTRAINT tab_of_type_f3_check CHECK ((f3 > 1));

ALTER TABLE cities_ab
	ADD CONSTRAINT constr_check CHECK ((c1 > 10));
