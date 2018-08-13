SELECT dp.name,
p.name AS owner,
cc.groups
FROM sys.database_principals AS dp  WITH (NOLOCK)
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=dp.owning_principal_id
CROSS APPLY (
    SELECT * FROM (
        SELECT p1.name AS m
        FROM sys.database_role_members AS rm  WITH (NOLOCK)
        INNER JOIN sys.database_principals p1  WITH (NOLOCK) ON rm.member_principal_id=p1.principal_id
        WHERE rm.role_principal_id=dp.principal_id  
    ) cc
    FOR JSON AUTO, INCLUDE_NULL_VALUES
) cc (groups)
WHERE dp.type in ('R') and dp.is_fixed_role = 0
AND dp.name != N'public'