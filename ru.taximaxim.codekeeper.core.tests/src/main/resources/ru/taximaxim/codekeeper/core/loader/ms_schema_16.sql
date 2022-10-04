SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].["t_work"] (
   [id] [int])
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].["t_chart"] (
   [id] [int])
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].["t_memo"] (
   [name] [text])
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[v_subselect] AS
    SELECT 
        c.[id] AS id_t_chart, 
        t.[id] AS id_t_work, 
        t.[name]
    FROM (SELECT 
              w.[id], 
              m.[name] 
          FROM (SELECT 
                    ["t_work"].[id]
                FROM [dbo].["t_work"]) w 
          JOIN [dbo].["t_memo"] m ON w.[id] = CONVERT(INT, CONVERT(VARCHAR(MAX), m.[name]))) t
    JOIN [dbo].["t_chart"] c ON t.[id] = c.[id]
GO
