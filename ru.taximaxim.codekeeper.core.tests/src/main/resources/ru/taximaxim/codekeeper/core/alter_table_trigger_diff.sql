SET search_path = pg_catalog;

CREATE TRIGGER trigtest_b_stmt_tg
	BEFORE INSERT OR UPDATE OR DELETE ON public.trigtest
	FOR EACH ROW
	EXECUTE PROCEDURE public.trigtest();

ALTER TABLE public.trigtest ENABLE ALWAYS TRIGGER trigtest_b_stmt_tg;

CREATE TRIGGER trigtest_c_stmt_tg
	BEFORE INSERT OR UPDATE OR DELETE ON public.trigtest
	FOR EACH ROW
	EXECUTE PROCEDURE public.trigtest();

ALTER TABLE public.trigtest ENABLE REPLICA TRIGGER trigtest_c_stmt_tg;

ALTER TABLE public.trigtest DISABLE TRIGGER trigtest_b_row_tg;