CREATE TABLE [dbo].[table1](
    [c1] [int] NOT NULL,
    [c2] [varchar](100) NOT NULL)
GO

CREATE FUNCTION [dbo].[ReturnOne]() 
RETURNS integer
AS
BEGIN
  RETURN 1
END
GO