SELECT 
    s.schema_id AS schema_oid,
    s.name, 
    s.type,
    aa.acl,
    SCHEMA_NAME(usrt.schema_id) AS return_type_sh,
    usrt.name AS return_type,
    CASE WHEN ret_param.max_length>=0 AND usrt.name IN (N'nchar', N'nvarchar') THEN ret_param.max_length/2 ELSE ret_param.max_length END AS return_type_size,
    usrt.precision AS return_type_pr,
    usrt.scale AS return_type_sc,
    usrt.is_user_defined AS return_type_ud,
    am.null_on_null_input,
    cc.args,
    ccc.cols,
    p.name AS owner,
    p2.name AS execute_as,
    a.name AS assembly,
    am.assembly_class,
    am.assembly_method
FROM sys.objects s WITH (NOLOCK)
JOIN sys.assembly_modules am WITH (NOLOCK) ON am.object_id=s.object_id
JOIN sys.assemblies a WITH (NOLOCK) ON a.assembly_id=am.assembly_id
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=s.principal_id
LEFT JOIN sys.database_principals p2 WITH (NOLOCK) ON p2.principal_id=am.execute_as_principal_id
LEFT JOIN sys.all_parameters ret_param WITH (NOLOCK) ON ret_param.object_id = s.object_id and ret_param.parameter_id = 0
LEFT JOIN sys.types usrt WITH (NOLOCK) ON usrt.user_type_id = ret_param.user_type_id
CROSS APPLY (
    SELECT * FROM (
        SELECT  
            perm.state_desc AS sd,
            perm.permission_name AS pn,
            roleprinc.name AS r,
            col.name AS c
        FROM sys.database_principals roleprinc  WITH (NOLOCK)
        JOIN sys.database_permissions perm WITH (NOLOCK) ON perm.grantee_principal_id = roleprinc.principal_id
        LEFT JOIN sys.columns col WITH (NOLOCK) on col.object_id = perm.major_id  AND col.column_id = perm.minor_id
        WHERE major_id = s.object_id AND perm.class = 1
    ) cc 
    FOR XML RAW, ROOT
) aa (acl)
CROSS APPLY (
    SELECT * FROM (
        SELECT 
            p.name,
            t.name AS type,
            SCHEMA_NAME(t.schema_id) AS st,
            TYPE_NAME(t.system_type_id) AS bt,
            CASE WHEN p.max_length>=0 AND t.name IN (N'nchar', N'nvarchar') THEN p.max_length/2 ELSE p.max_length END AS size,
            p.parameter_id AS id,
            p.precision AS pr,
            p.scale AS sc,
            t.is_user_defined AS ud,
            p.is_output AS ou,
            p.has_default_value AS hd,
            p.default_value AS dv,
            --p.is_nullable AS n,
            p.is_readonly AS ro
        FROM sys.objects so WITH (NOLOCK)
        JOIN sys.parameters p WITH (NOLOCK) ON so.object_id = p.object_id
        JOIN sys.types t WITH (NOLOCK) ON p.user_type_id = t.user_type_id
        WHERE p.parameter_id > 0 AND so.object_id = s.object_id 
    ) cc ORDER BY cc.id
    FOR XML RAW, ROOT
) cc (args)
CROSS APPLY (
    SELECT * FROM (
        SELECT
            c.name,
            c.column_id AS id,
            t.name AS type,
            SCHEMA_NAME(t.schema_id) AS st,
            CASE WHEN c.max_length>=0 AND t.name IN (N'nchar', N'nvarchar') THEN c.max_length/2 ELSE c.max_length END AS size,
            c.precision AS pr,
            c.scale AS sc,
            c.collation_name AS cn,
            t.is_user_defined AS ud
        FROM sys.columns as c WITH (NOLOCK)
        JOIN sys.types t WITH (NOLOCK) ON c.user_type_id = t.user_type_id
        WHERE c.object_id = s.object_id
    ) ccc ORDER BY ccc.id
    FOR XML RAW, ROOT
) ccc (cols)
WHERE s.type IN ('PC', 'FT', 'FS')