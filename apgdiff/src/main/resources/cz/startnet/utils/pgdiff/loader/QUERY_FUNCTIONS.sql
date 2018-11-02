WITH sys_schemas AS (
    SELECT n.oid
    FROM pg_catalog.pg_namespace n
    WHERE n.nspname LIKE 'pg\_%'
        OR n.nspname = 'information_schema'    
), extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_catalog.pg_extension'::pg_catalog.regclass 
        AND dep.deptype = 'e'
)

SELECT  p.oid::bigint,
        p.proname,
        p.proowner::bigint,
        l.lanname AS lang_name,
        p.prosrc,
        p.provolatile,
        p.proleakproof,
        p.proisstrict,
        p.prosecdef,
        p.procost::real,
        p.prorows::real,
        p.proconfig,
        p.probin,
        p.prorettype::bigint,
        p.proallargtypes::bigint[],
        p.proargmodes,
        p.proargnames,
        proacl::text AS aclarray,
        d.description AS comment,
        p.proretset,
        array(select pg_catalog.unnest(proargtypes))::bigint[] as argtypes,
        pg_catalog.pg_get_expr(proargdefaults, 0) AS default_values_as_string,
        p.pronamespace AS schema_oid
FROM pg_catalog.pg_proc p
LEFT JOIN pg_catalog.pg_description d ON d.objoid = p.oid
LEFT JOIN pg_catalog.pg_language l ON l.oid = p.prolang
WHERE p.pronamespace NOT IN (SELECT oid FROM sys_schemas)
    AND NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.classid = 'pg_catalog.pg_proc'::pg_catalog.regclass AND dp.objid = p.oid AND dp.deptype = 'i')
    AND p.oid NOT IN (SELECT objid FROM extension_deps)