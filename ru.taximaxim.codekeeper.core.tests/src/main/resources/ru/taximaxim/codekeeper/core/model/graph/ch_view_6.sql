CREATE TABLE default.columns_transformers
(
	`i` Int32 NOT NULL,
	`j` Int32 NOT NULL,
	`k` Int32 NOT NULL,
	`a_bytes` Int32 NOT NULL,
	`b_bytes` Int32 NOT NULL,
	`c_bytes` Int32 NOT NULL
)
ENGINE = TinyLog;

CREATE VIEW default.view_columns_transformers
AS SELECT * EXCEPT 'bytes', COLUMNS('bytes') APPLY formatReadableSize FROM default.columns_transformers;