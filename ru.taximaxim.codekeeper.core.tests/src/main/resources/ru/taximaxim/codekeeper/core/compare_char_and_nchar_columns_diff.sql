ALTER TABLE [dbo].[testtable]
	ALTER COLUMN [a1] [nchar] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
GO

ALTER TABLE [dbo].[testtable]
	ALTER COLUMN [a2] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
GO