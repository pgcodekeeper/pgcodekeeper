SELECT
    s.name,
    p.name AS owner,
    s.is_visible, 
    s.permission_set, 
    aa.acl,
    af.content
FROM sys.assemblies AS s WITH (NOLOCK)
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=s.principal_id
LEFT JOIN sys.assembly_files af WITH (NOLOCK) ON s.assembly_id = af.assembly_id AND af.assembly_id > 65535
CROSS APPLY (
    SELECT * FROM (
        SELECT  
            perm.state_desc AS sd,
            perm.permission_name AS pn,
            roleprinc.name AS r,
            col.name AS c
        FROM sys.database_principals roleprinc WITH (NOLOCK)
        LEFT JOIN sys.database_permissions perm WITH (NOLOCK) ON perm.grantee_principal_id = roleprinc.principal_id
        LEFT JOIN sys.columns col WITH (NOLOCK) on col.object_id = perm.major_id  AND col.column_id = perm.minor_id
        WHERE major_id = s.assembly_id
    ) cc 
    FOR JSON AUTO, INCLUDE_NULL_VALUES
) aa (acl)
WHERE s.is_user_defined = 1
ORDER BY file_id