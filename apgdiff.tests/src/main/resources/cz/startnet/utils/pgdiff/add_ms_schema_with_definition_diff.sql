CREATE SCHEMA [test]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [test].[test_table](
	[c1] integer NULL,
	[c2] nvarchar(70) NULL,
	[c3] nvarchar(40) NULL
)
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [test].[test_view] AS
        SELECT c1, c2 FROM test_table WHERE c3 IS NOT NULL
GO

GRANT SELECT ON [test].[test_view] TO [test_user]
GO