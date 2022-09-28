EXECUTE sys.sp_addextendedproperty 
@name=N'MS_Description', 
@value=N'comment for table1', 
@level0type=N'SCHEMA',
@level0name=N'dbo', 
@level1type=N'TABLE',
@level1name=N'table1'
GO