SET QUOTED_IDENTIFIER OFF
GO
SET ANSI_NULLS OFF
GO
CREATE VIEW [dbo].[view1] AS
	SELECT 
    a.[c1],
    a.[c2]
FROM [tester].[table1] a
GO
