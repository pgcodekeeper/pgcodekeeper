CREATE FUNCTION public.multiply_numbers(number2 integer, number1 integer) RETURNS integer
    AS $$
begin
        return number2 * number1;
end;
$$
    LANGUAGE plpgsql;

ALTER FUNCTION public.multiply_numbers(number2 integer, number1 integer) OWNER TO fordfrog;

CREATE TABLE public.test_table (
    id serial NOT NULL
);

ALTER TABLE public.test_table OWNER TO fordfrog;

ALTER TABLE ONLY public.test_table
    ADD CONSTRAINT test_table_pkey PRIMARY KEY (id);