SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[f2] (@first integer) 
RETURNS integer
AS
BEGIN
  return dbo.f1 (@first);
END
GO