SELECT 
    fs.schema_id AS schema_oid,
    fs.name AS table_name,
    sfk.name,
    fc.name AS field_name,
    SCHEMA_NAME(rs.schema_id) AS referenced_schema_name,
    rs.name AS referenced_table_name, 
    rc.name AS referenced_field_name,
    --sfk.is_disabled AS disabled,
    sfk.is_not_for_replication,
    sfk.update_referential_action,
    sfk.delete_referential_action
    --sfk.is_not_trusted AS with_no_check,
FROM sys.foreign_keys AS sfk WITH (NOLOCK)
LEFT JOIN sys.foreign_key_columns AS sfkc WITH (NOLOCK) ON sfk.object_id=sfkc.constraint_object_id
LEFT JOIN sys.objects fs WITH (NOLOCK) ON sfk.parent_object_id=fs.object_id
LEFT JOIN sys.objects rs WITH (NOLOCK) ON sfk.referenced_object_id=rs.object_id 
LEFT JOIN sys.columns fc WITH (NOLOCK) ON sfkc.parent_column_id=fc.column_id AND fc.object_id=sfkc.parent_object_id
LEFT JOIN sys.columns rc WITH (NOLOCK) ON sfkc.referenced_column_id=rc.column_id AND rc.object_id=sfkc.referenced_object_id