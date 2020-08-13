-- DEPCY: This CONSTRAINT depends on the TABLE: [dbo].[tbl]

ALTER TABLE [dbo].[tbl]
	DROP CONSTRAINT [PK_tbl]
GO

EXEC sp_rename '[dbo].[tbl]', 'tbl_randomly_generated_part'
GO

ALTER TABLE [dbo].[tbl_randomly_generated_part] DROP CONSTRAINT [DF__tbl__c5__2645B050]
GO

ALTER TABLE [dbo].[tbl_randomly_generated_part] DROP CONSTRAINT [DF__tbl__c6__2739D489]
GO

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

EXEC sys.sp_refreshsqlmodule '[dbo].[v]' 
GO

ALTER TABLE [dbo].[tbl]
	ADD CONSTRAINT [PK_tbl] PRIMARY KEY CLUSTERED  ([c1]) ON [PRIMARY]
GO

INSERT INTO [dbo].[tbl](c1, c2, c3, c5, c6) SELECT c1, c2, c3, c5, c6 FROM [dbo].[tbl_randomly_generated_part];

DROP TABLE [dbo].[tbl_randomly_generated_part];
