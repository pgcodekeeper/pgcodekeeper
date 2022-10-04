SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
ALTER FUNCTION [dbo].[ReturnOperResult](@Second int, @First int) 
RETURNS integer
AS
BEGIN
  DECLARE @Res integer = 0;
  
  SET @Res = @Second - @First + 2;

  IF @Res < 0
    SET @Res = 0;
  
  RETURN @Res;
END
GO
