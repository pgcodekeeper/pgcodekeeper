SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[func](@storeid int) 
RETURNS TABLE
AS  
RETURN   
(  
    SELECT @storeid as test
)
GO

--check INLINE option for MS2022
CREATE FUNCTION [dbo].[FooBar4](
    @p1 nVarchar(4000)
)
Returns int
WITH INLINE = OFF
As
Begin
  return 123;
END
GO