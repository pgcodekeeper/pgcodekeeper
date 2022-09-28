SELECT  -- common part (functions/procedures/aggregates)
        p.oid::bigint,
        p.proisagg,
        
        -- for functions/procedures
        p.proiswindow
        
FROM pg_catalog.pg_proc p