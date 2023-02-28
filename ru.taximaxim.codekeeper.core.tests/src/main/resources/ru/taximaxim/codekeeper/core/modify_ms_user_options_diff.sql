ALTER USER [test_user] WITH LOGIN = [test_user_2], DEFAULT_SCHEMA = [test]
GO

ALTER USER [test_user1] WITH DEFAULT_SCHEMA = [dbo], ALLOW_ENCRYPTED_VALUE_MODIFICATIONS = ON
GO

ALTER USER [test_user2] WITH DEFAULT_SCHEMA = [test], DEFAULT_LANGUAGE = [Spanish], ALLOW_ENCRYPTED_VALUE_MODIFICATIONS = ON
GO

ALTER USER [test_user3] WITH ALLOW_ENCRYPTED_VALUE_MODIFICATIONS = OFF
GO

ALTER USER [test_user5] WITH ALLOW_ENCRYPTED_VALUE_MODIFICATIONS = OFF
GO

ALTER USER [test_user6] WITH DEFAULT_LANGUAGE = NONE
GO

ALTER USER [test_user8] WITH DEFAULT_LANGUAGE = 1033
GO
