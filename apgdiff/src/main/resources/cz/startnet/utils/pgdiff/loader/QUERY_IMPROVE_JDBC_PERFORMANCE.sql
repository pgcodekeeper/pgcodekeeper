CREATE SCHEMA performance;

CREATE OR REPLACE FUNCTION performance.get_all_table()
  RETURNS TABLE(oid bigint,
	nspname text,
       relname name,
       relowner bigint,
       aclArray text,
       col_numbers integer[],
       col_names name[],
       col_defaults text[],
       col_comments text[],
       col_type_name text[],
       col_notnull boolean[],
       col_collation oid[],
       col_statictics integer[],
       col_local boolean[],
       col_typcollation oid[],
       col_collationname name[],
       col_collationnspname name[],
       col_acl text[],
       table_comment text,
       table_space name,
       has_oids boolean,
       inherited text[],
       reloptions text[],
       toast_reloptions text[]) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT 
	n.oid::bigint,
       n.nspname
FROM pg_catalog.pg_namespace n
JOIN pg_catalog.pg_roles r ON n.nspowner = r.oid
    AND n.nspname NOT LIKE ('pg_%')
    AND n.nspname != 'information_schema'
LEFT JOIN pg_catalog.pg_description d ON n.oid = d.objoid
LOOP
	EXECUTE 'SET search_path TO ' || schema_name;
	RETURN QUERY (



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
	schema_name,
       subselectColumns.relname,
       subselectColumns.relowner::bigint,
       subselectColumns.aclArray,
       subselectColumns.col_numbers,
       subselectColumns.col_names,
       subselectColumns.col_defaults,
       subselectColumns.col_comments,
       subselectColumns.atttypname as col_type_name,
       subselectColumns.col_notnull,
       subselectColumns.col_collation,
       subselectColumns.col_statictics,
       subselectColumns.col_local,
       subselectColumns.col_typcollation,
       subselectColumns.col_collationname,
       subselectColumns.col_collationnspname,
       subselectColumns.col_acl,
       comments.description AS table_comment,
       subselectColumns.spcname as table_space,
       subselectColumns.relhasoids as has_oids,
       subselectInherits.inherited,
       subselectColumns.reloptions,
       subselectColumns.toast_reloptions
FROM
    (SELECT columnsData.oid,
            columnsData.relname,
            columnsData.relowner,
            columnsData.aclArray,
            columnsData.spcname,
            columnsData.relhasoids,
            array_agg(columnsData.attnum ORDER BY columnsData.attnum) AS col_numbers,
            array_agg(columnsData.attname ORDER BY columnsData.attnum) AS col_names,
            array_agg(columnsData.defaults ORDER BY columnsData.attnum) AS col_defaults,
            array_agg(columnsData.description ORDER BY columnsData.attnum) AS col_comments,
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
              c.relowner::bigint,
              c.relacl::text AS aclArray,
              attr.attnum::integer,
              attr.attname,
              c.relhasoids,
              pg_catalog.pg_get_expr(attrdef.adbin, attrdef.adrelid) AS defaults,
              comments.description,
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
          WHERE c.relnamespace = schema_oid
              AND c.relkind = 'r'
              AND c.oid NOT IN (SELECT objid FROM extension_deps)
          ORDER BY attr.attnum) columnsData
     GROUP BY columnsData.oid,
              columnsData.relname,
              columnsData.relowner,
              columnsData.aclArray,
              columnsData.reloptions,
              columnsData.toast_reloptions,
              columnsData.relhasoids,
              columnsData.spcname) subselectColumns
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
     GROUP BY subinh.inhrelid ) subselectInherits ON subselectInherits.inhrelid = subselectColumns.oid);



END LOOP;
EXECUTE 'SET search_path TO ' || schema_name_current;
RETURN;
END
$BODY$
  LANGUAGE plpgsql;

