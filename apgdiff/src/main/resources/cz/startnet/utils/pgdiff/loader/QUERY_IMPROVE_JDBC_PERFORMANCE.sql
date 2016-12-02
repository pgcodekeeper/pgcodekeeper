CREATE SCHEMA IF NOT EXISTS pgcodekeeperhelper;

-- these functions only read pg_catalog metadata, so it's safe to expose them to PUBLIC
-- you may alter access rights as you need
GRANT USAGE ON SCHEMA pgcodekeeperhelpers to PUBLIC;

-- you may remove functions from this schema 
-- doing so will impose performance penalty on reading corresponding object types

-- DO NOT ALTER the functions themselves or their signatures
-- doing so will most likely result in failures to read the DB schema using JDBC

CREATE OR REPLACE FUNCTION pgcodekeeperhelper.get_all_tables(schema_oids bigint[], schema_names text[])
  RETURNS TABLE(
       schema_oid bigint,
       relname name,
       relowner bigint,
       aclArray text,
       col_numbers integer[],
       col_names name[],
       col_defaults text[],
       col_comments text[],
       col_type_ids oid[],
       col_type_name text[],
       col_notnull boolean[],
       col_collation oid[],
       col_statictics integer[],
       col_local boolean[],
       col_typcollation oid[],
       col_collationname name[],
       col_collationnspname name[],
       col_attseq text[],
       col_acl text[],
       table_comment text,
       table_space name,
       has_oids boolean,
       inhrelnames name[],
       inhnspnames name[],
       reloptions text[],
       toast_reloptions text[]) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT unnest(schema_oids), unnest(schema_names)
LOOP
	EXECUTE 'SET search_path TO ' || quote_literal(schema_name);
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

SELECT schema_oid,
       subselectColumns.relname,
       subselectColumns.relowner::bigint,
       subselectColumns.aclArray,
       subselectColumns.col_numbers,
       subselectColumns.col_names,
       subselectColumns.col_defaults,
       subselectColumns.col_comments,
       subselectColumns.atttypids as col_type_ids,
       subselectColumns.atttypname as col_type_name,
       subselectColumns.col_notnull,
       subselectColumns.col_collation,
       subselectColumns.col_statictics,
       subselectColumns.col_local,
       subselectColumns.col_typcollation,
       subselectColumns.col_collationname,
       subselectColumns.col_collationnspname,
       subselectColumns.col_attseq,
       subselectColumns.col_acl,
       comments.description AS table_comment,
       subselectColumns.spcname as table_space,
       subselectColumns.relhasoids as has_oids,
       subselectInherits.inhrelnames,
       subselectInherits.inhnspnames,
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
            array_agg(columnsData.attcollationnspname ORDER BY columnsData.attnum) AS col_collationnspname,
            array_agg(columnsData.attseq ORDER BY columnsData.attnum) AS col_attseq
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
              (SELECT cl.collname FROM collations cl WHERE cl.oid = attr.attcollation) AS attcollationname,
              (SELECT cl.nspname FROM collations cl WHERE cl.oid = attr.attcollation) AS attcollationnspname,
              pg_catalog.pg_get_serial_sequence(quote_ident(c.relname), attr.attname) AS attseq
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
     GROUP BY subinh.inhrelid ) subselectInherits ON subselectInherits.inhrelid = subselectColumns.oid);



END LOOP;
EXECUTE 'SET search_path TO ' || quote_literal(schema_name_current);
RETURN;
END
$BODY$
  LANGUAGE plpgsql;

------------------------------------------------------------------------------------------------

CREATE OR REPLACE FUNCTION pgcodekeeperhelper.get_all_views(schema_oids bigint[], schema_names text[])
  RETURNS TABLE(
    schema_oid bigint,
    relname name,
    relacl aclitem[],
    relowner bigint,
    definition text,
    comment text,
    column_names name[],
    column_comments text[],
    column_defaults text[],
    column_acl text[]) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT unnest(schema_oids), unnest(schema_names)
