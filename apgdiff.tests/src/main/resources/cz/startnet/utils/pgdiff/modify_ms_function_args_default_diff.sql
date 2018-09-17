SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
ALTER FUNCTION [dbo].[ReturnOperResult](@First int, @Second int = 777, @Third int) 
RETURNS integer
AS
BEGIN
  DECLARE @Res integer = 0;
  
  SET @Res = @Second - @First + @Third;

  IF @Res < 0
    SET @Res = 0;
  
  RETURN @Res;
END
GO
