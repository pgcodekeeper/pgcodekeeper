-- create table with foreign key
CREATE TABLE dbo.Employee (
  EmployeeID int PRIMARY KEY CLUSTERED,
  SalesPersonID int NULL REFERENCES SalesPerson(SalesPersonID)
);
GO;

-- Create Table With primary key clustered
CREATE TABLE #calls (date DATETIME PRIMARY KEY CLUSTERED (date));
GO

-- create table and with table constraint
CREATE TABLE dbo.Employee (
  EmployeeID int PRIMARY KEY CLUSTERED,
  ProductID int,
  SpecialOfferID int,
  CONSTRAINT FK_SpecialOfferProduct_SalesOrderDetail FOREIGN KEY (
    ProductID, SpecialOfferID)
  REFERENCES SpecialOfferProduct (
    ProductID, SpecialOfferID)
);
GO;

-- create table with multiple column constratints
CREATE TABLE [#TestTable] (
  [ID] INT PRIMARY KEY NOT NULL
) WITH (DATA_COMPRESSION = PAGE);
GO;

-- create table with multiple columns and constraints
CREATE TABLE [#TestTable] (
  [ID] INT PRIMARY KEY NOT NULL,
  [Name] NVARCHAR(64) NOT NULL
) WITH (DATA_COMPRESSION = PAGE);
GO;

-- create table with materialized column
create table xyz  (
  ccc  char(1),
  xxx  numeric(18,0) NULL,
  yyy  numeric(10,2) NULL,
  zzz  as cast(round(xxx / yyy, 0) as numeric(18,0)) materialized, 
  constraint pk primary key clustered (ccc)
)
go

-- Create Table With Index Option
CREATE TABLE dbo.TestTable (
  TableID uniqueidentifier NOT NULL,
  Value nvarchar(64) NOT NULL,
  CONSTRAINT PK_TestTable_ID PRIMARY KEY (TableID) WITH (DATA_COMPRESSION = PAGE))
GO

-- Create Table With Index Option and Table Option
CREATE TABLE dbo.TestTable (
  TableID uniqueidentifier NOT NULL,
  Value nvarchar(64) NOT NULL,
  Name nvarchar(64) NOT NULL,
  ModifiedDateUTC SMALLDATETIME,
  CONSTRAINT UQ_TestTable_ID  UNIQUE (Value) WITH (DATA_COMPRESSION = PAGE),
  CONSTRAINT PK_TestTable_ID PRIMARY KEY (TableID, Name))
  WITH (DATA_COMPRESSION = PAGE)
GO

-- Create Table With Column Option
CREATE TABLE dbo.TestTable (
  col1 int IDENTITY(1,1) NOT FOR REPLICATION NOT NUll,
  col2 int IDENTITY(1,2) NOT NULL,
  GUID UNIQUEIDENTIFIER
        CONSTRAINT Guid_Default DEFAULT
        NEWSEQUENTIALID() ROWGUIDCOL,
  u UTF8STRING,
    ustr AS u.ToString() PERSISTED,
  col3 VARCHAR(50) SPARSE NULL,
  col4 int MASKED WITH ( FUNCTION = 'default()' ) NOT NULL)
GO

-- Alter table drop constraint in transaction
IF NOT EXISTS (SELECT * FROM sys.columns cols
  JOIN sys.types AS types ON cols.user_type_id = types.user_type_id
WHERE object_id = OBJECT_ID('dbo.TestTable')
  AND cols.name = 'ModifiedDateUTC'
  AND types.name = 'datetime')
BEGIN
  BEGIN TRAN
    ALTER TABLE dbo.TestTable DROP CONSTRAINT DF_ModifiedDate;
  COMMIT TRAN
END
GO

--create table with COLUMNSTORE
CREATE TABLE [dbo].[24_11_23_1](
	[col1] [int] NULL
) ON [test1fg]
WITH (DATA_COMPRESSION = COLUMNSTORE)
GO

-- Alter table drop multiple constraints in transaction
IF NOT EXISTS (SELECT * FROM sys.columns cols
  JOIN sys.types AS types ON cols.user_type_id = types.user_type_id
WHERE object_id = OBJECT_ID('dbo.TestTable')
  AND cols.name = 'ModifiedDateUTC'
  AND types.name = 'datetime')
BEGIN
  BEGIN TRAN
    ALTER TABLE dbo.TestTable DROP CONSTRAINT DF_ModifiedDate;
    ALTER TABLE dbo.TestTable DROP CONSTRAINT UQ_TestTable_ID;
  COMMIT TRAN
