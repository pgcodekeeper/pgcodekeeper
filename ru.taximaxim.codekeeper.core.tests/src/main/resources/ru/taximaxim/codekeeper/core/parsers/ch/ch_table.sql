-- CREATE with MergeTree ENGINE
create table t (n int) engine MergeTree order by n;
CREATE TABLE t (x UInt8) ENGINE = MergeTree ORDER BY ();
create table x (i int) engine MergeTree order by tuple();
-- парсер ломается в правиле keyword есть коментарий. обойти это ограничение или игнорировать комент
--CREATE TABLE NULL (c String) ENGINE = MergeTree ORDER BY c;
create table t (c Decimal32(9)) engine MergeTree order by c;
create table t (n int, s String) engine MergeTree order by n;
CREATE TABLE db.t (n Int8) ENGINE=MergeTree ORDER BY n;
CREATE TABLE `$4@^7` (c String) ENGINE = MergeTree ORDER BY c;
CREATE TABLE `'`.`'` (c String) ENGINE = MergeTree ORDER BY c;
CREATE TABLE t1 (c0 Int32, PRIMARY KEY (c0)) ENGINE=MergeTree;
CREATE TABLE t (x DateTime64(3)) ENGINE = MergeTree ORDER BY x;
CREATE TABLE t (x Decimal(18, 3)) ENGINE = MergeTree ORDER BY x;
CREATE TABLE t (`A` Int64) ENGINE = MergeTree() ORDER BY tuple();
CREATE TABLE count (x UInt64) ENGINE = MergeTree ORDER BY tuple();
CREATE TABLE rptable (x UInt8) ENGINE = MergeTree ORDER BY x;
create table t(id UInt32) engine MergeTree order by id as select 1;
CREATE TABLE x AS system.numbers ENGINE = MergeTree ORDER BY number;
CREATE TABLE test1__fuzz_37 (`i` Date) ENGINE = MergeTree ORDER BY i;
-- описания данного синтаксиса https://clickhouse.com/docs/en/sql-reference/syntax#defining-and-using-query-parameters
CREATE TABLE test.xxx (a Int64) ENGINE=MergeTree ORDER BY ({o:String});
CREATE TABLE t (x UInt8) ENGINE = MergeTree ORDER BY () COMMENT 'Hello';
CREATE TABLE tab (col FixedString(2)) engine = MergeTree() ORDER BY col;
create table test (a String) Engine MergeTree order by a partition by a;
CREATE TABLE pk_order (a Int, b Int) ENGINE = MergeTree ORDER BY (a / b);
CREATE TABLE pk_order (a Int, b Int) ENGINE = MergeTree ORDER BY a / b;
create table shard1 (id Int32) engine = MergeTree order by cityHash64(id);
CREATE TABLE table_d (a Float64, count Int64) ENGINE MergeTree ORDER BY a;
create table mt (n UInt64) engine=MergeTree order by n partition by n % 10;
CREATE TABLE t1 (x Int16, y ALIAS x + x * 2) ENGINE=MergeTree() ORDER BY x;
create table tab (x String) engine = MergeTree order by x as select 'Hello';
CREATE TABLE tbl (id UInt32) ENGINE = MergeTree() ORDER BY (id + 1, id + 1);
CREATE TABLE tnul (lc Nullable(String)) ENGINE = MergeTree ORDER BY tuple();
CREATE TABLE Dates (date DateTime('UTC')) ENGINE = MergeTree() ORDER BY date;
CREATE TABLE auto_assign_enum (x enum('a', 'b')) ENGINE=MergeTree() order by x;
CREATE TABLE test (ip IPv4 Codec(ZSTD(6)),) ENGINE MergeTree() order by ip;
CREATE TABLE codecs6 (a UInt8 CODEC(Delta)) ENGINE = MergeTree ORDER BY tuple();
CREATE TABLE test (`x` Tuple(UInt64, UInt64)) ENGINE = MergeTree ORDER BY x;
-- парсер ломается на 2, если заменить правило literal на expr то все работает и показатели неоднозначности не меняются
create table a (i int) engine MergeTree order by i settings index_granularity = 2;
CREATE TABLE t1 (c0 Int32) ENGINE = MergeTree() ORDER BY c0 PARTITION BY (- (c0));
CREATE TEMPORARY TABLE alter_test (a UInt32, b UInt8) ENGINE=MergeTree ORDER BY a;
CREATE TABLE codecs4 (a UInt8 CODEC(LZ4, LZ4)) ENGINE = MergeTree ORDER BY tuple();
CREATE TABLE IF NOT EXISTS t_02708(x DateTime) ENGINE = MergeTree ORDER BY tuple();
create table "/t1" (a Int64, b Int64) engine = MergeTree() partition by a order by a;
CREATE TABLE db.rptable (x UInt8, y UInt8) ENGINE = MergeTree ORDER BY x;
create table alter_ttl(i Int) engine = MergeTree order by i ttl toDate('2020-05-05');
CREATE TABLE null_before (id DEFAULT 1 NOT NULL) ENGINE=MergeTree() ORDER BY tuple();
CREATE TABLE null_before (id INT DEFAULT 1 NULL) ENGINE=MergeTree() ORDER BY tuple();
CREATE TABLE null_before (id INT NULL DEFAULT 1) ENGINE=MergeTree() ORDER BY tuple();
CREATE TABLE null_before (id NOT NULL DEFAULT 1) ENGINE=MergeTree() ORDER BY tuple();
create table t1(a Array(UInt32)) ENGINE = MergeTree ORDER BY tuple() as select [1,2];
CREATE TABLE auto_assign_enum3 (x enum('a', 'b', NULL)) ENGINE=MergeTree() order by x;
CREATE TABLE data_02222 engine=MergeTree() ORDER BY dummy AS SELECT * FROM system.one;
CREATE TABLE trailing_comma_2 (id INT DEFAULT 1,) ENGINE=MergeTree() ORDER BY tuple();
CREATE TABLE primary_key (d Date DEFAULT today(), x Int8) ENGINE = MergeTree ORDER BY d;
create table aggr (n int, s AggregateFunction(max, String)) engine=MergeTree order by n;
CREATE TABLE auto_assign_enum1 (x enum('a' = -1000, 'b')) ENGINE=MergeTree() order by x;
CREATE TABLE store (id UInt32, "名称" String, "状态" String) ENGINE=MergeTree() Order by id;
CREATE TABLE `default` (d Date DEFAULT toDate(t), t DateTime) ENGINE = MergeTree order by d;
create table tab (x Int32, y Int32) engine = MergeTree partition by x + y order by tuple();
CREATE TABLE t (x UInt8, PROJECTION p (SELECT x GROUP BY x)) ENGINE = MergeTree ORDER BY ();
CREATE TABLE test (x UInt8, y UInt8 MATERIALIZED x + 1) ENGINE = MergeTree ORDER BY tuple();
create table ttl (d Date, a Int) engine = MergeTree order by a partition by toDayOfMonth(d);
CREATE TABLE numbers5 ENGINE = MergeTree ORDER BY number AS SELECT number FROM numbers(1000);
--создает аналогичную таблицу упомянутую во FROM, стягивает название столбцов и их типо индексы и прочее не создает
--нужно потестить подробнее подобный синтаксис
CREATE TABLE test_table ENGINE=MergeTree() ORDER BY tuple() AS SELECT * FROM test_table_data;
create table data_02230_ttl (date Date, `key` Int) Engine=MergeTree() order by key TTL date + 14;
--просто так не завелось требует "set `compatibility_ignore_auto_increment_in_create_table` to true"
-- CREATE TABLE ignore_auto_increment (id AUTO_INCREMENT) ENGINE=MergeTree() ORDER BY tuple();
CREATE TABLE test_table (a UInt64, b ALIAS a, c ALIAS b) ENGINE = MergeTree() ORDER BY tuple();
create table x (dt String) engine MergeTree partition by toYYYYMM(toDate(dt)) order by tuple();
create table alter_ttl(d Date, s String) engine = MergeTree order by d ttl d + interval 1 month;
create table lc_00800_1 (names Array(LowCardinality(String))) engine=MergeTree order by tuple();
CREATE TABLE table (uid UUID, date DateTime('Asia/Kamchatka')) ENGINE = MergeTree ORDER BY date;
create table tp (type Int32, device UUID, cnt UInt64) engine = MergeTree order by (type, device);
CREATE TABLE bad_conversions_2 (e Enum('foo' = 1, 'bar' = 2)) ENGINE = MergeTree ORDER BY tuple();
CREATE TABLE samples (key UInt32, value UInt32) ENGINE = MergeTree() ORDER BY key PRIMARY KEY key;
CREATE TABLE sessions (`user_id` UInt64) ENGINE = MergeTree ORDER BY user_id SAMPLE BY user_id;
-- интересный кейс стоит отнести к синтаксическому сахара така как бд хранит столбец n как n.key и n.value а типы у них Array(String)
CREATE TABLE t_array_index (n Nested(key String, value String)) ENGINE = MergeTree ORDER BY n.key;
-- синтаксический сахар бд будет возвращать другую запись значение default
CREATE TABLE test (x UInt64, "\\" String DEFAULT '\r\n\t\\' || ' ') ENGINE = MergeTree ORDER BY x;
CREATE TABLE delta_table (`id` UInt64 CODEC(Delta(tuple()))) ENGINE = MergeTree() ORDER BY tuple();
CREATE TABLE foo (key int, INDEX i1 key TYPE minmax GRANULARITY 1) Engine=MergeTree() ORDER BY key;
CREATE TABLE tab(id Int32, vec Float32, INDEX idx vec TYPE annoy()) ENGINE = MergeTree ORDER BY id;
CREATE TABLE test (key UInt64, val UInt64) engine = MergeTree Order by key PARTITION BY key >= 128;
CREATE TABLE encryption_test (i Int, s String Codec(AES_128_GCM_SIV)) ENGINE = MergeTree ORDER BY i;
CREATE TABLE interval (`id` String, `start` Int64, `end` Int64) ENGINE = MergeTree ORDER BY start;
create table t (i int, j int, projection p (select i order by i)) engine MergeTree order by tuple();
create table t (id UInt32, a Int) engine = MergeTree order by id settings min_bytes_for_wide_part=0;
CREATE TABLE tdm__fuzz_23 (`x` UInt256) ENGINE = MergeTree ORDER BY x SETTINGS write_final_mark = 0;
create table test_ins_null (date Date, val Nullable(UInt64)) engine = MergeTree(date, (date), 8192);
CREATE TABLE binary_op_mono1(i int, j int) ENGINE MergeTree PARTITION BY toDate(i / 1000) ORDER BY j;
CREATE TABLE db_asterisk.`*` (x UInt8, y UInt8) ENGINE = MergeTree ORDER BY x AS SELECT 100, 20;
-- один индекс может содержать несколько уникальных выражений
CREATE TABLE tbl (id UInt32, INDEX idx (id + 1, id - 1) TYPE minmax) ENGINE = MergeTree() ORDER BY id;
CREATE TABLE t36 (id UInt32, id2 UInt32, INDEX idx (id + 1, id2) TYPE minmax) ENGINE = MergeTree() ORDER BY id;
CREATE TABLE t37 (id UInt32, id2 UInt32, INDEX idx (id + 1, id + 1 != 12) TYPE minmax) ENGINE = MergeTree() ORDER BY id;
CREATE TABLE {CLICKHOUSE_DATABASE_1:Identifier}.data_02716_3 (v UInt64) ENGINE = MergeTree ORDER BY v;
create table cc (a UInt64, b String) ENGINE = MergeTree order by (a, b) SETTINGS compress_marks = true;
CREATE TABLE t02006 on cluster test_shard_localhost (d Date) ENGINE = MergeTree ORDER BY d format Null;
create table tab (x Int32, y Int32) engine = MergeTree partition by ((x + y) + 1) * 2 order by tuple();
CREATE TEMPORARY TABLE src (p UInt64, k String, d UInt64) ENGINE = MergeTree PARTITION BY p ORDER BY k;
CREATE TABLE IF NOT EXISTS sample_incorrect (`x` UUID) ENGINE = MergeTree ORDER BY tuple(x) SAMPLE BY x;
CREATE TABLE mmm ENGINE=MergeTree ORDER BY number AS SELECT number, rand() % 10 AS a FROM numbers(1000);
create table tab (x UInt64, `arr.a` Array(UInt64), `arr.b` Array(UInt64)) engine = MergeTree order by x;
CREATE TABLE test_parallel_index (z UInt64, INDEX i z TYPE set(8)) ENGINE = MergeTree ORDER BY ();
CREATE TABLE test_table (id UInt8, value Nullable(Decimal(38, 2))) ENGINE = MergeTree ORDER BY id;
create table tp (x Int32, y Int32, projection p (select x, y order by x)) engine = MergeTree order by y;
CREATE TABLE ignore_auto_increment (id int AUTO_INCREMENT DEFAULT 1) ENGINE=MergeTree() ORDER BY tuple();
CREATE TABLE ignore_auto_increment (id int DEFAULT 1 AUTO_INCREMENT) ENGINE=MergeTree() ORDER BY tuple();
CREATE TABLE sales ("日期" Date, "店铺" UInt32, "地址" UInt32, "销售额" Float32) ENGINE=MergeTree() Order by "日期";
CREATE TABLE src Engine=MergeTree ORDER BY id AS SELECT number as id, toInt32(1) as value FROM numbers(1);
create table enum engine MergeTree order by enum as select cast(1, 'Enum8(\'zero\'=0, \'one\'=1)') AS enum;
CREATE TABLE t_ttl_non_deterministic(A Int64) ENGINE = MergeTree ORDER BY A TTL now() + toIntervalMonth(1);
CREATE TABLE tdm (x DateTime('Asia/Istanbul')) ENGINE = MergeTree ORDER BY x SETTINGS write_final_mark = 0;
CREATE TABLE test2 (a UInt32, b Int64) ENGINE = MergeTree ORDER BY tuple() PARTITION BY (a * b, b * b);
CREATE TABLE producer_02366 (`id` UInt16, `dec` String) ENGINE = MergeTree PRIMARY KEY id ORDER BY id;
create table ttl (i Int, s String) engine = MergeTree order by i ttl toDate('2000-01-01') TO DISK 'default';
CREATE TABLE t_json(id UInt64, obj JSON) ENGINE = MergeTree ORDER BY id SETTINGS min_bytes_for_wide_part = 0;
create table foo(bar String, projection p (select * apply groupUniqArray(100))) engine MergeTree order by bar;
create table projection_without_key (key UInt32, PROJECTION x (SELECT max(key))) engine MergeTree order by key;
--нужно разобраться с этим синтаксисом
CREATE TABLE {new_db_name:Identifier}.{old_tbl_name:Identifier} (a UInt64) ENGINE = MergeTree ORDER BY tuple();
create table tab (a UInt32, b UInt32, c UInt32, d UInt32) engine = MergeTree order by ((a + b) * c, sin(a / b));
-- валидный кейс
CREATE TABLE lol (n int) ENGINE=MergeTree ORDER BY n SETTINGS min_bytes_for_wide_part=123 SETTINGS log_queries=1;
create table tab (x UInt128) engine = MergeTree order by x settings allow_nullable_key = 1, index_granularity = 2;
CREATE TABLE t1 (s String) ENGINE = MergeTree ORDER BY s SETTINGS ratio_of_defaults_for_sparse_serialization = 0.5;
CREATE TABLE test (a Int32) ENGINE = MergeTree() order by tuple() SETTINGS disk = disk(type=local, path='/local/');
create table p(d Date, i int, j int) engine MergeTree partition by d order by i settings max_partitions_to_read = 1;
CREATE TABLE t_map (m Map(String, UInt32)) ENGINE = MergeTree ORDER BY tuple() SETTINGS min_bytes_for_wide_part = 0;
CREATE TABLE substitute_udf (id UInt32, number UInt32 DEFAULT plusone(id)) ENGINE=MergeTree() ORDER BY id;
CREATE TABLE delta_codec_synthetic (`id` Decimal(38, 10) CODEC(Delta, ZSTD(22))) ENGINE = MergeTree() ORDER BY tuple();
CREATE TABLE table2 (id Int64, v UInt64) ENGINE = MergeTree() PARTITION BY (toInt32(id / 2) % 3, id % 200) ORDER BY id;
CREATE TABLE t0 (c0 Int16, projection h (SELECT min(c0), max(c0), count() GROUP BY -c0)) ENGINE = MergeTree ORDER BY ();
create table test (key Int) engine=MergeTree() order by tuple() settings ratio_of_defaults_for_sparse_serialization=0.1;
create table data_01643
(
    key Int
) engine=MergeTree() order by key settings min_rows_for_wide_part=2, fsync_after_insert=1;
CREATE TABLE t_bad_constraint
(
    a UInt32,
    s String,
    CONSTRAINT c1 ASSUME a = toUInt32(s)
) ENGINE = MergeTree ORDER BY tuple();
create table pl
(
    dt DateTime,
    i int,
    projection p (select sum(i) group by toStartOfMinute(dt))
) engine MergeTree order by dt;
CREATE TABLE test
(
    time DateTime64(3)
) ENGINE = MergeTree ORDER BY tuple() PARTITION BY toStartOfInterval(time, INTERVAL 2 YEAR);
create table ttl
(
    d Date,
    a Int
) engine = MergeTree order by tuple() partition by toDayOfMonth(d) settings remove_empty_parts = 0;
create table undrop_no_uuid_on_cluster on cluster test_shard_localhost
(
    id Int32
) Engine=MergeTree() order by id format Null;
CREATE TABLE a
(
    number UInt64
) ENGINE = MergeTree ORDER BY if(now() > toDateTime('2020-06-01 13:31:40'), toInt64(number), -number);
CREATE TABLE dummy
(
    num1 Int32,
    num2 Enum8('foo' = 0, 'bar' = 1, 'tar' = 2)
) ENGINE = MergeTree ORDER BY num1 as select 5, 'bar';
CREATE TABLE ".inner_id.e15f3ab5-6cae-4df3-b879-f40deafd82c2"
(
    n Int32,
    n2 Int64
) ENGINE = MergeTree PARTITION BY n % 10 ORDER BY n;
-- синтаксический сахар ceiling на сервере превращается в ceil
create table d
(
    dt DateTime,
    j int
) engine MergeTree partition by (toDate(dt), ceiling(j), toDate(dt), CEILING(j)) order by tuple();
create table fat_granularity
(
    x UInt32,
    fat FixedString(160000)
) engine = MergeTree order by x settings storage_policy = 's3_cache';
-- какая то функция обращается к таблице и мб ее столбцам нужно потестить на примерах
CREATE TABLE test_01676.table
(
    x UInt64,
    y UInt64 DEFAULT dictGet('test_01676.dict', 'value', x)
) ENGINE=MergeTree ORDER BY tuple();
-- EPHEMERAL может быть без значения остальные дефолтные типы должны иметь значения
CREATE TABLE ignore_auto_increment (di DEFAULT 1, s String EPHEMERAL) ENGINE=MergeTree() ORDER BY tuple();
CREATE TABLE tab
(
    e8 Enum8('hello' = -5, 'world' = 15), e16 Enum16('shark' = -999, 'eagle' = 9999)
) ENGINE MergeTree ORDER BY tuple();
CREATE TABLE test
(
    `key` UInt32,
    `arr` ALIAS [1, 2],
    `xx` MATERIALIZED arr[1]
) ENGINE = MergeTree PARTITION BY tuple() ORDER BY tuple();
CREATE TABLE column_swap_test_test
(
    i Int64,
    a String,
    b UInt64,
    CONSTRAINT c1 ASSUME b = cityHash64(a)
) ENGINE = MergeTree() ORDER BY i;
CREATE TABLE event_types
(
    type String,
    active Int16
) ENGINE = MergeTree PARTITION BY substring(type, 1, 1) ORDER BY (type, active);
CREATE TABLE t_ttl_move_if_exists
(
    d DateTime,
    a UInt32
) ENGINE = MergeTree ORDER BY tuple() TTL d TO DISK IF EXISTS 'non_existing_disk';
CREATE TABLE too_many_parts
(
    x UInt64
) ENGINE = MergeTree ORDER BY tuple() SETTINGS parts_to_delay_insert = 5, parts_to_throw_insert = 5;
CREATE TABLE ip_part_test
(
    ipv4 IPv4,
    ipv6 IPv6
) ENGINE = MergeTree PARTITION BY ipv4 ORDER BY ipv4 AS SELECT '1.2.3.4', '::ffff:1.2.3.4';
-- для тестирования нужно создать DICTINORY
CREATE TABLE table
(
    col MATERIALIZED dictGet(currentDatabase() || '.dict', 'value', toUInt32(1))
) ENGINE = MergeTree() ORDER BY tuple();
-- создаем таблицу и инсертим в ней значения
CREATE TABLE table_key
(
    keycol UInt16
) ENGINE = MergeTree() ORDER BY (keycol) PARTITION BY tuple() as SELECT * FROM VALUES ((1), (2), (3));
create table ttl_00933_2
(
    d DateTime,
    a Int,
    b default 222 ttl d + interval 1 DAY
) engine = MergeTree order by tuple() partition by toDayOfMonth(d);
CREATE TABLE test
(
    x UUID,
    INDEX ix_x x TYPE bloom_filter(0.01) GRANULARITY 1
) ENGINE = MergeTree() ORDER BY x SETTINGS index_granularity=8192;
CREATE TABLE source_data
(
    pk Int32,
    sk Int32,
    val UInt32,
    partition_key UInt32 DEFAULT 1,
    PRIMARY KEY (pk)
) ENGINE=MergeTree ORDER BY (pk, sk);
create table if not exists null_01016
(
    x Nullable(String)
) engine MergeTree order by ifNull(x, 'order-null') partition by ifNull(x, 'partition-null');
CREATE TABLE parsed_eph
(
    name String,
    num_ephemeral UInt32 EPHEMERAL,
    num UInt32 MATERIALIZED num_ephemeral,
) ENGINE = MergeTree ORDER BY (name);
CREATE TABLE test
(
    x Int128,
    INDEX ix_x x TYPE bloom_filter(0.01) GRANULARITY 1
) ENGINE = MergeTree() ORDER BY x SETTINGS index_granularity=8192;
CREATE TABLE click_storage
(
    `PhraseID` UInt64,
    `PhraseProcessedID` UInt64 ALIAS if(PhraseID > 5, PhraseID, 0)
) ENGINE = MergeTree() ORDER BY tuple();
CREATE TABLE column_swap_test_test
(
    i Int64,
    a String,
    b String,
    CONSTRAINT c1 ASSUME a = substring(reverse(b), 1, 1)
) ENGINE = MergeTree() ORDER BY i;
CREATE TABLE legacy_column_name_of_tuple_literal
(
    `x` UInt32,
    `y` UInt64,
    PROJECTION p (SELECT sum(y in (1, 2 ,3)))
) ENGINE = MergeTree ORDER BY tuple();
CREATE TABLE t_nested_with_dots
(
    `t.t2` Tuple(`t3.t4.t5` Tuple(`s1.s2` String, `u1.u2` UInt64), `s3.s4.s5` String)
) ENGINE = MergeTree ORDER BY tuple();
CREATE TABLE t_skip_index_in
(
    a String,
    b String,
    c String,
    INDEX idx_c c TYPE bloom_filter GRANULARITY 1
) ENGINE = MergeTree ORDER BY (a, b);
create table ttl
(
    i Int,
    s String
) engine = MergeTree order by i SETTINGS max_number_of_merges_with_ttl_in_pool=0,materialize_ttl_recalculate_only=true;
CREATE TABLE t0 ENGINE=MergeTree() ORDER BY tuple() AS SELECT rowNumberInAllBlocks(), * FROM (SELECT toLowCardinality(arrayJoin(['exchange', 'tables'])));
CREATE TABLE merge_tree
(
    x UInt32
) ENGINE = MergeTree ORDER BY x SETTINGS index_granularity_bytes = 4, min_index_granularity_bytes=1, write_final_mark = 0;
CREATE TABLE default_table
(
    key UInt64 DEFAULT 42,
    value1 UInt64 MATERIALIZED key * key,
    value2 ALIAS value1 * key
) ENGINE = MergeTree() ORDER BY tuple();
CREATE TABLE mytable
(
    operand Float64,
    low Float64,
    high Float64,
    count UInt64,
    PRIMARY KEY (operand, low, high, count)
) ENGINE = MergeTree();
CREATE TABLE t2 ENGINE=MergeTree() ORDER BY tuple() AS SELECT rowNumberInAllBlocks() + (SELECT count() FROM t0), * FROM (SELECT arrayJoin(['hello', 'world']));
CREATE TABLE github_events AS gen ENGINE=MergeTree ORDER BY (event_type, repo_name, created_at) SETTINGS index_granularity = 8192, index_granularity_bytes = '10Mi';
CREATE TABLE t_s3_compressed_blocks
(
    id UInt64,
    s String CODEC(NONE)
) ENGINE = MergeTree ORDER BY id SETTINGS storage_policy = 's3_cache', min_bytes_for_wide_part = 0;
CREATE TABLE test_a
(
    OldColumn String DEFAULT '',
    EventDate Date DEFAULT toDate(EventTime),
    EventTime DateTime
) ENGINE = MergeTree(EventDate, EventTime, 8192);
CREATE TABLE IF NOT EXISTS uuid
(
    created_at DateTime,
    id0 String,
    id1 FixedString(36)
) ENGINE = MergeTree PARTITION BY toDate(created_at) ORDER BY (created_at);
CREATE TABLE primary
(
    `primary` String
) ENGINE = MergeTree ORDER BY primary settings min_bytes_for_wide_part=0,min_bytes_for_wide_part=0 AS SELECT * FROM numbers(1000);
CREATE TABLE test
(
    a Int32,
    b String
) ENGINE = MergeTree() ORDER BY tuple() SETTINGS disk = disk(type = 'local_blob_storage', path = '${CLICKHOUSE_TEST_UNIQUE_NAME}/');
-- для чего может быть приминим подобный синтаксис?
CREATE TABLE ".inner_id.e15f3ab5-6cae-4df3-b879-f40deafd82c2" UUID '3bd68e3c-2693-4352-ad66-a66eba9e345e'
(
    n Int32,
    n2 Int64
) ENGINE = MergeTree PARTITION BY n % 10 ORDER BY n;
-- по сделал такое отображения в целях улучшения читабильности
create table test_byte_size_more_complex
(
    key Int32,
    complex1 Array(
    			  Tuple(
    				   Nullable(FixedString(4)),
    				   Array(
    					    Tuple(
    						     Nullable(String),
    						     String
    						     )
    					    )
    				   )
    			  )
) engine MergeTree order by key;
-- так подобные кейсы со множественной вложенностью отображаются в БД
CREATE TABLE nested
(
    column Nested (name String, names Array(String), types Array(Enum8('PU' = 1, 'US' = 2, 'OTHER' = 3)))
) ENGINE = MergeTree ORDER BY tuple();
CREATE TABLE test
(
    a Int32
) ENGINE = MergeTree() ORDER BY tuple() SETTINGS disk = disk(type = cache, max_size = '1Mi', path = '/kek', disk = 'local_disk');
CREATE TABLE ttl_where
(
    `d` Date,
    `i` UInt32
) ENGINE = MergeTree ORDER BY tuple() TTL d + toIntervalYear(10) DELETE WHERE i % 3 = 0, d + toIntervalYear(40) DELETE WHERE i % 3 = 1;
CREATE TABLE t_02809
(
    a Int64,
    b Int64,
    s String
) ENGINE=MergeTree order by tuple() AS SELECT number, number%10, toString(arrayMap(i-> cityHash64(i*number), range(50))) FROM numbers(10000);
create table test_02381
(
    a UInt64,
    b UInt64
) ENGINE = MergeTree order by (a, b) SETTINGS compress_marks = false, compress_primary_key = false, ratio_of_defaults_for_sparse_serialization = 1;
create table data_01809
(
    i int
) engine MergeTree order by i settings old_parts_lifetime = 10000000000, min_bytes_for_wide_part = 0, inactive_parts_to_throw_insert = 0, inactive_parts_to_delay_insert = 1;
CREATE TABLE tab
(
    `uint64` UInt64,
    `int32` Nullable(Int32) COMMENT 'example comment',
    `str` String,
    INDEX idx str TYPE set(1000)
) ENGINE = MergeTree PRIMARY KEY (uint64) ORDER BY (uint64, str);
CREATE TABLE test
(
    `int8` Int8,
    `int16` Int16,
    `int32` Int32,
    `int64` Int64,
    INDEX idx (`int8`, `int16`, `int32`, `int64`) TYPE bloom_filter(0.01) GRANULARITY 8192
) ENGINE = MergeTree() ORDER BY `int8`;
-- также можно этим кейсом дополнить случаи со сравнением дефолтного скрипта и синтактического сахара
CREATE TABLE cast
(
    x UInt8,
    e Enum8 ('hello' = 1, 'world' = 2) DEFAULT CAST (x AS Enum8 ('hello' = 1, 'world' = 2))
) ENGINE = MergeTree ORDER BY e;
CREATE TABLE test02910_second
(
    `Id1` String,
    `Id2` String,
    `timestamp` DateTime64(6),
    `tags` Array(String),
) ENGINE = MergeTree PRIMARY KEY (Id1, Id2) ORDER BY (Id1, Id2, timestamp) SETTINGS index_granularity = 8192, index_granularity_bytes = 0;
CREATE TABLE merge_tree_table
(
    Date Date,
    SomeType UInt8,
    Alternative1 UInt64,
    Alternative2 UInt64,
    User UInt32,
    CharID UInt64 ALIAS multiIf(SomeType IN (3, 4, 11), 0, SomeType IN (7, 8), Alternative1, Alternative2)
) ENGINE = MergeTree() ORDER BY tuple();
CREATE TABLE recompression_table_compact
(
    dt DateTime,
    key UInt64,
    value String
) ENGINE MergeTree()
ORDER BY tuple()
PARTITION BY key
TTL dt + INTERVAL 1 MONTH RECOMPRESS CODEC(ZSTD(17)), dt + INTERVAL 1 YEAR RECOMPRESS CODEC(LZ4HC(10))
SETTINGS min_rows_for_wide_part = 10000;
CREATE TABLE tbl
(
    a UInt64,
    b UInt64,
    c UInt64,
    d UInt64,
    e UInt64,
    INDEX mm1_idx (a, c, d) TYPE minmax,
    INDEX mm2_idx (c, d, e) TYPE minmax,
    INDEX set_idx (e) TYPE set(100),
    INDEX blf_idx (d, b) TYPE bloom_filter(0.8)
) ENGINE = MergeTree PRIMARY KEY (c, a);
CREATE TABLE table_for_rename
(
    date Date,
    key UInt64,
    value1 String,
    value2 String,
    value3 String,
    CONSTRAINT cs_value1 CHECK toInt64(value1) < toInt64(value2),
    CONSTRAINT cs_value2 CHECK toInt64(value2) < toInt64(value3)
) ENGINE = MergeTree() PARTITION BY date ORDER BY key;
-- очень веселый кейс
CREATE TABLE multidimensional
ENGINE = MergeTree
ORDER BY number
SETTINGS index_granularity = 8192,
index_granularity_bytes = '10Mi'
AS SELECT number, arrayMap(x -> (x, [x], [[x]], (x, toString(x))), arrayMap(x -> range(x), range(number % 10))) AS value FROM system.numbers LIMIT 100000;
CREATE TABLE large_alter_table_00804
(
    somedate Date CODEC(ZSTD, ZSTD, ZSTD(12), LZ4HC(12)),
    id UInt64 CODEC(LZ4, ZSTD, NONE, LZ4HC),
    data String CODEC(ZSTD(2), LZ4HC, NONE, LZ4, LZ4)
) ENGINE = MergeTree() PARTITION BY somedate ORDER BY id SETTINGS index_granularity = 2, index_granularity_bytes = '10Mi', min_bytes_for_wide_part = 0;
CREATE TABLE Test
ENGINE = MergeTree()
PRIMARY KEY (String1,String2)
ORDER BY (String1,String2)
SETTINGS index_granularity = 8192, index_granularity_bytes = '10Mi'
AS SELECT 'String1_' || toString(number) as String1, 'String2_' || toString(number) as String2, 'String3_' || toString(number) as String3, 'String4_' || toString(number%4) as String4 FROM numbers(1);
CREATE TABLE test
(
    key UInt32,
    value String
) ENGINE=MergeTree()
ORDER BY key
SETTINGS min_bytes_for_wide_part = 10485760,
compress_marks=false,
compress_primary_key=false,
disk = disk(type = cache, max_size = '128Mi',
path = 'filesystem_query_cache/',
cache_on_write_operations= 1,
enable_filesystem_query_cache_limit = 1,
delayed_cleanup_interval_ms = 100, disk = 's3_disk');

