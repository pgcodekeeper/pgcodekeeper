SELECT t.oid,
       rngmultitypid::bigint AS rngmultirange
 FROM pg_catalog.pg_range r 
 LEFT JOIN pg_catalog.pg_type t ON r.rngtypid = t.oid