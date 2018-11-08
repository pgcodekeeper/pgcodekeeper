SELECT  p.oid::bigint,
        p.proiswindow,
        p.proisagg
FROM pg_catalog.pg_proc p