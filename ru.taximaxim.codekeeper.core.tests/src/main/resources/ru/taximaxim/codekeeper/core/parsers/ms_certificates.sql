BACKUP CERTIFICATE sales05 TO FILE = 'c:\storedcerts\sales05cert';  
GO 
BACKUP CERTIFICATE sales05 TO FILE = 'c:\storedcerts\sales05cert'
    WITH PRIVATE KEY ( FILE = 'c:\storedkeys\sales05key' ,
    ENCRYPTION BY PASSWORD = '997jkhUbhk$w4ez0876hKHJH5gh' );
GO
BACKUP CERTIFICATE sales09 TO FILE = 'c:\storedcerts\sales09cert'
    WITH PRIVATE KEY ( DECRYPTION BY PASSWORD = '9875t6#6rfid7vble7r' ,
    FILE = 'c:\storedkeys\sales09key' ,
    ENCRYPTION BY PASSWORD = '9n34khUbhk$w4ecJH5gh' );
GO
BACKUP CERTIFICATE sales05 TO FILE = '\\ServerA7\storedcerts\sales05cert'
    WITH PRIVATE KEY ( FILE = '\\ServerA7\storedkeys\sales05key' ,
    ENCRYPTION BY PASSWORD = '997jkhUbhk$w4ez0876hKHJH5gh' );
GO  
ALTER CERTIFICATE Shipping04   
    WITH PRIVATE KEY (DECRYPTION BY PASSWORD = 'pGF$5DGvbd2439587y',  
    ENCRYPTION BY PASSWORD = '4-329578thlkajdshglXCSgf');  
GO  
ALTER CERTIFICATE Shipping11
    WITH PRIVATE KEY (ENCRYPTION BY PASSWORD = '34958tosdgfkh##38',
    DECRYPTION BY PASSWORD = '95hkjdskghFDGGG4%');
GO
ALTER CERTIFICATE Shipping13   
    WITH PRIVATE KEY (FILE = 'c:\\importedkeys\Shipping13',  
    DECRYPTION BY PASSWORD = 'GDFLKl8^^GGG4000%');  
GO  
ALTER CERTIFICATE Shipping15
    WITH PRIVATE KEY (DECRYPTION BY PASSWORD = '95hk000eEnvjkjy#F%');
GO  