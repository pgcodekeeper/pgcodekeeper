CREATE TABLE hobbies_r (
    name        text,
    person      text
);

CREATE TABLE equipment_r (
    name        text,
    hobby       text
);

CREATE TABLE onek (
    unique1     int4,
    unique2     int4,
    two         int4,
    four        int4,
    ten         int4,
    twenty      int4,
    hundred     int4,
    thousand    int4,
    twothousand int4,
    fivethous   int4,
    tenthous    int4,
    odd         int4,
    even        int4,
    stringu1    name,
    stringu2    name,
    string4     name
);

CREATE TABLE tenk1 (
    unique1     int4,
    unique2     int4,
    two         int4,
    four        int4,
    ten         int4,
    twenty      int4,
    hundred     int4,
    thousand    int4,
    twothousand int4,
    fivethous   int4,
    tenthous    int4,
    odd         int4,
    even        int4,
    stringu1    name,
    stringu2    name,
    string4     name
);

CREATE TABLE tenk2 (
    unique1     int4,
    unique2     int4,
    two         int4,
    four        int4,
    ten         int4,
    twenty      int4,
    hundred     int4,
    thousand    int4,
    twothousand int4,
    fivethous   int4,
    tenthous    int4,
    odd         int4,
    even        int4,
    stringu1    name,
    stringu2    name,
    string4     name
);


CREATE TABLE person (
    name        text,
    age         int4,
    location    point
);


CREATE TABLE emp (
    salary      int4,
    manager     name
) INHERITS (person);


CREATE TABLE student (
    gpa         float8
) INHERITS (person);


CREATE TABLE stud_emp (
    percent     int4
) INHERITS (emp, student);


CREATE TABLE city (
    name        name,
    location    box,
    budget      city_budget
);

CREATE TABLE dept (
    dname       name,
    mgrname     text
);

CREATE TABLE slow_emp4000 (
    home_base    box
);

CREATE TABLE fast_emp4000 (
    home_base    box
);

CREATE TABLE road (
    name        text,
    thepath     path
);

CREATE TABLE ihighway () INHERITS (road);

CREATE TABLE shighway (
    surface     text
) INHERITS (road);

CREATE TABLE real_city (
    pop         int4,
    cname       text,
    outline     path
);

--
-- test the "star" operators a bit more thoroughly -- this time,
-- throw in lots of NULL fields...
--
-- a is the type root
-- b and c inherit from a (one-level single inheritance)
-- d inherits from b and c (two-level multiple inheritance)
-- e inherits from c (two-level single inheritance)
-- f inherits from e (three-level single inheritance)
--
CREATE TABLE a_star (
    class       char,
    a           int4
);

CREATE TABLE b_star (
    b           text
) INHERITS (a_star);

CREATE TABLE c_star (
    c           name
) INHERITS (a_star);

CREATE TABLE d_star (
    d           float8
) INHERITS (b_star, c_star);

CREATE TABLE e_star (
    e           int2
) INHERITS (c_star);

CREATE TABLE f_star (
    f           polygon
) INHERITS (e_star);

CREATE TABLE aggtest (
    a           int2,
    b           float4
);

CREATE TABLE hash_i4_heap (
    seqno       int4,
    random      int4
);

CREATE TABLE hash_name_heap (
    seqno       int4,
    random      name
);

CREATE TABLE hash_txt_heap (
    seqno       int4,
    random      text
);

CREATE TABLE hash_f8_heap (
    seqno       int4,
    random      float8
);

-- don't include the hash_ovfl_heap stuff in the distribution
-- the data set is too large for what it's worth
--
-- CREATE TABLE hash_ovfl_heap (
--  x           int4,
--  y           int4
-- );

CREATE TABLE bt_i4_heap (
    seqno       int4,
    random      int4
);

CREATE TABLE bt_name_heap (
    seqno       name,
    random      int4
);

CREATE TABLE bt_txt_heap (
    seqno       text,
    random      int4
);

CREATE TABLE bt_f8_heap (
    seqno       float8,
    random      int4
);

CREATE TABLE array_op_test (
    seqno       int4,
    i           int4[],
    t           text[]
);

CREATE TABLE array_index_op_test (
    seqno       int4,
    i           int4[],
    t           text[]
);

CREATE TABLE testjsonb (
       j jsonb
);

CREATE TABLE unknowntab (
    u unknown    -- fail
);

CREATE TABLE IF NOT EXISTS test_tsvector(
    t text,
    a tsvector
);

CREATE TABLE IF NOT EXISTS test_tsvector(
    t text
);

-- invalid: non-lowercase quoted reloptions identifiers
CREATE TABLE tas_case WITH ("Fillfactor" = 10) AS SELECT 1 a;

CREATE UNLOGGED TABLE unlogged1 (a int primary key);            -- OK
CREATE TEMPORARY TABLE unlogged2 (a int primary key);           -- OK
INSERT INTO unlogged1 VALUES (42);
CREATE UNLOGGED TABLE public.unlogged2 (a int primary key);     -- also OK
CREATE UNLOGGED TABLE pg_temp.unlogged3 (a int primary key);    -- not OK
CREATE TABLE pg_temp.implicitly_temp (a int primary key);       -- OK
CREATE TEMP TABLE explicitly_temp (a int primary key);          -- also OK
CREATE TEMP TABLE pg_temp.doubly_temp (a int primary key);      -- also OK
CREATE TEMP TABLE public.temp_to_perm (a int primary key);      -- not OK

CREATE TABLE as_select1 AS SELECT * FROM pg_class WHERE relkind = 'r';
CREATE TABLE as_select1 AS SELECT * FROM pg_class WHERE relkind = 'r';
CREATE TABLE IF NOT EXISTS as_select1 AS SELECT * FROM pg_class WHERE relkind = 'r';

-- check that tables with oids cannot be created anymore
CREATE TABLE withoid() WITH OIDS;
CREATE TABLE withoid() WITH (oids);
CREATE TABLE withoid() WITH (oids = true);

-- but explicitly not adding oids is still supported
CREATE TEMP TABLE withoutoid() WITHOUT OIDS;
CREATE TEMP TABLE withoutoid() WITH (oids = false);

--
-- Partitioned tables
--

-- cannot combine INHERITS and PARTITION BY (although grammar allows)
CREATE TABLE partitioned (
    a int
) INHERITS (some_table) PARTITION BY LIST (a);

-- cannot use more than 1 column as partition key for list partitioned table
CREATE TABLE partitioned (
    a1 int,
    a2 int
) PARTITION BY LIST (a1, a2);   -- fail

