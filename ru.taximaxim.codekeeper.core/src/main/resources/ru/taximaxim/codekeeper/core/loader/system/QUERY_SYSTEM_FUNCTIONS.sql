SELECT  p.proname AS name,
        n.nspname,
        p.proargmodes,
        p.proretset,
        p.proargnames,
        pg_catalog.format_type(p.prorettype, null) AS prorettype,
        p.proallargtypes::bigint[],
        pg_catalog.pg_get_function_arguments(p.oid) AS proarguments
FROM pg_catalog.pg_proc p
LEFT JOIN pg_catalog.pg_namespace n ON p.pronamespace = n.oid
WHERE NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp 
                    WHERE dp.classid = 'pg_catalog.pg_proc'::pg_catalog.regclass 
                    AND dp.objid = p.oid 
                    AND dp.deptype = 'i')
    AND (n.nspname LIKE 'pg\_%' OR n.nspname = 'information_schema')