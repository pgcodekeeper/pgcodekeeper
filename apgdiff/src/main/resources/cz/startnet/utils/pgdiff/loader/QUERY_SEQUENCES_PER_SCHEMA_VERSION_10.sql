SELECT seqrelid AS oid,
       seqstart, 
       seqincrement, 
       seqmax, 
       seqmin, 
       seqcache, 
       seqcycle 
FROM pg_catalog.pg_sequence