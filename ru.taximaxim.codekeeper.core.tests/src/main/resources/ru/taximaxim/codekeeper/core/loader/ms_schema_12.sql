SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[function_string_to_table]
(@string nvarchar(MAX), @delimiter char(1))
RETURNS @output TABLE(tbldata nvarchar(256))
BEGIN
    DECLARE @start INT, @end INT
    SELECT @start = 1, @end = CHARINDEX(@delimiter, @string)

    WHILE @start < LEN(@string) + 1 BEGIN
        IF @end = 0 
            SET @end = LEN(@string) + 1

        INSERT INTO @output (tbldata) 
        VALUES(SUBSTRING(@string, @start, @end - @start))
        SET @start = @end + 1
        SET @end = CHARINDEX(@delimiter, @string, @start)
    END

    RETURN
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE FUNCTION [dbo].[function_empty]
(@string nvarchar(MAX), @delimiter char(1))
RETURNS @output TABLE(tbldata nvarchar(256))
BEGIN
    -- aaa
    RETURN
END
GO
