CREATE TABLE [dbo].[t1](
	[b] [int] NULL,
	[a] [int] NULL,
	[c] AS ([a]+[b])
) ON [test1fg]
GO

CREATE TABLE [dbo].[t2](
	[b] [int] NULL,
	[a] [int] NOT NULL IDENTITY (1,1),
	[c] AS ([a]+[b])
) ON [test1fg]
GO