SELECT * FROM performance.get_all_table();
  
  ------------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION performance.get_all_view()
  RETURNS TABLE(relname name,  nspname text, relacl aclitem[], relowner bigint, definition text, comment text, column_names name[], column_comments text[], column_defaults text[], column_acl text[]) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR oid, schema_name IN SELECT 
	n.oid::bigint,
       n.nspname
FROM pg_catalog.pg_namespace n
JOIN pg_catalog.pg_roles r ON n.nspowner = r.oid
    AND n.nspname NOT LIKE ('pg_%')
    AND n.nspname != 'information_schema'
LEFT JOIN pg_catalog.pg_description d ON n.oid = d.objoid
LOOP
	EXECUTE 'SET search_path TO ' || schema_name;
	RETURN QUERY (WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_extension'::regclass 
        AND dep.deptype = 'e'
)

SELECT c.relname,
	   schema_name,
       c.relacl,
       c.relowner::bigint,
       pg_get_viewdef(c.oid) AS definition,
       d.description AS comment,
       subselect.column_names,
       subselect.column_comments,
       subselect.column_defaults,
       subselect.column_acl
FROM pg_catalog.pg_class c
LEFT JOIN
    (SELECT attrelid,
            array_agg(columnsData.attname ORDER BY columnsData.attnum) AS column_names,
            array_agg(columnsData.description ORDER BY columnsData.attnum) AS column_comments,
            array_agg(columnsData.adsrc ORDER BY columnsData.attnum) AS column_defaults,
            array_agg(columnsData.attacl ORDER BY columnsData.attnum) AS column_acl
     FROM
         (SELECT attnum,
                 attrelid,
                 attr.attname,
                 attr.attacl::text,
                 des.description,
                 def.adsrc
          FROM pg_catalog.pg_attribute attr
          LEFT JOIN pg_catalog.pg_attrdef def ON def.adnum = attr.attnum
              AND attr.attrelid = def.adrelid
              AND attr.attisdropped IS FALSE
          LEFT JOIN pg_catalog.pg_description des ON des.objoid = attr.attrelid
              AND des.objsubid = attr.attnum
          ORDER BY attr.attnum) columnsData
     GROUP BY attrelid) subselect ON subselect.attrelid = c.oid
LEFT JOIN pg_catalog.pg_description d ON c.oid = d.objoid
    AND d.objsubid = 0
WHERE relnamespace = oid
    AND relkind = 'v'
    AND c.oid NOT IN (SELECT objid FROM extension_deps));

END LOOP;
EXECUTE 'SET search_path TO ' || schema_name_current;
RETURN;
END
$BODY$
  LANGUAGE plpgsql;
  
  ------------------------------------------------------------------------------------------------------
  
  CREATE OR REPLACE FUNCTION performance.get_all_function()
  RETURNS TABLE(proname name,
	nspname text,
        proowner oid,
        lang_name name,
        prosrc text,
        proiswindow boolean,
        provolatile "char",
        proleakproof boolean,
        proisstrict boolean,
        prosecdef boolean,
        procost real,
        prorows real,
        proconfig text[],
        probin text,
        prorettype bigint,
        proallargtypes bigint[],
        proargmodes "char"[],
        proargnames text[],
        proarguments text,
        proarguments_without_default text,
        proargdefaults pg_node_tree,
        aclArray aclitem[],
        comment text,
        proretset boolean) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT 
	n.oid::bigint,
       n.nspname
FROM pg_catalog.pg_namespace n
JOIN pg_catalog.pg_roles r ON n.nspowner = r.oid
    AND n.nspname NOT LIKE ('pg_%')
    AND n.nspname != 'information_schema'
LEFT JOIN pg_catalog.pg_description d ON n.oid = d.objoid
LOOP
	EXECUTE 'SET search_path TO ' || schema_name;
	RETURN QUERY (



WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_extension'::regclass 
        AND dep.deptype = 'e'
)

