-- DEPCY: This FUNCTION depends on the TYPE: [dbo].[boolean]

DROP FUNCTION [dbo].[getboolean]
GO

DROP TYPE [dbo].[boolean]
GO

-- DEPCY: This TYPE is a dependency of FUNCTION: [dbo].[getboolean]

CREATE TYPE [dbo].[boolean] FROM [bit]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[getboolean]() 
RETURNS dbo.boolean
AS     
BEGIN
    RETURN 1;
END
GO