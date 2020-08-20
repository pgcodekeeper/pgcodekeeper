SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE PROCEDURE [dbo].[prc]
@first integer
AS
    SELECT (@first + @first) AS val;
    INSERT INTO [dbo].[tbl] (c1, c2, c3, c5, c6)
    VALUES (9, 99, 'Yahoo', DEFAULT, DEFAULT);
    GO
GO



SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[tbl](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar] (100) COLLATE Cyrillic_General_CI_AS NULL,
    [c5] [int] NOT NULL CONSTRAINT [DF__tbl__c5__2645B050] DEFAULT ((333999)),
    [c6] [int] NOT NULL CONSTRAINT [DF__tbl__c6__2739D489] DEFAULT ((555777))
) ON [PRIMARY]
GO

GRANT SELECT ON [dbo].[tbl] TO [test_user]
GO

--------------------------------------------------------------------------------

CREATE UNIQUE NONCLUSTERED INDEX [idx_dbo_tbl_c2] ON [dbo].[tbl] ([c2])
ON [PRIMARY]
GO

--------------------------------------------------------------------------------

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TRIGGER [dbo].[trg] ON [dbo].[tbl]  
AFTER UPDATE   
AS EXECUTE [dbo].[prc] @first = 4
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[tbl]
    ADD CONSTRAINT [PK_tbl] PRIMARY KEY CLUSTERED  ([c1]) ON [PRIMARY]
GO



SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[v] AS
    SELECT 
    a.[c1],
    a.[c2],
    a.[c5]
FROM [dbo].[tbl] a
GO