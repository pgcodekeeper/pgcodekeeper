-- extension owned triggers are skipped by table != null check in java code

SELECT ccc.relname,
       p.proname,
       nsp.nspname,
       t.tgname,
       t.tgtype,
       t.tgargs,
       t.tgconstraint,
       t.tgdeferrable,
       t.tginitdeferred,
       relcon.relname as refrelname,
       (SELECT array_agg(attname ORDER BY attnum) 
        FROM pg_attribute a
        WHERE a.attrelid = ccc.oid AND a.attnum = ANY(t.tgattr)) AS cols,
       pg_get_triggerdef(t.oid,false) || ';' AS definition,
       d.description as comment
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_trigger t ON ccc.oid = t.tgrelid
LEFT JOIN pg_catalog.pg_class relcon ON relcon.oid = t.tgconstrrelid
LEFT JOIN pg_catalog.pg_description d ON t.oid = d.objoid
    AND d.objsubid = 0
JOIN pg_catalog.pg_proc p ON p.oid = t.tgfoid
JOIN pg_catalog.pg_namespace nsp ON p.pronamespace = nsp.oid
WHERE (ccc.relkind = 'r' OR ccc.relkind = 'v')
    AND ccc.relnamespace = ?
    AND tgisinternal = FALSE