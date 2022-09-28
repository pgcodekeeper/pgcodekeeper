CREATE USER MAPPING FOR public SERVER s1;

CREATE USER MAPPING FOR testuser SERVER s2 OPTIONS (password 'secret');

CREATE USER MAPPING FOR testuser SERVER s3 OPTIONS (user 'user1', password 'u');

CREATE USER MAPPING FOR user1 SERVER s4 OPTIONS (username 'test', password 'secret');

CREATE USER MAPPING FOR testuser SERVER s5 OPTIONS (user 'user1', password 'u');