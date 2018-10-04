SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[func]() 
RETURNS @t TABLE (c1 int NULL)
AS 
begin 
    insert @t
    SELECT c1 from test.mstable;
    return;
end
