SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [varchar](100) NULL
)
GO

EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'comment for table1', 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'TABLE',
@level1name=N'table1'
GO