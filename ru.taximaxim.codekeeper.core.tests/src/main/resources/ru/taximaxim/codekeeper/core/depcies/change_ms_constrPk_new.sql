SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[Employee](
    [EmployeeID] [int] NOT NULL PRIMARY KEY CLUSTERED WITH (FILLFACTOR = 10)
) ON [PRIMARY]
GO

SET QUOTED_IDENTIFIER ON
GO
SET ANSI_NULLS ON
GO
CREATE TABLE [dbo].[test_fk](
    [col1] [int] NULL REFERENCES [dbo].[Employee] ([EmployeeID])
) ON [PRIMARY]
GO