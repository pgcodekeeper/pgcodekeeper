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

CREATE TABLE [dbo].[t2](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] NOT NULL,
    [ValidTo] [datetime2] NOT NULL,
    [col1] [int]
) ON [PRIMARY]
WITH (SYSTEM_VERSIONING = ON (HISTORY_TABLE = [dbo].[TemporalHistoryFor_t2]))
GO

ALTER TABLE [dbo].[t2]
    ADD CONSTRAINT [PK_t2] PRIMARY KEY CLUSTERED ([DepartmentNumber]) ON [PRIMARY]
GO

ALTER TABLE [dbo].[t2]
    ADD CONSTRAINT [UK_t2] UNIQUE ([col1]) ON [PRIMARY]
GO

CREATE TABLE [dbo].[t3](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] NOT NULL,
    [ValidTo] [datetime2] NOT NULL,
) ON [PRIMARY]
WITH (SYSTEM_VERSIONING = ON (HISTORY_TABLE = [dbo].[TemporalHistoryFor_t3]))
GO

ALTER TABLE [dbo].[t3]
    ADD CONSTRAINT [PK_t3] PRIMARY KEY CLUSTERED ([DepartmentNumber]) ON [PRIMARY]
GO

CREATE TABLE [dbo].[t4](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] NOT NULL,
    [ValidTo] [datetime2] NOT NULL,
) ON [PRIMARY]
WITH (SYSTEM_VERSIONING = ON (HISTORY_TABLE = [dbo].[TemporalHistoryFor_t4], HISTORY_RETENTION_PERIOD = 3 WEEK))
GO

ALTER TABLE [dbo].[t4]
    ADD CONSTRAINT [PK_t4] PRIMARY KEY CLUSTERED ([DepartmentNumber]) ON [PRIMARY]
GO