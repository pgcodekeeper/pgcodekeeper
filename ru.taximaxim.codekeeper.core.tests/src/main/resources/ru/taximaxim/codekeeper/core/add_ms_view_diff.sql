SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[view1] AS
    SELECT 
    a.[c1],
    a.[c2]
FROM [dbo].[table1] a
GO
