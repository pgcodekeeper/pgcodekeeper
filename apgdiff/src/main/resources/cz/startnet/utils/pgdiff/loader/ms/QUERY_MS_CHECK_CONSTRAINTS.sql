SELECT so.name AS table_name,
    cc.name,
    cc.is_not_for_replication,
    cc.is_not_trusted AS with_no_check,
    cc.is_disabled,
    sc.name AS column_name,
    cc.parent_column_id AS colid, 
    cc.definition,
    cc.is_system_named AS is_system_named
FROM sys.check_constraints cc WITH (NOLOCK) 
INNER JOIN sys.objects so WITH (NOLOCK) ON so.object_id=cc.parent_object_id 
LEFT JOIN sys.schemas ss WITH (NOLOCK) ON ss.schema_id=so.schema_id
LEFT JOIN sys.columns sc  WITH (NOLOCK) ON sc.column_id=cc.parent_column_id AND sc.object_id=cc.parent_object_id