ALTER PARTITION FUNCTION R () MERGE RANGE (100)
GO
ALTER PARTITION FUNCTION R () SPLIT RANGE (500)
GO
ALTER PARTITION FUNCTION R () SPLIT RANGE (@CurrentPoint)
GO

CREATE FUNCTION [main].[TestParentheses]
  (
    @WHY INTEGER
  )
  RETURNS TABLE
  AS
  RETURN
  (
  SELECT @WHY + 1 AS UltimateAnswer
  )
GO
--create function return table , no BEGIN and END in this case
create function Test (@TZ int)
returns table
as
return
(
    select  1 AS s FROM dbo.Table1
)
GO

--create function return table with indeces and constraints
CREATE FUNCTION [dbo].[func_name]()
RETURNS @Result TABLE
(
     [col1] INT INDEX index_name CLUSTERED with (fillfactor=10)
    ,[col2] NCHAR(3)
    ,[col3] INT
    ,[col4] INT primary key NONCLUSTERED with (fillfactor=10)
    ,[col5] INT
    ,INDEX index_name2 UNIQUE NONCLUSTERED ([col1]) with (fillfactor=10)
    ,UNIQUE NONCLUSTERED ([col1] ASC)
)
AS
BEGIN
    INSERT INTO @Result([col1], [col2])
    SELECT t1.col1, t2.col2
    FROM (VALUES
      (N'v08'),
      (N'v09')
      ) AS t2 (col2)
      INNER JOIN [dbo].[table_1_name]() AS t1 ON t1.col3 = t2.col2
    RETURN;
END
GO

--create function return date_type
Create Function dbo.FooBar(
    @p1 nVarchar(4000)
)
Returns int
As
Begin
  return 123;
END
GO

--create function return @val table 
CREATE OR ALTER FUNCTION [dbo].[Foo](@String nvarchar(4000))
RETURNS @Bar TABLE (Col1 nvarchar(4000))
AS
   BEGIN

   RETURN
END
GO
--Alter Function, should behave the same as create function, except the ALTER keyword
ALTER FUNCTION [dbo].[Foo](@String nvarchar(4000))
RETURNS @Bar TABLE (Col1 nvarchar(4000))
AS
   BEGIN

   RETURN
END
GO
--drop Function, you can drop multiple at same time
Drop function Func1
drop function Func1 , Func2
GO

--create function return date_type and WITH INLINE = ON
Create Function dbo.FooBar3(
    @p1 nVarchar(4000)
)
Returns int
WITH INLINE = ON
As
Begin
  return 123;
END
GO

-- Non-breaking spaces
CREATE PROCEDURE [dbo].[test_nbsp]
AS
BEGIN
	SELECT 1
  from (values
  		(1),
  		(2)
  ) v(a)

END
GO