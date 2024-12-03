-- DEPCY: This PROCEDURE p1 is a dependency of FUNCTION: [dbo].[f2]

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE PROCEDURE [dbo].[p1] (  
@p1 smallint = 42,   
@p2 char(1),   
@p3 varchar(8) = 'CAR')  
AS   
   SET NOCOUNT ON;  
   SELECT @p1, @p2, @p3;
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[f2]() 
RETURNS smallint
AS
BEGIN
  EXECUTE [dbo].[p1] @p2 = 'A';

  RETURN 3;
END
GO