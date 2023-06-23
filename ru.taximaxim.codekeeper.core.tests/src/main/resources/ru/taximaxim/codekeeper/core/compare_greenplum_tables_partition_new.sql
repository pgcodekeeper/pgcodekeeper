--change only one templates
CREATE TABLE public.rank1 (
    id integer,
    rank integer,
    year date,
    gender character(1)
)
DISTRIBUTED BY (id, gender, year)
PARTITION BY LIST(gender)
          SUBPARTITION BY RANGE(year)
                  SUBPARTITION BY RANGE(rank) 
          (
          PARTITION boys VALUES('M')
                  (
                  START ('2001-01-01'::date) END ('2002-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2002-01-01'::date) END ('2003-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2003-01-01'::date) END ('2004-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2004-01-01'::date) END ('2005-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2005-01-01'::date)
                          (
                          START (1)
                          )
                  ), 
          PARTITION girls VALUES('F')
                  (
                  START ('2001-01-01'::date) END ('2002-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2002-01-01'::date) END ('2003-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2003-01-01'::date) END ('2004-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2004-01-01'::date) END ('2005-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2005-01-01'::date)
                          (
                          START (1)
                          )
                  )
          );

ALTER TABLE public.rank1
ALTER PARTITION boys 
SET SUBPARTITION TEMPLATE 
          (
          START (1)
          );

ALTER TABLE public.rank1
SET SUBPARTITION TEMPLATE 
          (
          START ('2001-01-01'::date) END ('2002-01-01'::date) , 
          START ('2002-01-01'::date) END ('2003-01-01'::date) , 
          START ('2003-01-01'::date) END ('2004-01-01'::date) , 
          START ('2004-01-03'::date) END ('2005-01-01'::date) , 
          START ('2005-01-01'::date)
          );

ALTER TABLE public.rank1 OWNER TO khazieva_gr;

-------------------------------------------------------------------------------
-- change 2 templates
CREATE TABLE public.ataprank (
    id integer,
    rank integer,
    year date,
    gender character(1),
    usstate character(2)
)
DISTRIBUTED BY (id, gender, year, usstate)
PARTITION BY LIST(gender)
          SUBPARTITION BY RANGE(year)
                  SUBPARTITION BY LIST(usstate) 
          (
          PARTITION boys VALUES('M')
                  (
                  SUBPARTITION jan01 START ('2001-01-01'::date) END ('2002-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan02 START ('2002-01-01'::date) END ('2003-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan03 START ('2003-01-01'::date) END ('2004-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan04 START ('2004-01-01'::date) END ('2005-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan05 START ('2005-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          )
                  ), 
          PARTITION girls VALUES('F')
                  (
                  SUBPARTITION jan01 START ('2001-01-01'::date) END ('2002-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan02 START ('2002-01-01'::date) END ('2003-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan03 START ('2003-01-01'::date) END ('2004-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan04 START ('2004-01-01'::date) END ('2005-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          ), 
                  SUBPARTITION jan05 START ('2005-01-01'::date)
                          (
                          SUBPARTITION mass VALUES('MA'), 
                          SUBPARTITION cali VALUES('CA'), 
                          SUBPARTITION ohio VALUES('OH')
                          )
                  )
          );

ALTER TABLE public.ataprank
SET SUBPARTITION TEMPLATE 
          (
          SUBPARTITION mass VALUES('MA'), 
          SUBPARTITION cali VALUES('GH'), 
          SUBPARTITION ohio VALUES('OH')
          );

ALTER TABLE public.ataprank OWNER TO khazieva_gr;

-----------------------------------------------------
--change template order
CREATE TABLE public.rank2 (
    id integer,
    rank integer,
    year date,
    gender character(1)
)
DISTRIBUTED BY (id, gender, year)
PARTITION BY LIST(gender)
          SUBPARTITION BY RANGE(year)
                  SUBPARTITION BY RANGE(rank) 
          (
          PARTITION boys VALUES('M')
                  (
                  START ('2001-01-01'::date) END ('2002-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2002-01-01'::date) END ('2003-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2005-01-01'::date)
                          (
                          START (1)
                          )
                  ), 
          PARTITION girls VALUES('F')
                  (
                  START ('2001-01-01'::date) END ('2002-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2002-01-01'::date) END ('2003-01-01'::date)
                          (
                          START (1)
                          ), 
                  START ('2005-01-01'::date)
                          (
                          START (1)
                          )
                  )
          );

ALTER TABLE public.rank2
SET SUBPARTITION TEMPLATE 
          (
          START ('2001-01-01'::date) END ('2002-01-01'::date) , 
          START ('2002-01-01'::date) END ('2003-01-01'::date) , 
          START ('2005-01-01'::date)
          );

ALTER TABLE public.rank2
ALTER PARTITION boys 
SET SUBPARTITION TEMPLATE 
          (
          START (1)
          );

ALTER TABLE public.rank2 OWNER TO khazieva_gr;

----------------------------------------------------
--change partition name
CREATE TABLE public.p3_sales (
    id integer,
    year integer,
    month integer,
    day integer,
    region text
)
DISTRIBUTED BY (id)
PARTITION BY RANGE(year)
          SUBPARTITION BY RANGE(month)
                  SUBPARTITION BY LIST(region) 
          (
          START (2011) END (2012) EVERY (1)
                  (
                  START (1) END (13) EVERY (1)
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          ), 
                  DEFAULT SUBPARTITION other_months
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          )
                  ), 
          DEFAULT PARTITION outlying_years
                  (
                  START (1) END (13) EVERY (1)
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          ), 
                  DEFAULT SUBPARTITION other_months
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          )
                  )
          );

ALTER TABLE public.p3_sales ALTER PARTITION new_name
SET SUBPARTITION TEMPLATE (
 SUBPARTITION usa VALUES('usa'),
 SUBPARTITION europe VALUES('europe'),
 SUBPARTITION asia VALUES('asia'),
 DEFAULT SUBPARTITION other_regions 
);

ALTER TABLE public.p3_sales
SET SUBPARTITION TEMPLATE (
START (1) END (13) EVERY (13),
 DEFAULT SUBPARTITION other_months 
);

ALTER TABLE public.p3_sales OWNER TO shamsutdinov_er;
-----------------------------------------------------
--delete suppartition template
CREATE TABLE public.p4_sales (
    id integer,
    year integer,
    month integer,
    day integer,
    region text
)
DISTRIBUTED BY (id)
PARTITION BY RANGE(year)
          SUBPARTITION BY RANGE(month)
                  SUBPARTITION BY LIST(region) 
          (
          START (2011) END (2012) EVERY (1)
                  (
                  START (1) END (13) EVERY (1)
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          ), 
                  DEFAULT SUBPARTITION other_months
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          )
                  ), 
          DEFAULT PARTITION outlying_years
                  (
                  START (1) END (13) EVERY (1)
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          ), 
                  DEFAULT SUBPARTITION other_months
                          (
                          SUBPARTITION usa VALUES('usa'), 
                          SUBPARTITION europe VALUES('europe'), 
                          SUBPARTITION asia VALUES('asia'), 
                          DEFAULT SUBPARTITION other_regions
                          )
                  )
          );

ALTER TABLE public.p4_sales OWNER TO shamsutdinov_er;
