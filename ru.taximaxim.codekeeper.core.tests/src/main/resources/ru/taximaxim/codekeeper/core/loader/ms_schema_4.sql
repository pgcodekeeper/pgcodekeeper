SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1] (
    [id] [int] NOT NULL,
    [entityId] [int] NOT NULL)
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create FUNCTION [dbo].[gtsq_in](@eid int)
RETURNS varchar(100)
WITH RETURNS NULL ON NULL INPUT
AS
BEGIN
    Declare @logid varchar(50);
    SELECT @logid = tbl1.id from [dbo].[table1] AS tbl1
    WHERE tbl1.entityId = @eid
    RETURN  @logid
END
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[multiply_numbers](@First int, @Second int) 
RETURNS integer
AS
BEGIN
    DECLARE @Res integer = 0

    SET @Res = @First * @Second

    IF @Res < 0
        SET @Res = 0

    RETURN @Res
END
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[select_something](@First int, @Second int) 
RETURNS integer
AS
BEGIN
    DECLARE @Res integer = 0
    SELECT  @Res = COUNT(*) FROM [dbo].[table1];
    RETURN @Res + @First * @Second
END
GO
