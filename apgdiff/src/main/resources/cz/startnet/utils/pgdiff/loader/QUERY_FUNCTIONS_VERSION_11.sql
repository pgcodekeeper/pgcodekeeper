SELECT  p.oid::bigint,
        p.prokind = 'w' AS proiswindow,
        p.prokind IN ('a', 'p') AS proisspecial
FROM pg_catalog.pg_proc p