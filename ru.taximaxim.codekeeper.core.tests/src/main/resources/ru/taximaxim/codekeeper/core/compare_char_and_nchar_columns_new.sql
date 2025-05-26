SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[testtable](
	[a1] [nchar] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[a2] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[a3] [nchar] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[a4] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]
GO

CREATE TYPE [dbo].[ttt] FROM [char] (1)
GO