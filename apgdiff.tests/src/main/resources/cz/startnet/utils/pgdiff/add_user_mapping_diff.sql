SET search_path = pg_catalog;

CREATE USER MAPPING FOR "current_user" SERVER s6 OPTIONS (
    username 'test'
);

CREATE USER MAPPING FOR "current_role" SERVER s6 OPTIONS (
    "user" 'secret'
);

CREATE USER MAPPING FOR testuser SERVER myserver OPTIONS (
    "this mapping" 'is public'
);

CREATE USER MAPPING FOR public SERVER s8;

CREATE USER MAPPING FOR regress_test_missing_role SERVER s1;