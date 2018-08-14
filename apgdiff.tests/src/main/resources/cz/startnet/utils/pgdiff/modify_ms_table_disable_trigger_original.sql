CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [varchar](100) NOT NULL)
GO

CREATE TRIGGER [dbo].[trig1]
ON [dbo].[table1] 
FOR INSERT  
AS  
IF 100000 > 0  
BEGIN  
    print 'TRIG1 Error: you attempted to insert a c1 > 100000'  
    ROLLBACK TRANSACTION  
END
GO