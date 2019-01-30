SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[f1](
@p1 smallint = 42,   
@p2 char(1),   
@p3 varchar(8) = 'CAR') 
RETURNS integer
AS
BEGIN
  RETURN @p1;
END
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[f2]() 
RETURNS smallint
AS
BEGIN
  DECLARE @ret smallint;  

  EXECUTE @ret = [dbo].[f1] 68, 'A';

  RETURN @ret;
END
GO