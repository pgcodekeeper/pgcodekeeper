ALTER TABLE [dbo].[t1]
	ADD [c3] [int]
GO

EXEC sys.sp_refreshsqlmodule '[dbo].[v1]'
GO

EXEC sys.sp_refreshsqlmodule '[dbo].[v2]'
GO

EXEC sys.sp_refreshsqlmodule '[dbo].[v3]'
GO

EXEC sys.sp_refreshsqlmodule '[dbo].[v4]'
GO