-- Comment for current database.
EXEC sys.sp_addextendedproperty 
@name = N'MS_DescriptionExample', 
@value = N'comments database';
GO

-- Comment for schema [dbo].
EXECUTE sys.sp_addextendedproperty 
@name = N'MS_Description',
@value = N'dbo schema',
@level0type = N'SCHEMA', 
@level0name = dbo;
GO

CREATE SEQUENCE [dbo].[test_id_seq]
    START WITH 1
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1
GO

ALTER AUTHORIZATION ON OBJECT::[dbo].[test_id_seq] TO [ms_user]
GO

-- Comment for sequence [dbo].[test_id_seq].
EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'test table sequence', 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'SEQUENCE',
@level1name=N'test_id_seq'
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[test_fnc](@arg nvarchar) 
RETURNS bit
AS
BEGIN
    RETURN 1
END
GO

ALTER AUTHORIZATION ON OBJECT::[dbo].[test_fnc] TO [ms_user]
GO

-- Comment for function [dbo].[test_fnc].
EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'test function' , 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'FUNCTION',
@level1name=N'test_fnc'
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[fnc]() 
RETURNS bit
AS
BEGIN
    RETURN 1
END
GO

ALTER AUTHORIZATION ON OBJECT::[dbo].[fnc] TO [ms_user]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE PROCEDURE [dbo].[trigger_proc]
AS
BEGIN
    -- empty procedure
    RETURN
END
GO

ALTER AUTHORIZATION ON OBJECT::[dbo].[trigger_proc] TO [ms_user]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[test] (
   [id] [int] NOT NULL,
   [text] [nvarchar](20) NOT NULL)
GO

ALTER TABLE [dbo].[test]  WITH CHECK ADD  CONSTRAINT [text_check] CHECK  ((LEN([text])>(0)))
GO

ALTER TABLE [dbo].[test] CHECK CONSTRAINT [text_check]
GO

ALTER TABLE [dbo].[test]
    ADD CONSTRAINT [DF_test_id] DEFAULT (NEXT VALUE FOR [dbo].[test_id_seq]) FOR id
GO

ALTER TABLE [dbo].[test] 
    ADD CONSTRAINT [PK_test] PRIMARY KEY CLUSTERED  ([id]) ON [PRIMARY]
GO

ALTER AUTHORIZATION ON OBJECT::[dbo].[test] TO [ms_user]
GO

-- Comment for table [dbo].[test].
EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'test table', 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'TABLE',
@level1name=N'test'
GO

-- Comment for column [id] of table [dbo].[test].
EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'id column' , 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'TABLE',
@level1name=N'test',
@level2type=N'COLUMN',
@level2name=N'id'
GO

-- Comment for column [text] of table [dbo].[test].
EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'text column' , 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'TABLE',
@level1name=N'test',
@level2type=N'COLUMN',
@level2name=N'text'
GO

-- Comment for constraint [text_check] of table [dbo].[test].
EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'text check' , 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'TABLE',
@level1name=N'test', 
@level2type=N'CONSTRAINT',
@level2name=N'text_check'
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[test_view] AS
    SELECT 
    [test].[id],
    [test].[text]
FROM [dbo].[test]
GO

ALTER AUTHORIZATION ON OBJECT::[dbo].[test_view] TO [ms_user]
GO

-- Comment for view [dbo].[test_view].
EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'test view', 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'VIEW',
@level1name=N'test_view'
GO

-- Comment for column [id] of view [dbo].[test_view].
EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'view id col' , 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'VIEW',
@level1name=N'test_view',
@level2type=N'COLUMN',
@level2name=N'id'
GO

CREATE NONCLUSTERED INDEX [IX_test_id] ON [dbo].[test] ([id])
GO

-- Comment for index [IX_test_id] ON [dbo].[test].
EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'view id col' , 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'TABLE',
@level1name=N'test',
@level2type=N'INDEX',
@level2name=N'IX_test_id'
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TRIGGER [dbo].[test_trigger]
ON [dbo].[test]
FOR UPDATE
AS 
    BEGIN
        SET NOCOUNT ON;
        EXEC [dbo].[trigger_proc];
    END
GO

-- Comment for trigger [dbo].[test_trigger] on [dbo].[test].
EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'test trigger', 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'TABLE',
@level1name=N'test',
@level2type=N'TRIGGER',
@level2name=N'test_trigger'
GO

REVOKE SELECT ON SCHEMA::[dbo] FROM [ms_user]
GO

REVOKE UPDATE ON SCHEMA::[dbo] FROM [ms_user]
GO

REVOKE DELETE ON SCHEMA::[dbo] FROM [ms_user]
GO

REVOKE INSERT ON SCHEMA::[dbo] FROM [ms_user]
GO

GRANT SELECT ON SCHEMA::[dbo] TO [ms_user]
GO

GRANT UPDATE ON SCHEMA::[dbo] TO [ms_user]
GO

GRANT DELETE ON SCHEMA::[dbo] TO [ms_user]
GO

GRANT INSERT ON SCHEMA::[dbo] TO [ms_user]
GO
