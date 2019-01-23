-- Used in java code with MessageFormat
-- A single quote itself must be escaped by using two single quotes ('').
WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = '''pg_catalog.pg_extension'''::pg_catalog.regclass 
        AND dep.deptype = '''e'''
)
SELECT * 
FROM {0}.dbots_object_timestamps t
WHERE t.objid NOT IN (SELECT objid FROM extension_deps)