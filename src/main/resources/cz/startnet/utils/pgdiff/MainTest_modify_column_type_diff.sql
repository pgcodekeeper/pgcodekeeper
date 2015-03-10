START TRANSACTION;

ALTER TABLE testtable
	ALTER COLUMN field1 TYPE integer; /* TYPE change - table: testtable original: smallint new: integer */

ALTER TABLE testtable
	ALTER COLUMN field3 TYPE character varying(150); /* TYPE change - table: testtable original: character varying(100) new: character varying(150) */


COMMIT TRANSACTION;


/* Original database ignored statements

SET client_encoding = 'UTF8';

SET check_function_bodies = false;

SET client_min_messages = warning;

SET default_tablespace = '';

SET default_with_oids = false;
*/

/* New database ignored statements

SET client_encoding = 'UTF8';

SET check_function_bodies = false;

SET client_min_messages = warning;

SET default_tablespace = '';

SET default_with_oids = false;
*/
