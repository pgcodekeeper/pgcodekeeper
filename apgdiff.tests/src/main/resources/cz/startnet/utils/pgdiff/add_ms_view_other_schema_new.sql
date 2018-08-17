CREATE SCHEMA [tester]
GO

CREATE TABLE [tester].[table1](
    [c1] [int] NOT NULL,
    [c2] [varchar](100) NOT NULL)
GO

CREATE VIEW [dbo].[view1] AS
    SELECT 
    a.[c1],
    a.[c2]
FROM [tester].[table1] a
GO