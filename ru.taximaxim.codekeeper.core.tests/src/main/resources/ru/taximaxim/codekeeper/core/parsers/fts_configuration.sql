CREATE TEXT SEARCH CONFIGURATION public.english_ns ( COPY = english );

ALTER TEXT SEARCH CONFIGURATION public.english_ns
  ALTER MAPPING REPLACE english WITH swedish;

DROP TEXT SEARCH CONFIGURATION public.english_ns