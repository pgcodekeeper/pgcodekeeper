CREATE USER MAPPING FOR sikorskiy_da SERVER server;

ALTER USER MAPPING FOR sikorskiy_da SERVER server OPTIONS (SET password 'public');

DROP USER MAPPING FOR sikorskiy_da SERVER server;