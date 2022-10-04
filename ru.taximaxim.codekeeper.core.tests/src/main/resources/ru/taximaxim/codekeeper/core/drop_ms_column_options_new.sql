SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [uniqueidentifier] NULL,
    [c4] AS ([c1]+[c2]),
    [c5] [varchar] (50) COLLATE Cyrillic_General_CI_AS NULL)
GO