CREATE TYPE public.testtt AS (
	a integer,
	b text
);

ALTER TYPE public.testtt OWNER TO madej;

CREATE SCHEMA "``54'253-=9!@#$%^&*()__<>?:""{}[];',./";

CREATE FUNCTION "``54'253-=9!@#$%^&*()__<>?:""{}[];',./".".x"".""""."(integer) RETURNS boolean
    AS $_$
declare
begin
raise notice 'inside: %', $1;
return true;
end;
$_$
    LANGUAGE plpgsql;


ALTER FUNCTION "``54'253-=9!@#$%^&*()__<>?:""{}[];',./".".x"".""""."(integer) OWNER TO madej;