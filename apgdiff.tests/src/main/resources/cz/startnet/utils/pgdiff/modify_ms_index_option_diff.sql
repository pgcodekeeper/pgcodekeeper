DROP INDEX [index_table1] ON [dbo].[table1]
GO

CREATE NONCLUSTERED INDEX [index_table1] ON [dbo].[table1] ([c1])
WITH (FILLFACTOR = 50)
ON [PRIMARY]
GO