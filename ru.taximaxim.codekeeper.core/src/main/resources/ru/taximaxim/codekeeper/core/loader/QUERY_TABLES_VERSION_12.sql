SELECT 
   c.oid,
   columns.col_generated
FROM pg_catalog.pg_class c
LEFT JOIN (SELECT
            a.attrelid,
           pg_catalog.array_agg(a.attgenerated ORDER BY a.attnum) AS col_generated
      FROM pg_catalog.pg_attribute a
      WHERE a.attisdropped IS FALSE
            AND a.attnum > 0 
      GROUP BY attrelid) columns ON columns.attrelid = c.oid