--ReplicatedMergeTree
create table t1_r1 (x Int32) engine=ReplicatedMergeTree('/test/02442/{database}/t', 'r1') order by x;
CREATE TABLE test_01148_atomic.rmt2 ON CLUSTER test_shard_localhost
(
    n int,
    PRIMARY KEY n
) ENGINE=ReplicatedMergeTree('/test/02442/{database}/t', 'r1');
create table trunc (n int, primary key n) engine=ReplicatedMergeTree('/test/1166/{database}', '1') partition by n % 10;
CREATE TABLE cast2 AS cast1 ENGINE = ReplicatedMergeTree('/clickhouse/tables/{database}/test_00643/cast', 'r2') ORDER BY e;
CREATE TABLE replicated_mutations_empty_partitions
(
    key UInt64,
    value String
) ENGINE = ReplicatedMergeTree('/clickhouse/test/'||currentDatabase()||'/01586_replicated_mutations_empty_partitions/{shard}', '{replica}') ORDER BY key PARTITION by key;
CREATE TABLE replicated_merge_tree_with_sampling
(
    d Date,
    a String,
    b UInt8,
    x String,
    y Int8,
    z UInt32
) ENGINE = ReplicatedMergeTree('/clickhouse/tables/{database}/test_00083/01/replicated_merge_tree_with_sampling/', 'r1', d, sipHash64(a) + b, (a, sipHash64(a) + b), 111);

