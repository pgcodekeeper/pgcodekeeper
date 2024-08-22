SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar](100) NOT NULL)
GO

ALTER TABLE [dbo].[table1]
    ADD CONSTRAINT [constraint_check_c2] CHECK (c2 > 20)
GO

ALTER TABLE [dbo].[table1]
    ADD CONSTRAINT [constraint_default_c2] DEFAULT 100 FOR c2
GO

CREATE TABLE [dbo].[table2](
    [c1] [int] NOT NULL,
    [c2] [varchar](100) NULL
    CONSTRAINT [PK_table2] PRIMARY KEY NONCLUSTERED
(
	[c1] ASC
))
GO

ALTER TABLE [dbo].[table2] ENABLE CHANGE_TRACKING WITH (TRACK_COLUMNS_UPDATED = ON)
GO