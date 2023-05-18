-- DISTRIBUTED
create table public.ao1
(col1 varchar(2), col2 int) DISTRIBUTED randomly;

create table public.testbug_char5_exchange
(timest character varying(6), user_id numeric(16,0) NOT NULL, tag1 char(5), tag2 char(5))
DISTRIBUTED BY (user_id);

create table public.t_reorganize_false
(col1 varchar(2), col2 int) DISTRIBUTED REPLICATED;

CREATE TABLE public.distpol_person (
  name      text,
  age       int4,
  location  point
) DISTRIBUTED BY (name);

create table public.t1
(col1 varchar(2), col2 int) DISTRIBUTED BY (col1);

create table public.t2
(col1 varchar(2), col2 int) DISTRIBUTED BY (col1);

CREATE TABLE public.sales1 (
    txn_id integer,
    qty integer,
    date date
)
DISTRIBUTED RANDOMLY;

--change on default DISTRIBUTED (when have primary key)
CREATE TABLE public.sales5 (
    txn_id integer,
    qty integer,
    date date
)
DISTRIBUTED RANDOMLY;

CREATE TABLE public.sales3 (
    txn_id public.test_int,
    qty integer,
    date date
)
DISTRIBUTED BY (qty);

CREATE TABLE public.sales2 (
    txn_id integer,
    qty integer,
    date date
)
DISTRIBUTED BY (qty);

CREATE TABLE public.t4()
WITH (appendonly=true, compresstype=none);

CREATE TABLE public.t5()
WITH (appendonly=true, compresstype=zlib, fillfactor=10);