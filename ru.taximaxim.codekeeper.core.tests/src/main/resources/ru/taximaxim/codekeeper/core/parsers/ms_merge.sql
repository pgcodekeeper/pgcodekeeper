
--https://docs.microsoft.com/en-us/sql/t-sql/statements/merge-transact-sql

MERGE Production.UnitMeasure AS target
USING (SELECT @UnitMeasureCode, @Name) AS src (UnitMeasureCode, Name)
ON (target.UnitMeasureCode = src.UnitMeasureCode)
WHEN MATCHED THEN
    UPDATE SET Name = src.Name
WHEN NOT MATCHED THEN
INSERT (UnitMeasureCode, Name)
VALUES (src.UnitMeasureCode, src.Name)
OUTPUT deleted.*, $action, inserted.* INTO #MyTempTable;

MERGE l
    USING ((SELECT @P, @C, @S) AS T (P, C, S)
            JOIN P ON T.P = P.ID
            JOIN C ON T.C = C.ID)
    ON MATCH (P-(l)->C)
WHEN NOT MATCHED THEN INSERT DEFAULT VALUES
WHEN MATCHED THEN UPDATE SET S = @S;
