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
CREATE PROCEDURE [dbo].[prc]
@first integer
AS
    SELECT 1 AS trigger_action;
    UPDATE [dbo].[tbl]
    SET c5 = ((SELECT MAX(c1) FROM [dbo].[tbl]) + 1000)
    WHERE c1 = 2;
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TRIGGER [dbo].[trg] ON [dbo].[tbl]
AFTER INSERT
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

-------------------------------------------------------------------------------
 --drop sequence when migrate data
CREATE SEQUENCE [dbo].[seq2]
    AS integer
    START WITH 555888
    INCREMENT BY 555
    MAXVALUE 5557772036854775807
    MINVALUE 555777
    CACHE 
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [bigint] NOT NULL CONSTRAINT [DF__table1__c1__5629CD9C] DEFAULT (NEXT VALUE FOR [dbo].[seq2]),
    [c2] [int] NOT NULL,
    [c3] [varchar] (100) COLLATE Cyrillic_General_CI_AS NOT NULL
) ON [PRIMARY]
GO