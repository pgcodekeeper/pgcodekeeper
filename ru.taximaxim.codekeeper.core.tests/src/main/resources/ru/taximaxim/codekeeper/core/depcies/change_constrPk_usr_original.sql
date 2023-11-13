CREATE TABLE public.test_t1 (
    id bigint NOT NULL PRIMARY KEY,
    col2 text,
    col3 bigint
);

ALTER TABLE public.test_t1 OWNER TO shamsutdinov_er;
