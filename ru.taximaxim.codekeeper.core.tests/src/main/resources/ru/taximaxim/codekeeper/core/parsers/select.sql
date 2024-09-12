SELECT * FROM onek WHERE onek.unique1 < 10 ORDER BY onek.unique1;
SELECT onek.unique1, onek.stringu1 FROM onek WHERE onek.unique1 < 20 ORDER BY unique1 using >;
SELECT onek.unique1, onek.stringu1 FROM onek WHERE onek.unique1 > 980 ORDER BY stringu1 using <;
SELECT onek.unique1, onek.string4 FROM onek WHERE onek.unique1 > 980 ORDER BY string4 using <, unique1 using >;
SELECT onek.unique1, onek.string4 FROM onek WHERE onek.unique1 > 980 ORDER BY string4 using >, unique1 using <;
SELECT onek.unique1, onek.string4 FROM onek WHERE onek.unique1 < 20 ORDER BY unique1 using >, string4 using <;
SELECT onek.unique1, onek.string4 FROM onek WHERE onek.unique1 < 20 ORDER BY unique1 using <, string4 using >;
SELECT onek2.* FROM onek2 WHERE onek2.unique1 < 10;
SELECT onek2.unique1, onek2.stringu1 FROM onek2 WHERE onek2.unique1 < 20 ORDER BY unique1 using >;
SELECT onek2.unique1, onek2.stringu1 FROM onek2 WHERE onek2.unique1 > 980;
SELECT two, stringu1, ten, string4 FROM onek;
SELECT p.name, p.age FROM person* p;
SELECT p.name, p.age FROM person* p ORDER BY age using >, name;
select foo from (select 1 offset 0) as foo;
select foo from (select null offset 0) as foo;
select foo from (select 'xyzzy',1,null offset 0) as foo;
select * from onek, (values(147, 'RFAAAA'), (931, 'VJAAAA')) as v (i, j) WHERE onek.unique1 = v.i and onek.stringu1 = v.j;
select * from onek, (values ((select i from (values(10), (20), ((select 19))) as foo(i) order by i asc limit 1))) bar (i) where onek.unique1 = bar.i;
select * from onek where (unique1,ten) in (values (1,1), (20,0), (99,9), (17,99)) order by unique1;
VALUES (1,2), (3,4+4), (7,77.7);
VALUES (1,2), (3,4+4), (7,77.7) UNION ALL SELECT 2+2, 57 UNION ALL TABLE int8_tbl;
INSERT INTO foo VALUES (42),(3),(10),(7),(null),(null),(1);
SELECT * FROM foo ORDER BY f1;
SELECT * FROM foo ORDER BY f1 ASC;  -- same thing
SELECT * FROM foo ORDER BY f1 NULLS FIRST;
SELECT * FROM foo ORDER BY f1 DESC;
SELECT * FROM foo ORDER BY f1 DESC NULLS LAST;
SELECT * FROM foo ORDER BY f1;
SELECT * FROM foo ORDER BY f1 NULLS FIRST;
SELECT * FROM foo ORDER BY f1 DESC;
SELECT * FROM foo ORDER BY f1 DESC NULLS LAST;
select * from onek2 where unique2 = 11 and stringu1 = 'ATAAAA';
select unique2 from onek2 where unique2 = 11 and stringu1 = 'ATAAAA';
select * from onek2 where unique2 = 11 and stringu1 < 'B';
select unique2 from onek2 where unique2 = 11 and stringu1 < 'B';
select unique2 from onek2 where unique2 = 11 and stringu1 < 'B' for update;
select unique1, unique2 from onek2 where (unique2 = 11 or unique1 = 0) and stringu1 < 'B';
select unique1, unique2 from onek2 where (unique2 = 11 and stringu1 < 'B') or unique1 = 0;
SELECT 1 AS x ORDER BY x;
select sillysrf(42);
select sillysrf(-1) order by 1;
select * from (values (2),(null),(1)) v(k) where k = k order by k;
select * from (values (2),(null),(1)) v(k) where k = k;
SELECT * INTO TABLE sitmp1 FROM onek WHERE onek.unique1 < 2;
SELECT * INTO TABLE selinto_schema.tmp1 FROM pg_class WHERE relname like '%a%';
SELECT oid AS clsoid, relname, relnatts + 10 AS x INTO selinto_schema.tmp2 FROM pg_class WHERE relname like '%b%';
SELECT * INTO TABLE selinto_schema.tmp1 FROM pg_class WHERE relname like '%a%';
SELECT * FROM (SELECT 1 INTO f) bar;
SELECT b,
       b ~ '^[[:alpha:]]+$' AS is_alpha,
       b ~ '^[[:upper:]]+$' AS is_upper,
       b ~ '^[[:lower:]]+$' AS is_lower,
       b ~ '^[[:digit:]]+$' AS is_digit,
       b ~ '^[[:alnum:]]+$' AS is_alnum,
       b ~ '^[[:graph:]]+$' AS is_graph,
       b ~ '^[[:print:]]+$' AS is_print,
       b ~ '^[[:punct:]]+$' AS is_punct,
       b ~ '^[[:space:]]+$' AS is_space
FROM collate_test6;

WITH RECURSIVE foo(x) AS
   (SELECT x FROM (VALUES('a' COLLATE "en-x-icu"),('b')) t(x)
   UNION ALL
   SELECT (x || 'c') COLLATE "de-x-icu" FROM foo WHERE length(x) < 10)
SELECT * FROM foo;

SELECT a, b, a < b as lt FROM
  (VALUES ('a', 'B'), ('A', 'b' COLLATE "C")) v(a,b);

SELECT a, CAST(b AS varchar) FROM collate_test1 ORDER BY 2;

SELECT a.b AS a, b.b AS b, a.b < b.b COLLATE "C" AS lt,
       mylt(a.b, b.b COLLATE "C"), mylt_noninline(a.b, b.b COLLATE "C"),
       mylt_plpgsql(a.b, b.b COLLATE "C")
FROM collate_test1 a, collate_test1 b
ORDER BY a.b, b.b;

SELECT mylt2('a', 'B' collate "en-x-icu") as t, mylt2('a', 'B' collate "C") as f;
SELECT * FROM unnest((SELECT array_agg(b ORDER BY b) FROM collate_test3)) ORDER BY 1;
select textrange_c('A','Z') @> 'b'::text;
select textrange_en_us('A','Z') @> 'b'::text;
SELECT v, b, (v || b) AS concat FROM BIT_TABLE, VARBIT_TABLE ORDER BY 3;
SELECT b, length(b) AS lb FROM BIT_TABLE;
SELECT b,
       SUBSTRING(b FROM 2 FOR 4) AS sub_2_4,
       SUBSTRING(b FROM 7 FOR 13) AS sub_7_13,
       SUBSTRING(b FROM 6) AS sub_6
       FROM BIT_TABLE;
SELECT v,
       SUBSTRING(v FROM 2 FOR 4) AS sub_2_4,
       SUBSTRING(v FROM 7 FOR 13) AS sub_7_13,
       SUBSTRING(v FROM 6) AS sub_6
       FROM VARBIT_TABLE;
SELECT a, b, ~a AS "~ a", a & b AS "a & b",
       a | b AS "a | b", a # b AS "a # b" FROM varbit_table;
SELECT a,b,a<b AS "a<b",a<=b AS "a<=b",a=b AS "a=b",
        a>=b AS "a>=b",a>b AS "a>b",a<>b AS "a<>b" FROM varbit_table;
SELECT a,a<<4 AS "a<<4",b,b>>2 AS "b>>2" FROM varbit_table;

-- The following should fail
select B'001' & B'10';
select B'0111' | B'011';
select B'0010' # B'011101';

-- More position tests, checking all the boundary cases
SELECT POSITION(B'1010' IN B'0000101');   -- 0
SELECT POSITION(B'1010' IN B'00001010');  -- 5
SELECT POSITION(B'1010' IN B'00000101');  -- 0
SELECT POSITION(B'1010' IN B'000001010');  -- 6
SELECT POSITION(B'' IN B'00001010');  -- 1
SELECT POSITION(B'0' IN B'');  -- 0
SELECT POSITION(B'' IN B'');  -- 0
SELECT POSITION(B'101101' IN B'001011011011011000');  -- 3
SELECT POSITION(B'10110110' IN B'001011011011010');  -- 3
SELECT POSITION(B'1011011011011' IN B'001011011011011');  -- 3
SELECT POSITION(B'11101011' IN B'11101011'); -- 1
SELECT POSITION(B'11101011' IN B'011101011'); -- 2
SELECT POSITION(B'111010110' IN B'0000000011101011111010110'); -- 17
SELECT POSITION(B'111010110' IN B'000000000011101011111010110'); -- 19
SELECT POSITION(B'0000000000011101011111010110' IN B'000000000011101011111010110'); -- 0
SELECT POSITION(B'1101' IN b), POSITION(B'11011' IN b), b FROM t1 ;
SELECT get_bit(B'0101011000100', 10);
SELECT set_bit(B'0101011000100100', 15, 1);
SELECT set_bit(B'0101011000100100', 16, 1); -- fail
SELECT overlay(B'0101011100' placing '001' from 2 for 3);
SELECT overlay(B'0101011100' placing '101' from 6);
SELECT overlay(B'0101011100' placing '001' from 11);
SELECT overlay(B'0101011100' placing '001' from 20);
SELECT 1 AS two UNION SELECT 2 ORDER BY 1;
SELECT 1 AS one UNION SELECT 1 ORDER BY 1;
SELECT 1 AS two UNION ALL SELECT 2;
SELECT 1 AS two UNION ALL SELECT 1;
SELECT 1 AS three UNION SELECT 2 UNION SELECT 3 ORDER BY 1;
SELECT 1 AS two UNION SELECT 2 UNION SELECT 2 ORDER BY 1;
SELECT 1 AS three UNION SELECT 2 UNION ALL SELECT 2 ORDER BY 1;
SELECT 1.1 AS two UNION SELECT 2.2 ORDER BY 1;
SELECT 1.1 AS two UNION SELECT 2 ORDER BY 1;
SELECT 1 AS two UNION SELECT 2.2 ORDER BY 1;
SELECT 1 AS one UNION SELECT 1.0::float8 ORDER BY 1;
SELECT 1.1 AS two UNION ALL SELECT 2 ORDER BY 1;
SELECT 1.0::float8 AS two UNION ALL SELECT 1 ORDER BY 1;
SELECT 1.1 AS three UNION SELECT 2 UNION SELECT 3 ORDER BY 1;
SELECT 1.1::float8 AS two UNION SELECT 2 UNION SELECT 2.0::float8 ORDER BY 1;
SELECT 1.1 AS three UNION SELECT 2 UNION ALL SELECT 2 ORDER BY 1;
SELECT 1.1 AS two UNION (SELECT 2 UNION ALL SELECT 2) ORDER BY 1;
SELECT f1 AS five FROM FLOAT8_TBL UNION SELECT f1 FROM FLOAT8_TBL ORDER BY 1;
SELECT f1 AS ten FROM FLOAT8_TBL UNION ALL SELECT f1 FROM FLOAT8_TBL;
SELECT f1 AS nine FROM FLOAT8_TBL UNION SELECT f1 FROM INT4_TBL ORDER BY 1;
SELECT f1 AS ten FROM FLOAT8_TBL UNION ALL SELECT f1 FROM INT4_TBL;
SELECT f1 AS five FROM FLOAT8_TBL WHERE f1 BETWEEN -1e6 AND 1e6 UNION SELECT f1 FROM INT4_TBL WHERE f1 BETWEEN 0 AND 1000000 ORDER BY 1;
SELECT CAST(f1 AS char(4)) AS three FROM VARCHAR_TBL UNION SELECT f1 FROM CHAR_TBL ORDER BY 1;
SELECT f1 AS three FROM VARCHAR_TBL UNION SELECT CAST(f1 AS varchar) FROM CHAR_TBL ORDER BY 1;
SELECT f1 AS eight FROM VARCHAR_TBL UNION ALL SELECT f1 FROM CHAR_TBL;
SELECT f1 AS five FROM TEXT_TBL UNION SELECT f1 FROM VARCHAR_TBL UNION SELECT TRIM(TRAILING FROM f1) FROM CHAR_TBL ORDER BY 1;
SELECT q2 FROM int8_tbl INTERSECT SELECT q1 FROM int8_tbl ORDER BY 1;
SELECT q2 FROM int8_tbl INTERSECT ALL SELECT q1 FROM int8_tbl ORDER BY 1;
SELECT q2 FROM int8_tbl EXCEPT SELECT q1 FROM int8_tbl ORDER BY 1;
SELECT q2 FROM int8_tbl EXCEPT ALL SELECT q1 FROM int8_tbl ORDER BY 1;
SELECT q2 FROM int8_tbl EXCEPT ALL SELECT DISTINCT q1 FROM int8_tbl ORDER BY 1;
SELECT q1 FROM int8_tbl EXCEPT SELECT q2 FROM int8_tbl ORDER BY 1;
SELECT q1 FROM int8_tbl EXCEPT ALL SELECT q2 FROM int8_tbl ORDER BY 1;
SELECT q1 FROM int8_tbl EXCEPT ALL SELECT DISTINCT q2 FROM int8_tbl ORDER BY 1;
SELECT q1 FROM int8_tbl EXCEPT ALL SELECT q1 FROM int8_tbl FOR NO KEY UPDATE;
(SELECT 1,2,3 UNION SELECT 4,5,6) INTERSECT SELECT 4,5,6;
(SELECT 1,2,3 UNION SELECT 4,5,6 ORDER BY 1,2) INTERSECT SELECT 4,5,6;
(SELECT 1,2,3 UNION SELECT 4,5,6) EXCEPT SELECT 4,5,6;
(SELECT 1,2,3 UNION SELECT 4,5,6 ORDER BY 1,2) EXCEPT SELECT 4,5,6;
select count(*) from ( select unique1 from tenk1 intersect select fivethous from tenk1 ) ss;
select count(*) from ( select unique1 from tenk1 intersect select fivethous from tenk1 ) ss;
select unique1 from tenk1 except select unique2 from tenk1 where unique2 != 10;
select unique1 from tenk1 except select unique2 from tenk1 where unique2 != 10;
select count(*) from ( select unique1 from tenk1 intersect select fivethous from tenk1 ) ss;
select count(*) from ( select unique1 from tenk1 intersect select fivethous from tenk1 ) ss;
select unique1 from tenk1 except select unique2 from tenk1 where unique2 != 10;
select unique1 from tenk1 except select unique2 from tenk1 where unique2 != 10;
SELECT f1 FROM float8_tbl INTERSECT SELECT f1 FROM int4_tbl ORDER BY 1;
SELECT f1 FROM float8_tbl EXCEPT SELECT f1 FROM int4_tbl ORDER BY 1;
SELECT q1 FROM int8_tbl INTERSECT SELECT q2 FROM int8_tbl UNION ALL SELECT q2 FROM int8_tbl  ORDER BY 1;
SELECT q1 FROM int8_tbl INTERSECT (((SELECT q2 FROM int8_tbl UNION ALL SELECT q2 FROM int8_tbl))) ORDER BY 1;
(((SELECT q1 FROM int8_tbl INTERSECT SELECT q2 FROM int8_tbl ORDER BY 1))) UNION ALL SELECT q2 FROM int8_tbl;
SELECT q1 FROM int8_tbl UNION ALL SELECT q2 FROM int8_tbl EXCEPT SELECT q1 FROM int8_tbl ORDER BY 1;
SELECT q1 FROM int8_tbl UNION ALL (((SELECT q2 FROM int8_tbl EXCEPT SELECT q1 FROM int8_tbl ORDER BY 1)));
(((SELECT q1 FROM int8_tbl UNION ALL SELECT q2 FROM int8_tbl))) EXCEPT SELECT q1 FROM int8_tbl ORDER BY 1;
SELECT q1,q2 FROM int8_tbl EXCEPT SELECT q2,q1 FROM int8_tbl ORDER BY q2,q1;
SELECT q1 FROM int8_tbl EXCEPT SELECT q2 FROM int8_tbl ORDER BY q2 LIMIT 1;
SELECT q1 FROM int8_tbl EXCEPT (((SELECT q2 FROM int8_tbl ORDER BY q2 LIMIT 1))) ORDER BY 1;
(((((select * from int8_tbl)))));
SELECT a.f1 FROM (SELECT 'test' AS f1 FROM varchar_tbl) a UNION SELECT b.f1 FROM (SELECT f1 FROM varchar_tbl) b ORDER BY 1;
SELECT '3.4'::numeric UNION SELECT 'foo';
select 1 union ((select 2 union select 3));
select 1 union ((select 2 union (((select 3)))));
select ( select 1 union select 2);
select ( select 1 union select 2 limit 1);
select ( select 1 union (((select 2))) limit 1);
select ( select 1 union (( select 3 union (select 2))) limit 1);
select ( select 1 union (( select 3 union (select 2))) limit 1 offset 1);
select ( select 1 union (( select 3 union (select 2))) limit 1 offset 2);
select ( select 1 union (( select 3 union (select 2))) limit 1 offset 3);
select ( (select 1 union select 2) union (select 3 union select 4) limit 1  );
select ( (select 1 union select 2) union (select 3 union select 4) limit 1 offset 3 );
select ( (select 1 union select 2) union (select 3 union select 4) limit 1 offset 2 );
select ( select 1 union select 2 union select 3 union select 4   );
select ((select 1));
SELECT relname, relkind, relpersistence FROM pg_class WHERE relname ~ '^unlogged\d' ORDER BY relname;
SELECT 'CREATE TABLE extra_wide_table(firstc text, '|| array_to_string(array_agg('c'||i||' bool'),',')||', lastc text);' FROM generate_series(1, 1100) g(i);
SELECT relkind FROM pg_class WHERE relname = 'partitioned';
SELECT attname, attislocal, attinhcount FROM pg_attribute WHERE attrelid = 'part_a'::regclass and attnum > 0 ORDER BY attnum;
SELECT conislocal, coninhcount FROM pg_constraint WHERE conrelid = 'part_b'::regclass ORDER BY conislocal, coninhcount;
SELECT conislocal, coninhcount FROM pg_constraint WHERE conrelid = 'part_b'::regclass;
SELECT proname, prorettype::regtype, proargtypes::regtype[] FROM pg_proc WHERE oid in ('functest1'::regproc, 'functest3'::regproc) ORDER BY proname;
SELECT c1, c2, c3, c4 FROM public.t1 JOIN public.t2 USING (c5, c6) WHERE c5 = 'test' AND c6 ~ '^_is_' ORDER BY 1, 2;
TABLE sometable;
SELECT casttestfunc('foo'::text);
SELECT casttestfunc('foo'::text::casttesttype);
SELECT 1234::int4::casttesttype;
SELECT CAST(42 AS float8);
SELECT '' AS count, f1 AS open_path FROM t1 WHERE isopen(f1);
SELECT '' AS count, f1 AS closed_path FROM t1 WHERE isclosed(f1);
SELECT '' AS count, pclose(f1) AS closed_path FROM t1;
SELECT '' AS count, popen(f1) AS open_path FROM t1;
SELECT '""'::json;              -- OK.
SELECT $$''$$::json;            -- ERROR, single quotes are not allowed
SELECT '"abc"'::json;           -- OK
SELECT '"abc'::json;            -- ERROR, quotes not closed
SELECT '"abc
def"'::json;                    -- ERROR, unescaped newline in string constant
SELECT '[]'::json;              -- OK
SELECT '[[[[[[[[[[]]]]]]]]]]'::json;  -- OK
SELECT repeat('[', 10000)::json;
SELECT array_to_json(array(select 1 as a));
SELECT array_to_json(array_agg(q),false) from (select x as b, x * 2 as c from generate_series(1,3) x) q;
SELECT array_to_json(array_agg(q),false)
  FROM ( SELECT $$a$$ || x AS b, y AS c,
               ARRAY[ROW(x.*,ARRAY[1,2,3]),
               ROW(y.*,ARRAY[4,5,6])] AS z
         FROM generate_series(1,2) x,
              generate_series(4,5) y) q;
