ALTER TABLE [dbo].[testtable2]
	DROP CONSTRAINT [cd3]
GO

ALTER TABLE [dbo].[testtable2]
	ALTER COLUMN [field3] [float] NOT NULL
GO