-- unsupported constraint type for partitioned tables
CREATE TABLE partitioned (
    a int,
    EXCLUDE USING gist (a WITH &&)
) PARTITION BY RANGE (a);

-- prevent using prohibited expressions in the key
CREATE TABLE partitioned (
    a int
) PARTITION BY RANGE (retset(a));

CREATE TABLE partitioned (
    a int
) PARTITION BY RANGE ((avg(a)));

CREATE TABLE partitioned (
    a int,
    b int
) PARTITION BY RANGE ((avg(a) OVER (PARTITION BY b)));

CREATE TABLE partitioned (
    a int
) PARTITION BY LIST ((a LIKE (SELECT 1)));

CREATE TABLE partitioned (
    a int
) PARTITION BY RANGE (('a'));

-- specified column must be present in the table
CREATE TABLE partitioned (
    a int
) PARTITION BY RANGE (b);

-- cannot use system columns in partition key
CREATE TABLE partitioned (
    a int
) PARTITION BY RANGE (xmin);

-- functions in key must be immutable
CREATE FUNCTION immut_func (a int) RETURNS int AS $$ SELECT a + random()::int; $$ LANGUAGE SQL;

-- cannot contain whole-row references
CREATE TABLE partitioned (
    a   int
) PARTITION BY RANGE ((partitioned));

-- prevent using columns of unsupported types in key (type must have a btree operator class)
CREATE TABLE partitioned (
    a point
) PARTITION BY LIST (a);
CREATE TABLE partitioned (
    a point
) PARTITION BY LIST (a point_ops);
CREATE TABLE partitioned (
    a point
) PARTITION BY RANGE (a);
CREATE TABLE partitioned (
    a point
) PARTITION BY RANGE (a point_ops);

-- cannot add NO INHERIT constraints to partitioned tables
CREATE TABLE partitioned (
    a int,
    CONSTRAINT check_a CHECK (a > 0) NO INHERIT
) PARTITION BY RANGE (a);

CREATE TABLE partitioned (
    a int,
    b int,
    c text,
    d text
) PARTITION BY RANGE (a oid_ops, plusone(b), c collate "default", d collate "C");

-- partitioned table cannot participate in regular inheritance
CREATE TABLE partitioned2 (
    a int,
    b text
) PARTITION BY RANGE ((a+1), substr(b, 1, 5));
CREATE TABLE fail () INHERITS (partitioned2);

CREATE TABLE part2_1 PARTITION OF partitioned2 FOR VALUES FROM (-1, 'aaaaa') TO (100, 'ccccc');
--
-- Partitions
--

-- check partition bound syntax

CREATE TABLE list_parted (
    a int
) PARTITION BY LIST (a);
CREATE TABLE part_p1 PARTITION OF list_parted FOR VALUES IN ('1');
CREATE TABLE part_p2 PARTITION OF list_parted FOR VALUES IN (2);
CREATE TABLE part_p3 PARTITION OF list_parted FOR VALUES IN ((2+1));
CREATE TABLE part_null PARTITION OF list_parted FOR VALUES IN (null);


-- forbidden expressions for partition bound
CREATE TABLE part_bogus_expr_fail PARTITION OF list_parted FOR VALUES IN (somename);
CREATE TABLE part_bogus_expr_fail PARTITION OF list_parted FOR VALUES IN (a);
CREATE TABLE part_bogus_expr_fail PARTITION OF list_parted FOR VALUES IN (sum(a));
CREATE TABLE part_bogus_expr_fail PARTITION OF list_parted FOR VALUES IN ((select 1));
CREATE TABLE part_bogus_expr_fail PARTITION OF list_parted FOR VALUES IN (generate_series(4, 6));

-- trying to specify range for list partitioned table
CREATE TABLE fail_part PARTITION OF list_parted FOR VALUES FROM (1) TO (2);
-- trying to specify modulus and remainder for list partitioned table
CREATE TABLE fail_part PARTITION OF list_parted FOR VALUES WITH (MODULUS 10, REMAINDER 1);

-- check default partition cannot be created more than once
CREATE TABLE part_default PARTITION OF list_parted DEFAULT;
CREATE TABLE fail_default_part PARTITION OF list_parted DEFAULT;

-- specified literal can't be cast to the partition column data type
CREATE TABLE bools (
    a bool
) PARTITION BY LIST (a);
CREATE TABLE bools_true PARTITION OF bools FOR VALUES IN (1);

-- specified literal can be cast, and the cast might not be immutable
CREATE TABLE moneyp (
    a money
) PARTITION BY LIST (a);
CREATE TABLE moneyp_10 PARTITION OF moneyp FOR VALUES IN (10);
CREATE TABLE moneyp_11 PARTITION OF moneyp FOR VALUES IN ('11');
CREATE TABLE moneyp_12 PARTITION OF moneyp FOR VALUES IN (to_char(12, '99')::int);

-- cast is immutable
CREATE TABLE bigintp (
    a bigint
) PARTITION BY LIST (a);
CREATE TABLE bigintp_10 PARTITION OF bigintp FOR VALUES IN (10);
-- fails due to overlap:
CREATE TABLE bigintp_10_2 PARTITION OF bigintp FOR VALUES IN ('10');

CREATE TABLE range_parted (
    a date
) PARTITION BY RANGE (a);

-- trying to specify list for range partitioned table
CREATE TABLE fail_part PARTITION OF range_parted FOR VALUES IN ('a');
-- trying to specify modulus and remainder for range partitioned table
CREATE TABLE fail_part PARTITION OF range_parted FOR VALUES WITH (MODULUS 10, REMAINDER 1);
-- each of start and end bounds must have same number of values as the
-- length of the partition key
CREATE TABLE fail_part PARTITION OF range_parted FOR VALUES FROM ('a', 1) TO ('z');
CREATE TABLE fail_part PARTITION OF range_parted FOR VALUES FROM ('a') TO ('z', 1);

-- cannot specify null values in range bounds
CREATE TABLE fail_part PARTITION OF range_parted FOR VALUES FROM (null) TO (maxvalue);

-- trying to specify modulus and remainder for range partitioned table
CREATE TABLE fail_part PARTITION OF range_parted FOR VALUES WITH (MODULUS 10, REMAINDER 1);

