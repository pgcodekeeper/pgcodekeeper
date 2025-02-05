create procedure a as begin
	select 1
end
go
create procedure b as begin
	select 2
end
go

-- call stored procedure, name in local var
IF EXISTS (SELECT * FROM sys.objects WHERE type = 'P' AND name = 'TestSproc')
  DROP PROCEDURE dbo.TestSproc
GO

CREATE PROCEDURE dbo.TestSproc @Name nvarchar(30) AS SELECT @Name RETURN
GO

DECLARE @SprocName nvarchar(64) = 'TestSproc';
DECLARE @TestName nvarchar(64) = 'Foo'
DECLARE @Result nvarchar(64)
EXEC @Result = @SprocName @Name = @TestName;
SELECT @Result
GO


CREATE OR ALTER PROC What_DB_is_this
AS
SELECT DB_NAME() AS ThisDB;
GO


CREATE PROCEDURE [dbo].[p1] 
WITH EXECUTE AS OWNER
AS
BEGIN
    SELECT
        ord.LoadId AS ID, 
        (SELECT 1 FROM dbo.LoadRoutes FOR XML RAW ('v'), ELEMENTS, ROOT ('vs')) AS ExtraPoints;
END;
GO

CREATE PROCEDURE dbo.p
WITH EXECUTE AS 'Domain\User1'
AS SELECT user_name();
GO

CREATE PROCEDURE [dbo].[p]
  @f1 NVARCHAR(100) NULL = NULL,
  @f2 NVARCHAR(100) NULL,
  @f3 NVARCHAR(100) = NULL,
  @f4 NVARCHAR(100) NULL = "test",
  @f5 NVARCHAR(100) = GETDATE,
  @f6 DATETIME = @@DATEFIRST OUT,
  @f7 NVARCHAR(100) NULL = [test]
WITH EXECUTE AS OWNER AS
BEGIN
    SET STATISTICS TIME, IO, XML, TIME ON;
    select @f6;
END;
GO

 -- reconfigure option
 CREATE PROCEDURE [dbo].[p]
@IDBase int,
@IDClfis int,
@Url nvarchar(1000)
as
BEGIN
    if 1 <> @show_advanced 
    begin 
      exec sys.sp_configure @configname = N'show advanced options', @configvalue = 1 
      reconfigure with override 
    end 
    
    exec sys.sp_configure @configname = N'Agent yyy', @configvalue = @new_value 
    reconfigure with override 
    if 1 <> @show_advanced 
    begin 
      exec sys.sp_configure @configname = N'show advanced options', @configvalue = 0 
      reconfigure with override
      end
END;
GO

 --RAISERROR null value
 CREATE PROCEDURE [dbo].[proc1]
@IDBase int,
@IDClfis int,
@Url nvarchar(1000)
as
begin
    IF @action_type = @create AND @dac_object_type = @database --database create
    BEGIN
        RAISERROR(N'%d, %d, %s', -1, 1, @sequence_id, @rollback_pending, NULL) WITH NOWAIT

        EXEC dbo.sp_sysdac_drop_database @database_name = @dac_object_name_pretran
        
        RAISERROR(N'%d, %d, %s', -1, 1, @sequence_id, @rollback_success, NULL) WITH NOWAIT
    END
    ELSE IF @action_type = @rename AND @dac_object_type = @database --database rename
    BEGIN
        RAISERROR(N'%d, %d, %s', -1, 1, @sequence_id, @rollback_pending, NULL) WITH NOWAIT

        EXEC dbo.sp_sysdac_rename_database @dac_object_name_posttran, @dac_object_name_pretran

        RAISERROR(N'%d, %d, %s', -1, 1, @sequence_id, @rollback_success, NULL) WITH NOWAIT
    END
end;
GO

 --LOGIN value
CREATE PROCEDURE [dbo].[sp_sqlagent_is_srvrolemember]
   @role_name sysname, @login_name sysname
AS
BEGIN
  DECLARE @is_member        INT
  SET NOCOUNT ON
     EXECUTE AS LOGIN = @login_name -- impersonate 
        SELECT @is_member = IS_SRVROLEMEMBER(@role_name)  -- check role membership 
  RETURN ISNULL(@is_member,0)
END
GO

CREATE   PROCEDURE [dbo].[p_CheckDetails_Get]
    @FirmId INT,
    @InvoiceID INT
WITH EXECUTE AS OWNER
AS
BEGIN
    SET NOCOUNT ON;
    DECLARE @zeroMoney MONEY = 0;
    DECLARE @true BIT = 1;
    DECLARE @false BIT = 0;
   -- special character 0x200b ​
    
    ​
    SELECT i.InvoiceID,
           i.UserID,
           i.SummaBezNDS AS SumWithoutVat,
           i.NDS AS Vat,
           i.Deleted,
           i.PeriodID,
           ISNULL(p.PayDate, i.InvDate) AS PayDate,
           i.InvoiceNumber
    FROM dbo.Invoices i WITH (NOLOCK)
        LEFT JOIN dbo.Payments p WITH (NOLOCK)
            ON p.PayNumber = i.InvoiceID
    WHERE i.InvoiceID = @InvoiceID
          AND i.UserID = @FirmId;

END
​GO