END
GO

-- Alter table Add Constraint with Default
ALTER TABLE dbo.TestTable ADD CONSTRAINT DF_ModifiedDateUTC DEFAULT(GETUTCDATE()) FOR ModifiedDateUTC;
GO

-- Alter table Alter Column
ALTER TABLE dbo.TestTable ALTER COLUMN ModifiedDateUTC DATETIME
GO
ALTER TABLE dbo.TestTable ALTER COLUMN t ADD ROWGUIDCOL
GO
ALTER TABLE dbo.TestTable ALTER COLUMN t ADD PERSISTED
GO
ALTER TABLE dbo.TestTable ALTER COLUMN t ADD SPARSE
GO
ALTER TABLE dbo.TestTable ALTER COLUMN t ADD NOT FOR REPLICATION
GO
ALTER TABLE dbo.TestTable ALTER COLUMN t ADD MASKED WITH (FUNCTION = 'default()')
GO
ALTER TABLE dbo.TestTable ALTER COLUMN t DROP ROWGUIDCOL
GO
ALTER TABLE dbo.TestTable ALTER COLUMN t DROP PERSISTED
GO
ALTER TABLE dbo.TestTable ALTER COLUMN t DROP SPARSE
GO
ALTER TABLE dbo.TestTable ALTER COLUMN t DROP NOT FOR REPLICATION
GO
ALTER TABLE dbo.TestTable ALTER COLUMN t DROP MASKED
GO

-- Alter table Rebuild with Table Options
ALTER TABLE TestTable REBUILD WITH (DATA_COMPRESSION = PAGE, ONLINE=ON);
GO

ALTER TABLE TestTable REBUILD WITH (DATA_COMPRESSION = PAGE, ONLINE=OFF);
GO

ALTER TABLE PartitionTable1
REBUILD PARTITION = 1 WITH (DATA_COMPRESSION =NONE);
GO

ALTER TABLE PartitionTable1
REBUILD PARTITION = ALL
WITH (DATA_COMPRESSION = PAGE ON PARTITIONS(1));
GO

ALTER TABLE PartitionTable1
REBUILD PARTITION = ALL
WITH (DATA_COMPRESSION = PAGE);    
GO

ALTER TABLE PartitionTable1
REBUILD PARTITION = 1 WITH (DATA_COMPRESSION = COLUMNSTORE_ARCHIVE);
GO

ALTER TABLE PartitionTable1
REBUILD PARTITION = 1 WITH (DATA_COMPRESSION = COLUMNSTORE);
GO

ALTER TABLE T1
REBUILD WITH 
(PAD_INDEX = ON,
ONLINE = ON ( WAIT_AT_LOW_PRIORITY ( MAX_DURATION = 4 MINUTES,
            ABORT_AFTER_WAIT = BLOCKERS )));
GO

-- Create Table with Specified Order in Constraint
CREATE TABLE [dbo].[TestTable] (
  TableID UNIQUEIDENTIFIER NOT NULL,
  Value NVARCHAR(64) NOT NULL,
  Name NVARCHAR(64) NOT NULL,
  CONSTRAINT [PK_TestTable_Value] PRIMARY KEY CLUSTERED (
    [TableID] ASC,
    [Value] ASC))
GO

-- Create Table with NOT NULL and DEFAULT Constraint
CREATE TABLE [dbo].[TestTable] (
  TableID UNIQUEIDENTIFIER NOT NULL,
  Name NVARCHAR(64) NOT NULL,
  Value BIT NOT NULL CONSTRAINT DF_TestTable_Value DEFAULT (0))
  WITH (DATA_COMPRESSION = PAGE)
GO

-- Drop Column
IF EXISTS(SELECT * FROM sys.columns WHERE NAME = N'Name' AND Object_ID = Object_ID(N'dbo.TestTable'))
BEGIN
  ALTER TABLE dbo.TestTable
  DROP COLUMN Name
END
GO

-- Drop Index Using Fully Qualified Name
DROP INDEX dbo.TestTable.UIX_TestTable_Name_Value
GO

-- Alter Table Add Column With Default Constraint First
ALTER TABLE TestTable
  ADD Value BIT
  CONSTRAINT DF_TestTable_Value DEFAULT(0) NOT NULL
GO

-- Alter Table Add Column With Null Constraint First
ALTER TABLE TestTable
  ADD Value BIT NOT NULL
  CONSTRAINT DF_TestTable_Value DEFAULT(0)
