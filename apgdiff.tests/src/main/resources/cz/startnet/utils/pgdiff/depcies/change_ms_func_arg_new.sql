SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[f1] (@first nvarchar(5), @second integer) 
RETURNS integer
AS
BEGIN
  return 1;
END
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[f2] (@first integer) 
RETURNS integer
AS
BEGIN
  return dbo.f1 ('ts', 4);
END
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[f3] (@first integer) 
RETURNS integer
AS
BEGIN
  return dbo.f2 (4);
END
GO