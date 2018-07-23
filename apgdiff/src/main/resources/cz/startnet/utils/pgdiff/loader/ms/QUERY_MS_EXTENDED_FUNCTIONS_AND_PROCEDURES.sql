SELECT 
    s.schema_id AS schema_oid,
    s.name, 
    s.type,
    am.null_on_null_input,
    p.name AS owner,
    p2.name AS execute_as,
    a.name AS assembly,
    am.assembly_class,
    am.assembly_method
FROM sys.objects s WITH (NOLOCK)
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=s.principal_id
LEFT JOIN sys.assembly_modules am WITH (NOLOCK) ON am.object_id=s.object_id
LEFT JOIN sys.assemblies a WITH (NOLOCK) ON a.assembly_id=am.assembly_id
LEFT JOIN sys.database_principals p2 WITH (NOLOCK) ON p2.principal_id=am.execute_as_principal_id
WHERE s.type IN ('PC', 'FT', 'FS')