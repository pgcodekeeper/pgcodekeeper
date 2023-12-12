
CREATE TABLE [dbo].[tt1](
	[id] [int] NOT NULL,
	[c2] [int] NULL,
	[c3] [int] NULL
) ON [PRIMARY]
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[tt1]
	ADD CONSTRAINT [PK_tt1_id] PRIMARY KEY CLUSTERED  ([id]) ON [PRIMARY]
GO


CREATE TYPE [dbo].[test_type] AS TABLE(
	[col4] [int] NULL CHECK (([col4]<(100))),
	[col1] [int] NOT NULL PRIMARY KEY NONCLUSTERED WITH (IGNORE_DUP_KEY =  ON),
	[col3] [bigint] NULL DEFAULT ((15))
)
GO

CREATE TYPE [dbo].[test_type2] AS TABLE(
    [col4] [int] NULL,
    [col1] [int] NOT NULL UNIQUE ([col1], [col4]) WITH (IGNORE_DUP_KEY =  ON),
    [col3] [bigint] NULL DEFAULT ((15))
)
GO

CREATE TABLE [dbo].[tt2](
	[id] [int] NOT NULL UNIQUE NONCLUSTERED ON [PRIMARY],
	[age] [int] CHECK NOT FOR REPLICATION ([age]>18),
	[col3] [int] CONSTRAINT [FK_cons] FOREIGN KEY REFERENCES [dbo].[tt1] ON DELETE CASCADE ON UPDATE SET DEFAULT NOT FOR REPLICATION
) ON [PRIMARY]
GO