-- check partition bound syntax for the hash partition
CREATE TABLE hash_parted (
    a int
) PARTITION BY HASH (a);
CREATE TABLE hpart_1 PARTITION OF hash_parted FOR VALUES WITH (MODULUS 10, REMAINDER 0);
CREATE TABLE hpart_2 PARTITION OF hash_parted FOR VALUES WITH (MODULUS 50, REMAINDER 1);
CREATE TABLE hpart_3 PARTITION OF hash_parted FOR VALUES WITH (MODULUS 200, REMAINDER 2);
-- modulus 25 is factor of modulus of 50 but 10 is not factor of 25.
CREATE TABLE fail_part PARTITION OF hash_parted FOR VALUES WITH (MODULUS 25, REMAINDER 3);
-- previous modulus 50 is factor of 150 but this modulus is not factor of next modulus 200.
CREATE TABLE fail_part PARTITION OF hash_parted FOR VALUES WITH (MODULUS 150, REMAINDER 3);
-- trying to specify range for the hash partitioned table
CREATE TABLE fail_part PARTITION OF hash_parted FOR VALUES FROM ('a', 1) TO ('z');
-- trying to specify list value for the hash partitioned table
CREATE TABLE fail_part PARTITION OF hash_parted FOR VALUES IN (1000);

-- trying to create default partition for the hash partitioned table
CREATE TABLE fail_default_part PARTITION OF hash_parted DEFAULT;

-- check if compatible with the specified parent

-- cannot create as partition of a non-partitioned table
CREATE TABLE unparted (
    a int
);
CREATE TABLE fail_part PARTITION OF unparted FOR VALUES IN ('a');
CREATE TABLE fail_part PARTITION OF unparted FOR VALUES WITH (MODULUS 2, REMAINDER 1);

-- cannot create a permanent rel as partition of a temp rel
CREATE TEMP TABLE temp_parted (
    a int
) PARTITION BY LIST (a);
CREATE TABLE fail_part PARTITION OF temp_parted FOR VALUES IN ('a');

-- check for partition bound overlap and other invalid specifications

CREATE TABLE list_parted2 (
    a varchar
) PARTITION BY LIST (a);
CREATE TABLE part_null_z PARTITION OF list_parted2 FOR VALUES IN (null, 'z');
CREATE TABLE part_ab PARTITION OF list_parted2 FOR VALUES IN ('a', 'b');
CREATE TABLE list_parted2_def PARTITION OF list_parted2 DEFAULT;

CREATE TABLE fail_part PARTITION OF list_parted2 FOR VALUES IN (null);
CREATE TABLE fail_part PARTITION OF list_parted2 FOR VALUES IN ('b', 'c');
-- check default partition overlap
INSERT INTO list_parted2 VALUES('X');
CREATE TABLE fail_part PARTITION OF list_parted2 FOR VALUES IN ('W', 'X', 'Y');

CREATE TABLE range_parted2 (
    a int
) PARTITION BY RANGE (a);

-- trying to create range partition with empty range
CREATE TABLE fail_part PARTITION OF range_parted2 FOR VALUES FROM (1) TO (0);
-- note that the range '[1, 1)' has no elements
CREATE TABLE fail_part PARTITION OF range_parted2 FOR VALUES FROM (1) TO (1);

CREATE TABLE part0 PARTITION OF range_parted2 FOR VALUES FROM (minvalue) TO (1);
CREATE TABLE fail_part PARTITION OF range_parted2 FOR VALUES FROM (minvalue) TO (2);
CREATE TABLE part1 PARTITION OF range_parted2 FOR VALUES FROM (1) TO (10);
CREATE TABLE fail_part PARTITION OF range_parted2 FOR VALUES FROM (9) TO (maxvalue);
CREATE TABLE part2 PARTITION OF range_parted2 FOR VALUES FROM (20) TO (30);
CREATE TABLE part3 PARTITION OF range_parted2 FOR VALUES FROM (30) TO (40);
CREATE TABLE fail_part PARTITION OF range_parted2 FOR VALUES FROM (10) TO (30);
CREATE TABLE fail_part PARTITION OF range_parted2 FOR VALUES FROM (10) TO (50);

-- Create a default partition for range partitioned table
CREATE TABLE range2_default PARTITION OF range_parted2 DEFAULT;

-- More than one default partition is not allowed, so this should give error
CREATE TABLE fail_default_part PARTITION OF range_parted2 DEFAULT;

-- Check if the range for default partitions overlap
CREATE TABLE fail_part PARTITION OF range_parted2 FOR VALUES FROM (80) TO (90);
CREATE TABLE part4 PARTITION OF range_parted2 FOR VALUES FROM (90) TO (100);

-- now check for multi-column range partition key
CREATE TABLE range_parted3 (
    a int,
    b int
) PARTITION BY RANGE (a, (b+1));

CREATE TABLE part00 PARTITION OF range_parted3 FOR VALUES FROM (0, minvalue) TO (0, maxvalue);
CREATE TABLE fail_part PARTITION OF range_parted3 FOR VALUES FROM (0, minvalue) TO (0, 1);

CREATE TABLE part10 PARTITION OF range_parted3 FOR VALUES FROM (1, minvalue) TO (1, 1);
CREATE TABLE part11 PARTITION OF range_parted3 FOR VALUES FROM (1, 1) TO (1, 10);
CREATE TABLE part12 PARTITION OF range_parted3 FOR VALUES FROM (1, 10) TO (1, maxvalue);
CREATE TABLE fail_part PARTITION OF range_parted3 FOR VALUES FROM (1, 10) TO (1, 20);
CREATE TABLE range3_default PARTITION OF range_parted3 DEFAULT;

-- cannot create a partition that says column b is allowed to range
-- from -infinity to +infinity, while there exist partitions that have
-- more specific ranges
CREATE TABLE fail_part PARTITION OF range_parted3 FOR VALUES FROM (1, minvalue) TO (1, maxvalue);

-- check for partition bound overlap and other invalid specifications for the hash partition
CREATE TABLE hash_parted2 (
    a varchar
) PARTITION BY HASH (a);
CREATE TABLE h2part_1 PARTITION OF hash_parted2 FOR VALUES WITH (MODULUS 4, REMAINDER 2);
CREATE TABLE h2part_2 PARTITION OF hash_parted2 FOR VALUES WITH (MODULUS 8, REMAINDER 0);
CREATE TABLE h2part_3 PARTITION OF hash_parted2 FOR VALUES WITH (MODULUS 8, REMAINDER 4);
CREATE TABLE h2part_4 PARTITION OF hash_parted2 FOR VALUES WITH (MODULUS 8, REMAINDER 5);
-- overlap with part_4
CREATE TABLE fail_part PARTITION OF hash_parted2 FOR VALUES WITH (MODULUS 2, REMAINDER 1);
-- modulus must be greater than zero
CREATE TABLE fail_part PARTITION OF hash_parted2 FOR VALUES WITH (MODULUS 0, REMAINDER 1);
-- remainder must be greater than or equal to zero and less than modulus
CREATE TABLE fail_part PARTITION OF hash_parted2 FOR VALUES WITH (MODULUS 8, REMAINDER 8);

