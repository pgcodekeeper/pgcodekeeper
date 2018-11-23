SELECT  p.oid::bigint,
        p.prokind = 'a' AS proisagg
FROM pg_catalog.pg_proc p