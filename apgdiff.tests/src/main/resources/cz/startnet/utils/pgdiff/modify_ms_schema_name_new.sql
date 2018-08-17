CREATE SCHEMA [super]
GO

CREATE TABLE [super].[table1](
    [c1] [int] NOT NULL,
    [c2] [varchar](100) NULL)
GO

ALTER TABLE [super].[table1] 
    ADD CONSTRAINT [PK_table1] PRIMARY KEY CLUSTERED  ([c1]) ON [PRIMARY]
GO