-- check schema propagation from parent

CREATE TABLE parted (
    a text,
    b int NOT NULL DEFAULT 0,
    CONSTRAINT check_a CHECK (length(a) > 0)
) PARTITION BY LIST (a);

CREATE TABLE part_a PARTITION OF parted FOR VALUES IN ('a');

-- able to specify column default, column constraint, and table constraint

-- first check the "column specified more than once" error
CREATE TABLE part_b PARTITION OF parted (
    b NOT NULL,
    b DEFAULT 1,
    b CHECK (b >= 0),
    CONSTRAINT check_a CHECK (length(a) > 0)
) FOR VALUES IN ('b');

CREATE TABLE part_b PARTITION OF parted (
    b NOT NULL DEFAULT 1,
    CONSTRAINT check_a CHECK (length(a) > 0),
    CONSTRAINT check_b CHECK (b >= 0)
) FOR VALUES IN ('b');

-- specify PARTITION BY for a partition
CREATE TABLE fail_part_col_not_found PARTITION OF parted FOR VALUES IN ('c') PARTITION BY RANGE (c);
CREATE TABLE part_c PARTITION OF parted (b WITH OPTIONS NOT NULL DEFAULT 0) FOR VALUES IN ('c') PARTITION BY RANGE ((b));

-- create a level-2 partition
CREATE TABLE part_c_1_10 PARTITION OF part_c FOR VALUES FROM (1) TO (10);

-- check that NOT NULL and default value are inherited correctly
create table parted_notnull_inh_test (a int default 1, b int not null default 0) partition by list (a);
create table parted_notnull_inh_test1 partition of parted_notnull_inh_test (a not null, b default 1) for values in (1);
-- note that while b's default is overriden, a's default is preserved

-- check for a conflicting COLLATE clause
create table parted_collate_must_match (a text collate "C", b text collate "C")
  partition by range (a);
-- on the partition key
create table parted_collate_must_match1 partition of parted_collate_must_match
  (a /*collate "POSIX"*/) for values from ('a') to ('m');
-- on another column
create table parted_collate_must_match2 partition of parted_collate_must_match
  (b /*collate "POSIX"*/) for values from ('m') to ('z');

-- check that specifying incompatible collations for partition bound
-- expressions fails promptly

create table test_part_coll_posix (a text) partition by range (a collate "POSIX");
-- fail
create table test_part_coll partition of test_part_coll_posix for values from ('a' collate "C") to ('g');
-- ok
create table test_part_coll partition of test_part_coll_posix for values from ('a' collate "POSIX") to ('g');
-- ok
create table test_part_coll2 partition of test_part_coll_posix for values from ('g') to ('m');

-- using a cast expression uses the target type's default collation

-- fail
create table test_part_coll_cast partition of test_part_coll_posix for values from (name 'm' collate "C") to ('s');
-- ok
create table test_part_coll_cast partition of test_part_coll_posix for values from (name 'm' collate "POSIX") to ('s');
-- ok; partition collation silently overrides the default collation of type 'name'
create table test_part_coll_cast2 partition of test_part_coll_posix for values from (name 's') to ('z');

-- Partition bound in describe output


-- Both partition bound and partition key in describe output


-- a level-2 partition's constraint will include the parent's expressions


-- Show partition count in the parent's describe output
-- Tempted to include \d+ output listing partitions with bound info but
-- output could vary depending on the order in which partition oids are
-- returned.



-- check that we get the expected partition constraints
CREATE TABLE range_parted4 (a int, b int, c int) PARTITION BY RANGE (abs(a), abs(b), c);
CREATE TABLE unbounded_range_part PARTITION OF range_parted4 FOR VALUES FROM (MINVALUE, MINVALUE, MINVALUE) TO (MAXVALUE, MAXVALUE, MAXVALUE);

CREATE TABLE range_parted4_1 PARTITION OF range_parted4 FOR VALUES FROM (MINVALUE, MINVALUE, MINVALUE) TO (1, MAXVALUE, MAXVALUE);

CREATE TABLE range_parted4_2 PARTITION OF range_parted4 FOR VALUES FROM (3, 4, 5) TO (6, 7, MAXVALUE);

CREATE TABLE range_parted4_3 PARTITION OF range_parted4 FOR VALUES FROM (6, 8, MINVALUE) TO (9, MAXVALUE, MAXVALUE);

CREATE TABLE partkey_t (a int4) PARTITION BY RANGE (a test_int4_ops);
CREATE TABLE partkey_t_1 PARTITION OF partkey_t FOR VALUES FROM (0) TO (1000);
INSERT INTO partkey_t VALUES (100);
INSERT INTO partkey_t VALUES (200);

-- comments on partitioned tables columns
CREATE TABLE parted_col_comment (a int, b text) PARTITION BY LIST (a);
COMMENT ON TABLE parted_col_comment IS 'Am partitioned table';
COMMENT ON COLUMN parted_col_comment.a IS 'Partition key';
SELECT obj_description('parted_col_comment'::regclass);

-- list partitioning on array type column
CREATE TABLE arrlp (a int[]) PARTITION BY LIST (a);
CREATE TABLE arrlp12 PARTITION OF arrlp FOR VALUES IN ('{1}', '{2}');

-- partition on boolean column
create table boolspart (a bool) partition by list (a);
create table boolspart_t partition of boolspart for values in (true);
create table boolspart_f partition of boolspart for values in (false);

-- partitions mixing temporary and permanent relations
create table perm_parted (a int) partition by list (a);
create temporary table temp_parted (a int) partition by list (a);
create table perm_part partition of temp_parted default; -- error
create temp table temp_part partition of perm_parted default; -- error
create temp table temp_part partition of temp_parted default; -- ok
create table tab_part_create (a int) partition by list (a);

-- test using a volatile expression as partition bound
create table volatile_partbound_test (partkey timestamp) partition by range (partkey);
create table volatile_partbound_test1 partition of volatile_partbound_test for values from (minvalue) to (current_timestamp);
create table volatile_partbound_test2 partition of volatile_partbound_test for values from (current_timestamp) to (maxvalue);
-- this should go into the partition volatile_partbound_test2
insert into volatile_partbound_test values (current_timestamp);
select tableoid::regclass from volatile_partbound_test;

