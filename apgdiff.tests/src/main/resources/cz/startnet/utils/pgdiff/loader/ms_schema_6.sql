CREATE SCHEMA [common]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create FUNCTION [common].[t_common_casttotext]()
RETURNS varchar(100)
AS
BEGIN
    DECLARE @Res varchar(100) = ''
    SELECT  @Res = DATENAME(dw, '09/23/2013')
    RETURN  @Res
END
GO