SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[table1](
	[c1] [int] NOT NULL,
	[c2] [int] NOT NULL
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[table1]
		ADD CONSTRAINT [PK_table1] PRIMARY KEY CLUSTERED  ([c1]) ON [PRIMARY]
GO

CREATE SEQUENCE [dbo].[seq1]
    AS bigint
    START WITH 555888
    INCREMENT BY 555
    MAXVALUE 5557772036854775807
    MINVALUE 555777
    CACHE 
GO

CREATE TYPE [dbo].[type1] FROM [int] NOT NULL
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE VIEW [dbo].[view1] AS
    SELECT 
    a.[c1],
    a.[c2]
FROM [dbo].[table1] a
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[ReturnSum](@First int, @Second int) 
RETURNS integer
AS
BEGIN
  DECLARE @Res integer = 0;
  
  SET @Res = @First + @Second;

  IF @Res < 0
    SET @Res = 0;
  
  RETURN @Res;
END
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE PROCEDURE [dbo].[proc1] @first integer, @second integer
AS
SET NOCOUNT ON;  
    SELECT t.[c1], t.[c2], (@first + @second) AS val  
    FROM [dbo].[table1] t;
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TRIGGER [dbo].[trigger1] ON [dbo].[table1]  
AFTER INSERT, UPDATE   
AS RAISERROR ('Notify!', 16, 10)
GO

CREATE NONCLUSTERED INDEX [index_c2] ON [dbo].[table1] ([c2])
ON [PRIMARY]
GO

CREATE SCHEMA [test] AUTHORIZATION [dbo]
GO

CREATE SCHEMA [worker] AUTHORIZATION [dbo]
GO

CREATE SCHEMA [country] AUTHORIZATION [dbo]
GO

CREATE SCHEMA [ignore1] AUTHORIZATION [dbo]
GO

CREATE SCHEMA [ignoreI4vrw] AUTHORIZATION [dbo]
GO

CREATE SCHEMA [ignore] AUTHORIZATION [dbo]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO

CREATE FUNCTION [worker].[get_changes](@First int, @Second int) 
RETURNS integer
AS
BEGIN
  DECLARE @Res integer = 0;
  
  SET @Res = @First + @Second;

  IF @Res < 0
    SET @Res = 0;
  
  RETURN @Res;
END
GO

CREATE TABLE [country].[city](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL
) ON [PRIMARY]
GO

ALTER TABLE [country].[city]
        ADD CONSTRAINT [PK_city] PRIMARY KEY CLUSTERED  ([c1]) ON [PRIMARY]
GO

CREATE FUNCTION [ignoreI4vrw].[get_func](@First int, @Second int) 
RETURNS integer
AS
BEGIN
  DECLARE @Res integer = 0;
  
  SET @Res = @First + @Second;

  IF @Res < 0
    SET @Res = 0;
  
  RETURN @Res;
END
GO

CREATE FUNCTION [ignore1].[get_func](@First int, @Second int) 
RETURNS integer
AS
BEGIN
  DECLARE @Res integer = 0;
  
  SET @Res = @First + @Second;

  IF @Res < 0
    SET @Res = 0;
  
  RETURN @Res;
END
GO

CREATE TABLE [ignore].[city](
    [c1] [int] NOT NULL,
    [c2] [int] NOT NULL
) ON [PRIMARY]
GO

ALTER TABLE [ignore].[city]
        ADD CONSTRAINT [PK_city] PRIMARY KEY CLUSTERED  ([c1]) ON [PRIMARY]
GO