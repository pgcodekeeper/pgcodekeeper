-- DISTRIBUTED

--change on DISTRIBUTED REPLICATED
create table public.ao1
(col1 varchar(2), col2 int) DISTRIBUTED REPLICATED;

--added timest and public.op_class on DISTRIBUTED + REORGANIZE
create table public.testbug_char5_exchange
(timest character varying(6), user_id numeric(16,0) NOT NULL, tag1 char(5), tag2 char(5))
DISTRIBUTED BY (user_id public.op_class, timest);

--dropped DISTRIBUTED
create table public.t_reorganize_false
(col1 varchar(2), col2 int);

--added cols in DISTRIBUTED
CREATE TABLE public.distpol_person (
  name      text,
  age       int4,
  location  point
) DISTRIBUTED BY (name, age public.op_class, location public.op_class_2);

--no change
create table public.t1
(col1 varchar(2), col2 int) DISTRIBUTED BY (col1);

--change the same hash distribution policy
create table public.t2
(col1 varchar(2), col2 int) DISTRIBUTED randomly;

--change on default DISTRIBUTED (without DISTRIBUTED clause)
CREATE TABLE public.sales1 (
    txn_id integer,
    qty integer,
    date date
);

--change on default DISTRIBUTED (when we have 1 primary key)
CREATE TABLE public.sales5 (
    txn_id integer PRIMARY KEY,
    qty integer,
    date date
);

--change on default DISTRIBUTED (when we have user-defined 1 column)
CREATE TABLE public.sales3 (
    txn_id public.test_int,
    qty integer,
    date date
);

--change on default DISTRIBUTED (when we have 2 primary key)
CREATE TABLE public.sales2 (
    txn_id integer,
    qty integer,
    date date
);

ALTER TABLE public.sales2
    ADD CONSTRAINT pk_sales2 PRIMARY KEY (txn_id, qty);

--change compresstype
CREATE TABLE public.t4()
WITH (appendonly=true, compresstype=zlib);

--change fillfactor
CREATE TABLE public.t5()
WITH (appendonly=true, compresstype=zlib, fillfactor=50);