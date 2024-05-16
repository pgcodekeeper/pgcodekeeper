CREATE USER anna HOST LOCAL, NAME 'old_host_name', NAME 'LOCAL';

CREATE USER host_ip_user HOST LOCAL, IP '192.168.0.0/16', IP '2001:db8::/32';

CREATE USER host_ip_regexp HOST REGEXP '.*\.ggg\.com', REGEXP '.*\.mysite\.com';

CREATE USER jonny HOST LOCAL, IP '192.168.0.0/16', REGEXP '.*\.mysite\.com';
