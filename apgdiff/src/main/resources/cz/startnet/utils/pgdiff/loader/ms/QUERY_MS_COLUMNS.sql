SELECT
    OBJECT_SCHEMA_NAME(c.object_id) AS schema_name,
    OBJECT_NAME(c.object_id) AS table_name,
    so.type,
    c.name AS column_name,
    c.column_id,
    t.name as data_type,
    CASE WHEN c.max_length>=0 AND t.name IN (N'nchar', N'nvarchar') THEN c.max_length/2 ELSE c.max_length END AS size,
    c.precision,
    c.scale,
    c.is_sparse,
    c.collation_name,
    object_definition( c.default_object_id) as defval,
    dc.name AS default_name,
    c.is_replicated,
    c.is_nullable,
    c.is_identity,
    ic.seed_value,
    ic.increment_value,
    ic.is_not_for_replication,
    cc.definition as expression,
    c.is_filestream,
    t.is_user_defined,
    t.is_table_type
FROM sys.columns as c WITH (NOLOCK)
LEFT JOIN sys.types t WITH (NOLOCK) ON c.user_type_id = t.user_type_id
LEFT JOIN sys.computed_columns cc WITH (NOLOCK) ON cc.object_id = c.object_id AND c.column_id = cc.column_id
LEFT JOIN sys.identity_columns ic WITH (NOLOCK) ON c.object_id = ic.object_id AND c.column_id = ic.column_id
LEFT JOIN sys.default_constraints dc WITH (NOLOCK) ON dc.parent_object_id = c.object_id AND c.column_id = dc.parent_column_id AND dc.is_system_named = 0
LEFT JOIN sys.objects so WITH (NOLOCK) ON so.object_id = c.object_id
WHERE so.type IN (N'FT', N'U')