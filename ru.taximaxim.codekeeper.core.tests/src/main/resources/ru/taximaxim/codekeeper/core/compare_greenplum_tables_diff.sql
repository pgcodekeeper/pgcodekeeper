SET search_path = pg_catalog;

DROP TABLE public.t4;

ALTER TABLE public.t5 SET (fillfactor=50);

ALTER TABLE public.sales5
	ALTER COLUMN txn_id SET NOT NULL;

ALTER TABLE public.sales5
	ADD CONSTRAINT sales5_pkey PRIMARY KEY (txn_id);

ALTER TABLE public.sales2
	ADD CONSTRAINT pk_sales2 PRIMARY KEY (txn_id, qty);

CREATE TABLE public.t4 (
)
WITH (appendonly=true, compresstype=zlib);

ALTER TABLE public.ao1 SET DISTRIBUTED REPLICATED;

ALTER TABLE public.testbug_char5_exchange SET WITH (REORGANIZE=true) DISTRIBUTED BY (user_id public.op_class, timest);

ALTER TABLE public.t_reorganize_false SET DISTRIBUTED BY (col1);

ALTER TABLE public.distpol_person SET WITH (REORGANIZE=true) DISTRIBUTED BY (name, age public.op_class, location public.op_class_2);

ALTER TABLE public.t2 SET WITH (REORGANIZE=true) DISTRIBUTED RANDOMLY;

ALTER TABLE public.sales1 SET DISTRIBUTED BY (txn_id);

ALTER TABLE public.sales5 SET DISTRIBUTED BY (txn_id);

ALTER TABLE public.sales3 SET WITH (REORGANIZE=true) DISTRIBUTED BY (qty);

ALTER TABLE public.sales2 SET WITH (REORGANIZE=true) DISTRIBUTED BY (txn_id, qty);
