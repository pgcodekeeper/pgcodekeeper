SELECT 
    si.object_id, 
    OBJECT_NAME(si.object_id) AS table_name, 
    si.name, 
    si.index_id,
    si.is_unique,
    si.is_padded,
    si.allow_page_locks,
    si.allow_row_locks,
    0 AS isStatistics,
    si.fill_factor, 
    si.filter_definition,
    si.is_primary_key,
    d.name AS data_space
FROM sys.indexes si WITH (NOLOCK)
LEFT JOIN sys.filegroups f WITH (NOLOCK) ON si.data_space_id = f.data_space_id
LEFT JOIN sys.data_spaces d WITH (NOLOCK) ON si.data_space_id = d.data_space_id
WHERE OBJECTPROPERTY(si.object_id, 'IsUserTable') = 1