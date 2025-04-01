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
ON [dbo].[table1]    --my trigger
AFTER UPDATE   
AS RAISERROR ('Edited Notify!', 16, 10)
GO

create table [dbo].[T1] (c1 integer, c2 text)
GO 

CREATE TRIGGER reminder2  
ON [dbo].[t1]
AFTER INSERT, UPDATE, DELETE
AS RAISERROR ('Notify Customer Relations', 16, 10);
GO