GRANT ALL TO pax_writer;
GRANT EXECUTE ON TestProc TO TesterRole WITH GRANT OPTION;
GRANT EXECUTE ON TestMe TO User2;
GRANT EXECUTE ON TestMe TO User2 AS TesterRole;
GRANT VIEW DEFINITION ON AVAILABILITY GROUP::MyAg TO test;
GRANT TAKE OWNERSHIP ON AVAILABILITY GROUP::MyAg TO test WITH GRANT OPTION;
GRANT CONTROL ON AVAILABILITY GROUP::MyAg TO test;
GRANT CREATE TABLE TO test;
GRANT SHOWPLAN TO AuditMonitor;
GRANT CREATE VIEW TO CarmineEs WITH GRANT OPTION;
GRANT CONTROL ON USER::test TO RolandX;
GRANT VIEW DEFINITION ON ROLE::SammamishParking TO JinghaoLiu WITH GRANT OPTION;
GRANT IMPERSONATE ON USER::HamithaL TO test;
GRANT VIEW DEFINITION ON ENDPOINT::test TO test;
GRANT TAKE OWNERSHIP ON ENDPOINT::test TO test WITH GRANT OPTION;
GRANT CONTROL ON FULLTEXT CATALOG :: ProductCatalog TO Ted ;
GRANT VIEW DEFINITION ON FULLTEXT STOPLIST :: ProductStoplist TO Mary ;
GRANT SELECT ON OBJECT::Person.Address TO test;
GRANT EXECUTE ON OBJECT::HumanResources.uspUpdateEmployeeHireInfo TO test;
GRANT REFERENCES (BusinessEntityID) ON OBJECT::HumanResources.vEmployee TO test WITH GRANT OPTION;
GRANT SELECT ON Person.Address TO test;
GRANT SELECT ON Person.Address TO [AdventureWorks2012\test];
GRANT EXECUTE ON dbo.uspGetBillOfMaterials TO newrole ;
GRANT INSERT ON SCHEMA :: HumanResources TO guest;
GRANT SELECT ON SCHEMA :: Person TO WilJo WITH GRANT OPTION;
GRANT VIEW DEFINITION ON SEARCH PROPERTY LIST :: DocumentTablePropertyList TO Mary ;
GRANT CONTROL SERVER TO TerryEminhizer;
GRANT ALTER ANY EVENT NOTIFICATION TO JanethEsteves WITH GRANT OPTION;
GRANT ALTER ANY DATABASE TO ITDevAdmin WITH GRANT OPTION ;
GRANT ALTER ANY DATABASE TO ITDevelopers AS ITDevAdmin ;
GRANT IMPERSONATE ON LOGIN::testBenshoof to [AdvWorks\YoonM];
GRANT VIEW DEFINITION ON LOGIN::test TO test WITH GRANT OPTION;
GRANT VIEW DEFINITION ON SERVER ROLE::Sales TO test;
GRANT ALTER ON SYMMETRIC KEY::test TO test;
GRANT SELECT ON sys.sql_logins TO Sylvester1;
GRANT VIEW SERVER STATE to Sylvester1;
GRANT EXECUTE ON xp_readmail TO Sylvester1;
GRANT VIEW DEFINITION ON TYPE::Telemarketing.PhoneNumber TO KhalidR WITH GRANT OPTION;
GRANT EXECUTE ON XML SCHEMA COLLECTION::Sales.Invoices4 TO test;
--GRANT EXECUTE ON [dbo].[closeLead] to Public,XYZPublic
GRANT VIEW CHANGE TRACKING ON [dbo].[t] TO [test];
REVOKE VIEW DEFINITION ON AVAILABILITY GROUP::MyAg TO test;  
REVOKE TAKE OWNERSHIP ON AVAILABILITY GROUP::MyAg TO test CASCADE;
REVOKE GRANT OPTION FOR CONTROL ON AVAILABILITY GROUP::MyAg TO test CASCADE;
REVOKE CREATE CERTIFICATE FROM test;
REVOKE REFERENCES FROM AuditMonitor;
REVOKE VIEW DEFINITION FROM CarmineEs CASCADE;
REVOKE CONTROL ON USER::test FROM RolandX;
REVOKE VIEW DEFINITION ON ROLE::SammamishParking FROM JinghaoLiu CASCADE;
REVOKE IMPERSONATE ON USER::HamithaL FROM test;
REVOKE VIEW DEFINITION ON ENDPOINT::test FROM test;
REVOKE TAKE OWNERSHIP ON ENDPOINT::test FROM test CASCADE;
REVOKE SELECT ON OBJECT::Person.Address FROM test;
REVOKE EXECUTE ON OBJECT::HumanResources.uspUpdateEmployeeHireInfo FROM test;
REVOKE REFERENCES (BusinessEntityID) ON OBJECT::HumanResources.vEmployee FROM test CASCADE;
REVOKE VIEW SERVER STATE FROM testBenshoof;
REVOKE GRANT OPTION FOR CONNECT SQL FROM JanethEsteves;
REVOKE IMPERSONATE ON LOGIN::testBenshoof FROM [AdvWorks\YoonM];
REVOKE VIEW DEFINITION ON LOGIN::test FROM test CASCADE;
REVOKE VIEW DEFINITION ON SERVER ROLE::Sales TO test;
REVOKE ALTER ON SYMMETRIC KEY::test TO test CASCADE;
--REVOKE EXECUTE ON sys.sp_addlinkedserver FROM public;
REVOKE EXECUTE ON XML SCHEMA COLLECTION::Sales.Invoices4 FROM test;
DENY VIEW DEFINITION ON AVAILABILITY GROUP::MyAg TO test;
DENY TAKE OWNERSHIP ON AVAILABILITY GROUP::MyAg TO test CASCADE;
DENY CREATE CERTIFICATE TO test;
DENY REFERENCES TO AuditMonitor;
DENY VIEW DEFINITION TO CarmineEs CASCADE;
DENY CONTROL ON USER::test TO RolandX;
DENY VIEW DEFINITION ON ROLE::SammamishParking TO JinghaoLiu CASCADE;
DENY IMPERSONATE ON USER::HamithaL TO test;
DENY VIEW DEFINITION ON ENDPOINT::test TO test;
DENY TAKE OWNERSHIP ON ENDPOINT::test TO test CASCADE;
DENY SELECT ON OBJECT::Person.Address TO test;
DENY EXECUTE ON OBJECT::HumanResources.uspUpdateEmployeeHireInfo  TO test;
DENY REFERENCES (BusinessEntityID) ON OBJECT::HumanResources.vEmployee TO test CASCADE;
DENY CONNECT SQL TO Annika CASCADE;
DENY CREATE ENDPOINT TO ArifS AS MandarP;
DENY IMPERSONATE ON LOGIN::testBenshoof TO [AdvWorks\YoonM];
DENY VIEW DEFINITION ON LOGIN::test TO test CASCADE;
DENY VIEW DEFINITION ON SERVER ROLE::Sales TO test ;
DENY ALTER ON SYMMETRIC KEY::test TO test;
--DENY EXECUTE ON sys.xp_cmdshell TO public;
DENY EXECUTE ON XML SCHEMA COLLECTION::Sales.Invoices4 TO test;

