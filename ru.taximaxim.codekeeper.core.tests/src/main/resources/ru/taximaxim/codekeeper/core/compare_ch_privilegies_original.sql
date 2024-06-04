--compare privillegies for USER
CREATE USER timon
	DEFAULT ROLE admin;
--Will change permission SELECT(c1, c2)
GRANT SELECT(c1, c2) ON default.table1 TO timon WITH GRANT OPTION;
--Will add GRANT OPTION
GRANT SELECT(c2) ON default.table1 TO timon;
--Will remove WITH GRANT OPTION
GRANT SELECT(c3) ON default.table1 TO timon WITH GRANT OPTION;
--Will remove SHOW ON grant
GRANT SHOW ON default.v1 TO timon WITH GRANT OPTION;
--------------------------------------------------------------
 --compare privillegies for ROLE
CREATE ROLE admin;

--Will add GRANT OPTION
GRANT ALTER VIEW ON default.v1 TO admin;
--Will change permission SELECT(s) GRANT OPTION
GRANT SELECT(s) ON default.v1 TO admin;
--Will remove grants for cols
GRANT SHOW COLUMNS ON default.v1 TO admin WITH GRANT OPTION;

--nothing change
CREATE ROLE king;
GRANT SHOW DATABASES ON default.table4 TO king;

--compare privillegies for USER
CREATE USER khazieva_gr
	DEFAULT ROLE admin;
--splitted grants
GRANT SELECT(c1) ON default.table1 TO khazieva_gr WITH GRANT OPTION;
GRANT SELECT(c2) ON default.table1 TO khazieva_gr WITH GRANT OPTION;