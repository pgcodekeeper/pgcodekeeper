CREATE TABLE public.fax_boxes (
  fax_box_id serial NOT NULL,
  name text,
  CONSTRAINT fax_boxes_pkey PRIMARY KEY (fax_box_id) INCLUDE (name)
);

ALTER TABLE public.fax_boxes OWNER TO postgres;

CREATE TABLE public.extensions (id serial NOT NULL);

ALTER TABLE public.extensions ADD CONSTRAINT extensions_fax_box_id_fkey FOREIGN KEY (id) REFERENCES public.fax_boxes
(fax_box_id)    ON UPDATE RESTRICT ON DELETE RESTRICT;              CREATE TABLE public.faxes (


  fax_id serial NOT NULL,
  fax_box_id int4,
  from_name text,
  from_number text,
  status int4, -- 1=pending, 2=failed, 3=received
  pages int4,
  time_received timestamp DEFAULT now(),
  time_finished_received timestamp,
  "read" int2 DEFAULT 0,
  station_id text,
  CONSTRAINT faxes_pkey PRIMARY KEY (fax_id),
  CONSTRAINT faxes_fax_box_id_fkey FOREIGN KEY (fax_box_id)
      REFERENCES public.fax_boxes MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE SET NULL (fax_box_id)
);
