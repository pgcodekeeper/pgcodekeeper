CREATE TABLE default.visits
(
    `CounterID` UInt32,
    `StartDate` Date,
    `StartTime` DateTime,
    `GoalsID` Array(UInt32),
    `GID` UInt32,
    `Sign` Int8
)
ENGINE = Null;


CREATE MATERIALIZED VIEW default.goal_view TO default.goal
(
    `CounterID` UInt32,
    `StartDate` Date,
    `GoalID` UInt32,
    `Visits` AggregateFunction(sumIf, Int8, UInt8),
    `GoalReaches` AggregateFunction(sum, Int8)
) AS
SELECT
    CounterID,
    StartDate,
    sumIfState(Sign, _uniq = 1) AS Visits,
    sumState(Sign) AS GoalReaches
FROM default.visits
ARRAY JOIN
    GoalsID AS GoalID,
    arrayEnumerateUniq(GID) AS _uniq
GROUP BY
    CounterID,
    StartDate
ORDER BY
    CounterID ASC,
    StartDate ASC;

CREATE TABLE default.goal
(
     `CounterID` UInt32,
     `StartDate` Date,
     `GoalID` UInt32,
     `Visits` AggregateFunction(sumIf, Int8, UInt8),
     `GoalReaches` AggregateFunction(sum, Int8)
) ENGINE = AggregatingMergeTree PARTITION BY toStartOfMonth(StartDate) ORDER BY (CounterID, StartDate, GoalID) SETTINGS index_granularity = 256, index_granularity_bytes = '10Mi';