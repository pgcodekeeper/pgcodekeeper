DROP TABLE [dbo].[table1]
GO

-- DEPCY: This TABLE is a dependency of COLUMN: dbo.table1.c4

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
	[c1] [bigint] NOT NULL,
	[c2] [int] NOT NULL,
	[c3] [varchar](100) NOT NULL,
	[c4] [varchar](50) NOT NULL
) ON [PRIMARY]
GO
