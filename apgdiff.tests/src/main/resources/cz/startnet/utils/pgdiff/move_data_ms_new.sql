SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[tbl](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar] (100) COLLATE Cyrillic_General_CI_AS NULL,
    [c6] [int] NOT NULL CONSTRAINT [DF__tbl__c6__2739D489] DEFAULT ((555777)),
    [c5] [int] NOT NULL CONSTRAINT [DF__tbl__c5__2645B050] DEFAULT ((333999))
) ON [PRIMARY]
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