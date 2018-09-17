REVOKE SELECT ON [dbo].[table1] ([c1]) FROM [test_user]
GO

-- COLUMN dbo.table1.c1 GRANT

GRANT UPDATE ON [dbo].[table1] ([c1]) TO [test_user]
GO
GRANT REFERENCES ON [dbo].[table1] ([c1]) TO [test_user]
GO

REVOKE SELECT ON [dbo].[table1] ([c2]) FROM [test_user]
GO

-- COLUMN dbo.table1.c2 GRANT

GRANT UPDATE ON [dbo].[table1] ([c2]) TO [test_user]
GO