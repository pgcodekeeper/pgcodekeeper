CREATE TABLE public.t1 (
    c1 integer
);

ALTER TABLE public.t1 OWNER TO galiev_mr;

CREATE RULE notify_me AS
    ON UPDATE TO public.t1 DO  NOTIFY t1;