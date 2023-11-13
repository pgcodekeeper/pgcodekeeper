CREATE TABLE public.test_t1 (
    id bigint NOT NULL PRIMARY KEY WITH (fillfactor = '10'),
    col2 text,
    col3 bigint
);

ALTER TABLE public.test_t1 OWNER TO shamsutdinov_er;

CREATE TABLE public.test_fk_1 (
    col1 bigint REFERENCES public.test_t1(id) ON UPDATE CASCADE ON DELETE SET NULL,
    col2 text
);

ALTER TABLE public.test_fk_1 OWNER TO shamsutdinov_er;