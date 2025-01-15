CREATE TABLE [dbo].[MSSQL_TemporalHistoryFor_Department2](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] NOT NULL,
    [ValidTo] [datetime2] NOT NULL
) ON [PRIMARY]
WITH (DATA_COMPRESSION = PAGE)
GO

CREATE CLUSTERED INDEX [ix_MSSQL_TemporalHistoryFor_Department2] ON [dbo].[MSSQL_TemporalHistoryFor_Department2] ([ValidTo], [ValidFrom])
WITH (DATA_COMPRESSION = PAGE)
ON [PRIMARY]
GO

CREATE TABLE [dbo].[Department2](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
    [ValidTo] [datetime2] GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
    PERIOD FOR SYSTEM_TIME ([ValidFrom], [ValidTo])
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Department2] SET (SYSTEM_VERSIONING = ON (HISTORY_TABLE = [dbo].[MSSQL_TemporalHistoryFor_Department2]))
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[Department2]
    ADD CONSTRAINT [pk_1] PRIMARY KEY CLUSTERED  ([DepartmentNumber]) ON [PRIMARY]
GO

