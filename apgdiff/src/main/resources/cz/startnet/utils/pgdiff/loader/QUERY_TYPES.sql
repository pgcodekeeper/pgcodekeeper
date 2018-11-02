WITH sys_schemas AS (
    SELECT n.oid
    FROM pg_catalog.pg_namespace n
    WHERE n.nspname LIKE 'pg\_%'
        OR n.nspname = 'information_schema'    
), extension_deps AS (
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
    t.oid::bigint,
    t.typname,
    t.typowner::bigint,
    t.typacl::text,
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
    t.typelem::bigint,
    t.typdelim, -- don't output if == ','
    t.typcollation::bigint, -- collatable == (collation != 0)
    -- END BASE

    -- DOMAIN
    pg_catalog.format_type(t.typbasetype, t.typtypmod) AS dom_basetypefmt,
    t.typbasetype::bigint AS dom_basetype,
    -- collation from BASE
    (SELECT tbase.typcollation::bigint FROM pg_catalog.pg_type tbase WHERE tbase.oid = t.typbasetype) AS dom_basecollation,
    (SELECT cl.collname FROM collations cl WHERE cl.oid = t.typcollation) AS dom_collationname, -- don't output if typcollation = dom_basecollation
    (SELECT cl.nspname FROM collations cl WHERE cl.oid = t.typcollation) AS dom_collationnspname,
    -- default from BASE
    pg_catalog.pg_get_expr(t.typdefaultbin, 'pg_catalog.pg_type'::pg_catalog.regclass) AS dom_defaultbin,
    t.typnotnull AS dom_notnull,
    dom_constraints.connames AS dom_connames,
    dom_constraints.condefs AS dom_condefs,
    dom_constraints.concomments AS dom_concomments,
    -- END DOMAIN

    -- ENUM
    (SELECT pg_catalog.array_agg(en.enumlabel ORDER BY en.enumsortorder) FROM pg_catalog.pg_enum en WHERE en.enumtypid = t.oid GROUP BY en.enumtypid) AS enums,
    -- END ENUM

    -- RANGE
    r.rngsubtype::bigint,
    opc.opcname, -- don't output opclass if opcdefault == true; always qualify
    (SELECT n.nspname FROM nspnames n WHERE n.oid = opc.opcnamespace) AS opcnspname,
    opc.opcdefault,
    r.rngcollation::bigint,
    (SELECT tsub.typcollation::bigint FROM pg_catalog.pg_type tsub WHERE tsub.oid = r.rngsubtype) AS rngsubtypcollation,
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
    comp_attrs.attcomments AS comp_attcomments,
    -- END COMPOSITE
    
    t.typnamespace AS schema_oid
FROM pg_catalog.pg_type t
LEFT JOIN pg_catalog.pg_description d ON d.objoid = t.oid
LEFT JOIN pg_catalog.pg_range r ON r.rngtypid = t.oid
LEFT JOIN pg_catalog.pg_opclass opc ON opc.oid = r.rngsubopc
LEFT JOIN
    (SELECT
         c.contypid,
         pg_catalog.array_agg(c.conname ORDER BY c.conname) AS connames,
         pg_catalog.array_agg(pg_catalog.pg_get_constraintdef(c.oid) ORDER BY c.conname) AS condefs,
         pg_catalog.array_agg(cd.description ORDER BY c.conname) AS concomments
     FROM pg_catalog.pg_constraint c
     LEFT JOIN pg_catalog.pg_description cd ON cd.objoid = c.oid
     WHERE c.contypid != 0
     GROUP BY c.contypid) dom_constraints ON dom_constraints.contypid = t.oid
LEFT JOIN
    (SELECT
         a.attrelid,
         pg_catalog.array_agg(a.attname ORDER BY a.attnum) AS attnames,
         pg_catalog.array_agg(pg_catalog.format_type(a.atttypid, a.atttypmod) ORDER BY a.attnum) AS atttypdefns,
         pg_catalog.array_agg(a.atttypid::bigint ORDER BY a.attnum) AS atttypids,
         pg_catalog.array_agg(a.attcollation::bigint ORDER BY a.attnum) AS attcollations,
         pg_catalog.array_agg(ta.typcollation::bigint ORDER BY a.attnum) AS atttypcollations,
         pg_catalog.array_agg(cl.collname ORDER BY a.attnum) AS attcollationnames,
         pg_catalog.array_agg(cl.nspname ORDER BY a.attnum) AS attcollationnspnames,
         pg_catalog.array_agg(d.description ORDER BY a.attnum) AS attcomments
     FROM pg_catalog.pg_attribute a
     LEFT JOIN pg_catalog.pg_type ta ON ta.oid = a.atttypid
     LEFT JOIN collations cl ON cl.oid = a.attcollation
     LEFT JOIN pg_catalog.pg_description d ON d.objoid = a.attrelid AND d.objsubid = a.attnum
     WHERE a.attisdropped = FALSE
     GROUP BY a.attrelid) comp_attrs ON comp_attrs.attrelid = t.typrelid
WHERE t.typnamespace NOT IN (SELECT oid FROM sys_schemas)
    AND t.typisdefined = TRUE
    AND (t.typrelid = 0 OR (SELECT c.relkind FROM pg_catalog.pg_class c WHERE c.oid = t.typrelid) = 'c')
    AND NOT EXISTS(SELECT 1 FROM pg_catalog.pg_type el WHERE el.oid = t.typelem AND el.typarray = t.oid)
    AND t.oid NOT IN (SELECT objid FROM extension_deps) 