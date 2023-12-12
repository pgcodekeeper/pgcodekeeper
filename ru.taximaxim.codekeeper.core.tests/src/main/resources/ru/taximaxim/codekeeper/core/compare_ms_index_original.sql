CREATE TABLE [dbo].[t1](
    [c1] int,
    [c2] int,
    [c3] int)
ON [PRIMARY]
GO

CREATE INDEX [idx1] ON [dbo].[t1] ([c1], [c2] DESC) ON [PRIMARY]
GO

CREATE TABLE [dbo].[t2](
    [c1] int,
    [c2] int,
    [c3] int)
ON [PRIMARY]
GO

CREATE INDEX [idx2] ON [dbo].[t2] ([c1], [c2] DESC) ON [PRIMARY]
GO

CREATE TABLE [dbo].[t3](
    [c1] int,
    [c2] int,
    [c3] int,
    INDEX [idx3] ([c1] , [c2] DESC))
ON [PRIMARY]
GO