SET QUOTED_IDENTIFIER OFF
GO
SET ANSI_NULLS OFF
GO
ALTER PROCEDURE [dbo].[ext]
@i1 [int],
@b1 [bit] = False,
@b2 [bit] = True,
@f1 [float] = 0,
@f2 [float] = 0
WITH EXECUTE AS CALLER
AS
EXTERNAL NAME [Hi].[Hello].[returnValue]
GO