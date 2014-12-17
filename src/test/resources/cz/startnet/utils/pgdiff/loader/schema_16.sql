CREATE TABLE "t_work" (id integer);

CREATE TABLE "t_chart" (id integer);

CREATE OR REPLACE VIEW v_subselect AS
	SELECT c.id, t.id FROM ( SELECT t_work.id FROM t_work) t JOIN t_chart c ON t.id = c.id;
