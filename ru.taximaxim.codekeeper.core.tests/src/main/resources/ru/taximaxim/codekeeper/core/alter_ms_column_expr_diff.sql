-- DEPCY: This COLUMN c depends on the COLUMN: [dbo].[t1].[a]

ALTER TABLE [dbo].[t1]
	DROP COLUMN [c]
GO

ALTER TABLE [dbo].[t1]
	DROP COLUMN [a]
GO

-- DEPCY: This COLUMN c depends on the COLUMN: [dbo].[t2].[a]

ALTER TABLE [dbo].[t2]
	DROP COLUMN [c]
GO

ALTER TABLE [dbo].[t2]
	DROP COLUMN [a]
GO

ALTER TABLE [dbo].[t1]
	ADD [a] [int]
GO

ALTER TABLE [dbo].[t1]
	ADD [c] AS ([a]+[b])
GO

ALTER TABLE [dbo].[t2]
	ADD [a] [int] IDENTITY (1,1) NOT NULL
GO

ALTER TABLE [dbo].[t2]
	ADD [c] AS ([a]+[b])
GO