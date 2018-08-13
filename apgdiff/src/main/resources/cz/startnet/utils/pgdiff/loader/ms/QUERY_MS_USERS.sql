SELECT dp.name AS name, 
suser_sname(dp.sid) AS loginname,
dp.default_schema_name AS schema_name
FROM sys.database_principals AS dp WITH (NOLOCK)
WHERE dp.type IN ('S', 'U') 
AND NOT name IN ('guest', 'sys', 'INFORMATION_SCHEMA')