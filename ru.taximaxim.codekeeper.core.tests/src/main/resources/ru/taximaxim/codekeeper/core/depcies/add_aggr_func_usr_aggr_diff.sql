SET search_path = pg_catalog;

-- DEPCY: This FUNCTION mode_m_final1 is a dependency of AGGREGATE: public.mode1(boolean)

CREATE OR REPLACE FUNCTION public.mode_m_final1(bigint[]) RETURNS boolean
    LANGUAGE sql
    AS $$
SELECT 1>2
$$;

ALTER FUNCTION public.mode_m_final1(bigint[]) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_m_inv1 is a dependency of AGGREGATE: public.mode1(boolean)

CREATE OR REPLACE FUNCTION public.mode_m_inv1(bigint[], boolean) RETURNS bigint[]
    LANGUAGE sql
    AS $_$
SELECT $1
$_$;

ALTER FUNCTION public.mode_m_inv1(bigint[], boolean) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_m_state1 is a dependency of AGGREGATE: public.mode1(boolean)

CREATE OR REPLACE FUNCTION public.mode_m_state1(bigint[], boolean) RETURNS bigint[]
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

ALTER FUNCTION public.mode_m_state1(bigint[], boolean) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_bool_final1 is a dependency of AGGREGATE: public.mode1(boolean)

CREATE OR REPLACE FUNCTION public.mode_bool_final1(integer[]) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;

ALTER FUNCTION public.mode_bool_final1(integer[]) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_combine1 is a dependency of AGGREGATE: public.mode1(boolean)

CREATE OR REPLACE FUNCTION public.mode_combine1(integer[], integer[]) RETURNS integer[]
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

ALTER FUNCTION public.mode_combine1(integer[], integer[]) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_bool_state1 is a dependency of AGGREGATE: public.mode1(boolean)

CREATE OR REPLACE FUNCTION public.mode_bool_state1(integer[], boolean) RETURNS integer[]
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

ALTER FUNCTION public.mode_bool_state1(integer[], boolean) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode1(boolean) (
	SFUNC = public.mode_bool_state1,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final1,
	COMBINEFUNC = public.mode_combine1,
	INITCOND = '{0,0}',
	MSFUNC = public.mode_m_state1,
	MINVFUNC = public.mode_m_inv1,
	MSTYPE = bigint[],
	MFINALFUNC = public.mode_m_final1
);

ALTER AGGREGATE public.mode1(boolean) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_m_final3 is a dependency of AGGREGATE: public.mode3()

CREATE OR REPLACE FUNCTION public.mode_m_final3(bigint[]) RETURNS boolean
    LANGUAGE sql
    AS $$
SELECT 1>2
$$;

ALTER FUNCTION public.mode_m_final3(bigint[]) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_m_inv3 is a dependency of AGGREGATE: public.mode3()

CREATE OR REPLACE FUNCTION public.mode_m_inv3(bigint[]) RETURNS bigint[]
    LANGUAGE sql
    AS $_$
SELECT $1
$_$;

ALTER FUNCTION public.mode_m_inv3(bigint[]) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_m_state3 is a dependency of AGGREGATE: public.mode3()

CREATE OR REPLACE FUNCTION public.mode_m_state3(bigint[]) RETURNS bigint[]
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

ALTER FUNCTION public.mode_m_state3(bigint[]) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_bool_final3 is a dependency of AGGREGATE: public.mode3()

CREATE OR REPLACE FUNCTION public.mode_bool_final3(integer[]) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;

ALTER FUNCTION public.mode_bool_final3(integer[]) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_combine3 is a dependency of AGGREGATE: public.mode3()

CREATE OR REPLACE FUNCTION public.mode_combine3(integer[], integer[]) RETURNS integer[]
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

ALTER FUNCTION public.mode_combine3(integer[], integer[]) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_bool_state3 is a dependency of AGGREGATE: public.mode3()

CREATE OR REPLACE FUNCTION public.mode_bool_state3(integer[]) RETURNS integer[]
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

ALTER FUNCTION public.mode_bool_state3(integer[]) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode3(*) (
	SFUNC = public.mode_bool_state3,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final3,
	COMBINEFUNC = public.mode_combine3,
	INITCOND = '{0,0}',
	MSFUNC = public.mode_m_state3,
	MINVFUNC = public.mode_m_inv3,
	MSTYPE = bigint[],
	MFINALFUNC = public.mode_m_final3
);

ALTER AGGREGATE public.mode3(*) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_m_final4 is a dependency of AGGREGATE: public.mode4(boolean)