CREATE TABLE BIT_TABLE(b BIT(11));
CREATE TABLE VARBIT_TABLE(v BIT VARYING(11));
CREATE TABLE bit_defaults(
  b1 bit(4) DEFAULT '1001',
  b2 bit(4) DEFAULT B'0101',
  b3 bit varying(5) DEFAULT '1001',
  b4 bit varying(5) DEFAULT B'0101'
);

CREATE TEMP TABLE foo (f1 int);
CREATE TABLE t1 (f1 path);
CREATE TEMP TABLE rows AS SELECT x, 'txt' || x as y FROM generate_series(1,3) AS x;
create temp table t1 (a int, b int, c int, d int, primary key (a, b));
create temp table t2 (x int, y int, z int, primary key (x, y));
create temp table t3 (a int, b int, c int, primary key(a, b) deferrable);
CREATE TABLE r2 (a int REFERENCES r1 ON UPDATE CASCADE);
CREATE TABLE macaddr_data (a int, b macaddr);
CREATE TABLE macaddr8_data (a int, b macaddr8);
CREATE TABLE brintest (byteacol bytea,
    charcol "char",
    namecol name,
    int8col bigint,
    int2col smallint,
    int4col integer,
    textcol text,
    oidcol oid,
    tidcol tid,
    float4col real,
    float8col double precision,
    macaddrcol macaddr,
    inetcol inet,
    cidrcol cidr,
    bpcharcol character,
    datecol date,
    timecol time without time zone,
    timestampcol timestamp without time zone,
    timestamptzcol timestamp with time zone,
    intervalcol interval,
    timetzcol time with time zone,
    bitcol bit(10),
    varbitcol bit varying(16),
    numericcol numeric,
    uuidcol uuid,
    int4rangecol int4range,
    lsncol pg_lsn,
    boxcol box
) WITH (fillfactor=10);
CREATE TABLE CIRCLE_TBL (f1 circle);
CREATE TABLE guid1(guid_field UUID, text_field TEXT DEFAULT(now()));
CREATE FOREIGN TABLE tststats.f (a int, b int, c text) SERVER extstats_dummy_srv;
CREATE TABLE tststats.pt (a int, b int, c text) PARTITION BY RANGE (a, b);
CREATE TABLE tststats.pt1 PARTITION OF tststats.pt FOR VALUES FROM (-10, -10) TO (10, 10);
create table part_pa_test(a int, b int) partition by range(a);
create table part_pa_test_p1 partition of part_pa_test for values from (minvalue) to (0);
create table part_pa_test_p2 partition of part_pa_test for values from (0) to (maxvalue);
CREATE TABLE xmltest2(x xml, _path text);
CREATE TABLE testxmlschema.test3
    AS SELECT true c1, true::testboolxmldomain c2, '2013-02-21'::date c3, '2013-02-21'::testdatexmldomain c4;
