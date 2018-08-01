-- COLUMN dbo.testtable.c1 GRANT

GRANT SELECT ON [dbo].[testtable] ([c1]) TO test_user
GO
GRANT REFERENCES ON [dbo].[testtable] ([c1]) TO test_user
GO

-- COLUMN dbo.testtable.c2 GRANT

GRANT UPDATE ON [dbo].[testtable] ([c2]) TO test_user
GO
GRANT SELECT ON [dbo].[testtable] ([c2]) TO test_user
GO