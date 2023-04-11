CREATE TEXT SEARCH PARSER public.test_parser (
	START = prsd_start,
	GETTOKEN = prsd_nexttoken,
	END = prsd_end,
	HEADLINE = prsd_headline,
	LEXTYPES = prsd_lextype );
	
CREATE FUNCTION public.test_fnc(arg character varying) RETURNS boolean
    LANGUAGE plpgsql
    AS $$BEGIN
RETURN true;
END;$$;

CREATE FUNCTION public.trigger_fnc() RETURNS trigger
    LANGUAGE plpgsql
    AS $$begin
end;$$;

CREATE TEXT SEARCH TEMPLATE public.test_template (
	LEXIZE = dsnowball_lexize );

CREATE TEXT SEARCH DICTIONARY public.test_dictionary (
	TEMPLATE = snowball,
	language = 'english',
	stopwords = 'english' );

CREATE TEXT SEARCH CONFIGURATION public.test_config (
	PARSER = pg_catalog."default" );

