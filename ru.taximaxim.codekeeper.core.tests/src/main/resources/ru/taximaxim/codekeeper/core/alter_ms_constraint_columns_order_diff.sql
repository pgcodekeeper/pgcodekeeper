ALTER TABLE [dbo].[t1]
	DROP CONSTRAINT [pk]
GO

ALTER TABLE [dbo].[t_fk_1]
	DROP CONSTRAINT [t_fk_1_fk]
GO

ALTER TABLE [dbo].[t_fk_2]
	DROP CONSTRAINT [t_fk_2_fk]
GO

ALTER TABLE [dbo].[t1]
	ADD CONSTRAINT [pk] PRIMARY KEY NONCLUSTERED  ([c2], [c1])
GO

ALTER TABLE [dbo].[t_fk_1]
	ADD CONSTRAINT [t_fk_1_fk] FOREIGN KEY ([c1], [c2]) REFERENCES [dbo].[t_pk] ([c2], [c1])
GO

ALTER TABLE [dbo].[t_fk_2]
	ADD CONSTRAINT [t_fk_2_fk] FOREIGN KEY ([c2], [c1]) REFERENCES [dbo].[t_pk] ([c1], [c2])
GO
