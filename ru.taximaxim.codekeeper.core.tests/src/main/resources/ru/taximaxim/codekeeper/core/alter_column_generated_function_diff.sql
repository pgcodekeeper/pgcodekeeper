SET search_path = pg_catalog;

-- DEPCY: This COLUMN mess_number depends on the FUNCTION: test.mess_number(integer)

ALTER TABLE ONLY test.message
	DROP COLUMN mess_number;

DROP FUNCTION test.mess_number(p_id_message integer);

CREATE OR REPLACE FUNCTION test.mess_number2(p_id_message integer) RETURNS character varying
    LANGUAGE sql IMMUTABLE PARALLEL SAFE
    AS $$
	select p_id_message::varchar(10); 
$$;

ALTER TABLE test.message
	ADD COLUMN mess_number character varying(30) NOT NULL GENERATED ALWAYS AS (test.mess_number2(id_message)) STORED;