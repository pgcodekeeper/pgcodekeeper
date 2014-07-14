CREATE TABLE "t_work" (id integer);

CREATE TABLE "t_chart" (id integer);

CREATE TABLE "t_memo" (name text);

CREATE OR REPLACE VIEW v_subselect AS
	SELECT c.id, t.id, t.name FROM  ( SELECT w.id, m.name FROM (SELECT t_work.id FROM t_work) w JOIN t_memo m )  t JOIN t_chart c ON t.id = c.id;
