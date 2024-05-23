--compare USER's host name. We have 'LOCAL' name/
CREATE USER anna HOST LOCAL, NAME 'old_host_name', NAME 'LOCAL';

--compare USER's IPs.
CREATE USER host_ip_user HOST LOCAL, IP '192.168.0.0/16', IP '2001:db8::/32';

--compare USER's REGEXPs.
CREATE USER host_ip_regexp HOST REGEXP '.*\.ggg\.com', REGEXP '.*\.mysite\.com';

--compare USER's host options. We will change options.
CREATE USER jonny HOST LOCAL, IP '192.168.0.0/16', REGEXP '.*\.mysite\.com';

--compare USER's host options. We will drop all host options.
CREATE USER nancy HOST LOCAL, IP '192.168.0.0/16', REGEXP '.*\.mysite\.com';

--compare USER's host LIKE options. We will add new host options.
CREATE USER fox HOST LIKE 'template', LIKE 'new_template';

--compare USER's host options. We will host ANY
CREATE USER nut HOST IP '56.168.0.0/16', REGEXP '.*\.ggg\.com' DEFAULT ROLE harkonnen;

--compare USER's roles. We will drop all roles.
CREATE USER arakhis DEFAULT ROLE harkonnen, artreides;

--compare USER's roles. We will add EXCEPT roles.
CREATE USER arakhis2 DEFAULT ROLE harkonnen;

--compare USER's roles. We will drop EXCEPT roles.
CREATE USER mistake HOST ANY DEFAULT ROLE harkonnen EXCEPT shaiHulud;

--compare USER's roles. We will add all roles
CREATE USER simba DEFAULT ROLE leo, king;

--compare USER's roles. We will add all roles and except changed
CREATE USER mufasa DEFAULT ROLE leo, king;

--compare USER's roles. We will not write DEFAULT ROLE
CREATE USER default_roles_2 HOST ANY DEFAULT ROLE harkonnen;

--compare USER's databases. We will databases
CREATE USER def_user DEFAULT DATABASE default;

--compare USER's grantees. We will add except grantees
CREATE USER rafik GRANTEES shaiHulud;

--compare USER's grantees. Equal
CREATE USER timon GRANTEES shaiHulud;

--compare USER's grantees.  We will change grantees
CREATE USER pumba GRANTEES leo;

--compare USER's grantees.  We will change except
CREATE USER worm GRANTEES pig EXCEPT mouse, leo;

--compare USER's grantees.  ANY grantees
CREATE USER worm_2 GRANTEES pig EXCEPT mouse, leo;

--compare USER's grantees.  We will drop except
CREATE USER vinni HOST ANY GRANTEES rabbit EXCEPT tigro;

--compare USER's grantees.  We will change def grantees except
CREATE USER vinni2 HOST ANY GRANTEES harkonnen EXCEPT artreides;

--compare USER's grantees.  We will remove sentence about DEFAULT ROLE ALL
CREATE USER vinni3 HOST ANY DEFAULT ROLE ALL GRANTEES ANY EXCEPT artreides;

--compare USER's's access_storage_type
CREATE USER admin1;

--compare USER's access_storage_type. Will change default access_storage_type
CREATE USER student
    IN ldadp;

--compare USER's access_storage_type. Will change default access_storage_type (not specified)
CREATE USER tom
    IN memory;

--compare USER's access_storage_type. Nothing changed
CREATE USER mouse
    IN local_directory;

--compare USER's access_storage_type. Not specified default access_storage_type. Nothing changed
CREATE USER jerry;
