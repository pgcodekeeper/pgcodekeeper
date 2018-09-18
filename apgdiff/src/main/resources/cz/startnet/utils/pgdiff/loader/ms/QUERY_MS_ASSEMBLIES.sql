SELECT
    s.name,
    p.name AS owner,
    s.is_visible, 
    s.permission_set, 
    aa.acl,
    bb.binaries
FROM sys.assemblies AS s WITH (NOLOCK)
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=s.principal_id
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
    FOR XML RAW, ROOT
) aa (acl)
CROSS APPLY (
    SELECT convert(varchar(max), af.content, 1) b
    FROM sys.assembly_files af WITH (NOLOCK) 
    WHERE s.assembly_id = af.assembly_id AND af.assembly_id > 65535
    FOR XML RAW, ROOT
) bb (binaries)
WHERE s.is_user_defined = 1