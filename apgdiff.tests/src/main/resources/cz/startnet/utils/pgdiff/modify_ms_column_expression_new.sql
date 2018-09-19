SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[testtable2](
    [c1] [int] NOT NULL,
    [c2] AS ([c1]*(2))
)
GO
