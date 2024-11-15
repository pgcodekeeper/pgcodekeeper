ALTER CRYPTOGRAPHIC PROVIDER SecurityProvider   
DISABLE;  
GO  
ALTER CRYPTOGRAPHIC PROVIDER SecurityProvider
FROM FILE = 'c:\SecurityProvider\SecurityProvider_v2.dll';
GO
ALTER CRYPTOGRAPHIC PROVIDER SecurityProvider
ENABLE;
GO  

CREATE CRYPTOGRAPHIC PROVIDER SecurityProvider
    FROM FILE = 'C:\SecurityProvider\SecurityProvider_v1.dll';

ALTER CREDENTIAL Saddles WITH IDENTITY = 'RettigB',   
    SECRET = 'sdrlk8$40-dksli87nNN8';  
GO  

ALTER CREDENTIAL Frames WITH IDENTITY = 'Aboulrus8';
GO
CREATE CREDENTIAL AlterEgo WITH IDENTITY = 'Mary5',
    SECRET = '<EnterStrongPasswordHere>';
GO
CREATE CREDENTIAL CredentialForEKM
    WITH IDENTITY='User1OnEKM', SECRET='<EnterStrongPasswordHere>'
    FOR CRYPTOGRAPHIC PROVIDER MyEKMProvider;
GO

CREATE EXTERNAL LIBRARY customPackage
FROM (CONTENT = 'customPackage.zip') WITH (LANGUAGE = 'R')
GO

CREATE EXTERNAL LIBRARY customLibrary FROM (CONTENT = 0xABC123) WITH (LANGUAGE = 'R')
GO

CREATE EXTERNAL LIBRARY customJar
FROM (CONTENT = 'customJar.jar') 
WITH (LANGUAGE = 'Java');
GO

CREATE EXTERNAL LIBRARY lazyeval 
FROM (CONTENT = 'packageA.zip', PLATFORM = WINDOWS),
(CONTENT = 'packageA.tar.gz', PLATFORM = LINUX)
WITH (LANGUAGE = 'R')
GO

ALTER EXTERNAL LIBRARY customPackage 
SET (CONTENT = 'customPackage.zip')
WITH (LANGUAGE = 'R')
GO

ALTER EXTERNAL LIBRARY customLibrary 
SET (CONTENT = 0xABC123) WITH (LANGUAGE = 'R')
GO

ALTER EXTERNAL DATA SOURCE hadoop_eds SET  
     LOCATION = 'hdfs://10.10.10.10:8020',  
     RESOURCE_MANAGER_LOCATION = '10.10.10.10:8032'  
    ;  
ALTER EXTERNAL DATA SOURCE hadoop_eds SET
   CREDENTIAL = new_hadoop_user
    ;
ALTER EXTERNAL DATA SOURCE MyAzureInvoices
    WITH  (
        TYPE = BLOB_STORAGE,
        LOCATION = 'https://newinvoices.blob.core.windows.net',
        CREDENTIAL = UploadInvoices
    );



ALTER WORKLOAD GROUP "default"  
WITH (IMPORTANCE = LOW);  
GO
ALTER RESOURCE GOVERNOR RECONFIGURE;
GO
ALTER WORKLOAD GROUP adHoc
USING [default];
GO
ALTER RESOURCE GOVERNOR RECONFIGURE;
GO
CREATE WORKLOAD GROUP newReports
    USING "default" ;
GO

CREATE XML SCHEMA COLLECTION MyCollection AS @MySchemaCollection 

TRUNCATE TABLE HumanResources.JobCandidate;
GO  
TRUNCATE TABLE PartitionTable1
WITH (PARTITIONS (2, 4, 6 TO 8));
GO
TRUNCATE TABLE v1
WITH (PARTITIONS (1, @PartFirst TO @PartLast));
GO
TRUNCATE TABLE DifferentDB..JobCandidate;
GO
ALTER APPLICATION ROLE weekly_receipts
WITH NAME = receipts_ledger;
GO
ALTER APPLICATION ROLE receipts_ledger
WITH NAME = weekly_ledger,
PASSWORD = '897yUUbv77bsrEE00nk2i',
DEFAULT_SCHEMA = Production;
GO
CREATE APPLICATION ROLE weekly_receipts
    WITH PASSWORD = '987G^bv876sPY)Y5m23'
    , DEFAULT_SCHEMA = Sales;
