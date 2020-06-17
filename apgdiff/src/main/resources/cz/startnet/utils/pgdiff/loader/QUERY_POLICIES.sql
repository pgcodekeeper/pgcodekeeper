WITH sys_schemas AS (
    SELECT n.oid
    FROM pg_catalog.pg_namespace n
    WHERE n.nspname LIKE 'pg\_%'
        OR n.nspname = 'information_schema'
        OR EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.objid = n.oid AND dp.deptype = 'e')
)

SELECT p.oid::bigint,
       p.polname,
       c.relname,
       p.polcmd,
       ARRAY(SELECT pg_catalog.quote_ident(rolname) FROM pg_catalog.pg_roles WHERE oid = ANY(p.polroles)) AS polroles,
       pg_catalog.pg_get_expr(p.polqual, p.polrelid) AS polqual, 
       pg_catalog.pg_get_expr(p.polwithcheck, p.polrelid) AS polwithcheck,
       d.description AS comment,
       c.relnamespace AS schema_oid
FROM pg_catalog.pg_policy p
JOIN pg_catalog.pg_class c ON c.oid = p.polrelid
LEFT JOIN pg_catalog.pg_description d ON p.oid = d.objoid
WHERE c.relnamespace NOT IN (SELECT oid FROM sys_schemas)
