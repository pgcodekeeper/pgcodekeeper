CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [varchar](100) NOT NULL)
GO

CREATE FUNCTION [dbo].[ReturnOperResult](@First int, @Second int) 
RETURNS integer
AS
BEGIN
  DECLARE @Res integer = 0
  
  SET @Res = @First - @Second + 1

  IF @Res < 0
    SET @Res = 0
  
  RETURN @Res
END
GO