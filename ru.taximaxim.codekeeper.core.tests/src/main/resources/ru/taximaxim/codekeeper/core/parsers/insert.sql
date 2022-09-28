insert into inserttest (col1, col2, col3) values (DEFAULT, DEFAULT, DEFAULT);
insert into inserttest (col2, col3) values (3, DEFAULT);
insert into inserttest (col1, col2, col3) values (DEFAULT, 5, DEFAULT);
insert into inserttest values (DEFAULT, 5, 'test');
insert into inserttest values (DEFAULT, 7);
insert into inserttest (col1, col2, col3) values (DEFAULT, DEFAULT);
insert into inserttest (col1, col2, col3) values (1, 2);
insert into inserttest (col1) values (1, 2);
insert into inserttest (col1) values (DEFAULT, DEFAULT);
insert into inserttest values(10, 20, '40'), (-1, 2, DEFAULT),
    ((select 2), (select i from (values(3)) as foo (i)), 'values are fun!');
insert into inserttest values(30, 50, repeat('x', 10000));
/*
insert into inserttest (f2[1], f2[2]) values (1,2);
insert into inserttest (f2[1], f2[2]) values (3,4), (5,6);
insert into inserttest (f2[1], f2[2]) select 7,8;
insert into inserttest (f2[1], f2[2]) values (1,default);  -- not supported

insert into inserttest (f3.if1, f3.if2) values (1,array['foo']);
insert into inserttest (f3.if1, f3.if2) values (1,'{foo}'), (2,'{bar}');
insert into inserttest (f3.if1, f3.if2) select 3, '{baz,quux}';
insert into inserttest (f3.if1, f3.if2) values (1,default);  -- not supported

insert into inserttest (f3.if2[1], f3.if2[2]) values ('foo', 'bar');
insert into inserttest (f3.if2[1], f3.if2[2]) values ('foo', 'bar'), ('baz', 'quux');
insert into inserttest (f3.if2[1], f3.if2[2]) select 'bear', 'beer';

insert into inserttest (f4[1].if2[1], f4[1].if2[2]) values ('foo', 'bar');
insert into inserttest (f4[1].if2[1], f4[1].if2[2]) values ('foo', 'bar'), ('baz', 'quux');
insert into inserttest (f4[1].if2[1], f4[1].if2[2]) select 'bear', 'beer';

select * from inserttest;

-- also check reverse-listing
create table inserttest2 (f1 bigint, f2 text);
create rule irule1 as on insert to inserttest2 do also
  insert into inserttest (f3.if2[1], f3.if2[2])
  values (new.f1,new.f2);
create rule irule2 as on insert to inserttest2 do also
  insert into inserttest (f4[1].if1, f4[1].if2[2])
  values (1,'fool'),(new.f1,new.f2);
create rule irule3 as on insert to inserttest2 do also
  insert into inserttest (f4[1].if1, f4[1].if2[2])
  select new.f1, new.f2;
*/
insert into range_parted values ('a', 11);
insert into part1 values ('a', 11);
insert into part1 values ('b', 1);
insert into part1 values ('a', 1);
insert into part4 values ('b', 21);
insert into part4 values ('a', 10);
insert into part4 values ('b', 10);
insert into part1 values (null);
insert into part1 values (1);
insert into part_aa_bb values ('cc', 1);
insert into part_aa_bb values ('AAa', 1);
insert into part_aa_bb values (null);
insert into part_cc_dd values ('cC', 1);
insert into part_null values (null, 0);
insert into part_default values ('aa', 2);
insert into part_default values (null, 2);
insert into part_default values ('Zz', 2);
insert into part_ee_ff1 values ('EE', 11);
insert into part_default_p2 values ('gg', 43);
insert into part_ee_ff1 values ('cc', 1);
insert into part_default values ('gg', 43);
insert into part_ee_ff1 values ('ff', 1);
insert into part_ee_ff2 values ('ff', 11);
insert into part_default_p1 values ('cd', 25);
insert into part_default_p2 values ('de', 35);
insert into list_parted values ('ab', 21);
insert into list_parted values ('xx', 1);
insert into list_parted values ('yy', 2);
insert into range_parted values ('a', 0);
insert into range_parted values ('a', 1);
insert into range_parted values ('a', 10);
insert into range_parted values ('a', 20);
insert into range_parted values ('b', 1);
insert into range_parted values ('b', 10);
insert into range_parted values ('a');
insert into part_def values ('b', 10);
insert into part_def values ('c', 10);
insert into range_parted values (null, null);
insert into range_parted values ('a', null);
insert into range_parted values (null, 19);
insert into range_parted values ('b', 20);
insert into list_parted values (null, 1);
insert into list_parted (a) values ('aA');
insert into list_parted values ('EE', 0);
insert into part_ee_ff values ('EE', 0);
insert into list_parted values ('EE', 1);
insert into part_ee_ff values ('EE', 10);
insert into list_parted values ('aa'), ('cc');
insert into list_parted select 'Ff', s.a from generate_series(1, 29) s(a);
insert into list_parted select 'gg', s.a from generate_series(1, 9) s(a);
insert into list_parted (b) values (1);
insert into hash_parted values(generate_series(1,10));
insert into hpart0 values(12),(16);
insert into hpart0 values(11);
insert into hpart3 values(11);
insert into part_default values (null);
insert into part_default values (1);
insert into part_default values (-1);
insert into mlparted values (1, 2);
insert into mlparted (a, b) values (1, 5);
insert into mlparted values (1, 2);
insert into mlparted1 (a, b) values (2, 3);
insert into lparted_nonullpart values (1);
with ins (a, b, c) as
  (insert into mlparted (b, a) select s.a, 1 from generate_series(2, 39) s(a) returning tableoid::regclass, *)
  select a, b, min(c), max(c) from ins group by a, b order by 1;
