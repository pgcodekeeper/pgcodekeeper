SELECT 
    s.schema_id AS schema_oid,
    s.name, 
    s.type,
    aa.acl,
    usrt.name AS return_type,
    CASE WHEN usrt.max_length>=0 AND usrt.name IN (N'nchar', N'nvarchar') THEN usrt.max_length/2 ELSE usrt.max_length END AS return_type_size,
    usrt.precision AS return_type_pr,
    usrt.scale AS return_type_sc,
    am.null_on_null_input,
    cc.args,
    ccc.cols,
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
        LEFT JOIN sys.database_permissions perm WITH (NOLOCK) ON perm.grantee_principal_id = roleprinc.principal_id
        LEFT JOIN sys.columns col WITH (NOLOCK) on col.object_id = perm.major_id  AND col.column_id = perm.minor_id
        WHERE major_id = s.object_id
    ) cc 
    FOR XML RAW, ROOT
) aa (acl)

CROSS APPLY (
    SELECT * FROM (
            SELECT 
                p.name,
                t.name AS type,
                CASE WHEN p.max_length>=0 AND t.name IN (N'nchar', N'nvarchar') THEN p.max_length/2 ELSE p.max_length END AS size,
                p.parameter_id AS id,
                p.precision AS pr,
                p.scale AS sc,
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
    FOR XML RAW, ROOT
) cc (args)
CROSS APPLY (
    SELECT * FROM (
        SELECT
            c.name,
            c.column_id AS id,
            t.name as type,
            CASE WHEN c.max_length>=0 AND t.name IN (N'nchar', N'nvarchar') THEN c.max_length/2 ELSE c.max_length END AS size,
            c.precision AS pr,
            c.scale AS sc,
            c.is_sparse AS sp,
            c.collation_name AS cn,
            object_definition(c.default_object_id) AS dv,
            dc.name AS dn,
            --c.is_replicated AS rp,
            c.is_nullable AS nl,
            c.is_identity AS ii,
            ic.seed_value AS s,
            ic.increment_value AS i,
            ic.is_not_for_replication AS nfr,
            --t.is_user_defined AS ud,
            --t.is_table_type AS tt,
            --c.is_filestream AS fs,
            cc.definition AS def
        FROM sys.columns as c WITH (NOLOCK)
        LEFT JOIN sys.types t WITH (NOLOCK) ON c.user_type_id = t.user_type_id
        LEFT JOIN sys.computed_columns cc WITH (NOLOCK) ON cc.object_id = c.object_id AND c.column_id = cc.column_id
        LEFT JOIN sys.identity_columns ic WITH (NOLOCK) ON c.object_id = ic.object_id AND c.column_id = ic.column_id
        LEFT JOIN sys.default_constraints dc WITH (NOLOCK) ON dc.parent_object_id = c.object_id AND c.column_id = dc.parent_column_id AND dc.is_system_named = 0
        LEFT JOIN sys.objects so WITH (NOLOCK) ON so.object_id = c.object_id
        WHERE c.object_id = s.object_id
    ) ccc ORDER BY ccc.id
    FOR XML RAW, ROOT
) ccc (cols)
WHERE s.type IN ('PC', 'FT', 'FS')