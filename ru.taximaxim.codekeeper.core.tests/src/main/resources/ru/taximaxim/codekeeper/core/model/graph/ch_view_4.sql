CREATE TABLE default.join_inner_table
(
	`id` UUID NOT NULL,
	`key` String NOT NULL,
	`number` Int64 NOT NULL,
	`value1` String NOT NULL,
	`value2` String NOT NULL,
	`v1` String NOT NULL,
	`v2` String NOT NULL,
	`time` Int64 NOT NULL
)
ENGINE = MergeTree
ORDER BY (id, number, key)
SETTINGS index_granularity = 8192;

CREATE VIEW default.view_join_inner_table
(
	`key` String NOT NULL,
	`value1` String NOT NULL,
	`value2` String NOT NULL,
	`start_ts` UInt64 NOT NULL
)
AS SELECT key, 
		value1, 
		value2, 
		toUInt64(min(time)) AS start_ts 
FROM default.join_inner_table 
PREWHERE (id = '833c9e22-c245-4eb5-8745-117a9a1f26b1') AND (number > toUInt64('1610517366120')) 
GROUP BY key, v2 
ORDER BY key ASC, v1 ASC 
LIMIT 10;