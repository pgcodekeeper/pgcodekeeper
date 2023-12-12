CREATE TABLE [dbo].[t1](
    [c1] int,
    [c2] int INDEX [idx1] NONCLUSTERED ([c1] ASC, [c2] DESC),
    [c3] int)
ON [PRIMARY]
GO

CREATE TABLE [dbo].[t2](
    [c1] int,
    [c2] int,
    [c3] int,
    INDEX [idx2] NONCLUSTERED ([c1] ASC, [c2] DESC))
ON [PRIMARY]
GO

CREATE TABLE [dbo].[t3](
    [c1] int,
    [c2] int INDEX [idx3] NONCLUSTERED ([c1] ASC, [c2] DESC),
    [c3] int)
ON [PRIMARY]
GO