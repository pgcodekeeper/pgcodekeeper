WITH sys_schemas AS (
    SELECT n.oid
    FROM pg_catalog.pg_namespace n
    WHERE n.nspname LIKE 'pg\_%'
        OR n.nspname = 'information_schema'
        OR NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.objid = n.oid AND dp.deptype = 'e')
)

SELECT t.oid::bigint,
       ccc.relname,
       p.proname,
       nsp.nspname,
       t.tgname,
       t.tgtype,
       t.tgargs,
       t.tgconstraint::bigint,
       t.tgdeferrable,
       t.tginitdeferred,
       relcon.relname as refrelname,
       refnsp.nspname as refnspname,
       (SELECT pg_catalog.array_agg(attname ORDER BY attnum) 
        FROM pg_catalog.pg_attribute a
        WHERE a.attrelid = ccc.oid AND a.attnum = ANY(t.tgattr)) AS cols,
       pg_catalog.pg_get_triggerdef(t.oid,false) || ';' AS definition,
       d.description AS comment,
       ccc.relnamespace AS schema_oid
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_trigger t ON ccc.oid = t.tgrelid
LEFT JOIN pg_catalog.pg_class relcon ON relcon.oid = t.tgconstrrelid
LEFT JOIN pg_catalog.pg_namespace refnsp ON refnsp.oid = relcon.relnamespace
LEFT JOIN pg_catalog.pg_description d ON t.oid = d.objoid
    AND d.objsubid = 0
JOIN pg_catalog.pg_proc p ON p.oid = t.tgfoid
JOIN pg_catalog.pg_namespace nsp ON p.pronamespace = nsp.oid
WHERE ccc.relkind IN ('r', 'f', 'p', 'm', 'v')
    AND ccc.relnamespace NOT IN (SELECT oid FROM sys_schemas)
    AND t.tgisinternal = FALSE