CREATE USER MAPPING FOR public SERVER s1 OPTIONS ("this mapping" 'is public');

CREATE USER MAPPING FOR testuser SERVER s2 OPTIONS (username 'test', password 'secret');

CREATE USER MAPPING FOR testuser SERVER s3 OPTIONS (user 'test', password 'secret');

CREATE USER MAPPING FOR user1 SERVER s4 OPTIONS (username 'test');

CREATE USER MAPPING FOR testuser SERVER s5;