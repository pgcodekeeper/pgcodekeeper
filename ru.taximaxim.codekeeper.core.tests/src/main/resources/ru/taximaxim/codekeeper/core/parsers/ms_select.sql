SELECT * FROM dbo.t1 ORDER BY Name ASC;
SELECT p.* FROM dbo.t1 AS p ORDER BY Name ASC;
SELECT Name, ProductNumber, ListPrice AS Price FROM dbo.t1 ORDER BY Name ASC;
SELECT Name, ProductNumber, ListPrice AS Price FROM dbo.t1 WHERE P = 'R' AND D < 4 ORDER BY Name ASC;
SELECT * FROM dbo.t1 ORDER BY Name ASC;
SELECT [Production].[Product].[ProductID], [Production].[Product].[Name] FROM [dbo].[t1];
SELECT *, *, * FROM t1; -- yes, syntax is valid
SELECT
    some_type::static_method (@arg1, @arg2, @arg3),
    another_type::method ('some value'),
    still_one_type.non_static_method (@but, @with, @params)
FROM dbo.t1;
SELECT p.Name AS ProductName, 
NonDiscountSales = (OrderQty * UnitPrice),
Discounts = ((OrderQty * UnitPrice) * UnitPriceDiscount)
FROM Production.Product AS p 
INNER JOIN Sales.SalesOrderDetail AS sod
ON p.ProductID = sod.ProductID 
ORDER BY ProductName DESC;
GO

SELECT 'Total income is', ((OrderQty * UnitPrice) * (1.0 - UnitPriceDiscount)), ' for ',
p.Name AS ProductName 
FROM Production.Product AS p 
INNER JOIN Sales.SalesOrderDetail AS sod
ON p.ProductID = sod.ProductID 
ORDER BY ProductName ASC;
GO

SELECT DISTINCT title FROM workers ORDER BY title;
SELECT * INTO #T FROM D.S.T WHERE ProductNumber LIKE 'BK%';
SELECT * INTO dbo.NewProducts FROM Production.Product WHERE ListPrice > $25  AND ListPrice < $100;

SELECT DISTINCT Name
FROM Production.Product AS p 
WHERE EXISTS
    (SELECT *
     FROM Production.ProductModel AS pm 
     WHERE p.ProductModelID = pm.ProductModelID
           AND pm.Name LIKE 'Long-Sleeve Logo Jersey%');
GO

SELECT DISTINCT Name
FROM Production.Product
WHERE ProductModelID IN
    (SELECT ProductModelID 
     FROM Production.ProductModel
     WHERE Name LIKE 'Long-Sleeve Logo Jersey%');
GO

SELECT DISTINCT p.LastName, p.FirstName 
FROM Person.Person AS p 
JOIN HumanResources.Employee AS e
    ON e.BusinessEntityID = p.BusinessEntityID WHERE 5000.00 IN
    (SELECT Bonus
     FROM Sales.SalesPerson AS sp
     WHERE e.BusinessEntityID = sp.BusinessEntityID);
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

USE AdventureWorks2012;
GO
CREATE FUNCTION dbo.GetContactInformation(@BusinessEntityID int)
    RETURNS @retContactInformation TABLE 
(
BusinessEntityID int NOT NULL,
FirstName nvarchar(50) NULL,
LastName nvarchar(50) NULL,
ContactType nvarchar(50) NULL,
    PRIMARY KEY CLUSTERED (BusinessEntityID ASC)
) 
AS 
-- Returns the first name, last name and contact type for the specified contact.
BEGIN
    DECLARE 
        @FirstName nvarchar(50), 
        @LastName nvarchar(50), 
        @ContactType nvarchar(50);

    -- Get common contact information
    SELECT 
        @BusinessEntityID = BusinessEntityID, 
        @FirstName = FirstName, 
        @LastName = LastName
    FROM Person.Person 
    WHERE BusinessEntityID = @BusinessEntityID;

    SET @ContactType = 
        CASE 
            -- Check for employee
            WHEN EXISTS(SELECT * FROM HumanResources.Employee AS e 
                WHERE e.BusinessEntityID = @BusinessEntityID) 
                THEN 'Employee'

            -- Check for vendor
            WHEN EXISTS(SELECT * FROM Person.BusinessEntityContact AS bec
                WHERE bec.BusinessEntityID = @BusinessEntityID) 
                THEN 'Vendor'

            -- Check for store
            WHEN EXISTS(SELECT * FROM Purchasing.Vendor AS v          
                WHERE v.BusinessEntityID = @BusinessEntityID) 
                THEN 'Store Contact'

            -- Check for individual consumer
            WHEN EXISTS(SELECT * FROM Sales.Customer AS c 
                WHERE c.PersonID = @BusinessEntityID) 
                THEN 'Consumer'
        END;

    -- Return the information to the caller
    IF @BusinessEntityID IS NOT NULL 
    BEGIN
        INSERT @retContactInformation
        SELECT @BusinessEntityID, @FirstName, @LastName, @ContactType;
    END;

    RETURN;
