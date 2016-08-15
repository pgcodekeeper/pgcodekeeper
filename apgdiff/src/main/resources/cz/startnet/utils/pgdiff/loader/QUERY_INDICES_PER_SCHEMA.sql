-- extension owned indices are skipped by table != null check in java code

SELECT  cls.relname,
	clsrel.relname AS table_name,
	nsp.nspname AS namespace,
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
LEFT JOIN pg_catalog.pg_namespace nsp ON nsp.oid = cls.relnamespace
LEFT JOIN pg_catalog.pg_description des ON ind.indexrelid = des.objoid
    AND des.objsubid = 0
LEFT JOIN pg_catalog.pg_constraint cons ON cons.conindid = ind.indexrelid
WHERE cls.relkind = 'i'
    AND cls.relnamespace = ?
    AND ind.indisprimary = FALSE
    AND ind.indisexclusion = FALSE
    AND cons.conindid is NULL