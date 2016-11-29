WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_extension'::regclass 
        AND dep.deptype = 'e'
)

SELECT p.proname,
        p.proowner,
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
        pg_get_function_arguments(p.oid) AS proarguments,
        pg_get_function_identity_arguments(p.oid) AS proarguments_without_default,
        proacl AS aclArray,
        d.description AS comment,
        p.proretset
FROM pg_catalog.pg_proc p
LEFT JOIN pg_catalog.pg_description d ON d.objoid = p.oid
LEFT JOIN pg_catalog.pg_language l ON l.oid = p.prolang
WHERE pronamespace = ?
    AND proisagg = FALSE
    AND NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.classid = 'pg_proc'::regclass AND dp.objid = p.oid AND dp.deptype = 'i')
    AND p.oid NOT IN (SELECT objid FROM extension_deps)