SELECT array_to_json(array_agg(x),false) from generate_series(5,10) x;
SELECT array_to_json('{{1,5},{99,100}}'::int[]);
SELECT row_to_json(row(1,'foo'));
SELECT row_to_json(q)
FROM (SELECT $$a$$ || x AS b, y AS c,
         ARRAY[ROW(x.*,ARRAY[1,2,3]),
               ROW(y.*,ARRAY[4,5,6])] AS z
      FROM generate_series(1,2) x,
           generate_series(4,5) y) q;
SELECT row_to_json(q,true) FROM rows q;
SELECT row_to_json(row((select array_agg(x) as d from generate_series(5,10) x)),false);
select to_json(histogram_bounds) histogram_bounds from pg_stats where attname = 'tmplname' and tablename = 'pg_pltemplate';
select to_json(timestamptz '2014-05-28 12:22:35.614298-04');
select to_json(date 'Infinity');
select to_json(timestamptz '-Infinity');
SELECT json_agg(q)
  FROM ( SELECT $$a$$ || x AS b, y AS c,
               ARRAY[ROW(x.*,ARRAY[1,2,3]),
               ROW(y.*,ARRAY[4,5,6])] AS z
         FROM generate_series(1,2) x,
              generate_series(4,5) y) q;
SELECT json_agg(q ORDER BY x, y) FROM rows q;
SELECT json_agg(q ORDER BY x NULLS FIRST, y) FROM rows q;
SELECT row_to_json(q) FROM (SELECT 'NaN'::float8 AS "float8field") q;
SELECT row_to_json(q) FROM (SELECT 'Infinity'::float8 AS "float8field") q;
SELECT row_to_json(q) FROM (SELECT '-Infinity'::float8 AS "float8field") q;
SELECT row_to_json(q) FROM (SELECT '{"a":1,"b": [2,3,4,"d","e","f"],"c":{"p":1,"q":2}}'::json AS "jsonfield") q;
SELECT test_json -> 'x' FROM test_json WHERE json_type = 'object';
SELECT test_json->'field2' FROM test_json WHERE json_type = 'object';
SELECT test_json -> -1 FROM test_json WHERE json_type = 'array';
SELECT test_json -> 2 FROM test_json WHERE json_type = 'object';
SELECT test_json->>2 FROM test_json WHERE json_type = 'array';
SELECT test_json ->> 'field6' FROM test_json WHERE json_type = 'object';
SELECT json_object_keys(test_json) FROM test_json WHERE json_type = 'scalar';
SELECT json_object_keys(test_json) FROM test_json WHERE json_type = 'array';
SELECT json_object_keys(test_json) FROM test_json WHERE json_type = 'object';
select count(*) from
    (select json_object_keys(json_object(array_agg(g)))
     from (select unnest(array['f'||n,n::text])as g
           from generate_series(1,300) as n) x ) y;
select (test_json->'field3') is null as expect_false from test_json where json_type = 'object';
select (test_json->>'field3') is null as expect_true from test_json where json_type = 'object';
select (test_json->3) is null as expect_false from test_json where json_type = 'array';
select (test_json->>3) is null as expect_true from test_json where json_type = 'array';
select '{"a": [{"b": "c"}, {"b": "cc"}]}'::json -> null::int;
select '{"a": [{"b": "c"}, {"b": "cc"}]}'::json -> 1;
select '{"a": [{"b": "c"}, {"b": "cc"}]}'::json -> -1;
select '{"a": [{"b": "c"}, {"b": "cc"}]}'::json -> 'z';
select '{"a": [{"b": "c"}, {"b": "cc"}]}'::json -> '';
SELECT json_array_length('[1,2,3,{"f1":1,"f2":[5,6]},4]');
SELECT json_array_length('4');
select json_each_text('{"f1":[1,2,3],"f2":{"f3":1},"f4":null,"f5":"null"}');
select * from json_each_text('{"f1":[1,2,3],"f2":{"f3":1},"f4":null,"f5":99,"f6":"stringy"}') q;
select json_extract_path_text('{"f2":["f3",1],"f4":{"f5":99,"f6":"stringy"}}','f2',1::text);
select json_extract_path_text('{"f2":{"f3":1},"f4":{"f5":null,"f6":"stringy"}}','f4','f5') is null as expect_true;
select '{"f2":["f3",1],"f4":{"f5":99,"f6":"stringy"}}'::json#>>array['f2','1'];
select 'null'::json #> '{}';
select '{"a": {"b":{"c": "foo"}}}'::json #> array['a','z','c'];
select '{"a": [{"b": "c"}, {"b": "cc"}]}'::json #> array['a','z','b'];
select '"foo"'::json #> array['z'];
select '42'::json #> array['f2'];
select '42'::json #> array['0'];
select '{"a": {"b":{"c": "foo"}}}'::json #>> '{}';
select '[1,2,3]'::json #>> '{}';
select '"foo"'::json #>> '{}';
select '42'::json #>> '{}';
select 'null'::json #>> '{}';
select '{"a": {"b":{"c": "foo"}}}'::json #>> array['a'];
select '[{"b": "c"}, {"b": null}]'::json #>> array['1','b'];
select '"foo"'::json #>> array['z'];
select '42'::json #>> array['f2'];
select '42'::json #>> array['0'];
select json_array_elements('[1,true,[1,[2,3]],null,{"f1":1,"f2":[7,8,9]},false,"stringy"]');
select json_array_elements_text('[1,true,[1,[2,3]],null,{"f1":1,"f2":[7,8,9]},false,"stringy"]');
select * from json_array_elements_text('[1,true,[1,[2,3]],null,{"f1":1,"f2":[7,8,9]},false,"stringy"]') q;
select * from json_array_elements('[1,true,[1,[2,3]],null,{"f1":1,"f2":[7,8,9]},false,"stringy"]') q;
select * from json_populate_record(null::jpop,'{"a":"blurfl","x":43.2}') q;
select * from json_populate_record(row('x',3,'2012-12-31 15:30:56')::jpop,'{}') q;
SELECT i FROM json_populate_record(NULL::jsrec_i_not_null, '{"i": 12345}') q;
SELECT reca FROM json_populate_record(NULL::jsrec, '{"reca": "{\"(abc,42,01.02.2003)\"}"}') q;
SELECT rec FROM json_populate_record(
    row(NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,
        row('x',3,'2012-12-31 15:30:56')::jpop,NULL)::jsrec,
    '{"rec": {"a": "abc", "c": "01.02.2003", "x": 43.2}}'
) q;
SELECT json_populate_record(null::record, '{"x": 0, "y": 1}');
SELECT json_populate_record(row(1,2), '{"f1": 0, "f2": 1}');
SELECT json_populate_record(null::j_ordered_pair, '{"x": 0, "y": 1}');
SELECT json_populate_recordset(null::record, '[{"x": 0, "y": 1}]');
SELECT json_populate_recordset(row(1,2), '[{"f1": 0, "f2": 1}]');
SELECT i, json_populate_recordset(row(i,50), '[{"f1":"42"},{"f2":"43"}]') FROM (VALUES (1),(2)) v(i);
SELECT json_populate_recordset(null::record, '[]');
SELECT json_populate_recordset(row(1,2), '[]');
SELECT json_populate_recordset(null::j_ordered_pair, '[{"x": 0, "y": 1}]');
SELECT json_populate_recordset(row(1,2)::j_ordered_pair, '[{"x": 1, "y": 0}]');
select * from json_populate_recordset(row(0::int),'[{"a":"1","b":"2"},{"a":"3"}]') q (a text, b text);
select * from json_populate_recordset(row(1000000000::int,50::int),'[{"b":"2"},{"a":"3"}]') q (a text, b text);
SELECT * FROM json_populate_recordset(NULL::jpop,'[]') q;
select value, json_typeof(value)
  from (values (json '123.4'),
               (json '-1'),
               (json '"foo"'),
               (json 'true'),
               (json 'false'),
               (json 'null'),
               (json '[1, 2, 3]'),
               (json '[]'),
               (json '{"x":"foo", "y":123}'),
               (json '{}'),
               (NULL::json))
      as data(value);
SELECT json_build_object('a',1,'b',1.2,'c',true,'d',null,'e',json '{"x": 3, "y": [1,2,3]}');
SELECT json_build_object(
       'a', json_build_object('b',false,'c',99),
       'd', json_build_object('e',array[9,8,7]::int[],
       'f', (select row_to_json(r) from (select * from t1) r)));
