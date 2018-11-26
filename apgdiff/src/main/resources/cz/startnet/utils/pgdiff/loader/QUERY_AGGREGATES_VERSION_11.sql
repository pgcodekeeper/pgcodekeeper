SELECT  p.oid::bigint,
        p.prokind = 'a' AS proisagg,
        a.aggfinalmodify AS finalfunc_modify,
        a.aggmfinalmodify AS mfinalfunc_modify
FROM pg_catalog.pg_proc p