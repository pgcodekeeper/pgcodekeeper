SELECT 
  s.schema_id, 
  s.name, 
  p.name AS owner 
FROM sys.schemas s WITH (NOLOCK)
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=s.principal_id
WHERE s.name != 'information_schema'