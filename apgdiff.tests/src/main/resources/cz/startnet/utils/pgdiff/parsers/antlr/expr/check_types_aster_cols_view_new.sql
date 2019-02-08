CREATE OR REPLACE FUNCTION public.dup3(integer) RETURNS TABLE(f1 integer, f2 double precision)
    LANGUAGE sql
    AS $_$ SELECT $1, $1::double precision $_$;

ALTER FUNCTION public.dup3(integer) OWNER TO shamsutdinov_lr;

CREATE OR REPLACE FUNCTION public.f(p integer) RETURNS integer
    LANGUAGE plpgsql
    AS $_$begin return $1; end;$_$;

ALTER FUNCTION public.f(p integer) OWNER TO shamsutdinov_lr;

CREATE OR REPLACE FUNCTION public.f(s text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'textttt'; end;$$;

ALTER FUNCTION public.f(s text) OWNER TO shamsutdinov_lr;

--------------------------------------------------------------------------------

CREATE TABLE public.tablettt (
    c1 integer,
    c2 text,
    c3 double precision,
    c4 text
);

ALTER TABLE public.tablettt OWNER TO shamsutdinov_lr;

CREATE TABLE public.table_inherits (
    own_column integer
) INHERITS (public.tablettt);

ALTER TABLE public.table_inherits OWNER TO shamsutdinov_lr;

CREATE TABLE public.users (
    id integer,
    login character(64),
    password character(64)
);

ALTER TABLE public.users OWNER TO shamsutdinov_lr;

CREATE TABLE public.one1 (
    col11 text
);

ALTER TABLE public.one1 OWNER TO shamsutdinov_lr;

CREATE TABLE public.one2 (
    col22 integer
);

ALTER TABLE public.one2 OWNER TO shamsutdinov_lr;

CREATE TABLE public.mytable (
    col111 integer,
    col222 integer
);

ALTER TABLE public.mytable OWNER TO shamsutdinov_lr;
    
--------------------------------------------------------------------------------

CREATE VIEW public.asterisk AS
    WITH mmyytable AS (
    SELECT *, 111 AS myvalue FROM public.mytable
    )
    SELECT * FROM 
        public.tablettt t, 
        public.users u,
        mmyytable mt,
        (SELECT * FROM public.one1 LIMIT 1) a,
        (SELECT * FROM public.one2 LIMIT 1) b;

ALTER VIEW public.asterisk OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk1 AS
    SELECT tablettt.*, users.*
   FROM public.tablettt, public.users;

ALTER VIEW public.asterisk1 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk2 AS
    SELECT t.*, u.*
   FROM public.tablettt t, public.users u;

ALTER VIEW public.asterisk2 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk3 AS
    SELECT *
   FROM 
   public.f(3);

ALTER VIEW public.asterisk3 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk4 AS
    SELECT d.*, t.*
   FROM 
   public.f(3) d, public.f('txt') t;

ALTER VIEW public.asterisk4 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk5 AS
    SELECT d.*
   FROM 
   public.dup3(3) d;

ALTER VIEW public.asterisk5 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk6 AS
    SELECT *
   FROM 
   public.dup3(3);

ALTER VIEW public.asterisk6 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk7 AS
    SELECT q.*
   FROM (SELECT t.*, u.* FROM public.tablettt t, public.users u) q;

ALTER VIEW public.asterisk7 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk8 AS
    SELECT
        (SELECT * FROM public.one1 LIMIT 1) AS onee,
        (SELECT * FROM public.one2 LIMIT 1) AS twoo;

ALTER VIEW public.asterisk8 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk9 AS
    SELECT
        (SELECT * FROM public.one1 LIMIT 1),
        (SELECT * FROM public.one2 LIMIT 1);

ALTER VIEW public.asterisk9 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk10 AS
        SELECT s.* FROM public.one1 s LIMIT 1;

ALTER VIEW public.asterisk10 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk11 AS
    SELECT * FROM
        (SELECT * FROM public.one1 LIMIT 1) a,
        (SELECT * FROM public.one2 LIMIT 1) b;

ALTER VIEW public.asterisk11 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk12 AS
    select * from (select * from public.table_inherits) r;

ALTER VIEW public.asterisk12 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk13 AS
    select * from pg_cast;

ALTER VIEW public.asterisk13 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk14 AS
    select * from version();

ALTER VIEW public.asterisk14 OWNER TO shamsutdinov_lr;

CREATE VIEW public.asterisk15 AS
    SELECT
    (select count(*) from public.tablettt) as qqq,
    (select to_json(d.*) from public.tablettt d) as www;

ALTER VIEW public.asterisk15 OWNER TO shamsutdinov_lr;