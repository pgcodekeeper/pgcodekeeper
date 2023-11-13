SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[fax_boxes] (
	[fax_box_id] [int] NOT NULL,
	[name] [text])
GO

ALTER TABLE [dbo].[fax_boxes] 
    ADD CONSTRAINT [PK_fax_boxes] PRIMARY KEY CLUSTERED  ([fax_box_id]) ON [PRIMARY]
GO

ALTER AUTHORIZATION ON OBJECT::[dbo].[fax_boxes] TO [ms_user];    
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[faxes] (
    [fax_id] [int] NOT NULL,
    [fax_box_id] [int],
    [from_name] [text],
    [from_number] [text],
    [status] [int],
    [pages] [int],
    [time_received] [datetime],
    [time_finished_received] [datetime],
    [read] [int],
    [station_id] [text])
GO

ALTER TABLE [dbo].[faxes] 
    ADD CONSTRAINT [PK_faxes] PRIMARY KEY CLUSTERED  ([fax_id]) ON [PRIMARY]
GO

ALTER TABLE [dbo].[faxes] 
    ADD CONSTRAINT [FK_faxes_fax_box_id] FOREIGN KEY (fax_box_id) 
    REFERENCES [dbo].[fax_boxes](fax_box_id) ON DELETE SET NULL ON UPDATE CASCADE
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[extensions] (
    [id] [int] NOT NULL)
GO

ALTER TABLE [dbo].[extensions] 
    ADD CONSTRAINT [FK_extensions_fax_box_id] FOREIGN KEY (fax_box_id) 
    REFERENCES [dbo].[fax_boxes] ON DELETE SET DEFAULT ON UPDATE SET NULL NOT FOR REPLICATION
GO  

ALTER TABLE [dbo].[faxes] 
    ADD CONSTRAINT [DF_faxes_time_received] DEFAULT (getdate()) FOR time_received
GO

ALTER TABLE [dbo].[faxes] 
    ADD CONSTRAINT [DF_faxes_read] DEFAULT 0 FOR [read]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1] (
    [id] [int] NOT NULL)
GO

ALTER TABLE [dbo].[table1] 
    ADD CONSTRAINT [FK_table1_fax_box_id] FOREIGN KEY (fax_box_id) 
    REFERENCES [dbo].[fax_boxes] ON DELETE CASCADE ON UPDATE SET DEFAULT
GO