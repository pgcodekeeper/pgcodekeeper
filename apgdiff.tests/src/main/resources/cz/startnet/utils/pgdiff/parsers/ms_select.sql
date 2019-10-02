-----------------------------------------------------------------------
-- SELECT https://msdn.microsoft.com/en-us/library/ms187731.aspx

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using SELECT to retrieve rows and columns

USE AdventureWorks2012;
GO
SELECT *
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT p.*
FROM Production.Product AS p
ORDER BY Name ASC;
GO

USE AdventureWorks2012;
GO
SELECT Name, ProductNumber, ListPrice AS Price
FROM Production.Product 
ORDER BY Name ASC;
GO

USE AdventureWorks2012;
GO
SELECT Name, ProductNumber, ListPrice AS Price
FROM Production.Product 
WHERE ProductLine = 'R' 
AND DaysToManufacture < 4
ORDER BY Name ASC;
GO

-- Select with Multiple Batch Separators
USE AdventureWorks2012;
GO
SELECT *
FROM Production.Product
ORDER BY Name ASC;
GO
GO

USE AdventureWorks2012;
GO
SELECT
    [Production].[Product].[ProductID],
    [Production].[Product].[Name]
FROM [Production].[Product]
GO

USE AdventureWorks2012;
GO
SELECT *, *, * -- yes, syntax is valid
FROM [Production].[Product]
GO

USE AdventureWorks2012;
GO
SELECT
    some_type::static_method (@arg1, @arg2, @arg3),
    another_type::method ('some value'),
    still_one_type.non_static_method (@but, @with, @params)
FROM [Production].[Product]
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using SELECT with column headings and calculations

USE AdventureWorks2012;
GO
SELECT p.Name AS ProductName, 
NonDiscountSales = (OrderQty * UnitPrice),
Discounts = ((OrderQty * UnitPrice) * UnitPriceDiscount)
FROM Production.Product AS p 
INNER JOIN Sales.SalesOrderDetail AS sod
ON p.ProductID = sod.ProductID 
ORDER BY ProductName DESC;
GO

USE AdventureWorks2012;
GO
SELECT 'Total income is', ((OrderQty * UnitPrice) * (1.0 - UnitPriceDiscount)), ' for ',
p.Name AS ProductName 
FROM Production.Product AS p 
INNER JOIN Sales.SalesOrderDetail AS sod
ON p.ProductID = sod.ProductID 
ORDER BY ProductName ASC;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using DISTINCT with SELECT

USE AdventureWorks2012;
GO
SELECT DISTINCT JobTitle
FROM HumanResources.Employee
ORDER BY JobTitle;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Creating tables with SELECT INTO

USE tempdb;
GO
IF OBJECT_ID (N'#Bicycles',N'U') IS NOT NULL
DROP TABLE #Bicycles;
GO
SELECT * 
INTO #Bicycles
FROM AdventureWorks2012.Production.Product
WHERE ProductNumber LIKE 'BK%';
GO

USE AdventureWorks2012;
GO
IF OBJECT_ID('dbo.NewProducts', 'U') IS NOT NULL
    DROP TABLE dbo.NewProducts;
GO
ALTER DATABASE AdventureWorks2012 SET RECOVERY BULK_LOGGED;
GO

SELECT * INTO dbo.NewProducts
FROM Production.Product
WHERE ListPrice > $25 
AND ListPrice < $100;
GO
ALTER DATABASE AdventureWorks2012 SET RECOVERY FULL;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using correlated subqueries

USE AdventureWorks2012;
GO
SELECT DISTINCT Name
FROM Production.Product AS p 
WHERE EXISTS
    (SELECT *
     FROM Production.ProductModel AS pm 
     WHERE p.ProductModelID = pm.ProductModelID
           AND pm.Name LIKE 'Long-Sleeve Logo Jersey%');
GO

-- OR

USE AdventureWorks2012;
GO
SELECT DISTINCT Name
FROM Production.Product
WHERE ProductModelID IN
    (SELECT ProductModelID 
     FROM Production.ProductModel
     WHERE Name LIKE 'Long-Sleeve Logo Jersey%');
GO

USE AdventureWorks2012;
GO
SELECT DISTINCT p.LastName, p.FirstName 
FROM Person.Person AS p 
JOIN HumanResources.Employee AS e
    ON e.BusinessEntityID = p.BusinessEntityID WHERE 5000.00 IN
    (SELECT Bonus
     FROM Sales.SalesPerson AS sp
     WHERE e.BusinessEntityID = sp.BusinessEntityID);
GO

USE AdventureWorks2012;
GO
SELECT p1.ProductModelID
FROM Production.Product AS p1
GROUP BY p1.ProductModelID
HAVING MAX(p1.ListPrice) >= ALL
    (SELECT AVG(p2.ListPrice)
     FROM Production.Product AS p2
     WHERE p1.ProductModelID = p2.ProductModelID);
GO

