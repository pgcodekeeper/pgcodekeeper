DROP TABLE [dbo].[test_row]
GO

DROP TABLE [dbo].[test_change_to_row244]
GO

DROP TABLE [dbo].[Department4]
GO

DROP TABLE [dbo].[test_new_row]
GO

DROP TABLE [dbo].[Department_new]
GO

DROP TABLE [dbo].[Department5]
GO

DROP TABLE [dbo].[Department6]
GO

DROP TABLE [dbo].[Department7]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[test_row](
	[DepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidTo] [bigint] GENERATED ALWAYS AS TRANSACTION_ID START HIDDEN NOT NULL,
	[ValidFrom ] [bigint] GENERATED ALWAYS AS TRANSACTION_ID END NULL
) ON [PRIMARY]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[test_change_to_row244](
	[DepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[NewColStart] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
	[NewColEnd] [datetime2] GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
	PERIOD FOR SYSTEM_TIME ([NewColStart], [NewColEnd])
) ON [PRIMARY]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[Department4](
	[DepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[ManagerID] [int] NULL,
	[ParentDepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidFrom] [datetime2] NOT NULL,
	[NewCol] [datetime2] NOT NULL
) ON [PRIMARY]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[Department7](
	[DepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[ManagerID] [int] NULL,
	[ParentDepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidFrom] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
	[ValidTo] [datetime2] GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
	PERIOD FOR SYSTEM_TIME ([ValidFrom], [ValidTo])
)
GO

ALTER TABLE [dbo].[test_gen1]
	DROP COLUMN [ValidTo]
GO

ALTER TABLE [dbo].[test_gen1]
	DROP COLUMN [ValidFrom]
GO

ALTER TABLE [dbo].[test_trans]
	DROP COLUMN [tranx_1]
GO

ALTER TABLE [dbo].[test_trans]
	DROP COLUMN [tranx_2]
GO

ALTER TABLE [dbo].[test_seq_gen]
	DROP COLUMN [seq_1]
GO

ALTER TABLE [dbo].[test_seq_gen]
	DROP COLUMN [seq_2]
GO

ALTER TABLE [dbo].[test_gen2]
	DROP COLUMN [ValidTo]
GO

ALTER TABLE [dbo].[test_gen2]
	DROP COLUMN [ValidFrom]
GO

ALTER TABLE [dbo].[test_tranxaction]
	DROP COLUMN [tranx_1]
GO

ALTER TABLE [dbo].[test_tranxaction]
	DROP COLUMN [tranx_2]
GO

ALTER TABLE [dbo].[test_change_hidden]
	DROP COLUMN [tranx_1]
GO

ALTER TABLE [dbo].[test_change_hidden]
	DROP COLUMN [tranx_2]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[test_new_row](
	[DepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidTo] [datetime2] GENERATED ALWAYS AS ROW START NOT NULL,
	[ValidFrom] [datetime2] GENERATED ALWAYS AS ROW END NOT NULL,
	PERIOD FOR SYSTEM_TIME ([ValidTo], [ValidFrom])
) ON [PRIMARY]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[Department_new](
	[DepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[ManagerID] [int] NULL,
	[ParentDepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidFrom] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
	[ValidTo] [datetime2] GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
	PERIOD FOR SYSTEM_TIME ([ValidFrom], [ValidTo])
) ON [PRIMARY]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[Department5](
	[DepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[ManagerID] [int] NULL,
	[ParentDepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidFrom] [datetime2] NULL,
	[ValidTo] [datetime2] NULL
) ON [PRIMARY]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[Department6](
	[DepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[ManagerID] [int] NULL,
	[ParentDepartmentNumber] [char] (1) COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidFrom] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
	[ValidTo] [datetime2] GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
	PERIOD FOR SYSTEM_TIME ([ValidFrom], [ValidTo])
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[test_gen1]
	ADD [ValidTo] [bigint] GENERATED ALWAYS AS TRANSACTION_ID START NOT NULL
GO

ALTER TABLE [dbo].[test_gen1]
	ADD [ValidFrom] [bigint] GENERATED ALWAYS AS TRANSACTION_ID END
GO

ALTER TABLE [dbo].[test_trans]
	ADD [tranx_1] [bigint] GENERATED ALWAYS AS TRANSACTION_ID END
GO

ALTER TABLE [dbo].[test_trans]
	ADD [tranx_2] [bigint] GENERATED ALWAYS AS TRANSACTION_ID START NOT NULL
GO

ALTER TABLE [dbo].[test_seq_gen]
	ADD [seq_1] [bigint] GENERATED ALWAYS AS SEQUENCE_NUMBER START HIDDEN NOT NULL
GO

ALTER TABLE [dbo].[test_seq_gen]
	ADD [seq_2] [bigint] GENERATED ALWAYS AS SEQUENCE_NUMBER END HIDDEN
GO

ALTER TABLE [dbo].[test_gen2]
	ADD [ValidTo] [bigint] NOT NULL
GO

ALTER TABLE [dbo].[test_gen2]
	ADD [ValidFrom] [bigint]
GO

ALTER TABLE [dbo].[test_tranxaction]
	ADD [tranx_1] [bigint] NOT NULL
GO

ALTER TABLE [dbo].[test_tranxaction]
	ADD [tranx_2] [bigint]
GO

ALTER TABLE [dbo].[test_change_hidden]
	ADD [tranx_1] [bigint] GENERATED ALWAYS AS TRANSACTION_ID START HIDDEN NOT NULL
GO

ALTER TABLE [dbo].[test_change_hidden]
	ADD [tranx_2] [bigint] GENERATED ALWAYS AS TRANSACTION_ID END HIDDEN NOT NULL
GO