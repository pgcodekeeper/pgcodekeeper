CREATE TABLE [dbo].[t1] (id integer, name text, second_name text)
GO

CREATE VIEW [dbo].[v1] AS 
SELECT
     id
    ,name
    ,ROW_NUMBER() OVER win
FROM dbo.t1
WINDOW win AS (PARTITION BY id ORDER BY second_name)
GO