GO

-- Alter Table Add Constraint To Column
ALTER TABLE dbo.TestTable 
  ADD CONSTRAINT DF_TestTable_Value DEFAULT(0) 
  FOR Value
GO

-- Alter Table Add Constraint With String Concatenation
ALTER TABLE dbo.TestTable
  ADD CONSTRAINT DF_Name
  DEFAULT('NONE_' + CONVERT(NVARCHAR(40),NEWID())) 
  FOR Name
GO

-- Alter Table Switch Partition
ALTER TABLE Source SWITCH PARTITION 1 TO Target PARTITION 1
GO
ALTER TABLE Source SWITCH TO Target PARTITION 1
GO
ALTER TABLE Source SWITCH PARTITION 1 TO Target WITH (WAIT_AT_LOW_PRIORITY ( MAX_DURATION = 0 minutes, ABORT_AFTER_WAIT = NONE))
GO
ALTER TABLE Source SWITCH TO Target PARTITION $PARTITION.PF_TEST_DT( '20121201' )
GO

-- Alter Table With Constraint and Trigger (param ALL) 
ALTER TABLE dbo.doc_exa NOCHECK CONSTRAINT ALL;
GO
ALTER TABLE dbo.doc_exa DISABLE TRIGGER ALL;
GO

CREATE TABLE [dbo].[t](
	[ID] [int] NOT NULL IDENTITY (-99, - 1) NOT FOR REPLICATION
) ON [PRIMARY]
GO

CREATE TABLE t (c1 integer, c2 integer PRIMARY KEY CLUSTERED (c1, c2));
GO

create TABLE t (c1 int, firmID INT NULL INDEX ix_@filter_1 (c1, firmID) where (firmID > 0) with (fillfactor =70) );
GO

--create table with NONCLUSTERED index
CREATE TABLE t1
(
    c1 INT,
    INDEX ix_1 NONCLUSTERED (c1)
);

CREATE TABLE t1
(
    c1 INT,
    INDEX ix_1 CLUSTERED (c1)
);

--create table with CLUSTERED COLUMNSTORE index
CREATE TABLE t1
(
    c1 INT,
    INDEX ix_1 CLUSTERED COLUMNSTORE ORDER (c1)
);

--create table with CLUSTERED COLUMNSTORE index
CREATE TABLE t1
(
    c1 INT,
    INDEX ix_1 COLUMNSTORE (c1)
);

CREATE TABLE t1
(
    c1 INT,
    INDEX index_name2 UNIQUE NONCLUSTERED ([c1]) with (fillfactor=10)
);

--create table with LEDGER (since mssql 2022)
CREATE TABLE [AccessControl].[KeyCardEvents]
(
    EmployeeID INT NOT NULL,
    AccessOperationDescription NVARCHAR (MAX) NOT NULL,
    [Timestamp] Datetime2 NOT NULL,
    StartTransactionId BIGINT GENERATED ALWAYS AS TRANSACTION_ID START HIDDEN NOT NULL,
    StartSequenceNumber BIGINT GENERATED ALWAYS AS SEQUENCE_NUMBER START HIDDEN NOT NULL
)
WITH (
    LEDGER = ON (
        LEDGER_VIEW = [AccessControl].[KeyCardEventsLedger] (
            TRANSACTION_ID_COLUMN_NAME = TransactionId,
            SEQUENCE_NUMBER_COLUMN_NAME = SequenceNumber,
            OPERATION_TYPE_COLUMN_NAME = OperationId,
            OPERATION_TYPE_DESC_COLUMN_NAME = OperationTypeDescription
        ),
        APPEND_ONLY = ON
    )
);
GO

--create table with LEDGER, SYSTEM_VERSIONING
CREATE TABLE [HR].[Employees]
(
    EmployeeID INT NOT NULL,
    Salary Money NOT NULL
)
WITH (SYSTEM_VERSIONING = ON, LEDGER = ON);
GO

--create table with PERIOD FOR SYSTEM_TIME
CREATE TABLE Department
(
    DepartmentNumber CHAR(10) NOT NULL PRIMARY KEY CLUSTERED,
    DepartmentName VARCHAR(50) NOT NULL,
    ManagerID INT NULL,
    ParentDepartmentNumber CHAR(10) NULL,
    ValidFrom DATETIME2 GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
    ValidTo DATETIME2 GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
    PERIOD FOR SYSTEM_TIME (ValidFrom, ValidTo)
)
WITH (SYSTEM_VERSIONING = ON);

