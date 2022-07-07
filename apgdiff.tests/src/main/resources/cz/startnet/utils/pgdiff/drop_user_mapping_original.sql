CREATE USER MAPPING FOR public SERVER s8; 

CREATE USER MAPPING FOR current_user SERVER t1 OPTIONS (username 'bob', password 'boo');

CREATE USER MAPPING FOR testuser SERVER s1;
