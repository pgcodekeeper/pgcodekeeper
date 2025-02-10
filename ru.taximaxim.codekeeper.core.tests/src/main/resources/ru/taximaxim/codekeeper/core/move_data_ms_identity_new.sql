CREATE SEQUENCE [dbo].[seq_second_id]
    AS bigint
    START WITH 1001
    INCREMENT BY 1
    MAXVALUE 9223372036854775807
    MINVALUE -9223372036854775808
    CACHE 
GO


SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[tbl](
    [c1] [int] NOT NULL IDENTITY (1,1),
    [c2] [int] NULL CONSTRAINT [DF__tbl__c2__3F115E1A] DEFAULT (NEXT VALUE FOR [dbo].[seq_second_id]),
    [c3] [int] NOT NULL,
    [c4] [varchar] (100) COLLATE Cyrillic_General_CI_AS NULL,
    [c6] [int] NOT NULL CONSTRAINT [DF__tbl__c6__32AB8735] DEFAULT ((555777)),
    [c5] [int] NOT NULL CONSTRAINT [DF__tbl__c5__31B762FC] DEFAULT ((333999)),
    [c7] [int] NULL,
    [c8] AS ([c1]+(2000)),
    [c9] AS ([c1]+(3000)) PERSISTED
) ON [PRIMARY]
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[tbl]
    ADD CONSTRAINT [CHK_c7_tbl] CHECK  (([c7]>(1) AND [c7]<(999999)))
GO

--------------------------------------------------------------------------------

ALTER TABLE [dbo].[tbl]
    ADD CONSTRAINT [PK_tbl] PRIMARY KEY CLUSTERED  ([c1]) ON [PRIMARY]
GO

--------------------------------------------------------------------------------

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE PROCEDURE [dbo].[prc]
@first integer
AS
    SELECT 1 AS trigger_action;
    UPDATE [dbo].[tbl]
    SET c5 = ((SELECT MAX(c1) FROM [dbo].[tbl]) + 1000)
    WHERE c1 = 2;
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TRIGGER [dbo].[trg] ON [dbo].[tbl]
AFTER INSERT
AS EXECUTE [dbo].[prc] @first = 4
GO


SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[v] AS
    SELECT 
    a.[c1],
    a.[c2],
    a.[c5]
FROM [dbo].[tbl] a
GO

CREATE TABLE [dbo].[testtable](
	[id] [bigint] NOT NULL IDENTITY (1, 452),
	[c2] [bigint] NULL,
	[c4] [bigint] NULL,
	[c3] [text] COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

CREATE TABLE [dbo].[testtable11](
	[id] [bigint] NOT NULL,
	[c4] [bigint] NULL,
	[c3] [text] COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO