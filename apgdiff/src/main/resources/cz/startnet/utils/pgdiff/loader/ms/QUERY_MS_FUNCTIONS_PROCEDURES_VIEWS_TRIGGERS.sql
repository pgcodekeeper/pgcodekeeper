SELECT 
    s.schema_id AS schema_oid,
    s.name,
    aa.acl,
    s.type,
    p.name AS owner,
    sm.definition,
    sm.uses_ansi_nulls AS ansi_nulls,
    sm.uses_quoted_identifier AS quoted_identifier,
    t.is_disabled
FROM sys.objects s WITH (NOLOCK)
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=s.principal_id
LEFT JOIN sys.sql_modules sm WITH (NOLOCK) ON sm.object_id=s.object_id
LEFT JOIN sys.triggers t WITH(NOLOCK) ON t.object_id=s.object_id
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

WHERE s.type IN (N'TR', N'V', N'IF', N'FN', N'TF', N'P')