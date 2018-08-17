SELECT
    o.schema_id AS schema_oid,
    o.name,
    tt.name AS space_name,
  --c.name AS part_column,
    p.name AS owner,
    ds.name AS file_stream, 
    cc.cols,
    aa.acl,
    dsx.name AS text_image, 
    o.uses_ansi_nulls,
    o.is_memory_optimized,
    o.durability,
    o.durability_desc,
    sp.data_compression,
    sp.data_compression_desc
FROM sys.tables o WITH (NOLOCK)
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=o.principal_id
LEFT JOIN sys.indexes ind WITH (NOLOCK) on ind.object_id = o.object_id AND ind.index_id = 0
LEFT JOIN sys.data_spaces dsp WITH (NOLOCK) on dsp.data_space_id = ind.data_space_id  
LEFT JOIN sys.data_spaces ds WITH (NOLOCK) ON o.filestream_data_space_id = ds.data_space_id
LEFT JOIN sys.data_spaces dsx WITH (NOLOCK) ON dsx.data_space_id=o.lob_data_space_id
LEFT JOIN sys.partitions sp WITH (NOLOCK) ON sp.object_id = o.object_id AND sp.index_id in (0,1) AND sp.partition_number = 1
--LEFT JOIN sys.index_columns  ic ON ic.partition_ordinal > 0 AND ic.index_id = ind.index_id and ic.object_id = o.object_id
--LEFT JOIN sys.columns c ON c.object_id = ic.object_id AND c.column_id = ic.column_id
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
        WHERE major_id = o.object_id
    ) cc 
    FOR JSON AUTO, INCLUDE_NULL_VALUES
) aa (acl)

CROSS APPLY (
    SELECT TOP 1 dsp.name
    FROM sys.indexes ind WITH (NOLOCK) 
    LEFT JOIN sys.data_spaces dsp WITH (NOLOCK) on dsp.data_space_id = ind.data_space_id  
    WHERE ind.object_id = o.object_id
) tt 

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
        WHERE c.object_id = o.object_id
    ) cc ORDER BY cc.id
FOR JSON AUTO, INCLUDE_NULL_VALUES
) cc (cols)
WHERE o.type = 'U'