--ReplicatedSummingMergeTree
CREATE TABLE summing_r1
(
    x UInt32,
    y UInt32,
    val UInt32
) ENGINE ReplicatedSummingMergeTree('/clickhouse/tables/{database}/test_00754/summing', 'r1') ORDER BY (x, y);

--ReplicatedReplacingMergeTree
CREATE TABLE rename1
(
    p Int64,
    i Int64,
    v UInt64
) ENGINE = ReplicatedReplacingMergeTree('/clickhouse/tables/{database}/rename', '1', v) PARTITION BY p ORDER BY i;

--ReplicatedAggregatingMergeTree
CREATE TABLE replicated_aggregating_merge_tree
(
    d Date,
    a String,
    b UInt8,
    x String,
    y Int8,
    z UInt32
) ENGINE = ReplicatedAggregatingMergeTree('/clickhouse/tables/{database}/test_00083/01/replicated_aggregating_merge_tree/', 'r1', d, (a, b), 111);

--ReplicatedCollapsingMergeTree
create table data_rep_02228
(
    key1 UInt32,
    sign Int8,
    s UInt64
) engine = ReplicatedCollapsingMergeTree('/clickhouse/{database}', 'r1', sign) order by (key1) partition by key1 % 1024;

--ReplicatedVersionedCollapsingMergeTree
CREATE TABLE table_with_version_replicated_1
(
    key UInt64,
    value String,
    version UInt8,
    sign Int8
) ENGINE ReplicatedVersionedCollapsingMergeTree('/clickhouse/' || currentDatabase() || '/test_01511/{shard}/t', '1_{replica}', sign, version) ORDER BY key;