USE AdventureWorks2012;
GO
SELECT DISTINCT pp.LastName, pp.FirstName 
FROM Person.Person pp JOIN HumanResources.Employee e
ON e.BusinessEntityID = pp.BusinessEntityID WHERE pp.BusinessEntityID IN 
(SELECT SalesPersonID 
FROM Sales.SalesOrderHeader
WHERE SalesOrderID IN 
(SELECT SalesOrderID 
FROM Sales.SalesOrderDetail
WHERE ProductID IN 
(SELECT ProductID 
FROM Production.Product p 
WHERE ProductNumber = 'BK-M68B-42')));
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using GROUP BY

USE AdventureWorks2012;
GO
SELECT SalesOrderID, SUM(LineTotal) AS SubTotal
FROM Sales.SalesOrderDetail
GROUP BY SalesOrderID
ORDER BY SalesOrderID;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using GROUP BY with multiple groups

USE AdventureWorks2012;
GO
SELECT ProductID, SpecialOfferID, AVG(UnitPrice) AS [Average Price], 
    SUM(LineTotal) AS SubTotal
FROM Sales.SalesOrderDetail
GROUP BY ProductID, SpecialOfferID
ORDER BY ProductID;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using GROUP BY and WHERE

USE AdventureWorks2012;
GO
SELECT ProductModelID, AVG(ListPrice) AS [Average List Price]
FROM Production.Product
WHERE ListPrice > $1000
GROUP BY ProductModelID
ORDER BY ProductModelID;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using GROUP BY with an expression

USE AdventureWorks2012;
GO
SELECT AVG(OrderQty) AS [Average Quantity], 
NonDiscountSales = (OrderQty * UnitPrice)
FROM Sales.SalesOrderDetail
GROUP BY (OrderQty * UnitPrice)
ORDER BY (OrderQty * UnitPrice) DESC;
GO


--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using GROUP BY with ORDER BY

USE AdventureWorks2012;
GO
SELECT ProductID, AVG(UnitPrice) AS [Average Price]
FROM Sales.SalesOrderDetail
WHERE OrderQty > 10
GROUP BY ProductID
ORDER BY AVG(UnitPrice);
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using the HAVING clause

USE AdventureWorks2012;
GO
SELECT ProductID 
FROM Sales.SalesOrderDetail
GROUP BY ProductID
HAVING AVG(OrderQty) > 5
ORDER BY ProductID;
GO

USE AdventureWorks2012 ;
GO
SELECT SalesOrderID, CarrierTrackingNumber 
FROM Sales.SalesOrderDetail
GROUP BY SalesOrderID, CarrierTrackingNumber
HAVING CarrierTrackingNumber LIKE '4BD%'
ORDER BY SalesOrderID ;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using HAVING and GROUP BY

USE AdventureWorks2012;
GO
SELECT ProductID 
FROM Sales.SalesOrderDetail
WHERE UnitPrice < 25.00
GROUP BY ProductID
HAVING AVG(OrderQty) > 5
ORDER BY ProductID;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using HAVING with SUM and AVG

USE AdventureWorks2012;
GO
SELECT ProductID, AVG(OrderQty) AS AverageQuantity, SUM(LineTotal) AS Total
FROM Sales.SalesOrderDetail
GROUP BY ProductID
HAVING SUM(LineTotal) > $1000000.00
AND AVG(OrderQty) < 3;
GO

USE AdventureWorks2012;
GO
SELECT ProductID, Total = SUM(LineTotal)
FROM Sales.SalesOrderDetail
GROUP BY ProductID
HAVING SUM(LineTotal) > $2000000.00;
GO

USE AdventureWorks2012;
GO
SELECT ProductID, SUM(LineTotal) AS Total
FROM Sales.SalesOrderDetail
GROUP BY ProductID
HAVING COUNT(*) > 1500;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using the INDEX optimizer hint

USE AdventureWorks2012;
GO
SELECT pp.FirstName, pp.LastName, e.NationalIDNumber
FROM HumanResources.Employee AS e WITH (INDEX(AK_Employee_NationalIDNumber))
JOIN Person.Person AS pp on e.BusinessEntityID = pp.BusinessEntityID
WHERE LastName = 'Johnson';
GO

-- Force a table scan by using INDEX = 0.
USE AdventureWorks2012;
GO
SELECT pp.LastName, pp.FirstName, e.JobTitle
FROM HumanResources.Employee AS e WITH (INDEX = 0) JOIN Person.Person AS pp
ON e.BusinessEntityID = pp.BusinessEntityID
WHERE LastName = 'Johnson';
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using OPTION and the GROUP hints

USE AdventureWorks2012;
GO
SELECT ProductID, OrderQty, SUM(LineTotal) AS Total
FROM Sales.SalesOrderDetail
WHERE UnitPrice < $5.00
GROUP BY ProductID, OrderQty
ORDER BY ProductID, OrderQty
OPTION (HASH GROUP, FAST 10);
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using the UNION query hint

USE AdventureWorks2012;
GO
SELECT BusinessEntityID, JobTitle, HireDate, VacationHours, SickLeaveHours
FROM HumanResources.Employee AS e1
UNION
SELECT BusinessEntityID, JobTitle, HireDate, VacationHours, SickLeaveHours
FROM HumanResources.Employee AS e2
OPTION (MERGE UNION);
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using a simple UNION

