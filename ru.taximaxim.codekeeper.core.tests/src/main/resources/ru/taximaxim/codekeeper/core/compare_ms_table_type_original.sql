CREATE TYPE [dbo].[type_1] AS TABLE
(
        [col1] NVARCHAR(50) NOT NULL,
        [col2] BIGINT NOT NULL INDEX [idx_1] HASH ([col1], [col2]) WITH ( BUCKET_COUNT = 1 ),
        [col3] DECIMAL (18, 4) NULL
) WITH ( MEMORY_OPTIMIZED=ON)
GO

CREATE TYPE [dbo].[type_1_1] AS TABLE
(
        [col1] NVARCHAR(50) NOT NULL,
        [col2] BIGINT NOT NULL INDEX [idx_1_1] ([col1] ASC, [col2] DESC),
        [col3] DECIMAL (18, 4) NULL
) WITH ( MEMORY_OPTIMIZED=ON)
GO

CREATE TYPE [dbo].[type_2] AS TABLE
(
        [col1] NVARCHAR(50) NOT NULL,
        [col2] BIGINT NOT NULL INDEX [idx_2] NONCLUSTERED HASH,
        [col3] DECIMAL (18, 4) NULL
) WITH ( MEMORY_OPTIMIZED=ON)
GO

CREATE TYPE [dbo].[type_3] AS TABLE
(
        [col1] NVARCHAR(50) NOT NULL,
        [col2] BIGINT NOT NULL INDEX [idx_3] CLUSTERED ([col1], [col2] DESC),
        [col3] DECIMAL (18, 4) NULL
)
GO

CREATE TYPE [dbo].[type_4] AS TABLE
(
        [col1] NVARCHAR(50) NOT NULL,
        [col2] BIGINT NOT NULL INDEX [idx_4],
        [col3] DECIMAL (18, 4) NULL
)
GO

CREATE TYPE [dbo].[type_5] AS TABLE
(
        [col1] NVARCHAR(50) NOT NULL,
        [col2] BIGINT NOT NULL INDEX [idx_5] CLUSTERED,
        [col3] DECIMAL (18, 4) NULL
)
GO