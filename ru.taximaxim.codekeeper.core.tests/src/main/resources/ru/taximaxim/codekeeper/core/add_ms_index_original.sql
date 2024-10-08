SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar](100) NOT NULL)
GO

-- test clusterd columnstore index
CREATE TABLE [dbo].[table0](
	[col1] [int] NULL
) ON [PRIMARY]
WITH (DATA_COMPRESSION = COLUMNSTORE)
GO

-- test nonclusterd columnstore index
CREATE TABLE [dbo].[table3](
	[col1] [int] NULL,
	[col2] [int] NULL,
	[col3] [int] NULL
) ON [PRIMARY]
GO

--create table with COLUMNSTORE index with ORDER columns in table(MSSQL 2022)
CREATE TABLE [dbo].[table6](
	[col1] [int] NULL,
	[col2] [int] NULL,
	[col3] [int] NULL
) ON [PRIMARY]
WITH (DATA_COMPRESSION = COLUMNSTORE)
GO
