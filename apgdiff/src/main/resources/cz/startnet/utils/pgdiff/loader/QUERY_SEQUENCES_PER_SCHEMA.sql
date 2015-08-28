WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_extension'::regclass 
        AND dep.deptype = 'e'
)

SELECT c.oid AS sequence_oid,
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
WHERE c.relnamespace = ?
    AND c.relkind = 'S'
    AND c.oid NOT IN (SELECT objid FROM extension_deps)