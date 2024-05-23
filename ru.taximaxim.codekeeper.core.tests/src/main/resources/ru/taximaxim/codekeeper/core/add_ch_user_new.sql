--add USER with LOCAL, HOST NAME
CREATE USER jonny IDENTIFIED WITH sha256_password BY 'ssscsd' HOST LOCAL, NAME 'sunny', NAME 'north';

--add USER with LOCAL, IP
CREATE USER host_ip_user HOST LOCAL, IP '192.168.0.0/16', IP '2001:db8::/32';

--add USER with REGEXP
CREATE USER host_ip_regexp_2 HOST REGEXP '.*\.ggg\.com', REGEXP '.*\.mysite\.com';

--simple adding USER;
CREATE USER nancy;

--add USER with DEFAULT ROLEs
CREATE USER arakis DEFAULT ROLE harkonnen, artreides;

--add USER with DEFAULT ROLEs + EXCEPT roles
CREATE USER shai DEFAULT ROLE harkonnen, imperator EXCEPT artreides, worm;

--add USER with DEFAULT ROLE ALL
CREATE USER arakis2 DEFAULT ROLE ALL;

--add USER with DEFAULT ROLE ALL + EXCEPT roles
CREATE USER arakis3 DEFAULT ROLE ALL EXCEPT artreides, worm;

--add USER with DEFAULT ROLE NONE
CREATE USER arakis4 DEFAULT ROLE NONE;

--add USER with Host options
CREATE USER fox HOST NAME 'new_host_name', IP '192.168.0.0/16', LIKE 'new_template', LIKE 'new_host_name';

--add USER with DEFAULT DATABASE
CREATE USER def_user DEFAULT DATABASE new_database;

--add USER with grantees
CREATE USER rafik GRANTEES shaiHulud, artreides;

--add USER with grantees and EXCEPT
CREATE USER vinni HOST ANY GRANTEES artreides EXCEPT artreides;

--create USER with access_storage_type
CREATE USER sandy
	IN ldadp;

--create USER with access_storage_type local_directory
CREATE USER jia_lisa
	IN local_directory;