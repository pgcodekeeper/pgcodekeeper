SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[t1](
	[DepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[ManagerID] [int] NULL,
	[ParentDepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidFrom] [datetime2] NOT NULL,
	[ValidTo] [datetime2] NOT NULL
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[t1]
	ADD CONSTRAINT [PK_t1] PRIMARY KEY CLUSTERED  ([DepartmentNumber]) ON [PRIMARY]
GO

ALTER TABLE [dbo].[t1] SET (SYSTEM_VERSIONING = ON (HISTORY_TABLE = [dbo].[TemporalHistoryFor_t1]))
GO