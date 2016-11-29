SELECT s.qname
FROM ( SELECT unnest(?) ) s(qname)
WHERE pg_catalog.has_sequence_privilege(s.qname, 'SELECT')
