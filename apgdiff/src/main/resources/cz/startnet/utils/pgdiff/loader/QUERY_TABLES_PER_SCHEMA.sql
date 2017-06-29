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

SELECT subselectColumns.oid,
       subselectColumns.relname,
       subselectColumns.of_type::bigint,
       subselectColumns.relowner::bigint,
       subselectColumns.aclArray,
       subselectColumns.col_numbers,
       subselectColumns.col_names,
       subselectColumns.col_options,
       subselectColumns.col_storages,
       subselectColumns.col_default_storages,
       subselectColumns.col_defaults,
       subselectColumns.col_comments,
       subselectColumns.atttypids AS col_type_ids,
       subselectColumns.atttypname AS col_type_name,
       subselectColumns.col_notnull,
       subselectColumns.col_collation,
       subselectColumns.col_statictics,
       subselectColumns.col_local,
       subselectColumns.col_typcollation,
       subselectColumns.col_collationname,
       subselectColumns.col_collationnspname,
       subselectColumns.col_acl,
       comments.description AS table_comment,
       subselectColumns.spcname AS table_space,
       subselectColumns.relpersistence AS persistence,
       subselectColumns.relhasoids AS has_oids,
       subselectInherits.inhrelnames,
       subselectInherits.inhnspnames,
       subselectColumns.reloptions,
       subselectColumns.toast_reloptions
FROM
    (SELECT columnsData.oid,
            columnsData.relname,
            columnsData.of_type,
            columnsData.relowner,
            columnsData.aclArray,
            columnsData.spcname,
            columnsData.relpersistence,
            columnsData.relhasoids,
            array_agg(columnsData.attnum ORDER BY columnsData.attnum) AS col_numbers,
            array_agg(columnsData.attname ORDER BY columnsData.attnum) AS col_names,
            array_agg(columnsData.attoptions ORDER BY columnsData.attnum) AS col_options,
            array_agg(columnsData.attstorage ORDER BY columnsData.attnum) AS col_storages,
            array_agg(columnsData.typstorage ORDER BY columnsData.attnum) AS col_default_storages,
            array_agg(columnsData.defaults ORDER BY columnsData.attnum) AS col_defaults,
            array_agg(columnsData.description ORDER BY columnsData.attnum) AS col_comments,
            array_agg(columnsData.atttypid ORDER BY columnsData.attnum) AS atttypids,
            array_agg(columnsData.atttypname ORDER BY columnsData.attnum) AS atttypname,
            array_agg(columnsData.attnotnull ORDER BY columnsData.attnum) AS col_notnull,
            array_agg(columnsData.attstattarget ORDER BY columnsData.attnum) AS col_statictics,
            array_agg(columnsData.attislocal ORDER BY columnsData.attnum) AS col_local,
            array_agg(columnsData.attacl ORDER BY columnsData.attnum) AS col_acl,
            columnsData.reloptions,
            columnsData.toast_reloptions,
            array_agg(columnsData.attcollation ORDER BY columnsData.attnum) AS col_collation,
            array_agg(columnsData.typcollation ORDER BY columnsData.attnum) AS col_typcollation,
            array_agg(columnsData.attcollationname ORDER BY columnsData.attnum) AS col_collationname,
            array_agg(columnsData.attcollationnspname ORDER BY columnsData.attnum) AS col_collationnspname
     FROM
         (SELECT c.oid,
              c.relname,
              c.reloftype::bigint AS of_type,
              c.relowner::bigint,
              c.relacl::text AS aclArray,
              attr.attnum::integer,
              attr.attname,
              array_to_string(attr.attoptions, ',') attoptions,
              attr.attstorage,
              t.typstorage,
              c.relhasoids,
              pg_catalog.pg_get_expr(attrdef.adbin, attrdef.adrelid) AS defaults,
              comments.description,
              attr.atttypid,
              pg_catalog.format_type(attr.atttypid, attr.atttypmod) AS atttypname,
              attr.attnotnull,
              attr.attstattarget,
              attr.attislocal,
              attr.attacl::text,
              c.reloptions,
              tc.reloptions AS toast_reloptions,
              attr.attcollation,
              t.typcollation,
              tabsp.spcname,
              c.relpersistence,
              (SELECT cl.collname FROM collations cl WHERE cl.oid = attr.attcollation) AS attcollationname,
              (SELECT cl.nspname FROM collations cl WHERE cl.oid = attr.attcollation) AS attcollationnspname
          FROM pg_catalog.pg_class c
          JOIN pg_catalog.pg_attribute attr ON c.oid = attr.attrelid
              AND attr.attisdropped IS FALSE
          LEFT JOIN pg_catalog.pg_attrdef attrdef ON attrdef.adnum = attr.attnum
              AND attr.attrelid = attrdef.adrelid
          LEFT JOIN pg_catalog.pg_description comments ON comments.objoid = attr.attrelid
              AND comments.objsubid = attr.attnum
          LEFT JOIN pg_tablespace tabsp ON tabsp.oid = c.reltablespace
          LEFT JOIN pg_class tc ON (c.reltoastrelid = tc.oid)
          LEFT JOIN pg_catalog.pg_type t ON t.oid = attr.atttypid
          WHERE c.relnamespace = ?
              AND c.relkind = 'r'
              AND c.oid NOT IN (SELECT objid FROM extension_deps)
          ORDER BY attr.attnum) columnsData
     GROUP BY columnsData.oid,
              columnsData.relname,
              columnsData.of_type,
              columnsData.relowner,
              columnsData.aclArray,
              columnsData.reloptions,
              columnsData.toast_reloptions,
              columnsData.relhasoids,
              columnsData.spcname,
              columnsData.relpersistence) subselectColumns
LEFT JOIN pg_catalog.pg_description comments ON comments.objoid = subselectColumns.oid
    AND comments.objsubid = 0
LEFT JOIN
    (SELECT
        array_agg(subinh.inhrelname ORDER BY subinh.inhrelid, subinh.inhseqno) AS inhrelnames,
        array_agg(subinh.inhnspname ORDER BY subinh.inhrelid, subinh.inhseqno) AS inhnspnames,
        subinh.inhrelid
     FROM
         (SELECT inhrelid,
             inhrel.relname as inhrelname,
             inhns.nspname as inhnspname,
             inh.inhseqno
          FROM pg_catalog.pg_inherits inh
          LEFT JOIN pg_catalog.pg_class inhrel ON inh.inhparent = inhrel.oid
          LEFT JOIN pg_catalog.pg_namespace inhns ON inhrel.relnamespace = inhns.oid
          ORDER BY inhrelid, inh.inhseqno ) subinh
     GROUP BY subinh.inhrelid ) subselectInherits ON subselectInherits.inhrelid = subselectColumns.oid
     