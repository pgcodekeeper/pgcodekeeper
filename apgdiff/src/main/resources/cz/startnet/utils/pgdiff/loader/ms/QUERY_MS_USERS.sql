SELECT dp.name AS name,
suser_sname(dp.sid) AS loginname,
dp.default_schema_name AS schema_name,
aa.acl
FROM sys.database_principals AS dp WITH (NOLOCK)
CROSS APPLY (
    SELECT * FROM (
        SELECT
            perm.state_desc AS sd,
            perm.permission_name AS pn,
            roleprinc.name AS r
        FROM sys.database_principals roleprinc WITH (NOLOCK)
        LEFT JOIN sys.database_permissions perm WITH (NOLOCK) ON perm.grantee_principal_id = roleprinc.principal_id
        WHERE major_id = dp.principal_id AND perm.class = 4
    ) cc 
    FOR XML RAW, ROOT
) aa (acl)
WHERE dp.type IN ('S', 'U') 
AND NOT name IN ('guest', 'sys', 'INFORMATION_SCHEMA')