--ReplicatedGraphiteMergeTree
CREATE TABLE t4_r_ok
(
    `key` UInt32,
    `Path` String,
    `Time` DateTime('UTC'),
    `Value` Float64,
    `Version` UInt32,
    `col` UInt64
) ENGINE = ReplicatedGraphiteMergeTree('/tables/{database}/t4/', 'r2', 'graphite_rollup') ORDER BY key;

--ReplacingMergeTree
create table if not exists rhs (x String) engine=ReplacingMergeTree() ORDER BY x;
CREATE TABLE primary_key_test
(
    v1 Int64,
    v2 Int32,
    v3 String,
    PRIMARY KEY(v1, gcd(v1, v2))
) ENGINE=ReplacingMergeTree ORDER BY v1;
CREATE TABLE t
(
    `account_id` UInt64,
    `_is_deleted` UInt8,
    `_version` UInt64
) ENGINE = ReplacingMergeTree(_version, _is_deleted) ORDER BY (account_id);

--SummingMergeTree
CREATE TABLE pk_func(d DateTime, ui UInt32) ENGINE = SummingMergeTree ORDER BY toDate(d);
CREATE TABLE summing_merge_tree
(
    key UInt32,
    val UInt32,
    date Datetime
) engine=SummingMergeTree(val) PARTITION BY date ORDER BY key;
CREATE TABLE default.derived_metrics_local 
(
    `timestamp` DateTime, 
    `timestamp_h` DateTime MATERIALIZED toStartOfHour(timestamp), 
    `bytes` UInt64
) ENGINE = SummingMergeTree 
PARTITION BY toYYYYMMDD(timestamp) 
ORDER BY (timestamp_h, timestamp) 
TTL toStartOfHour(timestamp) + toIntervalHour(1) 
    GROUP BY timestamp_h 
    SET bytes = max(bytes), timestamp = toStartOfHour(any(timestamp))
