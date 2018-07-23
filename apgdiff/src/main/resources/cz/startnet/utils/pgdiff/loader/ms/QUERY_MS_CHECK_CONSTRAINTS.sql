SELECT 
    so.schema_id AS schema_oid,
    so.name AS table_name,
    cc.name,
    cc.is_not_for_replication,
    --cc.is_not_trusted AS with_no_check,
    --cc.is_disabled,
    cc.definition,
    cc.is_system_named AS is_system_named
FROM sys.check_constraints cc WITH (NOLOCK) 
INNER JOIN sys.objects so WITH (NOLOCK) ON so.object_id=cc.parent_object_id