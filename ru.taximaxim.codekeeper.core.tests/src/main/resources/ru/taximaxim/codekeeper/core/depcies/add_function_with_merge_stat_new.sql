CREATE TABLE public.target (
    t1 integer,
    t2 integer,
    t3 integer
);

CREATE TABLE public.source (
    s1 integer,
    s2 integer,
    s3 integer
);

CREATE OR REPLACE FUNCTION public.func1() RETURNS bigint
    LANGUAGE plpgsql
    AS $$ begin
    SELECT 1;
    end $$;

CREATE OR REPLACE FUNCTION public.func() RETURNS setof text LANGUAGE plpgsql AS $$
BEGIN
--testing table deps
MERGE INTO public.target t
USING public.source AS s
ON t1.tid = s1.sid
WHEN NOT MATCHED THEN
    INSERT VALUES (s.sid, s.delta);
SELECT * FROM target ORDER BY tid;

--testing function deps
MERGE INTO request_app_names AS dest
USING public.func1() AS source(val)
ON (dest.request_app_name = source.val)
WHEN NOT MATCHED THEN
    INSERT (request_app_name)
    VALUES (source.val);
END
$$;
