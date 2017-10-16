SELECT seqrelid AS oid,
       seqtypid,
       seqstart, 
       seqincrement, 
       seqmax, 
       seqmin, 
       seqcache, 
       seqcycle 
FROM pg_catalog.pg_sequence