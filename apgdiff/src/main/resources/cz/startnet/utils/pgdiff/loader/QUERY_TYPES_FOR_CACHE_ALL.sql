SELECT t.oid,
       t.typname,
       t.typelem,
       t.typarray,
       n.nspname
FROM pg_catalog.pg_type t
LEFT JOIN pg_catalog.pg_namespace n ON t.typnamespace = n.oid