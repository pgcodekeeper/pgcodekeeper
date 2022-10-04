CREATE SCHEMA [test_schema]
AUTHORIZATION [test_user]
GO

CREATE SEQUENCE [dbo].[test_sequence]
    AS [bigint]
    START WITH -9223372036854775808
    INCREMENT BY 1
    MAXVALUE 9223372036854775807
    MINVALUE -9223372036854775808
    CACHE 
GO

ALTER AUTHORIZATION ON [dbo].[test_sequence] TO [test_user]
GO

CREATE TYPE [dbo].[test_type] FROM [bit]
GO

ALTER AUTHORIZATION ON TYPE::[dbo].[test_type] TO [test_user]
GO

CREATE ASSEMBLY [test_assembly]
AUTHORIZATION [test_user]
FROM 0x4D5A900003
GO

CREATE FUNCTION [dbo].[test_function]() 
RETURNS integer
AS
BEGIN
  RETURN 1
END
GO

ALTER AUTHORIZATION ON [dbo].[test_function] TO [test_user]
GO

CREATE PROCEDURE [dbo].[test_procedure]
WITH EXECUTE AS CALLER
AS SELECT 1
GO

ALTER AUTHORIZATION ON [dbo].[test_procedure] TO [test_user]
GO

CREATE TABLE [dbo].[test_table] (
    [c1] integer
)
GO

ALTER AUTHORIZATION ON [dbo].[test_table] TO [test_user]
GO

CREATE VIEW [dbo].[test_view]
AS SELECT 1 AS id
GO

ALTER AUTHORIZATION ON [dbo].[test_view] TO [test_user]
GO