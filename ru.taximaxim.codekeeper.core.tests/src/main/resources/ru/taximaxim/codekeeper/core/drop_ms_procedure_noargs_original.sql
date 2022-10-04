CREATE TABLE [dbo].[table1](
    [c1] [bigint] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar](100) NOT NULL)
GO

CREATE PROCEDURE [dbo].[proc1]
AS
SET NOCOUNT ON;  
    SELECT t.[c1], t.[c2], t.[c3]  
    FROM [dbo].[table1] t;
GO