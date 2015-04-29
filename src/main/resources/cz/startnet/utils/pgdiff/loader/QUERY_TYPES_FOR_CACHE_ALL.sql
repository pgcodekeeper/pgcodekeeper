SELECT t.oid::bigint,
       t.typname,
       t.typlen,
       t.typelem::regtype AS castedType,
       t.typarray,
       n.nspname,
       proc.proname
FROM pg_catalog.pg_type t
LEFT JOIN pg_catalog.pg_namespace n ON t.typnamespace = n.oid
LEFT JOIN pg_catalog.pg_proc proc ON proc.oid = t.typmodout