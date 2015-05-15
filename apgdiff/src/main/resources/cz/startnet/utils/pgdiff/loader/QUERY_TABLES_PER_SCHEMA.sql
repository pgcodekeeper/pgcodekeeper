WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_extension'::regclass 
        AND dep.deptype = 'e'
), nspnames AS (
    SELECT n.oid,
        n.nspname
    FROM pg_catalog.pg_namespace n
), collations AS (
    SELECT c.oid,
        c.collname,
        n.nspname
    FROM pg_catalog.pg_collation c
    LEFT JOIN nspnames n ON n.oid = c.collnamespace
)

SELECT subselectColumns.oid::bigint,
       subselectColumns.relname,
       subselectColumns.relowner::bigint,
       subselectColumns.aclArray,
       subselectColumns.col_numbers,
       subselectColumns.col_names,
       subselectColumns.col_types::bigint[], 
       subselectColumns.col_defaults,
       subselectColumns.col_comments,
       subselectColumns.col_typemod,
       subselectColumns.col_notnull,
       subselectColumns.col_collation,
       subselectColumns.col_statictics,
       subselectColumns.col_local,
       subselectColumns.col_typcollation,
       subselectColumns.col_collationname,
       subselectColumns.col_collationnspname,
       subselectColumns.seqs,
       subselectColumns.col_acl,
       comments.description AS table_comment,
       subselectInherits.inherited,
       subselectColumns.reloptions
FROM
    (SELECT columnsData.oid,
            columnsData.relname,
            columnsData.relowner,
            columnsData.aclArray,
            array_agg(columnsData.attnum) AS col_numbers,
            array_agg(columnsData.attname) AS col_names,
            array_agg(columnsData.atttypid) AS col_types,
            array_agg(columnsData.defaults) AS col_defaults,
            array_agg(columnsData.description) AS col_comments,
            array_agg(columnsData.atttypmod) AS col_typemod,
            array_agg(columnsData.attnotnull) AS col_notnull,
            array_agg(columnsData.attstattarget) AS col_statictics,
            array_agg(columnsData.attislocal) AS col_local,
            array_agg(columnsData.col_seq) AS seqs,
            array_agg(columnsData.attacl) AS col_acl,
            columnsData.reloptions,
            array_agg(columnsData.attcollation) AS col_collation,
            array_agg(columnsData.typcollation) AS col_typcollation,
            array_agg(columnsData.attcollationname) AS col_collationname,
            array_agg(columnsData.attcollationnspname) AS col_collationnspname
     FROM
         (SELECT c.oid,
              c.relname,
              c.relowner::bigint,
              c.relacl AS aclArray,
              attr.attnum::integer,
              attr.attname,
              attr.atttypid::bigint,
              pg_catalog.pg_get_expr(attrdef.adbin, attrdef.adrelid) AS defaults,
              comments.description,
              attr.atttypmod,
              attr.attnotnull,
              attr.attstattarget,
              attr.attislocal,
              (SELECT oid::regclass::text
               FROM pg_catalog.pg_class c2
               WHERE c2.oid = depseq.refobjid
                   AND c2.relkind = 'S') col_seq,
              attr.attacl::text,
              c.reloptions,
              attr.attcollation,
              t.typcollation,
              (SELECT cl.collname FROM collations cl WHERE cl.oid = attr.attcollation) AS attcollationname,
              (SELECT cl.nspname FROM collations cl WHERE cl.oid = attr.attcollation) AS attcollationnspname
          FROM pg_catalog.pg_class c
          JOIN pg_catalog.pg_attribute attr ON c.oid = attr.attrelid
              AND attr.attisdropped IS FALSE
          LEFT JOIN pg_catalog.pg_attrdef attrdef ON attrdef.adnum = attr.attnum
              AND attr.attrelid = attrdef.adrelid
          LEFT JOIN pg_catalog.pg_description comments ON comments.objoid = attr.attrelid
              AND comments.objsubid = attr.attnum
          LEFT JOIN pg_catalog.pg_depend depseq ON attrdef.oid = depseq.objid
              AND depseq.refobjid != c.oid
          LEFT JOIN pg_catalog.pg_type t ON t.oid = attr.atttypid
          WHERE c.relnamespace = ?
              AND c.relkind = 'r'
              AND c.oid NOT IN (SELECT objid FROM extension_deps)
          ORDER BY attr.attnum) columnsData
     GROUP BY columnsData.oid,
              columnsData.relname,
              columnsData.relowner,
              columnsData.aclArray,
              columnsData.reloptions) subselectColumns
LEFT JOIN pg_catalog.pg_description comments ON comments.objoid = subselectColumns.oid
    AND comments.objsubid = 0
LEFT JOIN
    (SELECT array_agg(subinh.inherits)::text[] AS inherited,
        subinh.inhrelid
     FROM
         (SELECT inhrelid,
             inh.inhparent::regclass AS inherits,
             inh.inhseqno
          FROM pg_catalog.pg_inherits inh
          ORDER BY inhrelid, inh.inhseqno ) subinh
     GROUP BY subinh.inhrelid ) subselectInherits ON subselectInherits.inhrelid = subselectColumns.oid