LOOP
	EXECUTE 'SET search_path TO ' || quote_literal(schema_name);
	RETURN QUERY (
	
	
WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_extension'::regclass 
        AND dep.deptype = 'e'
)

SELECT schema_oid,
       c.relname,
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
WHERE relnamespace = schema_oid
    AND relkind = 'v'
    AND c.oid NOT IN (SELECT objid FROM extension_deps));

END LOOP;
EXECUTE 'SET search_path TO ' || quote_literal(schema_name_current);
RETURN;
END
$BODY$
  LANGUAGE plpgsql;
  
  ------------------------------------------------------------------------------------------------------
  
CREATE OR REPLACE FUNCTION pgcodekeeperhelper.get_all_functions(schema_oids bigint[], schema_names text[])
  RETURNS TABLE(
        schema_oid bigint,
        proname name,
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
	FOR schema_oid, schema_name IN SELECT unnest(schema_oids), unnest(schema_names)
LOOP
	EXECUTE 'SET search_path TO ' || quote_literal(schema_name);
	RETURN QUERY (



WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_extension'::regclass 
        AND dep.deptype = 'e'
)

SELECT schema_oid,
        p.proname,
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
EXECUTE 'SET search_path TO ' || quote_literal(schema_name_current);
RETURN;
END
$BODY$
  LANGUAGE plpgsql;
  
  -----------------------------------------------------------------------------------------------------------------
  
CREATE OR REPLACE FUNCTION pgcodekeeperhelper.get_all_indices(schema_oids bigint[], schema_names text[])
  RETURNS TABLE(
    schema_oid bigint,
    relname name,
    table_name name,
	indisunique boolean,
    isClustered boolean,
    comment text,
    definition text,
    cols name[]) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT unnest(schema_oids), unnest(schema_names)
LOOP
	EXECUTE 'SET search_path TO ' || quote_literal(schema_name);
	RETURN QUERY (



SELECT schema_oid,
    cls.relname,
    clsrel.relname AS table_name,
    ind.indisunique,
    ind.indisclustered as isClustered,
    des.description AS comment,
    pg_get_indexdef(cls.oid) AS definition,
    (SELECT array_agg(attr.attname)
        FROM pg_catalog.pg_attribute attr
        WHERE attr.attrelid = ind.indrelid 
            AND attr.attnum = any(ind.indkey)) AS cols
FROM pg_catalog.pg_index ind
JOIN pg_catalog.pg_class cls ON cls.oid = ind.indexrelid
JOIN pg_catalog.pg_class clsrel ON clsrel.oid = ind.indrelid
LEFT JOIN pg_catalog.pg_description des ON ind.indexrelid = des.objoid
    AND des.objsubid = 0
LEFT JOIN pg_catalog.pg_constraint cons ON cons.conindid = ind.indexrelid
    AND cons.contype IN ('p', 'u', 'x')
WHERE cls.relkind = 'i'
    AND cls.relnamespace = schema_oid
    AND ind.indisprimary = FALSE
    AND ind.indisexclusion = FALSE
    AND cons.conindid is NULL);



END LOOP;
EXECUTE 'SET search_path TO ' || quote_literal(schema_name_current);
RETURN;
END
$BODY$
  LANGUAGE plpgsql;
  
  
  
  -----------------------------------------------------------------------------------------------------------
  
CREATE OR REPLACE FUNCTION pgcodekeeperhelper.get_all_constraints(schema_oids bigint[], schema_names text[])
  RETURNS TABLE(
    schema_oid bigint,
    relname name,
    conname name,
    contype "char",
    foreign_table_name name,
    foreign_schema_name name,
    foreign_cols name[],
    cols name[],
    description text,
    definition text) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT unnest(schema_oids), unnest(schema_names)
LOOP
	EXECUTE 'SET search_path TO ' || quote_literal(schema_name);
	RETURN QUERY (



SELECT schema_oid,
    ccc.relname,
    c.conname,
    c.contype,
    cf.relname AS foreign_table_name,
    (SELECT nsp.nspname
     FROM pg_catalog.pg_namespace nsp
     WHERE nsp.oid = cf.relnamespace) AS foreign_schema_name,
    (SELECT array_agg(attname ORDER BY attnum) 
     FROM pg_attribute a
     WHERE a.attrelid = cf.oid AND a.attnum = ANY(c.confkey)) AS foreign_cols,
    (SELECT array_agg(attname ORDER BY attnum) 
     FROM pg_attribute a
     WHERE a.attrelid = ccc.oid AND a.attnum = ANY(c.conkey)) AS cols,
    d.description,
    pg_get_constraintdef(c.oid) as definition
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_constraint c ON ccc.oid = c.conrelid
LEFT JOIN pg_catalog.pg_class cf ON cf.oid = c.confrelid
LEFT JOIN pg_catalog.pg_description d ON c.oid = d.objoid
WHERE ccc.relkind = 'r'
    AND ccc.relnamespace = schema_oid);

END LOOP;
EXECUTE 'SET search_path TO ' || quote_literal(schema_name_current);
RETURN;
END
$BODY$
  LANGUAGE plpgsql;
  
  -------------------------------------------------------------------------------------------------
  
CREATE OR REPLACE FUNCTION pgcodekeeperhelper.get_all_sequences(schema_oids bigint[], schema_names text[])
  RETURNS TABLE(
       schema_oid bigint,
       relowner oid,
       relname name,
       comment text,
       referenced_table_name text,
       ref_col_name name,
       aclArray aclitem[]) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT unnest(schema_oids), unnest(schema_names)
LOOP
	EXECUTE 'SET search_path TO ' || quote_literal(schema_name);
	RETURN QUERY (



WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_extension'::regclass 
        AND dep.deptype = 'e'
)

SELECT schema_oid,
       c.relowner,
       c.relname,
       descr.description AS comment,
       d.refobjid::regclass::text referenced_table_name,
       a.attname AS ref_col_name,
       c.relacl AS aclArray
FROM pg_catalog.pg_class c
LEFT JOIN pg_catalog.pg_depend d ON d.objid = c.oid
    AND d.refobjsubid != 0
LEFT JOIN pg_catalog.pg_description descr ON c.oid = descr.objoid
    AND descr.objsubid = 0
LEFT JOIN pg_catalog.pg_attribute a ON a.attrelid = d.refobjid
    AND a.attnum = d.refobjsubid
    AND a.attisdropped IS FALSE
WHERE c.relnamespace = schema_oid
    AND c.relkind = 'S'
    AND c.oid NOT IN (SELECT objid FROM extension_deps));

