DROP FUNCTION [dbo].[func]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
--check INLINE option for MS2022
ALTER FUNCTION [dbo].[FooBar4](
    @p1 nVarchar(4000)
)
Returns int
WITH INLINE = OFF
As
Begin
  return 123;
END
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[func](@storeid int) 
RETURNS TABLE
AS  
RETURN   
(  
    SELECT @storeid as test
)
GO