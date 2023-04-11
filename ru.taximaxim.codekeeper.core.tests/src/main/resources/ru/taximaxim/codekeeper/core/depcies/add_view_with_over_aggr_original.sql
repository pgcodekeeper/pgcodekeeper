CREATE TABLE public.bug_table21 (
    link uuid NOT NULL,
    col1 boolean,
    col2 integer,
    f_network_pts_types smallint NOT NULL
);

ALTER TABLE public.bug_table21
    ADD CONSTRAINT bug_table21_pkey PRIMARY KEY (link);
