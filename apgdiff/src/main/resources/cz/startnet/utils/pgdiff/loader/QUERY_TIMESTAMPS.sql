SELECT f.type,
       f.schema,
       f.name,
       f.identity,
       t.last_modified
FROM pgcodekeeperhelper.ddl_events t,
LATERAL pg_identify_object(t.classid, t.objid, t.objsubid) f(type, schema, name, identity);