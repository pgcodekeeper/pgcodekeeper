SELECT
    ind.indexrelid::bigint AS oid,
    ind.indnullsnotdistinct AS nullsnotdistinct
FROM
    pg_catalog.pg_index ind