CREATE SCHEMA test;

CREATE TABLE test.message (
	id_message integer NOT NULL,
	mess_number character varying(30) NOT NULL GENERATED ALWAYS AS (test.mess_number(id_message)) STORED
);

CREATE OR REPLACE FUNCTION test.mess_number(p_id_message integer) RETURNS character varying
    LANGUAGE sql IMMUTABLE PARALLEL SAFE
    AS $$
	select p_id_message::varchar(10); 
$$;