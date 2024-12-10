SET search_path = pg_catalog;

-- DEPCY: This FUNCTION dsimple_lexize is a dependency of FTS_TEMPLATE: public.fts_template

CREATE OR REPLACE FUNCTION public.dsimple_lexize(internal, internal, internal, internal) RETURNS internal
    LANGUAGE internal IMMUTABLE STRICT
    AS $$dsimple_lexize$$;

-- DEPCY: This FUNCTION dsimple_init is a dependency of FTS_TEMPLATE: public.fts_template

CREATE OR REPLACE FUNCTION public.dsimple_init(internal) RETURNS internal
    LANGUAGE internal IMMUTABLE STRICT
    AS $$dsimple_init$$;

CREATE TEXT SEARCH TEMPLATE public.fts_template (
	INIT = public.dsimple_init,
	LEXIZE = public.dsimple_lexize );