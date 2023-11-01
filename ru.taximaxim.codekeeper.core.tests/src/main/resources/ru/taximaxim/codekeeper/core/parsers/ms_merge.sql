
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

MERGE dbo.Table1 AS T
    USING @Participation AS S
    ON (T.Id = S.Id)
    WHEN MATCHED AND S.ParticipationCount = 0 THEN
        DELETE
    WHEN MATCHED AND S.ParticipationCount <> T.ParticipationCount THEN
        UPDATE SET T.ParticipationCount = S.ParticipationCount,
                   T.Date = CURRENT_TIMESTAMP
    WHEN NOT MATCHED BY TARGET AND S.ParticipationCount > 0 THEN
        INSERT (Id, ParticipationCount)
        VALUES (S.Id, S.ParticipationCount)
    OUTPUT CASE WHEN $action = 'INSERT' THEN @Added
      WHEN $action = 'UPDATE' THEN @Updated
      WHEN $action = 'DELETE' THEN @Deleted
      END AS OperationId,
      CASE WHEN $action IN ('INSERT', 'UPDATE') THEN Inserted.Id
      WHEN $action = 'DELETE' THEN DELETED.FirmId
      END AS FirmId,
      CASE WHEN $action IN ('INSERT', 'UPDATE') THEN Inserted.ParticipationCount
      WHEN $action = 'DELETE' THEN DELETED.ParticipationCount
      END AS ParticipationCount;
