CREATE FUNCTION public.multiply_numbers(number1 integer, number2 integer) RETURNS integer
    AS $$
begin
	return number1 * number2;
end;
$$
    LANGUAGE plpgsql;


ALTER FUNCTION public.multiply_numbers(number1 integer, number2 integer) OWNER TO fordfrog;

CREATE TABLE public.test_table (
    id serial NOT NULL
);

ALTER TABLE public.test_table OWNER TO fordfrog;

ALTER TABLE ONLY public.test_table
    ADD CONSTRAINT test_table_pkey PRIMARY KEY (id);