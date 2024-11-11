RESTORE DATABASE MyDB1
FROM DISK='C:\MyDB1.bak'
WITH NORECOVERY,
    MOVE 'MyDB1_Data' TO
     'C:\Program Files\Microsoft SQL Server\MSSQL13.Always On1\MSSQL\DATA\MyDB1_Data.mdf',
    MOVE 'MyDB1_Log' TO
     'C:\Program Files\Microsoft SQL Server\MSSQL13.Always On1\MSSQL\DATA\MyDB1_Data.ldf';
GO
RESTORE DATABASE AdventureWorks2022   
FROM DISK = 'Z:\SQLServerBackups\AdventureWorks2022.bak'   
WITH 
	FILE=2, 
   	RECOVERY;
GO
RESTORE LOG AdventureWorks2022   
FROM DISK = 'Z:\SQLServerBackups\AdventureWorksFullRM.bak'   
WITH 
  	FILE=2,   
    standby = N'D:\Program Files\Microsoft SQL Server\MSSQL15.SQL2019\MSSQL\DATA\AW_LS_rollback.BAK',
    nounload,
    stats = 3;
GO
RESTORE LOG AdventureWorks2022   
FROM DISK = 'Z:\SQLServerBackups\AdventureWorksFullRM.bak'   
WITH 
  	FILE=2,   
    standby = 'D:\Program Files\Microsoft SQL Server\MSSQL15.SQL2019\MSSQL\DATA\AW_LS_rollback.BAK',
    nounload,
    KEEP_CDC,
    MOVE 'Z:\SQLTEST' TO 'Z:\SQLTEST\EXAMPLE',
    MOVE 'C:\DBTEST' TO 'D:\DBTEST',
    stats = 3;
GO
RESTORE DATABASE AdventureWorks 
FROM DATABASE_SNAPSHOT = 'AdventureWorks_dbss1800';  
GO
RESTORE DATABASE my_db
PAGE='1:57, 1:202, 1:916, 1:1016'
FROM DISK = 'Z:\SQLServerBackups\AdventureWorksFullRM.bak'
WITH NORECOVERY
GO
RESTORE LOG MyDB1
FROM DISK='C:\MyDB1.bak'
WITH 
	NORECOVERY,
    RESTART,
    FILE=15,
    MEDIAPASSWORD='SECRET_PASSWORD',
    MOVE 'MyDB1_Data' TO
     'C:\Program Files\Microsoft SQL Server\MSSQL13.Always On1\MSSQL\DATA\MyDB1_Data.mdf',
    MOVE 'MyDB1_Log' TO
     'C:\Program Files\Microsoft SQL Server\MSSQL13.Always On1\MSSQL\DATA\MyDB1_Data.ldf';
GO
RESTORE DATABASE AdventureWorks
FROM TAPE='C:\Program Files\Microsoft SQL Server\MSSQL13.Always On1\MSSQL\DATA\MyDB1_Data.ldf'
WITH 
	STANDBY='C:\MyDB1.bak',
	RESTART,
	MOVE 'C:\Program Files\Microsoft\test' TO 'D:\Windows\example',
	ENABLE_BROKER,
	NEW_BROKER,
	CHECKSUM,
	BUFFERCOUNT=124;
GO
RESTORE DATABASE AdventureWorks2022
  FROM AdventureWorks2022Backups;
GO
RESTORE DATABASE AdventureWorks2022
    FROM DISK = 'Z:\SQLServerBackups\AdventureWorks2022.bak'
    WITH FILE = 6,
      NORECOVERY;
RESTORE DATABASE AdventureWorks2022
    FROM DISK = 'Z:\SQLServerBackups\AdventureWorks2022.bak'
    WITH FILE = 9,
      RECOVERY;
GO
RESTORE DATABASE AdventureWorks2022
    FROM AdventureWorksBackups;
RESTORE DATABASE AdventureWorks2022
    FROM AdventureWorksBackups WITH RESTART;
RESTORE DATABASE AdventureWorks2022
    FROM AdventureWorksBackups
    WITH NORECOVERY,
      MOVE 'AdventureWorks2022_Data' TO
'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\Data\NewAdvWorks.mdf',
      MOVE 'AdventureWorks2022_Log'
