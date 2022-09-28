SELECT 
    oid,
    relispartition,
    pg_catalog.pg_get_partkeydef(oid) AS partition_by,
    pg_catalog.pg_get_expr(relpartbound, oid) AS partition_bound
FROM 
    pg_catalog.pg_class