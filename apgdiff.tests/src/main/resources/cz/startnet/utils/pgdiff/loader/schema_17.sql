CREATE TABLE public."t_work" (id integer);

CREATE TABLE public."t_chart" (id integer);

CREATE TABLE public."t_memo" (name text);

CREATE VIEW public.v_subselect AS
 SELECT c.id, t.id AS second, t.name
   FROM (( SELECT w.id, m.name FROM (( SELECT t_work.id FROM public.t_work) w
             JOIN public.t_memo m ON (((w.id)::text = m.name)))) t
     JOIN public.t_chart c ON ((t.id = c.id)));
