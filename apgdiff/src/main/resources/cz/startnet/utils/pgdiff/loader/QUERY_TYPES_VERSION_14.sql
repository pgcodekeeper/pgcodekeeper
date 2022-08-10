SELECT t.oid,
       r.rngmultitypid::bigint AS rngmultirange,
       t.typsubscript,
       t.typsubscript != 0 AS typsubscriptset
 FROM pg_catalog.pg_type t
 LEFT JOIN pg_catalog.pg_range r ON r.rngtypid = t.oid