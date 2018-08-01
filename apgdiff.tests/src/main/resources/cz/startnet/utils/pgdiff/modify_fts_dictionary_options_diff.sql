SET search_path = pg_catalog;

ALTER TEXT SEARCH DICTIONARY public.first_dictionary
	(stopwords='myrussian');

ALTER TEXT SEARCH DICTIONARY public.second_dictionary
	(language='english');

ALTER TEXT SEARCH DICTIONARY public.third_dictionary
	(stopwords);

ALTER TEXT SEARCH DICTIONARY public.fourth_dictionary
	(language='english', stopwords);
