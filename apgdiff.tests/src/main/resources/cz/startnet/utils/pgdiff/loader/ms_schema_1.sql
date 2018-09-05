CREATE SCHEMA [msschema]  
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[contacts] (
    [id] [int],
    [number_pool_id] [int],
    [name] [varchar](50))
GO

CREATE NONCLUSTERED INDEX [IX_contacts_number_pool_id] ON [dbo].[contacts] ([number_pool_id])
GO