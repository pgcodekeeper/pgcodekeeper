CREATE TABLE [dbo].[table1] (
    [c1] [int] NOT NULL,
    [c2] [varchar] (100) NOT NULL)
GO

ALTER TABLE [dbo].[table1] SET (LOCK_ESCALATION = AUTO);  
GO 