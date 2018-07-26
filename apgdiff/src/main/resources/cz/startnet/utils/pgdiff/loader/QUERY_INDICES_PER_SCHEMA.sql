-- extension owned indices are skipped by table != null check in java code

WITH sys_schemas AS (
    SELECT n.oid
    FROM pg_catalog.pg_namespace n
    WHERE n.nspname LIKE 'pg\_%'
        OR n.nspname = 'information_schema'    
)

SELECT  cls.oid::bigint,
    cls.relname,
    clsrel.relname AS table_name,
    ind.indisunique,
    ind.indisclustered as isclustered,
    des.description AS comment,
    t.spcname AS table_space,
    pg_catalog.pg_get_indexdef(cls.oid) || ';' AS definition,
    cls.relnamespace AS schema_oid
FROM pg_catalog.pg_index ind
JOIN pg_catalog.pg_class cls ON cls.oid = ind.indexrelid
JOIN pg_catalog.pg_class clsrel ON clsrel.oid = ind.indrelid
LEFT JOIN pg_catalog.pg_tablespace t ON cls.reltablespace = t.oid 
LEFT JOIN pg_catalog.pg_description des ON ind.indexrelid = des.objoid
    AND des.objsubid = 0
LEFT JOIN pg_catalog.pg_constraint cons ON cons.conindid = ind.indexrelid
    AND cons.contype IN ('p', 'u', 'x')
WHERE cls.relkind = 'i'
    AND cls.relnamespace NOT IN (SELECT oid FROM sys_schemas)
    AND ind.indisprimary = FALSE
    AND ind.indisexclusion = FALSE
    AND cons.conindid is NULL