END;
GO

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

SELECT TRIM (exp)
GO
SELECT IIF (exp, exp, exp)
GO
SELECT IIF (exp = 1 or exp = 2, exp, exp)
GO

-- predicate
SELECT * FROM testtable WHERE id IS NOT DISTINCT FROM NULL
GO
SELECT * FROM testtable WHERE id IS NOT DISTINCT FROM 42
GO
SELECT * FROM testtable WHERE FREETEXT(D, @S)
GO
SELECT * FROM testtable WHERE FREETEXT(D, 'search', language 1053)
GO
SELECT * FROM testtable WHERE CONTAINS(D, N'search')
GO
SELECT * FROM testtable WHERE CONTAINS((N, C), 'R');
GO
SELECT * FROM testtable WHERE CONTAINS(PROPERTY(D,'T'), 'M OR R');
GO
SELECT id FROM dbo.t1 WITH (NOLOCK, INDEX (i1, i2));
GO
SELECT id FROM dbo.t1 WITH (NOLOCK, INDEX = i1, INDEX = i2);
GO
SELECT id FROM dbo.t1 WITH (NOLOCK, NOEXPAND, SERIALIZABLE);
GO

-- GROUP BY options
SELECT col1 FROM testTable GROUP BY GROUPING SETS (col1, ());
GO
SELECT col1 FROM testTable GROUP BY ROLLUP (col1, col2);
GO
SELECT col1 FROM testTable GROUP BY ALL col1, col2;
GO
SELECT col1 FROM testTable GROUP BY col1, col2 WITH ROLLUP;
GO
SELECT col1 FROM testTable GROUP BY col1, col2 WITH CUBE;
GO
SELECT col1 FROM testTable GROUP BY col1, col2 WITH (DISTRIBUTED_AGG);
GO
SELECT col1 FROM testTable GROUP BY CUBE (col1, col2);
GO
SELECT col1 FROM testTable GROUP BY GROUPING SETS ( ROLLUP (col1, col2), CUBE (col1, col2) );
GO
SELECT col1 FROM testTable GROUP BY ROLLUP (col1, col2);
GO
SELECT col1 FROM testTable GROUP BY CUBE (col1, col2);
GO
SELECT col1 FROM testTable GROUP BY (), CUBE (col1, col2);
GO
SELECT col1 FROM testTable GROUP BY GROUPING SETS ((), CUBE (col1, col2));
GO
SELECT col1 FROM testTable GROUP BY (), CUBE (col1, col2), (), col1;
GO
SELECT col1 FROM testTable GROUP BY (), CUBE (col1, col2), (), col1;
GO
SELECT col1 FROM testTable GROUP BY (), CUBE (col1, col2), (), col1;
GO

SELECT {fn BIT_LENGTH( 'test' )};
SELECT {fn CONCAT( 'test', 'test2' )};
SELECT {fn OCTET_LENGTH( 'test' )};
SELECT {fn TRUNCATE( 100.123456, 4)};
SELECT {fn CURRENT_DATE( )};
SELECT {fn CURDATE( )};
SELECT {fn CURRENT_TIME( 6 )};
SELECT {fn CURRENT_TIME};
SELECT {fn CURTIME( )};
SELECT {fn DAYNAME( 0 )};
SELECT {fn DAYOFMONTH( 0 )};
SELECT {fn DAYOFWEEK( 0 )};
SELECT {fn HOUR( 0 )};
SELECT {fn MINUTE( 0 )};
SELECT {fn SECOND( 0 )};
SELECT {fn MONTHNAME( 0 )};
SELECT {fn QUARTER( 0 )};
SELECT {fn WEEK( 0 )};
SELECT APPROX_COUNT_DISTINCT(O_OrderKey);
SELECT DISTINCT DeptId,
  APPROX_PERCENTILE_CONT(0.10) WITHIN GROUP(ORDER BY Salary) AS 'P10',
  APPROX_PERCENTILE_CONT(0.90) WITHIN GROUP(ORDER BY Salary) AS 'P90',
  APPROX_PERCENTILE_DISC(0.10) WITHIN GROUP(ORDER BY Salary) AS 'PD10',
  APPROX_PERCENTILE_DISC(0.90) WITHIN GROUP(ORDER BY Salary) AS 'PD90',
  PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY B) OVER (PARTITION BY D),
  PERCENTILE_DISC(0.5) WITHIN GROUP (ORDER BY B) OVER (PARTITION BY D),
  CUME_DIST() OVER (PARTITION BY D ORDER BY R) AS C,
  PERCENT_RANK() OVER (PARTITION BY D ORDER BY R) AS P
