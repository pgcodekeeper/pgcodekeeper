-- Assume that assembly binary is correct

CREATE ASSEMBLY [Hi] AUTHORIZATION [dbo]
FROM 0x4D5A900003 WITH PERMISSION_SET = SAFE
GO

CREATE PROCEDURE [dbo].[ext]
AS EXTERNAL NAME [Hi].[Hello].[returnValue]
GO