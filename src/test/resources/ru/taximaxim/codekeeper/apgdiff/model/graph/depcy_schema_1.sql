CREATE TABLE t1 (
    c1 boolean,
    c2 boolean
);

CREATE TABLE t2 (
    c1 boolean,
    c2 boolean
);

ALTER TABLE public.t1 OWNER TO ryabinin_av;


CREATE VIEW v2 AS
 SELECT a.c1
   FROM t1 a;

ALTER TABLE public.v2 OWNER TO ryabinin_av;


CREATE VIEW v1 AS
 SELECT a.c1
   FROM v2 a;

ALTER TABLE public.v1 OWNER TO ryabinin_av;
