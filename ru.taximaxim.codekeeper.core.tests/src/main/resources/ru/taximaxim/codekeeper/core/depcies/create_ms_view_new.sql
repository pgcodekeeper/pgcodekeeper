CREATE TABLE [dbo].[Ms table 2](
    [Col1] [int] NULL
) ON [PRIMARY]
GO

CREATE VIEW [dbo].[v1] as select * from [dbo].[ms table 2]
GO
