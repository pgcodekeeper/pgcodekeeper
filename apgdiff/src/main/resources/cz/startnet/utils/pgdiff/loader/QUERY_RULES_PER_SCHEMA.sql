WITH sys_schemas AS (
    SELECT n.oid
    FROM pg_catalog.pg_namespace n
    WHERE n.nspname LIKE 'pg\_%'
        OR n.nspname = 'information_schema'
        OR NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.objid = n.oid AND dp.deptype = 'e')
)

SELECT  r.oid::bigint,
        ccc.relname,
        r.rulename, 
        r.ev_type, 
        r.is_instead, 
        r.ev_enabled,
        pg_catalog.pg_get_ruledef(r.oid) AS rule_string,
        d.description AS comment,
        ccc.relnamespace AS schema_oid
FROM pg_catalog.pg_rewrite r
JOIN pg_catalog.pg_class ccc ON ccc.oid = r.ev_class 
LEFT JOIN pg_catalog.pg_description d ON r.oid = d.objoid
WHERE ccc.relnamespace NOT IN (SELECT oid FROM sys_schemas) 
    -- block rules that implement views
    AND NOT ((ccc.relkind = 'v' OR ccc.relkind = 'm') AND r.ev_type = '1' AND r.is_instead)