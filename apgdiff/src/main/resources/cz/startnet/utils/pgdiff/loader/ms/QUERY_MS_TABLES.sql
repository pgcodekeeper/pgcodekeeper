SELECT
    o.object_id,
    os.schema_id,
    os.name AS schema_name,
    o.name,
    p.name AS owner,
    ds.name AS file_stream, 
    dsx.name AS text_image, 
    o.uses_ansi_nulls,
    o.is_memory_optimized,
    o.durability,
    o.durability_desc
FROM sys.tables o WITH (NOLOCK)
LEFT JOIN sys.schemas os WITH (NOLOCK) ON os.schema_id=o.schema_id
LEFT JOIN sys.database_principals p WITH (NOLOCK) ON p.principal_id=o.principal_id
LEFT JOIN sys.data_spaces ds WITH (NOLOCK) ON o.filestream_data_space_id = ds.data_space_id
LEFT JOIN sys.data_spaces dsx WITH (NOLOCK) ON dsx.data_space_id=o.lob_data_space_id
WHERE o.type = 'U'
