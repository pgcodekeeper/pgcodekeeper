CREATE TABLE t2 (
    t2_c1 character(1),
    c_seq integer NOT NULL
);


CREATE VIEW v3 AS
 SELECT a.t2_c1
   FROM t2 a;


CREATE VIEW v3_boo AS
 SELECT a.t2_c1
   FROM v3 a;

