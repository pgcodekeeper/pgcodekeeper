CREATE TABLE public.testtable (
    a           int2[],
    b           int4[][][],
    c           name[],
    d           text[][],
    e           float8[],
    f           char(5)[],
    g           varchar(5)[]
);
  
  CREATE FUNCTION public.f2(_id_base text, _number anyelement, _need_confirm integer) RETURNS anyelement
    LANGUAGE plpgsql
    AS $_$ begin return _number; end;$_$;

CREATE VIEW public.testview1 AS
 SELECT *
 FROM public.testtable;

CREATE VIEW public.testview2 AS
 SELECT q.a[1],
          q.b[1][1][1],
          q.c[1],
          q.d[1][1],
          q.e[0]
   FROM public.testtable q;

CREATE VIEW public.testview3 AS
 SELECT a[1:3],
          b[1:1][1:2][1:2],
          c[1:2],
          d[1:1][1:2]
   FROM public.testtable;

CREATE VIEW public.testview4 AS   
   SELECT array_dims(a) AS a,array_dims(b) AS b,array_dims(c) AS c
   FROM public.testtable;

CREATE VIEW public.testview5 AS
 select array_agg(distinct ar order by ar desc)
  from (select array[i / 2] from generate_series(1,10) a(i)) b(ar);

 CREATE VIEW public.testview6 AS
 SELECT * FROM public.f2(null, '123', 1);

 CREATE VIEW public.testview7 AS
  SELECT * FROM public.f2('text', 90, 3::anyelement);
