SELECT relname,
       relacl,
       relowner::bigint,
       pg_get_viewdef(c.oid) AS definition,
       d.description AS comment,
       array_agg(dep.deptype) AS deptype,
       subselect.column_names,
       subselect.column_comments,
       subselect.column_defaults
FROM pg_catalog.pg_class c
LEFT JOIN
    (SELECT attrelid,
            array_agg(columnsData.attname) AS column_names,
            array_agg(columnsData.description) AS column_comments,
            array_agg(columnsData.adsrc) AS column_defaults
     FROM
         (SELECT attrelid,
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
LEFT JOIN pg_catalog.pg_depend dep ON dep.objid = c.oid
WHERE relkind = 'v'
    AND relnamespace = ?
GROUP BY relname,
         relowner,
         definition,
         comment,
         relacl,
         subselect.column_names,
         subselect.column_comments,
         subselect.column_defaults