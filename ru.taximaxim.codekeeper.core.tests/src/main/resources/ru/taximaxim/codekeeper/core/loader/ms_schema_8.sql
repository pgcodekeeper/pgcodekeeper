SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[user_data] (
    [id] [bigint] NOT NULL,
    [email] [nvarchar](128) NOT NULL,
    [created] [datetimeoffset])
GO

ALTER TABLE [dbo].[user_data] 
    ADD CONSTRAINT [DF_user_data_created] DEFAULT getdate() FOR created
GO

ALTER AUTHORIZATION ON OBJECT::[dbo].[user_data] TO [ms_user];    
GO

CREATE SEQUENCE [dbo].[user_id_seq]
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1
GO

ALTER AUTHORIZATION ON OBJECT::[dbo].[user_id_seq] TO [ms_user];    
GO

ALTER TABLE [dbo].[user_data]
    ADD CONSTRAINT [DF_user_data_id] DEFAULT (NEXT VALUE FOR [dbo].[user_id_seq]) FOR id
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[t1] (
    [c1] [int])
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].["user"] AS
    SELECT 
    [user_data].[id],
    [user_data].[email],
    [user_data].[created]
FROM [dbo].[user_data]
GO

ALTER AUTHORIZATION ON OBJECT::[dbo].["user"] TO [ms_user];    
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[ws_test] AS
    SELECT 
    ud.[id] AS "   i   d   "
FROM [dbo].[user_data] ud
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TRIGGER [dbo].[instead_of_delete] 
    ON [dbo].["user"]
    INSTEAD OF DELETE
    AS
    BEGIN
        DELETE FROM [dbo].[user_data]
        WHERE id = 10  
    END
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TRIGGER [dbo].[instead_of_insert] 
    ON [dbo].["user"]
    INSTEAD OF INSERT
    AS
    BEGIN
        INSERT INTO [dbo].[user_data] (id, email, created)
        VALUES(1, 'test@supermail.loc', getdate())
    END
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TRIGGER [dbo].[instead_of_update] 
    ON [dbo].["user"]
    INSTEAD OF UPDATE
    AS
    BEGIN
        UPDATE [dbo].[user_data] 
        SET id = 55, email = 'super@supermail.loc'
        WHERE id = 4
    END
GO
