SET QUOTED_IDENTIFIER OFF
GO
SET ANSI_NULLS OFF
GO
CREATE TABLE [dbo].[table_partition_01](
	[id] [int] NULL
) ON [ps_range_left]([id])
GO
