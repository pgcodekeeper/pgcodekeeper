SET search_path = pg_catalog;

-- DEPCY: This AGGREGATE depends on the FUNCTION: public.mode_m_final(bigint[], boolean, integer, text)

DROP AGGREGATE public.mode11_params(boolean, integer, text ORDER BY boolean, text);

DROP FUNCTION public.mode_m_final(bigint[], boolean, integer, text);

-- DEPCY: This FUNCTION is a dependency of AGGREGATE: public.mode11_params(boolean, integer, text, boolean, text)

CREATE OR REPLACE FUNCTION public.mode_m_final(bigint[], boolean, integer, text) RETURNS bytea
    LANGUAGE sql
    AS $_$
SELECT CASE WHEN ( $1[1] = 0 AND $1[2] = 0 )
THEN NULL
ELSE $1[1] >= $1[2]
END;
$_$;

ALTER FUNCTION public.mode_m_final(bigint[], boolean, integer, text) OWNER TO shamsutdinov_lr;

CREATE AGGREGATE public.mode11_params(boolean, integer, text ORDER BY boolean, text) (
	SFUNC = public.mode_bool_state,
	STYPE = integer[],
	FINALFUNC = public.mode_bool_final,
	COMBINEFUNC = public.mode_combine,
	INITCOND = '{0,0}',
	MSFUNC = public.mode_m_state,
	MINVFUNC = public.mode_m_inv,
	MSTYPE = bigint[],
	MFINALFUNC = public.mode_m_final
);

ALTER AGGREGATE public.mode11_params(boolean, integer, text ORDER BY boolean, text) OWNER TO shamsutdinov_lr;
