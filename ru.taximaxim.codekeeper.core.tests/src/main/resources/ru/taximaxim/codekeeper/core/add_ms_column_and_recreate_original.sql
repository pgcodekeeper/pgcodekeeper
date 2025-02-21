SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [bigint] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar](100) NOT NULL)
ON [SECOND]
GO

--recreate table with generated cols
CREATE TABLE [dbo].[test_change_to_row3](
	[DepartmentNumber] [char] COLLATE SQL_Latin1_General_CP1_CI_AS NULL,
	[ValidTo] [datetime2] GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
	[ValidFrom] [datetime2] GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
	PERIOD FOR SYSTEM_TIME ([ValidTo], [ValidFrom])
) ON [PRIMARY]
GO