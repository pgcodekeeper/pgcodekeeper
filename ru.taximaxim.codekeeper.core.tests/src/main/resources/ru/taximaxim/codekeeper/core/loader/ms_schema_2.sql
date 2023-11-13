CREATE SEQUENCE [dbo].[admins_aid_seq]
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 1000000000
    MINVALUE 1
    CACHE 1
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[admins] (
    [aid] [int] NOT NULL,
    [companyid] [int] NOT NULL,
    [groupid] [int] NOT NULL,
    [username] [nvarchar](max) NOT NULL,
    [password] [nvarchar](40) NOT NULL,
    [superuser] [bit] NOT NULL,
    [name] [nvarchar](40),
    [surname] [nvarchar](40),
    [email] [nvarchar](100) NOT NULL,
    [tel] [nvarchar](40),
    [mobile] [nvarchar](40),
    [enabled] [bit] NOT NULL,
    [lastlogints] [datetimeoffset] NOT NULL,
    [expirienced] [bit])
GO
   
ALTER TABLE [dbo].[admins]
    ADD CONSTRAINT [PK_admins] PRIMARY KEY CLUSTERED  ([aid]) ON [PRIMARY]
GO

ALTER TABLE [dbo].[admins]
    ADD CONSTRAINT [DF_admins_aid] DEFAULT (NEXT VALUE FOR [dbo].[admins_aid_seq]) FOR aid
GO

ALTER TABLE [dbo].[admins]
    ADD CONSTRAINT [DF_admins_companyid] DEFAULT 0 FOR companyid
GO

ALTER TABLE [dbo].[admins]
    ADD CONSTRAINT [DF_admins_groupid] DEFAULT 0 FOR groupid
GO

ALTER TABLE [dbo].[admins]
    ADD CONSTRAINT [DF_admins_superuser] DEFAULT 0 FOR superuser
GO

ALTER TABLE [dbo].[admins]
    ADD CONSTRAINT [DF_admins_enabled] DEFAULT 1 FOR enabled
GO

ALTER TABLE [dbo].[admins] 
    ADD CONSTRAINT [DF_admins_lastlogints] DEFAULT (getdate()) FOR lastlogints
GO

ALTER TABLE [dbo].[admins]
    ADD CONSTRAINT [DF_admins_expirienced] DEFAULT 0 FOR expirienced
GO