-- DEPCY: This INDEX PK_search_firms_test depends on the COLUMN: [dbo].[firms_test].[nameRus]

DROP INDEX [PK_search_firms_test] ON [dbo].[v_search_firms_test]
GO

-- DEPCY: This VIEW v_search_firms_test depends on the COLUMN: [dbo].[firms_test].[nameRus]

DROP VIEW [dbo].[v_search_firms_test]
GO

ALTER TABLE [dbo].[firms_test]
	ALTER COLUMN [nameRus] NVARCHAR(80) NULL
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[v_search_firms_test]
WITH SCHEMABINDING
AS
SELECT firmId, nameRus
FROM dbo.firms_test
GO

CREATE UNIQUE CLUSTERED INDEX [PK_search_firms_test] ON [dbo].[v_search_firms_test] ([firmId])
GO