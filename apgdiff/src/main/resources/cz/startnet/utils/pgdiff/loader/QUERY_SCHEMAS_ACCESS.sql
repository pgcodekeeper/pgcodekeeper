SELECT n.nspname
FROM ( SELECT unnest(?) ) n(nspname)
WHERE pg_catalog.has_schema_privilege(n.nspname, 'USAGE')