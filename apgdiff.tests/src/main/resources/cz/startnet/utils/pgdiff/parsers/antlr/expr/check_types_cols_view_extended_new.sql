SET TIMEZONE TO 'UTC';

SET check_function_bodies = false;

CREATE SCHEMA tester;

ALTER SCHEMA tester OWNER TO shamsutdinov_lr;

SET search_path = tester, pg_catalog;

CREATE OR REPLACE FUNCTION f2(p double precision) RETURNS real
    LANGUAGE plpgsql
    AS $$begin return 'double precision'; end;$$;

ALTER FUNCTION f2(p double precision) OWNER TO shamsutdinov_lr;

CREATE OR REPLACE FUNCTION f2(p text) RETURNS integer
    LANGUAGE plpgsql
    AS $$begin return 'text'; end;$$;

ALTER FUNCTION f2(p text) OWNER TO shamsutdinov_lr;

--------------------------------------------------------------------------------
--------------------------------------------------------------------------------

SET search_path = public, pg_catalog;

CREATE OR REPLACE FUNCTION f(p integer) RETURNS integer
    LANGUAGE plpgsql
    AS $_$begin return $1; end;$_$;

ALTER FUNCTION f(p integer) OWNER TO shamsutdinov_lr;

CREATE OR REPLACE FUNCTION f(s text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'int'; end;$$;

ALTER FUNCTION f(s text) OWNER TO shamsutdinov_lr;

CREATE OR REPLACE FUNCTION f2(p double precision) RETURNS double precision
    LANGUAGE plpgsql
    AS $$begin return 'double precision'; end;$$;

ALTER FUNCTION f2(p double precision) OWNER TO shamsutdinov_lr;

CREATE OR REPLACE FUNCTION f2(p text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'text'; end;$$;

ALTER FUNCTION f2(p text) OWNER TO shamsutdinov_lr;

CREATE OR REPLACE FUNCTION round(p1 double precision) RETURNS text
    LANGUAGE sql
    AS $$select 'ttteexxtt'::text ;$$;

ALTER FUNCTION round(p1 double precision) OWNER TO shamsutdinov_lr;

CREATE OR REPLACE FUNCTION maxmin(pid integer) RETURNS custom_type
    LANGUAGE plpgsql
    AS $$ 
declare  
  oResult custom_type%rowtype; 
begin 
  select into oResult min(a) as minimum, max(b) as maximum 
  from test where id = pid; 

  return oResult; 
end; 
$$;

ALTER FUNCTION maxmin(pid integer) OWNER TO shamsutdinov_lr;

--------------------------------------------------------------------------------

CREATE TYPE custom_type AS (
    minimum integer,
    maximum integer
);

ALTER TYPE custom_type OWNER TO shamsutdinov_lr;

--------------------------------------------------------------------------------

CREATE TABLE tablettt (
    c1 integer,
    c2 text,
    c4 text,
    c3 double precision
);

ALTER TABLE tablettt OWNER TO shamsutdinov_lr;

CREATE TABLE geo (
    id integer NOT NULL,
    parent_id integer,
    name character varying(1000)
);

ALTER TABLE geo OWNER TO shamsutdinov_lr;

CREATE TABLE mytable (
    col1 integer,
    col2 integer
);

ALTER TABLE mytable OWNER TO shamsutdinov_lr;

--------------------------------------------------------------------------------

CREATE VIEW nums_1_100 AS
    WITH RECURSIVE nums_1_100(n) AS (
         VALUES (1)
        UNION ALL
         SELECT (nums_1_100_1.n + 1)
           FROM nums_1_100 nums_1_100_1
          WHERE (nums_1_100_1.n < 100)
        )
 SELECT nums_1_100.n
   FROM nums_1_100;

ALTER VIEW nums_1_100 OWNER TO shamsutdinov_lr;

CREATE VIEW nums_1_100_f AS
    WITH RECURSIVE nums_1_100_f(n, m) AS (
         VALUES (1,2)
        UNION ALL
         SELECT f((nums_1_100_f_1.n + 1)) AS f,
            (nums_1_100_f_1.m + 1)
           FROM nums_1_100_f nums_1_100_f_1
          WHERE (nums_1_100_f_1.n < 100)
        )
 SELECT nums_1_100_f.n,
    nums_1_100_f.m
   FROM nums_1_100_f;

ALTER VIEW nums_1_100_f OWNER TO shamsutdinov_lr;

CREATE VIEW myview AS
    WITH RECURSIVE aaa(col1, col2) AS (
         SELECT mytable.col1,
            mytable.col2
           FROM mytable
          WHERE (mytable.col1 = ANY (ARRAY[1, 2]))
        UNION
         SELECT child.col1,
            child.col2
           FROM aaa aaa_1,
            mytable child
          WHERE (aaa_1.col2 = child.col1)
        )
 SELECT aaa.col1,
    aaa.col2
   FROM aaa;

ALTER VIEW myview OWNER TO shamsutdinov_lr;

CREATE VIEW geo_recurs AS
    WITH RECURSIVE r AS (
         SELECT geo.id,
            geo.parent_id,
            geo.name
           FROM geo
          WHERE (geo.parent_id = 4)
        UNION ALL
         SELECT geo_r.id,
            geo_r.parent_id,
            geo_r.name
           FROM geo geo_r
          WHERE (geo_r.parent_id IN ( SELECT geo.id
                   FROM geo))
        )
 SELECT r.name
   FROM r;

ALTER VIEW geo_recurs OWNER TO shamsutdinov_lr;

CREATE VIEW viewttt AS
    SELECT tablettt.c1 AS c1__integer,
    tablettt.c2 AS c2__text,
    f(tablettt.c1) AS func__integer,
    f(tablettt.c2) AS func__text,
    ( SELECT current_database() AS current_database) AS schema__name,
    ( SELECT pg_is_other_temp_schema((tablettt.c1)::oid) AS pg_is_other_temp_schema) AS is_other_temp_schema__boolean,
    f2((f(tablettt.c1))::double precision) AS func2__double,
    f2(f(tablettt.c2)) AS func2__text,
    tester.f2((f(tablettt.c1))::double precision) AS tester_func2__real,
    tester.f2(f(tablettt.c2)) AS tester_func2__integer,
    (4 / 2) AS dev__integer,
    (2.5 + (2)::numeric) AS summ__numeric,
    ((2.5)::integer + 2) AS summ__integer,
    f2(((1.5 + (2)::numeric))::double precision) AS funcsum__double,
    f(tablettt.c1) AS public_func__integer,
    round((7.8)::double precision) AS round__text,
    pg_catalog.round((9.8)::double precision) AS pgcatalogggg_round__double,
    (4 > 2) AS vex_op_vex__boolean,
    - ('4.3'::numeric) AS op_vex__numeric,
    ((4.7)::bigint !) AS vex_op__numeric,
    (@ 4.7) AS vex_op_2__numeric,
    (32 # 2) AS operrrr__integer,
    maxmin(333) AS func_user_type_return__custom_type,
    ( SELECT geo_recurs.name
           FROM geo_recurs
         LIMIT 1) AS recurs__character_varying_1000,
    ( SELECT myview.col1
           FROM myview
         LIMIT 1) AS recurs_myview___integer,
    ( SELECT nums_1_100_f.n
           FROM nums_1_100_f
         LIMIT 1) AS recurs_nums_1_100_fn___integerr,
    ( SELECT nums_1_100_f.m
           FROM nums_1_100_f
         LIMIT 1) AS recurs_nums_1_100_fm___integerr,
    ( SELECT nums_1_100.n
           FROM nums_1_100
         LIMIT 1) AS recurs_nums_1_100___integerr
   FROM tablettt;

ALTER VIEW viewttt OWNER TO shamsutdinov_lr;