--
-- PostgreSQL database dump
--

SET client_encoding = 'LATIN2';
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'Standard public schema';


--
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: 
--

CREATE PROCEDURAL LANGUAGE plpgsql;


SET search_path = public, pg_catalog;

--
-- Name: testtt; Type: TYPE; Schema: public; Owner: madej
--

CREATE TYPE testtt AS (
	a integer,
	b text
);


ALTER TYPE public.testtt OWNER TO madej;

-- garbled identifier test

CREATE SCHEMA "``54'253-=9!@#$%^&*()__<>?:""{}[];',./";


--
-- Name: "``54'253-=9!@#$%^&*()__<>?:""{}[];',./".".x.."(integer); Type: FUNCTION; Schema: public; Owner: madej
--

CREATE FUNCTION "``54'253-=9!@#$%^&*()__<>?:""{}[];',./".".x"".""""."(integer) RETURNS boolean
    AS $_$
declare
begin
raise notice 'inside: %', $1;
return true;
end;
$_$
    LANGUAGE plpgsql;


ALTER FUNCTION "``54'253-=9!@#$%^&*()__<>?:""{}[];',./".".x.."(integer) OWNER TO madej;

--
-- PostgreSQL database dump complete
--

