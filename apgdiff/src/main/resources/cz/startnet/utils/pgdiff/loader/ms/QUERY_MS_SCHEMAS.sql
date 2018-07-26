SELECT 
  s.schema_id, 
  s.name, 
  cc.acl,
  p.name AS owner 
FROM sys.schemas s WITH (NOLOCK)
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=s.principal_id
CROSS APPLY (
    SELECT * FROM (
        SELECT  
            perm.state_desc AS sd,
            perm.permission_name AS pn,
            roleprinc.name AS r
            --obj.type_desc
        FROM sys.database_principals roleprinc
        LEFT JOIN sys.database_permissions perm WITH (NOLOCK) ON perm.grantee_principal_id = roleprinc.principal_id
        WHERE major_id = s.schema_id
    ) cc 
    FOR JSON AUTO, INCLUDE_NULL_VALUES
) cc (acl)
WHERE p.name = N'dbo'
