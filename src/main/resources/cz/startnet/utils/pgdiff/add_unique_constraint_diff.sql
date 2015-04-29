ALTER SEQUENCE inventoryitemsupplier_seq
	RESTART WITH 1;

ALTER TABLE inventoryitemsupplier
	ADD CONSTRAINT inventoryitemsupplier_pkey PRIMARY KEY (id);

ALTER TABLE inventoryitemsupplier
	ADD CONSTRAINT inventoryitemsupplier_5a808b9c_key UNIQUE (inventoryitemid, partneridentificationid);
