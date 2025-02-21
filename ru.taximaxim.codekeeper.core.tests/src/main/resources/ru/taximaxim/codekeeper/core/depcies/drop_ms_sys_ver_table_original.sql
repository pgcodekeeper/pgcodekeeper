SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[hist_t1](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] NOT NULL,
    [ValidTo] [datetime2] NOT NULL,
    [col1] [int] NULL
) ON [PRIMARY]
WITH (DATA_COMPRESSION = PAGE)
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[t1](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
    [ValidTo] [datetime2] GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
    [col1] [int] NULL,
    PERIOD FOR SYSTEM_TIME ([ValidFrom], [ValidTo])
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[t1]
    ADD CONSTRAINT [PK__Departme__718447F8BF74033C] PRIMARY KEY CLUSTERED  ([DepartmentName]) ON [PRIMARY]
GO

ALTER TABLE [dbo].[t1] SET (SYSTEM_VERSIONING = ON (HISTORY_TABLE = [dbo].[hist_t1], HISTORY_RETENTION_PERIOD = 3 WEEK))
GO