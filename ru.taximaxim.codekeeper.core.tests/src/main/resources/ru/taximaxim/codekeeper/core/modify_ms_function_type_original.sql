SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[func]() 
RETURNS @t TABLE (c1 int NULL)
AS 
begin 
    insert @t
    SELECT c1 from test.mstable;
    return;
end
GO

--check INLINE option for MS2022
CREATE FUNCTION [dbo].[FooBar4](
    @p1 nVarchar(4000)
)
Returns int
WITH INLINE = ON
As
Begin
  return 123;
END
GO