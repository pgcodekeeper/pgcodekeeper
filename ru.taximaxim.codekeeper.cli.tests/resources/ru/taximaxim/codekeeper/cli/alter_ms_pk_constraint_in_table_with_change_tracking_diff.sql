ALTER TABLE [dbo].[test_table] DISABLE CHANGE_TRACKING
GO

ALTER TABLE [dbo].[test_table]
	DROP CONSTRAINT [PK_test_table]
GO

-- HIDDEN: Object [dbo].[test_table] of type TABLE (action: ALTER, reason: object type is not in allowed types list)

ALTER TABLE [dbo].[test_table]
	ADD CONSTRAINT [PK_test_table] PRIMARY KEY CLUSTERED  ([name]) ON [PRIMARY]
GO

ALTER TABLE [dbo].[test_table] ENABLE CHANGE_TRACKING WITH (TRACK_COLUMNS_UPDATED = OFF)
GO