FROM t1;

SELECT AVG(h) AS 'av' FROM t1;
SELECT SUM(h) AS 'sum' FROM t1;
SELECT CHECKSUM_AGG(CAST(Q AS INT)) FROM P.P;
SELECT COUNT(DISTINCT T) FROM H.E;
SELECT GROUPING_ID(c1, c2) FROM t GROUP BY ROLLUP(c1);
SELECT MAX(c1) FROM t1;
SELECT STDEV(c1) FROM t1;
SELECT STDEVP(c1) FROM t1;
SELECT VAR(c1) FROM Sales.SalesPerson;
SELECT VARP(Bonus) FROM Sales.SalesPerson;  
SELECT CUME_DIST () OVER (PARTITION BY D ORDER BY R) AS CD, PERCENT_RANK() OVER (PARTITION BY D ORDER BY R) AS PR FROM t1;
SELECT FIRST_VALUE(Name) OVER (ORDER BY LP ASC) AS LE FROM t1;
SELECT YEAR(Q), LAG(S, 1,0) OVER (ORDER BY YEAR(Q)) AS Q FROM t1;
SELECT LAST_VALUE(H) OVER (PARTITION BY D ORDER BY R) AS L FROM t1;
SELECT LEAD(S, 1,0) FROM t1;
SELECT LEFT_SHIFT(12345, 5);
SELECT RIGHT_SHIFT(12345, 5);
SELECT BIT_COUNT (0xabcdef) as Count;
SELECT GET_BIT (0xabcdef, 2) as B2, GET_BIT (0xabcdef, 4) as B4;
SELECT SET_BIT (0x00, 2) as VB;
SELECT COLLATIONPROPERTY('WS', 'Page');
SELECT TERTIARY_WEIGHTS(Col1) FROM t1;
SELECT @@DBTS; 
SELECT @@LANGID;
SELECT @@LANGUAGE;
SELECT @@LOCK_TIMEOUT;
SELECT @@MAX_CONNECTIONS;
SELECT @@MAX_PRECISION;
SELECT @@NESTLEVEL;
SELECT @@OPTIONS;
SELECT @@REMSERVER;
SELECT @@SERVERNAME;
SELECT @@SERVICENAME;
SELECT @@SPID;
SELECT @@TEXTSIZE ;
SELECT @@VERSION;
SELECT CAST(CAST(0x41 AS nvarchar) AS varbinary);
SELECT PARSE('Monday, 13 December 2010' AS datetime2 USING 'en-US') AS R;
SELECT TRY_CAST('12/31/2022' AS DATETIME2) AS R;
SELECT TRY_CONVERT(datetime2, '12/31/2010') AS R;
SELECT TRY_PARSE('Jabberwokkie' AS datetime2 USING 'en-US') AS R;
SELECT ASYMKEY_ID('ABerglundKey11');
SELECT ASYMKEYPROPERTY(256, 'algorithm_desc') AS A;
DECLARE @CertSubject sql_variant;  
SELECT CONVERT(nvarchar, CertProperty( Cert_ID('Marketing19'), 'Subject'));
SELECT CRYPT_GEN_RANDOM(50);
SELECT CONVERT(NVARCHAR(max), DecryptByAsymKey(AsymKey_Id('K'), ProtectedData, N'p')) FROM t1;
SELECT CONVERT(nvarchar, DecryptByKey(enc, 1, HashBytes('SHA1', CONVERT(varbinary, id)))) from t1;
SELECT CONVERT(nvarchar, DecryptByKeyAutoAsymKey(AsymKey_ID('SSN_AKey') , NULL , n)) from t1; 
SELECT CONVERT(nvarchar, DecryptByKeyAutoCert ( cert_ID('H') , NULL, n)) FROM t1; 
SELECT CONVERT(varchar, DecryptByPassphrase(@Pa, C, 1, CONVERT(varbinary, Credit))) AS 'D' FROM Credit;
SELECT EncryptByAsymKey(AsymKey_ID('Janaina'), @cl);
SELECT EncryptByCert(Cert_ID('Janaina'), @cl);
SELECT EncryptByKey(Key_GUID('Key'));
SELECT EncryptByPassPhrase(@Pass, CardNumber, 1, CONVERT(varbinary, CreditCardID));
SELECT HASHBYTES('SHA2_256', c1);
SELECT IS_OBJECTSIGNED('OBJECT', OBJECT_ID(@n), 'c', @t);
SELECT Key_GUID('ABerglundKey1');
SELECT KEY_ID('ABerglundKey1');
SELECT KEY_NAME(@guid) AS [Name of Key];
SELECT SignByAsymKey( AsymKey_Id('PrimeKey' ), @clear_text_data, N'pGFD4bb925DGvbd2439587y' );
SELECT SignByCert( Cert_Id( 'ABerglundCert07' ), @SensitiveData, N'pGFD4bb925DGvbd2439587y' );
SELECT SYMKEYPROPERTY(256, 'algorithm_desc') AS Algorithm;
SELECT VerifySignedByCert( Cert_Id( 'Shipping04' ), Signed_Data, DataSignature );
SELECT VerifySignedByAsymKey( AsymKey_Id( 'WillisKey74' ), SignedData, DataSignature )
SELECT @@CURSOR_ROWS;
SELECT @@FETCH_STATUS;
SELECT @@DATEFIRST;
SELECT CURSOR_STATUS('global','cur');
SELECT DATALENGTH(col1) from dbo.t;
SELECT IDENT_CURRENT('t');
SELECT IDENT_INCR('dbo.t') AS Identity_Increment; 
SELECT IDENT_SEED('dbo.t') AS Identity_Seed;
SELECT IDENTITY(int, 1,1);
SELECT SQL_VARIANT_PROPERTY(@v1, 'BaseType');
SELECT CURRENT_TIMESTAMP;
SELECT CURRENT_TIMEZONE();
SELECT CURRENT_TIMEZONE_ID();
SELECT DATE_BUCKET(WEEK, 2, @date);
SELECT DATEADD(month, 1, '20060830');
SELECT DATEDIFF(day, @startdate, @enddate);
SELECT DATEDIFF_BIG(year, '2005-12-31 23:59:59.9999999', '2006-01-01 00:00:00.0000000');
SELECT DATEFROMPARTS ( 2010, 12, 31 ) AS Result;
SELECT DATENAME(year, '12:10:30.123');
SELECT DATEPART(year, '12:10:30.123');
SELECT DATETIME2FROMPARTS ( 2010, 12, 31, 23, 59, 59, 0, 0 );
SELECT DATETIMEFROMPARTS ( 2010, 12, 31, 23, 59, 59, 0 );
SELECT DATETIMEOFFSETFROMPARTS ( 2010, 12, 31, 14, 23, 23, 0, 12, 0, 7 );
SELECT 'Year', DATETRUNC(year, @d);
SELECT YEAR(0), MONTH(0), DAY(0);
SELECT EOMONTH ( @date ) AS Result;
SELECT GETDATE();
SELECT GETUTCDATE();
SELECT ISDATE('04/15/2008');
SELECT SMALLDATETIMEFROMPARTS ( 2010, 12, 31, 23, 59 );
SELECT SWITCHOFFSET (o, '-08:00');
SELECT SYSDATETIME();
SELECT SYSDATETIMEOFFSET();
SELECT SYSUTCDATETIME();
SELECT TIMEFROMPARTS ( 23, 59, 59, 0, 0 );
SELECT TODATETIMEOFFSET (@todaysDateTime, '-07:00'); 
SELECT ISJSON('true', VALUE);
SELECT JSON_OBJECT();
SELECT JSON_OBJECT('name':'value', 'type':1);
SELECT JSON_OBJECT('name':'value', 'type':NULL ABSENT ON NULL);
SELECT JSON_OBJECT('name':'value', 'type':JSON_ARRAY(1, 2));
SELECT JSON_OBJECT('name':'value', 'type':JSON_OBJECT('type_id':1, 'name':'a'));
SELECT JSON_OBJECT('user_name':USER_NAME(), @id_key:@id_value, 'sid':(SELECT @@SPID));
SELECT JSON_OBJECT('security_id':s.security_id, 'login':s.login_name, 'status':s.status);
SELECT JSON_ARRAY();
SELECT JSON_ARRAY('a', 1, 'b', 2);
SELECT JSON_ARRAY('a', 1, 'b', NULL);
SELECT JSON_ARRAY('a', 1, NULL, 2 NULL ON NULL);
SELECT JSON_ARRAY('a', JSON_OBJECT('name':'value', 'type':1));
SELECT JSON_ARRAY('a', JSON_OBJECT('name':'value', 'type':1), JSON_ARRAY(1, null, 2 NULL ON NULL));
SELECT JSON_ARRAY(1, @id_value, (SELECT @@SPID));
SELECT JSON_ARRAY(host_name, program_name, client_interface_name) FROM sys.dm_exec_sessions;
SELECT JSON_VALUE(jsonInfo,'$.info.address.town');
SELECT JSON_QUERY(CustomFields,'$.OtherLanguages');
SELECT JSON_MODIFY(@jsonCol,'$.info.address.town','London');
SELECT JSON_PATH_EXISTS(@jsonInfo,'$.info.address');
SELECT ABS(-1.0);
SELECT ACOS(@cos);
SELECT ASIN(1.00);
SELECT ATAN(45.87);
SELECT ATAN(-181.01);
SELECT ATN2(@y, @x);
SELECT CEILING($123.45);
SELECT COS(14.76);
SELECT COT(@angle);
SELECT DEGREES((PI()/2));
SELECT EXP(@var);
SELECT FLOOR(123.45);
SELECT LOG(10);
SELECT LOG (EXP (10));
SELECT POWER (10, LOG10(5));
SELECT RADIANS(1e-307);
SELECT RAND(100), RAND();
SELECT ROUND(150.75, 0);  
SELECT ROUND(150.75, 0, 1);
SELECT SIGN(-125), SIGN(0), SIGN(564);
SELECT SIN(45.175643);
SELECT SQRT(@myvalue);
SELECT SQUARE(@r);
SELECT TAN(PI()/2);
SELECT TAN(.45);
SELECT CHOOSE ( 3, 'Manager', 'Director', 'Developer', 'Tester' ) AS Result;
SELECT [Result] = IIF( 45 > 30, NULL, NULL );
SELECT [Result] = IIF( @a > @b, 'TRUE', 'FALSE' );
SELECT [Result] = IIF( 45 > 30, @P, @S );
SELECT @@PROCID;
SELECT APP_NAME();
SELECT APPLOCK_MODE('public', 'Form1', 'Transaction');
SELECT APPLOCK_TEST('public', 'Form1', 'Shared', 'Transaction');
SELECT ASSEMBLYPROPERTY ('HelloWorld' , 'PublicKey');
SELECT COL_LENGTH('t1','c1');
SELECT COL_NAME(OBJECT_ID('dbo.FactResellerSales'), 1);
SELECT COLUMNPROPERTY( OBJECT_ID('Person.Person'),'LastName','PRECISION')AS 'Column Length';
SELECT DATABASEPROPERTYEX('AdventureWorks2022', 'IsAutoShrink');
SELECT DB_ID();
SELECT DB_ID('AdventureWorksPDW2012');
SELECT DB_NAME();
SELECT DB_NAME(3);
SELECT DB_NAME(database_id) AS [Database], database_id FROM sys.databases;
SELECT FILE_ID('AdventureWorks2022_Data');
SELECT FILE_IDEX('AdventureWorks2022_Data');
SELECT FILE_IDEX(SELECT TOP (1) name FROM sys.database_files WHERE type = 1);
SELECT FILE_NAME(1);
SELECT FILEGROUP_ID('PRIMARY');
SELECT FILEGROUP_NAME(1);
SELECT FILEGROUPPROPERTY('PRIMARY', 'IsDefault');
SELECT FILEPROPERTY('Data', 'IsPrimaryFile');
SELECT FILEPROPERTYEX(s.name, 'IsPageBlob') AS IsPageBlob;
SELECT fulltextcatalogproperty('Cat_Desc', 'ItemCount');
SELECT fulltextserviceproperty('VerifySignature');
SELECT INDEX_COL (N'AdventureWorks2022.Sales.SalesOrderDetail', 1,1);
SELECT INDEXKEY_PROPERTY(OBJECT_ID('Production.Location', 'U'), 1,1,'ColumnId');
SELECT INDEXPROPERTY(OBJECT_ID('HumanResources.Employee'), 'PK_Employee_BusinessEntityID','IsClustered');
SELECT NEXT VALUE FOR Test.CountBy1;
SELECT OBJECT_DEFINITION (OBJECT_ID(N'Person.uAddress'));
SELECT OBJECT_ID(N'AdventureWorks2022.Production.WorkOrder');
SELECT DISTINCT OBJECT_NAME(object_id) FROM master.sys.objects;
SELECT DISTINCT OBJECT_SCHEMA_NAME(object_id, 1) AS schema_name FROM master.sys.objects; 
SELECT OBJECTPROPERTY(OBJECT_ID('dbo.v'), 'IsDeterministic');
SELECT OBJECTPROPERTYEX(OBJECT_ID(N'dbo.v'), 'IsView');
SELECT ORIGINAL_DB_NAME();
SELECT PARSENAME('dbo.d', 1);
SELECT SCHEMA_ID();
SELECT SCHEMA_ID('dbo');
SELECT SCHEMA_NAME();
SELECT SCHEMA_NAME(1);
SELECT SCOPE_IDENTITY();
SELECT SERVERPROPERTY('MachineName');
SELECT STATS_DATE(object_id, index_id);
SELECT TYPE_NAME(TYPE_ID('datetime'));
SELECT TYPE_NAME(36);
SELECT TYPEPROPERTY( 'tinyint', 'PRECISION');
SELECT DENSE_RANK() OVER (ORDER BY Rate DESC) FROM HumanResources.EmployeePayHistory;
SELECT DENSE_RANK() OVER (PARTITION BY SalesTerritoryGroup ORDER BY SUM(SalesAmountQuota) DESC ) FROM dbo.DimEmployee;
SELECT NTILE(4) OVER(ORDER BY SalesYTD DESC) FROM Sales.SalesPerson;
SELECT NTILE(@NTILE_Var) OVER(PARTITION BY PostalCode ORDER BY SalesYTD DESC) FROM Sales.SalesPerson;
SELECT RANK() OVER (PARTITION BY i.LocationID ORDER BY i.Quantity DESC) FROM Production.ProductInventory;
SELECT ROW_NUMBER() OVER(ORDER BY name ASC) FROM sys.databases;
SELECT PUBLISHINGSERVERNAME();
SELECT CERTENCODED(CERT_ID('Shipping04'));
SELECT CERTPRIVATEKEY(CERT_ID('Shipping04'), 'jklalkaa/; uia3dd');
SELECT CURRENT_USER;
SELECT DATABASE_PRINCIPAL_ID();
SELECT DATABASE_PRINCIPAL_ID('db_owner');
SELECT HAS_DBACCESS('AdventureWorks2022'); 
SELECT HAS_PERMS_BY_NAME(null, null, 'VIEW SERVER STATE');
SELECT HAS_PERMS_BY_NAME('Ps', 'LOGIN', 'IMPERSONATE');
SELECT HAS_PERMS_BY_NAME(db_name(), 'DATABASE', 'ANY');
SELECT IS_MEMBER ('db_owner');
SELECT IS_ROLEMEMBER ('db_datareader');
SELECT IS_SRVROLEMEMBER('diskadmin', 'Contoso\Pat');
SELECT LOGINPROPERTY('John3', 'IsMustChange');
SELECT ORIGINAL_LOGIN();
SELECT PERMISSIONS(OBJECT_ID('AdventureWorks2022.Person.Address','U'));
SELECT PWDENCRYPT ( 'password' );
SELECT PWDCOMPARE('password', password_hash);
SELECT SESSION_USER;
SELECT SESSIONPROPERTY ('CONCAT_NULL_YIELDS_NULL');
SELECT SUSER_ID('sa');
SELECT SUSER_NAME(1);
SELECT SUSER_NAME();
SELECT SUSER_SID();
SELECT SUSER_SID('sa');
SELECT SUSER_SNAME();
SELECT SUSER_SNAME(0x010500000000000515000000a065cf7e784b9b5fe77c87705a2e0000);
SELECT SYSTEM_USER;
SELECT USER;
SELECT USER_ID(); 
SELECT USER_ID('Harold');
SELECT USER_NAME(1);  
SELECT USER_NAME(); 
SELECT ASCII('A');
SELECT CHAR(ASCII(SUBSTRING(@string, @position, 1)));
SELECT CHARINDEX('bicycle', @document);
SELECT CHARINDEX('vital', @document, 5); 
SELECT CONCAT ('Happy ', 'Birthday ', 11, '/', '25');
SELECT CONCAT_WS(' - ', database_id, recovery_model_desc, containment_desc) FROM sys.databases;
SELECT SOUNDEX('Green'), SOUNDEX('Greene'), DIFFERENCE('Green','Greene');
SELECT FORMAT( @d, 'd', 'en-US' ) 'US English';
SELECT LEFT('abcdefg',2);
SELECT LEN('asdw');
SELECT LOWER('SADWasdw');
SELECT LTRIM(@string_to_trim);
SELECT LTRIM('123abc.' , '123.');
SELECT NCHAR(143743);
SELECT PATINDEX('%ter%', 'interesting data');
SELECT QUOTENAME('abc[]def');
SELECT REPLACE('abcdefghicde','cde','xxx');  
SELECT REPLICATE('0', 4) + [ProductLine] FROM [Production].[Product];
SELECT REVERSE(1234);
SELECT RIGHT('abcdefg', 2);
SELECT RTRIM('Removes trailing spaces.   ');
SELECT RTRIM('.123abc.' , 'abc.');
SELECT SOUNDEX ('Smith'), SOUNDEX ('Smythe'); 
SELECT RTRIM(LastName) + ',' + SPACE(2) +  LTRIM(FirstName) FROM dbo.DimCustomer ORDER BY LastName, FirstName;  
SELECT STR(123.45, 6, 1);  
SELECT STRING_AGG (CONVERT(NVARCHAR(max),FirstName), CHAR(13)) FROM Person.Person;
SELECT STRING_ESCAPE('\   /  \\    "     ', 'json');
SELECT STUFF('abcdef', 2, 3, 'ijklmn');
SELECT SUBSTRING(name, 1, 1) FROM sys.databases;
SELECT TRANSLATE('2*[3+4]/{7-2}', '[]{}', '()()');
SELECT TRIM( '     test    ');
SELECT TRIM( '.,! ' FROM '     #     test    .');
SELECT UNICODE(@nstring), NCHAR(UNICODE(@nstring));  
SELECT UPPER('adfjkh');
SELECT $PARTITION.P (10);
SELECT @@ERROR;
SELECT @@IDENTITY;
SELECT @@PACK_RECEIVED;
SELECT @@ROWCOUNT;
SELECT @@TRANCOUNT;
SELECT BINARY_CHECKSUM(*) from myTable;
SELECT CHECKSUM(N'1');
SELECT COMPRESS(N'sdfseassg');
SELECT ConnectionProperty('net_transport');
SELECT CONTEXT_INFO();
SELECT CURRENT_REQUEST_ID();
SELECT CURRENT_TRANSACTION_ID();
SELECT DECOMPRESS(COMPRESS(N'sdfseassg'));
SELECT ERROR_LINE();
SELECT ERROR_MESSAGE();
SELECT ERROR_NUMBER();
SELECT ERROR_PROCEDURE();
SELECT ERROR_SEVERITY();
SELECT ERROR_STATE();
SELECT FORMATMESSAGE(20009, 'First Variable', 'Second Variable');
SELECT FORMATMESSAGE('This is the %s and this is the %s.', 'first variable', 'second variable');
SELECT GET_FILESTREAM_TRANSACTION_CONTEXT();
SELECT GETANSINULL('AdventureWorks2022');
SELECT HOST_ID();
SELECT HOST_NAME();
SELECT AVG(ISNULL(48, 50));
SELECT ISNUMERICK(@var1);
SELECT MIN_ACTIVE_ROWVERSION();
SELECT NEWID();
SELECT NEWSEQUENTIALID();
SELECT ROWCOUNT_BIG();
SELECT SESSION_CONTEXT(N'user_id');
SELECT XACT_STATE();
SELECT @@CONNECTIONS;
SELECT @@CPU_BUSY;
SELECT @@IDLE;
SELECT @@IO_BUSY;
SELECT @@PACK_SENT;
SELECT @@PACKET_ERRORS;
SELECT @@TIMETICKS;
SELECT @@TOTAL_ERRORS;
SELECT @@TOTAL_READ;
SELECT @@TOTAL_WRITE;
SELECT TEXTPTR(pr_info) FROM pub_info;
SELECT TEXTVALID('pub_info.logo', TEXTPTR(logo)) FROM pub_info;
SELECT COLUMNS_UPDATED();
SELECT EVENTDATA();
SELECT TRIGGER_NESTLEVEL( OBJECT_ID('xyz') , 'AFTER' , 'DML' );
SELECT * FROM dbo.t1 WITH (UPDLOCK) p;
SELECT * FROM dbo.t1 WITH (UPDLOCK) as p;
SELECT * FROM dbo.t1 p WITH (UPDLOCK);
SELECT * FROM dbo.t1 as p WITH (UPDLOCK);
SELECT * FROM dbo.t1 p WITH (UPDLOCK);
SELECT * FROM dbo.t1 as p WITH (UPDLOCK);

