CREATE SCHEMA tester;

CREATE TYPE public.custom_type AS (
    minimum integer,
    maximum integer
);

CREATE TABLE public.minmaxtest (
    a integer,
    b integer,
    id bigint
);

CREATE FUNCTION public.f(p integer) RETURNS integer
    LANGUAGE plpgsql
    AS $_$begin return $1; end;$_$;

CREATE FUNCTION public.f(s text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'int'; end;$$;

CREATE FUNCTION public.f2(p double precision) RETURNS double precision
    LANGUAGE plpgsql
    AS $$begin return 'double precision'; end;$$;

CREATE FUNCTION public.f2(p text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'text'; end;$$;

CREATE FUNCTION public.maxmin(pid integer) RETURNS public.custom_type
    LANGUAGE plpgsql
    AS $$ 
declare  
  oResult public.custom_type%rowtype; 
begin 
  select into oResult min(a) as minimum, max(b) as maximum 
  from public.minmaxtest where id = pid; 

  return oResult; 
end; 
$$;

CREATE FUNCTION public.round(p1 double precision) RETURNS text
    LANGUAGE sql
    AS $$select 'ttteexxtt'::text ;$$;

CREATE FUNCTION tester.f2(p double precision) RETURNS real
    LANGUAGE plpgsql
    AS $$begin return 'double precision'; end;$$;

CREATE FUNCTION tester.f2(p text) RETURNS integer
    LANGUAGE plpgsql
    AS $$begin return 'text'; end;$$;

CREATE TABLE public.mytable (
    col1 integer,
    col2 integer
);

CREATE VIEW public.nums_1_100 AS
 WITH RECURSIVE nums_1_100(n) AS (
         VALUES (1)
        UNION ALL
         SELECT (nums_1_100_1.n + 1)
           FROM nums_1_100 nums_1_100_1
          WHERE (nums_1_100_1.n < 100)
        )
 SELECT nums_1_100.n
   FROM nums_1_100;

CREATE VIEW public.nums_1_100_f AS
 WITH RECURSIVE nums_1_100_f(n, m) AS (
         VALUES (1,2)
        UNION ALL
         SELECT public.f((nums_1_100_f_1.n + 1)) AS f,
            (nums_1_100_f_1.m + 1)
           FROM nums_1_100_f nums_1_100_f_1
          WHERE (nums_1_100_f_1.n < 100)
        )
 SELECT nums_1_100_f.n,
    nums_1_100_f.m
   FROM nums_1_100_f;

CREATE VIEW public.myview AS
 WITH RECURSIVE aaa(col1, col2) AS (
         SELECT mytable.col1,
            mytable.col2
           FROM public.mytable
          WHERE (mytable.col1 = ANY (ARRAY[1, 2]))
        UNION
         SELECT child.col1,
            child.col2
           FROM aaa aaa_1,
            public.mytable child
          WHERE (aaa_1.col2 = child.col1)
        )
 SELECT aaa.col1,
    aaa.col2
   FROM aaa;
   
CREATE TABLE public.geo (
    id integer NOT NULL,
    parent_id integer,
    name character varying(1000)
);

CREATE VIEW public.geo_recurs AS
 WITH RECURSIVE r AS (
         SELECT geo.id,
            geo.parent_id,
            geo.name
           FROM public.geo
          WHERE (geo.parent_id = 4)
        UNION ALL
         SELECT geo_r.id,
            geo_r.parent_id,
            geo_r.name
           FROM public.geo geo_r
          WHERE (geo_r.parent_id IN ( SELECT geo.id
                   FROM public.geo))
        )
 SELECT r.name
   FROM r;

CREATE TABLE public.tablettt (
    c1 integer,
    c2 text,
    c4 text,
    c3 double precision
);

CREATE VIEW public.viewttt AS
 SELECT tablettt.c1 AS c1__integer,
    tablettt.c2 AS c2__text,
    public.f(tablettt.c1) AS func__integer,
    public.f(tablettt.c2) AS func__text,
    ( SELECT current_database() AS current_database) AS schema__name,
    ( SELECT pg_is_other_temp_schema((tablettt.c1)::oid) AS pg_is_other_temp_schema) AS is_other_temp_schema__boolean,
    public.f2((public.f(tablettt.c1))::double precision) AS func2__double,
    public.f2(public.f(tablettt.c2)) AS func2__text,
    tester.f2((public.f(tablettt.c1))::double precision) AS tester_func2__real,
    tester.f2(public.f(tablettt.c2)) AS tester_func2__integer,
    (4 / 2) AS dev__integer,
    (2.5 + (2)::numeric) AS summ__numeric,
    ((2.5)::integer + 2) AS summ__integer,
    public.f2(((1.5 + (2)::numeric))::double precision) AS funcsum__double,
    public.f(tablettt.c1) AS public_func__integer,
    public.round((7.8)::double precision) AS round__text,
    pg_catalog.round((9.8)::double precision) AS pgcatalogggg_round__double,
    (4 > 2) AS vex_op_vex__boolean,
    - ('4.3'::numeric) AS op_vex__numeric,
    (@ 4.7) AS vex_op_2__numeric,
    (32 # 2) AS operrrr__integer,
    public.maxmin(333) AS func_user_type_return__custom_type,
    ( SELECT geo_recurs.name
           FROM public.geo_recurs
         LIMIT 1) AS recurs__character_varying_1000,
    ( SELECT myview.col1
           FROM public.myview
         LIMIT 1) AS recurs_myview___integer,
    ( SELECT nums_1_100_f.n
           FROM public.nums_1_100_f
         LIMIT 1) AS recurs_nums_1_100_fn___integerr,
    ( SELECT nums_1_100_f.m
           FROM public.nums_1_100_f
         LIMIT 1) AS recurs_nums_1_100_fm___integerr,
    ( SELECT nums_1_100.n
           FROM public.nums_1_100
         LIMIT 1) AS recurs_nums_1_100___integerr
   FROM public.tablettt;

CREATE TABLE public.numeric_testtable (
  col0 serial,
  col6 smallserial,
  col7 bigserial,
  col1 int,
  col2 numeric(18,2),
  col3 numeric(18,3),
  col4 text);

CREATE VIEW public.testview1 AS
 SELECT (t1.col2 + t1.col3) as summ1,
    (t1.col0 + t1.col0) as summ2,
    (t1.col6 + t1.col6) as summ3,
    (t1.col7 + t1.col7) as summ4
   FROM public.numeric_testtable as t1;

CREATE VIEW public.testview2 AS
 SELECT concat_ws(', ', null, 12) AS t1,
   concat('abcde', 2, NULL, 22) AS t2,
   format('Hello %s, %1$s', 'World');

CREATE VIEW public.testview3 AS
 SELECT (SELECT a.a),
    (SELECT a.b)
   FROM (SELECT 1, 'test', 3) a(a, b, c);

CREATE VIEW public.testview4 AS
 SELECT (SELECT a.a),
    (SELECT a.b)
   FROM (SELECT 1 z, 'test' x, 3 c) a(a, b, c);

CREATE VIEW public.testview5 AS
 SELECT (SELECT a.z),
    (SELECT a.x)
   FROM (SELECT 1 z, 'test' x, 3 c) a;

CREATE VIEW public.testview6 AS
 SELECT (SELECT abs(a.b)) as num1,
    (SELECT lower(a.a)) as text1
   FROM (SELECT 'text' z, 2 x, 3 c) a(a, b, c);
   
CREATE TYPE public.complex AS (
    r double precision,
    i double precision
);

CREATE TYPE public.test_composite AS (
    r public.complex
);

CREATE TYPE public.test_composite1 AS (
    t public.test_composite
);

CREATE TYPE public.inventory_item AS (
    name text,
    supplier_id integer,
    price numeric,
    test public.test_composite1
);

CREATE TABLE public.on_hand (
    count integer,
    item public.inventory_item
);

CREATE VIEW public.testview AS
 SELECT item as c1,
   (item).test as c2,
   (item).test.t as c3,
   (item).test.t.r as c4,
   (item).test.t.r.r AS c5
   FROM public.on_hand;