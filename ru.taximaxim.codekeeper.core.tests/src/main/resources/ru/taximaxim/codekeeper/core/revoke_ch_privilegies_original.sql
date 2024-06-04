--revoke column privillegies for User
CREATE USER john
	DEFAULT ROLE admin;

GRANT SELECT(c1) ON default.table2 TO john WITH GRANT OPTION;
GRANT SELECT(c2) ON default.table2 TO john WITH GRANT OPTION;
GRANT INSERT ON default.table2 TO john;
GRANT SELECT(c4, c5) ON default.table1 TO john;

GRANT SELECT(c1) ON default.table2 TO john;
GRANT SELECT(c2) ON default.table2 TO john;

GRANT SHOW ON *.* TO john;

--revoke privillegies for ROLE
CREATE ROLE admin;

GRANT SELECT(c1) ON default.table1 TO admin;
GRANT SHOW TABLES ON default.table4 TO admin;
GRANT SHOW COLUMNS ON default.table4 TO admin;
GRANT SHOW DICTIONARIES ON default.table4 TO admin;
GRANT SELECT ON test_function1 TO admin;
GRANT SHOW ON default.* TO admin;