USE AdventureWorks2012;
GO
IF OBJECT_ID ('dbo.Gloves', 'U') IS NOT NULL
DROP TABLE dbo.Gloves;
GO
-- Create Gloves table.
SELECT ProductModelID, Name
INTO dbo.Gloves
FROM Production.ProductModel
WHERE ProductModelID IN (3, 4);
GO

-- Here is the simple union.
USE AdventureWorks2012;
GO
SELECT ProductModelID, Name
FROM Production.ProductModel
WHERE ProductModelID NOT IN (3, 4)
UNION
SELECT ProductModelID, Name
FROM dbo.Gloves
ORDER BY Name;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using SELECT INTO with UNION

USE AdventureWorks2012;
GO
IF OBJECT_ID ('dbo.ProductResults', 'U') IS NOT NULL
DROP TABLE dbo.ProductResults;
GO
IF OBJECT_ID ('dbo.Gloves', 'U') IS NOT NULL
DROP TABLE dbo.Gloves;
GO
-- Create Gloves table.
SELECT ProductModelID, Name
INTO dbo.Gloves
FROM Production.ProductModel
WHERE ProductModelID IN (3, 4);
GO

USE AdventureWorks2012;
GO
SELECT ProductModelID, Name
INTO dbo.ProductResults
FROM Production.ProductModel
WHERE ProductModelID NOT IN (3, 4)
UNION
SELECT ProductModelID, Name
FROM dbo.Gloves;
GO

SELECT ProductModelID, Name 
FROM dbo.ProductResults;

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using UNION of two SELECT statements with ORDER BY

USE AdventureWorks2012;
GO
IF OBJECT_ID ('dbo.Gloves', 'U') IS NOT NULL
DROP TABLE dbo.Gloves;
GO
-- Create Gloves table.
SELECT ProductModelID, Name
INTO dbo.Gloves
FROM Production.ProductModel
WHERE ProductModelID IN (3, 4);
GO

/* CORRECT */
USE AdventureWorks2012;
GO
SELECT ProductModelID, Name
FROM Production.ProductModel
WHERE ProductModelID NOT IN (3, 4)
UNION
SELECT ProductModelID, Name
FROM dbo.Gloves
ORDER BY Name;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using UNION of three SELECT statements to show the effects of ALL and parentheses

USE AdventureWorks2012;
GO
IF OBJECT_ID ('dbo.EmployeeOne', 'U') IS NOT NULL
DROP TABLE dbo.EmployeeOne;
GO
IF OBJECT_ID ('dbo.EmployeeTwo', 'U') IS NOT NULL
DROP TABLE dbo.EmployeeTwo;
GO
IF OBJECT_ID ('dbo.EmployeeThree', 'U') IS NOT NULL
DROP TABLE dbo.EmployeeThree;
GO

SELECT pp.LastName, pp.FirstName, e.JobTitle 
INTO dbo.EmployeeOne
FROM Person.Person AS pp JOIN HumanResources.Employee AS e
ON e.BusinessEntityID = pp.BusinessEntityID
WHERE LastName = 'Johnson';
GO
SELECT pp.LastName, pp.FirstName, e.JobTitle 
INTO dbo.EmployeeTwo
FROM Person.Person AS pp JOIN HumanResources.Employee AS e
ON e.BusinessEntityID = pp.BusinessEntityID
WHERE LastName = 'Johnson';
GO
SELECT pp.LastName, pp.FirstName, e.JobTitle 
INTO dbo.EmployeeThree
FROM Person.Person AS pp JOIN HumanResources.Employee AS e
ON e.BusinessEntityID = pp.BusinessEntityID
WHERE LastName = 'Johnson';
GO
-- Union ALL
SELECT LastName, FirstName, JobTitle
FROM dbo.EmployeeOne
UNION ALL
SELECT LastName, FirstName ,JobTitle
FROM dbo.EmployeeTwo
UNION ALL
SELECT LastName, FirstName,JobTitle 
FROM dbo.EmployeeThree;
GO

SELECT LastName, FirstName,JobTitle
FROM dbo.EmployeeOne
UNION 
SELECT LastName, FirstName, JobTitle 
FROM dbo.EmployeeTwo
UNION 
SELECT LastName, FirstName, JobTitle 
FROM dbo.EmployeeThree;
GO

SELECT LastName, FirstName,JobTitle 
FROM dbo.EmployeeOne
UNION ALL
(
SELECT LastName, FirstName, JobTitle 
FROM dbo.EmployeeTwo
UNION
SELECT LastName, FirstName, JobTitle 
FROM dbo.EmployeeThree
);
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using SELECT with TOP clause

USE AdventureWorks2012;
GO
SELECT TOP 10 *
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT TOP (10) *
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT TOP (@localvar) *
FROM Production.Product
ORDER BY Name ASC;

-- TOP with percentage.
USE AdventureWorks2012;
GO
SELECT TOP 10.5 PERCENT *
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT TOP (10.5) PERCENT *
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT TOP (@localvar) PERCENT *
FROM Production.Product
ORDER BY Name ASC;

