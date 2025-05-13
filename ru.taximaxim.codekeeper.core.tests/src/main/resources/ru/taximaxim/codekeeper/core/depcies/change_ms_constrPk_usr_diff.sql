-- DEPCY: This CONSTRAINT test_fk_col1_fkey depends on the CONSTRAINT: [dbo].[Employee].[Employee_EmployeeID_pkey]

ALTER TABLE [dbo].[test_fk]
	DROP CONSTRAINT [test_fk_col1_fkey]
GO

ALTER TABLE [dbo].[Employee]
	DROP CONSTRAINT [Employee_EmployeeID_pkey]
GO

ALTER TABLE [dbo].[Employee]
	ADD CONSTRAINT [Employee_EmployeeID_pkey] PRIMARY KEY CLUSTERED  ([EmployeeID]) WITH (FILLFACTOR = 10)
GO

ALTER TABLE [dbo].[test_fk]
	ADD CONSTRAINT [test_fk_col1_fkey] FOREIGN KEY ([col1]) REFERENCES [dbo].[Employee] ([EmployeeID])
GO
