WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_catalog.pg_extension'::pg_catalog.regclass 
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

SELECT  -- GENERAL
    c.oid,
    c.relname,
    c.relkind,
    c.relowner::bigint,
    c.relacl::text AS aclarray,
    c.relpersistence AS persistence,
    c.relhasoids AS has_oids,
    c.reloptions,
    tc.reloptions AS toast_reloptions,
    tabsp.spcname AS table_space,
    d.description AS table_comment,
    
    -- inherits tables
    parents.inhrelnames,
    parents.inhnspnames,
    
    -- foreign table
    ftbl.ftoptions, 
    ser.srvname AS server_name,
    
    --typed table
    c.reloftype::bigint AS of_type,
    
    --columns
   columns.col_names,
   columns.col_options,
   columns.col_foptions,
   columns.col_storages,
   columns.col_default_storages,
   columns.col_has_default,
   columns.col_defaults,
   columns.col_comments,
   columns.col_type_ids,
   columns.col_type_name,
   columns.col_notnull,
   columns.col_statictics,
   columns.col_local,
   columns.col_acl,
   columns.col_collation,
   columns.col_typcollation,
   columns.col_collationname,
   columns.col_collationnspname
    
FROM pg_catalog.pg_class c
LEFT JOIN pg_catalog.pg_foreign_table ftbl ON ftbl.ftrelid = c.relfilenode
LEFT JOIN pg_catalog.pg_foreign_server ser ON ser.oid = ftbl.ftserver
LEFT JOIN pg_catalog.pg_tablespace tabsp ON tabsp.oid = c.reltablespace
LEFT JOIN pg_catalog.pg_description d ON d.objoid = c.oid AND d.objsubid = 0
LEFT JOIN pg_catalog.pg_class tc ON tc.oid = c.reltoastrelid
LEFT JOIN (SELECT
            a.attrelid,
            pg_catalog.array_agg(a.attname ORDER BY a.attnum) AS col_names,
            pg_catalog.array_agg(pg_catalog.array_to_string(a.attoptions, ',') ORDER BY a.attnum) AS col_options,
            pg_catalog.array_agg(pg_catalog.array_to_string(a.attfdwoptions, ',') ORDER BY a.attnum) AS col_foptions,
            pg_catalog.array_agg(a.attstorage ORDER BY a.attnum) AS col_storages,
            pg_catalog.array_agg(t.typstorage ORDER BY a.attnum) AS col_default_storages,
            pg_catalog.array_agg(a.atthasdef ORDER BY a.attnum) AS col_has_default,
            pg_catalog.array_agg(pg_catalog.pg_get_expr(attrdef.adbin, attrdef.adrelid) ORDER BY a.attnum) AS col_defaults,
            pg_catalog.array_agg(d.description ORDER BY a.attnum) AS col_comments,
            pg_catalog.array_agg(a.atttypid::bigint ORDER BY a.attnum) AS col_type_ids,
            pg_catalog.array_agg(pg_catalog.format_type(a.atttypid, a.atttypmod) ORDER BY a.attnum) AS col_type_name,
            
             -- skips not null for column, if parents have not null 
            pg_catalog.array_agg(
                (CASE WHEN a.attnotnull THEN 
                    NOT EXISTS (
                        SELECT 1 FROM pg_catalog.pg_inherits inh 
                        LEFT JOIN pg_catalog.pg_attribute attr ON attr.attrelid = inh.inhparent
                        WHERE inh.inhrelid = a.attrelid 
                        AND attr.attnotnull
                        AND attr.attname = a.attname)
                    ELSE FALSE
                    END
                ) ORDER BY a.attnum) AS col_notnull,
            
            pg_catalog.array_agg(a.attstattarget ORDER BY a.attnum) AS col_statictics,
            pg_catalog.array_agg(a.attislocal ORDER BY a.attnum) AS col_local,
            pg_catalog.array_agg(a.attacl::text ORDER BY a.attnum) AS col_acl,
            pg_catalog.array_agg(a.attcollation::bigint ORDER BY a.attnum) AS col_collation,
            pg_catalog.array_agg(t.typcollation::bigint ORDER BY a.attnum) AS col_typcollation,
            pg_catalog.array_agg(cl.collname ORDER BY a.attnum) AS col_collationname,
            pg_catalog.array_agg(cl.nspname ORDER BY a.attnum) AS col_collationnspname
      FROM pg_catalog.pg_attribute a
      LEFT JOIN pg_catalog.pg_attrdef attrdef ON attrdef.adnum = a.attnum AND a.attrelid = attrdef.adrelid
      LEFT JOIN pg_catalog.pg_description d ON d.objoid = a.attrelid AND d.objsubid = a.attnum
      LEFT JOIN pg_catalog.pg_type t ON t.oid = a.atttypid
      LEFT JOIN collations cl ON cl.oid =  a.attcollation
      WHERE a.attisdropped IS FALSE
            AND a.attnum > 0 
      GROUP BY attrelid) columns ON columns.attrelid = c.oid
LEFT JOIN (SELECT
        inh.inhrelid,
        pg_catalog.array_agg(inhrel.relname ORDER BY inh.inhrelid, inh.inhseqno) AS inhrelnames,
        pg_catalog.array_agg(inhns.nspname ORDER BY inh.inhrelid, inh.inhseqno) AS inhnspnames
     FROM pg_catalog.pg_inherits inh
     LEFT JOIN pg_catalog.pg_class inhrel ON inh.inhparent = inhrel.oid
     LEFT JOIN pg_catalog.pg_namespace inhns ON inhrel.relnamespace = inhns.oid
     GROUP BY inh.inhrelid) parents ON parents.inhrelid = c.oid
 WHERE c.relnamespace = ?
       AND c.relkind IN ('f','r','p')
       AND c.oid NOT IN (SELECT objid FROM extension_deps)