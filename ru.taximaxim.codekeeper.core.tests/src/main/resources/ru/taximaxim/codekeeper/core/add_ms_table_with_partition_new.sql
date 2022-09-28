SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1] (
    [c1] [int]
)
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table_partition_01](
    [id] [int] NULL
) ON [ps_range_left]([id])
GO