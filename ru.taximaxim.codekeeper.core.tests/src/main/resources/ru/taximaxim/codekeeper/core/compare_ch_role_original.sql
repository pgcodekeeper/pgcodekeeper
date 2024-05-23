--compare ROLE's access_storage_type
CREATE ROLE admin1;

--compare ROLE's access_storage_type. Will add default access_storage_type
CREATE ROLE student
    IN ldadp;

--compare ROLE's access_storage_type. Will add default access_storage_type (not specified)
CREATE ROLE tom
    IN memory;

--compare ROLE's access_storage_type. Nothing changed
CREATE ROLE mouse
    IN local_directory;
    
--compare ROLE's access_storage_type. Not specified default access_storage_type. Nothing changed
CREATE ROLE jerry;