--create table with DATA_DELETION
CREATE TABLE [dbo].[data_retention_table]
(
  [dbdatetime2] datetime2(7),
  [product_code] int,
  [value] char(10)
)
WITH (DATA_DELETION = ON ( FILTER_COLUMN = [dbdatetime2], RETENTION_PERIOD = 1 WEEKS ))

--create table with ENCRYPTED
CREATE TABLE Customers (
    CustName NVARCHAR(60)
        ENCRYPTED WITH (
            COLUMN_ENCRYPTION_KEY = MyCEK,
            ENCRYPTION_TYPE = RANDOMIZED,
            ALGORITHM = 'AEAD_AES_256_CBC_HMAC_SHA_256'
        ),
    SSN VARCHAR(11) COLLATE Latin1_General_BIN2
        ENCRYPTED WITH (
            COLUMN_ENCRYPTION_KEY = MyCEK,
            ENCRYPTION_TYPE = DETERMINISTIC ,
            ALGORITHM = 'AEAD_AES_256_CBC_HMAC_SHA_256'
        ),
    Age INT NULL
);

--create table with DATA_CONSISTENCY_CHECK
CREATE TABLE Department
(
    DepartmentNumber CHAR(10) NOT NULL PRIMARY KEY CLUSTERED,
    DepartmentName VARCHAR(50) NOT NULL,
    ManagerID INT NULL,
    ParentDepartmentNumber CHAR(10) NULL,
    ValidFrom DATETIME2 GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
    ValidTo DATETIME2 GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
    PERIOD FOR SYSTEM_TIME (ValidFrom, ValidTo)
)
WITH
(
    SYSTEM_VERSIONING = ON (HISTORY_TABLE = dbo.Department_History, DATA_CONSISTENCY_CHECK = ON)
);

--create table with other options
CREATE TABLE dbo.Department
(
    DepartmentNumber CHAR(10) NOT NULL PRIMARY KEY NONCLUSTERED,
    DepartmentName VARCHAR(50) NOT NULL,
    ManagerID INT NULL,
    ParentDepartmentNumber CHAR(10) NULL,
    ValidFrom DATETIME2 GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
    ValidTo DATETIME2 GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
    PERIOD FOR SYSTEM_TIME (ValidFrom, ValidTo)
)
WITH
(
    MEMORY_OPTIMIZED = ON,
    DURABILITY = SCHEMA_AND_DATA,
    SYSTEM_VERSIONING = ON (HISTORY_TABLE = History.DepartmentHistory)
);

--create table with COLUMN_SET option
CREATE TABLE T1
(
    c1 INT PRIMARY KEY,
    c2 VARCHAR(50) SPARSE NULL,
    c3 INT SPARSE NULL
    --CSet XML COLUMN_SET FOR ALL_SPARSE_COLUMNS
);

--create table with XML_COMPRESSION option
CREATE TABLE dbo.T1
(
    c1 INT,
    c2 XML
)
WITH (XML_COMPRESSION = ON);

--create table with DATA_COMPRESSION option
CREATE TABLE dbo.T1
(
    c1 INT,
    c2 NVARCHAR(200)
)
WITH (DATA_COMPRESSION = ROW);

--create table with xml column type
CREATE TABLE HumanResources.EmployeeResumes
(
    LName nvarchar(25),
    FName nvarchar(25),
    Resume xml(DOCUMENT HumanResources.HRResumeSchemaCollection)
);

--create table with REMOTE_DATA_ARCHIVE
CREATE TABLE Department
(
    DepartmentNumber CHAR(10) NOT NULL PRIMARY KEY CLUSTERED,
    DepartmentName VARCHAR(50) NOT NULL,
    ManagerID INT NULL,
    ParentDepartmentNumber CHAR(10) NULL,
    ValidFrom DATETIME2 GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
    ValidTo DATETIME2 GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
    PERIOD FOR SYSTEM_TIME (ValidFrom, ValidTo)
)
WITH
(
    REMOTE_DATA_ARCHIVE = ON (FILTER_PREDICATE = function1,
 	MIGRATION_STATE = INBOUND)
);