END LOOP;
EXECUTE 'SET search_path TO ' || quote_literal(schema_name_current);
RETURN;
END
$BODY$
  LANGUAGE plpgsql;

  -------------------------------------------------------------------------------------------------
  
CREATE OR REPLACE FUNCTION pgcodekeeperhelper.get_all_triggers(schema_oids bigint[], schema_names text[])
  RETURNS TABLE(
       schema_oid bigint,
       relname name,
       proname name,
       nspname name,
       tgname name,
       tgtype smallint,
       tgargs bytea,
       cols name[],
       definition text,
       comment text) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
	show search_path into schema_name_current;
	FOR schema_oid, schema_name IN SELECT unnest(schema_oids), unnest(schema_names)
LOOP
	EXECUTE 'SET search_path TO ' || quote_literal(schema_name);
	RETURN QUERY (




SELECT schema_oid,
       ccc.relname,
       p.proname,
       nsp.nspname,
       t.tgname,
       t.tgtype,
       t.tgargs,
       (SELECT array_agg(attname ORDER BY attnum) 
        FROM pg_attribute a
        WHERE a.attrelid = ccc.oid AND a.attnum = ANY(t.tgattr)) AS cols,
       pg_get_triggerdef(t.oid,false) || ';' AS definition,
       d.description as comment
FROM pg_catalog.pg_class ccc
RIGHT JOIN pg_catalog.pg_trigger t ON ccc.oid = t.tgrelid
LEFT JOIN pg_catalog.pg_description d ON t.oid = d.objoid
    AND d.objsubid = 0
JOIN pg_catalog.pg_proc p ON p.oid = t.tgfoid
JOIN pg_catalog.pg_namespace nsp ON p.pronamespace = nsp.oid
WHERE (ccc.relkind = 'r' OR ccc.relkind = 'v')
    AND ccc.relnamespace = schema_oid
    AND tgisinternal = FALSE);

