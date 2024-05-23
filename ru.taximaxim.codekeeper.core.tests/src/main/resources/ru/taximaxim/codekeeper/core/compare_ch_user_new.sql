--compare USER's host name. We dropped 'LOCAL' name.
CREATE USER anna HOST LOCAL, NAME 'old_host_name';

--compare USER's IPs. We change IPs(add new one and drop all old).
CREATE USER host_ip_user HOST LOCAL, IP '78.198.0.0/16';

--compare USER's REGEXPs. We change REGEXPs(add new one and drop all old).
CREATE USER host_ip_regexp HOST REGEXP '.*\.dddg\.com';

--compare USER's host options. We will change options.
CREATE USER jonny HOST LOCAL, NAME 'new_host_name', IP '56.168.0.0/16', REGEXP '.*\.yuu\.com';

--compare USER's host options. We will drop all host options.
CREATE USER nancy HOST NONE;

--compare USER's host LIKE options. We will add new host options.
CREATE USER fox HOST LIKE 'template', LIKE 'new_template', LIKE 'new_host_name';

--compare USER's host options. We will add host ANY
CREATE USER nut HOST ANY DEFAULT ROLE harkonnen;

--compare USER's roles. We drop all roles.
CREATE USER arakhis DEFAULT ROLE NONE;

--compare USER's roles. We add EXCEPT roles.
CREATE USER arakhis2 DEFAULT ROLE harkonnen EXCEPT worm;

--compare USER's roles. We will drop EXCEPT roles.
CREATE USER mistake HOST ANY DEFAULT ROLE harkonnen;

--compare USER's roles. We add all roles
CREATE USER simba DEFAULT ROLE ALL;

--compare USER's roles. We will add all roles and except changed
CREATE USER mufasa DEFAULT ROLE ALL EXCEPT worm;

--compare USER's roles. We will not write DEFAULT ROLE
CREATE USER default_roles_2;

--compare USER's databases. We will databases
CREATE USER def_user DEFAULT DATABASE new_database;

--compare USER's grantees. We add except grantees
CREATE USER rafik GRANTEES shaiHulud EXCEPT harkonnen, artreides;

--compare USER's grantees. Equal
CREATE USER timon GRANTEES shaiHulud;

--compare USER's grantees.  We will change grantees
CREATE USER pumba GRANTEES mouse;

--compare USER's grantees.  We will change except
CREATE USER worm GRANTEES pig EXCEPT bird;

--compare USER's grantees. ANY grantees
CREATE USER worm_2 GRANTEES ANY;

--compare USER's grantees.  We will drop except
CREATE USER vinni HOST ANY GRANTEES rabbit;

--compare USER's grantees.  We changed def grantees except
CREATE USER vinni2 HOST ANY GRANTEES ANY EXCEPT artreides;

--compare USER's grantees.  We will remove sentence about DEFAULT ROLE ALL, but this is equal writing. We haven't script!
CREATE USER vinni3 HOST ANY GRANTEES ANY EXCEPT artreides;

--compare USER's access_storage_type. Added access_storage_type
CREATE USER admin1
    IN ldadp;

--compare USER's access_storage_type. Changed default access_storage_type
CREATE USER student
    IN local_directory;

--compare USER's access_storage_type. Changed default access_storage_type (not specified)
CREATE USER tom;

--compare USER's access_storage_type. Nothing changed
CREATE USER mouse;

--compare USER's access_storage_type. Specified default access_storage_type. Nothing changed
CREATE USER jerry
    IN local_directory;
