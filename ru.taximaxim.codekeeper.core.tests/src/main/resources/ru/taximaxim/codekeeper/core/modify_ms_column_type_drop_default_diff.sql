ALTER TABLE [dbo].[testtable]
	DROP CONSTRAINT [cd]
GO

ALTER TABLE [dbo].[testtable]
	ALTER COLUMN [field3] [int]
GO

ALTER TABLE [dbo].[testtable]
	ADD CONSTRAINT [cd] DEFAULT (7) FOR [field3]
GO

UPDATE [dbo].[testtable]
	SET [field3] = DEFAULT WHERE [field3] IS NULL
GO

ALTER TABLE [dbo].[testtable]
	ALTER COLUMN [field3] [int] NOT NULL
GO