CREATE TABLE ttable1 OF nothing;
CREATE TYPE person_type AS (id int, name text);
CREATE TABLE persons OF person_type;
CREATE TABLE IF NOT EXISTS persons OF person_type;
CREATE TYPE person_type AS (id int, name text);
CREATE TABLE personsx OF person_type (myname WITH OPTIONS NOT NULL);
CREATE TABLE persons2 OF person_type (
    id WITH OPTIONS PRIMARY KEY,
    UNIQUE (name)
);
CREATE TABLE persons3 OF person_type (
    PRIMARY KEY (id),
    name WITH OPTIONS DEFAULT ''
);
CREATE TABLE persons4 OF person_type (
    name WITH OPTIONS NOT NULL,
    name WITH OPTIONS DEFAULT ''
);
CREATE TABLE persons2 OF person_type (
    id WITH OPTIONS PRIMARY KEY,
    UNIQUE (name)
);
CREATE TABLE persons3 OF person_type (
    PRIMARY KEY (id),
    name NOT NULL DEFAULT ''
);
create table parted_sample (a int) partition by list (a);
create table parted_sample_1 partition of parted_sample for values in (1);
create table parted_sample_2 partition of parted_sample for values in (2);
CREATE TABLE INET_TBL (c cidr, i inet);
CREATE TABLE mchash (a int, b text, c jsonb) PARTITION BY HASH (a part_test_int4_ops, b part_test_text_ops);
CREATE TABLE mchash1 PARTITION OF mchash FOR VALUES WITH (MODULUS 4, REMAINDER 0);
CREATE TABLE mcinthash (a int, b int, c jsonb) PARTITION BY HASH (a part_test_int4_ops, b part_test_int4_ops);
CREATE TABLE ptif_test (a int, b int) PARTITION BY range (a);
CREATE TABLE ptif_test0 PARTITION OF ptif_test FOR VALUES FROM (minvalue) TO (0) PARTITION BY list (b);
CREATE TABLE ptif_test01 PARTITION OF ptif_test0 FOR VALUES IN (1);
CREATE TABLE ptif_test1 PARTITION OF ptif_test FOR VALUES FROM (0) TO (100) PARTITION BY list (b);
CREATE TABLE ptif_test11 PARTITION OF ptif_test1 FOR VALUES IN (1);
CREATE TABLE ptif_test2 PARTITION OF ptif_test FOR VALUES FROM (100) TO (maxvalue);
CREATE TABLE PG_LSN_TBL (f1 pg_lsn);
create table gin_test_tbl(i int4[]) with (autovacuum_enabled = off);
create table gist_tbl (b box, p point, c circle);
create table list_parted_tbl (a int,b int) partition by list (a);
create table list_parted_tbl1 partition of list_parted_tbl for values in (1) partition by list(b);
create table inserttest (f1 int, f2 int[], f3 insert_test_type, f4 insert_test_type[]);
create table range_parted (a text, b int) partition by range (a, (b+0));
create table part1 partition of range_parted for values from ('a', 1) to ('a', 10);
create table part2 partition of range_parted for values from ('a', 10) to ('a', 20);
create table part3 partition of range_parted for values from ('b', 1) to ('b', 10);
create table part4 partition of range_parted for values from ('b', 10) to ('b', 20);
create table list_parted (a text, b int) partition by list (lower(a));
create table part_aa_bb partition of list_parted FOR VALUES IN ('aa', 'bb');
create table part_cc_dd partition of list_parted FOR VALUES IN ('cc', 'dd');
create table part_null partition of list_parted FOR VALUES IN (null);
create table part_ee_ff partition of list_parted for values in ('ee', 'ff') partition by range (b);
create table part_ee_ff1 partition of part_ee_ff for values from (1) to (10);
create table part_ee_ff2 partition of part_ee_ff for values from (10) to (20);
create table part_default partition of list_parted default;
create table part_xx_yy partition of list_parted for values in ('xx', 'yy') partition by list (a);
create table part_xx_yy_p1 partition of part_xx_yy for values in ('xx');
create table part_xx_yy_defpart partition of part_xx_yy default;
create table part_default partition of list_parted default partition by range(b);
create table part_default_p2 partition of part_default for values from (30) to (40);
create table part_def partition of range_parted default;
create table part_gg partition of list_parted for values in ('gg') partition by range (b);
create table part_gg1 partition of part_gg for values from (minvalue) to (1);
create table part_gg2 partition of part_gg for values from (1) to (10) partition by range (b);
create table part_gg2_2 partition of part_gg2 for values from (5) to (10);
create table part_ee_ff3 partition of part_ee_ff for values from (20) to (30) partition by range (b);
create table part_ee_ff3_2 partition of part_ee_ff3 for values from (25) to (30);
create table hash_parted (a int) partition by hash (a part_test_int4_ops);
create table hpart0 partition of hash_parted for values with (modulus 4, remainder 0);
create table hpart1 partition of hash_parted for values with (modulus 4, remainder 1);
create table hpart2 partition of hash_parted for values with (modulus 4, remainder 2);
create table hpart3 partition of hash_parted for values with (modulus 4, remainder 3);
create table list_parted (a int) partition by list (a);
create table part_default partition of list_parted default;
create table donothingbrtrig_test (a int, b text) partition by list (a);
create table donothingbrtrig_test1 (b text, a int);
create table donothingbrtrig_test2 (c text, b text, a int);
create table mcrparted (a text, b int) partition by range(a, b);
create table mcrparted1_lt_b partition of mcrparted for values from (minvalue, minvalue) to ('b', minvalue);
create table mcrparted2_b partition of mcrparted for values from ('b', minvalue) to ('c', minvalue);
create table mcrparted3_c_to_common partition of mcrparted for values from ('c', minvalue) to ('common', minvalue);
create table mcrparted4_common_lt_0 partition of mcrparted for values from ('common', minvalue) to ('common', 0);
create table mcrparted5_common_0_to_10 partition of mcrparted for values from ('common', 0) to ('common', 10);
create table mcrparted6_common_ge_10 partition of mcrparted for values from ('common', 10) to ('common', maxvalue);
create table mcrparted7_gt_common_lt_d partition of mcrparted for values from ('common', maxvalue) to ('d', minvalue);
create table mcrparted8_ge_d partition of mcrparted for values from ('d', minvalue) to (maxvalue, maxvalue);
create table key_desc (a int, b int) partition by list ((a+0));
create table key_desc_1 partition of key_desc for values in (1) partition by range (b);
create table mcrparted (a int, b int, c int) partition by range (a, abs(b), c);
create table mcrparted0 partition of mcrparted for values from (minvalue, 0, 0) to (1, maxvalue, maxvalue);
create table mcrparted2 partition of mcrparted for values from (10, 6, minvalue) to (10, maxvalue, minvalue);
create table mcrparted4 partition of mcrparted for values from (21, minvalue, 0) to (30, 20, minvalue);
create table mcrparted0 partition of mcrparted for values from (minvalue, minvalue, minvalue) to (1, maxvalue, maxvalue);
create table mcrparted1 partition of mcrparted for values from (2, 1, minvalue) to (10, 5, 10);
create table mcrparted2 partition of mcrparted for values from (10, 6, minvalue) to (10, maxvalue, maxvalue);
create table mcrparted3 partition of mcrparted for values from (11, 1, 1) to (20, 10, 10);
create table mcrparted4 partition of mcrparted for values from (21, minvalue, minvalue) to (30, 20, maxvalue);
create table mcrparted5 partition of mcrparted for values from (30, 21, 20) to (maxvalue, maxvalue, maxvalue);
CREATE TABLE itest1 (a int generated by default as identity, b text);
CREATE TABLE itest2 (a bigint generated always as identity, b text);
CREATE TABLE itest3 (a smallint generated by default as identity (start with 7 increment by 5), b text);
CREATE TABLE itest7 (a int GENERATED ALWAYS AS IDENTITY);
CREATE TABLE itest7a (b text) INHERITS (itest7);
CREATE TABLE itest7c (a int GENERATED ALWAYS AS IDENTITY) INHERITS (itest7b);
CREATE TABLE itest_err_1 (a text generated by default as identity); -- invalid column type
CREATE TABLE itest_err_2 (a int generated always as identity generated by default as identity); -- duplicate identity
CREATE TABLE itest_err_3 (a int default 5 generated by default as identity); -- cannot have default and identity
CREATE TABLE itest_err_4 (a serial generated by default as identity);-- cannot combine serial and identity
CREATE TABLE itest9 (a int GENERATED ALWAYS AS IDENTITY, b text, c bigint);
CREATE TABLE VARCHAR_TBL(f1 varchar(1));
CREATE TEMP TABLE temptest(col int) ON COMMIT DELETE ROWS;
CREATE TEMP TABLE temptest(col int) ON COMMIT DROP;
create temp table temp_parted_oncommit (a int) partition by list (a) on commit delete rows;

CREATE TABLE cmdata(f1 text COMPRESSION pglz);
CREATE TABLE cmpart2(f1 text COMPRESSION lz4);
CREATE TABLE cmdata3 (f1 TEXT COMPRESSION pglz, f2 TEXT COMPRESSION lz4);
CREATE TABLE cmdata4 (f1 TEXT COMPRESSION DEFAULT);

-- for Greenplum:
CREATE TABLE baby.rank (id int, rank int, year smallint, gender char(1), count int) DISTRIBUTED BY (rank, gender, year);
CREATE TABLE table_1 
(MY_ID integer, MY_INT integer, MY_DATE date, MY_TEXT varchar(40))
distributed replicated;

CREATE TABLE table_2
(MY_ID integer, MY_INT integer, MY_DATE date, MY_TEXT varchar(40))
distributed randomly;

CREATE TEMPORARY TABLE tmp_t1 AS
    SELECT id, col1
FROM public.t1
WHERE col1 != null
DISTRIBUTED RANDOMLY;

CREATE TABLE baby.rank2 
(id int, rank int, year smallint, gender char(1), count int)
DISTRIBUTED BY (rank, gender public.gist__int_ops, year);

CREATE TABLE table_1 (MY_ID integer, MY_INT integer, MY_DATE date, MY_TEXT varchar(40)) distributed replicated;
CREATE TABLE table_2 (MY_ID integer, MY_INT integer, MY_DATE date, MY_TEXT varchar(40)) distributed randomly;
CREATE TABLE baby.rank2 (id int, rank int, year smallint,
gender char(1), count int) DISTRIBUTED BY (rank, gender public.gist__int_ops, year);

