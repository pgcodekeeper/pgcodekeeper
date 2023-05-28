SELECT -- common part (functions/procedures/aggregates)
       p.oid, 
       
       -- for aggregates
       combinefn.proname AS combinefunc,
       combinefn_n.nspname AS combinefunc_nsp,
       serialfn.proname AS serialfunc,
       serialfn_n.nspname AS serialfunc_nsp,
       deserialfn.proname AS deserialfunc,
       deserialfn_n.nspname AS deserialfunc_nsp,
       
       -- for functions
       p.proexeclocation AS executeOn
       
FROM pg_catalog.pg_proc p

-- for aggregates
LEFT JOIN pg_catalog.pg_aggregate a ON a.aggfnoid = p.oid
LEFT JOIN pg_catalog.pg_proc combinefn ON a.aggcombinefn = combinefn.oid
LEFT JOIN pg_catalog.pg_namespace combinefn_n ON combinefn.pronamespace = combinefn_n.oid
LEFT JOIN pg_catalog.pg_proc serialfn ON a.aggserialfn = serialfn.oid
LEFT JOIN pg_catalog.pg_namespace serialfn_n ON serialfn.pronamespace = serialfn_n.oid
LEFT JOIN pg_catalog.pg_proc deserialfn ON a.aggdeserialfn = deserialfn.oid
LEFT JOIN pg_catalog.pg_namespace deserialfn_n ON deserialfn.pronamespace = deserialfn_n.oid
