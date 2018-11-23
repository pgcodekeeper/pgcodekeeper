ALTER AUTHORIZATION ON SCHEMA::[test_schema] TO [dbo]
GO

ALTER AUTHORIZATION ON TYPE::[dbo].[test_type] TO SCHEMA OWNER
GO

ALTER AUTHORIZATION ON [dbo].[test_sequence] TO SCHEMA OWNER
GO

ALTER AUTHORIZATION ON ASSEMBLY::[test_assembly] TO [dbo]
GO

ALTER AUTHORIZATION ON [dbo].[test_function] TO SCHEMA OWNER
GO

ALTER AUTHORIZATION ON [dbo].[test_procedure] TO SCHEMA OWNER
GO

ALTER AUTHORIZATION ON [dbo].[test_table] TO SCHEMA OWNER
GO

ALTER AUTHORIZATION ON [dbo].[test_view] TO SCHEMA OWNER
GO