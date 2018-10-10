SELECT 
    fs.schema_id AS schema_oid,
    fs.name AS table_name,
    sfk.name,
    SCHEMA_NAME(rs.schema_id) AS referenced_schema_name,
    rs.name AS referenced_table_name,
    aa.cols,
    sfk.is_disabled,
    sfk.is_not_for_replication,
    sfk.update_referential_action,
    sfk.is_not_trusted AS with_no_check,
    sfk.delete_referential_action
FROM sys.foreign_keys AS sfk WITH (NOLOCK)
JOIN sys.objects fs WITH (NOLOCK) ON sfk.parent_object_id=fs.object_id
JOIN sys.objects rs WITH (NOLOCK) ON sfk.referenced_object_id=rs.object_id 
CROSS APPLY (
    SELECT * FROM (
        SELECT 
            sfkc.constraint_column_id AS id,
            fc.name AS f,
            rc.name AS r
        FROM sys.foreign_key_columns AS sfkc WITH (NOLOCK) 
        JOIN sys.columns fc WITH (NOLOCK) ON sfkc.parent_column_id=fc.column_id AND fc.object_id=sfkc.parent_object_id
        JOIN sys.columns rc WITH (NOLOCK) ON sfkc.referenced_column_id=rc.column_id AND rc.object_id=sfkc.referenced_object_id
        WHERE sfk.object_id=sfkc.constraint_object_id
    ) cc ORDER BY cc.id
    FOR XML RAW, ROOT
) aa (cols)