--create table with DATA_DELETION
CREATE TABLE Department
(
    DepartmentNumber CHAR(10) NOT NULL PRIMARY KEY CLUSTERED,
    DepartmentName VARCHAR(50) NOT NULL,
    ManagerID INT NULL,
    ParentDepartmentNumber CHAR(10) NULL,
    ValidFrom DATETIME2 GENERATED ALWAYS AS ROW START HIDDEN NOT NULL,
    ValidTo DATETIME2 GENERATED ALWAYS AS ROW END HIDDEN NOT NULL,
    PERIOD FOR SYSTEM_TIME (ValidFrom, ValidTo)
)
WITH
(DATA_DELETION = ON
           (FILTER_COLUMN = ManagerID,
            RETENTION_PERIOD = 5 DAYS) 
);

--create EXTERNAL TABLE with AS SELECT
CREATE EXTERNAL TABLE dbo.FactInternetSalesNew
    WITH (
            LOCATION = '/files/Customer',
            DATA_SOURCE = customer_ds,
            FILE_FORMAT = customer_ff
            ) AS

SELECT T1.*
FROM dbo.FactInternetSales T1
INNER JOIN dbo.DimCustomer T2
    ON (T1.CustomerKey = T2.CustomerKey)
OPTION (HASH JOIN);
GO

CREATE EXTERNAL TABLE [dbo].[<myexternaltable>] WITH (
        LOCATION = '<myoutputsubfolder>/',
        DATA_SOURCE = [SynapseSQLwriteable],
        FILE_FORMAT = [ParquetFF]
) AS
SELECT * FROM [<myview>];
GO

--EXTERNAL TABLE without AS Select...
CREATE EXTERNAL TABLE ClickStream (
    url varchar(50),
    event_date date,
    user_IP varchar(50)
)
WITH (
        LOCATION='/webdata/employee.tbl',
        DATA_SOURCE = mydatasource,
        FILE_FORMAT = myfileformat
    )
;
GO

ALTER TABLE InsurancePolicy
SET (SYSTEM_VERSIONING = ON (HISTORY_TABLE = ddd.ggg, HISTORY_RETENTION_PERIOD = 1 YEAR));
GO

ALTER TABLE Department
    SET (SYSTEM_VERSIONING = OFF) ;
GO

ALTER TABLE Department
    SET (SYSTEM_VERSIONING = ON (HISTORY_TABLE=dbo.DepartmentHistory,
                                 DATA_CONSISTENCY_CHECK = OFF));
GO

ALTER TABLE ProjectTask
ADD PERIOD FOR SYSTEM_TIME ([Changed Date], [Revised Date])
GO

ALTER TABLE InsurancePolicy
ADD PERIOD FOR SYSTEM_TIME (ValidFrom, ValidTo),
ValidFrom datetime2 GENERATED ALWAYS AS ROW START HIDDEN NOT NULL DEFAULT SYSUTCDATETIME(),
ValidTo datetime2 GENERATED ALWAYS AS ROW END HIDDEN NOT NULL DEFAULT CONVERT(DATETIME2, '9999-12-31 23:59:59.99999999')
GO

CREATE EXTERNAL TABLE dbo.FactInternetSalesNew (c1, c2)
WITH (LOCATION = '/files/Customer', DATA_SOURCE = customer_ds, FILE_FORMAT = customer_ff)
AS
SELECT T1.* FROM dbo.FactInternetSales T1 INNER JOIN dbo.DimCustomer T2 ON (T1.CustomerKey = T2.CustomerKey) OPTION (HASH JOIN);
GO

CREATE TABLE RestoreDbTable (
  DBNAME int PRIMARY KEY,
  DATABASE_SNAPSHOT int NULL,
  KEEP_CDC int NULL,
  KEEP_REPLICATION int NULL,
  MEDIAPASSWORD int NULL,
  METADATA_ONLY int NULL,
  PAGE int NULL,
  STOPAT int NULL,
  STOPATMARK int NULL,
  STOPBEFOREMARK int NULL,
  FILELISTONLY int NULL,
  HEADERONLY int NULL,
  LABELONLY int NULL,
  LOADHISTORY int NULL,
  NONLOAD int NULL,
  REWINDONLY int NULL,
  UNLOAD int NULL,
  VERIFYONLY int NULL,

);
GO

CREATE TABLE [dbo].["😎 🤙 😎 🤙!!"](
	[c1] [int] NULL,
	[c2] [text] COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

CREATE TABLE [dbo].["🙈 🙉 🙊 🙈 🙉 🙊"](
	[c1] [int] NULL,
	[c2] [text] COLLATE SQL_Latin1_General_CP1_CI_AS NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO