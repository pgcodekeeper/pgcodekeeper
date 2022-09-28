SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[test] (
   [id] [bigint])
GO

-- Comment for table [dbo].[test].
EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'multiline
comment
', 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'TABLE',
@level1name=N'test'
GO
