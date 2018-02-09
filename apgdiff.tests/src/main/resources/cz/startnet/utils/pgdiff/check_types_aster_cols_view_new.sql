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
    SELECT *, 111 AS myvalue FROM mytable
    )
    SELECT * FROM 
        tablettt t, 
        users u,
        mmyytable mt,
        (SELECT * FROM one1 LIMIT 1) a,
        (SELECT * FROM one2 LIMIT 1) b;

ALTER VIEW asterisk OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk1 AS
    SELECT tablettt.*, users.*
   FROM tablettt, users;

ALTER VIEW asterisk1 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk2 AS
    SELECT t.*, u.*
   FROM tablettt t, users u;

ALTER VIEW asterisk2 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk3 AS
    SELECT *
   FROM 
   f(3);

ALTER VIEW asterisk3 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk4 AS
    SELECT d.*, t.*
   FROM 
   f(3) d, f('txt') t;

ALTER VIEW asterisk4 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk5 AS
    SELECT d.*
   FROM 
   dup3(3) d;

ALTER VIEW asterisk5 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk6 AS
    SELECT *
   FROM 
   dup3(3);

ALTER VIEW asterisk6 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk7 AS
    SELECT q.*
   FROM (SELECT t.*, u.* FROM tablettt t, users u) q;

ALTER VIEW asterisk7 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk8 AS
    SELECT
        (SELECT * FROM one1 LIMIT 1) AS onee,
        (SELECT * FROM one2 LIMIT 1) AS twoo;

ALTER VIEW asterisk8 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk9 AS
    SELECT
        (SELECT * FROM one1 LIMIT 1),
        (SELECT * FROM one2 LIMIT 1);

ALTER VIEW asterisk9 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk10 AS
        SELECT s.* FROM one1 s LIMIT 1;

ALTER VIEW asterisk10 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk11 AS
    SELECT * FROM
        (SELECT * FROM one1 LIMIT 1) a,
        (SELECT * FROM one2 LIMIT 1) b;

ALTER VIEW asterisk11 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk12 AS
    select * from (select * from table_inherits) r;

ALTER VIEW asterisk12 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk13 AS
    select * from pg_cast;

ALTER VIEW asterisk13 OWNER TO shamsutdinov_lr;

CREATE VIEW asterisk14 AS
    select * from version();

ALTER VIEW asterisk14 OWNER TO shamsutdinov_lr;