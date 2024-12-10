CREATE STATISTICS [stat2] ON [dbo].[t6] ([col1], [col2], [col3])
WITH SAMPLE 100 PERCENT, PERSIST_SAMPLE_PERCENT = ON
GO

CREATE STATISTICS [stat3] ON [dbo].[t6] ([col1], [col2], [col3])
WITH SAMPLE 16 PERCENT, PERSIST_SAMPLE_PERCENT = ON
GO

CREATE STATISTICS [stat1] ON [dbo].[t6] ([col1], [col2])
GO

CREATE STATISTICS [stat2] ON [dbo].[t4] ([col1], [col2])
WHERE (col2=(2))
WITH AUTO_DROP = ON
GO

CREATE STATISTICS [stat1] ON [dbo].[t4] ([col1], [col2])
WHERE (col2=(2))
WITH NORECOMPUTE
GO

CREATE STATISTICS [stat1] ON [dbo].[PartitionTable] ([col1], [col2])
WITH INCREMENTAL = ON
GO