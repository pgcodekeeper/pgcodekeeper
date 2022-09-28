-- Assume that assembly binary is correct

CREATE ASSEMBLY [Hi] AUTHORIZATION [dbo]
FROM 0x4D5A900003 WITH PERMISSION_SET = SAFE
GO

CREATE PROCEDURE [dbo].[ext] @i1 [int],
@b1 [bit] = False, @b2 [bit] = False,
@f1 [float] READONLY, @f2 [float] = 0
WITH EXECUTE AS OWNER AS EXTERNAL NAME [Hi].[Hello].[returnValue]
GO 