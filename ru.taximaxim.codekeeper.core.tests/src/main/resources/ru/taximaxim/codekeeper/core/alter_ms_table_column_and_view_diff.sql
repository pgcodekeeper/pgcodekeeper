ALTER TABLE [dbo].[testtable]
	ADD [a2] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
ALTER VIEW [dbo].[testview]
AS
SELECT [a1], [a2]
FROM [testtable] alias
GO