SETTINGS index_granularity = 8192;

--AggregatingMergeTree
CREATE TABLE t1 (vkey UInt32) ENGINE = AggregatingMergeTree ORDER BY vkey;

--CollapsingMergeTree
CREATE TABLE signed_table (k UInt32, v String, s Int8) ENGINE CollapsingMergeTree(s) ORDER BY k;


--VersionedCollapsingMergeTree
CREATE TABLE table_with_version
(
    key UInt64,
    value String,
    version UInt8,
    sign Int8
) ENGINE VersionedCollapsingMergeTree(sign, version) ORDER BY key;

--GraphiteMergeTree
create table test_graphite
(
    key UInt32,
    Path String,
    Time DateTime('UTC'),
    Value UInt8,
    Version UInt32,
    col UInt64
) engine = GraphiteMergeTree('graphite_rollup') order by key;

--Log
create table m (a int) engine Log;
CREATE TABLE log ENGINE=Log AS val;
CREATE TABLE float (x Float64) ENGINE = Log;
create table local_t engine Log as select 1 a;
CREATE TEMPORARY TABLE tmp2 (n int) ENGINE=Log;
create table undrop_log (id Int32) Engine=Log();
CREATE TABLE t3 (`n` Int8) ENGINE = Log COMMENT 'this is a Log table';
CREATE TABLE {CLICKHOUSE_DATABASE:Identifier}.test_log(id UInt64) ENGINE = Log;
CREATE TABLE test_2554_log (n UInt32) ENGINE = Log SETTINGS storage_policy = 'default';
-- CH сможет обработать подобный кейс вопрос нужно ли нам подобное допускать на уровне парсера
--CREATE TABLE perf_lc_num(　 num UInt8,　 arr Array(LowCardinality(Int64)) default [num]　) ENGINE = Log
CREATE TABLE constrained
(
    URL String,
    CONSTRAINT is_censor CHECK domainWithoutWWW(URL) = 'censor.net',
    CONSTRAINT is_utf8 CHECK isValidUTF8(URL)
) ENGINE = Log;

--Stripelog
CREATE TABLE t (x UInt8) ENGINE = StripeLog;
CREATE TABLE numbers_squashed AS system.numbers ENGINE = StripeLog;

--TinyLog
CREATE TABLE t (x UInt8) ENGINE = TinyLog;
CREATE TABLE tmp ENGINE = TinyLog AS SELECT queryID();
CREATE TABLE order(id UInt32, pId UInt32, uId UInt32) ENGINE = TinyLog;
CREATE TABLE {CLICKHOUSE_DATABASE:Identifier}.A (A UInt8) ENGINE = TinyLog;
CREATE TABLE constraint_on_nullable_type (`id` Nullable(UInt64), CONSTRAINT `c0` CHECK `id` = 1) engine = TinyLog();
CREATE TABLE constraint_test_transitivity3
(
    a Int64,
    b Int64,
    c Int64,
    CONSTRAINT c1 ASSUME b > 10 AND 1 > a
) engine = TinyLog;
CREATE TABLE constraint_constant_number_expression
(
    id UInt64,
    CONSTRAINT `c0` CHECK 1,
    CONSTRAINT `c1` CHECK 1 < 2,
    CONSTRAINT `c2` CHECK isNull(cast(NULL, 'Nullable(UInt8)'))
) engine = TinyLog();

-- EmbeddedRocksDB
CREATE TABLE test (key String, value UInt32) Engine=EmbeddedRocksDB PRIMARY KEY(key);

--HDFS
create table test_table_hdfs_syntax (id UInt32) ENGINE = HDFS('') ;

--S3
create table test_02245 (a UInt64) engine = S3(s3_conn, filename='test_02245', format=Parquet);
create table test_02481_mismatch_files
(
    a UInt64,
    b String
) engine = S3(s3_conn, filename='test_02481_mismatch_files_{_partition_id}', format=Parquet) partition by a;
create table test_02245_s3_nested_orc1
(
    a Int64
) engine=S3(s3_conn, filename='test_02245_s3_nested_orc1_{_partition_id}', format='ORC') partition by a;
-- CH такой запрос тоже сможет обработать
--CREATE TABLE table_with_range
--(
--    `name` String,`
--    number` UInt32
--)　ENGINE = S3('http://localhost:11111/test/tsv_with_header.tsv', 'test', 'testtest', 'TSVWithNames')　SETTINGS input_format_with_names_use_header = 1;

--Distributed
create table dist (key Int) engine=Distributed(default, currentDatabase(), data);
create table dist as system.one engine=Distributed('test_shard_localhost', system, one);
create table td engine = Distributed(test_shard_localhost, currentDatabase(), 't') as t;
CREATE TABLE tt7 as tt6 ENGINE = Distributed('test_shard_localhost', '', 'tt6', rand());
CREATE TABLE inner_distributed AS inner ENGINE = Distributed('test_cluster_two_shards', currentDatabase(), 'inner', intHash64(organization_id));
CREATE TABLE outer_distributed AS outer ENGINE = Distributed('test_cluster_two_shards', currentDatabase(), 'outer', intHash64(organization_id));
create table dist_01850
(
    key Int
) engine=Distributed('test_cluster_two_replicas_different_databases', /* default_database= */ '', data_01850, key);

--Dictionary
CREATE TABLE test_dictionary_view
(
    id UInt64,
    value String
) ENGINE=Dictionary(concat(currentDatabase(), '.02155_test_dictionary'));
CREATE TABLE {CLICKHOUSE_DATABASE:Identifier}.table_from_ip_trie_dict
(
    prefix String,
    val String
) ENGINE = Dictionary({CLICKHOUSE_DATABASE:Identifier}.dict_ip_trie);

