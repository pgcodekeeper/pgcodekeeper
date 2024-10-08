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
