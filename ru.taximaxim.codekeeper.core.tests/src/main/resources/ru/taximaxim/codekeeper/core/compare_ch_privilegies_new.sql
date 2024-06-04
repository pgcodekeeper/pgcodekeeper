--compare privillegies for USER
CREATE USER timon
	DEFAULT ROLE admin;
--changed permission SELECT(c1, c2)
GRANT SELECT(c1) ON default.table1 TO timon WITH GRANT OPTION;
--added GRANT OPTION
GRANT SELECT(c2) ON default.table1 TO timon WITH GRANT OPTION;
--removed WITH GRANT OPTION
GRANT SELECT(c3) ON default.table1 TO timon;
--------------------------------------------------------------
--compare privillegies for ROLE
CREATE ROLE admin;
--added GRANT OPTION
GRANT ALTER VIEW ON default.v1 TO admin WITH GRANT OPTION;
-- changed permission SELECT(s)
GRANT SELECT(c1) ON default.v1 TO admin;
--added grants with permission SHOW ON
GRANT SHOW ON default.v1 TO king WITH GRANT OPTION;

--nothing change
CREATE ROLE king;
GRANT SHOW DATABASES ON default.table4 TO king;

--compare privillegies for USER
CREATE USER khazieva_gr
	DEFAULT ROLE admin;
--splitted grants, nothing change
GRANT SELECT(c1,c2) ON default.table1 TO khazieva_gr WITH GRANT OPTION;
