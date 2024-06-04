GRANT DELETE ON *.* TO test_user_01073;
GRANT DROP ON sqllt.view TO sqllt_user;
GRANT INSERT ON *.* TO test_user_01073;
GRANT NONE ON *.* TO test_user_01999 WITH REPLACE OPTION;
GRANT NONE ON *.*, SELECT on db9.tb3 TO test_user_01999 WITH REPLACE OPTION;
GRANT NONE TO test_user_01999 WITH REPLACE OPTION;
GRANT NONE, test_role_01999_1 TO test_user_01999 WITH REPLACE OPTION;
GRANT r1_01292 TO u1_01292;
GRANT r1_01292, r2_01292 TO u1_01292, u2_01292, u3_01292, u4_01292, u5_01292, u6_01292;
GRANT r1_01292, r2_01292 TO u2_01292, u3_01292, u4_01292;
GRANT r2_01292 TO u1_01292;
GRANT USAGE ON *.* TO test WITH REPLACE OPTION;
GRANT SELECT ON *.* TO test_user_01074 WITH GRANT OPTION;
GRANT SELECT ON *.* TO test_user_01074;
GRANT SELECT ON all.* TO test_user_01999 WITH REPLACE OPTION;
GRANT SELECT ON db.* TO test_user_01074 WITH GRANT OPTION;
GRANT SELECT ON db.* TO test_user_01074;
GRANT SELECT ON db.table TO test_user_01074;
GRANT SELECT ON db1.* TO test_role_01073;
GRANT SELECT ON db1.* TO test_user_01073;
GRANT SELECT ON db1.* TO test_user_01999;
GRANT SELECT ON db1.tb1 TO test_user_01999;
GRANT SELECT ON db2.table TO test_user_01073;
GRANT SELECT ON sqllt.table TO sqllt_user;
GRANT SELECT(col1) ON db3.table TO test_user_01073;
GRANT SELECT(col1) ON db3.table TO test_user_01999 WITH REPLACE OPTION;
GRANT SELECT(col1, col2) ON db4.table TO test_user_01073;
GRANT SELECT(col3) ON db3.table3, SELECT(col1, col2) ON db4.table4 TO test_user_01999 WITH REPLACE OPTION;
GRANT SELECT(cola) ON db5.table, INSERT(colb) ON db6.tb61, SHOW ON db7.* TO test_user_01999 WITH REPLACE OPTION;
GRANT SHOW ON db2.tb2 TO test_user_01999;
GRANT SHOW ON db8.* TO test_user_01999;
GRANT SHOW TABLES ON mew.table4 TO user_1 WITH GRANT OPTION WITH REPLACE OPTION;
GRANT sqllt_role TO sqllt_user;
GRANT test_role_01999 to test_user_01999;
GRANT USAGE ON *.* TO test_user_01999 WITH REPLACE OPTION;
REVOKE DROP ON sqllt.view FROM sqllt_user;
REVOKE GRANT OPTION FOR SELECT(col1) ON db.table FROM test_user_01074;
REVOKE ADMIN OPTION FOR test_role_01999 FROM  test_user_01999;
REVOKE test_role_01999 FROM  test_user_01999;
REVOKE INSERT ON *.* FROM test_user_01073;
REVOKE SELECT ON *.* FROM test_user_01074;
REVOKE SELECT ON db.* FROM test_user_01074;
REVOKE SELECT ON db.table FROM test_user_01074;
REVOKE SELECT ON db1.* FROM test_user_01073;
REVOKE SELECT ON db2.table FROM test_user_01073;
REVOKE SELECT ON db3.table FROM test_user_01073;
REVOKE SELECT ON sqllt.table FROM sqllt_user;
REVOKE SELECT(c1) ON db1.table2 FROM test_role_01073;
REVOKE SELECT(c1, c2, c3, c4, c5) ON db1.table1 FROM test_role_01073;
REVOKE SELECT(col1) ON db.table FROM test_user_01074;
REVOKE SELECT(col1, col2) ON db.table FROM test_user_01074;
REVOKE SELECT(col2) ON db4.table FROM test_user_01073;