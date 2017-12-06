SELECT o.oprname as name, 
       n.nspname, 
       format_type(o.oprleft, null) AS left,
       format_type(o.oprright, null) AS right, 
       format_type(o.oprresult, null) AS result 
FROM pg_operator o
LEFT JOIN pg_catalog.pg_namespace n ON o.oprnamespace = n.oid
WHERE (n.nspname LIKE 'pg\_%' OR n.nspname = 'information_schema')