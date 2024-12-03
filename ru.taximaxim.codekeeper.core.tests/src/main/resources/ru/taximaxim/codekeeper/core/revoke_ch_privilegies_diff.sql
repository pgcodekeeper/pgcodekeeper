REVOKE SELECT(c1) ON default.table2 FROM john;

REVOKE SELECT(c2) ON default.table2 FROM john;

REVOKE INSERT ON default.table2 FROM john;

REVOKE SELECT(c4) ON default.table1 FROM john;

REVOKE SELECT(c5) ON default.table1 FROM john;

REVOKE SHOW ON *.* FROM john;

REVOKE SELECT(c1) ON default.table1 FROM admin;

REVOKE SHOW TABLES ON default.table4 FROM admin;

REVOKE SHOW COLUMNS ON default.table4 FROM admin;

REVOKE SHOW DICTIONARIES ON default.table4 FROM admin;

REVOKE SELECT ON test_function1 FROM admin;

REVOKE SHOW ON default.* FROM admin;