CREATE TABLE public.test_table_elm2(
col1 text ENCODING (COMPRESSTYPE=zlib),
col2 text ENCODING (COMPRESSTYPE=none, COMPRESSLEVEL=1),
col3 text ENCODING (BLOCKSIZE=32768),
col4 text ENCODING (COMPRESSTYPE=none, COMPRESSLEVEL=1, BLOCKSIZE=32768)
)
WITH (appendonly='true',orientation='column');

CREATE FOREIGN TABLE public.films (
    code character(5) NOT NULL,
    title character varying(40) NOT NULL,
    did integer NOT NULL,
    date_prod date,
    kind character varying(10),
    len interval hour to minute
)
SERVER foreign_server
OPTIONS (
    mpp_execute 'all segments'
);

--PARTITION TABLE
create table region
(
    r_regionkey integer not null,
    r_name char(25),
    r_comment varchar(152)
)
distributed by (r_regionkey)
partition by range (r_regionkey)
subpartition by list (r_name)
 subpartition template
(
    subpartition africa values ('AFRICA'),
    subpartition america values ('AMERICA'),
    subpartition asia values ('ASIA'),
    subpartition europe values ('EUROPE'),
    subpartition mideast values ('MIDDLE EAST'),
    subpartition australia values ('AUSTRALIA'),
    subpartition antarctica values ('ANTARCTICA')
)
(
    partition region1 start (0),
    partition region2 start (3),
    partition region3 start (5) end (8)
);


-- more than one level partitioning table
CREATE TABLE two_level_pt(a int, b int, c int)
DISTRIBUTED BY (a)
PARTITION BY RANGE (b)
      SUBPARTITION BY RANGE (c)
      SUBPARTITION TEMPLATE (
      START (11) END (12) EVERY (1))
      ( START (1) END (2) EVERY (1));
 
 
Create table sto_ao_ao
 (col1 bigint, col2 date, col3 text, col4 int) with(appendonly=true)
 distributed randomly 
 partition by range(col2)
        subpartition by list (col3)
        subpartition template 
        (default subpartition subothers, 
        subpartition sub1 values ('one'),
        subpartition sub2 values ('two'))        
        (default partition others,
        start(date '2008-01-01') 
        end(date '2008-04-30')
        every(interval '1 month'));
        
CREATE TABLE public.t1 (
created_at timestamp NOT NULL,
customer_id int4 NULL,
response_v4 text NULL
)
WITH (
appendonly=true,
orientation=row,
compresstype=rle_type,
compresslevel=5
)
TABLESPACE pgdata2

DISTRIBUTED BY (id)
PARTITION BY RANGE(created_at)
(
START ('2022-04-01 00:00:00'::timestamp without time zone) END ('2025-02-01 00:00:00'::timestamp without time zone) EVERY ('1 mon'::interval) WITH (appendonly='true', orientation='column', compresstype=rle_type, compresslevel='5') TABLESPACE pgdata2
COLUMN created_at ENCODING (compresstype=rle_type, compresslevel=5, blocksize=32768)
COLUMN customer_id ENCODING (compresstype=rle_type, compresslevel=5, blocksize=32768)
COLUMN response_v4 ENCODING (compresstype=rle_type, compresslevel=5, blocksize=32768)
);

CREATE TABLE public.rank1 (
    id integer,
    rank integer,
    year date,
    gender character(1)
)
DISTRIBUTED BY (id, gender, year)
PARTITION BY LIST(gender)
          SUBPARTITION BY RANGE(year)
                  SUBPARTITION BY RANGE(rank) 
          (
          PARTITION boys VALUES('M')
                  (
                  START ('2001-01-01'::date) END ('2002-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2002-01-01'::date) END ('2003-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2003-01-01'::date) END ('2004-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2004-01-01'::date) END ('2005-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2005-01-01'::date)
                          (
                          START (1)
                          )
                  ), 
          PARTITION girls VALUES('F')
                  (
                  START ('2001-01-01'::date) END ('2002-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2002-01-01'::date) END ('2003-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2003-01-01'::date) END ('2004-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2004-01-01'::date) END ('2005-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2005-01-01'::date)
                          (
                          START (1)
                          )
                  )
          );

ALTER TABLE public.rank1
ALTER PARTITION boys 
SET SUBPARTITION TEMPLATE 
          (
START (1)
          );

ALTER TABLE public.rank1
SET SUBPARTITION TEMPLATE 
          (
          START ('2001-01-01'::date) END ('2002-01-01'::date) , 
          START ('2002-01-01'::date) END ('2003-01-01'::date) , 
          START ('2003-01-01'::date) END ('2004-01-01'::date) , 
          START ('2004-01-01'::date) END ('2005-01-01'::date) , 
          START ('2005-01-01'::date)
          );

ALTER TABLE public.rank1 OWNER TO khazieva_gr;

