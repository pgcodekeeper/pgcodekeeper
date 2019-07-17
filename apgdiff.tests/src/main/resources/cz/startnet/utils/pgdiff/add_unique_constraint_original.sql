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