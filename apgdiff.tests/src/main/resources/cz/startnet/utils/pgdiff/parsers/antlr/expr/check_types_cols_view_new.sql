CREATE FUNCTION public.dup3(integer) RETURNS TABLE(f1 integer, f2 double precision)
    LANGUAGE sql
    AS $_$ SELECT $1, $1::double precision $_$;

CREATE FUNCTION public.f(p integer) RETURNS integer
    LANGUAGE plpgsql
    AS $_$begin return $1; end;$_$;

CREATE FUNCTION public.f(s text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'textttt'; end;$$;

CREATE TABLE public.mytable (
    col111 integer,
    col222 integer
);

CREATE TABLE public.one1 (
    col11 text
);

CREATE TABLE public.one2 (
    col22 integer
);

CREATE TABLE public.tablettt (
    c1 integer,
    c2 text,
    c3 double precision,
    c4 text
);

CREATE TABLE public.users (
    id integer,
    login character(64),
    password character(64)
);

CREATE VIEW public.asterisk AS
 WITH mmyytable AS (
         SELECT mytable.col111,
            mytable.col222,
            111 AS myvalue
           FROM public.mytable
        )
 SELECT t.c1,
    t.c2,
    t.c3,
    t.c4,
    u.id,
    u.login,
    u.password,
    mt.col111,
    mt.col222,
    mt.myvalue,
    a.col11,
    b.col22
   FROM public.tablettt t,
    public.users u,
    mmyytable mt,
    ( SELECT one1.col11
           FROM public.one1
         LIMIT 1) a,
    ( SELECT one2.col22
           FROM public.one2
         LIMIT 1) b;

CREATE VIEW public.asterisk1 AS
 SELECT tablettt.c1,
    tablettt.c2,
    tablettt.c3,
    tablettt.c4,
    users.id,
    users.login,
    users.password
   FROM public.tablettt,
    public.users;


CREATE VIEW public.asterisk2 AS
 SELECT t.c1,
    t.c2,
    t.c3,
    t.c4,
    u.id,
    u.login,
    u.password
   FROM public.tablettt t,
    public.users u;

CREATE VIEW public.asterisk3 AS
 SELECT f.f
   FROM public.f(3) f(f);

CREATE VIEW public.asterisk4 AS
 SELECT d.d,
    t.t
   FROM public.f(3) d(d),
    public.f('txt'::text) t(t);

/*
TODO for realize in future

CREATE VIEW public.asterisk5 AS
    SELECT d.f1,
    d.f2
   FROM public.dup3(3) d(f1, f2);

CREATE VIEW public.asterisk6 AS
    SELECT dup3.f1,
    dup3.f2
   FROM public.dup3(3) dup3(f1, f2);
*/

CREATE VIEW public.asterisk7 AS
 SELECT q.c1,
    q.c2,
    q.c3,
    q.c4,
    q.id,
    q.login,
    q.password
   FROM ( SELECT t.c1,
            t.c2,
            t.c3,
            t.c4,
            u.id,
            u.login,
            u.password
           FROM public.tablettt t,
            public.users u) q;

CREATE VIEW public.asterisk8 AS
 SELECT ( SELECT one1.col11
           FROM public.one1
         LIMIT 1) AS onee,
    ( SELECT one2.col22
           FROM public.one2
         LIMIT 1) AS twoo;

CREATE VIEW public.asterisk9 AS
 SELECT ( SELECT one1.col11
           FROM public.one1
         LIMIT 1) AS col11,
    ( SELECT one2.col22
           FROM public.one2
         LIMIT 1) AS col22;

CREATE VIEW public.asterisk10 AS
 SELECT s.col11
   FROM public.one1 s
 LIMIT 1;

CREATE VIEW public.asterisk11 AS
 SELECT a.col11,
    b.col22
   FROM ( SELECT one1.col11
           FROM public.one1
         LIMIT 1) a,
    ( SELECT one2.col22
           FROM public.one2
         LIMIT 1) b;

CREATE TABLE public.table_inherits (
    own_column integer
)
INHERITS (public.tablettt);

CREATE VIEW public.asterisk12 AS
 SELECT r.c1,
    r.c2,
    r.c3,
    r.c4,
    r.own_column
   FROM ( SELECT table_inherits.c1,
            table_inherits.c2,
            table_inherits.c4,
            table_inherits.c3,
            table_inherits.own_column
           FROM public.table_inherits) r;

CREATE VIEW public.asterisk13 AS
 SELECT pg_cast.castsource,
    pg_cast.casttarget,
    pg_cast.castfunc,
    pg_cast.castcontext,
    pg_cast.castmethod
   FROM pg_cast;

CREATE VIEW public.asterisk14 AS
 SELECT version.version
   FROM version() version(version);

CREATE VIEW public.asterisk15 AS
 SELECT ( SELECT count(*) AS count
           FROM public.tablettt) AS qqq,
    ( SELECT to_json(d.*) AS to_json
           FROM public.tablettt d) AS www;

CREATE VIEW public.lateral_access AS
  SELECT first.c1 AS c1_int,
       second.c1 AS c1_text,
       second.c1_int_nested AS c1_int_nested
  FROM
    (SELECT 1 c1) first,
    LATERAL 
    (SELECT first.c1,
            second.c1_int_nested
     FROM
       (SELECT 'text' c1) first,
       (SELECT first.c1 c1_int_nested) second) second;