SELECT json_build_object('a', NULL); -- ok
SELECT json_build_object(VARIADIC NULL::text[]); -- ok
SELECT json_build_object(VARIADIC '{}'::text[]); -- ok
SELECT json_build_object(VARIADIC ARRAY[NULL, 'a']::text[]); -- error, key cannot be NULL
SELECT json_build_object(VARIADIC '{1,2,3,4}'::text[]); -- ok
SELECT json_build_object(VARIADIC '{1,2,3,4}'::int[]); -- ok
SELECT json_build_object(VARIADIC '{{1,4},{2,5},{3,6}}'::int[][]); -- ok
SELECT json_build_object(r,2) FROM (SELECT 1 AS a, 2 AS b) r;
SELECT json_build_object(json '{"a":1,"b":2}', 3);
SELECT json_build_object('{1,2,3}'::int[], 3);
SELECT json_build_object('turbines',json_object_agg(serial_num,json_build_object('name',name,'type',type))) FROM foo;
SELECT json_object_agg(name, type) FROM foo;
SELECT json_object('{}');
select json_object('{a,b,"","d e f"}','{1,2,3,"a b c"}');
select * from json_to_record('{"a":1,"b":"foo","c":"bar"}') as x(a int, b text, d text);
select *, c is null as c_is_null from json_to_recordset('[{"a":1, "b":{"c":16, "d":2}, "x":8}]'::json) as t(a int, b json, c text, x int);
select * from json_to_record('{"ia": null}') as x(ia _int4);
select * from json_to_record('{"ia": [1, "2", null, 4]}') as x(ia _int4);
select * from json_to_record('{"ia2": [[[1], [2], [3]]]}') as x(ia2 int4[][]);
select json_strip_nulls(null);
select json_strip_nulls('null');
select json_strip_nulls('{"a": {"b": null, "c": null}, "d": {} }');
select to_tsvector('{"a": "aaa bbb ddd ccc", "b": ["eee fff ggg"], "c": {"d": "hhh iii"}}'::json);
select json_to_tsvector('english', '{"a": "aaa in bbb", "b": 123, "c": 456, "d": true, "f": false, "g": null}'::json, '"all"');
select to_tsvector('""'::json);
select json_to_tsvector('null'::json, '"all"');
select json_to_tsvector('english', '{"a": "aaa in bbb", "b": 123, "c": 456, "d": true, "f": false, "g": null}'::json, '["all", null]');
select ts_headline('english', '{"a": "aaa bbb", "b": {"c": "ccc ddd fff", "c1": "ccc1 ddd1"}, "d": ["ggg hhh", "iii jjj"]}'::json, tsquery('bbb & ddd & hhh'), 'StartSel = <, StopSel = >');
select ts_headline('[]'::json, tsquery('aaa & bbb'));
SELECT avg(b)::numeric(10,3) AS avg_107_943 FROM aggtest;
SELECT avg(gpa) AS avg_3_4 FROM ONLY student;
SELECT sum(gpa) AS avg_6_8 FROM ONLY student;
SELECT max(four) AS max_3 FROM onek;
SELECT stddev_pop(b) FROM aggtest;
SELECT var_samp(b) FROM aggtest;
SELECT stddev_samp(b::numeric) FROM aggtest;
SELECT var_pop(b::numeric) FROM aggtest;
SELECT var_pop(1.0), var_samp(2.0);
SELECT stddev_pop(3.0::numeric), stddev_samp(4.0::numeric);
select avg(null::float8) from generate_series(1,3);
SELECT avg(x::float8), var_pop(x::float8) FROM (VALUES ('1'), ('infinity')) v(x);
SELECT regr_count(b, a) FROM aggtest;
SELECT covar_pop(b, a), covar_samp(b, a) FROM aggtest;
SELECT corr(b, a) FROM aggtest;
SELECT count(*), sum(x), regr_sxx(y,x), sum(y),regr_syy(y,x), regr_sxy(y,x) FROM regr_test WHERE x IN (10,20,30,80);
SELECT float8_regr_accum('{4,140,2900,1290,83075,15050}'::float8[], 200, 100);
SELECT float8_regr_combine('{3,60,200,750,20000,2000}'::float8[], '{2,180,200,740,57800,-3400}'::float8[]);
SELECT count(four) AS cnt_1000 FROM onek;
SELECT count(DISTINCT four) AS cnt_4 FROM onek;
select ten, count(*), sum(four) from onek group by ten order by ten;
select ten, count(four), sum(DISTINCT four) from onek group by ten order by ten;
SELECT newcnt(four) AS cnt_1000 FROM onek;
select ten, sum(distinct four) from onek a group by ten having exists (select 1 from onek b where sum(distinct a.four) = b.four);
select ten, sum(distinct four) from onek a group by ten having exists (select 1 from onek b where sum(distinct a.four + b.four) = b.four);
select (select max((select i.unique2 from tenk1 i where i.unique1 = o.unique1))) from tenk1 o;
select s1, s2, sm from generate_series(1, 3) s1, lateral (select s2, sum(s1 + s2) sm from generate_series(1, 3) s2 group by s2) ss order by 1, 2;
select array(select sum(x+y) s from generate_series(1,3) y group by y order by s) from generate_series(1,3) x;
SELECT BIT_AND(i2) AS "?", BIT_OR(i4)  AS "?" FROM bitwise_test;
SELECT booland_statefunc(NULL, NULL)  IS NULL AS "t", NOT booland_statefunc(FALSE, FALSE) AS "t";
SELECT BOOL_AND(b1) AS "f", BOOL_AND(NOT b3) AS "t" FROM bool_test;
SELECT EVERY(b1) AS "n", EVERY(NOT b2) AS "f" FROM bool_test;
select f1, (select min(unique1) from tenk1 where unique1 > f1) AS gt from int4_tbl;
select distinct max(unique2) from tenk1;
select max(unique2) from tenk1 order by max(unique2);
select max(unique2) from tenk1 order by max(unique2)+1;
select max(unique2), generate_series(1,3) as g from tenk1 order by g desc;
select max(min(unique1)) from tenk1;
select (select max(min(unique1)) from int8_tbl) from tenk1;
select * from t1 inner join t2 on t1.a = t2.x and t1.b = t2.y group by t1.a,t1.b,t1.c,t1.d,t2.x,t2.y,t2.z;
select t1.*,t2.x,t2.z from t1 inner join t2 on t1.a = t2.x and t1.b = t2.y group by t1.a,t1.b,t1.c,t1.d,t2.x,t2.z;
select array_agg(a order by b) from (values (1,4),(2,3),(3,1),(4,2)) v(a,b);
select array_agg(a order by a) from (values (1,4),(2,3),(3,1),(4,2)) v(a,b);
select array_agg(a order by a desc) from (values (1,4),(2,3),(3,1),(4,2)) v(a,b);
select array_agg(b order by a desc) from (values (1,4),(2,3),(3,1),(4,2)) v(a,b);
select array_agg(distinct a) from (values (1),(2),(1),(3),(null),(2)) v(a);
select array_agg(distinct a order by a) from (values (1),(2),(1),(3),(null),(2)) v(a);
select array_agg(distinct a order by a desc) from (values (1),(2),(1),(3),(null),(2)) v(a);
select array_agg(distinct a order by a desc nulls last) from (values (1),(2),(1),(3),(null),(2)) v(a);
select aggfstr(a,b,c) from (values (1,3,'foo'),(0,null,null),(2,2,'bar'),(3,1,'baz')) v(a,b,c);
select aggfns(a,b,c) from (values (1,3,'foo'),(0,null,null),(2,2,'bar'),(3,1,'baz')) v(a,b,c);
select aggfstr(distinct a,b,c) from (values (1,3,'foo'),(0,null,null),(2,2,'bar'),(3,1,'baz')) v(a,b,c), generate_series(1,3) i;
select aggfns(distinct a,b,c) from (values (1,3,'foo'),(0,null,null),(2,2,'bar'),(3,1,'baz')) v(a,b,c), generate_series(1,3) i;
select aggfstr(distinct a,b,c order by b) from (values (1,3,'foo'),(0,null,null),(2,2,'bar'),(3,1,'baz')) v(a,b,c), generate_series(1,3) i;
select aggfns(distinct a,b,c order by b) from (values (1,3,'foo'),(0,null,null),(2,2,'bar'),(3,1,'baz')) v(a,b,c), generate_series(1,3) i;
select aggfns(distinct a,a,c order by c using ~<~,a) from (values (1,3,'foo'),(0,null,null),(2,2,'bar'),(3,1,'baz')) v(a,b,c), generate_series(1,2) i;
select aggfns(distinct a,a,c order by c using ~<~) from (values (1,3,'foo'),(0,null,null),(2,2,'bar'),(3,1,'baz')) v(a,b,c), generate_series(1,2) i;
select aggfns(distinct a,a,c order by a) from (values (1,3,'foo'),(0,null,null),(2,2,'bar'),(3,1,'baz')) v(a,b,c), generate_series(1,2) i;
select aggfns(distinct a,b,c order by a,c using ~<~,b) from (values (1,3,'foo'),(0,null,null),(2,2,'bar'),(3,1,'baz')) v(a,b,c), generate_series(1,2) i;
select aggfns(distinct a,b,c order by i) from (values (1,1,'foo')) v(a,b,c), generate_series(1,2) i;
select string_agg(a,'AB') from (values(null),(null),('bbbb'),('cccc')) g(a);
select string_agg(a,',') from (values(null),(null)) g(a);
select string_agg(distinct f1, ',' order by f1) from varchar_tbl;  -- ok
select string_agg(distinct f1::text, ',' order by f1) from varchar_tbl;  -- not ok
select string_agg(distinct f1, ',' order by f1::text) from varchar_tbl;  -- not ok
select string_agg(distinct f1::text, ',' order by f1::text) from varchar_tbl;  -- ok
select string_agg(v, '') from bytea_test_table;
select string_agg(v, '') from bytea_test_table;
select string_agg(v, NULL) from bytea_test_table;
select string_agg(v, decode('ee', 'hex')) from bytea_test_table;
select min(unique1) filter (where unique1 > 100) from tenk1;
select sum(1/ten) filter (where ten > 0) from tenk1;
select ten, sum(distinct four) filter (where four::text ~ '123') from onek a group by ten;
select ten, sum(distinct four) filter (where four > 10) from onek a group by ten having exists (select 1 from onek b where sum(distinct a.four) = b.four);
select max(foo COLLATE "C") filter (where (bar collate "POSIX") > '0') from (values ('a', 'b')) AS v(foo,bar);
select (select count(*) from (values (1)) t0(inner_c)) from (values (2),(3)) t1(outer_c); -- inner query is aggregation query
select (select count(*) filter (where outer_c <> 0) from (values (1)) t0(inner_c)) from (values (2),(3)) t1(outer_c); -- outer query is aggregation query
select (select count(inner_c) filter (where outer_c <> 0) from (values (1)) t0(inner_c)) from (values (2),(3)) t1(outer_c); -- inner query is aggregation query
select (select max((select i.unique2 from tenk1 i where i.unique1 = o.unique1)) filter (where o.unique1 < 10)) from tenk1 o;                   -- outer query is aggregation query
select sum(unique1) FILTER (WHERE unique1 IN (SELECT unique1 FROM onek where unique1 < 100)) FROM tenk1;
select aggfns(distinct a,b,c order by a,c using ~<~,b) filter (where a > 1) from (values (1,3,'foo'),(0,null,null),(2,2,'bar'),(3,1,'baz')) v(a,b,c), generate_series(1,2) i;
select p, percentile_cont(p) within group (order by x::float8) from generate_series(1,5) x,
 (values (0::float8),(0.1),(0.25),(0.4),(0.5),(0.6),(0.75),(0.9),(1)) v(p) group by p order by p;
select p, percentile_cont(p order by p) within group (order by x) from generate_series(1,5) x, 
 (values (0::float8),(0.1),(0.25),(0.4),(0.5),(0.6),(0.75),(0.9),(1)) v(p) group by p order by p;
select p, sum() within group (order by x::float8) from generate_series(1,5) x,
 (values (0::float8),(0.1),(0.25),(0.4),(0.5),(0.6),(0.75),(0.9),(1)) v(p) group by p order by p;
select p, percentile_cont(p,p) from generate_series(1,5) x,
 (values (0::float8),(0.1),(0.25),(0.4),(0.5),(0.6),(0.75),(0.9),(1)) v(p) group by p order by p;
