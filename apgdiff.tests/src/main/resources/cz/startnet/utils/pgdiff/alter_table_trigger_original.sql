CREATE TABLE public.trigtest (
    i integer DEFAULT nextval('public.trigtest_i_seq'::regclass) NOT NULL
);

ALTER TABLE public.trigtest OWNER TO khazieva_gr;

CREATE TRIGGER trigtest_b_row_tg
    BEFORE INSERT OR UPDATE OR DELETE ON public.trigtest
    FOR EACH ROW
    EXECUTE PROCEDURE public.trigtest();

ALTER TABLE public.trigtest ENABLE TRIGGER trigtest_b_row_tg;
