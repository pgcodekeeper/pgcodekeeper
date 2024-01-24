SET search_path = pg_catalog;

CREATE TABLE public."Table1" (
	id integer NOT NULL
);

CREATE TABLE public."Table2" (
	id integer NOT NULL,
	"Table1_id" integer
);

ALTER TABLE public."Table1"
	ADD CONSTRAINT table1_pkey PRIMARY KEY (id);

ALTER TABLE public."Table2"
	ADD CONSTRAINT table2_pkey PRIMARY KEY (id);

ALTER TABLE public."Table2"
	ADD CONSTRAINT "Table2_Table1_id_fkey" FOREIGN KEY ("Table1_id") REFERENCES public."Table1"(id) ON UPDATE CASCADE ON DELETE CASCADE;