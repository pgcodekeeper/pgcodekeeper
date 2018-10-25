SELECT  p.oid::bigint,
        p.proiswindow,
        p.proisagg AS proisspecial
FROM pg_catalog.pg_proc p