SELECT 
    c.oid,
    c.conparentid::bigint
FROM  
    pg_catalog.pg_constraint c 
