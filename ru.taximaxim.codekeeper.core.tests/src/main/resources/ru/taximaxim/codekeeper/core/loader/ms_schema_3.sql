CREATE SEQUENCE [dbo].[call_logs_id_seq]
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
CREATE TABLE [dbo].[call_logs] (
    [id] [bigint] NOT NULL)
GO

ALTER TABLE [dbo].[call_logs]
    ADD CONSTRAINT [DF_call_logs_id] DEFAULT (NEXT VALUE FOR [dbo].[call_logs_id_seq]) FOR id
GO