CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [varchar](100) NOT NULL)
GO

CREATE FUNCTION [dbo].[ReturnOperResult](@First int, @Second int) 
RETURNS TABLE
AS
RETURN   
(  
    SELECT @First AS 'First', @Second AS 'Second', (@First + @Second) AS 'Sum'  
)
GO