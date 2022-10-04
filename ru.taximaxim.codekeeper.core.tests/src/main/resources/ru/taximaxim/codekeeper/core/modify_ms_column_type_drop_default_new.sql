SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[testtable](
    [field1] [int] NULL,
    [field2] [int] NULL,
    [field3] [int] NOT NULL CONSTRAINT [cd] DEFAULT (7),
    [field4] [float] NULL
) ON [PRIMARY]
GO