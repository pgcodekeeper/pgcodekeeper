SET search_path = pg_catalog;

CREATE TABLE public.order_book (
	id_iss bigint NOT NULL,
	id_feed smallint,
	dt timestamp without time zone NOT NULL,
	id_order smallint NOT NULL,
	gask numeric(25,8)
)
PARTITION BY RANGE (dt);

CREATE TABLE public.order_book_p1702 PARTITION OF public.order_book
FOR VALUES FROM (MINVALUE) TO ('2017-02-01 00:00:00');

CREATE TABLE public.order_book_p1703 PARTITION OF public.order_book
FOR VALUES FROM ('2017-02-01 00:00:00') TO ('2017-03-01 00:00:00');

CREATE TABLE public.order_book_p1704 PARTITION OF public.order_book
FOR VALUES FROM ('2017-03-01 00:00:00') TO ('2017-04-01 00:00:00');

CREATE TABLE public.order_book_pmax PARTITION OF public.order_book
FOR VALUES FROM ('2017-04-01 00:00:00') TO (MAXVALUE);

ALTER TABLE public.order_book
	ADD CONSTRAINT pk_order_book PRIMARY KEY (id_iss, dt, id_order);

CREATE TRIGGER swt_pk_order_book1
	BEFORE INSERT OR UPDATE ON public.order_book
	FOR EACH ROW
	EXECUTE PROCEDURE public.swf_pk_order_book();

CREATE TRIGGER swt_pk_order_book2
	BEFORE INSERT OR UPDATE ON public.order_book
	FOR EACH ROW
	EXECUTE PROCEDURE public.swf_pk_order_book();