DROP VIEW v8;

-- DEPCY: This TABLE is a dependency of VIEW: v8

CREATE TABLE t3 (
	c1 integer,
	c2 text,
	c3 text
);

ALTER TABLE t3 OWNER TO galiev_mr;

-- DEPCY: This COLUMN is a dependency of VIEW: v8

ALTER TABLE t1
	ADD COLUMN c6 text;

-- DEPCY: This VIEW depends on the VIEW: v2

DROP VIEW v7;

-- DEPCY: This VIEW depends on the VIEW: v2

DROP VIEW v6;

-- DEPCY: This VIEW depends on the VIEW: v2

DROP VIEW v5;

DROP VIEW v2;

-- DEPCY: This VIEW is a dependency of VIEW: v8

CREATE VIEW v2 AS
	SELECT t2.c1,
    t2.c2,
    t2.c4
   FROM t2;

ALTER VIEW v2 OWNER TO galiev_mr;

-- DEPCY: This VIEW is a dependency of VIEW: v8

CREATE VIEW v6 AS
	SELECT v2.c1,
    v2.c2,
    t1.c6
   FROM v2,
    t1;

ALTER VIEW v6 OWNER TO galiev_mr;

-- DEPCY: This VIEW is a dependency of VIEW: v8

CREATE VIEW v7 AS
	SELECT v2.c1,
    v6.c2
   FROM v2,
    v6;

ALTER VIEW v7 OWNER TO galiev_mr;

-- DEPCY: This VIEW depends on the COLUMN: t1.c4

DROP VIEW v4;

-- DEPCY: This VIEW depends on the COLUMN: t1.c4

DROP VIEW v1;

ALTER TABLE t1
	ALTER COLUMN c4 TYPE integer USING c4::integer; /* TYPE change - table: t1 original: text new: integer */

DROP VIEW v3;

-- DEPCY: This VIEW is a dependency of VIEW: v8

CREATE VIEW v3 AS
	SELECT t1.c1,
    t2.c2,
    t1.c6
   FROM t1,
    t2;

ALTER VIEW v3 OWNER TO galiev_mr;

-- DEPCY: This VIEW is a dependency of VIEW: v8

CREATE VIEW v1 AS
	SELECT t1.c1,
    t1.c2,
    t1.c3,
    t1.c4
   FROM t1;

ALTER VIEW v1 OWNER TO galiev_mr;

-- DEPCY: This VIEW is a dependency of VIEW: v8

CREATE VIEW v4 AS
	SELECT v1.c1,
    v3.c2,
    t1.c4
   FROM v1,
    v3,
    t1;

ALTER VIEW v4 OWNER TO galiev_mr;

-- DEPCY: This VIEW is a dependency of VIEW: v8

CREATE VIEW v5 AS
	SELECT v2.c1,
    v3.c2,
    v4.c4
   FROM v2,
    v3,
    v4;

ALTER VIEW v5 OWNER TO galiev_mr;

CREATE VIEW v8 AS
	SELECT v5.c1,
    v7.c2,
    t3.c3
   FROM v5,
    v7,
    t3;

ALTER VIEW v8 OWNER TO galiev_mr;
