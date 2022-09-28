CREATE TABLE public.trigtest (
    i integer DEFAULT nextval('public.trigtest_i_seq'::regclass) NOT NULL
);

ALTER TABLE public.trigtest OWNER TO khazieva_gr;

CREATE TRIGGER trigtest_b_row_tg
    BEFORE INSERT OR UPDATE OR DELETE ON public.trigtest
    FOR EACH ROW
    EXECUTE PROCEDURE public.trigtest();
    
ALTER TABLE public.trigtest DISABLE TRIGGER trigtest_b_row_tg;

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

ALTER TABLE public.trigtest ENABLE TRIGGER ALL;

ALTER TABLE public.trigtest ENABLE TRIGGER USER;