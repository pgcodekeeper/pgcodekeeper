CREATE TABLE dbo.firms_test (firmId INT, nameRus NVARCHAR(100) NULL, CONSTRAINT PK_firms_test PRIMARY KEY CLUSTERED (firmId))
GO

CREATE NONCLUSTERED INDEX [IX_firms_test_firmId_nameRus] ON [dbo].[firms_test] ([firmId], [nameRus]) WITH (ONLINE = ON)
GO

CREATE VIEW dbo.v_search_firms_test
WITH SCHEMABINDING
AS
SELECT firmId, nameRus
FROM dbo.firms_test
GO

CREATE UNIQUE CLUSTERED INDEX PK_search_firms_test ON dbo.v_search_firms_test (firmId ASC)
GO