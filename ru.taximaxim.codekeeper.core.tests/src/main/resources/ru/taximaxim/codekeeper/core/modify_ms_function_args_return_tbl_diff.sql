DROP FUNCTION [dbo].[ReturnOperResult]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[ReturnOperResult](@First int, @Second int) 
RETURNS TABLE
AS
RETURN   
(  
    SELECT @First AS 'First', @Second AS 'Second', (@First + @Second) AS 'Sum'  
)
GO