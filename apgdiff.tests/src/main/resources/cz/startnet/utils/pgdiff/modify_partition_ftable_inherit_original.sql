CREATE TABLE cities (
    c1 integer,
    c2 text,
    c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));

ALTER TABLE cities OWNER TO galiev_mr;

CREATE TABLE new_cities (
    c1 integer,
    c2 text,
    c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));

ALTER TABLE new_cities OWNER TO galiev_mr;

CREATE FOREIGN TABLE cities_xz PARTITION OF cities
FOR VALUES IN ('x', 'z')
SERVER myserver;

ALTER FOREIGN TABLE ONLY cities_xz ALTER COLUMN c1 SET NOT NULL;

ALTER FOREIGN TABLE cities_xz OWNER TO galiev_mr;