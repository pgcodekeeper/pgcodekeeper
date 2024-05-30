CREATE TABLE default.source_table
(
	`id` UInt64 NOT NULL,
	`value_first` String NOT NULL,
	`value_second` Nullable(String)
)
ENGINE = TinyLog;

CREATE DICTIONARY default.dict
(
	id UInt64,
	value_first String DEFAULT 'value_first_default',
	value_second Nullable(String) DEFAULT 'value_second_default'
)
PRIMARY KEY id
SOURCE(CLICKHOUSE(PORT 9000 HOST 'localhost' USER 'default' TABLE 'source_table'))
LAYOUT(CACHE(SIZE_IN_CELLS 10))
LIFETIME(MIN 1 MAX 1000);