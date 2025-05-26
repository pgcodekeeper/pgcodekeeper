SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[testtable](
	[a1] [nchar] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[a2] [char] (100) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[a3] [nchar] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[a4] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY]
GO

CREATE TYPE [dbo].[ttt] FROM [char]
GO