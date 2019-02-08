CREATE TABLE public.tablettt (
    c1 integer,
    c2 text,
    c3 double precision,
    c4 text
);

ALTER TABLE public.tablettt OWNER TO shamsutdinov_lr;

CREATE TABLE public.mytable (
    col111 integer,
    col222 integer,
    col333 text
);

ALTER TABLE public.mytable OWNER TO shamsutdinov_lr;

CREATE TABLE public.users (
    id integer,
    login character(64),
    password character(64)
);

ALTER TABLE public.users OWNER TO shamsutdinov_lr;

--------------------------------------------------------------------------------

CREATE VIEW public.tableless_view1 AS
    SELECT col222, col333 
   FROM public.tablettt t 
     JOIN public.mytable m ON (m.col111 = t.c1);

ALTER VIEW public.tableless_view1 OWNER TO shamsutdinov_lr;

CREATE VIEW public.tableless_view2 AS
    SELECT col222, col333, c3 
   FROM (SELECT c1, c3 FROM public.tablettt) t 
     JOIN public.mytable m on (m.col111 = t.c1);

ALTER VIEW public.tableless_view2 OWNER TO shamsutdinov_lr;

CREATE VIEW public.tableless_view3 AS
    WITH usr_tbl AS (
        SELECT id, login AS lgn, password
        FROM public.users
     ), usr_tbl_light AS (
        SELECT id, lgn
        FROM usr_tbl)
SELECT col222, col333, c3 , lgn
   FROM (SELECT c1, c3 FROM public.tablettt) t 
     JOIN public.mytable m on (m.col111 = t.c1)
     JOIN usr_tbl_light utl on (m.col111 = utl.id);

ALTER VIEW public.tableless_view3 OWNER TO shamsutdinov_lr;

CREATE VIEW public.tableless_system_view AS 
    select relacl, nspname from pg_class c join pg_namespace n on (n.oid = c.relnamespace) limit 1;

ALTER VIEW public.tableless_system_view OWNER TO shamsutdinov_lr;