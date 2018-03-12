SELECT o.oprname as name, 
       n.nspname, 
       o.oprleft::bigint AS left,
       o.oprright::bigint AS right, 
       o.oprresult::bigint AS result 
FROM pg_catalog.pg_operator o
LEFT JOIN pg_catalog.pg_namespace n ON o.oprnamespace = n.oid
WHERE (n.nspname LIKE 'pg\_%' OR n.nspname = 'information_schema')