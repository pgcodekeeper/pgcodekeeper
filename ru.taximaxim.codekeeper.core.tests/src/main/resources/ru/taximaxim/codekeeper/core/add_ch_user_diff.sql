CREATE USER jonny
	HOST LOCAL, NAME 'sunny', NAME 'north';

CREATE USER host_ip_user
	HOST LOCAL, IP '192.168.0.0/16', IP '2001:db8::/32';

CREATE USER host_ip_regexp_2
	HOST REGEXP '.*\.ggg\.com', REGEXP '.*\.mysite\.com';

CREATE USER nancy;

CREATE USER arakis
	DEFAULT ROLE harkonnen, artreides;

CREATE USER shai
	DEFAULT ROLE harkonnen, imperator EXCEPT artreides, worm;

CREATE USER arakis2;

CREATE USER arakis3
	DEFAULT ROLE ALL EXCEPT artreides, worm;

CREATE USER arakis4
	DEFAULT ROLE NONE;

CREATE USER fox
	HOST NAME 'new_host_name', IP '192.168.0.0/16', LIKE 'new_template', LIKE 'new_host_name';

CREATE USER def_user
	DEFAULT DATABASE new_database;

CREATE USER rafik
	GRANTEES shaiHulud, artreides;

CREATE USER vinni
	GRANTEES artreides EXCEPT artreides;

CREATE USER sandy
	IN ldadp;

CREATE USER jia_lisa;