ALTER TABLE [dbo].[table1]
	ADD [c4] [varchar](50) NOT NULL
GO

ALTER TABLE [dbo].[table1]
	ADD [c5] [int] MASKED WITH (FUNCTION = 'default()')
GO
