SET TIMEZONE TO 'UTC';

SET check_function_bodies = false;

SET search_path = public, pg_catalog;

CREATE OR REPLACE FUNCTION dup3(integer) RETURNS TABLE(f1 integer, f2 double precision)
    LANGUAGE sql
    AS $_$ SELECT $1, $1::double precision $_$;

ALTER FUNCTION dup3(integer) OWNER TO shamsutdinov_lr;

CREATE OR REPLACE FUNCTION f(p integer) RETURNS integer
    LANGUAGE plpgsql
    AS $_$begin return $1; end;$_$;

ALTER FUNCTION f(p integer) OWNER TO shamsutdinov_lr;

CREATE OR REPLACE FUNCTION f(s text) RETURNS text
    LANGUAGE plpgsql
    AS $$begin return 'textttt'; end;$$;

ALTER FUNCTION f(s text) OWNER TO shamsutdinov_lr;

--------------------------------------------------------------------------------

CREATE TABLE tablettt (
    c1 integer,
    c2 text,
    c4 text,
    c3 double precision
);

ALTER TABLE tablettt OWNER TO shamsutdinov_lr;

CREATE TABLE table_inherits (
    own_column integer
) INHERITS (tablettt);

ALTER TABLE table_inherits OWNER TO shamsutdinov_lr;

CREATE TABLE users (
    id integer,
    login character(64),
    password character(64)
);

ALTER TABLE users OWNER TO shamsutdinov_lr;

CREATE TABLE one1 (
    col11 text
);

ALTER TABLE one1 OWNER TO shamsutdinov_lr;

CREATE TABLE one2 (
    col22 integer
);

ALTER TABLE one2 OWNER TO shamsutdinov_lr;

CREATE TABLE mytable (
    col111 integer,
    col222 integer
);

ALTER TABLE mytable OWNER TO shamsutdinov_lr;

--------------------------------------------------------------------------------

CREATE VIEW asterisk AS
    WITH mmyytable AS (
         SELECT mytable.col111,
            mytable.col222,
            111 AS myvalue
           FROM mytable
        )
 SELECT t.c1,
    t.c2,
    t.c4,
    t.c3,
    u.id,
    u.login,
    u.password,
    mt.col111,
    mt.col222,
    mt.myvalue,
    a.col11,
    b.col22
   FROM tablettt t,
    users u,
    mmyytable mt,
    ( SELECT one1.col11
           FROM one1
         LIMIT 1) a,
    ( SELECT one2.col22
           FROM one2
         LIMIT 1) b;

ALTER VIEW asterisk OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk1 AS
    SELECT tablettt.c1,
    tablettt.c2,
    tablettt.c4,
    tablettt.c3,
    users.id,
    users.login,
    users.password
   FROM tablettt,
    users;

ALTER VIEW asterisk1 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk2 AS
    SELECT t.c1,
    t.c2,
    t.c4,
    t.c3,
    u.id,
    u.login,
    u.password
   FROM tablettt t,
    users u;

ALTER VIEW asterisk2 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk3 AS
    SELECT f.f
   FROM f(3) f(f);

ALTER VIEW asterisk3 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk4 AS
    SELECT d.d,
    t.t
   FROM f(3) d(d),
    f('txt'::text) t(t);

ALTER VIEW asterisk4 OWNER TO shamsutdinov_lr;

/* 
TODO for realize in future

CREATE VIEW asterisk5 AS
    SELECT d.f1,
    d.f2
   FROM dup3(3) d(f1, f2);

ALTER VIEW asterisk5 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk6 AS
    SELECT dup3.f1,
    dup3.f2
   FROM dup3(3) dup3(f1, f2);

ALTER VIEW asterisk6 OWNER TO shamsutdinov_lr;
*/

CREATE VIEW asterisk7 AS
    SELECT q.c1,
    q.c2,
    q.c4,
    q.c3,
    q.id,
    q.login,
    q.password
   FROM ( SELECT t.c1,
            t.c2,
            t.c4,
            t.c3,
            u.id,
            u.login,
            u.password
           FROM tablettt t,
            users u) q;

ALTER VIEW asterisk7 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk8 AS
    SELECT ( SELECT one1.col11
           FROM one1
         LIMIT 1) AS onee,
    ( SELECT one2.col22
           FROM one2
         LIMIT 1) AS twoo;

ALTER VIEW asterisk8 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk9 AS
    SELECT ( SELECT one1.col11
           FROM one1
         LIMIT 1) AS col11,
    ( SELECT one2.col22
           FROM one2
         LIMIT 1) AS col22;

ALTER VIEW asterisk9 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk10 AS
    SELECT s.col11 FROM one1 s LIMIT 1;

ALTER VIEW asterisk10 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk11 AS
    SELECT a.col11,
    b.col22
   FROM ( SELECT one1.col11
           FROM one1
         LIMIT 1) a,
    ( SELECT one2.col22
           FROM one2
         LIMIT 1) b;

ALTER VIEW asterisk11 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk12 AS
    SELECT r.c1,
    r.c2,
    r.c4,
    r.c3,
    r.own_column
   FROM ( SELECT table_inherits.c1,
            table_inherits.c2,
            table_inherits.c4,
            table_inherits.c3,
            table_inherits.own_column
           FROM table_inherits) r;

ALTER VIEW asterisk12 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk13 AS
    SELECT pg_cast.castsource,
    pg_cast.casttarget,
    pg_cast.castfunc,
    pg_cast.castcontext,
    pg_cast.castmethod
   FROM pg_cast;

ALTER VIEW asterisk13 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk14 AS
    SELECT version.version
   FROM version() version(version);

ALTER VIEW asterisk14 OWNER TO shamsutdinov_lr;