-- TOP with ties.
USE AdventureWorks2012;
GO
SELECT TOP 10 WITH TIES *
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT TOP 10.5 PERCENT WITH TIES *
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT TOP (@localvar) WITH TIES *
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT TOP (@localvar) PERCENT WITH TIES *
FROM Production.Product
ORDER BY Name ASC;

-- Can apply any expression WITH parentheses.
--  If without parentheses, expression trails may be misunderstanding select_list.
--  ex: "SELECT TOP 1 + 2 * FROM HOGE" --> "+ 2" are matching in select_list.
USE AdventureWorks2012;
GO
SELECT TOP (NULL) *     -- (But cause runtime error by SQL Server)
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT TOP (1+2) *
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT TOP (1+@localvar) *
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT TOP (NULL) PERCENT *     -- (But cause runtime error by SQL Server)
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT TOP (1+2) PERCENT *
FROM Production.Product
ORDER BY Name ASC;
-- Alternate way.
USE AdventureWorks2012;
GO
SELECT TOP (1+@localvar) PERCENT *
FROM Production.Product
ORDER BY Name ASC;

-- TRY_CAST & TRY_CONVERT
use AdventureWorks2012;
GO
SELECT TRY_CAST(SalesOrderID AS INT),
    TRY_CONVERT(INT, SalesOrderID)
FROM Sales.SalesOrderDetail
WHERE SalesOrderDetailID = 1;
GO

-- SET statement
SET ANSI_WARNINGS OFF;
SELECT id FROM tbl;
GO

-- Select with full table name
SELECT * FROM ServerName.DBName.do.TestTable TestTable

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using SELECT from build in function
SELECT * FROM ::fn_helpcollations()


--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using PIVOT and UNPIVOT statements

-- Pivot table with one row and five columns
SELECT 'AverageCost' AS Cost_Sorted_By_Production_Days, 
[0], [1], [2], [3], [4]
FROM
(SELECT DaysToManufacture, StandardCost 
    FROM Production.Product) AS SourceTable
PIVOT
(
AVG(StandardCost)
FOR DaysToManufacture IN ([0], [1], [2], [3], [4])
) AS PivotTable;

--Create the table and insert values as portrayed in the previous example.
CREATE TABLE pvt (VendorID int, Emp1 int, Emp2 int,
    Emp3 int, Emp4 int, Emp5 int);
GO
INSERT INTO pvt VALUES (1,4,3,5,4,4);
INSERT INTO pvt VALUES (2,4,1,5,5,5);
INSERT INTO pvt VALUES (3,4,3,5,4,4);
INSERT INTO pvt VALUES (4,4,2,5,5,4);
INSERT INTO pvt VALUES (5,5,1,5,5,5);
GO
--Unpivot the table.
SELECT VendorID, Employee, Orders
FROM 
   (SELECT VendorID, Emp1, Emp2, Emp3, Emp4, Emp5
   FROM pvt) p
UNPIVOT
   (Orders FOR Employee IN 
      (Emp1, Emp2, Emp3, Emp4, Emp5)
)AS unpvt;
GO
--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using table value constructor

SELECT a, b FROM (VALUES (1, 2), (3, 4), (5, 6), (7, 8), (9, 10) ) AS MyTable(a, b);  
GO  
-- Used in an inner join to specify values to return.  
SELECT ProductID, a.Name, Color  
FROM Production.Product AS a  
INNER JOIN (VALUES ('Blade'), ('Crown Race'), ('AWC Logo Cap')) AS b(Name)   
ON a.Name = b.Name;  

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Open XML Statement


DECLARE @idoc int, @doc varchar(1000);  
SET @doc ='  
<ROOT>  
<Customer CustomerID="VINET" ContactName="Paul Henriot">  
   <Order CustomerID="VINET" EmployeeID="5" OrderDate="1996-07-04T00:00:00">  
      <OrderDetail OrderID="10248" ProductID="11" Quantity="12"/>  
      <OrderDetail OrderID="10248" ProductID="42" Quantity="10"/>  
   </Order>  
</Customer>  
<Customer CustomerID="LILAS" ContactName="Carlos Gonzlez">  
   <Order CustomerID="LILAS" EmployeeID="3" OrderDate="1996-08-16T00:00:00">  
      <OrderDetail OrderID="10283" ProductID="72" Quantity="3"/>  
   </Order>  
</Customer>  
</ROOT>';  
--Create an internal representation of the XML document.  
EXEC sp_xml_preparedocument @idoc OUTPUT, @doc;  
-- Execute a SELECT statement that uses the OPENXML rowset provider.  
SELECT    *  
FROM       OPENXML (@idoc, '/ROOT/Customer',1)  
            WITH (CustomerID  varchar(10),  
                  ContactName varchar(20));  
				  

				  DECLARE @idoc int, @doc varchar(1000);   
SET @doc ='  
<ROOT>  
<Customer CustomerID="VINET" ContactName="Paul Henriot">  
   <Order OrderID="10248" CustomerID="VINET" EmployeeID="5"   
           OrderDate="1996-07-04T00:00:00">  
      <OrderDetail ProductID="11" Quantity="12"/>  
      <OrderDetail ProductID="42" Quantity="10"/>  
   </Order>  