SELECT p.proname,
	schema_name,
        p.proowner,
        l.lanname AS lang_name,
        p.prosrc,
        p.proiswindow,
        p.provolatile,
        p.proleakproof,
        p.proisstrict,
        p.prosecdef,
        p.procost::real,
        p.prorows::real,
        p.proconfig,
        p.probin,
        p.prorettype::bigint,
        p.proallargtypes::bigint[],
        p.proargmodes,
        p.proargnames,
        pg_get_function_arguments(p.oid) AS proarguments,
        pg_get_function_identity_arguments(p.oid) AS proarguments_without_default,
        p.proargdefaults,
        proacl AS aclArray,
        d.description AS comment,
        p.proretset
FROM pg_catalog.pg_proc p
LEFT JOIN pg_catalog.pg_description d ON d.objoid = p.oid
LEFT JOIN pg_catalog.pg_language l ON l.oid = p.prolang
WHERE pronamespace = schema_oid
    AND proisagg = FALSE
    AND NOT EXISTS (SELECT 1 FROM pg_catalog.pg_depend dp WHERE dp.classid = 'pg_proc'::regclass AND dp.objid = p.oid AND dp.deptype = 'i')
    AND p.oid NOT IN (SELECT objid FROM extension_deps));



END LOOP;
EXECUTE 'SET search_path TO ' || schema_name_current;
RETURN;
END
$BODY$
  LANGUAGE plpgsql;
  
  -----------------------------------------------------------------------------------------------------------------
  
  CREATE OR REPLACE FUNCTION performance.get_all_index()
  RETURNS TABLE(table_name name,
	indisunique boolean,
    relname name,
    nspname name,
    isClustered boolean,
    relowner oid,
    comment text,
    table_space name,
    definition text) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT 
	n.oid::bigint,
       n.nspname
FROM pg_catalog.pg_namespace n
JOIN pg_catalog.pg_roles r ON n.nspowner = r.oid
    AND n.nspname NOT LIKE ('pg_%')
    AND n.nspname != 'information_schema'
LEFT JOIN pg_catalog.pg_description d ON n.oid = d.objoid
LOOP
	EXECUTE 'SET search_path TO ' || schema_name;
	RETURN QUERY (



SELECT ccc.relname AS table_name,
    i.indisunique,
    c.relname,
    (SELECT n.nspname
     FROM pg_catalog.pg_namespace n
     WHERE c.relnamespace = n.oid) namespace,
     i.indisclustered as isClustered,
    c.relowner,
    d.description AS comment,
    tabsp.spcname as table_space,
    definition2
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_index i ON ccc.oid = i.indrelid
LEFT JOIN pg_catalog.pg_description d ON i.indexrelid = d.objoid
    AND d.objsubid = 0
JOIN pg_catalog.pg_class c ON c.oid = i.indexrelid
LEFT JOIN pg_catalog.pg_tablespace tabsp ON tabsp.oid = c.reltablespace
LEFT JOIN pg_catalog.pg_constraint cons ON cons.conindid = i.indexrelid,
pg_get_indexdef(c.oid) definition2
WHERE ccc.relkind = 'r'
    AND ccc.relnamespace = schema_oid
    AND i.indisprimary = FALSE
    AND i.indisexclusion = FALSE
    AND cons.conindid is NULL
ORDER BY relname);



END LOOP;
EXECUTE 'SET search_path TO ' || schema_name_current;
RETURN;
END
$BODY$
  LANGUAGE plpgsql;
  
  
  
  -----------------------------------------------------------------------------------------------------------
  
  CREATE OR REPLACE FUNCTION performance.get_all_constraint()
  RETURNS TABLE(relname name, nspname text,
    conname name,
    contype "char",
    conrelid oid,
    consrc_usable text,
    conkey integer[],
    confrelid oid,
    confrelid_name text,
    foreign_table_name name,
    foreign_schema_name name,
    confkey integer[],
    confupdtype "char",
    confdeltype "char",
    confmatchtype "char",
    description text,
    definition text) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT 
	n.oid::bigint,
       n.nspname
