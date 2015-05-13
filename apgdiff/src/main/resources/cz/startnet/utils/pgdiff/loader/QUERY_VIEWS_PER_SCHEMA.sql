WITH extension_deps AS (
    SELECT dep.objid 
    FROM pg_catalog.pg_depend dep 
    WHERE refclassid = 'pg_extension'::regclass 
        AND dep.deptype = 'e'
)

SELECT relname,
       relacl,
       relowner::bigint,
       pg_get_viewdef(c.oid) AS definition,
       d.description AS comment,
       subselect.column_names,
       subselect.column_comments,
       subselect.column_defaults
FROM pg_catalog.pg_class c
LEFT JOIN
    (SELECT attrelid,
            array_agg(columnsData.attname ORDER BY columnsData.attnum) AS column_names,
            array_agg(columnsData.description ORDER BY columnsData.attnum) AS column_comments,
            array_agg(columnsData.adsrc ORDER BY columnsData.attnum) AS column_defaults
     FROM
         (SELECT attnum,
                 attrelid,
                 attr.attname,
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
WHERE relnamespace = ?
    AND relkind = 'v'
    AND c.oid NOT IN (SELECT objid FROM extension_deps)