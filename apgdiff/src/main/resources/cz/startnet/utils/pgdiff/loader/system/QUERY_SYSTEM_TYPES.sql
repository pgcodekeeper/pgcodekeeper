SELECT 
    t.typname AS name,    
    t.typtype, -- b/c/d/e/r, p - pseudotype (?)
    n.nspname,
    
    -- COLUMNS
    columns.attnames AS col_names,
    columns.atttypdefns AS col_types
    
FROM pg_catalog.pg_type t
LEFT JOIN (SELECT
         a.attrelid,
         array_agg(a.attname ORDER BY a.attnum) AS attnames,
         array_agg(pg_catalog.format_type(a.atttypid, a.atttypmod) ORDER BY a.attnum) AS atttypdefns
     FROM pg_catalog.pg_attribute a
     WHERE a.attisdropped = FALSE
     GROUP BY attrelid) columns ON columns.attrelid = t.typrelid
LEFT JOIN pg_catalog.pg_namespace n ON t.typnamespace = n.oid
WHERE t.typisdefined = TRUE
    AND (t.typrelid = 0 OR (SELECT c.relkind FROM pg_catalog.pg_class c WHERE c.oid = t.typrelid) = 'c')
    AND NOT EXISTS (SELECT 1 FROM pg_catalog.pg_type el WHERE el.oid = t.typelem AND el.typarray = t.oid)
    AND (n.nspname LIKE 'pg\_%' OR n.nspname = 'information_schema')