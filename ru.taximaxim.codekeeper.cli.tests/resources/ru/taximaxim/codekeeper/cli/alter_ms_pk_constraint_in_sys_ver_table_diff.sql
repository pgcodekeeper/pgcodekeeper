ALTER TABLE [dbo].[Department2] SET (SYSTEM_VERSIONING = OFF)
GO

ALTER TABLE [dbo].[Department2]
	DROP CONSTRAINT [pk_1]
GO

-- HIDDEN: Object [dbo].[Department2] of type TABLE (action: ALTER, reason: object type is not in allowed types list)

ALTER TABLE [dbo].[Department2]
	ADD CONSTRAINT [pk_1] PRIMARY KEY CLUSTERED  ([DepartmentName]) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Department2] SET (SYSTEM_VERSIONING = ON (HISTORY_TABLE = [dbo].[MSSQL_TemporalHistoryFor_Department2]))
GO

