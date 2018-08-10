ALTER TABLE [dbo].[table1]
	DROP CONSTRAINT [constraint_check_c2]
GO

ALTER TABLE [dbo].[table1]
	ADD CONSTRAINT [constraint_check_c2] CHECK (c2 > 20)
GO



ALTER TABLE [dbo].[table1]
	DROP CONSTRAINT [constraint_default_c2]
GO

ALTER TABLE [dbo].[table1]
	ADD CONSTRAINT [constraint_default_c2] DEFAULT 100 FOR c2
GO
