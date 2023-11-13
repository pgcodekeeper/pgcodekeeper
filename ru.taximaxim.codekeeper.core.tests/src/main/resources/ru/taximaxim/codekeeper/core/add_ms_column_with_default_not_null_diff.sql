ALTER TABLE [dbo].[table1]
	ADD [c4] [float]
GO

ALTER TABLE [dbo].[table1]
	ADD CONSTRAINT [qwer] DEFAULT ((14)) FOR [c4]
GO

UPDATE [dbo].[table1]
	SET [c4] = DEFAULT WHERE [c4] IS NULL
GO

ALTER TABLE [dbo].[table1]
	ALTER COLUMN [c4] [float] NOT NULL
GO
