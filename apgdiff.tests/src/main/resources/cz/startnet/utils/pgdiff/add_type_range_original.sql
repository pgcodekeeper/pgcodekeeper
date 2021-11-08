CREATE TYPE public.textrange333 AS RANGE (
    subtype = text,
    collation = pg_catalog."C",
    multirange_type_name = public.multirange_of_text
);

ALTER TYPE public.textrange333 OWNER TO khazieva_gr;

CREATE TYPE public.textrange111 AS RANGE (
    subtype = text,
    collation = pg_catalog."C",
    multirange_type_name = public.multirange_of_text2
);

ALTER TYPE public.textrange111 OWNER TO khazieva_gr;