-----------------------------------------------------------------
CREATE TABLE public.ataprank (
    id integer,
    rank integer,
    year date,
    gender character(1),
    usstate character(2)
)
DISTRIBUTED BY (id, gender, year, usstate)
PARTITION BY LIST(gender)
          SUBPARTITION BY RANGE(year)
                  SUBPARTITION BY LIST(usstate) 
          (
          PARTITION boys VALUES('M')
                  (
                  SUBPARTITION jan01 START ('2001-01-01'::date) END ('2002-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan02 START ('2002-01-01'::date) END ('2003-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan03 START ('2003-01-01'::date) END ('2004-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan04 START ('2004-01-01'::date) END ('2005-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan05 START ('2005-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          )
                  ), 
          PARTITION girls VALUES('F')
                  (
                  SUBPARTITION jan01 START ('2001-01-01'::date) END ('2002-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan02 START ('2002-01-01'::date) END ('2003-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan03 START ('2003-01-01'::date) END ('2004-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan04 START ('2004-01-01'::date) END ('2005-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan05 START ('2005-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          )
                  )
          );

ALTER TABLE public.ataprank
SET SUBPARTITION TEMPLATE 
          (
          SUBPARTITION mass VALUES('MA'), 
          SUBPARTITION cali VALUES('CA'), 
          SUBPARTITION ohio VALUES('OH')
          );

ALTER TABLE public.ataprank OWNER TO khazieva_gr;

---------------------------------------------------------

CREATE TABLE public.rank2 (
    id integer,
    rank integer,
    year date,
    gender character(1)
)
DISTRIBUTED BY (id, gender, year)
PARTITION BY LIST(gender)
          SUBPARTITION BY RANGE(year)
                  SUBPARTITION BY RANGE(rank) 
          (
          PARTITION boys VALUES('M')
                  (
                  START ('2001-01-01'::date) END ('2002-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2002-01-01'::date) END ('2003-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2005-01-01'::date)
                          (
                          START (1)
                          )
                  ), 
          PARTITION girls VALUES('F')
                  (
                  START ('2001-01-01'::date) END ('2002-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2002-01-01'::date) END ('2003-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2005-01-01'::date)
                          (
                          START (1)
                          )
                  )
          );

ALTER TABLE public.rank2
ALTER PARTITION boys 
SET SUBPARTITION TEMPLATE 
          (
          START (1)
          );

ALTER TABLE public.rank2
SET SUBPARTITION TEMPLATE 
          (
          START ('2001-01-01'::date) END ('2002-01-01'::date) , 
          START ('2002-01-01'::date) END ('2003-01-01'::date) , 
          START ('2005-01-01'::date)
          );

ALTER TABLE public.rank2 OWNER TO khazieva_gr;
-----------------------------------------------------
CREATE TABLE public.p3_sales (
    id integer,
    year integer,
    month integer,
    day integer,
    region text
)
DISTRIBUTED BY (id)
PARTITION BY RANGE(year)
          SUBPARTITION BY RANGE(month)
                  SUBPARTITION BY LIST(region) 
          (
          START (2011) END (2012) EVERY (1)
                  (
                  START (1) END (13) EVERY (1)
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          ), 
                  DEFAULT SUBPARTITION other_months
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          )
                  ), 
          DEFAULT PARTITION outlying_years
                  (
                  START (1) END (13) EVERY (1)
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          ), 
                  DEFAULT SUBPARTITION other_months
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          )
                  )
          );

ALTER TABLE public.p3_sales ALTER PARTITION outlying_years
SET SUBPARTITION TEMPLATE (
 SUBPARTITION usa VALUES('usa'),
 SUBPARTITION europe VALUES('europe'),
 SUBPARTITION asia VALUES('asia'),
 DEFAULT SUBPARTITION other_regions 
);

ALTER TABLE public.p3_sales
SET SUBPARTITION TEMPLATE (
START (1) END (13) EVERY (13),
 DEFAULT SUBPARTITION other_months 
);

ALTER TABLE public.p3_sales OWNER TO shamsutdinov_er;

-----------------------------------------------------
CREATE TABLE public.p4_sales (
    id integer,
    year integer,
    month integer,
    day integer,
    region text
)
DISTRIBUTED BY (id)
PARTITION BY RANGE(year)
          SUBPARTITION BY RANGE(month)
                  SUBPARTITION BY LIST(region) 
          (
          START (2011) END (2012) EVERY (1)
                  (
                  START (1) END (13) EVERY (1)
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          ), 
                  DEFAULT SUBPARTITION other_months
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          )
                  ), 
          DEFAULT PARTITION outlying_years
                  (
                  START (1) END (13) EVERY (1)
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          ), 
                  DEFAULT SUBPARTITION other_months
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          )
                  )
          );

ALTER TABLE public.p4_sales ALTER PARTITION outlying_years
SET SUBPARTITION TEMPLATE (
 SUBPARTITION usa VALUES('usa'),
 SUBPARTITION europe VALUES('europe'),
 SUBPARTITION asia VALUES('asia'),
 DEFAULT SUBPARTITION other_regions 
);

ALTER TABLE public.p4_sales
SET SUBPARTITION TEMPLATE (
START (1) END (13) EVERY (13),
 DEFAULT SUBPARTITION other_months 
);

ALTER TABLE public.p4_sales ALTER PARTITION second_partition_name
SET SUBPARTITION TEMPLATE (
 SUBPARTITION usa VALUES('usa'),
 DEFAULT SUBPARTITION other_regions 
);

ALTER TABLE public.p4_sales OWNER TO shamsutdinov_er;

-- external tables 

CREATE EXTERNAL TABLE gp_dwh_test.public.ext_customer (
    id int4,
    name text,
    sponsor text
)
LOCATION (
    'gpfdist://filehost:8081/*.csv'
)
FORMAT 'CSV' ( delimiter ',' null '' escape '"' quote '"' )
ENCODING 'UTF8';

CREATE EXTERNAL TABLE gp_dwh_test.public.ext_customer1 (
    id int4,
    name text,
    sponsor text
)
LOCATION (
    'gpfdist://filehost:8081/*.txt'
)
FORMAT 'TEXT' ( delimiter '|' null ' ' escape '\' )
ENCODING 'UTF8'
SEGMENT REJECT LIMIT 5 ROWS;

CREATE EXTERNAL TABLE public.ext_customer2 (
    id text,
    name text,
    sponsor text,
    test text)
LOCATION (
'gpfdist://filehost:8081/*.txt'
)
FORMAT 'CUSTOM' ( formatter='somefunction' )
ENCODING 'UTF8'
SEGMENT REJECT LIMIT 5 ROWS;

CREATE EXTERNAL TABLE gp_dwh_test.public.ext_customer3 (
    id int4,
    name text,
    sponsor text
)
LOCATION (
    'gpfdist://filehost:8081/*.txt'
)
FORMAT 'TEXT' ( delimiter '|' null ' ' escape '"' header )
ENCODING 'UTF8'
SEGMENT REJECT LIMIT 5 ROWS;

CREATE EXTERNAL TABLE public.ext_expenses (
    name text,
    date date,
    amount real,
    category text,
    description text)
LOCATION (
'file://seghost1/dbfast/external/expenses1.csv'
'file://seghost1/dbfast/external/expenses2.csv'
'file://seghost2/dbfast/external/expenses3.csv'
'file://seghost2/dbfast/external/expenses4.csv'
'file://seghost3/dbfast/external/expenses5.csv'
'file://seghost3/dbfast/external/expenses6.csv'
)
FORMAT 'CSV' ( delimiter ',' null '' escape '"' quote '"' header )
ENCODING 'UTF8';

CREATE EXTERNAL WEB TABLE gp_dwh_test.public.log_output (
    linenum int4,
    message text
)
EXECUTE '/var/load_scripts/get_log_data.sh' ON ALL
FORMAT 'TEXT' ( delimiter '|' null '\N' escape '\' )
ENCODING 'UTF8';

CREATE EXTERNAL WEB TABLE gp_dwh_test.public.log_output1 (
    linenum int4,
    message text
)
EXECUTE '/var/load_scripts/get_log_data.sh' ON MASTER
FORMAT 'TEXT' ( delimiter '|' null '\N' escape '\' )
ENCODING 'UTF8';

create table nv_parent (d date, check (false) no inherit not valid);