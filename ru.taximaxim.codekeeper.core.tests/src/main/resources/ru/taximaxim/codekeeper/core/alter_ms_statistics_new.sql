CREATE TABLE [dbo].[t6](
    [col1] [int] NULL,
    [col2] [int] NULL,
    [col3] [int] NULL
) ON [PRIMARY]
GO

CREATE STATISTICS stat1 ON [dbo].[t6] (col1, col2, col3)
WITH SAMPLE 16 PERCENT, PERSIST_SAMPLE_PERCENT = ON;

CREATE STATISTICS stat2 ON [dbo].[t6] (col1, col2, col3)
WITH FULLSCAN;

CREATE STATISTICS stat3 ON [dbo].[t6] (col1, col2)
WHERE (col2=(5))
WITH NORECOMPUTE;

CREATE STATISTICS stat4 ON [dbo].[t6] (col1, col2, col3)
WHERE (col2=(2)) WITH AUTO_DROP = ON;