FROM pg_catalog.pg_namespace n
JOIN pg_catalog.pg_roles r ON n.nspowner = r.oid
    AND n.nspname NOT LIKE ('pg_%')
    AND n.nspname != 'information_schema'
LEFT JOIN pg_catalog.pg_description d ON n.oid = d.objoid
LOOP
	EXECUTE 'SET search_path TO ' || schema_name;
	RETURN QUERY (



SELECT ccc.relname,
schema_name,
    c.conname,
    c.contype,
    c.conrelid,
    pg_get_expr(conbin, ccc.oid) AS consrc_usable,
    c.conkey::integer[],
    c.confrelid,
    c.confrelid::regclass::text AS confrelid_name,
    (SELECT cx.relname
     FROM pg_catalog.pg_class cx
     WHERE cx.oid = c.confrelid) AS foreign_table_name,
    (SELECT nsp.nspname
     FROM pg_catalog.pg_namespace nsp
     WHERE nsp.oid =
             (SELECT cx.relnamespace
              FROM pg_catalog.pg_class cx
              WHERE cx.oid = c.confrelid)) AS foreign_schema_name,
    c.confkey::integer[],
    c.confupdtype,
    c.confdeltype,
    c.confmatchtype,
    d.description,
    pg_get_constraintdef(c.oid) as definition
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_constraint c ON ccc.oid = c.conrelid
LEFT JOIN pg_catalog.pg_description d ON c.oid = d.objoid
WHERE ccc.relkind = 'r'
    AND ccc.relnamespace = schema_oid);

END LOOP;
EXECUTE 'SET search_path TO ' || schema_name_current;
RETURN;
END
$BODY$
  LANGUAGE plpgsql;
  
  -------------------------------------------------------------------------------------------------
  
  CREATE OR REPLACE FUNCTION performance.get_all_sequence()
  RETURNS TABLE(sequence_oid oid, nspname text,
       relowner oid,
       relname name,
       start_value bigint,
       minimum_value bigint,
       maximum_value bigint,
       increment bigint,
       cycle_option boolean,
       referenced_column integer,
       referenced_table_name text,
       comment text,
       ref_col_name name,
       aclArray aclitem[]) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT 
	n.oid::bigint,
       n.nspname
FROM pg_catalog.pg_namespace n
JOIN pg_catalog.pg_roles r ON n.nspowner = r.oid
    AND n.nspname NOT LIKE ('pg_%')
    AND n.nspname != 'information_schema'
LEFT JOIN pg_catalog.pg_description d ON n.oid = d.objoid
LOOP
	EXECUTE 'SET search_path TO ' || schema_name;
	RETURN QUERY (



WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_extension'::regclass 
        AND dep.deptype = 'e'
)

SELECT c.oid AS sequence_oid,
schema_name,
       c.relowner,
       c.relname,
       p.start_value::bigint AS start_value,
       p.minimum_value::bigint AS minimum_value,
       p.maximum_value::bigint AS maximum_value,
       p.increment::bigint AS increment,
       p.cycle_option AS cycle_option,
       d.refobjsubid AS referenced_column,
       d.refobjid::regclass::text referenced_table_name,
       descr.description AS comment,
       a.attname AS ref_col_name,
       c.relacl AS aclArray
FROM pg_catalog.pg_class c
LEFT JOIN pg_catalog.pg_depend d ON d.objid = c.oid
    AND d.refobjsubid != 0
LEFT JOIN pg_catalog.pg_description descr ON c.oid = descr.objoid
    AND descr.objsubid = 0
LEFT JOIN pg_catalog.pg_attribute a ON a.attrelid = d.refobjid
    AND a.attnum = d.refobjsubid
    AND a.attisdropped IS FALSE,
