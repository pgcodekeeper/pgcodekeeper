--add privillegies for USER
CREATE USER timon
	DEFAULT ROLE admin;

--add privillegies with columns permissions for USER
GRANT INSERT ON default.table1 TO timon;
GRANT SELECT(c1) ON default.table1 TO timon WITH GRANT OPTION;
GRANT SELECT(c2) ON default.table1 TO timon WITH GRANT OPTION;
GRANT SELECT(c3, c4) ON default.table1 TO timon;
GRANT SHOW ON *.* TO timon;

--add privillegies for ROLE
CREATE ROLE admin;

GRANT SELECT(c1) ON default.table1 TO admin;
GRANT SHOW TABLES ON default.t2_1.ch1 TO admin WITH GRANT OPTION;
GRANT SELECT ON test_function1 TO admin;
GRANT SHOW ON test.* TO admin;