DROP TABLE [dbo].[table_partition_01]
GO

DROP PARTITION SCHEME [ps_range_left]
GO

DROP PARTITION FUNCTION [pf_range_left]
GO

DROP TABLE [dbo].[table_partition_02]
GO

DROP PARTITION SCHEME [ps_range_right]
GO

DROP PARTITION FUNCTION [pf_range_right]
GO

CREATE PARTITION FUNCTION [pf_range_right](int) AS RANGE LEFT FOR VALUES (1, 10, 100)
GO

CREATE PARTITION FUNCTION [pf_range_left](int) AS RANGE RIGHT FOR VALUES (1, 10, 100)
GO

CREATE PARTITION SCHEME [ps_range_right] AS PARTITION [pf_range_left] TO ([PRIMARY], [PRIMARY], [PRIMARY], [PRIMARY], [PRIMARY])
GO

CREATE PARTITION SCHEME [ps_range_left] AS PARTITION [pf_range_right] TO ([PRIMARY], [PRIMARY], [PRIMARY], [PRIMARY], [PRIMARY])
GO

CREATE TABLE [dbo].[table_partition_01](
    [id] [int] NULL
) ON [ps_range_right]([id])
GO

CREATE TABLE [dbo].[table_partition_02](
    [id] [int] NULL
) ON [ps_range_right]([id])
GO