CREATE FOREIGN TABLE mytable (
    c1 integer
)
SERVER myserver;

ALTER FOREIGN TABLE mytable ALTER COLUMN c1 OPTIONS (column_name 'c1');

ALTER TABLE mytable
    ADD CONSTRAINT mytable_c1_check CHECK ((c1 > 0));