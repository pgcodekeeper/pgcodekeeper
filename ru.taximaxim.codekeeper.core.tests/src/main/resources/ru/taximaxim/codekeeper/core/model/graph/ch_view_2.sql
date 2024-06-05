CREATE TABLE default.Test_00584 (
    str String,
    key Enum8('A' = 0, 'B' = 1, 'ALL' = 2),
    a Int64
)
ENGINE = MergeTree()
ORDER BY str;
        
CREATE VIEW default.TestView AS
    SELECT str, key, sumIf(a, 0) AS sum
    FROM Test_00584
    GROUP BY str, key

    UNION ALL

    SELECT str AS str, CAST('ALL' AS Enum8('A' = 0, 'B' = 1, 'ALL' = 2)) AS key, sumIf(a, 0) AS sum
    FROM Test_00584
    GROUP BY str;