SET search_path = pg_catalog;

CREATE TABLE public.t1(c1 int, id int, email text, created timestamp);
CREATE TABLE public.user_data(id int, email text, created timestamp);

CREATE RULE on_delete AS ON DELETE TO public.t1 DO ALSO DELETE FROM public.user_data WHERE (user_data.id = old.id);
CREATE RULE on_insert AS ON INSERT TO public.t1 DO INSTEAD (INSERT INTO public.user_data (id, email, created) VALUES (new.id, new.email, new.created); INSERT INTO public.t1 DEFAULT VALUES);
CREATE RULE on_update AS ON UPDATE TO public.t1 DO INSTEAD (UPDATE public.user_data SET id = new.id, email = new.email, created = new.created WHERE (user_data.id = old.id));
CREATE RULE on_select AS ON SELECT TO public.t1 WHERE (1=1) DO INSTEAD NOTHING;