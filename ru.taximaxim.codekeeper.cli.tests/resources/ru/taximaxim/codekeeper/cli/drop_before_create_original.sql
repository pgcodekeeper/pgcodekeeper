	--view
CREATE VIEW public.test_view AS
    SELECT 2 AS column1;

    --rule
CREATE TABLE public.table3 ( id bigint
);

CREATE RULE name AS
    ON UPDATE TO public.table3 DO NOTHING;

    --trigger
CREATE TABLE public.table2 (
    id bigint
);

ALTER TABLE public.table2 OWNER TO khazieva_gr;


CREATE TRIGGER name
    BEFORE UPDATE ON public.table2
    FOR EACH STATEMENT
    EXECUTE PROCEDURE public.fun4();

    --function
CREATE OR REPLACE FUNCTION public.f1(a text = NULL::text, b text = NULL::text[], VARIADIC c text[] = NULL::text[]) RETURNS text
    LANGUAGE plpgsql
    AS $$
begin
end;
$$;

ALTER FUNCTION public.f1(a text, b text, VARIADIC c text[]) OWNER TO khazieva_gr;

    --constraint
CREATE TABLE public.table5 (
    id bigint NOT NULL,
    id2 bigint
);

ALTER TABLE public.table5 OWNER TO khazieva_gr;

ALTER TABLE public.table5
    ADD CONSTRAINT table5e_pkey PRIMARY KEY (id);

 --server
CREATE SERVER test_server_3 FOREIGN DATA WRAPPER test_fdw_0;

ALTER SERVER test_server_3 OWNER TO khazieva_gr;

