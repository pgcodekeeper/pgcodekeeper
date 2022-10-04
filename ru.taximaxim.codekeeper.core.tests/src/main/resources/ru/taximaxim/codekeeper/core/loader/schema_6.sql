CREATE TABLE public.test_table (
    id bigint,
    date_deleted timestamp without time zone
);

ALTER TABLE public.test_table OWNER TO postgres;

CREATE INDEX test_table_deleted ON public.test_table USING btree (date_deleted) WHERE (date_deleted IS NULL);

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;