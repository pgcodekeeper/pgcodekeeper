CREATE TABLE [dbo].[test_table](
    [id] [int] NOT NULL IDENTITY (1,1),
    [name] [nvarchar] (100) COLLATE Cyrillic_General_CI_AS NOT NULL
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[test_table] ENABLE CHANGE_TRACKING WITH (TRACK_COLUMNS_UPDATED = OFF)
GO

ALTER TABLE [dbo].[test_table]
    ADD CONSTRAINT [PK_test_table] PRIMARY KEY CLUSTERED  ([id]) ON [PRIMARY]
GO
