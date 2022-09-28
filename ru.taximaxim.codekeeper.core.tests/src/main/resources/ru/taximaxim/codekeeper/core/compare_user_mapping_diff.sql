SET search_path = pg_catalog;

ALTER USER MAPPING FOR public SERVER s1 OPTIONS (DROP "this mapping" );

ALTER USER MAPPING FOR testuser SERVER s2 OPTIONS (DROP username );

ALTER USER MAPPING FOR testuser SERVER s3 OPTIONS (SET "user" 'user1');

ALTER USER MAPPING FOR testuser SERVER s3 OPTIONS (SET password 'u');

ALTER USER MAPPING FOR user1 SERVER s4 OPTIONS (ADD password 'secret');

ALTER USER MAPPING FOR testuser SERVER s5 OPTIONS (ADD "user" 'user1');

ALTER USER MAPPING FOR testuser SERVER s5 OPTIONS (ADD password 'u');