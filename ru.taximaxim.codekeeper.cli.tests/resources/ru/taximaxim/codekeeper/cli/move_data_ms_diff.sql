-- DEPCY: This CONSTRAINT depends on the TABLE: [dbo].[tbl]

ALTER TABLE [dbo].[tbl]
	DROP CONSTRAINT [PK_tbl]
GO

-- DEPCY: This TRIGGER depends on the TABLE: [dbo].[tbl]

DROP TRIGGER [dbo].[trg]
GO

-- DEPCY: This INDEX depends on the TABLE: [dbo].[tbl]

DROP INDEX [idx_dbo_tbl_c2] ON [dbo].[tbl]
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

GRANT SELECT ON [dbo].[tbl] TO [test_user]
GO

INSERT INTO [dbo].[tbl]([c1], [c2], [c3], [c6], [c5])
SELECT [c1], [c2], [c3], [c6], [c5] FROM [dbo].[tbl_randomly_generated_part]
GO

DROP TABLE [dbo].[tbl_randomly_generated_part]
GO

EXEC sys.sp_refreshsqlmodule '[dbo].[v]' 
GO

ALTER TABLE [dbo].[tbl]
	ADD CONSTRAINT [PK_tbl] PRIMARY KEY CLUSTERED  ([c1]) ON [PRIMARY]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TRIGGER [dbo].[trg] ON [dbo].[tbl]
AFTER INSERT
AS EXECUTE [dbo].[prc] @first = 4
GO

CREATE UNIQUE NONCLUSTERED INDEX [idx_dbo_tbl_c2] ON [dbo].[tbl] ([c2])
ON [PRIMARY]
GO