SELECT ord.Lo AS ID, ord.FId, ISNULL (ord.TrueId, 0) AS TrueID, ord.SizeD
FROM dbo.LAll AS ord (HOLDLOCK)
    LEFT JOIN Rinfo.dbo.fms AS f (NOLOCK) ON f.FID = ord.FId
    LEFT JOIN Rinfo.dbo.lo AS cser (NOLOCK) ON f.FID = cser.FID AND ord.LocalUserId = curuser.UserID
    LEFT JOIN Rinfo.dbo.lo AS basicuser (NOLOCK) ON f.FID = basicuser.FID AND basicuser.UserID = 0
    LEFT JOIN Rinfo.dbo.Pay AS pa (NOLOCK) ON f.FID = pa.FID
    LEFT JOIN Rinfo.dbo.Pt AS ps (NOLOCK) ON ps.FID = f.FID AND ps.PID = 0
    LEFT JOIN dbo.v_LResponses_Count AS lc WITH (NOLOCK) ON lc.LID = ord.LId
    LEFT JOIN dbo.v_Loa_Ct AS bc WITH (NOLOCK) ON bc.LID = ord.LId
WHERE ord.LoadId = ISNULL (@LID, ord.LId)
  AND ord.FID = ISNULL (@FID, ord.FID)
  AND ord.IsPublished = 1
