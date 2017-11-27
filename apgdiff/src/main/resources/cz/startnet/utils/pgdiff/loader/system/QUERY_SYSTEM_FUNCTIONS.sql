SELECT  p.proname AS name,
        n.nspname,
        p.proargmodes,
        p.proretset,
        p.proargnames,
        pg_catalog.format_type(p.prorettype, null) AS prorettype,
        p.proallargtypes::bigint[],
        pg_get_function_arguments(p.oid) AS proarguments,
        pg_get_function_identity_arguments(p.oid) AS proarguments_without_default
FROM pg_catalog.pg_proc p
LEFT JOIN pg_catalog.pg_namespace n ON p.pronamespace = n.oid
WHERE NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp 
                    WHERE dp.classid = 'pg_proc'::regclass 
                    AND dp.objid = p.oid 
                    AND dp.deptype = 'i')
    AND (n.nspname LIKE 'pg\_%' OR n.nspname = 'information_schema')