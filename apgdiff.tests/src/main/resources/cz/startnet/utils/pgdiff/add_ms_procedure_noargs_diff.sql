SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE PROCEDURE [dbo].[proc1]
AS
SET NOCOUNT ON;  
    SELECT t.[c1], t.[c2], t.[c3]  
    FROM [dbo].[table1] t;
GO