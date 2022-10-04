CREATE TYPE [dbo].[type1] AS TABLE(
    [a] [int], 
    [b] [text])
GO

ALTER AUTHORIZATION ON TYPE::[dbo].[type1] TO [ms_user]
GO
