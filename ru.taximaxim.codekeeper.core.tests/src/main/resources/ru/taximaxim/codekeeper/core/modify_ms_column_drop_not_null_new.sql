SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[testtable](
    [field1] [int] NULL,
    [field2] [int] NULL,
    [field3] [varchar] (150) COLLATE Cyrillic_General_CI_AS NULL CONSTRAINT [cd] DEFAULT (N'none'),
    [field4] [float] NULL
) ON [PRIMARY]
GO