CREATE TEXT SEARCH TEMPLATE public.template (LEXIZE = lex);

ALTER TEXT SEARCH TEMPLATE public.template SET SCHEMA private;

DROP TEXT SEARCH TEMPLATE private.template;