OPTION (RECOMPILE);
        
SELECT h.SalesOrderID, h.TotalDue, d.OrderQty
FROM Sales.SalesOrderHeader AS h
    INNER JOIN Sales.SalesOrderDetail t WITH (TABLOCK, INDEX(myindex)) ON h.SalesOrderID = d.SalesOrderID
WHERE h.TotalDue > 100 AND (d.OrderQty > 5 OR d.LineTotal < 1000.00);

SELECT * FROM Employees AS e CROSS APPLY CHANGETABLE (VERSION Employees, ([Emp ID], SSN), (e.[Emp ID], e.SSN)) AS c;
SELECT * FROM CHANGETABLE (CHANGES Employees, @last_sync_version) AS C;

-- ambiquities
SELECT f((SELECT 1));
SELECT * FROM dbo.t1 (UPDLOCK) p; -- function call
SELECT * FROM dbo.t1 (UPDLOCK) as p; -- function call

--WITH XMLNAMESPACES
WITH XMLNAMESPACES ('uri' as ns1)
SELECT ProductID as 'ns1:ProductID',
       Name      as 'ns1:Name',
       Color     as 'ns1:Color'
FROM  Production.Product
WHERE ProductID IN (316, 317)
FOR XML RAW ('ns1:Prod'), ELEMENTS;

