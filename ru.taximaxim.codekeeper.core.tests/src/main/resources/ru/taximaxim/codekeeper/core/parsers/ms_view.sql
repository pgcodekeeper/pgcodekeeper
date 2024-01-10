CREATE VIEW v1 AS
SELECT c1, c2
FROM t1;
GO

-- WITH XMLNAMESPACES
CREATE VIEW v2
AS
WITH XMLNAMESPACES (N'http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.SmartAdmin.SmartBackupAgent' as sb), rg as (select 1 as j) 
select * from rg
GO

CREATE VIEW v3
AS
WITH XMLNAMESPACES (N'http://schemas.datacontract.org/2004/07/Microsoft.SqlServer.SmartAdmin.SmartBackupAgent' AS sb)
SELECT 1
GO