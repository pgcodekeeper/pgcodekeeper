SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [bigint] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar] (100) COLLATE Cyrillic_General_CI_AS NOT NULL,
    [c4] [float] NOT NULL CONSTRAINT [qwer] DEFAULT ((14))
) ON [PRIMARY]
GO