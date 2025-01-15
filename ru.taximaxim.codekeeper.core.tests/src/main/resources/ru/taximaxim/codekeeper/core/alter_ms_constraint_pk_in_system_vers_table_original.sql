SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[Department](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
    [ValidTo] [datetime2] GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
    PERIOD FOR SYSTEM_TIME ([ValidFrom], [ValidTo])
) ON [PRIMARY]
WITH ( SYSTEM_VERSIONING = ON (HISTORY_TABLE = [dbo].[MSSQL_TemporalHistoryFor_Department], HISTORY_RETENTION_PERIOD = 3 WEEK))
GO

ALTER TABLE [dbo].[Department]
    ADD CONSTRAINT [PK__Departme__718447F87C145BBF] PRIMARY KEY CLUSTERED  ([DepartmentNumber]) ON [PRIMARY]
GO

CREATE TABLE [dbo].[MSSQL_TemporalHistoryFor_Department](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[ManagerID] [int] NULL,
	[ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidFrom] [datetime2] NOT NULL,
	[ValidTo] [datetime2] NOT NULL
) ON [PRIMARY]
WITH (DATA_COMPRESSION = PAGE)
GO

--------------------------------------------------------------------------------

CREATE CLUSTERED INDEX [ix_MSSQL_TemporalHistoryFor_Department] ON [dbo].[MSSQL_TemporalHistoryFor_Department] ([ValidTo], [ValidFrom])
WITH (DATA_COMPRESSION = PAGE)
ON [PRIMARY]
GO
