SELECT n.nspname, pg_catalog.has_schema_privilege(n.nspname, 'USAGE') AS has_priv 
FROM ( SELECT unnest(?) ) n(nspname)