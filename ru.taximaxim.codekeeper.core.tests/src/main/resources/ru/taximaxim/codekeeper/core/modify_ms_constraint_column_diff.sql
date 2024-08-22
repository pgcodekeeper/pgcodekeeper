ALTER TABLE [dbo].[table1]
	DROP CONSTRAINT [constraint_default_c2]
GO

ALTER TABLE [dbo].[table1]
	ADD CONSTRAINT [constraint_default_c2] DEFAULT 100 FOR [c2]
GO

ALTER TABLE [dbo].[table1]
	DROP CONSTRAINT [constraint_check_c2]
GO

ALTER TABLE [dbo].[table2] DISABLE CHANGE_TRACKING
GO

ALTER TABLE [dbo].[table2]
	DROP CONSTRAINT [PK_table2]
GO

ALTER TABLE [dbo].[table1]
	ADD CONSTRAINT [constraint_check_c2] CHECK  (c2 > 20)
GO

ALTER TABLE [dbo].[table2]
	ADD CONSTRAINT [PK_table2] PRIMARY KEY NONCLUSTERED  ([c1])
GO

ALTER TABLE [dbo].[table2] ENABLE CHANGE_TRACKING WITH (TRACK_COLUMNS_UPDATED = ON)
GO