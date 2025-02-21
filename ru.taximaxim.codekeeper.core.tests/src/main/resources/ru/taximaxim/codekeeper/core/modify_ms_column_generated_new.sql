SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
--changed GENERATED type on TRANSACTION_ID
CREATE TABLE [dbo].[test_gen1](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidTo] [bigint] GENERATED ALWAYS AS TRANSACTION_ID START NOT NULL,
	[ValidFrom] [bigint] GENERATED ALWAYS AS TRANSACTION_ID END NULL
) ON [PRIMARY]
GO

--change cols on GENERATED type TRANSACTION_ID
CREATE TABLE [dbo].[test_trans](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[tranx_1] [bigint] GENERATED ALWAYS AS TRANSACTION_ID END NULL,
	[tranx_2] [bigint] GENERATED ALWAYS AS TRANSACTION_ID START NOT NULL
) ON [PRIMARY]
GO

--change cols on GENERATED type SEQUENCE_NUMBER
CREATE TABLE [dbo].[test_seq_gen](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[seq_1] [bigint] GENERATED ALWAYS AS SEQUENCE_NUMBER START HIDDEN NOT NULL,
	[seq_2] [bigint] GENERATED ALWAYS AS SEQUENCE_NUMBER END HIDDEN NULL
) ON [PRIMARY]
GO

--removed GENERATED type SEQUENCE_NUMBER
CREATE TABLE [dbo].[test_gen2](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidTo] [bigint] NOT NULL,
	[ValidFrom] [bigint] NULL
) ON [PRIMARY]
GO

--remove GENERATED type TRANSACTION_ID
CREATE TABLE [dbo].[test_tranxaction](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[tranx_1] [bigint] NOT NULL,
	[tranx_2] [bigint] NULL
) ON [PRIMARY]
GO

--add HIDDEN option and change NULL
CREATE TABLE [dbo].[test_change_hidden](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[tranx_1] [bigint] GENERATED ALWAYS AS TRANSACTION_ID START HIDDEN NOT NULL,
	[tranx_2] [bigint] GENERATED ALWAYS AS TRANSACTION_ID END HIDDEN NOT NULL
) ON [PRIMARY]
GO

--changed cols on GENERATED type ROW. We drop all generated cols if change any col
CREATE TABLE [dbo].[test_new_row](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidTo] [datetime2] GENERATED ALWAYS AS ROW START NOT NULL,
	[ValidFrom] [datetime2] GENERATED ALWAYS AS ROW END NOT NULL,
	PERIOD FOR SYSTEM_TIME ([ValidTo], [ValidFrom])
) ON [PRIMARY]
GO

--changed cols on GENERATED type TRANSACTION_ID
CREATE TABLE [dbo].[test_row](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidTo] [bigint] GENERATED ALWAYS AS TRANSACTION_ID START HIDDEN NOT NULL,
	[ValidFrom ] [bigint] GENERATED ALWAYS AS TRANSACTION_ID END NULL
) ON [PRIMARY]
GO

--change cols GENERATED type ROW
CREATE TABLE [dbo].[test_change_to_row244](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[NewColStart] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
	[NewColEnd] [datetime2] GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
	PERIOD FOR SYSTEM_TIME ([NewColStart], [NewColEnd])
) ON [PRIMARY]
GO

--add and change to simple cols from GENERATED type ROW
CREATE TABLE [dbo].[Department4](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[ManagerID] [int] NULL,
	[ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidFrom] [datetime2] NOT NULL,
	[NewCol] [datetime2] NOT NULL,
) ON [PRIMARY]
GO

--changed GENERATED TRANSACTION_ID col to GENERATED ROW 
CREATE TABLE [dbo].[Department_new](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
    [ValidTo] [datetime2] GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
    PERIOD FOR SYSTEM_TIME ([ValidFrom], [ValidTo])
) ON [PRIMARY]
GO

--change GENERATED ROW col to simle col
CREATE TABLE [dbo].[Department5](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] NULL,
    [ValidTo] [datetime2] NULL
) ON [PRIMARY]
GO

--change simple col to GENERATED ROW 
CREATE TABLE [dbo].[Department6](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
    [ValidTo] [datetime2] GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
    PERIOD FOR SYSTEM_TIME ([ValidFrom], [ValidTo])
) ON [PRIMARY]
GO

--change simple col to GENERATED ROW and add new generated col
CREATE TABLE [dbo].[Department7](
    [DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
    [ManagerID] [int] NULL,
    [ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
    [ValidFrom] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
    [ValidTo] [datetime2] GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
    PERIOD FOR SYSTEM_TIME ([ValidFrom], [ValidTo])
)
GO