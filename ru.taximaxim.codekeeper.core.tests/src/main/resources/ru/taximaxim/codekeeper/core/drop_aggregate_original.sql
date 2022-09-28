--
-- PostgreSQL database dump
--

SET client_encoding = 'UTF8';
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


SET search_path = pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;


--
-- Name: eeincometax(double precision); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.eeincometax(double precision) RETURNS double precision
    LANGUAGE sql
    AS $_$
SELECT (least($1, 256) * 21) / 79
$_$;


ALTER FUNCTION public.eeincometax(double precision) OWNER TO shamsutdinov_lr;

--
-- Name: grt_finalfunc(point); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.grt_finalfunc(agg_state point) RETURNS double precision
    LANGUAGE plpgsql IMMUTABLE STRICT
    AS $$
begin
  return agg_state[1];
end;
$$;


ALTER FUNCTION public.grt_finalfunc(agg_state point) OWNER TO shamsutdinov_lr;

--
-- Name: grt_sfunc(point, double precision); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.grt_sfunc(agg_state point, el double precision) RETURNS point
    LANGUAGE plpgsql IMMUTABLE
    AS $$
declare
  greatest_sum float8;
  current_sum float8;
begin
  current_sum := agg_state[0] + el;
  if agg_state[1] < current_sum then
    greatest_sum := current_sum;
  else
    greatest_sum := agg_state[1];
  end if;

  return point(current_sum, greatest_sum);
end;
$$;


