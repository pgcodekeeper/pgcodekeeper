-- DEPCY: This COLUMN c1 depends on the SEQUENCE: [dbo].[seq1]

ALTER TABLE [dbo].[table1]
	DROP CONSTRAINT [constraint_default_c1]
GO

DROP SEQUENCE [dbo].[seq1]
GO