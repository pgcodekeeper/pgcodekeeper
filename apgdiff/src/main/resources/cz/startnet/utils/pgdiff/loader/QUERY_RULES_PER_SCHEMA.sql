-- extension owned triggers are skipped by table != null check in java code

SELECT  ccc.relname, 
		r.rulename, 
		r.ev_class, 
		r.ev_attr, 
		r.ev_type, 
		r.ev_enabled, 
		r.is_instead, 
		pg_get_ruledef(r.oid) AS rule_string
FROM pg_catalog.pg_rewrite r
JOIN pg_catalog.pg_class ccc ON ccc.oid = r.ev_class AND ccc.relnamespace = ?