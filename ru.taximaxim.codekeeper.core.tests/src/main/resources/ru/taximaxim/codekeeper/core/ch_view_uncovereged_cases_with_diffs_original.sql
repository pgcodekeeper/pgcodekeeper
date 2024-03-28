CREATE VIEW default.v_c_2
(
    `s` UInt8,
    `col1` Int64,
    `col2` Int64
) AS
SELECT 1 AS s;

CREATE VIEW default.v_i_2
(
    `s` UInt8,
    `col1` Int64,
    `col2` Int64
) AS
SELECT 1 AS s;

CREATE VIEW default.v_c_3
(
    `s` UInt8,
    `col1` Int64,
    `col2` Int64,
    CONSTRAINT c_3 CHECK col1 > 1
) AS
SELECT 1 AS s;

CREATE VIEW default.v_i_3
(
    `s` UInt8,
    `col1` Int64,
    `col2` Int64,
    INDEX i_3 col1 TYPE minmax GRANULARITY 1
) AS
SELECT 1 AS s;