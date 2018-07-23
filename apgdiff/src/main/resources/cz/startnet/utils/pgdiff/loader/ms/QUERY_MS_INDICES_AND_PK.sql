SELECT 
    o.schema_id AS schema_oid,
    o.name AS table_name, 
    si.name,
    si.is_primary_key,
    si.is_unique,
    si.is_unique_constraint,
    INDEXPROPERTY(si.object_id, si.name, 'IsClustered') AS is_clustered,
    si.is_padded,
    cc.cols,
    si.allow_page_locks,
    si.allow_row_locks,
    si.fill_factor, 
    si.filter_definition,
    d.name AS data_space
FROM sys.indexes si WITH (NOLOCK)
LEFT JOIN sys.filegroups f WITH (NOLOCK) ON si.data_space_id = f.data_space_id
LEFT JOIN sys.data_spaces d WITH (NOLOCK) ON si.data_space_id = d.data_space_id
LEFT JOIN sys.objects o WITH (NOLOCK) ON si.object_id = o.object_id
CROSS APPLY ( 
    SELECT * FROM (
        SELECT
          c.column_id AS id,
          sc.name,
          c.is_descending_key AS is_desc,
          c.is_included_column AS is_inc
        FROM sys.index_columns c WITH (NOLOCK)
        LEFT JOIN sys.columns sc WITH (NOLOCK) ON c.object_id = sc.object_id AND c.column_id = sc.column_id
        WHERE c.object_id = si.object_id AND c.index_id = si.index_id
) cc ORDER BY cc.id
FOR JSON AUTO, INCLUDE_NULL_VALUES, WITHOUT_ARRAY_WRAPPER
) cc (cols)
WHERE  o.type = 'U' AND si.name IS NOT NULL