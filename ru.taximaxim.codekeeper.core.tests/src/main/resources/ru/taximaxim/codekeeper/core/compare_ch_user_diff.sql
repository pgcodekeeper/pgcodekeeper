ALTER USER anna
	HOST LOCAL, NAME 'old_host_name';

ALTER USER host_ip_user
	HOST LOCAL, IP '78.198.0.0/16';

ALTER USER host_ip_regexp
	HOST REGEXP '.*\.dddg\.com';

ALTER USER jonny
	HOST LOCAL, NAME 'new_host_name', IP '56.168.0.0/16', REGEXP '.*\.yuu\.com';

ALTER USER nancy
	HOST NONE;

ALTER USER fox
	HOST LIKE 'template', LIKE 'new_template', LIKE 'new_host_name';

ALTER USER nut
	HOST ANY;

ALTER USER arakhis
	DEFAULT ROLE NONE;

ALTER USER arakhis2
	DEFAULT ROLE harkonnen EXCEPT worm;

ALTER USER mistake
	DEFAULT ROLE harkonnen;

ALTER USER simba
	DEFAULT ROLE ALL;

ALTER USER mufasa
	DEFAULT ROLE ALL EXCEPT worm;

ALTER USER default_roles_2
	DEFAULT ROLE ALL;

ALTER USER def_user
	DEFAULT DATABASE new_database;

ALTER USER rafik
	GRANTEES shaiHulud EXCEPT harkonnen, artreides;

ALTER USER pumba
	GRANTEES mouse;

ALTER USER worm
	GRANTEES pig EXCEPT bird;

ALTER USER worm_2
	GRANTEES ANY;

ALTER USER vinni
	GRANTEES rabbit;

ALTER USER vinni2
	GRANTEES ANY EXCEPT artreides;

MOVE ROLE admin1 TO ldadp;

MOVE ROLE student TO local_directory;

MOVE ROLE tom TO local_directory;