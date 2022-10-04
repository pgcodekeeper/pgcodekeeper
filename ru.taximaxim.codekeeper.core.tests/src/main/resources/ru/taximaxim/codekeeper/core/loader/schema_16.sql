CREATE TABLE public."t_work" (id integer);

CREATE TABLE public."t_chart" (id integer);

CREATE OR REPLACE VIEW public.v_subselect AS
	SELECT c.id, t.id FROM ( SELECT t_work.id FROM public.t_work) t JOIN public.t_chart c ON t.id = c.id;
