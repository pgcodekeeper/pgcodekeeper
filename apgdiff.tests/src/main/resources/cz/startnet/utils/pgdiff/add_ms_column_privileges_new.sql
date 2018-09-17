SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[testtable] (
    [c1] [integer] NOT NULL,
    [c2] [integer] NOT NULL
)
GO

GRANT UPDATE(c2), SELECT(c1, c2), REFERENCES(c1) ON [dbo].[testtable] TO [test_user]
GO