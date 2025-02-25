SET search_path = pg_catalog;

ALTER TABLE public.order_book DISABLE TRIGGER swt_pk_order_book1;

ALTER TABLE public.order_book DISABLE TRIGGER swt_pk_order_book2;

ALTER TABLE public.order_book_p1703 ENABLE TRIGGER swt_pk_order_book2;

ALTER TABLE public.order_book_p1703 ENABLE TRIGGER swt_pk_order_book1;

ALTER TABLE public.order_book_p1704 ENABLE TRIGGER swt_pk_order_book1;

ALTER TABLE public.order_book_pmax ENABLE TRIGGER swt_pk_order_book2;