insert into mlparted values (1, 45, 'a');
insert into mlparted5 (a, b, c) values (1, 40, 'a');
insert into mlparted values (40, 100);
insert into mlparted_def1 values (42, 100);
insert into mlparted_def2 values (54, 50);
insert into mlparted values (70, 100);
insert into mlparted_def1 values (52, 50);
insert into mlparted_def2 values (34, 50);
insert into mlparted values (70, 100);
insert into key_desc values (1, 1);
insert into key_desc values (1, 1);
insert into key_desc values (2, 1);
insert into mcrparted values (null, null, null);
insert into mcrparted values (0, 1, 1);
insert into mcrparted0 values (0, 1, 1);
insert into mcrparted values (9, 1000, 1);
insert into mcrparted1 values (9, 1000, 1);
insert into mcrparted values (10, 5, -1);
insert into mcrparted1 values (10, 5, -1);
insert into mcrparted values (2, 1, 0);
insert into mcrparted1 values (2, 1, 0);
insert into mcrparted values (10, 6, 1000);
insert into mcrparted2 values (10, 6, 1000);
insert into mcrparted values (10, 1000, 1000);
insert into mcrparted2 values (10, 1000, 1000);
insert into mcrparted values (11, 1, -1);
insert into mcrparted3 values (11, 1, -1);
insert into mcrparted values (30, 21, 20);
insert into mcrparted5 values (30, 21, 20);
insert into mcrparted4 values (30, 21, 20); -- error
insert into brtrigpartcon values (1, 'hi there');
insert into brtrigpartcon1 values (1, 'hi there');
with result as (insert into brtrigpartcon values (1, 'hi there') returning 1)
  insert into inserttest3 (f3) select * from result;
insert into mcrparted values ('aaa', 0), ('b', 0), ('bz', 10), ('c', -10),
    ('comm', -10), ('common', -10), ('common', 0), ('common', 10),
    ('commons', 0), ('d', -10), ('e', 0);
insert into returningwrtest values (1) returning returningwrtest;
insert into returningwrtest values (2, 'foo') returning returningwrtest;
INSERT INTO collate_test1 VALUES (1, 'abc'), (2, 'äbc'), (3, 'bbc'), (4, 'ABC');
INSERT INTO collate_test3 SELECT * FROM collate_test1;
INSERT INTO BIT_TABLE VALUES (B'');
INSERT INTO BIT_TABLE VALUES (B'0');
INSERT INTO BIT_TABLE VALUES (B'10'); -- too short
INSERT INTO BIT_TABLE VALUES (B'11011');
INSERT INTO BIT_TABLE VALUES (B'010101');
INSERT INTO BIT_TABLE VALUES (B'00000000000');
INSERT INTO BIT_TABLE VALUES (B'01010101010');
INSERT INTO BIT_TABLE VALUES (B'11011000000');
INSERT INTO BIT_TABLE VALUES (B'101011111010'); -- too long
INSERT INTO BIT_TABLE VALUES (B'1101100000000000');
--INSERT INTO BIT_TABLE VALUES ('X554');
--INSERT INTO BIT_TABLE VALUES ('X555');
INSERT INTO BIT_TABLE SELECT b>>1 FROM BIT_TABLE;
INSERT INTO BIT_TABLE SELECT b>>2 FROM BIT_TABLE;
INSERT INTO BIT_TABLE SELECT b>>4 FROM BIT_TABLE;
INSERT INTO BIT_TABLE SELECT b>>8 FROM BIT_TABLE;
INSERT INTO BIT_TABLE SELECT CAST(v || B'0' AS BIT VARYING(6)) >>1 FROM BIT_TABLE;
INSERT INTO BIT_TABLE SELECT CAST(v || B'00' AS BIT VARYING(8)) >>2 FROM BIT_TABLE;
INSERT INTO BIT_TABLE SELECT CAST(v || B'0000' AS BIT VARYING(12)) >>4 FROM BIT_TABLE;
INSERT INTO BIT_TABLE SELECT CAST(v || B'00000000' AS BIT VARYING(20)) >>8 FROM BIT_TABLE;
INSERT INTO extra_wide_table(firstc, lastc) VALUES('first col', 'last col');
INSERT INTO partitioned2 VALUES (1, 'hello');
INSERT INTO range_parted2 VALUES (85);
insert into parted_notnull_inh_test (b) values (null);
INSERT INTO t1 VALUES ('[(1,2),(3,4)]');
INSERT INTO t1 VALUES (' ( ( 1 , 2 ) , ( 3 , 4 ) ) ');
INSERT INTO t1 VALUES ('[ (0,0),(3,0),(4,5),(1,6) ]');
INSERT INTO t1 VALUES ('((1,2) ,(3,4 ))');
INSERT INTO t1 VALUES ('1,2 ,3,4 ');
INSERT INTO t1 VALUES (' [1,2,3, 4] ');
INSERT INTO t1 VALUES ('((10,20))');
INSERT INTO t1 VALUES ('[ 11,12,13,14 ]');
INSERT INTO t1 VALUES ('( 11,12,13,14) ');
INSERT INTO t1 VALUES ('[]');
INSERT INTO t1 VALUES ('[(,2),(3,4)]');
INSERT INTO t1 VALUES ('[(1,2),(3,4)');
INSERT INTO t1 VALUES ('(1,2,3,4');
INSERT INTO t1 VALUES ('(1,2),(3,4)]');
INSERT INTO bit_defaults DEFAULT VALUES;
INSERT INTO test_json VALUES
('scalar','"a scalar"'),
('array','["zero", "one","two",null,"four","five", [1,2,3],{"f1":9}]'),
('object','{"field1":"val1","field2":"val2","field3":null, "field4": 4, "field5": [1,2,3], "field6": {"f1":9}}');
INSERT INTO jspoptest
SELECT '{
    "jsa": [1, "2", null, 4],
    "rec": {"a": "abc", "c": "01.02.2003", "x": 43.2},
    "reca": [{"a": "abc", "b": 456}, null, {"c": "01.02.2003", "x": 43.2}]
}'::json
FROM generate_series(1, 3);
INSERT INTO foo VALUES (999999, NULL, 'bar');
INSERT INTO foo VALUES (847003,'sub-alpha','GESS90');
INSERT INTO r1 VALUES (10) ON CONFLICT (a) DO UPDATE SET a = 30 RETURNING *;
INSERT INTO r1 VALUES (10) ON CONFLICT ON CONSTRAINT r1_pkey DO UPDATE SET a = 30;
INSERT INTO r1 SELECT a + 1 FROM r2 RETURNING *; -- OK
INSERT INTO document VALUES (2, (SELECT cid from category WHERE cname = 'novel'), 1, 'carol', 'ovel')
    ON CONFLICT (did) DO UPDATE SET dtitle = EXCLUDED.dtitle, dauthor = EXCLUDED.dauthor;
