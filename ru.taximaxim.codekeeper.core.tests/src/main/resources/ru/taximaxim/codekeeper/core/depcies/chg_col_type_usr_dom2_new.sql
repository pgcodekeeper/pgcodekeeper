CREATE DOMAIN public.dom2 AS integer
	CONSTRAINT chechk1 CHECK ((VALUE > 0));

ALTER DOMAIN public.dom2 OWNER TO botov_av;