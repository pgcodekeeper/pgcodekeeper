CREATE TYPE [dbo].[custom_type] FROM [bit]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[getboolean]() 
RETURNS dbo.custom_type
AS     
BEGIN
    RETURN 1;
END
GO

--changed
CREATE FUNCTION [dbo].[changed_function]() 
RETURNS dbo.custom_type
AS     
BEGIN
    RETURN 777;
END
GO
