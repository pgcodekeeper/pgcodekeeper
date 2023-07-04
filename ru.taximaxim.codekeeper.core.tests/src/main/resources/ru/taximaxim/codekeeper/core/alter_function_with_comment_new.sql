CREATE OR REPLACE FUNCTION public.functest1(a int, b int) LANGUAGE SQL AS 'SELECT $2';

ALTER FUNCTION public.functest1(a int, b int) OWNER TO test_2;

COMMENT ON FUNCTION public.functest1(a int, b int) IS 'test function 2';