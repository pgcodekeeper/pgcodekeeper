CREATE SEQUENCE public.test_seq_1;
CREATE SEQUENCE public.test_seq_2 START WITH 2;
CREATE SEQUENCE public.test_seq_3 START WITH 2 INCREMENT BY 3;
CREATE SEQUENCE public.test_seq_4 START WITH 2 INCREMENT BY 3 MINVALUE -4;
CREATE SEQUENCE public.test_seq_5 START WITH 2 INCREMENT BY 3 MINVALUE -4 MAXVALUE 5;
CREATE SEQUENCE public.test_seq_6 START WITH 2 INCREMENT BY 3 MINVALUE -4 MAXVALUE 5 CACHE 1;
CREATE SEQUENCE public.test_seq_7 START WITH 2 INCREMENT BY 3 MINVALUE -4 MAXVALUE 5 CACHE 1 CYCLE;
CREATE SEQUENCE public.test_seq_8 INCREMENT BY -1;
CREATE SEQUENCE public.test_seq_9 MINVALUE 20;
CREATE SEQUENCE public.test_seq_10 MINVALUE -40 MAXVALUE -20;
CREATE SEQUENCE public.test_seq_11 MINVALUE -40 MAXVALUE 90;