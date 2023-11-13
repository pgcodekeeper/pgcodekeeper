ALTER TABLE [dbo].[testtable]
	DROP CONSTRAINT [DF_testtable]
GO

ALTER TABLE [dbo].[testtable]
	ADD CONSTRAINT [DF_testtable] DEFAULT ((2)) FOR [c1]
GO
