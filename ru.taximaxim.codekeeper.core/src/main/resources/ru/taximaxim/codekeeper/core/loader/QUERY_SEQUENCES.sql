WITH sys_schemas AS (
    SELECT n.oid
    FROM pg_catalog.pg_namespace n
    WHERE n.nspname LIKE 'pg\_%'
        OR n.nspname = 'information_schema'    
), extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE dep.classid = 'pg_catalog.pg_class'::pg_catalog.regclass
        AND dep.deptype = 'e'
)

SELECT s.seqrelid AS oid,
       s.seqtypid::bigint AS data_type,
       s.seqstart, 
       s.seqincrement, 
       s.seqmax, 
       s.seqmin, 
       s.seqcache, 
       s.seqcycle,
       a.attidentity,
       c.relowner::bigint,
       c.relname,
       c.relpersistence,
       descr.description AS comment,
       -- always in the same schema
       (SELECT t.relname FROM pg_catalog.pg_class t WHERE t.oid=d.refobjid) referenced_table_name,
       a.attname AS ref_col_name,
       c.relacl::text AS aclarray,
       c.relnamespace AS schema_oid
FROM pg_catalog.pg_sequence s
LEFT JOIN pg_catalog.pg_class c ON c.oid = s.seqrelid
LEFT JOIN pg_catalog.pg_depend d ON d.classid = c.tableoid
    AND d.objid = c.oid
    AND d.objsubid = 0
    AND d.refclassid = c.tableoid
    AND d.refobjsubid != 0
    AND d.deptype IN ('i', 'a')
LEFT JOIN pg_catalog.pg_description descr ON c.oid = descr.objoid 
    AND descr.classoid = 'pg_catalog.pg_class'::pg_catalog.regclass
    AND descr.objsubid = 0
LEFT JOIN pg_catalog.pg_attribute a ON a.attrelid = d.refobjid
    AND a.attnum = d.refobjsubid
    AND a.attisdropped IS FALSE
WHERE c.relnamespace NOT IN (SELECT oid FROM sys_schemas)
    AND c.relkind = 'S'
    AND c.oid NOT IN (SELECT objid FROM extension_deps)
