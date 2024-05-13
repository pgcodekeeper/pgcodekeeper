DROP FUNCTION [dbo].[dropped_function]
GO

-- DEPCY: This FUNCTION depends on the TYPE: [dbo].[custom_type]

DROP FUNCTION [dbo].[changed_function]
GO

-- DEPCY: This FUNCTION depends on the TYPE: [dbo].[custom_type]

DROP FUNCTION [dbo].[getboolean]
GO

DROP TYPE [dbo].[custom_type]
GO

-- DEPCY: This TYPE is a dependency of FUNCTION: [dbo].[changed_function]

CREATE TYPE [dbo].[custom_type] FROM [bit]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
--changed
CREATE FUNCTION [dbo].[changed_function]() 
RETURNS dbo.custom_type
AS     
BEGIN
    RETURN 777;
END
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE FUNCTION [dbo].[getboolean]() 
RETURNS dbo.custom_type
AS     
BEGIN
    RETURN 1;
END
GO