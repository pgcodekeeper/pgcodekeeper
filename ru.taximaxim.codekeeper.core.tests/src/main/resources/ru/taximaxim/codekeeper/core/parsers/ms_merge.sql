
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

MERGE livesIn
    USING ((SELECT @PersonId, @CityId, @StreetAddress) AS T (PersonId, CityId, StreetAddress)
            JOIN Person ON T.PersonId = Person.ID
            JOIN City ON T.CityId = City.ID)
    ON MATCH (Person-(livesIn)->City)
WHEN MATCHED THEN
    UPDATE SET StreetAddress = @StreetAddress
WHEN NOT MATCHED THEN
    INSERT (from_id, to_id, StreetAddress)
    VALUES (Person.node_id, City.node_id, treetAddress) ;

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
      END AS ParticipationCount
    OPTION (HASH GROUP);

MERGE dbo.Sen WITH (HOLDLOCK) AS Target
    USING Source
    ON Source.SId = Target.SId
    WHEN NOT MATCHED BY SOURCE AND Target.TrId = @TrId THEN DELETE
    WHEN MATCHED THEN UPDATE SET Target.SName = Source.SName,
                                 Target.UnactivateDate = Source.UnactivateDate,
                         Target.SHostId = Source.SHostId
    WHEN NOT MATCHED THEN
        INSERT (SName,
                PId,
                FId)
        VALUES (Source.SName, Source.PId, Source.UnactivateDate, Source.FId);
