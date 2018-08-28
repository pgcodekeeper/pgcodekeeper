SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar](100) NOT NULL)
GO

ALTER TABLE [dbo].[table1] WITH NOCHECK
    ADD CONSTRAINT [constraint_check_c1] CHECK (c1 > 0)
GO

ALTER TABLE [dbo].[table1] NOCHECK CONSTRAINT [constraint_check_c1]
GO

ALTER TABLE [dbo].[table1] WITH NOCHECK
    ADD CONSTRAINT [constraint_check_c2] CHECK (c2 > 10)
GO

ALTER TABLE [dbo].[table1] NOCHECK CONSTRAINT [constraint_check_c2]
GO