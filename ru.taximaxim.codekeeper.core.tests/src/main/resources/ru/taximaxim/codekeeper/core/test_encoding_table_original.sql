-- here Unix line separator '\n'
CREATE TABLE public.test (
    id              integer NOT NULL GENERATED BY DEFAULT AS IDENTITY,
    id_task         integer NOT NULL,
    id_object       integer NOT NULL,
    col_type        smallint NOT NULL,
    col_type_name character varying(10) GENERATED ALWAYS AS (
CASE
    WHEN (col_type = 1) THEN 'Source'::text
    WHEN (col_type = 2) THEN 'Target'::text
    ELSE NULL::text
END) STORED,
    CONSTRAINT pk_test PRIMARY KEY (id),
    CONSTRAINT uq_test UNIQUE (id_task, id_object)     
);