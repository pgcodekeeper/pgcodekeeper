-- DEPCY: This CONSTRAINT depends on the TABLE: [dbo].[tbl]

ALTER TABLE [dbo].[tbl]
	DROP CONSTRAINT [PK_tbl]
GO

-- DEPCY: This CONSTRAINT depends on the TABLE: [dbo].[tbl]

ALTER TABLE [dbo].[tbl]
	DROP CONSTRAINT [CHK_c7_tbl]
GO

EXEC sp_rename '[dbo].[tbl]', 'tbl_randomly_generated_part'
GO

ALTER TABLE [dbo].[tbl_randomly_generated_part] DROP CONSTRAINT [DF__tbl__c2__3F115E1A]
GO

ALTER TABLE [dbo].[tbl_randomly_generated_part] DROP CONSTRAINT [DF__tbl__c5__31B762FC]
GO

ALTER TABLE [dbo].[tbl_randomly_generated_part] DROP CONSTRAINT [DF__tbl__c6__32AB8735]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[tbl](
	[c1] [int] NOT NULL IDENTITY (1,1),
	[c2] [int] NULL CONSTRAINT [DF__tbl__c2__3F115E1A] DEFAULT (NEXT VALUE FOR [dbo].[seq_second_id]),
	[c3] [int] NOT NULL,
	[c4] [varchar] (100) COLLATE Cyrillic_General_CI_AS NULL,
	[c6] [int] NOT NULL CONSTRAINT [DF__tbl__c6__32AB8735] DEFAULT ((555777)),
	[c5] [int] NOT NULL CONSTRAINT [DF__tbl__c5__31B762FC] DEFAULT ((333999)),
	[c7] [int] NULL,
	[c8] AS ([c1]+(2000)),
	[c9] AS ([c1]+(3000)) PERSISTED
) ON [PRIMARY]
GO

EXEC sys.sp_refreshsqlmodule '[dbo].[v]' 
GO

ALTER TABLE [dbo].[tbl]
	ADD CONSTRAINT [PK_tbl] PRIMARY KEY CLUSTERED  ([c1]) ON [PRIMARY]
GO

ALTER TABLE [dbo].[tbl]
	ADD CONSTRAINT [CHK_c7_tbl] CHECK  (([c7]>(1) AND [c7]<(999999)))
GO

SET IDENTITY_INSERT [dbo].[tbl] ON
GO

INSERT INTO [dbo].[tbl](c1, c2, c3, c4, c5, c6, c7) SELECT c1, c2, c3, c4, c5, c6, c7 FROM [dbo].[tbl_randomly_generated_part]
GO

SET IDENTITY_INSERT [dbo].[tbl] OFF
GO

DECLARE @dbo_tbl_c1_restart_value integer = (SELECT IDENT_CURRENT ('[dbo].[tbl_randomly_generated_part]'));
BEGIN
	EXECUTE ('DBCC CHECKIDENT (''[dbo].[tbl]'', RESEED, ' + @dbo_tbl_c1_restart_value + ');');
END
GO

DROP TABLE [dbo].[tbl_randomly_generated_part]
GO
