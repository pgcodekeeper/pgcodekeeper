CREATE DICTIONARY default.dict1
(
	`LocationID` UInt16 DEFAULT 0,
	`Borough` String,
	`Zone` String,
	`service_zone` String
)
PRIMARY KEY LocationID
SOURCE(HTTP(FORMAT 'CSVWithNames' URL 'https://datasets-documentation.s3.eu-west-3.amazonaws.com/nyc-taxi/taxi_zone_lookup.csv'))
LIFETIME(MIN 0 MAX 100)
LAYOUT(HASHED())
RANGE(MIN discount_start_date MAX discount_end_date)
COMMENT 'test';