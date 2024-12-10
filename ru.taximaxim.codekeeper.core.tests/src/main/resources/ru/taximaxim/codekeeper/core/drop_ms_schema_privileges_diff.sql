REVOKE INSERT ON SCHEMA::[tester] FROM [test_user]
GO

REVOKE UPDATE ON SCHEMA::[tester] FROM [test_user]
GO

REVOKE SELECT ON SCHEMA::[tester] FROM [test_user] CASCADE
GO