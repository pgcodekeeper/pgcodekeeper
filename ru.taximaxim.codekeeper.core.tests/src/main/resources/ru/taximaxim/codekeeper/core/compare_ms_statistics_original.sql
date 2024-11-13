CREATE TABLE [dbo].[t6](
    [col1] [int] NULL,
    [col2] [int] NULL,
    [col3] [int] NULL
) ON [PRIMARY]
GO

CREATE STATISTICS stat1 ON [dbo].[t6] (col1, col2);

CREATE STATISTICS stat2 ON [dbo].[t6] (col1, col2, col3)
WITH FULLSCAN;