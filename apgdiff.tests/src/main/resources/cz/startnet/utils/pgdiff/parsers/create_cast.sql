CREATE CAST (text AS casttesttype) WITHOUT FUNCTION;
DROP CAST (text AS casttesttype);
CREATE CAST (text AS casttesttype) WITHOUT FUNCTION AS IMPLICIT;
SELECT casttestfunc('foo'::text);
CREATE CAST (int4 AS casttesttype) WITH INOUT;
DROP CAST (int4 AS casttesttype);
CREATE CAST (int4 AS casttesttype) WITH FUNCTION int4_casttesttype(int4) AS IMPLICIT;
DROP CAST (text AS int);
CREATE CAST (bigint AS int4) WITH FUNCTION int4(bigint) AS ASSIGNMENT;
