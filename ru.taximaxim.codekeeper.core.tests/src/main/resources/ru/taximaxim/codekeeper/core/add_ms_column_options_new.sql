SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [uniqueidentifier] NULL ROWGUIDCOL,
    [c4] AS ([c1]+[c2]) PERSISTED,
    [c5] [varchar] (50) COLLATE Cyrillic_General_CI_AS SPARSE NULL,
    [c6] [varchar] (100) MASKED WITH (FUNCTION = 'partial(1, "XXX''XXXX", 0)') NULL,
    [c7] [int] MASKED WITH (FUNCTION = 'default()') NULL,
    [c8] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL)
GO