select percentile_disc(0.5) within group (order by thousand) from tenk1;
select rank(3) within group (order by x) from (values (1),(1),(2),(2),(3),(3),(4)) v(x);
select cume_dist(3) within group (order by x) from (values (1),(1),(2),(2),(3),(3),(4)) v(x);
select percent_rank(3) within group (order by x) from (values (1),(1),(2),(2),(3),(3),(4),(5)) v(x);
select dense_rank(3) within group (order by x) from (values (1),(1),(2),(2),(3),(3),(4)) v(x);
select percentile_disc(array[0,0.1,0.25,0.5,0.75,0.9,1]) within group (order by thousand) from tenk1;
select percentile_cont(array[0,0.25,0.5,0.75,1]) within group (order by thousand) from tenk1;
select percentile_disc(array[[null,1,0.5],[0.75,0.25,null]]) within group (order by thousand) from tenk1;
select percentile_cont(array[0,1,0.25,0.75,0.5,1,0.3,0.32,0.35,0.38,0.4]) within group (order by x) from generate_series(1,6) x;
select ten, mode() within group (order by string4) from tenk1 group by ten;
select percentile_disc(array[0.25,0.5,0.75]) within group (order by x) from unnest('{fred,jim,}'::text[]) u(x);
select pg_collation_for(percentile_disc(1) within group (order by x collate "POSIX")) from (values ('fred'),('jim')) v(x);
select test_rank(3) within group (order by x) from (values (1),(1),(2),(2),(3),(3),(4)) v(x);
select test_percentile_disc(0.5) within group (order by thousand) from tenk1;
select rank(x) within group (order by x) from generate_series(1,5) x;
select array(select percentile_disc(a) within group (order by x) from (values (0.3),(0.7)) v(a) group by a) from generate_series(1,5) g(x);
select rank(sum(x)) within group (order by x) from generate_series(1,5) x;
select rank(3) within group (order by x) from (values ('fred'),('jim')) v(x);
select rank(3) within group (order by stringu1,stringu2) from tenk1;
select rank('fred') within group (order by x) from generate_series(1,5) x;
select rank('adam'::text collate "C") within group (order by x collate "POSIX") from (values ('fred'),('jim')) v(x);
select rank('adam'::varchar) within group (order by x) from (values ('fred'),('jim')) v(x);
select rank('3') within group (order by x) from generate_series(1,5) x;
select percent_rank(0) within group (order by x) from generate_series(1,0) x;
select pg_get_viewdef('aggordview1');
select * from aggordview1 order by ten;
select least_agg(q1,q2) from int8_tbl;
select least_agg(variadic array[q1,q2]) from int8_tbl;
select my_avg(one),my_avg(one) from (values(1),(3)) t(one);
select my_avg(one),my_sum(one) from (values(1),(3)) t(one);
select my_avg(distinct one),my_sum(distinct one) from (values(1),(3),(1)) t(one);
select my_avg(distinct one),my_sum(one) from (values(1),(3)) t(one);
select my_avg(one) filter (where one > 1),my_sum(one) from (values(1),(3)) t(one);
select my_avg(one),my_sum(two) from (values(1,2),(3,4)) t(one,two);
select percentile_cont(0.5) within group (order by a) from (values(1::float8),(3),(5),(7)) t(a);
select rank(4) within group (order by a), dense_rank(4) within group (order by a) from (values(1),(3),(5),(7)) t(a);
select my_sum_init(one),my_avg_init(one) from (values(1),(3)) t(one);
select my_sum_init(one),my_avg_init2(one) from (values(1),(3)) t(one);
select my_sum(one),my_half_sum(one) from (values(1),(2),(3),(4)) t(one);
SELECT dense_rank(x) WITHIN GROUP (ORDER BY x) FROM (VALUES (1),(1),(2),(2),(3),(3)) v(x) GROUP BY (x) ORDER BY 1;
SELECT min(x ORDER BY y) FROM (VALUES(1, NULL)) AS d(x,y);
SELECT min(x ORDER BY y) FROM (VALUES(1, 2)) AS d(x,y);
select v||'a', case v||'a' when 'aa' then 1 else 0 end, count(*) from unnest(array['a','b']) u(v) group by v||'a' order by 1;
select v||'a', case when v||'a' = 'aa' then 1 else 0 end, count(*) from unnest(array['a','b']) u(v) group by v||'a' order by 1;
SELECT point '(1,2)' <% widget '(0,0,3)' AS t, point '(1,2)' <% widget '(0,0,1)' AS f;
-- begin ambiguity
SELECT true<>-1 BETWEEN 1 AND 1;
SELECT false<>/**/1 BETWEEN 1 AND 1;
SELECT false<=-1 BETWEEN 1 AND 1;
SELECT false>=-1 BETWEEN 1 AND 1;
SELECT 2<=/**/3, 3>=/**/2, 2<>/**/3;
SELECT 3<=/**/2, 2>=/**/3, 2<>/**/2;
-- end ambiguity
SELECT * FROM money_data;
SELECT m + '123' FROM money_data;
SELECT m + '123.45' FROM money_data;
SELECT m - '123.45' FROM money_data;
SELECT m / '2'::money FROM money_data;
SELECT m * 2 FROM money_data;
SELECT 2 * m FROM money_data;
SELECT m / 2 FROM money_data;
SELECT m * 2::int2 FROM money_data;
SELECT 2::int2 * m FROM money_data;
SELECT m / 2::int2 FROM money_data;
SELECT m * 2::int8 FROM money_data;
SELECT 2::int8 * m FROM money_data;
SELECT m / 2::int8 FROM money_data;
SELECT m * 2::float8 FROM money_data;
SELECT 2::float8 * m FROM money_data;
SELECT m / 2::float8 FROM money_data;
SELECT m * 2::float4 FROM money_data;
SELECT 2::float4 * m FROM money_data;
SELECT m / 2::float4 FROM money_data;
SELECT m = '$123.00' FROM money_data;
SELECT m = '$123.01' FROM money_data;
SELECT cash_words(m + '1.23') FROM money_data;
SELECT '1234567890'::money;
SELECT '878.08'::money / 11::float4;
SELECT '878.08'::money / 11::bigint;
SELECT '878.08'::money / 11::int;
SELECT '878.08'::money / 11::smallint;
SELECT '90000000000000099.00'::money / 10::bigint;
SELECT (-12345)::money;
SELECT 12345678901234567::numeric::money;
SELECT '12345678901234567'::money::numeric;
SELECT '-12345678901234567'::money::numeric;
select amname, prop, pg_indexam_has_property(a.oid, prop) as p
  from pg_am a,
       unnest(array['can_order', 'can_unique', 'can_multi_col',
                    'can_exclude', 'can_include', 'bogus']::text[])
         with ordinality as u(prop,ord)
 where amtype = 'i'
 order by amname, ord;

select prop,
       pg_indexam_has_property(a.oid, prop) as "AM",
       pg_index_has_property('onek_hundred'::regclass, prop) as "Index",
       pg_index_column_has_property('onek_hundred'::regclass, 1, prop) as "Column"
  from pg_am a,
       unnest(array['asc', 'desc', 'nulls_first', 'nulls_last',
                    'orderable', 'distance_orderable', 'returnable',
                    'search_array', 'search_nulls',
                    'clusterable', 'index_scan', 'bitmap_scan',
                    'backward_scan',
                    'can_order', 'can_unique', 'can_multi_col',
                    'can_exclude', 'can_include',
                    'bogus']::text[])
         with ordinality as u(prop,ord)
where a.amname = 'btree'
order by ord;
SELECT 1 AS one;
SELECT true AS true;
SELECT false AS false;
SELECT bool '0' AS false;
SELECT bool '000' AS error;
SELECT bool '' AS error;
SELECT bool 't' and bool 'f' AS false;
SELECT not bool 'f' AS true;
SELECT bool 't' = bool 'f' AS false;
SELECT bool 't' >= bool 'f' AS true;
SELECT 'TrUe'::text::boolean AS true, 'fAlse'::text::boolean AS false;
SELECT true::boolean::text AS true, false::boolean::text AS false;
SELECT '  tru e '::text::boolean AS invalid;
SELECT ''::text::boolean AS invalid;
SELECT '' AS t_3, BOOLTBL1.* FROM BOOLTBL1 WHERE f1 <> bool 'false';
SELECT '' AS zero, BOOLTBL1.* FROM BOOLTBL1 WHERE booleq(bool 'false', f1);
SELECT '' AS f_1, BOOLTBL1.* FROM BOOLTBL1 WHERE f1 = bool 'false';
SELECT '' AS tf_12, BOOLTBL1.*, BOOLTBL2.* FROM BOOLTBL1, BOOLTBL2 WHERE boolne(BOOLTBL2.f1,BOOLTBL1.f1);
SELECT '' AS "Not True", f1 FROM BOOLTBL2 WHERE f1 IS NOT TRUE;
SELECT
    b IS TRUE AS istrue,
    b IS NOT TRUE AS isnottrue,
    b IS FALSE AS isfalse,
    b IS NOT FALSE AS isnotfalse,
    b IS UNKNOWN AS isunknown,
    b IS NOT UNKNOWN AS isnotunknown
