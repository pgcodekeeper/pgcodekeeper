REVOKE SELECT(c2) ON default.table1 FROM timon;

REVOKE SELECT(c3) ON default.table1 FROM timon;

REVOKE SHOW ON default.v1 FROM timon;

GRANT SELECT(c1) ON default.table1 TO timon WITH GRANT OPTION;

GRANT SELECT(c2) ON default.table1 TO timon WITH GRANT OPTION;

GRANT SELECT(c3) ON default.table1 TO timon;

REVOKE ALTER VIEW ON default.v1 FROM admin;

REVOKE SELECT(s) ON default.v1 FROM admin;

REVOKE SHOW COLUMNS ON default.v1 FROM admin;

GRANT ALTER VIEW ON default.v1 TO admin WITH GRANT OPTION;

GRANT SELECT(c1) ON default.v1 TO admin;