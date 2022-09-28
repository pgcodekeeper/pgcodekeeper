SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[ReturnSum](@First int, @Second int) 
RETURNS integer
AS
BEGIN
  DECLARE @Res integer = 0;
  
  SET @Res = @First + @Second;

  IF @Res < 0
    SET @Res = 0;
  
  RETURN @Res;
END
GO