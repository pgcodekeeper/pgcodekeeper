ALTER TABLE [dbo].[testtable]
	ALTER COLUMN [c1] DROP CONSTRAINT DF_testtable
GO

ALTER TABLE [dbo].[testtable]
	ALTER COLUMN [c1] ADD CONSTRAINT [DF_testtable] DEFAULT ((2))
GO
