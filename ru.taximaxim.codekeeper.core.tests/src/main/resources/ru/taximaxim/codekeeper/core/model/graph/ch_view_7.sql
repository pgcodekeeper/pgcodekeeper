CREATE TABLE default.hits (
	CounterID Int64,
	hits String,
	visits String
) ENGINE = MergeTree()
ORDER BY CounterID; 

CREATE TABLE default.visits (
	CounterID Int64,
	hits String,
	Sign String
) ENGINE = MergeTree()
ORDER BY CounterID;

CREATE VIEW default.ch_view_7
AS SELECT
    CounterID,
    hits,
    visits
FROM
(
    SELECT
        CounterID,
        count() AS hits
    FROM default.hits
    GROUP BY CounterID
) ANY LEFT JOIN
(
    SELECT
        CounterID,
        sum(Sign) AS visits
    FROM default.visits
    GROUP BY CounterID
) USING CounterID
ORDER BY hits DESC
LIMIT 10;