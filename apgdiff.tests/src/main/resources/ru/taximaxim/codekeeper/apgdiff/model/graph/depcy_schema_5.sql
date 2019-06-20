CREATE SCHEMA republic;

ALTER SCHEMA republic OWNER TO botov_av;

CREATE TABLE public.t_test2 (
    c_name_t_test2 text,
    c_id_t_test2 text
);

ALTER TABLE public.t_test2 OWNER TO botov_av;

ALTER TABLE ONLY public.t_test2
    ADD CONSTRAINT unique_referenced UNIQUE (c_name_t_test2);