SELECT ccc.relname,
       p.proname,
       nsp.nspname,
       tgname,
       tgfoid,
       tgtype,
       tgrelid::regclass::text,
       tgargs,
       tgrelid as table_oid,
       tgattr::int2[] as col_numbers,
       pg_get_triggerdef(t.oid,false) AS definition,
       d.description as comment
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_trigger t ON ccc.oid = t.tgrelid
LEFT JOIN pg_catalog.pg_description d ON t.oid = d.objoid
    AND d.objsubid = 0
JOIN pg_catalog.pg_proc p ON p.oid = tgfoid
JOIN pg_catalog.pg_namespace nsp ON p.pronamespace = nsp.oid
WHERE ccc.relkind = 'r'
    AND ccc.relnamespace = ?
    AND tgisinternal = FALSE