ALTER FUNCTION public.grt_sfunc(agg_state point, el double precision) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_final(integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_final(integer[]) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;


ALTER FUNCTION public.mode_bool_final(integer[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_final(integer[], boolean); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_final(integer[], boolean) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;


ALTER FUNCTION public.mode_bool_final(integer[], boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_final(integer[], boolean, integer, text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_final(integer[], boolean, integer, text) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;


ALTER FUNCTION public.mode_bool_final(integer[], boolean, integer, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_state(integer[]); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_state(integer[]) RETURNS integer[]
    LANGUAGE sql
    AS $_$
SELECT CASE 1 > 2
WHEN TRUE THEN
    array[ $1[1] + 1, $1[2] ]
WHEN FALSE THEN
    array[ $1[1], $1[2] + 1 ]
ELSE
    $1
END;
$_$;


ALTER FUNCTION public.mode_bool_state(integer[]) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_state(integer[], boolean); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_state(integer[], boolean) RETURNS integer[]
    LANGUAGE sql
    AS $_$
SELECT CASE $2
WHEN TRUE THEN
    array[ $1[1] + 1, $1[2] ]
WHEN FALSE THEN
    array[ $1[1], $1[2] + 1 ]
ELSE
    $1
END;
$_$;


ALTER FUNCTION public.mode_bool_state(integer[], boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_state(integer[], boolean, text); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_state(integer[], boolean, text) RETURNS integer[]
    LANGUAGE sql
    AS $_$
SELECT CASE 1 > 2
WHEN TRUE THEN
    array[ $1[1] + 1, $1[2] ]
WHEN FALSE THEN
    array[ $1[1], $1[2] + 1 ]
ELSE
    $1
END;
$_$;


ALTER FUNCTION public.mode_bool_state(integer[], boolean, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode_bool_state(integer[], boolean, text, integer); Type: FUNCTION; Schema: public; Owner: shamsutdinov_lr
--

CREATE FUNCTION public.mode_bool_state(integer[], boolean, text, integer) RETURNS integer[]
    LANGUAGE sql
    AS $_$
SELECT CASE 1 > 2
WHEN TRUE THEN
    array[ $1[1] + 1, $1[2] ]
WHEN FALSE THEN
    array[ $1[1], $1[2] + 1 ]
ELSE
    $1
END;
$_$;


ALTER FUNCTION public.mode_bool_state(integer[], boolean, text, integer) OWNER TO shamsutdinov_lr;

--
-- Name: aggregate_ee_income_tax(double precision); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.aggregate_ee_income_tax(double precision) (
    SFUNC = float8pl,
    STYPE = double precision,
    INITCOND = '0',
    FINALFUNC = public.eeincometax
);


ALTER AGGREGATE public.aggregate_ee_income_tax(double precision) OWNER TO shamsutdinov_lr;

--
-- Name: aggregate_ee_income_tax2(double precision); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.aggregate_ee_income_tax2(double precision) (
    SFUNC = float8pl,
    STYPE = double precision,
    INITCOND = '0.0',
    FINALFUNC = public.eeincometax
);


ALTER AGGREGATE public.aggregate_ee_income_tax2(double precision) OWNER TO shamsutdinov_lr;

--
-- Name: greatest_running_total(double precision); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.greatest_running_total(double precision) (
    SFUNC = public.grt_sfunc,
    STYPE = point,
    FINALFUNC = public.grt_finalfunc
);


ALTER AGGREGATE public.greatest_running_total(double precision) OWNER TO shamsutdinov_lr;

--
-- Name: mode1(boolean); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode1(boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final
);


ALTER AGGREGATE public.mode1(boolean) OWNER TO shamsutdinov_lr;

--
-- Name: AGGREGATE mode1(boolean); Type: COMMENT; Schema: public; Owner: shamsutdinov_lr
--

COMMENT ON AGGREGATE public.mode1(boolean) IS 'sdfsdf';


--
-- Name: mode10(boolean); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode10(boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{10}',
    FINALFUNC = public.mode_bool_final
);


ALTER AGGREGATE public.mode10(boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode11(boolean, integer, text, boolean, text); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode11(boolean, integer, text ORDER BY boolean, text) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final
);


ALTER AGGREGATE public.mode11(boolean, integer, text ORDER BY boolean, text) OWNER TO shamsutdinov_lr;

--
-- Name: mode12(boolean, boolean); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode12(boolean ORDER BY boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final,
    HYPOTHETICAL
);


ALTER AGGREGATE public.mode12(boolean ORDER BY boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode13(boolean, text, integer); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode13(ORDER BY boolean, text, integer) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final
);


ALTER AGGREGATE public.mode13(ORDER BY boolean, text, integer) OWNER TO shamsutdinov_lr;

--
-- Name: mode2(boolean); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode2(boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final
);


ALTER AGGREGATE public.mode2(boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode3(*); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode3(*) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final
);


ALTER AGGREGATE public.mode3(*) OWNER TO shamsutdinov_lr;

--
-- Name: mode4(boolean); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode4(ORDER BY boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final
);


ALTER AGGREGATE public.mode4(ORDER BY boolean) OWNER TO shamsutdinov_lr;

--
-- Name: AGGREGATE mode4(ORDER BY boolean); Type: COMMENT; Schema: public; Owner: shamsutdinov_lr
--

COMMENT ON AGGREGATE public.mode4(ORDER BY boolean) IS 's1111111';


--
-- Name: mode5(boolean, boolean); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode5(boolean ORDER BY boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final
);


ALTER AGGREGATE public.mode5(boolean ORDER BY boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode6(boolean); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode6(boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final
);


ALTER AGGREGATE public.mode6(boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode7(boolean); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode7(boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final,
    FINALFUNC_MODIFY = READ_WRITE
);


ALTER AGGREGATE public.mode7(boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode8(boolean, boolean); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode8(boolean ORDER BY boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final
);


ALTER AGGREGATE public.mode8(boolean ORDER BY boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode9(boolean, boolean); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode9(boolean ORDER BY boolean) (
    SFUNC = public.mode_bool_state,
    STYPE = integer[],
    INITCOND = '{0,0}',
    FINALFUNC = public.mode_bool_final,
    FINALFUNC_MODIFY = READ_ONLY
);


ALTER AGGREGATE public.mode9(boolean ORDER BY boolean) OWNER TO shamsutdinov_lr;

--
-- Name: mode_seria(internal); Type: AGGREGATE; Schema: public; Owner: shamsutdinov_lr
--

CREATE AGGREGATE public.mode_seria(internal) (
    SFUNC = inet_gist_picksplit,
    STYPE = internal,
    INITCOND = '{0,0}',
    SERIALFUNC = numeric_poly_serialize,
    DESERIALFUNC = numeric_poly_deserialize
);


ALTER AGGREGATE public.mode_seria(internal) OWNER TO shamsutdinov_lr;
