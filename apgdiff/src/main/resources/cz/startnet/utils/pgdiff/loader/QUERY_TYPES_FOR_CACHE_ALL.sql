SELECT t.oid,
       t.typname,
       t.typelem,
       t.typarray,
       t2.typname AS elemname,
       n.nspname
FROM pg_catalog.pg_type t
LEFT JOIN pg_catalog.pg_namespace n ON t.typnamespace = n.oid
LEFT JOIN pg_catalog.pg_type t2 ON t2.oid = t.typelem