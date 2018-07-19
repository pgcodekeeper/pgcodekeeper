SELECT
ss.schema_id,
ss.name AS schema_name,
s.name,
t.name AS data_type,
p.name AS owner,
s.start_value,
s.increment,
s.minimum_value,
s.maximum_value,
s.is_cycling,
s.is_cached,
s.cache_size
FROM sys.sequences s                WITH (NOLOCK)
LEFT JOIN sys.types t               WITH (NOLOCK) ON t.user_type_id = s.user_type_id
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id = s.principal_id
LEFT JOIN sys.schemas ss            WITH (NOLOCK) ON ss.schema_id = s.schema_id