GO
DBCC SHRINKLOG ( SIZE = DEFAULT );
DBCC SHRINKLOG;
DBCC PDW_SHOWSPACEUSED ( "AdventureWorksPDW2012..FactInternetSales" );
DBCC PROCCACHE  WITH NO_INFOMSGS
DBCC SHOWCONTIG (@id, @indid);
lock table xyz in exclusive mode wait 30
print "Error!"
print "Error: %1!", @anfEnd
print "Error: %1! %2!", @anfEnd, @asd
raiserror 721350 "Fehler %1!.", @err
raiserror 72958 'Quartal %1!.', @quartal
raiserror 641523 'Sülz.'
USE AdventureWorks2012;  
GO  
ALTER FULLTEXT CATALOG ftCatalog   
REBUILD WITH ACCENT_SENSITIVITY=OFF;  
GO  
CREATE FULLTEXT CATALOG ftCatalog AS DEFAULT;
ALTER MESSAGE TYPE  
    [//Adventure-Works.com/Expenses/SubmitExpense]  
    VALIDATION = WELL_FORMED_XML ; 
/* Es folgt ein Kommentar: /* Kommentar */ Danke */
ALTER REMOTE SERVICE BINDING APBinding  
    WITH USER = SecurityAccount 
CREATE REMOTE SERVICE BINDING APBinding
    TO SERVICE '//Adventure-Works.com/services/AccountsPayable'
    WITH USER = APUser ;
CREATE REMOTE SERVICE BINDING APBinding
    TO SERVICE '//Adventure-Works.com/services/AccountsPayable'
    WITH USER = APUser, ANONYMOUS=ON ;
ALTER RESOURCE GOVERNOR RECONFIGURE;
ALTER RESOURCE GOVERNOR WITH (CLASSIFIER_FUNCTION = NULL);
GO
ALTER RESOURCE GOVERNOR RECONFIGURE;
ALTER RESOURCE GOVERNOR WITH (CLASSIFIER_FUNCTION=dbo.rgclassifier_v1);
GO
ALTER RESOURCE GOVERNOR RECONFIGURE;
GO
ALTER RESOURCE GOVERNOR RESET STATISTICS;
ALTER RESOURCE GOVERNOR
WITH (MAX_OUTSTANDING_IO_PER_VOLUME = 20);
CREATE EXTERNAL RESOURCE POOL ep_1
WITH (
    MAX_CPU_PERCENT = 75
    , MAX_MEMORY_PERCENT = 30
)
GO
ALTER EXTERNAL RESOURCE POOL ep_1
WITH (
    MAX_CPU_PERCENT = 50 
    , MAX_MEMORY_PERCENT = 25
)
GO
CREATE EXTERNAL RESOURCE POOL "default"
GO
ALTER EXTERNAL RESOURCE POOL "default"
GO
CREATE RESOURCE POOL bigPool;
GO
ALTER RESOURCE GOVERNOR RECONFIGURE;
GO
CREATE RESOURCE POOL PoolAdmin
WITH (
     MIN_CPU_PERCENT = 10,
     MAX_CPU_PERCENT = 20,
     CAP_CPU_PERCENT = 30,
     AFFINITY SCHEDULER = (0 TO 63, 128 TO 191),
     MIN_MEMORY_PERCENT = 5,
     MAX_MEMORY_PERCENT = 15
      );

CREATE RESOURCE POOL PoolAdmin
WITH (
    MIN_IOPS_PER_VOLUME = 20,
    MAX_IOPS_PER_VOLUME = 100
      );
CREATE ROUTE ExpenseRoute  
    WITH  
    SERVICE_NAME = '//Adventure-Works.com/Expenses',  
    BROKER_INSTANCE = 'D8D4D268-00A3-4C62-8F91-634B89C1E315',  
    ADDRESS = 'TCP://www.Adventure-Works.com:1234' ;  
CREATE ROUTE ExpenseRoute
    WITH
    SERVICE_NAME = '//Adventure-Works.com/Expenses',
    BROKER_INSTANCE = 'D8D4D268-00A3-4C62-8F91-634B89C1E315',
    ADDRESS = 'TCP://SERVER02:1234' ;
CREATE ROUTE ExpenseRoute
    WITH
    SERVICE_NAME = '//Adventure-Works.com/Expenses',
    BROKER_INSTANCE = 'D8D4D268-00A3-4C62-8F91-634B89C1E315',
    ADDRESS = 'TCP://192.168.10.2:1234' ;
CREATE ROUTE ExpenseRoute
    WITH
    ADDRESS = 'TCP://dispatch.Adventure-Works.com' ;
CREATE ROUTE LogRequests
    WITH
    SERVICE_NAME = '//Adventure-Works.com/LogRequests',
    ADDRESS = 'LOCAL' ;
CREATE ROUTE ExpenseRoute
    WITH
    SERVICE_NAME = '//Adventure-Works.com/Expenses',
    LIFETIME = 259200,
    ADDRESS = 'TCP://services.Adventure-Works.com:1234' ;
CREATE ROUTE ExpenseRoute  
    WITH  
    SERVICE_NAME = '//Adventure-Works.com/Expenses',  
    BROKER_INSTANCE = '69fcc80c-2239-4700-8437-1001ecddf933',  
    ADDRESS = 'TCP://services.Adventure-Works.com:1234',   
    MIRROR_ADDRESS = 'TCP://services-mirror.Adventure-Works.com:1234' ;  
CREATE ROUTE TransportRoute  
    WITH ADDRESS = 'TRANSPORT' ;  
CREATE SEARCH PROPERTY LIST DocumentPropertyList;
CREATE SEARCH PROPERTY LIST JobCandidateProperties
FROM AdventureWorks2012.DocumentPropertyList;
CREATE SECURITY POLICY [FederatedSecurityPolicy]   
ADD FILTER PREDICATE [rls].[fn_securitypredicate]([CustomerId])   
ON [dbo].[Customer];  
CREATE SECURITY POLICY [FederatedSecurityPolicy]
ADD FILTER PREDICATE [rls].[fn_securitypredicate1]([CustomerId])
    ON [dbo].[Customer],
ADD FILTER PREDICATE [rls].[fn_securitypredicate1]([VendorId])
    ON [dbo].[ Vendor],
ADD FILTER PREDICATE [rls].[fn_securitypredicate2]([WingId])
    ON [dbo].[Patient]
WITH (STATE = ON);
CREATE SECURITY POLICY rls.SecPol
    ADD FILTER PREDICATE rls.tenantAccessPredicate(TenantId) ON dbo.Sales,
    ADD BLOCK PREDICATE rls.tenantAccessPredicate(TenantId) ON dbo.Sales AFTER INSERT;
CREATE SERVICE [//Adventure-Works.com/Expenses]  
    ON QUEUE [dbo].[ExpenseQueue]  
    ([//Adventure-Works.com/Expenses/ExpenseSubmission]) 
CREATE SERVICE [//Adventure-Works.com/Expenses] ON QUEUE ExpenseQueue
    ([//Adventure-Works.com/Expenses/ExpenseSubmission],
     [//Adventure-Works.com/Expenses/ExpenseProcessing]) ;
CREATE SERVICE [//Adventure-Works.com/Expenses] ON QUEUE ExpenseQueue ;
ALTER FULLTEXT STOPLIST CombinedFunctionWordList ADD 'en' LANGUAGE 'Spanish';  
ALTER FULLTEXT STOPLIST CombinedFunctionWordList ADD 'en' LANGUAGE 'French';  
CREATE FULLTEXT STOPLIST myStoplist;
GO
CREATE FULLTEXT STOPLIST myStoplist2 FROM AdventureWorks.otherStoplist;
GO
CREATE FULLTEXT STOPLIST myStoplist3 FROM SYSTEM STOPLIST;
GO
CREATE SYNONYM MyProduct  
FOR AdventureWorks2012.Production.Product;  
GO  
CREATE SYNONYM MyEmployee FOR Server_Remote.AdventureWorks2012.HumanResources.Employee;  
GO 
CREATE SYNONYM dbo.CorrectOrder
FOR dbo.OrderDozen;
GO

BACKUP CERTIFICATE Shipping04 TO FILE = 'c:\storedcerts\shipping04cert.pfx'
WITH  
    FORMAT = 'PFX',  
    PRIVATE KEY ( 
ENCRYPTION BY PASSWORD = '9n34khUbhk$w4ecJH5gh'
    )
GO

RESTORE SYMMETRIC KEY symmetric_key
   FROM FILE = 'c:\temp_backups\keys\symmetric_key' 
   DECRYPTION BY PASSWORD = '3dH85Hhk003#GHkf02597gheij04'   
   ENCRYPTION BY PASSWORD = '259087M#MyjkFkjhywiyedfgGDFD';
GO

RESTORE SYMMETRIC KEY symmetric_key 
   FROM URL = 'https://mydocsteststorage.blob.core.windows.net/mytestcontainer/symmetric_key.bak'
   DECRYPTION BY PASSWORD = '3dH85Hhk003#GHkf02597gheij04'   
   ENCRYPTION BY PASSWORD = '259087M#MyjkFkjhywiyedfgGDFD';
GO

CREATE EXTERNAL DATA SOURCE MyOracleServer
WITH (
    LOCATION = 'oracle://145.145.145.145:1521',
    CREDENTIAL = OracleProxyAccount,
    PUSHDOWN = ON
);
GO

--CREATE EXTERNAL DATA 2022
CREATE DATABASE SCOPED CREDENTIAL [OracleProxyCredential]
    WITH IDENTITY = 'oracle_username',
    SECRET = 'oracle_password';

CREATE EXTERNAL DATA SOURCE [OracleSalesSrvr]
WITH (
    LOCATION = 'oracle://145.145.145.145:1521',
    CONNECTION_OPTIONS = 'ImpersonateUser=%CURRENT_USER',
    CREDENTIAL = [OracleProxyCredential]
);

--CREATE EXTERNAL LANGUAGE 2022
CREATE EXTERNAL LANGUAGE Java 
FROM (CONTENT = N'<path-to-zip>', FILE_NAME = 'javaextension.dll');
GO

CREATE EXTERNAL LANGUAGE Java
FROM
(CONTENT = N'<path-to-zip>', FILE_NAME = 'javaextension.dll', PLATFORM = WINDOWS),
(CONTENT = N'<path-to-tar.gz>', FILE_NAME = 'javaextension.so', PLATFORM = LINUX);
GO

ALTER EXTERNAL LANGUAGE Java 
SET (CONTENT = N'<path-to-zip>', FILE_NAME = 'javaextension.dll');
GO

CREATE EXTERNAL FILE FORMAT parquetfile1
WITH (
    FORMAT_TYPE = PARQUET,
    DATA_COMPRESSION = ''
);

CREATE EXTERNAL FILE FORMAT skipHeader_CSV
WITH (FORMAT_TYPE = DELIMITEDTEXT,
      FORMAT_OPTIONS(
          FIELD_TERMINATOR = ',',
          STRING_DELIMITER = '"',
          FIRST_ROW = 2,
          USE_TYPE_DEFAULT = True)
);

CREATE EXTERNAL FILE FORMAT DeltaFileFormat
WITH (
    FORMAT_TYPE = DELTA
);

CREATE EXTERNAL FILE FORMAT textdelimited1
WITH (
    FORMAT_TYPE = DELIMITEDTEXT,
    FORMAT_OPTIONS (
        FIELD_TERMINATOR = '|',
        DATE_FORMAT = 'MM/dd/yyyy' ),
    DATA_COMPRESSION = 'org.apache.hadoop.io.compress.GzipCodec'
);

CREATE EXTERNAL FILE FORMAT rcfile1
WITH (
    FORMAT_TYPE = RCFILE,
    SERDE_METHOD = 'org.apache.hadoop.hive.serde2.columnar.LazyBinaryColumnarSerDe',
    DATA_COMPRESSION = 'org.apache.hadoop.io.compress.DefaultCodec'
);

SET QUOTED_IDENTIFIER, ANSI_NULLS ON;
set nocount, xact_abort on;