CREATE TYPE [dbo].[custom_type] FROM [integer]
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

--will change
CREATE FUNCTION [dbo].[changed_function]() 
RETURNS dbo.custom_type
AS     
BEGIN
    RETURN 1;
END
GO

--will drop
CREATE FUNCTION [dbo].[dropped_function]() 
RETURNS dbo.custom_type
AS     
BEGIN
    RETURN 1;
END
GO