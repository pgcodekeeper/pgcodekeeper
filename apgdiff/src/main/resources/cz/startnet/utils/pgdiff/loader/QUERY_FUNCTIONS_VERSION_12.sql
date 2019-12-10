SELECT  -- common part (functions/procedures/aggregates)
        p.oid::bigint,
        p.prokind = 'a' AS proisagg,
        
        -- for functions/procedures
        p.prokind = 'w' AS proiswindow,
        p.prokind = 'p' AS proisproc,
        
        -- for aggregates
        a.aggfinalmodify AS finalfunc_modify,
        a.aggmfinalmodify AS mfinalfunc_modify,
        
        -- for functions
        p.prosupport AS support_func
        
FROM pg_catalog.pg_proc p

-- for aggregates
LEFT JOIN pg_catalog.pg_aggregate a ON a.aggfnoid = p.oid