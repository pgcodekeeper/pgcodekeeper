CREATE DOMAIN public.dom AS integer NOT NULL DEFAULT (-1)
    CONSTRAINT dom_check1 CHECK ((VALUE <> 1));

CREATE DOMAIN public.dom2 AS integer NOT NULL DEFAULT (-1)
    CONSTRAINT dom2_check1 CHECK ((VALUE > -1));

CREATE DOMAIN public.dom3 AS integer NOT NULL DEFAULT (-1)
    CONSTRAINT dom3_check1 CHECK ((VALUE != 0))
    CONSTRAINT dom3_check2 CHECK ((VALUE < 5));

COMMENT ON CONSTRAINT dom3_check1 ON DOMAIN public.dom3 IS 'dom3 comment';