CREATE TABLE [dbo].[table1] (
    [c1] [int]
)
GO

CREATE PARTITION FUNCTION [pf_range_left](int) AS RANGE LEFT FOR VALUES (1, 10, 100)
GO

CREATE PARTITION SCHEME [ps_range_left] AS PARTITION [pf_range_left] TO ([PRIMARY], [PRIMARY], [PRIMARY], [PRIMARY], [PRIMARY])
GO

CREATE TABLE [dbo].[table_partition_01](
    [id] [int] NULL
) ON [ps_range_left]([id])
GO