TO 'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\Data\NewAdvWorks.ldf';
RESTORE LOG AdventureWorks2022
    FROM AdventureWorksBackups
    WITH RECOVERY;
RESTORE FILELISTONLY
    FROM AdventureWorksBackups ;

RESTORE DATABASE TestDB
    FROM AdventureWorksBackups
    WITH MOVE 'AdventureWorks2022_Data' TO 'C:\MySQLServer\testdb.mdf',
    MOVE 'AdventureWorks2022_Log' TO 'C:\MySQLServer\testdb.ldf';
GO
RESTORE DATABASE AdventureWorks2022
    FROM AdventureWorksBackups
    WITH FILE = 3, NORECOVERY;

RESTORE LOG AdventureWorks2022
    FROM AdventureWorksBackups
    WITH FILE = 4, NORECOVERY, STOPAT = 'Apr 15, 2020 12:00 AM';

RESTORE LOG AdventureWorks2022
    FROM AdventureWorksBackups
    WITH FILE = 5, NORECOVERY, STOPAT = 'Apr 15, 2020 12:00 AM';
RESTORE DATABASE AdventureWorks2022 WITH RECOVERY;
RESTORE DATABASE AdventureWorks2022
FROM AdventureWorksBackups
WITH FILE = 3, NORECOVERY;
GO
RESTORE LOG AdventureWorks2022
  FROM AdventureWorksBackups
    WITH FILE = 4,
    RECOVERY,
    STOPATMARK = 'UPDATE Product list prices';
RESTORE DATABASE AdventureWorks2022
    FROM TAPE = '\\.\tape0';
RESTORE DATABASE MyDatabase
    FILE = 'MyDatabase_data_1',
    FILE = 'MyDatabase_data_2',
    FILEGROUP = 'new_customers'
    FROM MyDatabaseBackups
    WITH
      FILE = 9,
      NORECOVERY;
GO
RESTORE LOG MyDatabase
    FROM MyDatabaseBackups
    WITH FILE = 10,
      NORECOVERY;
GO
RESTORE LOG MyDatabase
    FROM MyDatabaseBackups
    WITH FILE = 11,
      NORECOVERY;
GO
RESTORE LOG MyDatabase
    FROM MyDatabaseBackups
    WITH FILE = 12,
      NORECOVERY;
GO
RESTORE DATABASE MyDatabase WITH RECOVERY;
GO
RESTORE FILELISTONLY FROM AdventureWorksBackups   
   WITH FILE=2;  
GO  
RESTORE HEADERONLY
FROM DISK = N'C:\AdventureWorks-FullBackup.bak';
GO
RESTORE LABELONLY  FROM [SQL3-63999] WITH FILE=1;
GO
RESTORE MASTER KEY   
    FROM FILE = 'c:\backups\keys\AdventureWorks2022_master_key'   
    DECRYPTION BY PASSWORD = '3dH85Hhk003#GHkf02597gheij04'   
    ENCRYPTION BY PASSWORD = '259087M#MyjkFkjhywiyedfgGDFD';  
GO  
RESTORE SERVICE MASTER KEY   
    FROM FILE = 'c:\temp_backups\keys\service_master_key'   
    DECRYPTION BY PASSWORD = '3dH85Hhk003GHk2597gheij4';  
GO  
RESTORE REWINDONLY
	FROM TAPE = 'GHkf02597gheij04'
	WITH UNLOAD
RESTORE VERIFYONLY FROM DISK = 'D:\AdventureWorks.bak';
GO
RESTORE DATABASE @dbName
FROM DISK='C:\MyDB1.bak'
WITH NORECOVERY,
    MOVE 'MyDB1_Data' TO
     'C:\Program Files\Microsoft SQL Server\MSSQL13.Always On1\MSSQL\DATA\MyDB1_Data.mdf',
    MOVE 'MyDB1_Log' TO
     'C:\Program Files\Microsoft SQL Server\MSSQL13.Always On1\MSSQL\DATA\MyDB1_Data.ldf';
GO
RESTORE LOG @logName
    FROM MyDatabaseBackups
    WITH FILE = 11,
      NORECOVERY;
GO