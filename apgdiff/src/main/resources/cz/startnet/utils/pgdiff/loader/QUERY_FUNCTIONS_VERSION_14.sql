SELECT
    p.oid::bigint,
    pg_get_function_sqlbody(p.oid) AS prosqlbody
FROM
    pg_catalog.pg_proc p