END LOOP;
EXECUTE 'SET search_path TO ' || quote_literal(schema_name_current);
RETURN;
END
$BODY$
  LANGUAGE plpgsql;
  
    -------------------------------------------------------------------------------------------------
  
CREATE OR REPLACE FUNCTION pgcodekeeperhelper.get_all_rules(schema_oids bigint[], schema_names text[])
  RETURNS TABLE(
        schema_oid bigint,
        relname name,
		rulename name,
		ev_type "char",
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
	FOR schema_oid, schema_name IN SELECT unnest(schema_oids), unnest(schema_names)
LOOP
	EXECUTE 'SET search_path TO ' || quote_literal(schema_name);
	RETURN QUERY (




SELECT schema_oid,
        ccc.relname,
        r.rulename, 
        r.ev_type, 
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

EXECUTE 'SET search_path TO ' || quote_literal(schema_name_current);
RETURN;
END
$BODY$
  LANGUAGE plpgsql;

    -------------------------------------------------------------------------------------------------
  
CREATE OR REPLACE FUNCTION pgcodekeeperhelper.get_all_types(schema_oids bigint[], schema_names text[])
  RETURNS TABLE(
            schema_oid bigint,
            typname name,
            typowner oid,
            typacl aclitem[],
            typtype "char",
            description text,
            typinput regproc,
            typoutput regproc,
            typreceive regproc,
            typsend regproc,
            typmodin regproc,
            typmodout regproc,
            typanalyze regproc,
            typreceiveset boolean,
            typsendset boolean,
            typmodinset boolean,
            typmodoutset boolean,
            typanalyzeset boolean,
            typlen smallint,
            typbyval boolean,
            typalign "char",
            typstorage "char",
            typcategory "char",
            typispreferred boolean,
            typdefaultbin text,
            typdefault text,
            typelem oid,
            typdelim "char",
            typcollation oid,
            dom_basetypefmt text,
            dom_basetype oid,
            dom_basecollation oid,
            dom_collationname name,
            dom_collationnspname name,
            dom_defaultbin text,
            dom_notnull boolean,
            dom_connames name[],
            dom_condefs text[],
            dom_convalidates boolean[],
            dom_concomments text[],
            enums name[],
            rngsubtype oid,
            opcname name,
            opcnspname name,
            opcdefault boolean,
            rngcollation oid,
            rngsubtypcollation oid,
            rngcollationname name,
            rngcollationnspname name,
            rngcanonical regproc,
            rngsubdiff regproc,
            rngcanonicalset boolean,
            rngsubdiffset boolean,
            comp_attnames name[],
            comp_atttypdefns text[],
            comp_atttypids oid[],
            comp_attcollations oid[],
            comp_atttypcollations oid[],
            comp_attcollationnames name[],
            comp_attcollationnspnames name[],
            comp_attcomments text[]) AS
$BODY$
DECLARE
schema_name text;
schema_name_current text;
schema_oid bigint;
BEGIN
    show search_path into schema_name_current;
    FOR schema_oid, schema_name IN SELECT unnest(schema_oids), unnest(schema_names)
LOOP
    EXECUTE 'SET search_path TO ' || quote_literal(schema_name);
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
SELECT schema_oid,
    -- GENERAL
    t.typname,
    --(SELECT n.nspname FROM nspnames n WHERE n.oid = t.typnamespace) AS typnspname,
    t.typowner,
    t.typacl,
    -- t.typisdefined, -- false == SHELL type; pg_dump ignores those
    t.typtype, -- b/c/d/e/r, p - pseudotype (?)
    d.description,
    -- END GENERAL

    -- BASE
    t.typinput,
    t.typoutput,
    t.typreceive,
    t.typsend,
    t.typmodin,
    t.typmodout,
    t.typanalyze,
    t.typreceive != 0 AS typreceiveset,
    t.typsend != 0 AS typsendset,
    t.typmodin != 0 AS typmodinset,
    t.typmodout != 0 AS typmodoutset,
    t.typanalyze != 0 AS typanalyzeset,
    
    t.typlen,
    t.typbyval,
    t.typalign, -- convert into char/int2/int4/double
    t.typstorage, -- convert into plain/external(e)/extended(x)/main
    t.typcategory, -- don't output if == 'U'
    t.typispreferred,
    pg_catalog.pg_get_expr(t.typdefaultbin, 0) AS typdefaultbin, -- prefer this over typdefault
    t.typdefault, -- if using this, single-quote and escape it
    t.typelem,
    t.typdelim, -- don't output if == ','
    t.typcollation, -- collatable == (collation != 0)
    -- END BASE

    -- DOMAIN
    pg_catalog.format_type(t.typbasetype, t.typtypmod) AS dom_basetypefmt,
    t.typbasetype AS dom_basetype,
    -- collation from BASE
    (SELECT tbase.typcollation FROM pg_catalog.pg_type tbase WHERE tbase.oid = t.typbasetype) AS dom_basecollation,
    (SELECT cl.collname FROM collations cl WHERE cl.oid = t.typcollation) AS dom_collationname, -- don't output if typcollation = dom_basecollation
    (SELECT cl.nspname FROM collations cl WHERE cl.oid = t.typcollation) AS dom_collationnspname,
    -- default from BASE
    pg_catalog.pg_get_expr(t.typdefaultbin, 'pg_catalog.pg_type'::pg_catalog.regclass) AS dom_defaultbin,
    t.typnotnull AS dom_notnull,
    dom_constraints.connames AS dom_connames,
    dom_constraints.condefs AS dom_condefs,
    dom_constraints.convalidates AS dom_convalidates,
    dom_constraints.concomments AS dom_concomments,
    -- END DOMAIN

    -- ENUM
    (SELECT array_agg(en.enumlabel ORDER BY en.enumsortorder) FROM pg_catalog.pg_enum en WHERE en.enumtypid = t.oid GROUP BY en.enumtypid) AS enums,
    -- END ENUM

    -- RANGE
    r.rngsubtype,
    opc.opcname, -- don't output opclass if opcdefault == true; always qualify
    (SELECT n.nspname FROM nspnames n WHERE n.oid = opc.opcnamespace) AS opcnspname,
    opc.opcdefault,
    r.rngcollation,
    (SELECT tsub.typcollation FROM pg_catalog.pg_type tsub WHERE tsub.oid = r.rngsubtype) AS rngsubtypcollation,
    (SELECT cl.collname FROM collations cl WHERE cl.oid = r.rngcollation) AS rngcollationname, -- don't output if rngcollation == rngsubtypcollation
    (SELECT cl.nspname FROM collations cl WHERE cl.oid = r.rngcollation) AS rngcollationnspname, 
    r.rngcanonical,
    r.rngsubdiff,
    r.rngcanonical != 0 AS rngcanonicalset,
    r.rngsubdiff != 0 AS rngsubdiffset,
    -- END RANGE

    -- COMPOSITE
    comp_attrs.attnames AS comp_attnames,
    comp_attrs.atttypdefns AS comp_atttypdefns,
    comp_attrs.atttypids AS comp_atttypids,
    comp_attrs.attcollations AS comp_attcollations,
    comp_attrs.atttypcollations AS comp_atttypcollations,
    comp_attrs.attcollationnames AS comp_attcollationnames, -- don't output if comp_attcollations[i] = comp_atttypcollations[i]
    comp_attrs.attcollationnspnames AS comp_attcollationnspnames,
    comp_attrs.attcomments AS comp_attcomments
    -- END COMPOSITE
FROM pg_catalog.pg_type t
LEFT JOIN pg_catalog.pg_description d ON d.objoid = t.oid
LEFT JOIN pg_catalog.pg_range r ON r.rngtypid = t.oid
LEFT JOIN pg_catalog.pg_opclass opc ON opc.oid = r.rngsubopc
LEFT JOIN
    (SELECT
         c.contypid,
         array_agg(c.conname ORDER BY c.conname) AS connames,
         array_agg(pg_catalog.pg_get_constraintdef(c.oid) ORDER BY c.conname) AS condefs,
         array_agg(c.convalidated ORDER BY c.conname) AS convalidates,
         array_agg(cd.description ORDER BY c.conname) AS concomments
     FROM pg_catalog.pg_constraint c
     LEFT JOIN pg_catalog.pg_description cd ON cd.objoid = c.oid
     WHERE c.contypid != 0
     GROUP BY c.contypid) dom_constraints ON dom_constraints.contypid = t.oid
LEFT JOIN
    (SELECT
         comp_attrs_list.attrelid,
         array_agg(comp_attrs_list.attname ORDER BY comp_attrs_list.attnum) AS attnames,
         array_agg(comp_attrs_list.atttypdefn ORDER BY comp_attrs_list.attnum) AS atttypdefns,
         array_agg(comp_attrs_list.atttypid ORDER BY comp_attrs_list.attnum) AS atttypids,
         array_agg(comp_attrs_list.attcollation ORDER BY comp_attrs_list.attnum) AS attcollations,
         array_agg(comp_attrs_list.atttypcollation ORDER BY comp_attrs_list.attnum) AS atttypcollations,
         array_agg(comp_attrs_list.attcollationname ORDER BY comp_attrs_list.attnum) AS attcollationnames,
         array_agg(comp_attrs_list.attcollationnspname ORDER BY comp_attrs_list.attnum) AS attcollationnspnames,
         array_agg(comp_attrs_list.description ORDER BY comp_attrs_list.attnum) AS attcomments
     FROM -- this query needs filtering on non-groupby field so we do that in a sub and aggregate here
         (SELECT
              a.attnum,
              a.attrelid,
              a.attname,
              pg_catalog.format_type(a.atttypid, a.atttypmod) AS atttypdefn,
              a.atttypid,
              a.attcollation,
              ta.typcollation AS atttypcollation,
              cl.collname AS attcollationname,
              cl.nspname AS attcollationnspname,
              d.description
          FROM pg_catalog.pg_attribute a
          LEFT JOIN pg_catalog.pg_type ta ON ta.oid = a.atttypid
          LEFT JOIN collations cl ON cl.oid = a.attcollation
          LEFT JOIN pg_catalog.pg_description d ON d.objoid = a.attrelid
              AND d.objsubid = a.attnum
          WHERE a.attisdropped = FALSE) comp_attrs_list
     GROUP BY attrelid) comp_attrs ON comp_attrs.attrelid = t.typrelid
WHERE typnamespace = schema_oid
    AND t.typisdefined = TRUE
    AND (t.typrelid = 0 OR (SELECT c.relkind FROM pg_catalog.pg_class c WHERE c.oid = t.typrelid) = 'c')
    AND NOT EXISTS(SELECT 1 FROM pg_catalog.pg_type el WHERE el.oid = t.typelem AND el.typarray = t.oid)
    AND t.oid NOT IN (SELECT objid FROM extension_deps));

END LOOP;

EXECUTE 'SET search_path TO ' || quote_literal(schema_name_current);
RETURN;
END
$BODY$
  LANGUAGE plpgsql;
