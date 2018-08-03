SET search_path = pg_catalog;

CREATE TABLE public.t1 (c1 integer DEFAULT 11, c2 text DEFAULT 'qqqq'::text, c3 timestamp without time zone DEFAULT now());
CREATE TABLE public.user_data(id int, email text, created timestamp);