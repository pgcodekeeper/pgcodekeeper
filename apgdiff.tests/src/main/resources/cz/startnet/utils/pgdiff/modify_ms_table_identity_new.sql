CREATE TABLE [dbo].[testtable] (
    [c1] [int] NOT NULL IDENTITY(2, 1) NOT FOR REPLICATION,
    [c2] [varchar] (100) NOT NULL COLLATE Cyrillic_General_CI_AS NULL
);
