SET search_path = public, pg_catalog;

DROP FOREIGN TABLE cities_xz;

CREATE FOREIGN TABLE cities_xz PARTITION OF new_cities
FOR VALUES IN ('x', 'z')
SERVER myserver;

ALTER FOREIGN TABLE ONLY cities_xz ALTER COLUMN c1 SET NOT NULL;

ALTER FOREIGN TABLE cities_xz OWNER TO galiev_mr;