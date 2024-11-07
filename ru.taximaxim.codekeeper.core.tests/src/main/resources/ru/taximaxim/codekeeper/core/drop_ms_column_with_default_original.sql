SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[Tab](
	[Id] [int] NOT NULL IDENTITY (1,1),
	[AnyData] [nvarchar] (50) COLLATE Cyrillic_General_CI_AS NULL,
	[DefData] [nvarchar] (50) COLLATE Cyrillic_General_CI_AS NOT NULL CONSTRAINT [DF_Tab_DefData] DEFAULT ('Test')
) ON [PRIMARY]
GO