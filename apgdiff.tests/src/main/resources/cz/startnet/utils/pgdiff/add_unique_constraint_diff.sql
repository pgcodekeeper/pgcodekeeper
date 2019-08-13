SET search_path = pg_catalog;

ALTER TABLE public.inventoryitemsupplier
	ADD CONSTRAINT inventoryitemsupplier_5a808b9c_key UNIQUE (inventoryitemid, partneridentificationid);

ALTER TABLE public.inventoryitemsupplier
	ADD CONSTRAINT inventoryitemsupplier_pkey PRIMARY KEY (id);