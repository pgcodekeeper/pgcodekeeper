-- DEPCY: This STATISTICS stat1 depends on the COLUMN: [dbo].[t1].[col3]

DROP STATISTICS [dbo].[t1].[stat1]
GO

-- DEPCY: This STATISTICS stat2 depends on the COLUMN: [dbo].[t1].[col3]

DROP STATISTICS [dbo].[t1].[stat2]
GO

ALTER TABLE [dbo].[t1]
	DROP COLUMN [col3]
GO

CREATE STATISTICS [stat1] ON [dbo].[t1] ([col1], [col2])
WHERE ([col2]=(3))
GO