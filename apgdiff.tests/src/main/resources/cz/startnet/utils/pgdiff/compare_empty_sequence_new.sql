CREATE SEQUENCE public.my_seq
    INCREMENT BY 1
    NO MAXVALUE 
    NO MINVALUE 
    NO CYCLE;

ALTER SEQUENCE public.my_seq OWNER TO galiev_mr;
