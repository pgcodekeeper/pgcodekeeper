REVOKE SELECT ON [dbo].[table1] ([c1]) FROM [test_user]
GO

GRANT UPDATE ON [dbo].[table1] ([c1]) TO [test_user]
GO

GRANT REFERENCES ON [dbo].[table1] ([c1]) TO [test_user]
GO

REVOKE SELECT ON [dbo].[table1] ([c2]) FROM [test_user]
GO

GRANT UPDATE ON [dbo].[table1] ([c2]) TO [test_user]
GO