FROM booltbl3 ORDER BY o;
SELECT istrue AND isnul AND istrue FROM booltbl4;
SELECT isnul OR istrue OR isfalse FROM booltbl4;
SELECT pg_notify('notify_async1','sample message1');
SELECT pg_notify(NULL,'sample message1');
SELECT pg_notification_queue_usage();
SELECT (r%53), (r%59), 'foooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo' FROM generate_series(1,70000) r;
SELECT '' AS four, * FROM BOX_TBL;
SELECT '' AS four, b.*, area(b.f1) as barea FROM BOX_TBL b;
SELECT '' AS three, b.f1 FROM BOX_TBL b WHERE b.f1 && box '(2.5,2.5,1.0,1.0)';
SELECT '' AS two, b.f1 FROM BOX_TBL b WHERE box '(3.0,3.0,5.0,5.0)' >> b.f1;
SELECT * FROM box_temp WHERE f1 &< '(10,4.333334),(5,100)';
SELECT box(point(x * 10, y * 10), point(x * 10 + 5, y * 10 + 5)) FROM generate_series(1, 100) x, generate_series(1, 100) y;
SELECT count(*) FROM quad_box_tbl WHERE b |>> box '((100,200),(300,500))';
SELECT count(*) FROM quad_box_tbl WHERE b ~=  box '((200,300),(205,305))';
SELECT text 'this is a text string' = text 'this is a text string';
select length(42);
select 'four: '::text || 2+2;
select 'four: ' || 2+2;
select 3 || 4.0;
select concat('one');
select concat(1,2,3,'hello',true, false, to_date('20100309','YYYYMMDD'));
select concat_ws('#','one');
select concat_ws(',',10,20,null,30);
select concat_ws(NULL,10,20,null,30) is null;
select reverse('abcde');
select i, left('ahoj', i), right('ahoj', i) from generate_series(-5, 5) t(i) order by i;
select quote_literal('');
select quote_literal('abc''');
select quote_literal(e'\\');
select concat(variadic array[1,2,3]);
select concat_ws(',', variadic array[1,2,3]);
select concat_ws(',', variadic NULL::int[]);
select concat(variadic NULL::int[]) is NULL;
select concat(variadic '{}'::int[]) = '';
select concat_ws(',', variadic 10);
select format(NULL);
select format('Hello %%%%');
select format('Hello %s %s', 'World');
select format('Hello %x', 20);
select format('%1$s %13$s', 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
select format('%s, %s', variadic array[true, false]::text[]);
select format('%2$s, %1$s', variadic array[1, 2]);
select format('Hello', variadic NULL::int[]);
select format('>>%-10s<<', 'Hello');
select format('>>%2$*1$L<<', -10, NULL);
select format('>>%-s<<', 'Hello');
SELECT (string_to_array(polqual, ':'))[7] AS inputcollid FROM pg_policy WHERE polrelid = 'coll_t'::regclass;
WITH cte1 AS (SELECT * FROM t1 WHERE f_leak(b)) SELECT * FROM cte1;
INSERT INTO LINE_TBL VALUES ('{NaN,NaN,NaN}');
INSERT INTO LINE_TBL VALUES ('[(1,3),(2,3)]');
INSERT INTO LINE_TBL VALUES (line(point '(1,0)', point '(1,0)'));
select '{nan, 1, nan}'::line = '{nan, 1, nan}'::line as true, '{nan, 1, nan}'::line = '{nan, 2, nan}'::line as false;
SELECT '08:00:2b:01:02:03     '::macaddr8;
SELECT b::macaddr <= '08:00:2b:01:02:04' FROM macaddr8_data WHERE a = 1;
SELECT ''::text AS two, unique1, unique2, stringu1 FROM onek WHERE unique1 > 50 ORDER BY unique1 LIMIT 2;
SELECT ''::text AS five, unique1, unique2, stringu1 FROM onek WHERE unique1 > 60 ORDER BY unique1 LIMIT 5;
SELECT ''::text AS two, unique1, unique2, stringu1 FROM onek WHERE unique1 > 60 AND unique1 < 63 ORDER BY unique1 LIMIT 5;
SELECT ''::text AS three, unique1, unique2, stringu1 FROM onek WHERE unique1 > 100 ORDER BY unique1 LIMIT 3 OFFSET 20;
SELECT ''::text AS zero, unique1, unique2, stringu1 FROM onek WHERE unique1 < 50 ORDER BY unique1 DESC LIMIT 8 OFFSET 99;
SELECT ''::text AS eleven, unique1, unique2, stringu1 FROM onek WHERE unique1 < 50 ORDER BY unique1 DESC LIMIT 20 OFFSET 39;
SELECT ''::text AS ten, unique1, unique2, stringu1 FROM onek ORDER BY unique1 OFFSET 990;
SELECT ''::text AS five, unique1, unique2, stringu1 FROM onek ORDER BY unique1 OFFSET 990 /*LIMIT 5*/;
SELECT ''::text AS five, unique1, unique2, stringu1 FROM onek ORDER BY unique1 LIMIT 5 OFFSET 900;
select * from int8_tbl limit (case when random() < 0.5 then null::bigint end);
select * from int8_tbl offset (case when random() < 0.5 then null::bigint end);
SELECT (SELECT n FROM (VALUES (1)) AS x, (SELECT n FROM t1 AS n ORDER BY n LIMIT 1 OFFSET s-1) AS y) AS z FROM t2 AS s;
select unique1, unique2, nextval('testseq') from tenk1 order by unique2 limit 10;
select currval('testseq');
select unique1, unique2, nextval('testseq') from tenk1 order by tenthous limit 10;
select unique1, unique2, generate_series(1,10) from tenk1 order by unique2 limit 7;
select unique1, unique2, generate_series(1,10) from tenk1 order by tenthous limit 7;
select generate_series(0,2) as s1, generate_series((random()*.1)::int,2) as s2;
select sum(tenthous) as s1, sum(tenthous) + random()*0 as s2 from tenk1 group by thousand order by thousand limit 3;
SELECT '' AS four, i.* FROM INT2_TBL i WHERE i.f1 <> int2 '0';
SELECT '' AS one, i.* FROM INT2_TBL i WHERE (i.f1 % int2 '2') = int2 '1';
SELECT (-1::int2<<15)::text;
SELECT ((-1::int2<<15)+1::int2)::text;
SELECT (-32768)::int2 * (-1)::int2;
SELECT '' AS four, i.* FROM INT4_TBL i WHERE i.f1 <> int2 '0';
SELECT '' AS one, i.* FROM INT4_TBL i WHERE (i.f1 % int2 '2') = int2 '1';
SELECT '' AS three, i.* FROM INT4_TBL i WHERE (i.f1 % int4 '2') = int2 '0';
SELECT -2+3 AS one;
SELECT 4-2 AS two;
SELECT 2- -1 AS three;
SELECT 2 - -2 AS four;
SELECT int2 '2' * int2 '2' = int2 '16' / int2 '4' /*AS true*/;
SELECT int4 '1000' < int4 '999' /*AS false*/;
SELECT !!3 AS six;
SELECT 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 AS ten;
SELECT 2 + 2 / 2 AS three;
SELECT (2 + 2) / 2 AS two;
SELECT (-1::int4<<31)::text;
SELECT ((-1::int4<<31)+1)::text;
SELECT * FROM INT8_TBL WHERE q2 >= 4567890123456789;
SELECT * FROM INT8_TBL WHERE q2 >= '456'::int2;
SELECT * FROM INT8_TBL WHERE '123'::int2 >= q1;
SELECT '' AS five, q1 AS plus, -q1 AS minus FROM INT8_TBL;
SELECT '' AS five, q1, q2, q1 / q2 AS divide, q1 % q2 AS mod FROM INT8_TBL;
SELECT q1 + 42::int4 AS "8plus4", q1 - 42::int4 AS "8minus4", q1 * 42::int4 AS "8mul4", q1 / 42::int4 AS "8div4" FROM INT8_TBL;
SELECT min(q1), min(q2) FROM INT8_TBL;
SELECT max(q1), max(q2) FROM INT8_TBL;
SELECT '' AS to_char_2, to_char(q1, '9G99'), to_char(q2, '999.999,999') FROM INT8_TBL;
SELECT '' AS to_char_12, to_char(q2, 'FM9999999999999999.000') FROM INT8_TBL;
SELECT '' AS to_char_16, to_char(q2, E'99999 "text" 9999 "9999" 999 "\\"text between quote marks\\"" 9999') FROM INT8_TBL;
select '-9223372036854775808'::int8 / '0'::int2;
select '-100'::int2 - '9223372036854775800'::int8;
select '100'::int2 / '0'::int8;
SELECT CAST(q1 AS int4) FROM int8_tbl WHERE q2 = 456;
SELECT CAST('42'::int2 AS int8), CAST('-37'::int2 AS int8);
SELECT CAST(q1 AS float4), CAST(q2 AS float8) FROM INT8_TBL;
SELECT q1, q2, q1 & q2 AS "and", q1 | q2 AS "or", q1 # q2 AS "xor", ~q1 AS "not" FROM INT8_TBL;
SELECT q1, q1 << 2 AS "shl", q1 >> 3 AS "shr" FROM INT8_TBL;
SELECT * FROM generate_series('+4567890123456789'::int8, '+4567890123456799'::int8);
SELECT * FROM generate_series('+4567890123456789'::int8, '+4567890123456799'::int8, 0);
SELECT * FROM generate_series('+4567890123456789'::int8, '+4567890123456799'::int8, 2);
SELECT (-1::int8<<63)::text;
SELECT ((-1::int8<<63)+1)::text;
SELECT * FROM CIRCLE_TBL;
SELECT '' AS six, center(f1) AS center FROM CIRCLE_TBL;
SELECT '' AS six, radius(f1) AS radius FROM CIRCLE_TBL;
SELECT '' AS six, diameter(f1) AS diameter FROM CIRCLE_TBL;
SELECT '' AS two, f1 FROM CIRCLE_TBL WHERE radius(f1) < 5;
SELECT '' AS four, f1 FROM CIRCLE_TBL WHERE diameter(f1) >= 10;
SELECT '' as five, c1.f1 AS one, c2.f1 AS two, (c1.f1 <-> c2.f1) AS distance
  FROM CIRCLE_TBL c1, CIRCLE_TBL c2
  WHERE (c1.f1 < c2.f1) AND ((c1.f1 <-> c2.f1) > 0)
  ORDER BY distance, area(c1.f1), area(c2.f1);
SELECT 'aⓐ' ~ U&'a\24D0' AS t;
SELECT 'aⓐ' ~ U&'a\24D1' AS f;
SELECT 'aⓕ' ~ 'a[ⓐ-ⓩ]' AS t;
SELECT 'aⒻ' ~ 'a[ⓐ-ⓩ]' AS f;
SELECT 'aⓕⓕ' ~ 'aⓕ[ⓐ-ⓩ]' AS t;
SELECT 'aⓕⓐ' ~ 'aⓕ[ⓐ-ⓩ]' AS t;
SELECT 'aⓐⓕ' ~ 'aⓕ[ⓐ-ⓩ]' AS f;
SELECT 'aⓕⓕ' ~ 'a[ⓐ-ⓩ]ⓕ' AS t;
SELECT 'aⓕⓐ' ~ 'a[ⓐ-ⓩ]ⓕ' AS f;
SELECT 'aⓐⓕ' ~ 'a[ⓐ-ⓩ]ⓕ' AS t;
SELECT 'aⒶⓜ' ~ 'a[Ⓐ-ⓜ][ⓜ-ⓩ]' AS t;
SELECT 'aⓜⓜ' ~ 'a[Ⓐ-ⓜ][ⓜ-ⓩ]' AS t;
SELECT 'aⓜⓩ' ~ 'a[Ⓐ-ⓜ][ⓜ-ⓩ]' AS t;
SELECT 'aⓩⓩ' ~ 'a[Ⓐ-ⓜ][ⓜ-ⓩ]' AS f;
SELECT 'aⓜ⓪' ~ 'a[Ⓐ-ⓜ][ⓜ-ⓩ]' AS f;
SELECT 'a0' ~ 'a[a-ⓩ]' AS f;
SELECT 'aq' ~ 'a[a-ⓩ]' AS t;
SELECT 'aⓜ' ~ 'a[a-ⓩ]' AS t;
SELECT 'a⓪' ~ 'a[a-ⓩ]' AS f;
SELECT 'aⒶⓜ⓪' ~ '[[:alpha:]][[:alpha:]][[:alpha:]][[:graph:]]' AS t;
SELECT 'aⒶⓜ⓪' ~ '[[:alpha:]][[:alpha:]][[:alpha:]][[:alpha:]]' AS f;
SELECT 'aⒶⓜ⓪' ~ '[a-z][[:alpha:]][ⓐ-ⓩ][[:graph:]]' AS t;
SELECT 'aⓜⒶ⓪' ~ '[a-z][[:alpha:]][ⓐ-ⓩ][[:graph:]]' AS f;
SELECT 'aⓜⒶ⓪' ~ '[a-z][ⓐ-ⓩ][[:alpha:]][[:graph:]]' AS t;
SELECT 'aⒶⓜ⓪' ~ '[a-z][ⓐ-ⓩ][[:alpha:]][[:graph:]]' AS f;
select 'abc abc abd' ~ '^(.+)( \1)+$' as f;
select substring('a' from '((a)+)');
select regexp_matches('a', '(?=b)b');
select 'zyy' ~ '(?<![xy])yy+';
select 'dd x' ~ '(^(?!aa)(?!bb)(?!cc))+';
select 'a' ~ '((((((a+|)+|)+|)+|)+|)+|)';
select regexp_matches('foo/bar/baz', '^([^/]+?)(?:/([^/]+?))(?:/([^/]+?))?$', '');
SELECT hs_locks_drop(257);
SELECT hs_locks_create(257);
SELECT timestamp with time zone '20011227 040506+08';
SELECT time without time zone 'T040506.789-08';
SELECT time with time zone '040506.789+08';
SELECT date 'J1520447' AS "Confucius' Birthday";
SELECT date '1981-02-03' + time '04:05:06' AS "Date + Time";
SELECT date '1991-02-03' + time with time zone '04:05:06 PST' AS "Date + Time PST";
SELECT date '1991-02-03' + interval '2 years' AS "Add Two Years";
SELECT timestamp without time zone '1999-12-01' + interval '1 month - 1 second' AS "Dec 31";
SELECT timestamp without time zone '12/31/294276' - timestamp without time zone '12/23/1999' AS "106751991 Days";
SELECT (timestamp without time zone '12:34:56 yesterday' = (timestamp without time zone 'tomorrow' - interval '2 days - 12:34:56')) as "True";
SELECT (timestamp without time zone 'tomorrow' > 'now') as "True";
SELECT date '1994-01-01' + time '11:00' AS "Jan_01_1994_11am";
SELECT date '1994-01-01' + time '10:00' AS "Jan_01_1994_10am";
SELECT date '1994-01-01' + timetz '11:00-5' AS "Jan_01_1994_8am";
SELECT timestamptz(date '1994-01-01', time with time zone '11:00-5') AS "Jan_01_1994_8am";
SELECT '' AS "64", d1 - interval '1 year' AS one_year FROM TIMESTAMP_TBL;
SELECT timestamp with time zone '1999-12-01' + interval '1 month - 1 second' AS "Dec 31";
SELECT CAST(CAST(date 'today' + time with time zone '05:30' + interval '02:01' AS time with time zone) AS time) AS "07:31:00";
SELECT CAST(cast(date 'today' + time with time zone '03:30' + interval '1 month 04:01' as timestamp without time zone) AS time) AS "07:31:00";
SELECT t.d1 AS t, i.f1 AS i, t.d1 + i.f1 AS "add", t.d1 - i.f1 AS "subtract"
  FROM TIMESTAMP_TBL t, INTERVAL_TBL i
  WHERE t.d1 BETWEEN '1990-01-01' AND '2001-01-01'
    AND i.f1 BETWEEN '00:00' AND '23:00'
  ORDER BY 1,2;
SELECT (timestamp with time zone '2000-11-27', timestamp with time zone '2000-11-28')
  OVERLAPS (timestamp with time zone '2000-11-27 12:00', timestamp with time zone '2000-11-30') AS "True";
SELECT (time '00:00', time '01:00') OVERLAPS (time '00:30', time '01:30') AS "True";
SELECT (time '00:00', interval '1 hour') OVERLAPS (time '00:30', interval '1 hour') AS "True";
SELECT (time '00:00', interval '1 hour') OVERLAPS (time '01:30', interval '1 hour') AS "False";
SELECT (time '00:00', interval '1 hour') OVERLAPS (time '01:30', interval '1 day') AS "False";
SELECT '' AS "16", f1 AS "timestamp", date(f1) AS date FROM TEMP_TIMESTAMP WHERE f1 <> timestamp 'now' ORDER BY date, "timestamp";
SELECT to_timestamp('0097/Feb/16 --> 08:14:30', 'YYYY/Mon/DD --> HH:MI:SS');
SELECT to_timestamp('1,582nd VIII 21', 'Y,YYYth FMRM DD');
SELECT to_timestamp('15 "text between quote marks" 98 54 45', E'HH24 "\\"text between quote marks\\"" YY MI SS');
SELECT to_char('2012-12-12 12:00'::timestamptz, 'YYYY-MM-DD HH:MI:SS TZ');
SELECT * FROM testcase WHERE testcase.id = 1 FOR UPDATE;
SELECT setval('sequence_test'::regclass, 99, false);
SELECT nextval('sequence_test'::text);
SELECT b, c FROM test_having GROUP BY b, c HAVING count(*) = 1 ORDER BY b, c;
SELECT b, c FROM test_having GROUP BY b, c HAVING b = 3 ORDER BY b, c;
SELECT lower(c), count(c) FROM test_having GROUP BY lower(c) HAVING count(*) > 2 OR min(a) = max(a) ORDER BY lower(c);
SELECT c, max(a) FROM test_having GROUP BY c HAVING count(*) > 2 OR min(a) = max(a) ORDER BY c;
SELECT min(a), max(a) FROM test_having HAVING min(a) < max(a);
SELECT a FROM test_having HAVING min(a) < max(a);
SELECT 1 AS one FROM test_having HAVING a > 1;
SELECT 1 AS one FROM test_having HAVING 1 < 2;
SELECT 1 AS one FROM test_having WHERE 1/a = 1 HAVING 1 < 2;
SELECT name, #thepath FROM iexit ORDER BY name COLLATE "C", 2;
select length(stringu1) from tenk1 group by length(stringu1);
SELECT unique1 FROM tenk1 WHERE fivethous = (SELECT unique1 FROM tenk1 WHERE fivethous = 1 LIMIT 1)
UNION ALL
SELECT unique1 FROM tenk1 WHERE fivethous = (SELECT unique2 FROM tenk1 WHERE fivethous = 1 LIMIT 1)
ORDER BY 1;
SELECT 1 FROM tenk1_vw_sec WHERE (SELECT sum(f1) FROM int4_tbl WHERE f1 < unique1) < 100;
INSERT INTO test_missing_target VALUES (9, 4, 'CCCC', 'j');
SELECT c, count(*) FROM test_missing_target GROUP BY test_missing_target.c ORDER BY c;
SELECT count(*) FROM test_missing_target GROUP BY test_missing_target.c ORDER BY c;
SELECT count(*) FROM test_missing_target GROUP BY a ORDER BY b;
SELECT count(*) FROM test_missing_target GROUP BY b ORDER BY b;
SELECT test_missing_target.b, count(*) FROM test_missing_target GROUP BY b ORDER BY b;
SELECT c FROM test_missing_target ORDER BY a;
SELECT count(*) FROM test_missing_target GROUP BY b ORDER BY b desc;
SELECT count(*) FROM test_missing_target ORDER BY 1 desc;
SELECT c, count(*) FROM test_missing_target GROUP BY 1 ORDER BY 1;
SELECT c, count(*) FROM test_missing_target GROUP BY 3;
SELECT count(*) FROM test_missing_target x, test_missing_target y WHERE x.a = y.a GROUP BY b ORDER BY b;
SELECT a, a FROM test_missing_target ORDER BY a;
SELECT a/2, a/2 FROM test_missing_target ORDER BY a/2;
SELECT a/2, a/2 FROM test_missing_target GROUP BY a/2 ORDER BY a/2;
SELECT x.b, count(*) FROM test_missing_target x, test_missing_target y WHERE x.a = y.a GROUP BY x.b ORDER BY x.b;
SELECT count(*) FROM test_missing_target x, test_missing_target y WHERE x.a = y.a GROUP BY x.b ORDER BY x.b;
SELECT * FROM test_missing_target2;
SELECT a%2, count(b) FROM test_missing_target GROUP BY test_missing_target.a%2 ORDER BY test_missing_target.a%2;
SELECT count(c) FROM test_missing_target GROUP BY lower(test_missing_target.c) ORDER BY lower(test_missing_target.c);
SELECT count(a) FROM test_missing_target GROUP BY a ORDER BY b;
SELECT count(b) FROM test_missing_target GROUP BY b/2 ORDER BY b/2;
SELECT lower(test_missing_target.c), count(c) FROM test_missing_target GROUP BY lower(c) ORDER BY lower(c);
SELECT a FROM test_missing_target ORDER BY upper(d);
SELECT count(b) FROM test_missing_target GROUP BY (b + 1) / 2 ORDER BY (b + 1) / 2 desc;
SELECT count(x.a) FROM test_missing_target x, test_missing_target y WHERE x.a = y.a GROUP BY b/2 ORDER BY b/2;
SELECT x.b/2, count(x.b) FROM test_missing_target x, test_missing_target y WHERE x.a = y.a GROUP BY x.b/2 ORDER BY x.b/2;
SELECT count(b) FROM test_missing_target x, test_missing_target y WHERE x.a = y.a GROUP BY x.b/2;
SELECT count(x.b) FROM test_missing_target x, test_missing_target y WHERE x.a = y.a GROUP BY x.b/2 ORDER BY x.b/2;
SELECT * FROM test_missing_target3;
SELECT DISTINCT two FROM tmp ORDER BY 1;
SELECT DISTINCT two, string4, ten FROM tmp ORDER BY two using <, string4 using <, ten using <;
SELECT DISTINCT p.age FROM person* p ORDER BY age using >;
SELECT count(*) FROM (SELECT DISTINCT two, four, two FROM tenk1) ss;
SELECT f1, f1 IS DISTINCT FROM 2 as "not 2" FROM disttable;
SELECT f1, f1 IS DISTINCT FROM NULL as "not null" FROM disttable;
SELECT f1, f1 IS DISTINCT FROM f1 as "false" FROM disttable;
SELECT f1, f1 IS DISTINCT FROM f1+1 as "not null" FROM disttable;
SELECT 1 IS DISTINCT FROM 2 as "yes";
SELECT 2 IS DISTINCT FROM 2 as "no";
SELECT 2 IS DISTINCT FROM null as "yes";
SELECT null IS DISTINCT FROM null as "no";
SELECT DISTINCT ON (string4) string4, two, ten FROM tmp ORDER BY string4 using <, two using >, ten using <;
SELECT DISTINCT ON (string4, ten) string4, two, ten FROM tmp ORDER BY string4 using <, two using <, ten using <;
SELECT DISTINCT ON (string4, ten) string4, ten, two FROM tmp ORDER BY string4 using <, ten using >, two using <;
select distinct on (1) floor(random()) as r, f1 from int4_tbl order by 1,2;
SELECT c1, c2 FROM t1 WHERE c2 IN ('v', 'c', 'f', 'p', 'I') AND c3 <> 0;
SELECT xmlcomment('hello');
SELECT xmlcomment('test');
SELECT xmlconcat(xmlcomment('hello'), xmlelement(NAME qux, 'foo'), xmlcomment('world'));
SELECT xmlconcat('<foo/>', NULL, '<?xml version="1.1" standalone="no"?><bar/>');
SELECT xmlconcat('<?xml version="1.1"?><foo/>', NULL, '<?xml version="1.1" standalone="no"?><bar/>');
SELECT xmlelement(name element, xmlattributes (1 as one, 'deuce' as two), 'content');
SELECT xmlelement(name element, xmlattributes ('unnamed and wrong'));
SELECT xmlelement(name element, xmlelement(name nested, 'stuff'));
SELECT xmlelement(name employee, xmlforest(name, age, salary as pay)) FROM emp;
SELECT xmlelement(name duplicate, xmlattributes(1 as a, 2 as b, 3 as a));
SELECT xmlelement(name num, 37);
SELECT xmlelement(name foo, text 'bar');
SELECT xmlelement(name foo, xml 'bar');
SELECT xmlelement(name foo, text 'b<a/>r');
SELECT xmlelement(name foo, xml 'b<a/>r');
SELECT xmlelement(name foo, array[1, 2, 3]);
SELECT xmlelement(name foo, bytea 'bar');
SELECT xmlelement(name foo, xmlattributes(true as bar));
SELECT xmlelement(name foo, xmlattributes('2009-04-09 00:24:37'::timestamp as bar));
SELECT xmlelement(name foo, xmlattributes('infinity'::timestamp as bar));
SELECT xmlelement(name foo, xmlattributes('<>&"''' as funny, xml 'b<a/>r' as funnier));
SELECT xmlparse(content '<nosuchprefix:tag/>');
SELECT xmlparse(document '   ');
SELECT xmlparse(document '<abc>x</abc>');
SELECT xmlpi(name foo);
SELECT xmlpi(name xml);
SELECT xmlpi(name xmlstuff);
SELECT xmlpi(name foo, 'bar');
SELECT xmlpi(name foo, 'in?>valid');
SELECT xmlpi(name foo, null);
SELECT xmlpi(name xml, null);
SELECT xmlpi(name xmlstuff, null);
SELECT xmlpi(name "xml-stylesheet", 'href="mystyle.css" type="text/css"');
SELECT xmlpi(name foo, '   bar');
SELECT xmlroot(xml '<foo/>', version no value, standalone no value);
SELECT xmlroot(xml '<foo/>', version '2.0');
SELECT xmlroot(xml '<foo/>', version no value, standalone yes);
SELECT xmlroot(xml '<?xml version="1.1"?><foo/>', version no value, standalone yes);
SELECT xmlroot(xmlroot(xml '<foo/>', version '1.0'), version '1.1', standalone no);
SELECT xmlroot('<?xml version="1.1" standalone="yes"?><foo/>', version no value, standalone no);
SELECT xmlroot('<?xml version="1.1" standalone="yes"?><foo/>', version no value, standalone no value);
SELECT xmlroot('<?xml version="1.1" standalone="yes"?><foo/>', version no value);
SELECT xmlroot (xmlelement (name gazonk, xmlattributes ('val' AS name, 1 + 1 AS num), 
    xmlelement (NAME qux, 'foo')), version '1.0', standalone yes);
SELECT xmlserialize(content data as character varying(20)) FROM xmltest;
SELECT xmlserialize(content 'good' as char(10));
SELECT xmlserialize(document 'bad' as text);
SELECT xml '<foo>bar</foo>' IS DOCUMENT;
SELECT xml '<foo>bar</foo><bar>foo</bar>' IS DOCUMENT;
SELECT xml '<abc/>' IS NOT DOCUMENT;
SELECT xml 'abc' IS NOT DOCUMENT;
SELECT '<>' IS NOT DOCUMENT;
SELECT xmlagg(data) FROM xmltest;
SELECT xmlagg(data) FROM xmltest WHERE id > 10;
SELECT xmlelement(name employees, xmlagg(xmlelement(name name, name))) FROM emp;
SELECT xmlpi(name ":::_xml_abc135.%-&_");
SELECT xmlpi(name "123");
SELECT xpath('/value', data) FROM xmltest;
SELECT xpath(NULL, NULL) IS NULL FROM xmltest;
SELECT xpath('', '<!-- error -->');
SELECT xpath('root', '<root/>');
SELECT xmlexists('count(/nosuchtag)' PASSING BY REF '<root/>');
SELECT xpath_exists('//town[text() = ''Cwmbran'']','<towns><town>Cwmbran</town></towns>'::xml);
SELECT xpath_exists('count(/nosuchtag)', '<root/>'::xml);
SELECT COUNT(id) FROM xmltest WHERE xmlexists('/menu/beer' PASSING data);
SELECT COUNT(id) FROM xmltest WHERE xmlexists('/menu/beer' PASSING BY REF data BY REF);
SELECT COUNT(id) FROM xmltest WHERE xmlexists('/menu/beers' PASSING BY REF data);
SELECT COUNT(id) FROM xmltest WHERE xmlexists('/menu/beers/name[text() = ''Molson'']' PASSING BY REF data);
SELECT COUNT(id) FROM xmltest WHERE xpath_exists('/menu/beer',data);
SELECT COUNT(id) FROM xmltest WHERE xpath_exists('/menu/beers',data);
SELECT COUNT(id) FROM xmltest WHERE xpath_exists('/menu/beers/name[text() = ''Molson'']',data);
SELECT COUNT(id) FROM xmltest WHERE xpath_exists('/myns:menu/myns:beer',data,ARRAY[ARRAY['myns','http://myns.com']]);
SELECT COUNT(id) FROM xmltest WHERE xpath_exists('/myns:menu/myns:beers',data,ARRAY[ARRAY['myns','http://myns.com']]);
SELECT COUNT(id) FROM xmltest WHERE xpath_exists('/myns:menu/myns:beers/myns:name[text() = ''Molson'']',data,ARRAY[ARRAY['myns','http://myns.com']]);
SELECT COUNT(id) FROM xmltest, query WHERE xmlexists(expr PASSING BY REF data);
SELECT xml_is_well_formed_content('<foo>bar</foo>');
SELECT xml_is_well_formed_content('abc');
SELECT xml_is_well_formed('abc');
SELECT xml_is_well_formed('<foo><bar>baz</foo>');
SELECT xml_is_well_formed('<local:data xmlns:local="http://127.0.0.1"><local:piece id="1">number one</local:piece><local:piece id="2" /></local:data>');
SELECT xml_is_well_formed('<pg:foo xmlns:pg="http://postgresql.org/stuff">bar</pg:foo>');
SELECT xpath('/*', '<invalidns xmlns=''&lt;''/>');
SELECT xpath('/*', '<nosuchprefix:tag/>');
SELECT xpath('/*', '<relativens xmlns=''relative''/>');
SELECT XMLPARSE(DOCUMENT '<!DOCTYPE foo [<!ENTITY c SYSTEM "/etc/passwd">]><foo>&c;</foo>');
SELECT xmltable.* FROM xmltest2, LATERAL xmltable('/d/r' PASSING x COLUMNS a int PATH '' || lower(_path) || 'c');
SELECT xmltable.* FROM xmltest2, LATERAL xmltable(('/d/r/' || lower(_path) || 'c') PASSING x COLUMNS a int PATH '.');
SELECT xmltable.* FROM xmltest2, LATERAL xmltable(('/d/r/' || lower(_path) || 'c') PASSING x COLUMNS a int PATH 'x' DEFAULT ascii(_path) - 54);
SELECT xmltable.* FROM xmldata, LATERAL xmltable('/ROWS/ROW[COUNTRY_NAME="Japan" or COUNTRY_NAME="India"]' PASSING data COLUMNS "COUNTRY_NAME" text, "REGION_ID" int) WHERE "COUNTRY_NAME" = 'Japan';
SELECT xmltable.* FROM xmldata, LATERAL xmltable('/ROWS/ROW[COUNTRY_NAME="Japan" or COUNTRY_NAME="India"]' PASSING data COLUMNS "COUNTRY_NAME" text, "REGION_ID" int);
SELECT xmltable.* FROM xmldata, LATERAL xmltable('/ROWS/ROW[COUNTRY_NAME="Japan" or COUNTRY_NAME="India"]' PASSING data COLUMNS id int PATH '@id', "COUNTRY_NAME" text, "REGION_ID" int);
SELECT xmltable.* FROM xmldata, LATERAL xmltable('/ROWS/ROW[COUNTRY_NAME="Japan" or COUNTRY_NAME="India"]' PASSING data COLUMNS id int PATH '@id');
SELECT xmltable.* FROM xmldata, LATERAL xmltable('/ROWS/ROW[COUNTRY_NAME="Japan" or COUNTRY_NAME="India"]' PASSING data COLUMNS id FOR ORDINALITY);
SELECT xmltable.* FROM xmldata, LATERAL xmltable('/ROWS/ROW[COUNTRY_NAME="Japan" or COUNTRY_NAME="India"]' PASSING data COLUMNS id int PATH '@id', "COUNTRY_NAME" text, "REGION_ID" int, rawdata xml PATH './*');
SELECT * FROM xmltable('/root' passing '<root><element>a1a<!-- aaaa -->a2a<?aaaaa?> <!--z-->  bbbb<x>xxx</x>cccc</element></root>' COLUMNS element text);
SELECT * FROM xmltable('/root' passing '<root><element>a1a<!-- aaaa -->a2a<?aaaaa?> <!--z-->  bbbb<x>xxx</x>cccc</element></root>' COLUMNS element text PATH 'element/text()'); -- should fail
select * from xmltable('d/r' passing '<d><r><c><![CDATA[<hello> &"<>!<a>foo</a>]]></c></r><r><c>2</c></r></d>' columns c text);
SELECT * FROM xmltable('/x/a' PASSING '<x><a><ent>&apos;</ent></a><a><ent>&quot;</ent></a><a><ent>&amp;</ent></a><a><ent>&lt;</ent></a><a><ent>&gt;</ent></a></x>' COLUMNS ent text);
SELECT * FROM xmltable('/x/a' PASSING '<x><a><ent>&apos;</ent></a><a><ent>&quot;</ent></a><a><ent>&amp;</ent></a><a><ent>&lt;</ent></a><a><ent>&gt;</ent></a></x>' COLUMNS ent xml);
SELECT  xmltable.*
   FROM (SELECT data FROM xmldata) x,
        LATERAL XMLTABLE('/ROWS/ROW'
                         PASSING data
                         COLUMNS id int PATH '@id',
                                  _id FOR ORDINALITY,
                                  country_name text PATH 'COUNTRY_NAME/text()' NOT NULL,
                                  country_id text PATH 'COUNTRY_ID',
                                  region_id int PATH 'REGION_ID',
                                  size float PATH 'SIZE',
                                  unit text PATH 'SIZE/@unit',
                                  premier_name text PATH 'PREMIER_NAME' DEFAULT 'not specified');
SELECT * FROM XMLTABLE(XMLNAMESPACES('http://x.y' AS zz),
                      '/zz:rows/zz:row'
                      PASSING '<rows xmlns="http://x.y"><row><a>10</a></row></rows>'
                      COLUMNS a int PATH 'zz:a');
SELECT xmltable.*
   FROM (SELECT data FROM xmldata) x,
        LATERAL XMLTABLE('/ROWS/ROW'
                         PASSING data
                         COLUMNS id int PATH '@id',
                                  _id FOR ORDINALITY,
                                  country_name text PATH 'COUNTRY_NAME' NOT NULL,
                                  country_id text PATH 'COUNTRY_ID',
                                  region_id int PATH 'REGION_ID',
                                  size float PATH 'SIZE',
                                  unit text PATH 'SIZE/@unit',
                                  premier_name text PATH 'PREMIER_NAME' DEFAULT 'not specified');
SELECT  xmltable.*
   FROM (SELECT data FROM xmldata) x,
        LATERAL XMLTABLE('/ROWS/ROW'
                         PASSING data
                         COLUMNS id int PATH '@id',
                                  _id FOR ORDINALITY,
                                  country_name text PATH 'COUNTRY_NAME' NOT NULL,
                                  country_id text PATH 'COUNTRY_ID',
                                  region_id int PATH 'REGION_ID',
                                  size float PATH 'SIZE',
                                  unit text PATH 'SIZE/@unit',
                                  premier_name text PATH 'PREMIER_NAME' DEFAULT 'not specified');
SELECT  xmltable.*
   FROM (SELECT data FROM xmldata) x,
        LATERAL XMLTABLE('/ROWS/ROW'
                         PASSING data
                         COLUMNS id int PATH '@id',
                                  _id FOR ORDINALITY,
                                  country_name text PATH 'COUNTRY_NAME' NOT NULL,
                                  country_id text PATH 'COUNTRY_ID',
                                  region_id int PATH 'REGION_ID',
                                  size float PATH 'SIZE',
                                  unit text PATH 'SIZE/@unit',
                                  premier_name text PATH 'PREMIER_NAME' DEFAULT 'not specified');
SELECT  xmltable.*
   FROM (SELECT data FROM xmldata) x,
        LATERAL XMLTABLE('/ROWS/ROW'
                         PASSING data
                         COLUMNS id int PATH '@id',
                                  _id FOR ORDINALITY,
                                  country_name text PATH 'COUNTRY_NAME' NOT NULL,
                                  country_id text PATH 'COUNTRY_ID',
                                  region_id int PATH 'REGION_ID',
                                  size float PATH 'SIZE',
                                  unit text PATH 'SIZE/@unit',
                                  premier_name text PATH 'PREMIER_NAME' DEFAULT 'not specified')
  WHERE region_id = 2;
SELECT  xmltable.*
   FROM (SELECT data FROM xmldata) x,
        LATERAL XMLTABLE('/ROWS/ROW'
                         PASSING data
                         COLUMNS id int PATH '@id',
                                  _id FOR ORDINALITY,
                                  country_name text PATH 'COUNTRY_NAME' NOT NULL,
                                  country_id text PATH 'COUNTRY_ID',
                                  region_id int PATH 'REGION_ID',
                                  size float PATH 'SIZE',
                                  unit text PATH 'SIZE/@unit',
                                  premier_name text PATH 'PREMIER_NAME' DEFAULT 'not specified')
  WHERE region_id = 2;
SELECT  xmltable.*
   FROM (SELECT data FROM xmldata) x,
        LATERAL XMLTABLE('/ROWS/ROW'
                         PASSING data
                         COLUMNS id int PATH '@id',
                                  _id FOR ORDINALITY,
                                  country_name text PATH 'COUNTRY_NAME' NOT NULL,
                                  country_id text PATH 'COUNTRY_ID',
                                  region_id int PATH 'REGION_ID',
                                  size float PATH 'SIZE' NOT NULL,
                                  unit text PATH 'SIZE/@unit',
                                  premier_name text PATH 'PREMIER_NAME' DEFAULT 'not specified');
WITH
   x AS (SELECT proname, proowner, procost::numeric, pronargs,
                array_to_string(proargnames,',') as proargnames,
                case when proargtypes <> '' then array_to_string(proargtypes::oid[],',') end as proargtypes
           FROM pg_proc WHERE proname = 'f_leak'),
   y AS (SELECT xmlelement(name proc,
                           xmlforest(proname, proowner,
                                     procost, pronargs,
                                     proargnames, proargtypes)) as proc
           FROM x),
   z AS (SELECT xmltable.*
           FROM y,
                LATERAL xmltable('/proc' PASSING proc
                                 COLUMNS proname name,
                                         proowner oid,
                                         procost float,
                                         pronargs int,
                                         proargnames text,
                                         proargtypes text))
   SELECT * FROM z
   EXCEPT SELECT * FROM x;
WITH
   x AS (SELECT proname, proowner, procost::numeric, pronargs,
                array_to_string(proargnames,',') as proargnames,
                case when proargtypes <> '' then array_to_string(proargtypes::oid[],',') end as proargtypes
           FROM pg_proc),
   y AS (SELECT xmlelement(name data,
                           xmlagg(xmlelement(name proc,
                                             xmlforest(proname, proowner, procost,
                                                       pronargs, proargnames, proargtypes)))) as doc
           FROM x),
   z AS (SELECT xmltable.*
           FROM y,
                LATERAL xmltable('/data/proc' PASSING doc
                                 COLUMNS proname name,
                                         proowner oid,
                                         procost float,
                                         pronargs int,
                                         proargnames text,
                                         proargtypes text))
   SELECT * FROM z
   EXCEPT SELECT * FROM x;
SELECT table_to_xml('testxmlschema.test1', true, false, 'foo');
SELECT table_to_xmlschema('testxmlschema.test1', false, true, 'foo');
SELECT table_to_xml_and_xmlschema('testxmlschema.test1', true, true, 'foo');
SELECT query_to_xml('SELECT * FROM testxmlschema.test1', false, false, '');
SELECT query_to_xmlschema('SELECT * FROM testxmlschema.test1', false, false, '');
SELECT query_to_xml_and_xmlschema('SELECT * FROM testxmlschema.test1', true, true, '');
SELECT cursor_to_xml('xc'::refcursor, 5, false, true, '');
SELECT cursor_to_xmlschema('xc'::refcursor, false, true, '');
SELECT schema_to_xml_and_xmlschema('testxmlschema', true, true, 'foo');
SELECT xmlforest(c1, c2, c3, c4) FROM testxmlschema.test3;
SELECT table_to_xml('testxmlschema.test3', true, true, '');
SELECT t.id FROM test_tablesample AS t TABLESAMPLE SYSTEM (50) REPEATABLE (0);
SELECT id FROM test_tablesample TABLESAMPLE SYSTEM (100.0/11) REPEATABLE (0);
SELECT id FROM test_tablesample TABLESAMPLE SYSTEM (50) REPEATABLE (0);
SELECT id FROM test_tablesample TABLESAMPLE BERNOULLI (50) REPEATABLE (0);
SELECT id FROM test_tablesample TABLESAMPLE BERNOULLI (5.5) REPEATABLE (0);
SELECT count(*) FROM test_tablesample TABLESAMPLE SYSTEM (100);
SELECT count(*) FROM test_tablesample TABLESAMPLE SYSTEM (100) REPEATABLE (1+2);
SELECT count(*) FROM test_tablesample TABLESAMPLE SYSTEM (100) REPEATABLE (0.4);
SELECT count(*) FROM test_tablesample TABLESAMPLE bernoulli (('1'::text < '0'::text)::int);
select * from (values (0),(100)) v(pct), lateral (select count(*) from tenk1 tablesample bernoulli (pct)) ss;
select * from (values (0),(100)) v(pct), lateral (select count(*) from tenk1 tablesample system (pct)) ss;
select pct, count(unique1) from (values (0),(100)) v(pct), lateral (select * from tenk1 tablesample bernoulli (pct)) ss group by pct;
select pct, count(unique1) from (values (0),(100)) v(pct), lateral (select * from tenk1 tablesample system (pct)) ss group by pct;
SELECT id FROM test_tablesample TABLESAMPLE FOOBAR (1);
SELECT id FROM test_tablesample TABLESAMPLE SYSTEM (NULL);
SELECT id FROM test_tablesample TABLESAMPLE SYSTEM (50) REPEATABLE (NULL);
SELECT id FROM test_tablesample TABLESAMPLE BERNOULLI (-1);
SELECT id FROM test_tablesample TABLESAMPLE BERNOULLI (200);
SELECT id FROM test_tablesample TABLESAMPLE SYSTEM (-1);
SELECT id FROM test_tablesample TABLESAMPLE SYSTEM (200);
SELECT id FROM test_tablesample_v1 TABLESAMPLE BERNOULLI (1);
select * from parted_sample tablesample bernoulli (100);
WITH query_select AS (SELECT * FROM test_tablesample) SELECT * FROM query_select TABLESAMPLE BERNOULLI (5.5) REPEATABLE (1);
SELECT * FROM document TABLESAMPLE BERNOULLI(50) REPEATABLE(0) WHERE f_leak(dtitle) ORDER BY did;
select case pg_is_in_recovery() when false then 'First ' || 'case' else 'Second case' end;
select length(txid_current_snapshot()::text) >= 4;
SELECT nextval('hsseq');
SELECT '' AS ten, c AS cidr, i AS inet FROM INET_TBL;
SELECT '' AS ten, i AS inet, host(i), text(i), family(i) FROM INET_TBL;
SELECT '' AS ten, c AS cidr, broadcast(c), i AS inet, broadcast(i) FROM INET_TBL;
SELECT '' AS ten, c AS cidr, network(c) AS "network(cidr)", i AS inet, network(i) AS "network(inet)" FROM INET_TBL;
SELECT '' AS ten, c AS cidr, masklen(c) AS "masklen(cidr)", i AS inet, masklen(i) AS "masklen(inet)" FROM INET_TBL;
SELECT masklen(c) AS "masklen(cidr)",i AS inet, masklen(i) FROM INET_TBL WHERE masklen(c) <= 8;
SELECT '' AS six, c AS cidr, i AS inet FROM INET_TBL WHERE c = i;
SELECT '' AS ten, i, c,
  i < c AS lt, i <= c AS le, i = c AS eq,
  i >= c AS ge, i > c AS gt, i <> c AS ne,
  i << c AS sb, i <<= c AS sbe,
  i >> c AS sup, i >>= c AS spe,
  i && c AS ovr
  FROM INET_TBL;
SELECT max(i) AS max, min(i) AS min FROM INET_TBL;
SELECT max(c) AS max, min(c) AS min FROM INET_TBL;
SELECT '' AS ten, set_masklen(inet(text(i)), 24) FROM INET_TBL;
SELECT * FROM inet_tbl WHERE i<<'192.168.1.0/24'::cidr;
SELECT * FROM inet_tbl WHERE i<<='192.168.1.0/24'::cidr;
SELECT * FROM inet_tbl WHERE i << '192.168.1.0/24'::cidr ORDER BY i;
SELECT * FROM inet_tbl WHERE i <<= '192.168.1.0/24'::cidr ORDER BY i;
SELECT * FROM inet_tbl WHERE i && '192.168.1.0/24'::cidr ORDER BY i;
SELECT * FROM inet_tbl WHERE i >>= '192.168.1.0/24'::cidr ORDER BY i;
SELECT * FROM inet_tbl WHERE i >> '192.168.1.0/24'::cidr ORDER BY i;
SELECT * FROM inet_tbl WHERE i < '192.168.1.0/24'::cidr ORDER BY i;
SELECT * FROM inet_tbl WHERE i <= '192.168.1.0/24'::cidr ORDER BY i;
SELECT * FROM inet_tbl WHERE i = '192.168.1.0/24'::cidr ORDER BY i;
SELECT * FROM inet_tbl WHERE i >= '192.168.1.0/24'::cidr ORDER BY i;
SELECT * FROM inet_tbl WHERE i > '192.168.1.0/24'::cidr ORDER BY i;
SELECT * FROM inet_tbl WHERE i <> '192.168.1.0/24'::cidr ORDER BY i;
SELECT i, ~i AS "~i" FROM inet_tbl;
SELECT i, c, i & c AS "and" FROM inet_tbl;
SELECT i, c, i | c AS "or" FROM inet_tbl;
SELECT i, i + 500 AS "i+500" FROM inet_tbl;
SELECT i, i - 500 AS "i-500" FROM inet_tbl;
SELECT i, c, i - c AS "minus" FROM inet_tbl;
SELECT '127.0.0.1'::inet + 257;
SELECT ('127.0.0.1'::inet + 257) - 257;
SELECT '127::1'::inet + 257;
SELECT ('127::1'::inet + 257) - 257;
SELECT '127.0.0.2'::inet  - ('127.0.0.2'::inet + 500);
SELECT '127.0.0.2'::inet  - ('127.0.0.2'::inet - 500);
SELECT '127::2'::inet  - ('127::2'::inet + 500);
SELECT '127::2'::inet  - ('127::2'::inet - 500);
SELECT '127.0.0.1'::inet + 10000000000;
SELECT '127.0.0.1'::inet - 10000000000;
SELECT '126::1'::inet - '127::2'::inet;
SELECT '127::1'::inet - '126::2'::inet;
SELECT '127::1'::inet + 10000000000;
SELECT '127::1'::inet - '127::2'::inet;
SELECT inet_merge(c, i) FROM INET_TBL;
SELECT inet_merge(c, i) FROM INET_TBL WHERE inet_same_family(c, i);
SELECT satisfies_hash_partition('mchash'::regclass, 2, 1, NULL::int, NULL::int);
SELECT satisfies_hash_partition('mchash'::regclass, 4, 0, 2, ''::text);
SELECT satisfies_hash_partition('mchash'::regclass, 2, 1, variadic array[1,2]::int[]);
SELECT satisfies_hash_partition('mcinthash'::regclass, 4, 0, variadic array[0, 0]);
SELECT satisfies_hash_partition('mcinthash'::regclass, 4, 0, variadic array[0, 1]);
SELECT satisfies_hash_partition('mcinthash'::regclass, 4, 0, variadic array[now(), now()]);
SELECT '2006-08-13 12:34:56'::timestamptz;
SELECT char 'c' = char 'c' AS true;
SELECT '' AS six, c.* FROM CHAR_TBL c WHERE c.f1 <> 'a';
SELECT '0/16AE7F8' = '0/16AE7F8'::pg_lsn;
SELECT '0/16AE7F8'::pg_lsn != '0/16AE7F7';
SELECT '0/16AE7F7' < '0/16AE7F8'::pg_lsn;
SELECT '0/16AE7F8' > pg_lsn '0/16AE7F7';
SELECT '0/16AE7F7'::pg_lsn - '0/16AE7F8'::pg_lsn;
SELECT '0/16AE7F8'::pg_lsn - '0/16AE7F7'::pg_lsn;
SELECT DISTINCT (i || '/' || j)::pg_lsn f
  FROM generate_series(1, 10) i, generate_series(1, 10) j, generate_series(1, 5) k
  WHERE i <= 10 AND j > 0 AND j <= 10 ORDER BY f;
select box(point(0.05*i, 0.05*i), point(0.05*i, 0.05*i)), point(0.05*i, 0.05*i), circle(point(0.05*i, 0.05*i), 1.0);
select p from gist_tbl where p <@ box(point(0,0), point(0.5, 0.5));
select p from gist_tbl where p <@ box(point(0,0), point(0.5, 0.5)) order by p <-> point(0.201, 0.201);
select p from
  (values (box(point(0,0), point(0.5,0.5))),
          (box(point(0.5,0.5), point(0.75,0.75))),
          (box(point(0.8,0.8), point(1.0,1.0)))) as v(bb)
cross join lateral
  (select p from gist_tbl where p <@ bb order by p <-> bb[0] limit 2) ss;
select p from
  (values (box(point(0,0), point(0.5,0.5))),
          (box(point(0.5,0.5), point(0.75,0.75))),
          (box(point(0.8,0.8), point(1.0,1.0)))) as v(bb)
cross join lateral
  (select p from gist_tbl where p <@ bb order by p <-> bb[0] limit 2) ss;
(SELECT unique1 AS random FROM onek ORDER BY random() LIMIT 1)
INTERSECT
(SELECT unique1 AS random FROM onek ORDER BY random() LIMIT 1)
INTERSECT
(SELECT unique1 AS random FROM onek ORDER BY random() LIMIT 1);
SELECT count(*) AS random FROM onek WHERE random() < 1.0/10;
SELECT random, count(random) FROM RANDOM_TBL GROUP BY random HAVING count(random) > 3;
SELECT AVG(random) FROM RANDOM_TBL HAVING AVG(random) NOT BETWEEN 80 AND 120;
SELECT 'NaN'::float4;
SELECT '' AS four, f.* FROM FLOAT4_TBL f WHERE f.f1 <> '1004.3';
SELECT '' AS bad, f.f1 / '0.0' from FLOAT4_TBL f;
SELECT '' AS five, f.f1, @f.f1 AS abs_f1 FROM FLOAT4_TBL f;
SELECT '32767.4'::float4::int2;
SELECT * INTO films_recent FROM films WHERE date_prod >= '2002-01-01';
SELECT * INTO TABLE films_recent FROM films WHERE date_prod >= '2002-01-01';
SELECT * INTO TEMP TABLE public.films_recent FROM films WHERE date_prod >= '2002-01-01';
select tableoid::regclass::text, a, min(b) as min_b, max(b) as max_b from list_parted group by 1, 2 order by 1;
SELECT date(now())::text = current_date::text;
SELECT now()::timetz::text = current_time::text;
SELECT now()::time::text = localtime::text;
SELECT current_timestamp = NOW();
SELECT length(current_timestamp::text) >= length(current_timestamp(0)::text);
SELECT now()::timestamp::text = localtimestamp::text;
SELECT current_catalog = current_database();
SELECT regoper('||/');
SELECT regoperator('+(int4,int4)');
SELECT regproc('now');
SELECT regprocedure('abs(numeric)');
SELECT regclass('pg_class');
SELECT regtype('int4');
SELECT to_regoper('||/');
SELECT to_regoperator('+(int4,int4)');
SELECT to_regproc('now');
SELECT to_regprocedure('abs(numeric)');
SELECT to_regclass('pg_class');
SELECT to_regtype('int4');
SELECT regoper('pg_catalog.||/');
SELECT regoperator('pg_catalog.+(int4,int4)');
SELECT regproc('pg_catalog.now');
SELECT regprocedure('pg_catalog.abs(numeric)');
SELECT regclass('pg_catalog.pg_class');
SELECT regtype('pg_catalog.int4');
SELECT to_regoper('pg_catalog.||/');
SELECT to_regproc('pg_catalog.now');
SELECT to_regprocedure('pg_catalog.abs(numeric)');
SELECT to_regclass('pg_catalog.pg_class');
SELECT to_regtype('pg_catalog.int4');
SELECT regrole('regress_regrole_test');
SELECT regrole('"regress_regrole_test"');
SELECT regnamespace('pg_catalog');
SELECT regnamespace('"pg_catalog"');
SELECT to_regrole('regress_regrole_test');
SELECT to_regrole('"regress_regrole_test"');
SELECT to_regnamespace('pg_catalog');
SELECT to_regnamespace('"pg_catalog"');
SELECT size, pg_size_bytes(size) FROM (VALUES ('0'), ('-.0 gb')) x(size);
SELECT '' AS six, c.* FROM VARCHAR_TBL c WHERE c.f1 <> 'a';
SELECT generate_series(1, 2), generate_series(1,4);
SELECT generate_series(1, generate_series(1, 3));
SELECT * FROM generate_series(1, generate_series(1, 3));
SELECT generate_series(1, generate_series(1, 3)), generate_series(2, 4);
SELECT few.id, generate_series(1,3) g FROM few ORDER BY id, g DESC;
SELECT few.id, generate_series(1,3) g FROM few ORDER BY id, generate_series(1,3) DESC;
SELECT few.id FROM few ORDER BY id, generate_series(1,3) DESC;
SELECT few.dataa, count(*), min(id), max(id), unnest('{1,1,3}'::int[]) FROM few WHERE few.id = 1 GROUP BY few.dataa, unnest('{1,1,3}'::int[]);
SELECT dataa, generate_series(1,1), count(*) FROM few GROUP BY 1, 2 HAVING count(*) > 1;
SELECT few.dataa, count(*) FROM few WHERE dataa = 'a' GROUP BY few.dataa ORDER BY 2;
SELECT few.dataa, count(*) FROM few WHERE dataa = 'a' GROUP BY few.dataa, unnest('{1,1,3}'::int[]) ORDER BY 2;
SELECT q1, case when q1 > 0 then generate_series(1,3) else 0 end FROM int8_tbl;
SELECT q1, coalesce(generate_series(1,3), 0) FROM int8_tbl;
SELECT min(generate_series(1, 3)) FROM few;
SELECT sum((3 = ANY(SELECT generate_series(1,4)))::int);
SELECT sum((3 = ANY(SELECT lag(x) over(order by x) FROM generate_series(1,4) x))::int);
SELECT min(generate_series(1, 3)) OVER() FROM few;
SELECT id,lag(id) OVER(), count(*) OVER(), generate_series(1,3) FROM few;
SELECT SUM(count(*)) OVER(PARTITION BY generate_series(1,3) ORDER BY generate_series(1,3)), generate_series(1,3) g FROM few GROUP BY g;
SELECT few.dataa, count(*), min(id), max(id), generate_series(1,3) FROM few GROUP BY few.dataa ORDER BY 5, 1;
SELECT dataa, datab b, generate_series(1,2) g, count(*) FROM few GROUP BY CUBE(dataa, datab, g) ORDER BY dataa;
select 'foo' as f, generate_series(1,2) as g from few order by 1;
SELECT int4mul(generate_series(1,2), 10);
SELECT generate_series(1,3) IS DISTINCT FROM 2;
SELECT * FROM int4mul(generate_series(1,2), 10);
SELECT DISTINCT ON (a) a, b, generate_series(1,3) g FROM (VALUES (3, 2), (5,1)) AS t(a, b) ORDER BY a, b DESC;
SELECT DISTINCT ON (g) a, b, generate_series(1,3) g FROM (VALUES (3, 2), (5,3), (5,1)) AS t(a, b);
SELECT a, generate_series(1,2) FROM (VALUES(1),(2),(3)) r(a) LIMIT 2 OFFSET 2;
SELECT 1 LIMIT generate_series(1,3);
SELECT (SELECT generate_series(1,3) LIMIT 1 OFFSET few.id) FROM few;
SELECT (SELECT generate_series(1,3) LIMIT 1 OFFSET g.i) FROM generate_series(0,3) g(i);
SELECT |@|ARRAY[1,2,3];
select generate_series(1,3) as x, generate_series(1,3) + 1 as xp1;
select generate_series(1,3)+1 order by generate_series(1,3);
VALUES(1, generate_series(1,2));
SELECT '1 2'::tsvector;
SELECT '''1 2'''::tsvector;
SELECT E'''1 \\''2'' '' 3'' 4 '::tsvector;
SELECT $$'\\as' ab\c ab\\c AB\\\c ab\\\\c$$::tsvector;
SELECT tsvectorin(tsvectorout($$'\\as' ab\c ab\\c AB\\\c ab\\\\c$$::tsvector));
SELECT '''w'':4A,3B,2C,1D,5 a:8';
SELECT 'a:3A b:2a'::tsvector || 'ba:1234 a:1B';
SELECT E'''1 \\''2'''::tsquery;
SELECT '1&(2&(4&(5|!6)))'::tsquery;
SELECT E'1&(''2''&('' 4''&(\\|5 | ''6 \\'' !|&'')))'::tsquery;
SELECT $$'\\as'$$::tsquery;
SELECT 'a | f | g' < 'b & c'::tsquery as "false";
SELECT numnode( 'new & york | qwery'::tsquery );
SELECT 'foo & bar'::tsquery && 'asd | fg';
SELECT 'a & g' <-> 'b <-> d'::tsquery;
SELECT 'a b:89  ca:23A,64c cb:80b d:34c'::tsvector @@ 'd:AC & c:*B' as "true";
SELECT 'supernova'::tsvector @@ 'super'::tsquery AS "false";
SELECT 'supeznova supernova'::tsvector @@ 'super:*'::tsquery AS "true";
SELECT to_tsvector('simple', '1 2 1 2') @@ '1 <3> 2' AS "true";
SELECT to_tsvector('simple', '1 2 11 3') @@ '1:* <-> 3' AS "true";
SELECT to_tsvector('simple', '1 2 1 2 3 4') @@ '1 <-> 2 <-> 3' AS "true";
SELECT strip(to_tsvector('simple', '1 2 3 4')) @@ '1 <-> 2 <-> 3' AS "false";
select to_tsvector('simple', '') @@ '!foo' AS "true";
SELECT ts_rank(' a:1 s:2 d g'::tsvector, 'a & s');
SELECT ts_rank_cd(' a:1 s:2 d g'::tsvector, 'a & s');
SELECT ts_rank_cd(' a:1 sa:2A sb:2D g'::tsvector, 'a <-> s:* <-> sa:B');
SELECT 'a:1 b:3'::tsvector @@ 'a <0> a:*'::tsquery AS "true";
SELECT strip('base:7 hidden:6 rebel:1 spaceship:2,33A,34B,35C,36D strike:3'::tsvector);
SELECT ts_delete('base hidden rebel spaceship strike'::tsvector, ARRAY['spaceship','leya','rebel', NULL]);
SELECT unnest('base hidden rebel spaceship strike'::tsvector);
SELECT * FROM unnest('base hidden rebel spaceship strike'::tsvector);
SELECT lexeme, positions[1] from unnest('base:7 hidden:6 rebel:1 spaceship:2,33A,34B,35C,36D strike:3'::tsvector);
SELECT array_to_tsvector(ARRAY['base','hidden','rebel','spaceship', NULL]);
SELECT array_to_tsvector(ARRAY['foo','bar','baz','bar']);
SELECT setweight('a:1,3A asd:1C w:5,6,12B,13A zxc:81,222A,567'::tsvector, 'c', '{a,zxc}');
SELECT setweight('a asd w:5,6,12B,13A zxc'::tsvector, 'c', ARRAY['a', 'zxc', NULL]);
SELECT ts_filter('base hidden rebel spaceship strike'::tsvector, '{a,b,NULL}');
SELECT 
    1 AS AUTHORIZATION,
    1 AS BINARY,
    1 AS COLLATION,
    1 AS CONCURRENTLY,
    1 AS CROSS,
    1 AS CURRENT_SCHEMA,
    1 AS FREEZE,
    1 AS FULL,
    1 AS ILIKE,
    1 AS INNER,
    1 AS IS,
    1 AS ISNULL,
    1 AS JOIN,
    1 AS LEFT,
    1 AS LIKE,
    1 AS NATURAL,
    1 AS NOTNULL,
    1 AS OUTER,
    1 AS OVERLAPS,
    1 AS RIGHT,
    1 AS SIMILAR,
    1 AS TABLESAMPLE,
    1 AS VERBOSE;
SELECT xmlcomment('test');
SELECT xmlconcat('hello', 'you');
SELECT xmlelement(name element, xmlattributes (1 as ":one:", 'deuce' as two), 'content&');
SELECT xmlelement(name employee, xmlforest(name, age, salary as pay)) FROM emp;
SELECT xmlparse(content '<abc>x</abc>');
SELECT xmlpi(name foo, 'bar');
SELECT xmlroot(xml '<foo/>', version no value, standalone yes);
SELECT xmlserialize(content 'good' as char(10));
SELECT xmlserialize(content 'good' as text);
SELECT  xmltable.*
   FROM (SELECT data FROM xmldata) x,
        LATERAL XMLTABLE('/ROWS/ROW'
                         PASSING data
                         COLUMNS id int PATH '@id',
                                  _id FOR ORDINALITY,
                                  country_name text PATH 'COUNTRY_NAME/text()' NOT NULL,
                                  country_id text PATH 'COUNTRY_ID',
                                  region_id int PATH 'REGION_ID',
                                  size float PATH 'SIZE',
                                  unit text PATH 'SIZE/@unit',
                                  premier_name text PATH 'PREMIER_NAME' DEFAULT 'not specified');
SELECT * FROM XMLTABLE(XMLNAMESPACES('http://x.y' AS zz),
                      '/zz:rows/zz:row'
                      PASSING '<rows xmlns="http://x.y"><row><a>10</a></row></rows>'
                      COLUMNS a int PATH 'zz:a');
SELECT 1 INTO b;
select json_object('{a, 1, b, "def", c, 3.5}');
select json_object('{{a, 1}, {b, "def"}, {c, 3.5}}');
select json_object('{a,b}', '{1,2}');
select json_object('code' VALUE 'P123', 'title': 'Jaws');
select json_objectagg(k:v) FROM (VALUES ('a'::text,current_date),('b',current_date + 1)) AS t(k,v);
select JSON_EXISTS(jsonb '{"key1": [1,2,3]}', 'strict $.key1[*] ? (@ > $x)' PASSING 2 AS x);
select JSON_EXISTS(jsonb '{"a": [1,2,3]}', 'lax $.a[5]' ERROR ON ERROR);
select JSON_EXISTS(jsonb '{"a": [1,2,3]}', 'strict $.a[5]' ERROR ON ERROR);
select JSON_VALUE(jsonb '"123.45"', '$' RETURNING float);
select JSON_VALUE(jsonb '"03:04 2015-02-01"', '$.datetime("HH24:MI YYYY-MM-DD")' RETURNING date);
select JSON_VALUE(jsonb '[1,2]', 'strict $[$off]' PASSING 1 as off);
select JSON_VALUE(jsonb '[1,2]', 'strict $[*]' DEFAULT 9 ON ERROR);
select JSON_QUERY(jsonb '[1,[2,3],null]', 'lax $[*][$off]' PASSING 1 AS off WITH CONDITIONAL WRAPPER);
select JSON_QUERY(jsonb '{"a": "[1, 2]"}', 'lax $.a' OMIT QUOTES);
select JSON_QUERY(jsonb '{"a": "[1, 2]"}', 'lax $.a' RETURNING int[] OMIT QUOTES ERROR ON ERROR);

SELECT * FROM JSON_TABLE (
'{"favorites":
    {"movies":
      [{"name": "One", "director": "John Doe"},
       {"name": "Two", "director": "Don Joe"}],
     "books":
      [{"name": "Mystery", "authors": [{"name": "Brown Dan"}]},
       {"name": "Wonder", "authors": [{"name": "Jun Murakami"}, {"name":"Craig Doe"}]}]
}}'::json, '$.favorites[*]'
COLUMNS (
  user_id FOR ORDINALITY,
  NESTED '$.movies[*]'
    COLUMNS (
    movie_id FOR ORDINALITY,
    mname text PATH '$.name',
    director text),
  NESTED '$.books[*]'
    COLUMNS (
      book_id FOR ORDINALITY,
      bname text PATH '$.name',
      NESTED '$.authors[*]'
        COLUMNS (
          author_id FOR ORDINALITY,
          author_name text PATH '$.name'))));
