SET search_path = public, pg_catalog;

ALTER TEXT SEARCH DICTIONARY first_dictionary
	(stopwords='myrussian');

ALTER TEXT SEARCH DICTIONARY second_dictionary
	(language='english');

ALTER TEXT SEARCH DICTIONARY third_dictionary
	(stopwords);

ALTER TEXT SEARCH DICTIONARY fourth_dictionary
	(language='english', stopwords);