pg_sequence_parameters(c.oid) p(start_value, minimum_value, maximum_value, increment, cycle_option)
WHERE c.relnamespace = schema_oid
    AND c.relkind = 'S'
    AND c.oid NOT IN (SELECT objid FROM extension_deps));

END LOOP;
EXECUTE 'SET search_path TO ' || schema_name_current;
RETURN;
END
$BODY$
  LANGUAGE plpgsql;
  
  -------------------------------------------------------------------------------------------------
  
  CREATE OR REPLACE FUNCTION performance.get_all_trigger()
  RETURNS TABLE(relname name,
       proname name,
       nspname name,
       tgname name,
       tgfoid oid,
       tgtype smallint,
       tgrelid text,
       tgargs bytea,
       table_oid oid,
       col_numbers int2[],
       definition text,
       comment text) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT 
	n.oid::bigint,
       n.nspname
FROM pg_catalog.pg_namespace n
JOIN pg_catalog.pg_roles r ON n.nspowner = r.oid
    AND n.nspname NOT LIKE ('pg_%')
    AND n.nspname != 'information_schema'
LEFT JOIN pg_catalog.pg_description d ON n.oid = d.objoid
LOOP
	EXECUTE 'SET search_path TO ' || schema_name;
	RETURN QUERY (




SELECT ccc.relname,
       p.proname,
       nsp.nspname,
       t.tgname,
       t.tgfoid,
       t.tgtype,
       t.tgrelid::regclass::text,
       t.tgargs,
       t.tgrelid as table_oid,
       t.tgattr::int2[] as col_numbers,
       pg_get_triggerdef(t.oid,false) || ';' AS definition,
       d.description as comment
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_trigger t ON ccc.oid = t.tgrelid
LEFT JOIN pg_catalog.pg_description d ON t.oid = d.objoid
    AND d.objsubid = 0
JOIN pg_catalog.pg_proc p ON p.oid = t.tgfoid
JOIN pg_catalog.pg_namespace nsp ON p.pronamespace = nsp.oid
WHERE ccc.relkind = 'r'
    AND ccc.relnamespace = schema_oid
    AND tgisinternal = FALSE);

END LOOP;
EXECUTE 'SET search_path TO ' || schema_name_current;
RETURN;
END
$BODY$
  LANGUAGE plpgsql;
  
    -------------------------------------------------------------------------------------------------
  
  CREATE OR REPLACE FUNCTION performance.get_all_rule()
  RETURNS TABLE(relname name, 
		nspname text,
		rulename name, 
		ev_type "char", 
		ev_enabled "char", 
		is_instead boolean,  
		rule_string text,
		comment text) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT 
	n.oid::bigint,
       n.nspname
FROM pg_catalog.pg_namespace n
JOIN pg_catalog.pg_roles r ON n.nspowner = r.oid
    AND n.nspname NOT LIKE ('pg_%')
    AND n.nspname != 'information_schema'
LEFT JOIN pg_catalog.pg_description d ON n.oid = d.objoid
LOOP
	EXECUTE 'SET search_path TO ' || schema_name;
	RETURN QUERY (




SELECT  ccc.relname, 
		schema_name,
		r.rulename, 
		r.ev_type, 
		r.ev_enabled, 
		r.is_instead, 
		pg_get_ruledef(r.oid) AS rule_string,
		d.description as comment
FROM pg_catalog.pg_rewrite r
JOIN pg_catalog.pg_class ccc ON ccc.oid = r.ev_class 
LEFT JOIN pg_catalog.pg_description d ON r.oid = d.objoid
WHERE ccc.relnamespace = schema_oid AND
    -- block rules that implement views
    NOT ((ccc.relkind = 'v' OR ccc.relkind = 'm') AND r.ev_type = '1' AND r.is_instead));

END LOOP;
EXECUTE 'SET search_path TO ' || schema_name_current;
RETURN;
END
$BODY$
  LANGUAGE plpgsql;