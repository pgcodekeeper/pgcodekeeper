CREATE TABLE [dbo].[t1](
    [col1] [int] NULL,
    [col2] [int] NULL
) ON [PRIMARY]
GO

CREATE STATISTICS ContactMail999 ON [dbo].[t1] (col1, col2)
WITH SAMPLE 16 PERCENT, PERSIST_SAMPLE_PERCENT = ON
GO

CREATE STATISTICS stat1 ON [dbo].[t1] (col1, col2)
WHERE ([col2]=(3))
GO