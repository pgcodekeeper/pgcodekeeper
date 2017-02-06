-- extension owned triggers are skipped by rel != null check in java code

SELECT  ccc.relname, 
        r.rulename, 
        r.ev_type, 
        r.is_instead, 
        r.ev_enabled,
        pg_get_ruledef(r.oid) AS rule_string,
        d.description as comment
FROM pg_catalog.pg_rewrite r
JOIN pg_catalog.pg_class ccc ON ccc.oid = r.ev_class 
LEFT JOIN pg_catalog.pg_description d ON r.oid = d.objoid
WHERE ccc.relnamespace = ? AND
    -- block rules that implement views
    NOT ((ccc.relkind = 'v' OR ccc.relkind = 'm') AND r.ev_type = '1' AND r.is_instead)