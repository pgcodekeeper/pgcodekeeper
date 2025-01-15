CREATE TABLE [dbo].[t1](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] NOT NULL,
    [ValidTo] [datetime2] NOT NULL,
) ON [PRIMARY]
WITH (SYSTEM_VERSIONING = ON (HISTORY_TABLE = [dbo].[TemporalHistoryFor_t1]))
GO

ALTER TABLE [dbo].[t1]
    ADD CONSTRAINT [PK_t1] PRIMARY KEY CLUSTERED ([DepartmentNumber]) ON [PRIMARY]
GO
