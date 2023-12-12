CREATE TYPE [dbo].[type_1] AS TABLE
(
        [col1]  NVARCHAR(50) NOT NULL,
        [col2] BIGINT NOT NULL,
        [col3] DECIMAL (18, 4) NULL,
        INDEX [idx_1] NONCLUSTERED HASH 
(
        [col1],
        [col2]
) WITH ( BUCKET_COUNT = 1)
) WITH ( MEMORY_OPTIMIZED=ON)
GO

CREATE TYPE [dbo].[type_1_1] AS TABLE
(
        [col1]  NVARCHAR(50) NOT NULL,
        [col2] BIGINT NOT NULL,
        [col3] DECIMAL (18, 4) NULL,
        INDEX [idx_1_1] NONCLUSTERED  
(
        [col1],
        [col2] DESC
)
) WITH ( MEMORY_OPTIMIZED=ON)
GO

CREATE TYPE [dbo].[type_2] AS TABLE
(
        [col1]  NVARCHAR(50) NOT NULL,
        [col2] BIGINT NOT NULL,
        [col3] DECIMAL (18, 4) NULL,
        INDEX [idx_2] HASH
(
        [col2]
)
) WITH ( MEMORY_OPTIMIZED=ON)
GO

CREATE TYPE [dbo].[type_3] AS TABLE
(
        [col1] NVARCHAR(50) NOT NULL,
        [col2] BIGINT NOT NULL,
        [col3] DECIMAL (18, 4) NULL,
        INDEX [idx_3] CLUSTERED 
(
        [col1] ASC,
        [col2] DESC
)
)
GO

CREATE TYPE [dbo].[type_4] AS TABLE
(
        [col1] NVARCHAR(50) NOT NULL,
        [col2] BIGINT NOT NULL,
        [col3] DECIMAL (18, 4) NULL,
        INDEX [idx_4] NONCLUSTERED
(
        [col2] ASC
)
)
GO

CREATE TYPE [dbo].[type_5] AS TABLE
(
        [col1] NVARCHAR(50) NOT NULL,
        [col2] BIGINT NOT NULL,
        [col3] DECIMAL (18, 4) NULL,
        INDEX [idx_5] CLUSTERED
(
        [col2] 
)
)
GO