SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
ALTER TRIGGER [dbo].[trigger1] ON [dbo].[table1]    --my trigger
AFTER UPDATE   
AS RAISERROR ('Edited Notify!', 16, 10)
GO