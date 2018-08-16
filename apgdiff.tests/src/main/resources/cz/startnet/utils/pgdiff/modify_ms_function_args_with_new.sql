CREATE TABLE [dbo].[person](
    [id] [int] NOT NULL,
    [name] [nvarchar](255) NOT NULL,
    [value] [int] NOT NULL)
GO

CREATE FUNCTION [dbo].[findPerson] (@Condition INTEGER)  
RETURNS @retFindReports TABLE   
(  
    FindId int primary key NOT NULL,  
    FindName nvarchar(255) NOT NULL 
)
WITH EXECUTE AS SELF
AS  
BEGIN  
WITH PERS_cte(PersonID, PersonName)
    AS (  
        SELECT p.id, p.name
        FROM [dbo].[person] p 
        WHERE p.value = @Condition)  
   INSERT @retFindReports  
   SELECT PersonID, PersonName  
   FROM PERS_cte   
   RETURN
END