-- не тестил создание подобных объектов 24.02.01
--Merge
CREATE TABLE merge_tf as merge(currentDatabase(), '.*');
CREATE TABLE A_M as A1 ENGINE = Merge(currentDatabase(), '^A1$');
CREATE TABLE test_merge AS test1 ENGINE = Merge('default', 'test1');
CREATE TABLE merge (n Int8) ENGINE = Merge('', lower('DISTRIBUTED'));
CREATE TABLE db.t_merge1 as db.t ENGINE=Merge('01902_db', '^t$');
CREATE TABLE merged as short ENGINE = Merge(currentDatabase(), 'short|long');
CREATE TABLE merge (id UInt64) ENGINE = Merge(currentDatabase(), '^mt[0-9]+$');
CREATE TABLE db.t_merge as db.t ENGINE=Merge(REGEXP('^01902_db'), '^t');
CREATE TABLE m (`a` String, `f` UInt8 DEFAULT 0) ENGINE = Merge(currentDatabase(), '^(t1|t2)$');
CREATE TABLE m (`a` String, `f` UInt8 EPHEMERAL 0) ENGINE = Merge(currentDatabase(), '^(t1|t2)$');
CREATE TABLE merge_table Engine=Merge(currentDatabase(), '^(table_to_merge_[a-z])$') AS table_to_merge_a;
CREATE TABLE t_merge AS t ENGINE = Merge('02111_modify_table_comment', 't') COMMENT 'this is a Merge table';

--File
create table test (x UInt64) engine=File(JSON);
CREATE TABLE file (number UInt64) ENGINE = File(TSV);
create table f(s String) engine File(TSV, '/dev/null');
create table test (number UInt64) engine=File('Parquet');
CREATE TABLE table_MySQLWire (x UInt64) ENGINE = File(MySQLWire);
CREATE TABLE file (s String, n UInt32) ENGINE = File(CSVWithNames);
CREATE TABLE table_tsv_01375 AS tmp_01375 ENGINE = File(TSVWithNames);
create table test_02312 (x UInt32) engine=File(ORC);
CREATE TABLE file (n Int8) ENGINE = File(upper('tsv') || 'WithNames' || 'AndTypes');
CREATE TABLE file_02184 (id UInt64, name String, dt Date) ENGINE = File(TabSeparated);
create table test (number UInt64) engine=File('Parquet', 'test_02155/test1/data.Parquet');
create table json(a int, b int default 7, c default a + b) engine File(JSONEachRow, 'data1622.json');
create table file_delim
(
    a int,
    b int
) engine File(CSV, '01545_url_file_format_settings.csv') settings format_csv_delimiter = '|';
create table test_02152
(
    x UInt32,
    y String,
    z Array(UInt32),
    t Tuple(UInt32,
    String,
    Array(UInt32))
) engine=File('CSV') settings format_csv_delimiter=';';
create table test_02152
(
    x UInt32,
    y String,
    z Array(UInt32),
    t Tuple(UInt32,
    String,
    Array(UInt32))
) engine=File('CustomSeparated')
settings format_custom_field_delimiter='<field_delimiter>',
format_custom_row_before_delimiter='<row_start>',
format_custom_row_after_delimiter='<row_end_delimiter>',
format_custom_escaping_rule='CSV';

--Null
create table t (a UInt64) Engine = Null;
CREATE TABLE {CLICKHOUSE_DATABASE:Identifier}.A (A UInt8) ENGINE = Null;
CREATE TABLE test
ENGINE = Null AS WITH (SELECT arrayReduce('sumMapState', [(['foo'], arrayMap(x -> -0., ['foo']))])) AS all_metrics SELECT (finalizeAggregation(arrayReduce('sumMapMergeState', [all_metrics])) AS metrics_tuple).1 AS metric_names, metrics_tuple.2 AS metric_values FROM system.one;

--Set
CREATE TABLE set (x String) ENGINE = Set;
CREATE TABLE set (val UInt64) ENGINE = Set() SETTINGS persistent=0;
create table set (s String) engine=Set as select arrayJoin(['src_table_1', 'src_table_2']);

--Join
CREATE TABLE kv (k UInt32, v UInt32) ENGINE Join(Any, Left, k);
CREATE TABLE j (id UInt8, val UInt8) Engine = Join(ALL, INNER, id);
CREATE TABLE t2 (key UInt64, a UInt64) ENGINE = Join(ALL, RIGHT, key);
CREATE TABLE left_join (x UInt32, s String) engine = Join(ALL, LEFT, x);
CREATE TABLE semi_left_join (x UInt32, s String) engine = Join(SEMI, LEFT, x);
CREATE TABLE anti_right_join (x UInt32, s String) engine = Join(ANTI, RIGHT, x);
CREATE TABLE t2 (s String, x Array(UInt8), k UInt64) ENGINE = Join(ANY, LEFT, k);
CREATE TABLE join (k UInt64, s String) ENGINE = Join(ANY, LEFT, k) SETTINGS persistent=0;
CREATE TABLE full_join (x UInt32, s String) engine = Join(ALL, FULL, x) SETTINGS join_use_nulls = 1;

--URL
create table test_table_url_syntax (id UInt32) ENGINE = URL('') ;
create table test_table_url(id UInt32) ENGINE = URL('http://localhost/endpoint') ;
create table test_table_url(id UInt32) ENGINE = URL('http://localhost/endpoint', 'JSONEachRow');
create table test_table_url(id UInt32) ENGINE = URL('http://localhost/endpoint', 'JSONEachRow', 'gz');
create table url
(
    i String
) engine=URL('http://127.0.0.1:8123?query=select+12', 'RawBLOB', headers('X-ClickHouse-Format'='JSONEachRow'));
CREATE TABLE url
(
    n UInt64,
    col String
) ENGINE=URL (replace ('https://localhost:8443/?query=' || 'select n, _table from ' || currentDatabase() || '.merge format CSV', ' ', '+'), CSV);

--Memory
-- не удалось воспроизвести нужно разобраться глебже в подобном синтаксисе
--create table t engine=Memory empty;
CREATE TABLE t2 AS t1 Engine=Memory;
CREATE TABLE t2 Engine=Memory AS t1;
create table m (n int) engine=Memory;
CREATE TABLE join (k UInt8, x String) ENGINE = Memory;
CREATE TABLE test(start Integer, end Integer) engine = Memory;
-- сломался после правки правил для представлений
--CREATE TABLE distinct (Num UInt32, Name String) ENGINE = Memory;
CREATE TABLE h3_indexes (id int, start String, end String) ENGINE = Memory;
CREATE TABLE mann_whitney_test (left Float64, right UInt8) ENGINE = Memory;
CREATE TABLE geo (a Point, b Ring, c Polygon, d MultiPolygon) ENGINE=Memory();
-- БД возвращает 
create table t02155_t64_tz (a DateTime64(9, 'America/Chicago')) Engine = Memory;
CREATE TABLE t1 (`n` Int8) ENGINE = Memory COMMENT 'this is a temtorary table';
CREATE TABLE table_with_cyclic_defaults (a DEFAULT b, b DEFAULT a) ENGINE = Memory;
CREATE TEMPORARY TABLE t_00477 (x Array(/* Hello */ UInt32 /* World */)) ENGINE = Memory;
create table t engine = Memory as with cte as (select * from numbers(10)) select * from cte;
CREATE TABLE IF NOT EXISTS {CLICKHOUSE_DATABASE:Identifier}.r2 (name String) Engine=Memory();
CREATE TABLE tuple ENGINE = Memory AS SELECT CAST((1, 'Test'), 'Tuple(a Int8, b String)') AS j;
create table defaulted (col1 Int8, col2 UInt64 default (SELECT dummy+99 from system.one)) engine=Memory;
CREATE TABLE polygons_01862 (key Array(Array(Array(Tuple(Float64, Float64)))), name String) ENGINE = Memory;
CREATE TABLE default_constraints (x UInt8, y UInt8 DEFAULT x + 1, CONSTRAINT c CHECK y < 5) ENGINE = Memory;
CREATE OR REPLACE TABLE test_query_log_factories_info1.memory_table (id BIGINT, date DATETIME) ENGINE=Memory();
CREATE TABLE t_constraints_where
(
    a UInt32,
    b UInt32,
    CONSTRAINT c1 ASSUME b >= 5,
    CONSTRAINT c2 ASSUME b <= 10
) ENGINE = Memory;
CREATE TABLE floats (a FLOAT, b FLOAT(12), c FLOAT(15, 22), d DOUBLE, e DOUBLE(12), f DOUBLE(4, 18)) engine=Memory;
CREATE TABLE ints
(
    a TINYINT,
    b TINYINT(8),
    c SMALLINT,
    d SMALLINT(16),
    e INT,
    f INT(32),
    g BIGINT,
    h BIGINT(64)
) engine=Memory;
create table model engine = Memory as select stochasticLogisticRegressionState(0.1, 0.0, 1.0, 'SGD')(target, param1, param2) as state from defaults;
CREATE TABLE test_table_nullable
(
    key UInt64,
    value Nullable(UInt16)
) ENGINE=Memory() AS SELECT number, number % 2 == 0 ? NULL : number FROM numbers(1e5);
CREATE TABLE IF NOT EXISTS decimal
(
    a DEC(9, 2),
    b DEC(18, 5),
    c DEC(38, 5),
    d Nullable(DEC(9, 4)),
    e Nullable(DEC(18, 8)),
    f Nullable(DEC(38, 8))
) engine = Memory;
CREATE TABLE database_for_dict.table_for_dict
(
    CompanyID String,
    OSType Enum('UNKNOWN' = 0, 'WINDOWS' = 1, 'LINUX' = 2, 'ANDROID' = 3, 'MAC' = 4),
    SomeID Int32
) engine = Memory();
CREATE TABLE dict_data
(
    key UInt64,
    v0 UInt16,
    v1 UInt16,
    v2 UInt16,
    v3 UInt16,
    v4 UInt16
) engine=Memory() AS SELECT number, number%65535, number%65535, number%6553, number%655355, number%65535 FROM numbers(1e6);
CREATE TABLE IF NOT EXISTS decimal
(
    a DECIMAL(9, 4) DEFAULT 0,
    b DECIMAL(18, 4) DEFAULT a / 2,
    c DECIMAL(38, 4) DEFAULT b / 3,
    d MATERIALIZED a + toDecimal32('0.2', 1),
    e ALIAS b * 2,
    f ALIAS c * 6
) engine = Memory;
create temporary table data
(
    id UInt64
) engine=Memory() as with [ 0, 1, 0x7f, 0x80, 0xff, 0x7fff, 0x8000, 0xffff, 0x7fffffff, 0x80000000, 0xffffffff, 0x7fffffffffffffff, 0x8000000000000000, 0xffffffffffffffff ] as values select arrayJoin(values) id;
CREATE TABLE unsigned_types
(
    a TINYINT SIGNED,
    b INT1 SIGNED,
    c SMALLINT SIGNED,
    d INT SIGNED,
    e INTEGER SIGNED,
    f BIGINT SIGNED,
    g TINYINT UNSIGNED,
    h INT1 UNSIGNED,
    i SMALLINT UNSIGNED,
    j INT UNSIGNED,
    k INTEGER UNSIGNED,
    l BIGINT UNSIGNED
) engine=Memory;
create table arrays_02735 engine = Memory as select * from generateRandom(' u32 Array(UInt32), i8 Array(Int8), datetime Array(DateTime), enum16 Array(Enum16(''xx'' = 1000, ''yy'' = 2000, ''zz'' = 3000)), float32 Array(Float32), str Array(String), fstr Array(FixedString(12)), u128 Array(UInt128), decimal64 Array(Decimal64(10)), ipv4 Array(IPv4), msi Map(String, Int16), tup Tuple(FixedString(3), Array(String), Map(Int8, Date))') limit 10000;

