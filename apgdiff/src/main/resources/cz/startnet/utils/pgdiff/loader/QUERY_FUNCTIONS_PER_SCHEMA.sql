WITH extension_deps AS (
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
        p.proiswindow,
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
        pg_catalog.pg_get_function_arguments(p.oid) AS proarguments,
        pg_catalog.pg_get_function_identity_arguments(p.oid) AS proarguments_without_default,
        proacl::text AS aclarray,
        d.description AS comment,
        p.proretset,
        array(select unnest(proargtypes))::bigint[] as argtypes,
        pg_get_expr(proargdefaults, 0) AS default_values_as_string
FROM pg_catalog.pg_proc p
LEFT JOIN pg_catalog.pg_description d ON d.objoid = p.oid
LEFT JOIN pg_catalog.pg_language l ON l.oid = p.prolang
WHERE pronamespace = ?
    AND proisagg = FALSE
    AND NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.classid = 'pg_catalog.pg_proc'::pg_catalog.regclass AND dp.objid = p.oid AND dp.deptype = 'i')
    AND p.oid NOT IN (SELECT objid FROM extension_deps)