</Customer>  
<Customer CustomerID="LILAS" ContactName="Carlos Gonzlez">v  
   <Order OrderID="10283" CustomerID="LILAS" EmployeeID="3"   
           OrderDate="1996-08-16T00:00:00">  
      <OrderDetail ProductID="72" Quantity="3"/>  
   </Order>  
</Customer>  
</ROOT>';   
  
--Create an internal representation of the XML document.  
EXEC sp_xml_preparedocument @idoc OUTPUT, @doc;   
  
-- SELECT stmt using OPENXML rowset provider  
SELECT *  
FROM   OPENXML (@idoc, '/ROOT/Customer/Order/OrderDetail',2)   
         WITH (OrderID       int         '../@OrderID',   
               CustomerID  varchar(10) '../@CustomerID',   
               OrderDate   datetime    '../@OrderDate',   
               ProdID      int         '@ProductID',   
               Qty         int         '@Quantity');  

select '1' + '2';


SELECT FIRST_VALUE(SalesOrderNumber) OVER(PARTITION BY CustomerID ORDER BY OrderDate) 
    AS FirstSONumberPerCustomer
FROM Sales.SalesOrderHeader;


SELECT LAST_VALUE(SalesOrderNumber) OVER(PARTITION BY CustomerID ORDER BY OrderDate ROWS UNBOUNDED PRECEDING) 
    AS FirstSONumberPerCustomer
FROM Sales.SalesOrderHeader;

SELECT LAG(PurchaseOrderNumber,2) OVER(PARTITION BY CustomerID ORDER BY OrderDate) AS PrevPONumberOffset2
FROM sales.SalesOrderHeader;

SELECT LEAD(PurchaseOrderNumber) OVER(PARTITION BY CustomerID ORDER BY OrderDate) AS NextPONumber
FROM sales.SalesOrderHeader;

