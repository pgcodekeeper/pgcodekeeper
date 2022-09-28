CREATE TABLE public.table1 (id text);
 
 ALTER TABLE public.table1
    ADD CONSTRAINT costr CHECK (id > 0);

-------------------------------------------

CREATE TABLE public.table2 (id text);
 
 ALTER TABLE public.table2
    ADD CONSTRAINT costr UNIQUE (id);

-------------------------------------------

CREATE TABLE public.table3 (id text);

 ALTER TABLE public.table3
    ADD CONSTRAINT costr FOREIGN KEY (id) REFERENCES public.table2;
    
-------------------------------------------
CREATE TABLE public.table4 (id text);   
 
ALTER TABLE public.table4
    ADD CONSTRAINT costr PRIMARY KEY(id);
    
-------------------------------------------
CREATE TABLE public.table5 PARTITION OF public.rrr (id) DEFAULT;

ALTER TABLE public.table5
    ADD CONSTRAINT costr CHECK (id > 0);