EXEC sp_addrolemember TesterRole, User1;

--Test empty statements
;;;

-- Declare XML Schema
DECLARE @x xml (Sales.StoreSurveySchemaCollection)

-- Decrypts a symmetric key and makes it available for use
OPEN SYMMETRIC KEY SomeKeyName DECRYPTION
BY CERTIFICATE SomeCertificateName;
GO;

-- Closing a symmetric key
CLOSE SYMMETRIC KEY SomeKeyName;
GO;

-- Closing all symmetric keys
CLOSE ALL SYMMETRIC KEYS;
GO

-- Conversation timer
BEGIN CONVERSATION TIMER (@dialog_handle)
TIMEOUT = 120;
GO;

-- Beginning a conversation dialog
DECLARE @dialog_handle UNIQUEIDENTIFIER;
BEGIN DIALOG CONVERSATION @dialog_handle
   FROM SERVICE [//Adventure-Works.com/ExpenseClient]
   TO SERVICE '//Adventure-Works.com/Expenses'
   ON CONTRACT [//Adventure-Works.com/Expenses/ExpenseSubmission];
GO;

-- Begin a dialog with an explicit lifetime
DECLARE @dialog_handle UNIQUEIDENTIFIER;
BEGIN DIALOG CONVERSATION @dialog_handle
   FROM SERVICE [//Adventure-Works.com/ExpenseClient]
   TO SERVICE '//Adventure-Works.com/Expenses'
   ON CONTRACT [//Adventure-Works.com/Expenses/ExpenseSubmission]
   WITH LIFETIME = 60;
GO;

-- Begin a dialog with a specific broker instance
DECLARE @dialog_handle UNIQUEIDENTIFIER;
BEGIN DIALOG CONVERSATION @dialog_handle
   FROM SERVICE [//Adventure-Works.com/ExpenseClient]
   TO SERVICE '//Adventure-Works.com/Expenses',
              'a326e034-d4cf-4e8b-8d98-4d7e1926c904'
   ON CONTRACT [//Adventure-Works.com/Expenses/ExpenseSubmission];
GO;

-- Begin a dialog, and relating it to an existing conversation group
DECLARE @dialog_handle UNIQUEIDENTIFIER;
DECLARE @conversation_group_id UNIQUEIDENTIFIER;
BEGIN DIALOG CONVERSATION @dialog_handle
   FROM SERVICE [//Adventure-Works.com/ExpenseClient]
   TO SERVICE '//Adventure-Works.com/Expenses'
   ON CONTRACT [//Adventure-Works.com/Expenses/ExpenseSubmission]
   WITH RELATED_CONVERSATION_GROUP = @conversation_group_id;
GO;

-- Begin a dialog with an explicit lifetime, and relating the dialog to an existing conversation
DECLARE @dialog_handle UNIQUEIDENTIFIER
DECLARE @existing_conversation_handle UNIQUEIDENTIFIER
BEGIN DIALOG CONVERSATION @dialog_handle
   FROM SERVICE [//Adventure-Works.com/ExpenseClient]
   TO SERVICE '//Adventure-Works.com/Expenses'
   ON CONTRACT [//Adventure-Works.com/Expenses/ExpenseSubmission]
   WITH RELATED_CONVERSATION = @existing_conversation_handle
   LIFETIME = 600;
GO;

-- Begin a dialog with optional encryption
DECLARE @dialog_handle UNIQUEIDENTIFIER
BEGIN DIALOG CONVERSATION @dialog_handle
   FROM SERVICE [//Adventure-Works.com/ExpenseClient]
   TO SERVICE '//Adventure-Works.com/Expenses'
   ON CONTRACT [//Adventure-Works.com/Expenses/ExpenseSubmission]
   WITH ENCRYPTION = OFF;
GO;

-- Ending a conversation
END CONVERSATION @dialog_handle;
GO;

-- Ending a conversation with an error
DECLARE @dialog_handle UNIQUEIDENTIFIER,
        @ErrorSave INT,
        @ErrorDesc NVARCHAR(100) ;
BEGIN TRANSACTION ;
SET @ErrorSave = @@ERROR ;

IF (@ErrorSave <> 0)
  BEGIN
      ROLLBACK TRANSACTION ;
      SET @ErrorDesc = N'An error has occurred.' ;
      END CONVERSATION @dialog_handle
      WITH ERROR = @ErrorSave DESCRIPTION = @ErrorDesc ;
  END
ELSE

COMMIT TRANSACTION ;
GO;

-- Cleaning up a conversation that cannot complete normally
END CONVERSATION @dialog_handle WITH CLEANUP;
GO;

-- Getting a conversation group, waiting indefinitely
DECLARE @conversation_group_id UNIQUEIDENTIFIER ;
WAITFOR (
 GET CONVERSATION GROUP @conversation_group_id
     FROM ExpenseQueue
);
GO;

-- Getting a conversation group, waiting one minute
DECLARE @conversation_group_id UNIQUEIDENTIFIER
WAITFOR (
    GET CONVERSATION GROUP @conversation_group_id
    FROM ExpenseQueue ),
TIMEOUT 60000 ;
GO;

-- Getting a conversation group, returning immediately
DECLARE @conversation_group_id UNIQUEIDENTIFIER;
GET CONVERSATION GROUP @conversation_group_id
FROM AdventureWorks.dbo.ExpenseQueue;
GO;

-- Starts a dialog and sends an XML message on the dialog
DECLARE @dialog_handle UNIQUEIDENTIFIER,
        @ExpenseReport XML;

SET @ExpenseReport = '<document/>';

BEGIN DIALOG @dialog_handle
FROM SERVICE [//Adventure-Works.com/Expenses/ExpenseClient]
TO SERVICE '//Adventure-Works.com/Expenses'
ON CONTRACT [//Adventure-Works.com/Expenses/ExpenseProcessing] ;

SEND ON CONVERSATION @dialog_handle
    MESSAGE TYPE [//Adventure-Works.com/Expenses/SubmitExpense]
    (@ExpenseReport) ;
GO;

-- Starts a dialog and sends an XML message on the dialog using local vars without message body
DECLARE @dialog_handle UNIQUEIDENTIFIER,
        @ExpenseReport XML;

SET @ExpenseReport = '<document/>';

BEGIN DIALOG @dialog_handle
FROM SERVICE @from_service
TO SERVICE @to_service
ON CONTRACT @contract;

SEND ON CONVERSATION @dialog_handle
    MESSAGE TYPE @MessageType
GO;

-- Create Master Key
CREATE MASTER KEY ENCRYPTION BY PASSWORD = 'password';
GO;

-- Open Master Key
OPEN MASTER KEY DECRYPTION BY PASSWORD = 'password';
GO;

-- Close Master Key
CLOSE MASTER KEY;
GO;

-- Creating a self-signed certificate
USE AdventureWorks2012;
CREATE CERTIFICATE Shipping04
   ENCRYPTION BY PASSWORD = 'pGFD4bb925DGvbd2439587y'
   WITH SUBJECT = 'Sammamish Shipping Records',
   EXPIRY_DATE = '20201031';
GO;

-- Creating a certificate from a file
USE AdventureWorks2012;
CREATE CERTIFICATE Shipping11
    FROM FILE = 'c:\Shipping\Certs\Shipping11.cer'
    WITH PRIVATE KEY (FILE = 'c:\Shipping\Certs\Shipping11.pvk',
    DECRYPTION BY PASSWORD = 'sldkflk34et6gs%53#v00');
GO;

-- Creating a certificate from a signed executable file
USE AdventureWorks2012;
CREATE CERTIFICATE Shipping19
    FROM EXECUTABLE FILE = 'c:\Shipping\Certs\Shipping19.dll';
GO;

-- Creating a symmetric key
CREATE SYMMETRIC KEY JanainaKey09
WITH ALGORITHM = AES_256
ENCRYPTION BY CERTIFICATE Shipping04;
GO;

-- Creating a temporary symmetric key
CREATE SYMMETRIC KEY #MarketingXXV
WITH ALGORITHM = AES_128,
KEY_SOURCE
     = 'The square of the hypotenuse is equal to the sum of the squares of the sides',
IDENTITY_VALUE = 'Pythagoras'
ENCRYPTION BY CERTIFICATE Marketing25;
GO;

-- Creating a symmetric key using an Extensible Key Management (EKM) device
CREATE SYMMETRIC KEY MySymKey
AUTHORIZATION User1
FROM PROVIDER EKMProvider
WITH
PROVIDER_KEY_NAME='KeyForSensitiveData',
CREATION_DISPOSITION=OPEN_EXISTING;
GO;

-- Creating a message type for an empty message
CREATE MESSAGE TYPE
    [//Adventure-Works.com/Expenses/SubmitExpense]
    VALIDATION = EMPTY;
GO;

-- Creating a message type containing binary data
CREATE MESSAGE TYPE
    [//Adventure-Works.com/Expenses/ReceiptImage]
    VALIDATION = NONE;
GO;

-- Create Contract
CREATE MESSAGE TYPE
    [//Adventure-Works.com/Expenses/SubmitExpense]
    VALIDATION = WELL_FORMED_XML ;

CREATE MESSAGE TYPE
    [//Adventure-Works.com/Expenses/ExpenseApprovedOrDenied]
    VALIDATION = WELL_FORMED_XML ;

CREATE MESSAGE TYPE
    [//Adventure-Works.com/Expenses/ExpenseReimbursed]
    VALIDATION= WELL_FORMED_XML ;

CREATE CONTRACT
    [//Adventure-Works.com/Expenses/ExpenseSubmission]
    ( [//Adventure-Works.com/Expenses/SubmitExpense]
          SENT BY INITIATOR,
      [//Adventure-Works.com/Expenses/ExpenseApprovedOrDenied]
          SENT BY TARGET,
      [//Adventure-Works.com/Expenses/ExpenseReimbursed]
          SENT BY TARGET
    ) ;
GO;

-- Creating a queue with no parameters
CREATE QUEUE ExpenseQueue ;
GO;

-- Creating an unavailable queue
CREATE QUEUE ExpenseQueue WITH STATUS=OFF ;
GO;

-- Creating a queue and specify internal activation information
CREATE QUEUE ExpenseQueue
    WITH STATUS=ON,
    ACTIVATION (
        PROCEDURE_NAME = expense_procedure,
        MAX_QUEUE_READERS = 5,
        EXECUTE AS 'ExpenseUser' ) ;
GO;

-- Creating a queue on a specific filegroup
CREATE QUEUE ExpenseQueue
    ON ExpenseWorkFileGroup ;
GO;

-- Creating a queue with multiple parameters
CREATE QUEUE ExpenseQueue
    WITH STATUS = OFF,
      RETENTION = ON,
      ACTIVATION (
          PROCEDURE_NAME = AdventureWorks2012.dbo.expense_procedure,
          MAX_QUEUE_READERS = 10,
          EXECUTE AS SELF )
    ON [DEFAULT] ;
GO;

-- Making a queue unavailable
ALTER QUEUE ExpenseQueue WITH STATUS = OFF ;
GO;

-- Changing the activation stored procedure
ALTER QUEUE ExpenseQueue
    WITH ACTIVATION (
        PROCEDURE_NAME = new_stored_proc,
        EXECUTE AS SELF) ;
GO;

-- Changing the number of queue readers
ALTER QUEUE ExpenseQueue WITH ACTIVATION (MAX_QUEUE_READERS = 7) ;
GO;

-- Changing the activation stored procedure and the EXECUTE AS account
ALTER QUEUE ExpenseQueue
    WITH ACTIVATION (
        PROCEDURE_NAME = AdventureWorks2012.dbo.new_stored_proc ,
        EXECUTE AS 'SecurityAccount') ;
GO;

-- Setting the queue to retain messages
ALTER QUEUE ExpenseQueue WITH RETENTION = ON ;
GO;

-- Removing activation from a queue
ALTER QUEUE ExpenseQueue WITH ACTIVATION (DROP) ;
GO;

-- Rebuilding queue indexes
ALTER QUEUE ExpenseQueue REBUILD WITH (MAXDOP = 2)
GO;

-- Reorganizing queue indexes
ALTER QUEUE ExpenseQueue REORGANIZE
GO;

-- Moving queue internal table to another filegroup
ALTER QUEUE ExpenseQueue MOVE TO [NewFilegroup]
GO

CREATE CONTRACT [//A] (SENT BY INITIATOR)
GO
REVERT WITH COOKIE = @cookie;
GO
EXECUTE AS USER = 'user1' WITH COOKIE INTO @cookie;
GO
EXECUTE AS USER = 'user2';
GO
EXECUTE test.func 15;
GO
EXECUTE AS CALLER;
GO