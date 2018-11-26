SELECT  p.oid::bigint,
        p.proisagg,
        CASE
          WHEN a.aggkind='o' THEN 'READ_WRITE'
          ELSE 'READ_ONLY'
        END 
        AS finalfunc_modify,
        CASE
          WHEN a.aggkind='o' THEN 'READ_WRITE'
          ELSE 'READ_ONLY'
        END 
        AS mfinalfunc_modify
FROM pg_catalog.pg_proc p
LEFT JOIN pg_catalog.pg_aggregate a ON a.aggfnoid = p.oid