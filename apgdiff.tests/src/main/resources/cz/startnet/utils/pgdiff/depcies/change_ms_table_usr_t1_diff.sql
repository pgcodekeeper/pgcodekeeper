-- DEPCY: This VIEW depends on the TABLE: dbo.t1

DROP VIEW [dbo].[v4]
GO

-- DEPCY: This VIEW depends on the TABLE: dbo.t1

DROP VIEW [dbo].[v2]
GO

-- DEPCY: This VIEW depends on the TABLE: dbo.t1

DROP VIEW [dbo].[v1]
GO

-- no action; triggering depcies for [dbo].[t1]
GO

ALTER TABLE [dbo].[t1]
	ADD [c3] [int]
GO

-- DEPCY: This VIEW is a dependency of VIEW: dbo.v4

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[v1] as 
select 
    * 
from 
    dbo.t1
GO

-- DEPCY: This VIEW is a dependency of VIEW: dbo.v4

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[v2] as
select 
    * 
from 
    dbo.v1
GO

-- DEPCY: This VIEW is a dependency of VIEW: dbo.v4

EXEC sys.sp_refreshsqlmodule '[dbo].[v3]' 
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[v4] as 
select 
    * 
from 
    dbo.v3
GO
