CREATE SCHEMA [admin]
GO

ALTER AUTHORIZATION ON SCHEMA::[admin] TO [ms_user]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [admin].[acl_role] (
    [id] [bigint] NOT NULL)
GO

ALTER AUTHORIZATION ON OBJECT::[admin].[acl_role] TO [ms_user];    
GO

ALTER TABLE [admin].[acl_role] 
    ADD CONSTRAINT [PK_acl_role] PRIMARY KEY CLUSTERED  ([id]) ON [PRIMARY]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [admin].["user"] (
    [id] [bigint] NOT NULL,
    [email] [nvarchar](255) NOT NULL,
    [name] [nvarchar](255) NOT NULL,
    [password] [nvarchar](40) NOT NULL,
    [is_active] [bit] NOT NULL,
    [updated] [datetime] NOT NULL,
    [created] [datetime] NOT NULL,
    [role_id] [bigint] NOT NULL,
    [last_visit] [datetime] NOT NULL)
GO

ALTER TABLE [admin].["user"]
    ADD CONSTRAINT [DF_admin_is_active] DEFAULT 0 FOR is_active
GO

ALTER TABLE [admin].["user"] 
    ADD CONSTRAINT [DF_admin_updated] DEFAULT (getdate()) FOR updated
GO

ALTER TABLE [admin].["user"] 
    ADD CONSTRAINT [DF_admin_created] DEFAULT (getdate()) FOR created
GO

ALTER TABLE [admin].["user"]
    ADD CONSTRAINT [DF_admin_last_visit] DEFAULT (getdate()) FOR last_visit
GO

ALTER AUTHORIZATION ON OBJECT::[admin].["user"] TO [ms_user];    
GO

CREATE NONCLUSTERED INDEX [IX_user_role_id] ON [admin].["user"] ([role_id])
GO

ALTER TABLE [admin].["user"] 
    ADD CONSTRAINT [FK_user_fax_box_id] FOREIGN KEY (role_id) 
    REFERENCES [admin].[acl_role](id)
GO
