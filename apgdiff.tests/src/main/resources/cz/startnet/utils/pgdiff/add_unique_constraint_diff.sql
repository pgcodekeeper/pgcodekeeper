SET search_path = pg_catalog;

ALTER SEQUENCE public.inventoryitemsupplier_seq
	RESTART WITH 1;

ALTER TABLE public.inventoryitemsupplier
	ADD CONSTRAINT inventoryitemsupplier_5a808b9c_key UNIQUE (inventoryitemid, partneridentificationid);

ALTER TABLE public.inventoryitemsupplier
	ADD CONSTRAINT inventoryitemsupplier_pkey PRIMARY KEY (id);