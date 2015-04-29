CREATE TABLE t1 (
    c1 text,
    c2 boolean
);

CREATE VIEW v2 AS
 SELECT a.c1
   FROM t1 a;


CREATE VIEW v1 AS
 SELECT a.c1
   FROM v2 a;



GRANT ALL ON SCHEMA public TO maindb;
