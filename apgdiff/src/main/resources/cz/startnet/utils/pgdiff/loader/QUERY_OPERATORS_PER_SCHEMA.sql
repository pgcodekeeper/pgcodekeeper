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
)

SELECT o.oprname AS name, 
       o.oprnamespace AS schema_oid,
       prc.proname AS procedure,
       prc_n.nspname AS procedure_nsp,
       o.oprleft::bigint AS leftArg,
       o.oprright::bigint AS rightArg,
       com.oprname AS commutator,
       com_n.nspname AS commutator_nsp,
       neg.oprname AS negator,
       neg_n.nspname AS negator_nsp,
       o.oprcanmerge AS is_merges,
       o.oprcanhash AS is_hashes,
       prc_r.proname AS restrict,
       prc_r_n.nspname AS restrict_nsp,
       prc_j.proname AS join,
       prc_j_n.nspname AS join_nsp,
       o.oprowner AS owner,
       d.description AS comment
FROM pg_catalog.pg_operator o
LEFT JOIN pg_catalog.pg_description d ON d.objoid = o.oid
JOIN pg_catalog.pg_proc prc ON o.oprcode = prc.oid
LEFT JOIN pg_catalog.pg_namespace prc_n ON prc.pronamespace = prc_n.oid
LEFT JOIN pg_catalog.pg_operator com ON o.oprcom = com.oid
LEFT JOIN pg_catalog.pg_namespace com_n ON com.oprnamespace = com_n.oid
LEFT JOIN pg_catalog.pg_operator neg ON o.oprnegate = neg.oid
LEFT JOIN pg_catalog.pg_namespace neg_n ON neg.oprnamespace = neg_n.oid
LEFT JOIN pg_catalog.pg_proc prc_r ON o.oprrest = prc_r.oid
LEFT JOIN pg_catalog.pg_namespace prc_r_n ON prc_r.pronamespace = prc_r_n.oid
LEFT JOIN pg_catalog.pg_proc prc_j ON o.oprjoin = prc_j.oid
LEFT JOIN pg_catalog.pg_namespace prc_j_n ON prc_j.pronamespace = prc_j_n.oid
WHERE o.oprnamespace NOT IN (SELECT oid FROM sys_schemas)
    AND o.oid NOT IN (SELECT objid FROM extension_deps)
