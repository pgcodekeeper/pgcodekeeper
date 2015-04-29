SELECT a.attname,
       a.attnum,
       a.attrelid
FROM pg_catalog.pg_attribute a
JOIN pg_catalog.pg_class c ON c.oid = a.attrelid
    AND a.attisdropped IS FALSE
WHERE c.relnamespace = ?
    AND c.relkind IN ('i', 'r')
ORDER BY a.attrelid