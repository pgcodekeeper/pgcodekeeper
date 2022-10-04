CREATE TABLE public.user_data (
    id bigint NOT NULL,
    email character varying(128) NOT NULL,
    created timestamp with time zone DEFAULT now()
);

ALTER TABLE public.user_data OWNER TO postgres;

CREATE SEQUENCE public.user_id_seq
    INCREMENT BY 1
    NO MAXVALUE
    NO MINVALUE
    CACHE 1;

ALTER TABLE public.user_id_seq OWNER TO postgres;

ALTER SEQUENCE public.user_id_seq OWNED BY public.user_data.id;

ALTER TABLE public.user_data ALTER COLUMN id SET DEFAULT nextval('public.user_id_seq'::regclass);

CREATE VIEW public."user" AS
    (       SELECT 
                user_data.id, 
                user_data.email, 
                user_data.created 
            FROM 
                public.user_data);

ALTER TABLE public."user" OWNER TO postgres;
ALTER VIEW public."user" OWNER TO postgres;

--ALTER TABLE "user" ALTER COLUMN created SET DEFAULT now();
ALTER VIEW public."user" ALTER COLUMN created SET DEFAULT now();


CREATE VIEW public.ws_test AS 

SELECT
ud.id
"   i   d   "
FROM public.user_data ud;

CREATE TABLE public.t1(c1 int);

CREATE RULE on_delete AS ON DELETE TO public."user" DO ALSO DELETE FROM public.user_data WHERE (user_data.id = old.id);
CREATE RULE on_insert AS ON INSERT TO public."user" DO INSTEAD (INSERT INTO public.user_data (id, email, created) VALUES (new.id, new.email, new.created); INSERT INTO public.t1(c1) DEFAULT VALUES);
CREATE RULE on_update AS ON UPDATE TO public."user" DO INSTEAD (UPDATE public.user_data SET id = new.id, email = new.email, created = new.created WHERE (user_data.id = old.id));
CREATE RULE on_select AS ON SELECT TO public.user_data WHERE (1=1) DO INSTEAD NOTHING;