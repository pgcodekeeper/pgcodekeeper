CREATE TABLE [dbo].[table_partition_01](
    [id] [int] NULL
) ON [ps_range_right]([id])
GO