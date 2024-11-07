ALTER TABLE [dbo].[testtable2]
	DROP COLUMN [c2]
GO

ALTER TABLE [dbo].[testtable2]
	ADD [c2] AS ([c1]*(2))
GO
