	--view
CREATE VIEW public.test_view AS
    SELECT 1 AS column1;

    --rule
CREATE TABLE public.table3 (
    id bigint
);

CREATE RULE name AS
    ON UPDATE TO public.table3 DO  NOTIFY table3;

    CREATE TABLE public.table2 (
    id bigint
);

--trigger
CREATE TRIGGER name
    BEFORE UPDATE ON public.table2
    FOR EACH STATEMENT
    EXECUTE PROCEDURE public.fun3();

    --function
CREATE OR REPLACE FUNCTION public.f1(a text = NULL::text, c text = NULL::text[], VARIADIC c text[] = NULL::text[]) RETURNS text
    LANGUAGE plpgsql
    AS $$
begin
end;
$$;

ALTER FUNCTION public.f1(a text, c text, VARIADIC c text[]) OWNER TO khazieva_gr;

    --constraint
CREATE TABLE public.table5 (
    id bigint,
    id2 bigint
);

ALTER TABLE public.table5
    ADD CONSTRAINT table5e_pkey PRIMARY KEY (id2);

 --server
 CREATE SERVER test_server_3 FOREIGN DATA WRAPPER test_fdw11;

ALTER SERVER test_server_3 OWNER TO khazieva_gr;

--added drop before create table
CREATE TABLE public.rrr (
    idd bigint
);

--added new view
CREATE VIEW public.test_view3 AS
    SELECT 2 AS column1;