CREATE DOMAIN public.dom5 AS integer NOT NULL
	CONSTRAINT dom5_check CHECK ((VALUE <> 0));