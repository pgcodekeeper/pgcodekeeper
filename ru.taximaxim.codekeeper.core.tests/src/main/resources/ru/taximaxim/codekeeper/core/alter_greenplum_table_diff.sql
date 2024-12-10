START TRANSACTION;

SET search_path = pg_catalog;

ALTER TABLE ONLY public.test2
	DROP COLUMN col2;

ALTER TABLE public.test1
	ADD COLUMN col2 integer;

ALTER TABLE public.test1 SET WITH (REORGANIZE=true) DISTRIBUTED BY (col2);

ALTER TABLE public.test2 SET WITH (REORGANIZE=true) DISTRIBUTED BY (col1);

COMMIT TRANSACTION;
