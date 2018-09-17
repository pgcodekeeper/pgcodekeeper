SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1] (
    [c1] [integer] NOT NULL,
    [c2] [integer] NOT NULL
)
GO

GRANT UPDATE(c2), SELECT(c1, c2), REFERENCES(c1) ON [dbo].[table1] TO [test_user]
GO