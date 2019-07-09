CREATE TABLE public.measurement_year_month (
    logdate date NOT NULL,
    peaktemp integer,
    unitsales integer DEFAULT 5234
)
PARTITION BY RANGE (date_part('year'::text, logdate), date_part('month'::text, logdate));


CREATE TABLE public.measurement_ym_older PARTITION OF public.measurement_year_month
FOR VALUES FROM (MINVALUE, MINVALUE) TO ('2016', '11');

ALTER TABLE ONLY public.measurement_ym_older ALTER COLUMN unitsales SET DEFAULT 5234;


CREATE TABLE public.measurement_ym_y2016m11 PARTITION OF public.measurement_year_month
FOR VALUES FROM ('2016', '11') TO ('2016', '12');

ALTER TABLE ONLY public.measurement_ym_y2016m11 ALTER COLUMN unitsales SET DEFAULT 5234;


CREATE TABLE public.measurement_ym_y2016m12 PARTITION OF public.measurement_year_month
FOR VALUES FROM ('2016', '12') TO ('2017', '1');

ALTER TABLE ONLY public.measurement_ym_y2016m12 ALTER COLUMN unitsales SET DEFAULT 5234;


CREATE TABLE public.measurement_ym_y2017m01 PARTITION OF public.measurement_year_month
FOR VALUES FROM ('2017', '1') TO ('2017', '2');

ALTER TABLE ONLY public.measurement_ym_y2017m01 ALTER COLUMN unitsales SET DEFAULT 5234;
