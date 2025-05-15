SET search_path = pg_catalog;

ALTER TABLE public.order_book ENABLE TRIGGER swt_pk_order_book1;

ALTER TABLE public.order_book ENABLE TRIGGER swt_pk_order_book2;

ALTER TABLE public.order_book_p1702 DISABLE TRIGGER swt_pk_order_book3;

ALTER TABLE public.order_book_p1703 DISABLE TRIGGER swt_pk_order_book3;

ALTER TABLE public.order_book_p1704 DISABLE TRIGGER swt_pk_order_book3;

ALTER TABLE public.order_book_pmax DISABLE TRIGGER swt_pk_order_book3;