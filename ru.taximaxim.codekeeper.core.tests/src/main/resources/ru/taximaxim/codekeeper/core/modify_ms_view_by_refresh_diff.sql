-- DEPCY: This VIEW v2 depends on the TABLE: [dbo].[t1]

DROP VIEW [dbo].[v2]
GO

DROP TABLE [dbo].[t1]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[t1](
	[c2] [int] NOT NULL,
	[c1] [int] NOT NULL
)
GO

EXEC sys.sp_refreshsqlmodule '[dbo].[v1]'
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[v2] AS
    SELECT * FROM [dbo].[v1]
GO

EXEC sys.sp_refreshsqlmodule '[dbo].[v3]'
GO