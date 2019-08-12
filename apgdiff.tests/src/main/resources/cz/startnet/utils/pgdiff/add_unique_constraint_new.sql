CREATE TABLE public.inventoryitemsupplier (
    id integer NOT NULL,
    code character varying(20) NOT NULL,
    partneridentificationid integer NOT NULL,
    inventoryitemid integer NOT NULL,
    createdbyuserid smallint NOT NULL,
    datecreated timestamp without time zone NOT NULL,
    datedeleted timestamp without time zone,
    datelastmodified timestamp without time zone,
    deletedbyuserid smallint,
    lastmodifiedbyuserid smallint
);

ALTER TABLE ONLY public.inventoryitemsupplier
    ADD CONSTRAINT inventoryitemsupplier_5a808b9c_key UNIQUE (inventoryitemid, partneridentificationid);

ALTER TABLE ONLY public.inventoryitemsupplier
    ADD CONSTRAINT inventoryitemsupplier_pkey PRIMARY KEY (id);
