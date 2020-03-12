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

SELECT  -- common part (functions/procedures/aggregates)
        p.oid::bigint,
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
        p.proacl::text AS aclarray,
        d.description AS comment,
        p.proretset,
        array(select pg_catalog.unnest(p.proargtypes))::bigint[] as argtypes,
        pg_catalog.pg_get_expr(p.proargdefaults, 0) AS default_values_as_string,
        p.pronamespace AS schema_oid,
        p.pronargs,
        
        -- for aggregates
        sfunc.proname AS sfunc,
        sfunc_n.nspname AS sfunc_nsp,
        a.aggtranstype AS stype,
        a.aggtransspace AS sspace,
        finalfn.proname AS finalfunc,
        finalfn_n.nspname AS finalfunc_nsp,
        a.aggfinalextra AS is_finalfunc_extra,
        a.agginitval AS initcond,
        msfunc.proname AS msfunc,
        msfunc_n.nspname AS msfunc_nsp,
        minvfunc.proname AS minvfunc,
        minvfunc_n.nspname AS minvfunc_nsp,
        a.aggmtranstype AS mstype,
        a.aggmtransspace AS msspace,
        mfinalfn.proname AS mfinalfunc,
        mfinalfn_n.nspname AS mfinalfunc_nsp,
        a.aggmfinalextra AS is_mfinalfunc_extra,
        a.aggminitval AS minitcond,
        sortop.oprname AS sortop,
        sortop_n.nspname AS sortop_nsp,
        a.aggkind,
        a.aggnumdirectargs
        
FROM pg_catalog.pg_proc p

-- common part (functions/procedures/aggregates)
LEFT JOIN pg_catalog.pg_description d ON d.objoid = p.oid
LEFT JOIN pg_catalog.pg_language l ON l.oid = p.prolang

-- for aggregates
LEFT JOIN pg_catalog.pg_aggregate a ON a.aggfnoid = p.oid
LEFT JOIN pg_catalog.pg_proc sfunc ON a.aggtransfn = sfunc.oid
LEFT JOIN pg_catalog.pg_namespace sfunc_n ON sfunc.pronamespace = sfunc_n.oid
LEFT JOIN pg_catalog.pg_proc finalfn ON a.aggfinalfn = finalfn.oid
LEFT JOIN pg_catalog.pg_namespace finalfn_n ON finalfn.pronamespace = finalfn_n.oid
LEFT JOIN pg_catalog.pg_proc msfunc ON a.aggmtransfn = msfunc.oid
LEFT JOIN pg_catalog.pg_namespace msfunc_n ON msfunc.pronamespace = msfunc_n.oid
LEFT JOIN pg_catalog.pg_proc minvfunc ON a.aggminvtransfn = minvfunc.oid
LEFT JOIN pg_catalog.pg_namespace minvfunc_n ON minvfunc.pronamespace = minvfunc_n.oid
LEFT JOIN pg_catalog.pg_proc mfinalfn ON a.aggmfinalfn = mfinalfn.oid
LEFT JOIN pg_catalog.pg_namespace mfinalfn_n ON mfinalfn.pronamespace = mfinalfn_n.oid
LEFT JOIN pg_catalog.pg_operator sortop ON a.aggsortop = sortop.oid
LEFT JOIN pg_catalog.pg_namespace sortop_n ON sortop.oprnamespace = sortop_n.oid

WHERE p.pronamespace NOT IN (SELECT oid FROM sys_schemas)
    AND NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.classid = 'pg_catalog.pg_proc'::pg_catalog.regclass AND dp.objid = p.oid AND dp.deptype = 'i')
    AND p.oid NOT IN (SELECT objid FROM extension_deps)