SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1] (
    [c1] [int]
)
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table2](
    [c1] [int] NOT NULL,
    [c2] [numeric] (18, 2) NOT NULL,
    [c3] [nvarchar] (max) COLLATE Cyrillic_General_CI_AS NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
WITH (DATA_COMPRESSION = PAGE)
GO


ALTER TABLE [dbo].[table2]
    ADD CONSTRAINT [PK_table2] PRIMARY KEY CLUSTERED  ([c1]) ON [PRIMARY]
GO

--add table with GENERATED ALWAYS AS ROW column type
CREATE TABLE [dbo].[Department21](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[ManagerID] [int] NULL,
	[ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[Startic] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
	[Endic] [datetime2] GENERATED ALWAYS AS ROW END,
	PERIOD FOR SYSTEM_TIME ([Startic], [Endic])
) ON [PRIMARY]
GO

--add table with GENERATED ALWAYS AS TRANSACTION ID column type
CREATE TABLE [dbo].[Department_transaction](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[DepartmentName] [varchar] (50) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
	[ManagerID] [int] NULL,
	[ParentDepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[StartTransactionId] [bigint] GENERATED ALWAYS AS TRANSACTION_ID START HIDDEN NOT NULL,
	[EndTransactionId] [bigint] GENERATED ALWAYS AS TRANSACTION_ID END HIDDEN NULL
) ON [PRIMARY]
GO

--add table with GENERATED ALWAYS AS SEQUENCE_NUMBER and other column type
CREATE TABLE [dbo].[Employees](
	[EmployeeID] [int] NOT NULL,
	[Salary] [money] NOT NULL,
	[StartTransactionId] [bigint] GENERATED ALWAYS AS TRANSACTION_ID START HIDDEN NOT NULL,
	[EndTransactionId] [bigint] GENERATED ALWAYS AS TRANSACTION_ID END HIDDEN NULL,
	[StartSequenceNumber] [bigint] GENERATED ALWAYS AS SEQUENCE_NUMBER START NOT NULL,
	[EndSequenceNumber] [bigint] GENERATED ALWAYS AS SEQUENCE_NUMBER END NULL,
	[ValidFrom] [datetime2] GENERATED ALWAYS AS ROW START NOT NULL,
	[ValidTo] [datetime2] GENERATED ALWAYS AS ROW END,
	PERIOD FOR SYSTEM_TIME ([ValidTo], [ValidFrom])
) ON [PRIMARY]
GO