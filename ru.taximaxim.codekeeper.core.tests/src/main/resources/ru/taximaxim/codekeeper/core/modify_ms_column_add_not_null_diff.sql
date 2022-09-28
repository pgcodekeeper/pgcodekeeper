UPDATE [dbo].[testtable]
	SET [field3] = DEFAULT WHERE [field3] IS NULL
GO

ALTER TABLE [dbo].[testtable]
	ALTER COLUMN [field3] [varchar] (150) COLLATE Cyrillic_General_CI_AS NOT NULL
GO
