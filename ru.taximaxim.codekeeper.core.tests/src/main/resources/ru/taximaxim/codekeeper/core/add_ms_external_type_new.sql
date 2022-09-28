-- Assume that assembly binary is correct
CREATE ASSEMBLY [Point]
AUTHORIZATION [dbo]
FROM 0x4D5A900003
GO

CREATE TYPE [dbo].[Point] EXTERNAL NAME [Point].[Point]
GO