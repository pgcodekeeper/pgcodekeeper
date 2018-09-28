SELECT dp.name,
p.name AS owner,
cc.groups,
aa.acl
FROM sys.database_principals AS dp WITH (NOLOCK)
JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=dp.owning_principal_id
CROSS APPLY (
    SELECT * FROM (
        SELECT p1.name AS m
        FROM sys.database_role_members AS rm WITH (NOLOCK)
        INNER JOIN sys.database_principals p1 WITH (NOLOCK) ON rm.member_principal_id=p1.principal_id
        WHERE rm.role_principal_id=dp.principal_id  
    ) cc
    FOR XML RAW, ROOT
) cc (groups)
CROSS APPLY (
    SELECT * FROM (
        SELECT
            perm.state_desc AS sd,
            perm.permission_name AS pn,
            roleprinc.name AS r
        FROM sys.database_principals roleprinc WITH (NOLOCK)
        JOIN sys.database_permissions perm WITH (NOLOCK) ON perm.grantee_principal_id = roleprinc.principal_id
        WHERE major_id = dp.principal_id AND perm.class = 4
    ) cc 
    FOR XML RAW, ROOT
) aa (acl)
WHERE dp.type IN ('R') AND dp.is_fixed_role = 0
AND dp.name != N'public'