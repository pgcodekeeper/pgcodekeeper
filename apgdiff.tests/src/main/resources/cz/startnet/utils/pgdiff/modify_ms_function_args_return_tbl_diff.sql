DROP FUNCTION [dbo].[ReturnOperResult]
GO

SET QUOTED_IDENTIFIER OFF
GO
SET ANSI_NULLS OFF
GO
CREATE FUNCTION [dbo].[ReturnOperResult](@First int, @Second int) 
RETURNS TABLE
AS
RETURN   
(  
    SELECT @First AS 'First', @Second AS 'Second', (@First + @Second) AS 'Sum'  
)
GO