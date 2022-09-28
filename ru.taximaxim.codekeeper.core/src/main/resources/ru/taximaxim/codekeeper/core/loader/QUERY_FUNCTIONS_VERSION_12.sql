SELECT
    p.oid::bigint,
    p.prosupport AS support_func
FROM
    pg_catalog.pg_proc p