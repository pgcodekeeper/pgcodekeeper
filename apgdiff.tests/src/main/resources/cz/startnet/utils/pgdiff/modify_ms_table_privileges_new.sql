CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [varchar](100) NULL
)
GO

GRANT UPDATE ON [dbo].[table1] TO [test_user]
GO