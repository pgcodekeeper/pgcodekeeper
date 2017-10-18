SELECT 
    oid,
    pg_get_partkeydef(oid) AS partition_by
FROM 
    pg_catalog.pg_class