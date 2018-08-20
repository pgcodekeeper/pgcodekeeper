SELECT
    s.schema_id AS schema_oid,
    s.name,
    aa.acl,
    t.name AS data_type,
    s.precision,
    p.name AS owner,
    CONVERT(bigint, s.start_value) AS start_value,
    CONVERT(bigint, s.increment) AS increment,
    CONVERT(bigint, s.minimum_value) AS minimum_value,
    CONVERT(bigint, s.maximum_value) AS maximum_value,
    s.is_cycling,
    s.is_cached,
    s.cache_size
FROM sys.sequences s                WITH (NOLOCK)
LEFT JOIN sys.types t               WITH (NOLOCK) ON t.user_type_id = s.user_type_id
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id = s.principal_id
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
    FOR JSON AUTO, INCLUDE_NULL_VALUES
) aa (acl)