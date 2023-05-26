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
   x.logerrors AS logerrors,
   x.options,
   pg_catalog.pg_encoding_to_char(x.encoding) AS enc,
   x.writable,
   columns.col_enc_options
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