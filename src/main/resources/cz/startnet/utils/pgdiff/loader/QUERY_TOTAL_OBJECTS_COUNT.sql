SELECT COUNT(c.oid)::integer
FROM pg_catalog.pg_class c
WHERE c.relnamespace IN
        (SELECT nsp.oid
         FROM pg_catalog.pg_namespace nsp
         WHERE nsp.nspname NOT LIKE ('pg_%')
             AND nsp.nspname != 'information_schema')
             AND c.relkind IN ('r', 'i', 'S', 'v')