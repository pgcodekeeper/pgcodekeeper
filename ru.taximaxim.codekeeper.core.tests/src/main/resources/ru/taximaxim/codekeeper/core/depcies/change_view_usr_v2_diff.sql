SET search_path = pg_catalog;

-- DEPCY: This VIEW v8 depends on the VIEW: public.v2

DROP VIEW public.v8;

-- DEPCY: This VIEW v7 depends on the VIEW: public.v2

DROP VIEW public.v7;

-- DEPCY: This VIEW v6 depends on the VIEW: public.v2

DROP VIEW public.v6;

-- DEPCY: This VIEW v5 depends on the VIEW: public.v2

DROP VIEW public.v5;

DROP VIEW public.v2;

CREATE TABLE public.t3 (
	c1 integer,
	c2 text,
	c3 text
);

ALTER TABLE public.t3 OWNER TO galiev_mr;

-- DEPCY: This COLUMN c6 is a dependency of VIEW: public.v8

ALTER TABLE public.t1
	ADD COLUMN c6 text;

CREATE VIEW public.v2 AS
	SELECT t2.c1,
    t2.c2,
    t2.c4
   FROM public.t2;

ALTER VIEW public.v2 OWNER TO galiev_mr;

CREATE VIEW public.v6 AS
	SELECT v2.c1,
    v2.c2,
    t1.c6
   FROM public.v2,
    public.t1;

ALTER VIEW public.v6 OWNER TO galiev_mr;

CREATE VIEW public.v7 AS
	SELECT v2.c1,
    v6.c2
   FROM public.v2,
    public.v6;

ALTER VIEW public.v7 OWNER TO galiev_mr;

-- DEPCY: This VIEW v4 depends on the COLUMN: public.t1.c4

DROP VIEW public.v4;

-- DEPCY: This VIEW v1 depends on the COLUMN: public.t1.c4

DROP VIEW public.v1;

ALTER TABLE public.t1
	ALTER COLUMN c4 TYPE integer USING c4::integer; /* TYPE change - table: public.t1 original: text new: integer */

-- DEPCY: This VIEW v3 depends on the VIEW: public.v8

DROP VIEW public.v3;

-- DEPCY: This VIEW v3 is a dependency of VIEW: public.v8

CREATE VIEW public.v3 AS
	SELECT t1.c1,
    t2.c2,
    t1.c6
   FROM public.t1,
    public.t2;

ALTER VIEW public.v3 OWNER TO galiev_mr;

CREATE VIEW public.v1 AS
	SELECT t1.c1,
    t1.c2,
    t1.c3,
    t1.c4
   FROM public.t1;

ALTER VIEW public.v1 OWNER TO galiev_mr;

CREATE VIEW public.v4 AS
	SELECT v1.c1,
    v3.c2,
    t1.c4
   FROM public.v1,
    public.v3,
    public.t1;

ALTER VIEW public.v4 OWNER TO galiev_mr;

CREATE VIEW public.v5 AS
	SELECT v2.c1,
    v3.c2,
    v4.c4
   FROM public.v2,
    public.v3,
    public.v4;

ALTER VIEW public.v5 OWNER TO galiev_mr;

CREATE VIEW public.v8 AS
	SELECT v5.c1,
    v7.c2,
    t3.c3
   FROM public.v5,
    public.v7,
    public.t3;

ALTER VIEW public.v8 OWNER TO galiev_mr;