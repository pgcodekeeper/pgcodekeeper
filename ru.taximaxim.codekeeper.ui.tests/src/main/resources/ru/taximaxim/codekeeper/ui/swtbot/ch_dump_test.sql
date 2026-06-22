create table default.t (`n` Int32) engine MergeTree order by n;

CREATE TABLE default.rptable (`x` UInt8) ENGINE = MergeTree ORDER BY x;

CREATE TABLE default.pk_order (a Int32, b Int32) ENGINE = MergeTree ORDER BY a / b;

CREATE TABLE default.binary_op_mono1(`i` Int32, `j` Int32) ENGINE MergeTree PARTITION BY toDate(i / 1000) ORDER BY j;

CREATE VIEW default.mv_00472
(
	`n` Int32
)
AS SELECT *
FROM default.t;

CREATE FUNCTION function AS () -> 5;

CREATE FUNCTION plusthree AS (a) -> (a + 3);

CREATE TABLE default.constraint_constant_number_expression
(
    `id` UInt64,
    CONSTRAINT `c0` CHECK 1,
    CONSTRAINT `c1` CHECK 1 < 2,
    CONSTRAINT `c2` CHECK CAST(NULL, 'Nullable(UInt8)') IS NULL
) engine = TinyLog();

CREATE DICTIONARY default.test_dictionary (   `id` UInt64,   `value` String ) PRIMARY KEY id LAYOUT(FLAT()) SOURCE(CLICKHOUSE(TABLE 'dictionary_source_table')) LIFETIME(MIN 0 MAX 0);

CREATE DICTIONARY default.test_dictionary2 (   `id` UInt64,   `value` Date32 ) PRIMARY KEY id SOURCE(CLICKHOUSE(TABLE 'test_table')) LAYOUT(DIRECT());