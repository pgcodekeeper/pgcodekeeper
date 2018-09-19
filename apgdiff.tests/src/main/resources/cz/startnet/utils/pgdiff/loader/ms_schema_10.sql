SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create FUNCTION [dbo].[curdate]()
RETURNS nvarchar(30)
AS
BEGIN
    Declare @textdate nvarchar(30);
    SELECT @textdate = CAST(GETDATE() AS nvarchar(30));
    RETURN  @textdate;
END
GO
