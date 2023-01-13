CREATE AGGREGATE dbo.Product (@number float) RETURNS float
   EXTERNAL NAME dbo.ProductExt
GO