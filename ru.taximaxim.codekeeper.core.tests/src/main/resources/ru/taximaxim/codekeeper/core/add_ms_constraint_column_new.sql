SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar](100) NOT NULL,
    [c4] [int] NOT NULL)
GO

ALTER TABLE [dbo].[table1] 
    ADD CONSTRAINT [PK_table1] PRIMARY KEY CLUSTERED  ([c1]) WITH (DATA_COMPRESSION = PAGE) ON [PRIMARY]
GO

ALTER TABLE [dbo].[table1] WITH NOCHECK
    ADD CONSTRAINT [constraint_check_c2] CHECK (c2 > 10)
GO

ALTER TABLE [dbo].[table1] NOCHECK CONSTRAINT [constraint_check_c2]
GO

ALTER TABLE [dbo].[table1]
    ADD CONSTRAINT [constraint_default_c2] DEFAULT 50 FOR c2
GO

ALTER TABLE [dbo].[table1]
    ADD UNIQUE ([c4])
GO