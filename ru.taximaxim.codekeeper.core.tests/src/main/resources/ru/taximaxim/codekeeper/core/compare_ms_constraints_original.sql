
CREATE TABLE [dbo].[tt1](
	[id] [int] NOT NULL,
	[c2] [int] NULL,
	[c3] [int] NULL
) ON [PRIMARY]
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[tt1]
	ADD 
	CONSTRAINT [PK_tt1_id]
	PRIMARY KEY CLUSTERED ([id])
	ON [PRIMARY]
GO


CREATE TYPE [dbo].[test_type] AS TABLE(
	[col4] [int] NULL,
	[col1] [int] NOT NULL,
	[col3] [bigint] NULL DEFAULT ((15)),
	PRIMARY KEY NONCLUSTERED ([col1]) WITH (IGNORE_DUP_KEY =  ON),
	CHECK (([col4]<(100)))
)
GO

CREATE TYPE [dbo].[test_type2] AS TABLE(
    [col4] [int] NULL,
    [col1] [int] NOT NULL,
    [col3] [bigint] NULL DEFAULT ((15)),
    UNIQUE NONCLUSTERED ([col1], [col4]) WITH (IGNORE_DUP_KEY =  ON)
)
GO

CREATE TABLE [dbo].[tt2](
	[id] [int] NOT NULL,
	[age] [int],
	[col3] [int] 
) ON [PRIMARY]
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[tt2]
	ADD CONSTRAINT [tt2_id_key] UNIQUE NONCLUSTERED ([id]) ON [PRIMARY]
GO

ALTER TABLE [dbo].[tt2]
	ADD CONSTRAINT [tt2_age_check] CHECK NOT FOR REPLICATION ([age]>18 )
GO

ALTER TABLE [dbo].[tt2]
	ADD CONSTRAINT [FK_cons] FOREIGN KEY ([col3]) REFERENCES [dbo].[tt1] ON DELETE CASCADE ON UPDATE SET DEFAULT NOT FOR REPLICATION
GO