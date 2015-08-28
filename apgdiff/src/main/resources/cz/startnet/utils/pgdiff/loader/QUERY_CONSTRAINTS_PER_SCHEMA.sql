-- extension owned constraints are skipped by table != null check in java code

SELECT ccc.relname,
    conname,
    contype,
    conrelid,
    pg_get_expr(conbin, ccc.oid) AS consrc_usable,
    conkey::integer[],
    confrelid,
    confrelid::regclass::text AS confrelid_name,
    (SELECT cx.relname
     FROM pg_catalog.pg_class cx
     WHERE cx.oid = confrelid) AS foreign_table_name,
    (SELECT nsp.nspname
     FROM pg_catalog.pg_namespace nsp
     WHERE nsp.oid =
             (SELECT cx.relnamespace
              FROM pg_catalog.pg_class cx
              WHERE cx.oid = confrelid)) AS foreign_schema_name,
    confkey::integer[],
    confupdtype,
    confdeltype,
    confmatchtype,
    description,
    pg_get_constraintdef(c.oid) as definition
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_constraint c ON ccc.oid = c.conrelid
LEFT JOIN pg_catalog.pg_description d ON c.oid = d.objoid
WHERE ccc.relkind = 'r'
    AND ccc.relnamespace = ?