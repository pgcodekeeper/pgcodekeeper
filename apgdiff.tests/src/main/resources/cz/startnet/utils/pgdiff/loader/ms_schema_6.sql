CREATE SCHEMA [common]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
Create FUNCTION [common].[t_common_casttotext](@m_d_y varchar(100))
RETURNS varchar(100)
AS
BEGIN
    DECLARE @Res varchar(100) = ''
    SELECT  @Res = DATENAME(dw, @m_d_y)
    RETURN  @Res
END
GO