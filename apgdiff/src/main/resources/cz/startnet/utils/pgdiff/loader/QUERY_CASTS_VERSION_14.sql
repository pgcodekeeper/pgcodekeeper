SELECT
    c.oid::bigint
FROM pg_cast c
WHERE NOT EXISTS ( 
     SELECT 1 FROM pg_range r 
     WHERE c.castsource = r.rngtypid
     AND c.casttarget = r.rngmultitypid)