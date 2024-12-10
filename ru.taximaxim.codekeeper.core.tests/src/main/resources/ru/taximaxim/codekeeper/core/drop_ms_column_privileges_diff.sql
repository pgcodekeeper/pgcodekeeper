REVOKE SELECT ON [dbo].[table1] ([c1]) FROM [test_user]
GO

REVOKE REFERENCES ON [dbo].[table1] ([c1]) FROM [test_user]
GO

REVOKE UPDATE ON [dbo].[table1] ([c2]) FROM [test_user]
GO

REVOKE SELECT ON [dbo].[table1] ([c2]) FROM [test_user]
GO