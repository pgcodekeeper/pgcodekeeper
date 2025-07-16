SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[t1](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar](100) NOT NULL)
GO

ALTER TABLE [dbo].[t1]
    ADD CONSTRAINT [pk] PRIMARY KEY (c1, c2)
GO

CREATE TABLE [dbo].[t_pk](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar](100) NOT NULL)
GO

ALTER TABLE [dbo].[t_pk]
    ADD CONSTRAINT [t_pk_pk] PRIMARY KEY (c1, c2)
GO

CREATE TABLE [dbo].[t_fk_1](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar](100) NOT NULL)
GO

ALTER TABLE [dbo].[t_fk_1]
    ADD CONSTRAINT [t_fk_1_fk] FOREIGN KEY (c1, c2) REFERENCES [dbo].[t_pk] (c1, c2)
GO

CREATE TABLE [dbo].[t_fk_2](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL,
    [c3] [varchar](100) NOT NULL)
GO

ALTER TABLE [dbo].[t_fk_2]
    ADD CONSTRAINT [t_fk_2_fk] FOREIGN KEY (c1, c2) REFERENCES [dbo].[t_pk] (c1, c2)
GO