WITH cte1 AS (INSERT INTO t1 VALUES (21, 'Fail') RETURNING *) SELECT * FROM cte1;
WITH cte1 AS (INSERT INTO t1 VALUES (20, 'Success') RETURNING *) SELECT * FROM cte1;
INSERT INTO combocidtest SELECT 1 LIMIT 0;
INSERT INTO trunc_stats_test DEFAULT VALUES;
INSERT INTO xmltest VALUES (5, '<menu><name>Molson</name><cost>free</cost></menu>'::xml);
INSERT INTO query VALUES ('/menu/beers/cost[text() = ''lots'']');
INSERT INTO xmltest2 VALUES('<d><r><ac>1</ac></r></d>', 'A');
INSERT INTO xmltest VALUES (5, '<menu><name>Molson</name><cost>free</cost></menu>'::xml);
INSERT INTO xmldata VALUES('<ROWS>
<ROW id="1">
  <COUNTRY_ID>SG</COUNTRY_ID>
  <COUNTRY_NAME>Singapore</COUNTRY_NAME>
  <REGION_ID>3</REGION_ID><SIZE unit="km">791</SIZE>
</ROW>
</ROWS>');
INSERT INTO INET_TBL (c, i) VALUES ('192.168.1', '192.168.1.226/24');
INSERT INTO INET_TBL (c, i) VALUES ('1234::1234::1234', '::1.2.3.4');
INSERT INTO INET_TBL (c, i) VALUES (cidr('ffff:ffff:ffff:ffff::/24'), '::192.168.1.226');
INSERT INTO INET_TBL (c, i) VALUES ('10', '10::/8');
INSERT INTO b SELECT 1 INTO f;
INSERT INTO itest1 (c1, c2) OVERRIDING USER VALUE VALUES (10, 'xyz');
INSERT INTO itest2 (c1, c2) OVERRIDING SYSTEM VALUE VALUES (10, 'xyz');
INSERT INTO VARCHAR_TBL (f1) VALUES ('cd');
INSERT INTO VARCHAR_TBL (f1) VALUES ('abcd    ');
INSERT INTO fewmore VALUES(generate_series(4,5));
INSERT INTO fewmore VALUES(1) RETURNING generate_series(1,3);
INSERT INTO foo (f2,f3) VALUES ('t', DEFAULT), ('M', 11), (upper('m'), 7+9) RETURNING *, f1+f3 AS sum;
INSERT INTO foo SELECT f1+10 FROM foo RETURNING *, f1+1 IN (SELECT q1 FROM it) AS sn, EXISTS(SELECT * FROM il) AS an;
INSERT INTO foo AS bar DEFAULT VALUES RETURNING bar.f3;
