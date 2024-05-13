--added new col
CREATE TABLE [dbo].[Table1](
  [c0] [int] NULL,
  [c1] [int] NULL,
  [c2] [int] NULL
) ON [PRIMARY]
GO

CREATE TYPE [dbo].[custom_type] FROM [bit]
GO

CREATE FUNCTION [dbo].[TestParentheses]
  (
    @WHY dbo.custom_type
  )
  RETURNS TABLE
  AS
  RETURN
  (
    select 1 AS s FROM dbo.Table1
  )
GO
