SELECT t.oid,
       t.typname,
       t.typelem,
       t.typarray,
       te.typname AS elemname,
       n.nspname
FROM pg_catalog.pg_type t
LEFT JOIN pg_catalog.pg_namespace n ON t.typnamespace = n.oid
LEFT JOIN pg_catalog.pg_type te ON te.oid = t.typelem