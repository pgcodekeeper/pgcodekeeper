WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_extension'::regclass 
        AND dep.deptype = 'e'
)

SELECT c.oid::bigint,
       c.relowner::bigint,
       c.relname,
       descr.description AS comment,
       (SELECT t.relname FROM pg_catalog.pg_class t WHERE t.oid=d.refobjid) referenced_table_name,
       --d.refobjid::regclass::text referenced_table_name,
       a.attname AS ref_col_name,
       c.relacl::text AS aclarray
FROM pg_catalog.pg_class c
LEFT JOIN pg_catalog.pg_description descr ON c.oid = descr.objoid
    AND descr.objsubid = 0
LEFT JOIN pg_catalog.pg_depend d ON d.objid = c.oid
    AND d.refobjsubid != 0
    AND d.deptype IN ('i', 'a')
LEFT JOIN pg_catalog.pg_attribute a ON a.attrelid = d.refobjid
    AND a.attnum = d.refobjsubid
    AND a.attisdropped IS FALSE
WHERE c.relnamespace = ?
    AND c.relkind = 'S'
    AND c.oid NOT IN (SELECT objid FROM extension_deps)