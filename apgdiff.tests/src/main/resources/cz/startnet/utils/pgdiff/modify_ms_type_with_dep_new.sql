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