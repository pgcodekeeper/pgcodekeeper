EXEC sp_rename '[dbo].[table1]', 'table1_randomly_generated_part'
GO

ALTER TABLE [dbo].[table1_randomly_generated_part] DROP CONSTRAINT [DF__table1__c1__5629CD9C]
GO

DROP SEQUENCE [dbo].[seq2]
GO

-- DEPCY: This CONSTRAINT PK_tbl depends on the TABLE: [dbo].[tbl]

ALTER TABLE [dbo].[tbl]
	DROP CONSTRAINT [PK_tbl]
GO

-- DEPCY: This TRIGGER trg depends on the TABLE: [dbo].[tbl]

DROP TRIGGER [dbo].[trg]
GO

-- DEPCY: This INDEX idx_dbo_tbl_c2 depends on the TABLE: [dbo].[tbl]

DROP INDEX [idx_dbo_tbl_c2] ON [dbo].[tbl]
GO

EXEC sp_rename '[dbo].[tbl]', 'tbl_randomly_generated_part'
GO

ALTER TABLE [dbo].[tbl_randomly_generated_part] DROP CONSTRAINT [DF__tbl__c5__2645B050]
GO

ALTER TABLE [dbo].[tbl_randomly_generated_part] DROP CONSTRAINT [DF__tbl__c6__2739D489]
GO

CREATE SEQUENCE [dbo].[seq2]
	AS bigint
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
	[c5] [int] NOT NULL,
	[c1] [integer] NOT NULL CONSTRAINT [DF__table1__c1__5629CD9C] DEFAULT (NEXT VALUE FOR [dbo].[seq2]),
	[c2] [int] NOT NULL,
	[c3] [varchar] (100) COLLATE Cyrillic_General_CI_AS NOT NULL
) ON [PRIMARY]
GO

INSERT INTO [dbo].[table1]([c1], [c2], [c3])
SELECT [c1], [c2], [c3] FROM [dbo].[table1_randomly_generated_part]
GO

DROP TABLE [dbo].[table1_randomly_generated_part]
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