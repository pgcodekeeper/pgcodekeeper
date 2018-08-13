SET QUOTED_IDENTIFIER OFF
GO
SET ANSI_NULLS OFF
GO
ALTER FUNCTION [dbo].[ReturnOperResult](@Second int, @First int) 
RETURNS integer
AS
BEGIN
  DECLARE @Res integer = 0
  
  SET @Res = @Second - @First + 2

  IF @Res < 0
    SET @Res = 0
  
  RETURN @Res
END
GO
