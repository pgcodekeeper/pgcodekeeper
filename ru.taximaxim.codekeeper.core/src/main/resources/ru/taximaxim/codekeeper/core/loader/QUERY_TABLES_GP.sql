SELECT
   c.oid,
   pg_get_table_distributedby(c.oid) AS distribution,
   x.urilocation AS urloc,
   x.execlocation AS exloc,
   x.fmttype,
   x.fmtopts,
   x.command,
   x.rejectlimit AS rejlim,
   x.rejectlimittype AS rejtyp,
   x.logerrors,
   x.options,
   pg_catalog.pg_encoding_to_char(x.encoding) AS enc,
   x.writable,
   columns.col_enc_options,
   ps.tablename as parent_table,
   --ps.partitionname as given_part_name,
   --partitiontablename as part_name,
   --ps.partitiontype as part_type,
   CASE WHEN pl.parlevel = 0 THEN (SELECT pg_get_partition_def(c.oid, true, false)) END AS partclause,
   CASE WHEN pl.parlevel = 0 THEN (SELECT pg_get_partition_template_def(c.oid, true, false)) END as parttemplate
FROM pg_catalog.pg_class c
LEFT JOIN pg_exttable x ON c.oid = x.reloid
LEFT JOIN (SELECT
           a.attrelid,
           pg_catalog.array_agg(pg_catalog.array_to_string(enc_a.attoptions, ',') ORDER BY a.attnum) AS col_enc_options
      FROM pg_catalog.pg_attribute a
      LEFT JOIN pg_attribute_encoding enc_a ON enc_a.attnum = a.attnum AND a.attrelid = enc_a.attrelid
      WHERE a.attisdropped IS FALSE
            AND a.attnum > 0
      GROUP BY a.attrelid) columns ON columns.attrelid = c.oid
LEFT JOIN pg_partitions ps on (c.relname = ps.partitiontablename)
LEFT JOIN pg_partition_rule pr ON c.oid = pr.parchildrelid
LEFT JOIN pg_partition p ON pr.paroid = p.oid
LEFT JOIN pg_partition pl ON (c.oid = pl.parrelid AND pl.parlevel = 0)
WHERE ps.tablename IS NULL