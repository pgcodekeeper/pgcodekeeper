SET search_path = pg_catalog;

DROP EVENT TRIGGER evt1;

DROP EVENT TRIGGER evt2;

ALTER EVENT TRIGGER evt3 ENABLE ALWAYS

CREATE EVENT TRIGGER evt1
	ON ddl_command_end
	WHEN TAG IN ('ALTER COLLATION')
	EXECUTE PROCEDURE proc1();

ALTER EVENT TRIGGER evt1 DISABLE;

ALTER EVENT TRIGGER evt1 OWNER TO role1;

CREATE EVENT TRIGGER evt2
	ON ddl_command_start
	EXECUTE PROCEDURE proc2();

ALTER EVENT TRIGGER evt2 ENABLE REPLICA;