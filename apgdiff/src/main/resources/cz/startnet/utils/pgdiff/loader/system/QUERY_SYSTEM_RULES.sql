SELECT  r.rulename AS name,
        n.nspname
FROM pg_catalog.pg_rewrite r
JOIN pg_catalog.pg_class ccc ON ccc.oid = r.ev_class 
LEFT JOIN pg_catalog.pg_namespace n ON ccc.relnamespace = n.oid
WHERE (n.nspname LIKE 'pg\_%' OR n.nspname = 'information_schema')
    AND NOT ((ccc.relkind = 'v' OR ccc.relkind = 'm') AND r.ev_type = '1' AND r.is_instead)