SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [uniqueidentifier] NULL,
    [c4] AS ([c1]+[c2]),
    [c5] [varchar] (50) COLLATE Cyrillic_General_CI_AS NULL,
    [c6] [varchar] (100) NULL,
    [c7] [int] MASKED WITH (FUNCTION = 'random(1, 12)') NULL,
    [c8] [int] IDENTITY(1,1) NOT NULL)
GO