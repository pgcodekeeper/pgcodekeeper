SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar](100) NOT NULL)
GO

CREATE NONCLUSTERED INDEX [index_table1] ON [dbo].[table1] ([c1] ASC, [c2] DESC)
GO