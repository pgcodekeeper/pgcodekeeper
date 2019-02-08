CREATE SCHEMA republic;

ALTER SCHEMA republic OWNER TO botov_av;

CREATE TABLE public.t_test2 (
    c_name_t_test2 text,
    c_id_t_test2 text
);

ALTER TABLE public.t_test2 OWNER TO botov_av;

CREATE TABLE republic.t_test2foreign (
    column_referencing text,
    column_referencing2 character(1)[]
);

ALTER TABLE republic.t_test2foreign OWNER TO botov_av;

ALTER TABLE ONLY public.t_test2
    ADD CONSTRAINT unique_referenced UNIQUE (c_name_t_test2);

ALTER TABLE ONLY republic.t_test2foreign
    ADD CONSTRAINT fk_t_test2foreign FOREIGN KEY (column_referencing) REFERENCES public.t_test2(c_name_T_test2);
