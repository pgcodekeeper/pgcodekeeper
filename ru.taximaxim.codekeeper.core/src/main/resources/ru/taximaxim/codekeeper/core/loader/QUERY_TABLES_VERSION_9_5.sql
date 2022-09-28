SELECT 
    oid, 
    relrowsecurity AS row_security, 
    relforcerowsecurity AS force_security 
FROM 
    pg_catalog.pg_class