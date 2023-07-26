SET search_path = pg_catalog;

CREATE EVENT TRIGGER evt1
ON ddl_command_start
EXECUTE PROCEDURE proc1();