--Buffer
create table buf (n int) engine=Buffer(currentDatabase(), dist, 1, 10, 100, 10, 100, 1000, 1000);
CREATE TABLE mytable
(
    `a` UInt8
) ENGINE = Buffer(currentDatabase(), 'mytable_stored', 4, 600, 3600, 10, 100, 10000, 10000000);
CREATE TABLE test_buffer_table
(
    `a` Int64
) ENGINE = Buffer('', '', 1, 1000000, 1000000, 1000000, 1000000, 1000000, 1000000);
create table buffer_01277 as out_01277 Engine=Buffer(currentDatabase(), out_01277, 1, 86400, 86400, 1e5, 1e6, 10e6, 100e6);
create table buffer_01256 as system.numbers Engine=Buffer(currentDatabase(), data_01256, 1, 2, 100, /* time */ 4, 100, /* rows */ 1, 1e6 /* bytes */);
CREATE TABLE {CLICKHOUSE_DATABASE:Identifier}.mt_buffer_00158
(
    d Date DEFAULT today(),
    x UInt64
) ENGINE = Buffer({CLICKHOUSE_DATABASE:Identifier}, mt_00158, 16, 100, 100, 1000000, 1000000, 1000000000, 1000000000);

--GenerateRandom
CREATE TABLE t_random_1 (`ordinary_1` UInt32) ENGINE = GenerateRandom(1, 5, 3);

CREATE TABLE test_table_2
(
    a Array(Int8),
    d Decimal32(4),
    c Tuple(DateTime64(3, 'UTC'), UUID)
) ENGINE = GenerateRandom(10, 5, 3);
CREATE TABLE rng
(
    `user_id_raw` UInt64,
    `device_id_raw` UInt64,
    `domain_raw` UInt64,
    `bytes_raw` UInt64,
    `duration_raw` UInt64
) ENGINE = GenerateRandom(1024);

--KeeperMap
CREATE TABLE test
(
    key String,
    value UInt32
) Engine=KeeperMap('/' || currentDatabase() || '/test2416') PRIMARY KEY(key);
CREATE TABLE test
(
    key UInt64,
    value Float64
) Engine=KeeperMap('/' || currentDatabase() || '/test2418', 3) PRIMARY KEY(key);

--FileLog
CREATE TABLE log (A String) ENGINE= FileLog('/tmp/aaa.csv', 'CSV');

--OtherCases
CREATE TABLE t3 AS v;
CREATE TEMPORARY TABLE t3_00519 AS SELECT * FROM t1_00519;
CREATE TABLE test_table_noarg(str String) ENGINE = FuzzJSON('{}');
CREATE TABLE test_table_valid_args(str String) ENGINE = FuzzJSON('{"pet":"rat"}', NULL);
CREATE TABLE {CLICKHOUSE_DATABASE:Identifier}.tablefunc03 (a int) AS sqlite('db_path', 'table_name');
CREATE TABLE test_table (value String) ENGINE=ExecutablePool('nonexist.py', 'TabSeparated');
CREATE TABLE {CLICKHOUSE_DATABASE:Identifier}.tablefunc02 (x int) AS mysql('127.123.0.1:3306', 'mysql_db', 'mysql_table', 'mysql_user','123123');
CREATE TABLE {CLICKHOUSE_DATABASE:Identifier}.tablefunc04 (a int) AS mongodb('127.0.0.1:27017','test', 'my_collection', 'test_user', 'password', 'a Int');
CREATE TABLE {CLICKHOUSE_DATABASE:Identifier}.tablefunc01 (x int) AS postgresql('127.121.0.1:5432', 'postgres_db', 'postgres_table', 'postgres_user', '124444');
CREATE TABLE {CLICKHOUSE_DATABASE:Identifier}.tablefunc06 (a int) AS s3('http://some_addr:9000/cloud-storage-01/data.tsv', 'M9O7o0SX5I4udXhWxI12', '9ijqzmVN83fzD9XDkEAAAAAAAA', 'TSV');

