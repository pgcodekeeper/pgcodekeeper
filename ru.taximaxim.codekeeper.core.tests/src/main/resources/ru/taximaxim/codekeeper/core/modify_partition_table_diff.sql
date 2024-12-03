SET search_path = pg_catalog;

DROP TABLE public.cities_mz;

DROP TABLE public.cities_hi;

ALTER TABLE public.cities_cd
	DETACH PARTITION public.cities_cd_10_to_100;

ALTER TABLE public.cities_cd
	ATTACH PARTITION public.cities_cd_10_to_100 FOR VALUES FROM ('1') TO ('10');

ALTER TABLE public.cities
	DETACH PARTITION public.cities_fg;

ALTER TABLE public.cities
	ATTACH PARTITION public.cities_fg FOR VALUES IN ('e', 'g');

DROP FOREIGN TABLE public.f_cities_e;

ALTER FOREIGN TABLE ONLY public.ftable SET WITHOUT OIDS;

-- DEPCY: This CONSTRAINT tab_of_type_f3_check depends on the TABLE: public.tab_of_type

ALTER TABLE public.tab_of_type
	DROP CONSTRAINT tab_of_type_f3_check;

DROP TABLE public.tab_of_type;

CREATE TABLE public.tab_of_type OF public.comp (
	f1 WITH OPTIONS NOT NULL,
	f2 WITH OPTIONS DEFAULT 'text'::text,
	f3 WITH OPTIONS NOT NULL
);

ALTER TABLE public.tab_of_type OWNER TO galiev_mr;

ALTER TABLE public.cities_ab
	DROP CONSTRAINT constr_check;

CREATE TABLE public.cities_mz PARTITION OF public.cities
FOR VALUES IN ('m', 'z')
PARTITION BY RANGE (c3);

ALTER TABLE public.cities_mz OWNER TO galiev_mr;

CREATE FOREIGN TABLE public.f_cities_e PARTITION OF public.cities
FOR VALUES IN ('h', 'i')
SERVER myserver;

ALTER FOREIGN TABLE public.f_cities_e OWNER TO galiev_mr;

ALTER TABLE public.tab_of_type
	ADD CONSTRAINT tab_of_type_f3_check CHECK ((f3 > 1));

ALTER TABLE public.cities_ab
	ADD CONSTRAINT constr_check CHECK ((c1 > 10));