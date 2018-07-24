SELECT 
    s.schema_id AS schema_oid,
    s.name, 
    s.type,
    am.null_on_null_input,
    cc.args,
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
CROSS APPLY (
    SELECT * FROM (
            SELECT 
                p.name,
                t.name AS type,
                CASE WHEN p.max_length>=0 AND t.name IN (N'nchar', N'nvarchar') THEN p.max_length/2 ELSE p.max_length END AS size,
                p.parameter_id AS id,
                --p.precision AS pr,
                --p.scale AS sc,
                p.is_output AS ou,
                p.has_default_value AS hd,
                p.default_value AS dv,
                --p.is_nullable AS n,
                p.is_readonly AS ro
            FROM sys.objects so WITH (NOLOCK)
            JOIN sys.parameters p WITH (NOLOCK) ON so.object_id = p.object_id
            JOIN sys.types t WITH (NOLOCK) ON p.user_type_id = t.user_type_id
            WHERE p.parameter_id > 0
            AND so.object_id = s.object_id 
    ) cc ORDER BY cc.id
FOR JSON AUTO, INCLUDE_NULL_VALUES
) cc (args)
WHERE s.type IN ('PC', 'FT', 'FS')