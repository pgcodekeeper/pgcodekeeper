CREATE DOMAIN public.dom5 AS integer NOT NULL
	CONSTRAINT dom5_check CHECK ((VALUE <> 0))
	CONSTRAINT dom5_check1 CHECK ((VALUE <> (-1)))
	CONSTRAINT dom5_check2 CHECK ((VALUE <> 1));