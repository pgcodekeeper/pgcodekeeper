SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[test_table] (
    [id] [bigint],
    [date_deleted] [datetime])
GO

ALTER AUTHORIZATION ON OBJECT::[dbo].[test_table] TO [ms_user];    
GO

CREATE NONCLUSTERED INDEX [IX_test_table_date_deleted] ON [dbo].[test_table] ([date_deleted]) WHERE (date_deleted IS NULL)
GO

REVOKE SELECT ON SCHEMA::[dbo] FROM [ms_user]
GO

REVOKE UPDATE ON SCHEMA::[dbo] FROM [ms_user]
GO

REVOKE DELETE ON SCHEMA::[dbo] FROM [ms_user]
GO

REVOKE INSERT ON SCHEMA::[dbo] FROM [ms_user]
GO

GRANT SELECT ON SCHEMA::[dbo] TO [ms_user]
GO

GRANT UPDATE ON SCHEMA::[dbo] TO [ms_user]
GO

GRANT DELETE ON SCHEMA::[dbo] TO [ms_user]
GO

GRANT INSERT ON SCHEMA::[dbo] TO [ms_user]
GO