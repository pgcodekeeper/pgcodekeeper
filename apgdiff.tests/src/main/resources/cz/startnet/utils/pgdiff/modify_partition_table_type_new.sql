CREATE TABLE cities (
    c1 integer,
    c2 text,
    c3 bigint
)
PARTITION BY LIST ("left"(lower(c2), 1));

CREATE TABLE cities_ab (
    c1 integer,
    c2 text,
    c3 bigint
);
