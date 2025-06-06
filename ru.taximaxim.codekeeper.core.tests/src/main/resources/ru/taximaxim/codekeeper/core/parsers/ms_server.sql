USE master  
GO  
ALTER SERVER AUDIT HIPAA_Audit  
WITH (STATE = OFF);  
GO  
ALTER SERVER AUDIT HIPAA_Audit  
MODIFY NAME = HIPAA_Audit_Old;  
GO  
ALTER SERVER AUDIT HIPAA_Audit_Old  
WITH (STATE = ON);  
GO  
USE master  
GO  
ALTER SERVER AUDIT HIPAA_Audit  
WITH (STATE = OFF);  
GO  
ALTER SERVER AUDIT HIPAA_Audit  
TO FILE (FILEPATH ='\\SQLPROD_1\Audit\',  
          MAXSIZE = 1000 MB,  
          RESERVE_DISK_SPACE=OFF)  
WITH (QUEUE_DELAY = 1000,  
       ON_FAILURE = CONTINUE);  
GO  
ALTER SERVER AUDIT HIPAA_Audit  
WITH (STATE = ON);  
GO  
ALTER SERVER AUDIT [FilterForSensitiveData] WITH (STATE = OFF)  
GO  
ALTER SERVER AUDIT [FilterForSensitiveData]  
WHERE user_defined_event_id = 27;  
GO  
ALTER SERVER AUDIT [FilterForSensitiveData] WITH (STATE = ON);  
GO  
ALTER SERVER AUDIT [FilterForSensitiveData] WITH (STATE = OFF)  
GO  
ALTER SERVER AUDIT [FilterForSensitiveData]  
REMOVE WHERE;  
GO  
ALTER SERVER AUDIT [FilterForSensitiveData] WITH (STATE = ON);  
GO
ALTER SERVER AUDIT [FilterForSensitiveData] WITH (STATE = OFF)  
GO  
ALTER SERVER AUDIT [FilterForSensitiveData]  
MODIFY NAME = AuditDataAccess;  
GO  
ALTER SERVER AUDIT [AuditDataAccess] WITH (STATE = ON);  
GO  
CREATE SERVER AUDIT HIPAA_Audit
    TO FILE ( FILEPATH ='\\SQLPROD_1\Audit\' );
CREATE SERVER AUDIT HIPAA_Audit
    TO APPLICATION_LOG
    WITH ( QUEUE_DELAY = 1000,  ON_FAILURE = SHUTDOWN);
CREATE SERVER AUDIT AuditDataAccess
    TO FILE ( FILEPATH ='C:\SQLAudit\' )
    WHERE object_name = 'SensitiveData' ;
GO
ALTER SERVER AUDIT SPECIFICATION HIPPA_Audit_Specification  
FOR SERVER AUDIT HIPPA_Audit  
    DROP (FAILED_LOGIN_GROUP)  
    ADD (DATABASE_OBJECT_ACCESS_GROUP);  
GO  
CREATE SERVER AUDIT SPECIFICATION HIPPA_Audit_Specification
FOR SERVER AUDIT HIPPA_Audit
    ADD (FAILED_LOGIN_GROUP);
GO
CREATE SERVER AUDIT HIPAA_Audit
    TO APPLICATION_LOG
    WITH ( QUEUE_DELAY = 1000,  ON_FAILURE = SHUTDOWN);
GO

CREATE SERVER AUDIT AuditDataAccess
    TO FILE ( FILEPATH ='C:\SQLAudit\' )
    WHERE object_name = 'SensitiveData' ;
GO
ALTER SERVER CONFIGURATION   
SET PROCESS AFFINITY CPU=0 TO 63, 128 TO 191; 
ALTER SERVER CONFIGURATION
SET PROCESS AFFINITY NUMANODE=0, 7;
ALTER SERVER CONFIGURATION
SET PROCESS AFFINITY NUMANODE=0, 7;
ALTER SERVER CONFIGURATION SET PROCESS AFFINITY CPU=0;
ALTER SERVER CONFIGURATION
SET PROCESS AFFINITY CPU=AUTO;
ALTER SERVER CONFIGURATION SET DIAGNOSTICS LOG ON;
ALTER SERVER CONFIGURATION SET DIAGNOSTICS LOG OFF;
ALTER SERVER CONFIGURATION
SET DIAGNOSTICS LOG PATH = 'C:\logs';
ALTER SERVER CONFIGURATION
SET DIAGNOSTICS LOG MAX_SIZE = 10 MB;
ALTER SERVER CONFIGURATION
SET FAILOVER CLUSTER PROPERTY HealthCheckTimeout = 15000;
ALTER SERVER CONFIGURATION SET HADR CLUSTER CONTEXT = 'clus01.xyz.com';
ALTER SERVER CONFIGURATION
SET BUFFER POOL EXTENSION ON
    (FILENAME = 'F:\SSDCACHE\Example.BPE', SIZE = 50 GB);
ALTER SERVER CONFIGURATION
SET BUFFER POOL EXTENSION OFF;
GO
ALTER SERVER CONFIGURATION
SET BUFFER POOL EXTENSION ON
    (FILENAME = 'F:\SSDCACHE\Example.BPE', SIZE = 60 GB);
GO
ALTER SERVER ROLE Product WITH NAME = Production ;
ALTER SERVER ROLE Production ADD MEMBER [adventure-works\roberto0] ;
ALTER SERVER ROLE diskadmin ADD MEMBER Ted ;
ALTER SERVER ROLE Production DROP MEMBER [adventure-works\roberto0] ;
ALTER SERVER ROLE Production DROP MEMBER Ted ;
ALTER SERVER ROLE LargeRC ADD MEMBER Anna;
ALTER SERVER ROLE LargeRC DROP MEMBER Anna;
USE master;  
CREATE SERVER ROLE buyers AUTHORIZATION BenMiller;  
GO  
USE master;
CREATE SERVER ROLE auditors AUTHORIZATION securityadmin;
GO



