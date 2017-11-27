SELECT
    -- GENERAL
    c.relname AS name,
    c.relkind,
    n.nspname,
       
    --columns
    columns.col_names,
    columns.col_types
FROM pg_class c
LEFT JOIN (SELECT
                a.attrelid,
                array_agg(a.attname ORDER BY a.attnum) AS col_names,
                array_agg(pg_catalog.format_type(a.atttypid, a.atttypmod) ORDER BY a.attnum) AS col_types
          FROM pg_catalog.pg_attribute a
          WHERE a.attisdropped IS FALSE AND a.attnum > 0 
          GROUP BY attrelid) columns ON columns.attrelid = c.oid AND c.relkind != 'S'
LEFT JOIN pg_catalog.pg_namespace n ON c.relnamespace = n.oid
WHERE c.relkind IN ('f','r','p', 'v', 'm', 'S')
    AND (n.nspname LIKE 'pg\_%' OR n.nspname = 'information_schema')