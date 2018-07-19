SELECT 
    OBJECT_SCHEMA_NAME(so.object_id) AS schema_name,
    so.name AS parent_name,
    p.name,
    so.type,
    t.name AS data_type,
    CASE WHEN p.max_length>=0 AND t.name IN (N'nchar', N'nvarchar') THEN p.max_length/2 ELSE p.max_length END AS size,
    p.parameter_id,
    p.precision,
    p.scale,
    p.is_output,
    p.has_default_value,
    p.default_value,
    p.is_readonly,
    p.is_nullable
FROM sys.objects so WITH (NOLOCK)
JOIN sys.parameters p WITH (NOLOCK) ON so.object_id = p.object_id
JOIN sys.types t WITH (NOLOCK) ON p.user_type_id = t.user_type_id
WHERE so.type IN ('PC', 'FT', 'FS') AND p.parameter_id > 0
