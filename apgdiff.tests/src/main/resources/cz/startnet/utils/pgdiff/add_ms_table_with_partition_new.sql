CREATE TABLE [dbo].[table1] (
    [c1] [int]
)
GO

CREATE TABLE [dbo].[table_partition_01](
    [id] [int] NULL
) ON [ps_range_left]([id])
GO