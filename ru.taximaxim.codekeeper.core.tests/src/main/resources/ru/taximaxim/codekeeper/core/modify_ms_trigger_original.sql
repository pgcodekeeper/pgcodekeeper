SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [bigint] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar](100) NOT NULL)
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TRIGGER [trigger1]  
ON [dbo].[table1]  
AFTER INSERT, UPDATE   
AS RAISERROR ('Notify!', 16, 11)
GO

create table [dbo].[T1] (c1 integer, c2 text)
GO 

CREATE TRIGGER reminder2  
ON [dbo].[T1]
AFTER INSERT, UPDATE, DELETE
AS RAISERROR ('Notify Customer Relations', 16, 10);
GO