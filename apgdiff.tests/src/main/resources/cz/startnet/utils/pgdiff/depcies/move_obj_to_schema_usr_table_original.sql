CREATE TABLE public.emp (
    id integer NOT NULL,
    empname text,
    salary integer,
    last_date timestamp without time zone,
    last_user text,
    code public.user_code
);

ALTER TABLE public.emp OWNER TO galiev_mr;