CREATE OR REPLACE FUNCTION public.mode_m_final4(bigint[]) RETURNS boolean
    LANGUAGE sql
    AS $$
SELECT 1>2
$$;

ALTER FUNCTION public.mode_m_final4(bigint[]) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_m_inv4 is a dependency of AGGREGATE: public.mode4(boolean)

CREATE OR REPLACE FUNCTION public.mode_m_inv4(bigint[], boolean) RETURNS bigint[]
    LANGUAGE sql
    AS $_$
SELECT $1
$_$;

ALTER FUNCTION public.mode_m_inv4(bigint[], boolean) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_m_state4 is a dependency of AGGREGATE: public.mode4(boolean)

CREATE OR REPLACE FUNCTION public.mode_m_state4(bigint[], boolean) RETURNS bigint[]
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

ALTER FUNCTION public.mode_m_state4(bigint[], boolean) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_bool_final4 is a dependency of AGGREGATE: public.mode4(boolean)

CREATE OR REPLACE FUNCTION public.mode_bool_final4(integer[]) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;

ALTER FUNCTION public.mode_bool_final4(integer[]) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_combine4 is a dependency of AGGREGATE: public.mode4(boolean)

CREATE OR REPLACE FUNCTION public.mode_combine4(integer[], integer[]) RETURNS integer[]
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

ALTER FUNCTION public.mode_combine4(integer[], integer[]) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_bool_state4 is a dependency of AGGREGATE: public.mode4(boolean)

CREATE OR REPLACE FUNCTION public.mode_bool_state4(integer[], boolean) RETURNS integer[]
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

ALTER FUNCTION public.mode_bool_state4(integer[], boolean) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode4(ORDER BY boolean) (
	SFUNC = public.mode_bool_state4,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final4,
	COMBINEFUNC = public.mode_combine4,
	INITCOND = '{0,0}',
	MSFUNC = public.mode_m_state4,
	MINVFUNC = public.mode_m_inv4,
	MSTYPE = bigint[],
	MFINALFUNC = public.mode_m_final4
);

ALTER AGGREGATE public.mode4(ORDER BY boolean) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_m_final11 is a dependency of AGGREGATE: public.mode11_params(boolean, integer, text, boolean, text)

CREATE OR REPLACE FUNCTION public.mode_m_final11(bigint[], boolean, integer, text) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;

ALTER FUNCTION public.mode_m_final11(bigint[], boolean, integer, text) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_m_inv11 is a dependency of AGGREGATE: public.mode11_params(boolean, integer, text, boolean, text)

CREATE OR REPLACE FUNCTION public.mode_m_inv11(bigint[], boolean, text) RETURNS bigint[]
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

ALTER FUNCTION public.mode_m_inv11(bigint[], boolean, text) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_m_state11 is a dependency of AGGREGATE: public.mode11_params(boolean, integer, text, boolean, text)

CREATE OR REPLACE FUNCTION public.mode_m_state11(bigint[], boolean, text) RETURNS bigint[]
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

ALTER FUNCTION public.mode_m_state11(bigint[], boolean, text) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_bool_final11 is a dependency of AGGREGATE: public.mode11_params(boolean, integer, text, boolean, text)

CREATE OR REPLACE FUNCTION public.mode_bool_final11(integer[], boolean, integer, text) RETURNS boolean
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;

ALTER FUNCTION public.mode_bool_final11(integer[], boolean, integer, text) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_combine11 is a dependency of AGGREGATE: public.mode11_params(boolean, integer, text, boolean, text)

CREATE OR REPLACE FUNCTION public.mode_combine11(integer[], integer[]) RETURNS integer[]
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

ALTER FUNCTION public.mode_combine11(integer[], integer[]) OWNER TO shamsutdinov_lr;

-- DEPCY: This FUNCTION mode_bool_state11 is a dependency of AGGREGATE: public.mode11_params(boolean, integer, text, boolean, text)

CREATE OR REPLACE FUNCTION public.mode_bool_state11(integer[], boolean, text) RETURNS integer[]
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

ALTER FUNCTION public.mode_bool_state11(integer[], boolean, text) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode11_params(boolean, integer, text ORDER BY boolean, text) (
	SFUNC = public.mode_bool_state11,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final11,
	COMBINEFUNC = public.mode_combine11,
	INITCOND = '{0,0}',
	MSFUNC = public.mode_m_state11,
	MINVFUNC = public.mode_m_inv11,
	MSTYPE = bigint[],
	MFINALFUNC = public.mode_m_final11
);

ALTER AGGREGATE public.mode11_params(boolean, integer, text ORDER BY boolean, text) OWNER TO shamsutdinov_lr;