-- Comment for current database.
---- (written in one format)
EXEC sys.sp_addextendedproperty 
@name = N'MS_DescriptionExample', 
@value = N'This is my comment on this database.';
GO

-- Comment for schema [dbo].
---- (written in one format)
EXECUTE sys.sp_addextendedproperty 
@name = N'MS_Description',
@value = N'Contains super objects.',
@level0type = N'SCHEMA', 
@level0name = dbo;
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[TABLE_1] (
   [ID] [int] NOT NULL IDENTITY(1, 1),
   [COLUMN_1] [varchar](10) NULL,
   [COLUMN_2] [varchar](10) NULL)
GO

ALTER TABLE [dbo].[TABLE_1] 
    ADD CONSTRAINT [PK_TABLE_1] PRIMARY KEY CLUSTERED  ([ID]) ON [PRIMARY]
GO

-- Comment for table [dbo].[TABLE_1].
---- (written in a different format)
DECLARE @CurrentUser sysname
SELECT @CurrentUser = user_name()
EXECUTE sp_addextendedproperty 'MS_Description', 
   'This is my table comment.',
   'user', @CurrentUser, 'table', 'TABLE_1'
GO

-- Comment for column [ID] of table [dbo].[TABLE_1].
---- (written in one format)
EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'This is the primary key comment' , 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'TABLE',
@level1name=N'TABLE_1',
@level2type=N'COLUMN',
@level2name=N'ID'
GO

-- Comment for column [COLUMN_1] of table [dbo].[TABLE_1].
---- (written in a different format)
DECLARE @CurrentUser sysname
SELECT @CurrentUser = user_name()
EXECUTE sp_addextendedproperty 'MS_Description', 
   'This is column one comment',
   'user', @CurrentUser, 'table', 'TABLE_1', 'column', 'COLUMN_1'
GO

-- Comment for column [COLUMN_2] of table [dbo].[TABLE_1].
---- (written in a different format)
DECLARE @CurrentUser sysname
SELECT @CurrentUser = user_name()
EXECUTE sp_addextendedproperty 'MS_Description', 
   'This is column 2 comment',
   'user', @CurrentUser, 'table', 'TABLE_1', 'column', 'COLUMN_2'
GO
