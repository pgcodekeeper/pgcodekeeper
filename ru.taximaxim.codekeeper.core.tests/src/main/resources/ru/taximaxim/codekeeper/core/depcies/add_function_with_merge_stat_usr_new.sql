CREATE OR REPLACE FUNCTION public.func() RETURNS setof text LANGUAGE plpgsql AS $$
BEGIN
--test table deps
MERGE INTO public.target t
USING public.source AS s
ON t1.tid = s1.sid
WHEN NOT MATCHED THEN
    INSERT VALUES (s.sid, s.delta);
SELECT * FROM target ORDER BY tid;

--test function deps
MERGE INTO request_app_names AS dest
USING public.func1() AS source(val)
ON (dest.request_app_name = source.val)
WHEN NOT MATCHED THEN
    INSERT (request_app_name)
    VALUES (source.val);
END
$$;