SELECT * FROM OPENROWSET('SQLOLEDB', 'Server=.\SQLEXPRESS;Trusted_Connection=yes;', 'SET FMTONLY OFF;SET NOCOUNT ON;exec(''RESTORE headeronly FROM  DISK = N''''C:\Temp\Dev\SQL2012Backup.bak'''''')')
GO


-----------------------------------------------------------------------
-- ranking_windowed_function

-- Simple CASE expression: 
-- CASE input_expression 
     -- WHEN when_expression THEN result_expression [ ...n ] 
     -- [ ELSE else_result_expression ] 
-- END 
-- Searched CASE expression:
-- CASE
     -- WHEN Boolean_expression THEN result_expression [ ...n ] 
     -- [ ELSE else_result_expression ] 
-- END

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using a SELECT statement with a simple CASE expression

USE AdventureWorks2012;
GO
SELECT   ProductNumber, Category =
      CASE ProductLine
         WHEN 'R' THEN 'Road'
         WHEN 'M' THEN 'Mountain'
         WHEN 'T' THEN 'Touring'
         WHEN 'S' THEN 'Other sale items'
         ELSE 'Not for sale'
      END,
   Name
FROM Production.Product
ORDER BY ProductNumber;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using a SELECT statement with a searched CASE expression

USE AdventureWorks2012;
GO
SELECT   ProductNumber, Name, "Price Range" = 
      CASE 
         WHEN ListPrice =  0 THEN 'Mfg item - not for resale'
         WHEN ListPrice < 50 THEN 'Under $50'
         WHEN ListPrice > = 50 and ListPrice < 250 THEN 'Under $250'
         WHEN ListPrice > = 250 and ListPrice < 1000 THEN 'Under $1000'
         ELSE 'Over $1000'
      END
FROM Production.Product
ORDER BY ProductNumber ;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using CASE in an ORDER BY clause

SELECT BusinessEntityID, SalariedFlag
FROM HumanResources.Employee
ORDER BY CASE SalariedFlag WHEN 1 THEN BusinessEntityID END DESC
        ,CASE WHEN SalariedFlag = 0 THEN BusinessEntityID END;
GO

SELECT BusinessEntityID, LastName, TerritoryName, CountryRegionName
FROM Sales.vSalesPerson
WHERE TerritoryName IS NOT NULL
ORDER BY CASE CountryRegionName WHEN 'United States' THEN TerritoryName
         ELSE CountryRegionName END;
         
--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using CASE in an UPDATE statement

USE AdventureWorks2012;
GO
UPDATE HumanResources.Employee
SET VacationHours = 
    ( CASE
         WHEN ((VacationHours - 10.00) < 0) THEN VacationHours + 40
         ELSE (VacationHours + 20.00)
       END
    )
OUTPUT Deleted.BusinessEntityID, Deleted.VacationHours AS BeforeValue, 
       Inserted.VacationHours AS AfterValue
WHERE SalariedFlag = 0; 

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using CASE in a SET statement
-- TODO: uncomment when create_function will be implemented.

-- USE AdventureWorks2012;
-- GO
-- CREATE FUNCTION dbo.GetContactInformation(@BusinessEntityID int)
    -- RETURNS @retContactInformation TABLE 
-- (
-- BusinessEntityID int NOT NULL,
-- FirstName nvarchar(50) NULL,
-- LastName nvarchar(50) NULL,
-- ContactType nvarchar(50) NULL,
    -- PRIMARY KEY CLUSTERED (BusinessEntityID ASC)
-- ) 
-- AS 
-- -- Returns the first name, last name and contact type for the specified contact.
-- BEGIN
    -- DECLARE 
        -- @FirstName nvarchar(50), 
        -- @LastName nvarchar(50), 
        -- @ContactType nvarchar(50);

    -- -- Get common contact information
    -- SELECT 
        -- @BusinessEntityID = BusinessEntityID, 
-- @FirstName = FirstName, 
        -- @LastName = LastName
    -- FROM Person.Person 
    -- WHERE BusinessEntityID = @BusinessEntityID;

    -- SET @ContactType = 
        -- CASE 
            -- -- Check for employee
            -- WHEN EXISTS(SELECT * FROM HumanResources.Employee AS e 
                -- WHERE e.BusinessEntityID = @BusinessEntityID) 
                -- THEN 'Employee'

            -- -- Check for vendor
            -- WHEN EXISTS(SELECT * FROM Person.BusinessEntityContact AS bec
                -- WHERE bec.BusinessEntityID = @BusinessEntityID) 
                -- THEN 'Vendor'

            -- -- Check for store
            -- WHEN EXISTS(SELECT * FROM Purchasing.Vendor AS v          
                -- WHERE v.BusinessEntityID = @BusinessEntityID) 
                -- THEN 'Store Contact'

            -- -- Check for individual consumer
            -- WHEN EXISTS(SELECT * FROM Sales.Customer AS c 
                -- WHERE c.PersonID = @BusinessEntityID) 
                -- THEN 'Consumer'
        -- END;

    -- -- Return the information to the caller
    -- IF @BusinessEntityID IS NOT NULL 
    -- BEGIN
        -- INSERT @retContactInformation
        -- SELECT @BusinessEntityID, @FirstName, @LastName, @ContactType;
    -- END;

    -- RETURN;
-- END;
-- GO

-- SELECT BusinessEntityID, FirstName, LastName, ContactType
-- FROM dbo.GetContactInformation(2200);
-- GO
-- SELECT BusinessEntityID, FirstName, LastName, ContactType
-- FROM dbo.GetContactInformation(5);

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using CASE in a HAVING clause

USE AdventureWorks2012;
GO
SELECT JobTitle, MAX(ph1.Rate)AS MaximumRate
FROM HumanResources.Employee AS e
JOIN HumanResources.EmployeePayHistory AS ph1 ON e.BusinessEntityID = ph1.BusinessEntityID
GROUP BY JobTitle
HAVING (MAX(CASE WHEN Gender = 'M' 
        THEN ph1.Rate 
        ELSE NULL END) > 40.00
     OR MAX(CASE WHEN Gender  = 'F' 
        THEN ph1.Rate  
        ELSE NULL END) > 42.00)
ORDER BY MaximumRate DESC;

-----------------------------------------------------------------------
-- RANK https://msdn.microsoft.com/en-us/library/ms176102.aspx
-- RANK ( ) OVER ( [ partition_by_clause ] order_by_clause )

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Ranking rows within a partition

USE AdventureWorks2012;
GO
SELECT i.ProductID, p.Name, i.LocationID, i.Quantity
    ,RANK() OVER 
    (PARTITION BY i.LocationID ORDER BY i.Quantity DESC) AS Rank
FROM Production.ProductInventory AS i 
INNER JOIN Production.Product AS p 
    ON i.ProductID = p.ProductID
WHERE i.LocationID BETWEEN 3 AND 4
ORDER BY i.LocationID;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Ranking all rows in a result set

USE AdventureWorks2012
SELECT TOP(10) BusinessEntityID, Rate, 
       RANK() OVER (ORDER BY Rate DESC) AS RankBySalary
FROM HumanResources.EmployeePayHistory AS eph1
WHERE RateChangeDate = (SELECT MAX(RateChangeDate) 
                        FROM HumanResources.EmployeePayHistory AS eph2
                        WHERE eph1.BusinessEntityID = eph2.BusinessEntityID)
ORDER BY BusinessEntityID;

-----------------------------------------------------------------------
-- DENSE_RANK https://msdn.microsoft.com/en-us/library/ms173825.aspx
-- DENSE_RANK ( ) OVER ( [ <partition_by_clause> ] < order_by_clause > )

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Ranking rows within a partition

USE AdventureWorks2012;
GO
SELECT i.ProductID, p.Name, i.LocationID, i.Quantity
    ,DENSE_RANK() OVER 
    (PARTITION BY i.LocationID ORDER BY i.Quantity DESC) AS Rank
FROM Production.ProductInventory AS i 
INNER JOIN Production.Product AS p 
    ON i.ProductID = p.ProductID
WHERE i.LocationID BETWEEN 3 AND 4
ORDER BY i.LocationID;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Ranking all rows in a result set

USE AdventureWorks2012;
GO
SELECT TOP(10) BusinessEntityID, Rate, 
       DENSE_RANK() OVER (ORDER BY Rate DESC) AS RankBySalary
FROM HumanResources.EmployeePayHistory;

-----------------------------------------------------------------------
-- NTILE https://msdn.microsoft.com/en-us/library/ms173825.aspx
-- NTILE (integer_expression) OVER ( [ <partition_by_clause> ] < order_by_clause > )

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Dividing rows into groups

USE AdventureWorks2012; 
GO
SELECT p.FirstName, p.LastName
    ,NTILE(4) OVER(ORDER BY SalesYTD DESC) AS Quartile
    ,CONVERT(nvarchar(20),s.SalesYTD,1) AS SalesYTD
    , a.PostalCode
FROM Sales.SalesPerson AS s 
INNER JOIN Person.Person AS p 
    ON s.BusinessEntityID = p.BusinessEntityID
INNER JOIN Person.Address AS a 
    ON a.AddressID = p.BusinessEntityID
WHERE TerritoryID IS NOT NULL 
    AND SalesYTD <> 0;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Dividing the result set by using PARTITION BY

USE AdventureWorks2012;
GO
DECLARE @NTILE_Var int = 4;

SELECT p.FirstName, p.LastName
    ,NTILE(@NTILE_Var) OVER(PARTITION BY PostalCode ORDER BY SalesYTD DESC) AS Quartile
    ,CONVERT(nvarchar(20),s.SalesYTD,1) AS SalesYTD
    ,a.PostalCode
FROM Sales.SalesPerson AS s 
INNER JOIN Person.Person AS p 
    ON s.BusinessEntityID = p.BusinessEntityID
INNER JOIN Person.Address AS a 
    ON a.AddressID = p.BusinessEntityID
WHERE TerritoryID IS NOT NULL 
    AND SalesYTD <> 0;
GO

-----------------------------------------------------------------------
-- ROW_NUMBER https://msdn.microsoft.com/en-us/library/ms186734.aspx
-- ROW_NUMBER ( ) OVER ( [ PARTITION BY value_expression , ... [ n ] ] order_by_clause )

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Returning the row number for salespeople

USE AdventureWorks2012; 
GO
SELECT ROW_NUMBER() OVER(ORDER BY SalesYTD DESC) AS Row, 
    FirstName, LastName, ROUND(SalesYTD,2,1) AS "Sales YTD" 
FROM Sales.vSalesPerson
WHERE TerritoryName IS NOT NULL AND SalesYTD <> 0;

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Returning a subset of rows

USE AdventureWorks2012;
GO
WITH OrderedOrders AS
(
    SELECT SalesOrderID, OrderDate,
    ROW_NUMBER() OVER (ORDER BY OrderDate) AS RowNumber
    FROM Sales.SalesOrderHeader 
) 
SELECT SalesOrderID, OrderDate, RowNumber  
FROM OrderedOrders 
WHERE RowNumber BETWEEN 50 AND 60;

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using ROW_NUMBER() with PARTITION

USE AdventureWorks2012;
GO
SELECT FirstName, LastName, TerritoryName, ROUND(SalesYTD,2,1),
ROW_NUMBER() OVER(PARTITION BY TerritoryName ORDER BY SalesYTD DESC) AS Row
FROM Sales.vSalesPerson
WHERE TerritoryName IS NOT NULL AND SalesYTD <> 0
ORDER BY TerritoryName;

-----------------------------------------------------------------------
-- OVER Clause https://msdn.microsoft.com/en-us/library/ms189461.aspx
-- OVER ( 
       -- [ <PARTITION BY clause> ]
       -- [ <ORDER BY clause> ] 
       -- [ <ROW or RANGE clause> ]
      -- )<PARTITION BY clause> ::=
-- PARTITION BY value_expression , ... [ n ]

-- <ORDER BY clause> ::=
-- ORDER BY order_by_expression
    -- [ COLLATE collation_name ] 
    -- [ ASC | DESC ] 
    -- [ ,...n ]

-- <ROW or RANGE clause> ::=
-- { ROWS | RANGE } <window frame extent>

-- <window frame extent> ::= 
-- {   <window frame preceding>
  -- | <window frame between>
-- }
-- <window frame between> ::= 
  -- BETWEEN <window frame bound> AND <window frame bound>

-- <window frame bound> ::= 
-- {   <window frame preceding>
  -- | <window frame following>
-- }

-- <window frame preceding> ::= 
-- {
    -- UNBOUNDED PRECEDING
  -- | <unsigned_value_specification> PRECEDING
  -- | CURRENT ROW
-- }

-- <window frame following> ::= 
-- {
    -- UNBOUNDED FOLLOWING
  -- | <unsigned_value_specification> FOLLOWING
  -- | CURRENT ROW
-- }

-- <unsigned value specification> ::= 
-- {  <unsigned integer literal> }

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using the OVER clause with the ROW_NUMBER function

USE AdventureWorks2012;
GO
SELECT ROW_NUMBER() OVER(PARTITION BY PostalCode ORDER BY SalesYTD DESC) AS "Row Number", 
    p.LastName, s.SalesYTD, a.PostalCode
FROM Sales.SalesPerson AS s 
    INNER JOIN Person.Person AS p 
        ON s.BusinessEntityID = p.BusinessEntityID
    INNER JOIN Person.Address AS a 
        ON a.AddressID = p.BusinessEntityID
WHERE TerritoryID IS NOT NULL 
    AND SalesYTD <> 0
ORDER BY PostalCode;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using the OVER clause with aggregate functions

USE AdventureWorks2012;
GO
SELECT SalesOrderID, ProductID, OrderQty
    ,SUM(OrderQty) OVER(PARTITION BY SalesOrderID) AS Total
    ,AVG(OrderQty) OVER(PARTITION BY SalesOrderID) AS "Avg"
    ,COUNT(OrderQty) OVER(PARTITION BY SalesOrderID) AS "Count"
    ,MIN(OrderQty) OVER(PARTITION BY SalesOrderID) AS "Min"
    ,MAX(OrderQty) OVER(PARTITION BY SalesOrderID) AS "Max"
FROM Sales.SalesOrderDetail 
WHERE SalesOrderID IN(43659,43664);
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Using the OVER clause with aggregate functions

USE AdventureWorks2012;
GO
SELECT SalesOrderID, ProductID, OrderQty
    ,SUM(OrderQty) OVER(PARTITION BY SalesOrderID) AS Total
    ,CAST(1. * OrderQty / SUM(OrderQty) OVER(PARTITION BY SalesOrderID) 
        *100 AS DECIMAL(5,2))AS "Percent by ProductID"
FROM Sales.SalesOrderDetail 
WHERE SalesOrderID IN(43659,43664);
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Producing a moving average and cumulative total

USE AdventureWorks2012;
GO
SELECT BusinessEntityID, TerritoryID 
   ,DATEPART(yy,ModifiedDate) AS SalesYear
   ,CONVERT(varchar(20),SalesYTD,1) AS  SalesYTD
   ,CONVERT(varchar(20),AVG(SalesYTD) OVER (PARTITION BY TerritoryID 
                                            ORDER BY DATEPART(yy,ModifiedDate) 
                                           ),1) AS MovingAvg
   ,CONVERT(varchar(20),SUM(SalesYTD) OVER (PARTITION BY TerritoryID 
                                            ORDER BY DATEPART(yy,ModifiedDate) 
                                            ),1) AS CumulativeTotal
FROM Sales.SalesPerson
WHERE TerritoryID IS NULL OR TerritoryID < 5
ORDER BY TerritoryID,SalesYear;

SELECT BusinessEntityID, TerritoryID 
   ,DATEPART(yy,ModifiedDate) AS SalesYear
   ,CONVERT(varchar(20),SalesYTD,1) AS  SalesYTD
   ,CONVERT(varchar(20),AVG(SalesYTD) OVER (ORDER BY DATEPART(yy,ModifiedDate) 
                                            ),1) AS MovingAvg
   ,CONVERT(varchar(20),SUM(SalesYTD) OVER (ORDER BY DATEPART(yy,ModifiedDate) 
                                            ),1) AS CumulativeTotal
FROM Sales.SalesPerson
WHERE TerritoryID IS NULL OR TerritoryID < 5
ORDER BY SalesYear;

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Specifying the ROWS clause

SELECT BusinessEntityID, TerritoryID 
    ,CONVERT(varchar(20),SalesYTD,1) AS  SalesYTD
    ,DATEPART(yy,ModifiedDate) AS SalesYear
    ,CONVERT(varchar(20),SUM(SalesYTD) OVER (PARTITION BY TerritoryID 
                                             ORDER BY DATEPART(yy,ModifiedDate) 
                                             ROWS BETWEEN CURRENT ROW AND 1 FOLLOWING ),1) AS CumulativeTotal
FROM Sales.SalesPerson
WHERE TerritoryID IS NULL OR TerritoryID < 5;

SELECT BusinessEntityID, TerritoryID 
    ,CONVERT(varchar(20),SalesYTD,1) AS  SalesYTD
    ,DATEPART(yy,ModifiedDate) AS SalesYear
    ,CONVERT(varchar(20),SUM(SalesYTD) OVER (PARTITION BY TerritoryID 
                                             ORDER BY DATEPART(yy,ModifiedDate) 
                                             ROWS UNBOUNDED PRECEDING),1) AS CumulativeTotal
FROM Sales.SalesPerson
WHERE TerritoryID IS NULL OR TerritoryID < 5;

-- addition assignment operator
DECLARE @count int = 0;
SELECT @count += 1;
SELECT @count;
GO;

-- subtraction assignment operator
DECLARE @count int = 0;
SELECT @count -= 1;
SELECT @count;
GO;

-- division assignment operator
DECLARE @count int = 1;
SELECT @count /= 1;
SELECT @count;
GO;

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Specifying the ISNULL function

USE AdventureWorks2012;
GO
SELECT AVG(ISNULL(Weight, 50))
FROM Production.Product;
GO

--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Specifying the STUFF function
SELECT STUFF('abcdef', 2, 3, 'ijklmn');
GO