--Alter
ALTER TABLE t FREEZE;
alter table ttl modify ttl a;
ALTER TABLE tbl DROP COLUMN a;
alter table x add column j int;
ALTER TABLE test CLEAR COLUMN z;
alter table ttl materialize ttl;
ALTER TABLE src DROP PARTITION 1;
alter table t attach partition 1;
alter table t detach partition 1;
ALTER TABLE prop_table REMOVE TTL;
alter table tp drop projection pp;
alter table rmt drop partition '0';
alter table t rename column j to k;
alter table mut delete where n = 10;
ALTER TABLE t MODIFY COMMENT 'World';
ALTER TABLE t1 MODIFY COLUMN a Int64;
ALTER TABLE tmp MATERIALIZE COLUMN s;
alter table tp_1 clear projection pp;
ALTER TABLE union2 MODIFY ORDER BY a;
alter table rmt1 update k = 0 where 0;
ALTER TABLE t ATTACH PART 'all_1_1_0';
ALTER TABLE t DETACH PART 'all_1_1_0';
ALTER TABLE test MATERIALIZE INDEX i1;
ALTER TABLE minmax_idx DROP INDEX idx1;
ALTER TABLE t MODIFY SAMPLE BY tuple();
alter table trunc detach partition all;
ALTER TABLE t1 ADD STATISTIC a TYPE xyz;
alter table rmt update n = n + 1 where 1;
ALTER TABLE test MATERIALIZE PROJECTION p1;
alter table tp drop projection if exists p;
ALTER TABLE dst ATTACH PARTITION 1 FROM src;
ALTER TABLE dst REPLACE PARTITION 1 FROM dst;
ALTER TABLE sqllt.table CLEAR COLUMN new_col;
ALTER TABLE t1 DROP STATISTIC a TYPE tdigest;
ALTER TABLE partslost_0 MATERIALIZE INDEX idx;
ALTER TABLE t RENAME COLUMN value1 TO value11;
ALTER TABLE tab ADD INDEX idx(vec) TYPE annoy;
ALTER TABLE test_table DROP INDEX value_index;
alter table ttl modify ttl d + interval 1 day;
ALTER TABLE join_table_mutation DELETE WHERE 1;
ALTER TABLE most_ordinary_mt RESET SETTING ttl;
ALTER TABLE t UPDATE s = 'goodbye' WHERE k = 1;
ALTER TABLE t UPDATE x = x - 1 WHERE x % 2 = 1;
ALTER TABLE t1 ADD STATISTIC a, b TYPE tdigest;
ALTER TABLE t_lwd_mutations APPLY DELETED MASK;
ALTER TABLE test ADD COLUMN x UInt32 default 0;
ALTER TABLE test MODIFY COLUMN x Enum8('' = 1);
ALTER TABLE t1 DROP STATISTIC a, b TYPE tdigest;
ALTER TABLE t_remove_sample_by REMOVE SAMPLE BY;
ALTER TABLE tab ADD INDEX idx(vec) TYPE usearch;
ALTER TABLE test CLEAR COLUMN x IN PARTITION '';
ALTER TABLE t MODIFY COMMENT 'MergeTree Table';
ALTER TABLE test DROP PARTITION {partition:Date};
ALTER TABLE test5 DROP PARTITION ({f:UInt32}, 2);
ALTER TABLE alter_test DROP COLUMN NestedColumn.S;
ALTER TABLE prewhere ADD COLUMN a1 String AFTER a;
ALTER TABLE test UPDATE d = d || '1' where x = 42;
alter table rmt replace partition id '0' from rmt2;
ALTER TABLE t_merge MODIFY COMMENT 'Merge Table';
alter table tmp update n = sleepEachRow(1) where 1;
alter table x add projection p_agg (select sum(j));
ALTER TABLE alter_test DROP COLUMN IF EXISTS ToDrop;
alter table mut drop column k settings alter_sync=0;
alter table rmt update s = 's'||toString(n) where 1;
alter table t add projection p (select uniqHLL12(x));
alter table t add projection x (select * order by j);
ALTER TABLE null_before ALTER COLUMN id TYPE INT NULL;
ALTER TABLE test MODIFY COLUMN `abc` String AFTER `id`;
ALTER TABLE table_two REPLACE PARTITION 0 FROM table_one;
ALTER TABLE minmax_compact CLEAR INDEX idx IN PARTITION 1;
alter table ttl materialize ttl settings mutations_sync=2;
ALTER TABLE data MATERIALIZE INDEX idx IN PARTITION ID '2';
ALTER TABLE t DELETE WHERE id in (select id from t as tmp);
ALTER TABLE test MODIFY SETTING clean_deleted_rows='Never';
alter table ttl modify column a Int ttl d + interval 1 day;
ALTER TABLE ttl_old_syntax MODIFY TTL toDate('2020-01-01');
ALTER TABLE test ADD COLUMN `xx` UInt32 MATERIALIZED arr[1];
ALTER TABLE test_alter MODIFY COLUMN x DEFAULT '2000-01-01';
ALTER TABLE add_table ADD COLUMN IF NOT EXISTS value1 UInt64;
alter table aliases_test modify column array alias [0, 1, 2];
ALTER TABLE sqllt.table MODIFY COLUMN new_col REMOVE COMMENT;
--нужно потестить этот кейс, если сработает
ALTER TABLE t MODIFY COMMENT 'World', MODIFY COLUMN x UInt16;
--alter table t_light drop index i_c SETTINGS mutations_sync=2;
ALTER TABLE alter_test ADD COLUMN IF NOT EXISTS Added0 UInt32;
--ALTER TABLE test6 DROP PARTITION {tuple:Tuple(UInt32, Int64)};
-- изменяем выражения матириализованного представления
ALTER TABLE alter_02834 MODIFY QUERY SELECT a FROM alter_02834;
ALTER TABLE mv MODIFY QUERY
  SELECT toStartOfDay(ts) ts, event_type, browser,
  count() events_cnt,
  sum(cost) cost
  FROM events
  GROUP BY ts, event_type, browser;
ALTER TABLE clear_column1 CLEAR COLUMN i IN PARTITION '200001';
ALTER TABLE compress_table MODIFY COLUMN value3 CODEC(Default);
ALTER TABLE prop_table MODIFY COLUMN column_alias REMOVE ALIAS;
alter table z add projection pp (select id, sum(c) group by id);
ALTER TABLE prop_table MODIFY COLUMN column_comment REMOVE COMMENT;
ALTER TABLE prop_table MODIFY COLUMN column_default REMOVE DEFAULT;
ALTER TABLE t_materialize_delete APPLY DELETED MASK IN PARTITION 5;
alter table mt_compact modify setting min_rows_for_wide_part = 1000;
--alter table t_light MATERIALIZE INDEX i_c SETTINGS mutations_sync=2;
alter table t_light update b=-1 where a<3 SETTINGS mutations_sync=2;
ALTER TABLE table_for_reset_setting RESET SETTING index_granularity;
alter table rmt2 update m = m * 10 where 1 settings mutations_sync=2;
--ALTER TABLE test DROP PROJECTION d_order SETTINGS mutations_sync = 2;
ALTER TABLE mt_with_pk ADD INDEX idx1 z + w TYPE minmax GRANULARITY 1;
ALTER TABLE alter_test ADD COLUMN IF NOT EXISTS AddedNested1.C Array(String);
ALTER TABLE replicated_constraints1 ADD CONSTRAINT b_constraint CHECK b > 10;
ALTER TABLE tmp_table_01818 MOVE PARTITION 'ClickHouse' TO TABLE main_table_01818;
ALTER TABLE test_move_partition_src MOVE PART '0_1_1_0' TO TABLE test_move_partition_dest;
alter table ttl modify column s String ttl i % 2 = 0 ? today() - 10 : toDate('2100-01-01');
ALTER TABLE sales ADD PROJECTION test (SELECT toInt64(COUNT(*)) GROUP BY PRODUCT_ID, DATE_SOLD);
ALTER TABLE table_for_alter MODIFY SETTING parts_to_throw_insert = 1, parts_to_delay_insert = 1;
alter table test_02381_compress modify setting compress_marks=false, compress_primary_key=false;
alter table x add index nn LOG2(i) type minmax granularity 1, add projection p2 (select MIN(i));
ALTER TABLE test4 ON CLUSTER 'test_shard_localhost' DROP PARTITION {partition:String} FORMAT Null;
ALTER TABLE alter_compression_codec1 MODIFY COLUMN alter_column CODEC(ZSTD, LZ4HC, LZ4, LZ4, NONE);
ALTER TABLE t_mutations_nondeterministic UPDATE v = (SELECT sum(number) FROM numbers(100)) WHERE 1;
--ALTER TABLE table_for_ttl MODIFY TTL d + INTERVAL 1 YEAR SETTINGS materialize_ttl_after_modify = 0;
ALTER TABLE table_with_cyclic_defaults ADD COLUMN c String DEFAULT b, ADD COLUMN b String DEFAULT c;
ALTER TABLE add_table ADD COLUMN IF NOT EXISTS value1 UInt64, ADD COLUMN IF NOT EXISTS value2 UInt64;
ALTER TABLE replicated_table_detach_all1 FETCH PARTITION ALL FROM '/clickhouse/tables/test_00753_{database}/replicated_table_detach_all1';
ALTER TABLE agg_table UPDATE agg_simple = 5 WHERE time BETWEEN toDateTime('2020-08-01 00:00:00') AND toDateTime('2020-12-01 00:00:00') SETTINGS mutations_sync = 2;
ALTER TABLE check_query_comment_column COMMENT COLUMN first_column 'comment 1_2', COMMENT COLUMN second_column 'comment 2_2', COMMENT COLUMN third_column 'comment 3_2';

--Drop
DROP TABLE nr;
DROP TABLE IF EXISTS "/t0";
DROP TEMPORARY TABLE constrained;
DROP TEMPORARY TABLE IF EXISTS t1;
DROP TABLE {CLICKHOUSE_DATABASE:Identifier}.wv;
DROP TABLE IF EXISTS db.example_complex_key_source;

--Optimize
OPTIMIZE TABLE table DEDUPLICATE; -- all columns
OPTIMIZE TABLE table DEDUPLICATE BY *; -- excludes MATERIALIZED and ALIAS columns
OPTIMIZE TABLE table DEDUPLICATE BY colX,colY,colZ;
OPTIMIZE TABLE table DEDUPLICATE BY * EXCEPT colX;
OPTIMIZE TABLE table DEDUPLICATE BY * EXCEPT (colX, colY);
OPTIMIZE TABLE table DEDUPLICATE BY COLUMNS('column-matched-by-regex');
OPTIMIZE TABLE table DEDUPLICATE BY COLUMNS('column-matched-by-regex') EXCEPT colX;
OPTIMIZE TABLE table DEDUPLICATE BY COLUMNS('column-matched-by-regex') EXCEPT (colX, colY);