WITH XMLNAMESPACES ('urn:schemas-microsoft-com:xml-sql' as sql)
SELECT 'SELECT * FROM Customers FOR XML AUTO, ROOT("a")' AS "sql:query"
FOR XML PATH('sql:root');

--WINDOW clause
SELECT win AS [Row Number],
    p.LastName,
    s.SalesYTD,
    a.PostalCode
FROM Sales.SalesPerson AS s
INNER JOIN Person.Person AS p  ON s.BusinessEntityID = p.BusinessEntityID
INNER JOIN Person.Address AS a ON a.AddressID = p.BusinessEntityID
WHERE TerritoryID IS NOT NULL AND SalesYTD <> 0
WINDOW win AS (PARTITION BY PostalCode ORDER BY SalesYTD DESC)
ORDER BY PostalCode;
GO

SELECT SalesOrderID AS OrderNumber,
    ProductID,
    OrderQty AS Qty,
    SUM(OrderQty) OVER win AS Total,
    AVG(OrderQty) OVER (win PARTITION BY SalesOrderID) AS Avg,
    COUNT(OrderQty) OVER (win ROWS BETWEEN UNBOUNDED PRECEDING AND 1 FOLLOWING) AS Count
FROM Sales.SalesOrderDetail
WHERE SalesOrderID IN (43659, 43664) AND ProductID LIKE '71%' 
WINDOW win AS (ORDER BY SalesOrderID, ProductID);
GO

SELECT * FROM (SELECT 1 A, 2 B) T GROUP BY GROUPING SETS ((A,B), (A), B)
GO

SELECT TOP 100 PERCENT 1
GO

SELECT '😎 🤙 😎 🤙!!', ((OrderQty * UnitPrice) * (1.0 - UnitPriceDiscount)), ' 🙈 🙉 🙊 ',
p.Name AS ProductName 
FROM Production.Product AS p 
INNER JOIN Sales.SalesOrderDetail AS sod
ON p.ProductID = sod.ProductID 
ORDER BY ProductName ASC;
GO

SELECT SERVERPROPERTY('😎 🤙 😎 🤙!! 🙈 🙉 🙊');