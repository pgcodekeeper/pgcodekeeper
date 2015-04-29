SELECT ccc.relname,
       p.proname,
       nsp.nspname,
       tgname,
       tgfoid,
       tgtype,
       tgrelid::regclass::text,
       tgargs
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_trigger t ON ccc.oid = t.tgrelid
JOIN pg_catalog.pg_proc p ON p.oid = tgfoid
JOIN pg_catalog.pg_namespace nsp ON p.pronamespace = nsp.oid
WHERE ccc.relkind = 'r'
    AND ccc.relnamespace = ?
    AND tgisinternal = FALSE