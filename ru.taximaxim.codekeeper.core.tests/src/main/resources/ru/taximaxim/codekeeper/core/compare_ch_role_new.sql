--compare ROLE's access_storage_type. Added access_storage_type
CREATE ROLE admin1
    IN ldadp;
    
--compare ROLE's access_storage_type. Added default access_storage_type
CREATE ROLE student
    IN local_directory;
    
--compare ROLE's access_storage_type. Added default access_storage_type (not specified)
CREATE ROLE tom;

--compare ROLE's access_storage_type. Nothing changed
CREATE ROLE mouse;

--compare ROLE's access_storage_type. Specified default access_storage_type. Nothing changed
CREATE ROLE jerry
    IN local_directory;