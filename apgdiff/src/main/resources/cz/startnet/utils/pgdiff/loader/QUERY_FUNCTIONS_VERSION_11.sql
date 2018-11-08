SELECT  p.oid::bigint,
        p.prokind = 'w' AS proiswindow,
        p.prokind = 'a' AS proisagg,
        p.prokind = 'p' AS proisproc
FROM pg_catalog.pg_proc p