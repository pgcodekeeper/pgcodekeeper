SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[t1](
    [col1_1] [bigint] NOT NULL,
    [col1_2] [bigInt] NULL,
    [col2_1] [uniqueidentifier] ROWGUIDCOL NOT NULL,
    [col2_2] [uniqueidentifier] NOT NULL,
    [col3_1] [int] NOT NULL IDENTITY (1,1) not for replication,
    [col3_2] [int] NOT NULL IDENTITY (1,1),
    [col4_1] int NULL SPARSE,
    [col4_2] int NULL,
    [a_1] [int] NULL,
	[b_1] [int] NULL,
	[c_1] AS ([a_1]+[b_1]) persisted,
	[a_2] [int] NULL,
	[b_2] [int] NULL,
	[c_2] AS ([a_2]+[b_2])
) ON [test1fg]
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[t1]
    ADD CONSTRAINT [UQ_1_1] UNIQUE NONCLUSTERED  ([col1_1]) ON [test1fg]
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[t1]
    ADD CONSTRAINT [UQ_1_2] UNIQUE NONCLUSTERED  ([col1_2]) ON [test1fg]
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[t1]
	ADD CONSTRAINT [UQ_2_1] UNIQUE NONCLUSTERED  ([col2_1]) ON [test1fg]
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[t1]
	ADD CONSTRAINT [UQ_2_2] UNIQUE NONCLUSTERED  ([col2_2]) ON [test1fg]
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[t1]
	ADD CONSTRAINT [PK_1_1] PRIMARY KEY CLUSTERED  ([col3_1]) ON [test1fg]
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[t1]
	ADD CONSTRAINT [PK_1_2] PRIMARY KEY CLUSTERED  ([col3_2]) ON [test1fg]
GO

--------------------------------------------------------------------------------

CREATE NONCLUSTERED INDEX [idx1_1] ON [dbo].[t1] ([col4_1])
ON [test1fg]
GO

--------------------------------------------------------------------------------

CREATE NONCLUSTERED INDEX [idx1_2] ON [dbo].[t1] ([col4_2])
ON [test1fg]
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[t1]
	ADD CONSTRAINT [UQ_3_1] UNIQUE NONCLUSTERED  ([c_1]) ON [test1fg]
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[t1]
	ADD CONSTRAINT [UQ_3_2] UNIQUE NONCLUSTERED  ([c_2]) ON [test1fg]
GO