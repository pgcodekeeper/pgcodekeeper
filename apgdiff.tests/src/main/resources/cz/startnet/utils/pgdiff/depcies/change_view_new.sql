CREATE TABLE public.t1 (
    c1 integer,
    c2 text,
    c3 text,
    c4 integer,
    c5 integer,
    c6 text
);


ALTER TABLE public.t1 OWNER TO galiev_mr;

CREATE TABLE public.t2 (
    c1 integer,
    c2 text,
    c4 text,
    c5 date,
    c6 text
);


ALTER TABLE public.t2 OWNER TO galiev_mr;

CREATE TABLE public.t3 (
    c1 integer,
    c2 text,
    c3 text
);


ALTER TABLE public.t3 OWNER TO galiev_mr;

CREATE VIEW public.v1 AS
 SELECT t1.c1,
    t1.c2,
    t1.c3,
    t1.c4
   FROM public.t1;


ALTER TABLE public.v1 OWNER TO galiev_mr;

CREATE VIEW public.v2 AS
 SELECT t2.c1,
    t2.c2,
    t2.c4
   FROM public.t2;


ALTER TABLE public.v2 OWNER TO galiev_mr;

CREATE VIEW public.v3 AS
 SELECT t1.c1,
    t2.c2,
    t1.c6
   FROM public.t1,
    public.t2;


ALTER TABLE public.v3 OWNER TO galiev_mr;

CREATE VIEW public.v4 AS
 SELECT v1.c1,
    v3.c2,
    t1.c4
   FROM public.v1,
    public.v3,
    public.t1;


ALTER TABLE public.v4 OWNER TO galiev_mr;

CREATE VIEW public.v5 AS
 SELECT v2.c1,
    v3.c2,
    v4.c4
   FROM public.v2,
    public.v3,
    public.v4;


ALTER TABLE public.v5 OWNER TO galiev_mr;

CREATE VIEW public.v6 AS
 SELECT v2.c1,
    v2.c2,
    t1.c6
   FROM public.v2,
    public.t1;


ALTER TABLE public.v6 OWNER TO galiev_mr;

CREATE VIEW public.v7 AS
 SELECT v2.c1,
    v6.c2
   FROM public.v2,
    public.v6;


ALTER TABLE public.v7 OWNER TO galiev_mr;

CREATE VIEW public.v8 AS
 SELECT v5.c1,
    v7.c2,
    t3.c3
   FROM public.v5,
    public.v7,
    public.t3;


ALTER TABLE public.v8 OWNER TO galiev_mr;