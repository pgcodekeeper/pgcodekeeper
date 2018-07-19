SELECT
  OBJECT_SCHEMA_NAME(c.object_id) AS schema_name,
  OBJECT_NAME(c.object_id) AS table_name,
  si.name,
  c.index_id,
  c.column_id,
  sc.name,
  c.is_descending_key,
  c.is_included_column,
  si.is_primary_key
FROM sys.index_columns c WITH (NOLOCK)
LEFT JOIN sys.columns sc WITH (NOLOCK) ON c.object_id = sc.object_id AND c.column_id = sc.column_id
LEFT JOIN sys.indexes si WITH (NOLOCK) ON c.object_id = si.object_id AND c.index_id = si.index_id
WHERE OBJECTPROPERTY(c.object_id, 'IsUserTable') = 1