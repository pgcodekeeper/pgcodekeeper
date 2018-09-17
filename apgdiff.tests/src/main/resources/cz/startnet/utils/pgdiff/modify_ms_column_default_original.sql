SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[testtable] (
    [c1] [int] NULL CONSTRAINT [DF_testtable] DEFAULT ((1)),
    [c2] [int] NOT NULL
)
GO
