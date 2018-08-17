CREATE TABLE [dbo].[table1] (
    [c1] [int]
)
GO

CREATE SCHEMA [tester];  
GO; 

CREATE TABLE [tester].[table2](
    [c1] [int] NOT NULL,
    [c2] [varchar](100) NULL)
GO

ALTER TABLE [tester].[table2] 
    ADD CONSTRAINT [PK_table2] PRIMARY KEY CLUSTERED  ([c1]) ON [PRIMARY]
GO