-- DEPCY: This ROLE admin is a dependency of USER: timon

CREATE ROLE admin;

CREATE USER timon
	DEFAULT ROLE admin;