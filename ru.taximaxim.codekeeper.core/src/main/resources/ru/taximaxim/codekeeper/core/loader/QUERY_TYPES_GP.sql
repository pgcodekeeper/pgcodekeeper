SELECT   
   t.oid, 
   coalesce(array_to_string(e.typoptions, ', '), '') AS typoptions 
FROM pg_type t 
LEFT JOIN pg_type_encoding e ON t.oid = e.typid