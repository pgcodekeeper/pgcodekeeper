SELECT 
    c.oid,
    c.collversion,
    c.collprovider
FROM  
    pg_catalog.pg_collation c