SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [varchar](100) NOT NULL)
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[ReturnOperResult](@First int, @Second int) 
RETURNS TABLE
AS
RETURN   
(  
    SELECT @First AS 'First', @Second AS 'Second', (@First + @Second) AS 'Sum'  
)
GO