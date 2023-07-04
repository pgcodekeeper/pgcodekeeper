CREATE OR REPLACE FUNCTION public.functest1(a int, b int) LANGUAGE SQL AS 'SELECT $1';

ALTER FUNCTION public.functest1(a int, b int) OWNER TO test;

COMMENT ON FUNCTION public.functest1(a int, b int) IS 'test function';